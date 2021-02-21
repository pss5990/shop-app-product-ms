package com.shop.practice.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@Value("${deployment.version}")
	private String version;
	

	private ArrayList<String> products = Lists.newArrayList("T-Shirts", "Caps", "Jeans", "Sweaters");

	@GetMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getProducts() {
		return new ResponseEntity<List<String>>(products, HttpStatus.OK);
	}

	@GetMapping(path = "/product/{length}")
	public ResponseEntity<?> getProducts(@PathVariable(name = "length") final int length) {
		List<String> list = products.stream().filter(str -> str.length() < length).collect(Collectors.toList());
		list.add("version="+version);
		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> hello() {
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}
}
