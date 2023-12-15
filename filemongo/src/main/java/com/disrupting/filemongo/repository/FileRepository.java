package com.disrupting.filemongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.disrupting.filemongo.model.File;

@Repository
public interface FileRepository extends MongoRepository<File, String> { 
	
}


