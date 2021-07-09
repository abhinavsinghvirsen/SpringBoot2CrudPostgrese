package com.crud.ctrl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.crud.service.QRCodeGenrator;
import com.crud.service.UserCrudService;
import com.google.zxing.WriterException;
import com.itextpdf.text.DocumentException;



@RestController
@RequestMapping("/crudapp")
public class AppController {
	
	Logger logger =LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	UserCrudService userCrudService;
	
	@Autowired
	QRCodeGenrator qRCodeGenrator;
	

	@Autowired
	UserRepo userRepo; 
	
	
	/* multi line comment  {"name":"abhinav","id":1}*/
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
	/*PDF DOWNLOAD SERVICE WITH ITEXT*/
	@GetMapping(value="/downloaduserlist" ,produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity getUserList() throws DocumentException {
		
		logger.info("downloading started");
		
		ByteArrayInputStream bs = userCrudService.getUsersDownload();
		
		HttpHeaders hd = new HttpHeaders();
		hd.add("Content-Disposition", "attachment; filename=report.pdf");
		
		
		return ResponseEntity.ok().headers(hd).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bs));	
	}
	
	
	@GetMapping(value="/genrateqr/{info}")
	public HttpEntity<byte[]> getQR( @PathVariable(value="info") String info) throws DocumentException, WriterException, IOException {
		
		logger.info("downloading started");
		
		byte[] br=qRCodeGenrator.generateQRImage(info);
		
		HttpHeaders ht= new HttpHeaders();
		ht.setContentType(MediaType.IMAGE_PNG);
		ht.setContentLength(br.length);
		
		return new HttpEntity<byte[]>(br,ht) ;	
	}
	
	
	
	
	

}
