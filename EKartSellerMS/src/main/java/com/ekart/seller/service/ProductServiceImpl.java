package com.ekart.seller.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.seller.dto.OrderDTO;
import com.ekart.seller.dto.ProductDTO;
import com.ekart.seller.dto.ProductModifyDTO;
import com.ekart.seller.entity.ProductEntity;
import com.ekart.seller.exception.InvalidOrderException;
import com.ekart.seller.exception.NoItemException;
import com.ekart.seller.exception.NoOrderException;
import com.ekart.seller.repository.ProductRepository;
import com.ekart.seller.repository.SellerRepository;

@Service
public class ProductServiceImpl implements ProductService {

	Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SellerRepository sellerProdRepository;

	@Override
	public String add(String sellerId, ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setDisplayName(productDTO.getDisplayName());
		productEntity.setCategory(productDTO.getCategory().toLowerCase());
		productEntity.setShortDesc(productDTO.getShortDesc());
		productEntity.setDescription(productDTO.getDescription());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setDeliveryCharge(productDTO.getDeliveryCharge());
		productEntity.setDiscount(productDTO.getDiscount());
		productRepository.save(productEntity);
//		String prodName = productRepository.save(productEntity).getProductName();
//		SellerCompositeKey key = new SellerCompositeKey(sellerId, prodName);
//		Optional<SellerProductsEntity> sellerProductEntity = null;
//		if (sellerProdRepository.existsById(key)) {
//			sellerProductEntity = sellerProdRepository.findById(key);
//			sellerProductEntity.get().setItemCount(sellerProductEntity.get().getItemCount() + 1);
//		} else {
//			sellerProductEntity = Optional.of(new SellerProductsEntity());
//			sellerProductEntity.get().setKey(key);
//			sellerProductEntity.get().setItemCount(1);
//		}
//		sellerProdRepository.save(sellerProductEntity.get());
		return "ProductService.ADD_SUCCESS";
	}

	@Override
	public String modifyProductDetails(String productName, ProductModifyDTO productModifyDTO) throws NoItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> searchCatalog() throws NoItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> showOrders(String sellerId) throws NoOrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeStatus(String orderId) throws InvalidOrderException {
		// TODO Auto-generated method stub
		return null;
	}

}
