package com.subrutin.catalogue.service.impl;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.subrutin.catalogue.dto.UserDetailResponseDTO;
import com.subrutin.catalogue.repository.AppUserRepository;
import com.subrutin.catalogue.service.AppUserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AppUserServiceImpl implements AppUserService{
	
	private final AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return appUserRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("invalid username"));
	}

	@Override
	public UserDetailResponseDTO findUserDetail() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		UserDetailResponseDTO dto = new UserDetailResponseDTO();
		String username = ctx.getAuthentication().getName();
		dto.setUsername(username);
		return dto;
	}

}
