package com.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.service.serviceInterface.TestService;

@Service("mtest")
public class TestServiceImpl implements TestService{

	@Override
	public void mprint() {
	}

}
