package com.thbs.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.thbs.UserService.Entity.Product;
import com.thbs.UserService.Entity.User;
import com.thbs.UserService.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserService userService;
	//private final String URL = "http://localhost:8400/product";
	
	//Make sure @Loadbalanced for rest template bean in main method
	private final String URL = "http://PRODUCTSERVICE/product";

	@GetMapping("/product")
	public List<Product> getAllProducts() {
		//String url = "http://localhost:8400/product";
		List<Product> productList = restTemplate.getForObject(URL, List.class);
		return productList;
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<Object> getProductById(@PathVariable Integer productId) {
		try {
			Product product = restTemplate.getForObject(URL + "/" + productId, Product.class);
			return new ResponseEntity<Object>(product, HttpStatus.OK);
		} catch (HttpClientErrorException ex) {
			return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping()
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);

	}

	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<>("User added successfully with Id: " + user.getUserId(), HttpStatus.CREATED);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer userId) {
		userService.deleteUserById(userId);
		return new ResponseEntity<>("User deleted successfully with Id: " + userId, HttpStatus.OK);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User updatedUser, @PathVariable Integer userId) {
		userService.updateUser(userId, updatedUser);
		return new ResponseEntity<>("User updated successfully with Id: " + userId, HttpStatus.OK);
	}
}
