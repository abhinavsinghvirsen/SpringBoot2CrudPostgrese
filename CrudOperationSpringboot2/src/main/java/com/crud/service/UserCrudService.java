package com.crud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ctrl.AppController;
import com.crud.enty.User;
import com.crud.repo.UserRepo;

@Service
public class UserCrudService {

	Logger logger =LoggerFactory.getLogger(UserCrudService.class);
	@Autowired
	UserRepo userRepo; 
	
	
	public String saveUser(User usr) {
		logger.trace("i am in side save user");
		userRepo.save(usr);
		logger.warn("after save");
		logger.info("inside service save api");
		return "Sucess";
		
		
	}
	
	public String updateUser(User usr) {
		String status="fail";
		
		if(userRepo.findById(usr.getId()).get()!=null) {
			userRepo.save(usr);
			status="pass updated";
			
		}
		
		
		
		return status;
		
		
	}
	
	public List<User> getUsers(){
		
		return (List<User>) userRepo.findAll();
	}
	
	public User getUser(Long id) {
		
		User obj= userRepo.findById(id).get();
		
		return obj;
	}
	
	public String deleteUser(Long id) {
		
		userRepo.deleteById(id);
		
		
		return "deleted";
	}
	
}
