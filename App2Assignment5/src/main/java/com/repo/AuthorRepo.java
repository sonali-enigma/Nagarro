package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Author;

public interface AuthorRepo extends JpaRepository<Author, String> {

}
