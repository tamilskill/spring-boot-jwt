package com.tamilskillhub.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tamilskillhub.model.User;
import com.tamilskillhub.repository.UserRespository;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRespository userRespository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRespository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User nout found with username: " + username));
		
		return UserDetailsImpl.build(user);
	}

}
