package com.disrupting.filemongo.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "files")
public class File {
    
	@Id
    private String id;
    
    private String title;
        
    private Binary file;

	public String getId() {
		return id;
	}
	
	public File(String title) {
		// TODO Auto-generated constructor stub
		this.title=title;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Binary getFile() {
		return file;
	}

	public void setFile(Binary file) {
		this.file = file;
	}
    
    
}
