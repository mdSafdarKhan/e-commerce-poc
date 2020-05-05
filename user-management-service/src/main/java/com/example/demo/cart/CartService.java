package com.example.demo.cart;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cart-service")
public interface CartService {
	
	@GetMapping("/cart/1588695183498")
	public Cart getCart();

}
