package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Blog;
import com.example.entity.Item;

public interface ItemDao extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog,Pageable pageable);

}
