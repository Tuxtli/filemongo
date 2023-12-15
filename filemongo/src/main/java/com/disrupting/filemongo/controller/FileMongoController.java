package com.disrupting.filemongo.controller;

import java.io.IOException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.disrupting.filemongo.model.File;
import com.disrupting.filemongo.service.FileMongoService;


@RestController
@RequestMapping("/api/v1")
public class FileMongoController {
	
	public final static Logger LOGGER = LoggerFactory.getLogger(FileMongoController.class);
	
	@Autowired
	private FileMongoService fileMongoService;
	
	@PostMapping("/file/add")
	public String addfile(@RequestParam("title") String title, 
	  @RequestParam("file") MultipartFile image, Model model) 
	  throws IOException {
	    String id = fileMongoService.addFile(title, image);
	    return "redirect:/file/" + id;
	}
	
	@GetMapping("/file/{id}")
	public String getPhoto(@PathVariable String id, Model model) {
	    File file = fileMongoService.getFile(id);
	    model.addAttribute("Title", file.getTitle());
	    model.addAttribute("file", 
	      Base64.getEncoder().encodeToString(file.getFile().getData()));
	    LOGGER.info(model.toString());
	    return Base64.getEncoder().encodeToString(file.getFile().getData());
	}
	
	@GetMapping("/init")
	public ResponseEntity<Object> getInit(){
		return new ResponseEntity<Object>("HOLA MONGO SERVICE ", HttpStatus.OK);
	}
	

}
