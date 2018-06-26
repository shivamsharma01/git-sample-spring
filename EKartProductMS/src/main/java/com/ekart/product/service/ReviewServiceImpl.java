package com.ekart.product.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.product.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ReviewRepository reviewRepository;
}
