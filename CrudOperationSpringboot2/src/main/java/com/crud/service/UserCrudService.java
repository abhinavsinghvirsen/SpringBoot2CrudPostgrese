package com.crud.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.ctrl.AppController;
import com.crud.enty.User;
import com.crud.repo.UserRepo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
		if(obj==null) {
			throw new NullPointerException();
		}
		return obj;
	}
	
	public String deleteUser(Long id) {
		
		userRepo.deleteById(id);
		
		
		return "deleted";
	}
	
   public ByteArrayInputStream getUsersDownload() throws DocumentException{
	   
	   List<User> lu= getUsers();
	   
	   /*prepare pdf*/
	   
	  
		
		
		
		PdfPTable table = new PdfPTable(2);
		
		for(User bknm:lu) {
			
			PdfPCell cell;
			PdfPCell cell2;
			
			cell= new  PdfPCell(new Phrase(bknm.getId()+""));
			cell2= new  PdfPCell(new Phrase(bknm.getUsername()));
			table.addCell(cell);
			table.addCell(cell2);
			
			
		}
		
		
		    ByteArrayOutputStream bos= new ByteArrayOutputStream();
		    Document doc =new Document();
			PdfWriter.getInstance(doc, bos);
			doc.open();
			doc.add(table);
			doc.close();
			

		
		return new ByteArrayInputStream(bos.toByteArray());
	}
	
}
