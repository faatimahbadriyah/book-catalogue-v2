package com.subrutin.catalogue.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.subrutin.catalogue.dto.UserDetailResponseDTO;

public interface AppUserService extends UserDetailsService{
	
	public UserDetailResponseDTO findUserDetail();

}
