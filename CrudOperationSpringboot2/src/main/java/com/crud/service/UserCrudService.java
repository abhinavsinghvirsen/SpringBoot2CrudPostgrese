package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.enty.User;
import com.crud.repo.UserRepo;

@Service
public class UserCrudService {

	
	@Autowired
	UserRepo userRepo; 
	
	
	public String saveUser(User usr) {
		userRepo.save(usr);
		
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
