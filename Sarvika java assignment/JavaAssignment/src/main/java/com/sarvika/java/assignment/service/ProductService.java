package com.sarvika.java.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sarvika.java.assignment.config.ApiResponse;
import com.sarvika.java.assignment.entity.ProductEntity;
import com.sarvika.java.assignment.exception.ProductException;
import com.sarvika.java.assignment.model.ResponseModel;
import com.sarvika.java.assignment.model.ResquestModel;
import com.sarvika.java.assignment.repository.ProductRepository;

import jakarta.validation.Valid;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public ResponseEntity<ApiResponse> create(@Valid ResquestModel resquestModel) {

		validatePrice(resquestModel);

		ProductEntity productEntity = new ProductEntity();

		productEntity.create(resquestModel);

		repository.save(productEntity);

		ResponseModel responseModel = new ResponseModel(productEntity);

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ApiResponse.builder().status(201).message("Product created").data(responseModel).build());
	}

	public ResponseEntity<ApiResponse> update(Long id, @Valid ResquestModel resquestModel) {

		validatePrice(resquestModel);

		ProductEntity productEntity = repository.findById(id).orElseThrow(() -> ProductException.notFound(id));

		productEntity.update(resquestModel);

		repository.save(productEntity);

		ResponseModel responseModel = new ResponseModel(productEntity);

		return ResponseEntity
				.ok(ApiResponse.builder().status(200).message("Product updated").data(responseModel).build());
	}

	public ResponseEntity<ApiResponse> findById(Long id) {

		ProductEntity productEntity = repository.findById(id).orElseThrow(() -> ProductException.notFound(id));

		ResponseModel responseModel = new ResponseModel(productEntity);

		return ResponseEntity
				.ok(ApiResponse.builder().status(200).message("Product updated").data(responseModel).build());
	}

	public ResponseEntity<ApiResponse> getAll() {

		List<ProductEntity> list = repository.findAll();

		ResponseModel responseModel = null;

		for (ProductEntity entity : list) {

			responseModel = new ResponseModel(entity);

		}

		return ResponseEntity.ok(ApiResponse.builder().status(200).message("All products").data(responseModel).build());
	}

	public ResponseEntity<ApiResponse> delete(Long id) {

		ProductEntity entity = repository.findById(id).orElseThrow(() -> ProductException.notFound(id));

		repository.delete(entity);

		return ResponseEntity.ok(ApiResponse.builder().status(200).message("Product deleted").data(null).build());
	}

	private void validatePrice(ResquestModel request) {
		if (request.getPrice() == null || request.getPrice().doubleValue() <= 0) {
			throw ProductException.invalidInput("Price must be greater than 0");
		}
	}

}
