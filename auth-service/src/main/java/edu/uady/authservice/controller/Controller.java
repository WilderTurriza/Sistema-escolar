package edu.uady.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.uady.authservice.entity.UserAuth;
import edu.uady.authservice.service.UserAuthService;

@RestController
@RequestMapping(value="/auth")
public class Controller {

	@Autowired
	private UserAuthService userAuthService;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserAuth user){
		return ResponseEntity.ok(userAuthService.createUser(user));
	}
	
	@GetMapping("/${usernam}")
	public ResponseEntity<?> findUserByName(@PathVariable("username") String userName){
		try {
			return ResponseEntity.ok(userAuthService);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
