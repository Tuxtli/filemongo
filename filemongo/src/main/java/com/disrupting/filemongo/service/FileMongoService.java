package com.disrupting.filemongo.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.disrupting.filemongo.model.File;
import com.disrupting.filemongo.repository.FileRepository;

@Service
public class FileMongoService {
	
	public final static Logger LOGGER = LoggerFactory.getLogger(FileMongoService.class);
	
	@Autowired
	private FileRepository fileRepo;
	
	
	
	public String addFile(String title, MultipartFile fileMulti) throws IOException { 
        File file = new File(title); 
        LOGGER.info(" Multipart "+ fileMulti);
        file.setFile(
          new Binary(BsonBinarySubType.BINARY, fileMulti.getBytes())); 
        
        file = fileRepo.insert(file); return file.getId(); 
    }
	

    public File getFile(String id) { 
        return fileRepo.findById(id).get(); 
    }
	
	
    
    public JSONObject fileMongo(JSONObject responseJsonObject) {
		
		
		return null;
	}
    

}
