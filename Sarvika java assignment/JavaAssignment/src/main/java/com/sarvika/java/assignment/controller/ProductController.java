package com.sarvika.java.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sarvika.java.assignment.config.ApiResponse;
import com.sarvika.java.assignment.model.ResquestModel;
import com.sarvika.java.assignment.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> create(@RequestBody @Valid ResquestModel resquestModel) {
		return service.create(resquestModel);
	}

	@PutMapping("/{id}/update")
	public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody @Valid ResquestModel resquestModel) {
		return service.update(id, resquestModel);
	}

	@GetMapping("/{id}/getById")
	public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping("/getProductList")
	public ResponseEntity<ApiResponse> getAll() {
		return service.getAll();
	}

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
		return service.delete(id);
	}

}
