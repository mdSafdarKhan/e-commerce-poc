package com.example.demo.user;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cart.CartService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired UserRepository userRepository;
	
	@Autowired CartService cartService;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable(name = "id") int id){
		User user = userRepository.findById(id).get();
		user.setCartList(Arrays.asList(cartService.getCart()));
		return user;
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		User u = new User();
		u.setUserName(user.getUserName());
		u = userRepository.save(user);
		return u;
	}
}
