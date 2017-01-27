package com.example.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.exception.RssException;
import com.example.rss.ObjectFactory;
import com.example.rss.TRss;
import com.example.rss.TRssChannel;
import com.example.rss.TRssItem;
import com.sun.jmx.remote.internal.Unmarshal;

@Service
public class RssService {
	public List<Item> getItems(Source source) throws RssException{
		ArrayList<Item> list=new ArrayList<Item>();
		try {
		JAXBContext jaxbContext=	JAXBContext.newInstance(ObjectFactory.class);
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source,TRss.class);
			TRss rss = jaxbElement.getValue();
			
			List<TRssChannel> channels = rss.getChannel();
			
			for (TRssChannel channel : channels) {
				List<TRssItem> items = channel.getItem();
				
				for (TRssItem rssItem : items) {
					Item item=new Item();
					item.setTitle(rssItem.getTitle());
					item.setDescripton(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					
					Date pubDate = new SimpleDateFormat("EEE, dd MM yyyy HH:mm:ss Z",Locale.ENGLISH).parse(rssItem.getPubDate());
					item.setPublishedDate(pubDate);
					list.add(item);
				}
			}
		} catch (JAXBException e) {
			throw new RssException(e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new RssException(e);
		}
		return list;
	}
}
