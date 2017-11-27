package com.poc.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.language.v1beta2.ClassificationCategory;
import com.google.cloud.language.v1beta2.Document;
import com.google.cloud.language.v1beta2.Document.Type;
import com.google.cloud.language.v1beta2.LanguageServiceClient;
import com.poc.springboot.model.Classification;
import com.poc.springboot.util.Utililies;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestParam("myfile") MultipartFile[] file) throws IOException {
		ArrayList<String> googleOutput=new ArrayList<>();
		for (MultipartFile file1 : file) {
			if (!file1.isEmpty()) {
				File tempfile = new File("Files\\" );
				tempfile.mkdirs();
				tempfile = new File("Files\\" + file1.getOriginalFilename());
				try (LanguageServiceClient language = LanguageServiceClient.create()) {
					tempfile.createNewFile();
					Files.write(Paths.get(tempfile.toURI()), file1.getBytes(), StandardOpenOption.CREATE,
							StandardOpenOption.TRUNCATE_EXISTING);
							String str = new String(file1.getBytes());
							Document doc = Document.newBuilder()
					          .setContent(str).setType(Type.PLAIN_TEXT).build();
					      List<ClassificationCategory> classificationList = language.classifyText(doc).getCategoriesList();
					      for(ClassificationCategory obj:classificationList){
					    	  Classification tempObj=new Classification(obj.getName(), obj.getConfidence(),0,file1.getOriginalFilename());
					    	  googleOutput.add(Utililies.getJSONString(tempObj));
					      }
				} catch ( Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String resp="{\"error\":false,\"ResponseCode\":\"200\",\"IsError\":false,\"ResponseMessage\":\"200\",\"Data\":"+googleOutput+"}";
				return new ResponseEntity<String>(resp, HttpStatus.OK);
			}

		}

		return new ResponseEntity<String>("Empty File", HttpStatus.NO_CONTENT);
	}
}