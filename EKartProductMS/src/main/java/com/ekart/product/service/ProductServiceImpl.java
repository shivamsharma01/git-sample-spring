package com.ekart.product.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;

}
