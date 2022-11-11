package com.subrutin.catalogue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrutin.catalogue.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	//method name convention
	//find+keyword
	public Optional<Author> findById(Long id);
	
	public Optional<Author> findBySecureId(String id);
	
	public List<Author> findBySecureIdIn(List<String> authorIdList);
	
	//sql select * from author a where a.id = id and deleted = false
	public Optional<Author> findByIdAndDeletedFalse(Long id);
	
	//sql select a from Author a where a.name like :authorName
	public List<Author> findByNameLike(String authorName);

}
