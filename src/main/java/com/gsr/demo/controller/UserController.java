package com.gsr.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gsr.demo.entity.User;
import com.gsr.demo.repo.UserRepository;

@Controller
public class UserController {
	
	private final UserRepository userRepo;
	
	public static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public  UserController(UserRepository userRepo) {
		this.userRepo=userRepo;
	}
	
	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		LOGGER.info("signup api are called");
		return "add-user";
	}
	
	@PostMapping("/adduser")
	public String addUser(@Valid User user,BindingResult result,Model model) {
		LOGGER.info("add User(http://localhost:2020/adduser) api was called successfully");
		if(result.hasErrors()) {
			return "add-user";
		}
		userRepo.save(user);
		model.addAttribute("users",userRepo.findAll());
		LOGGER.info("add user api was executed successfully");
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id")long id,Model model) {
		LOGGER.info("edit api are called");
		User user=userRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid User Id"+id));
		model.addAttribute("user",user);
		return "update-user";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user,BindingResult result, Model model) {
		LOGGER.info("update api are called");
	    if (result.hasErrors()) {
	        user.setId(id);
	        return "update-user";
	    }
	         
	    userRepo.save(user);
	    model.addAttribute("users", userRepo.findAll());
	    return "index";
	}
	     
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		LOGGER.info("delete api are called");
	    User user = userRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    userRepo.delete(user);
	    model.addAttribute("users", userRepo.findAll());
	    return "index";
	}
}
