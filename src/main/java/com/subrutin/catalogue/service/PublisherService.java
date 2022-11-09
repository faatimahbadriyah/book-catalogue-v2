package com.subrutin.catalogue.service;

import com.subrutin.catalogue.dto.PublisherCreateRequestDTO;
import com.subrutin.catalogue.dto.PublisherUpdateRequestDTO;

public interface PublisherService {
	
	public void createPublisher(PublisherCreateRequestDTO dto);
	
	public void updatePublisher(String publisherId, PublisherUpdateRequestDTO dto);

}
