package com.subrutin.catalogue.service.impl;

import org.springframework.stereotype.Service;

import com.subrutin.catalogue.domain.Publisher;
import com.subrutin.catalogue.dto.PublisherCreateRequestDTO;
import com.subrutin.catalogue.dto.PublisherUpdateRequestDTO;
import com.subrutin.catalogue.exception.BadRequestException;
import com.subrutin.catalogue.repository.PublisherRepository;
import com.subrutin.catalogue.service.PublisherService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublisherServiceImpl implements PublisherService{

	private final PublisherRepository publisherRepository;
	
	@Override
	public void createPublisher(PublisherCreateRequestDTO dto) {
		Publisher publisher = new Publisher();
		publisher.setName(dto.getPublisherName());
		publisher.setCompanyName(dto.getCompanyName());
		publisher.setAddress(dto.getAddress());
		
		publisherRepository.save(publisher);
	}

	@Override
	public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto) {
		Publisher publisher = publisherRepository.findBySecureId(publisherId).orElseThrow(()->new BadRequestException("invalid.publisher_id"));	
		publisher.setName(dto.getPublisherName() == null || dto.getPublisherName().isBlank() ? publisher.getName() : dto.getPublisherName());	
		publisher.setCompanyName(dto.getCompanyName() == null || dto.getCompanyName().isBlank() ? publisher.getCompanyName() : dto.getCompanyName());	
		publisher.setAddress(dto.getAddress());
		
		publisherRepository.save(publisher);
	}

}
