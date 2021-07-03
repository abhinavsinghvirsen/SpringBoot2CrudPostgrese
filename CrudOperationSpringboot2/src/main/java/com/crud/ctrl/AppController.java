package com.crud.ctrl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.enty.User;
import com.crud.repo.UserRepo;
import com.crud.service.UserCrudService;



@RestController
@RequestMapping("/crudapp")
public class AppController {
	
	Logger logger =LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	UserCrudService userCrudService;
	

	@Autowired
	UserRepo userRepo; 
	
	
	/* multi line comment*/
	@PostMapping("/saveuser")
	public String saveUser(@RequestBody User obj) {
		logger.info("inside save api");
		
		
		
		return userCrudService.saveUser(obj);	
	}
	
	@GetMapping("/getusers")
	public List<User> getUser() {
		
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("Erroro");
		return userCrudService.getUsers();	
	}
	
	@PutMapping("/updateuser")
	public String update(@RequestBody User obj) {
		
		
		return userCrudService.updateUser(obj);	
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable( value="id" )Long id) {
		
		
		return userCrudService.deleteUser(id);	
	
	}
	
	@GetMapping("/getuser/{id}")
	public User getUser(@PathVariable( value="id" )Long id) {
		
		
		return userCrudService.getUser(id);	
	
	}
	
	

}
