package com.subrutin.catalogue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.catalogue.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	//method name convention
	//find+keyword
	
	//sql select * from author a where a.id = authorId
	public Optional<Author> findById(Long id);
	
	//sql select a from Author a where a.name like :authorName
	public List<Author> findByNameLike(String authorName);

}