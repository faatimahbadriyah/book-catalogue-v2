package com.subrutin.catalogue.service;

import com.subrutin.catalogue.domain.Publisher;
import com.subrutin.catalogue.dto.PublisherCreateRequestDTO;
import com.subrutin.catalogue.dto.PublisherListResponseDTO;
import com.subrutin.catalogue.dto.PublisherUpdateRequestDTO;
import com.subrutin.catalogue.dto.ResultPageResponseDTO;

public interface PublisherService {
	
	public Publisher findPublisher(String publisherId);
	
	public void createPublisher(PublisherCreateRequestDTO dto);
	
	public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);
	
	public ResultPageResponseDTO<PublisherListResponseDTO> findPublisherList(Integer pages, Integer limit, String sortBy, String direction, String publisherName);

}
