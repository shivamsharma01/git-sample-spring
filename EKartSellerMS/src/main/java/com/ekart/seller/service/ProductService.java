package com.ekart.seller.service;

import java.util.List;

import com.ekart.seller.dto.OrderDTO;
import com.ekart.seller.dto.ProductDTO;
import com.ekart.seller.dto.ProductModifyDTO;
import com.ekart.seller.exception.InvalidOrderException;
import com.ekart.seller.exception.NoItemException;
import com.ekart.seller.exception.NoOrderException;

public interface ProductService {
	public String add(String sellerId, ProductDTO productDTO);

	public String modifyProductDetails(String productName, ProductModifyDTO productModifyDTO) throws NoItemException;

	public List<ProductDTO> searchCatalog() throws NoItemException;

	public List<OrderDTO> showOrders(String sellerId) throws NoOrderException;

	public String changeStatus(String orderId) throws InvalidOrderException;
}
