package com.poc.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Classification {
	@JsonProperty(value = "Name")
	private String name;
	@JsonProperty(value = "Confidence")
	private Float confidence ;
	
	@JsonProperty(value = "FileId")
	private int fileId ;
	
	@JsonProperty(value = "FileName")
	private String fileName ;
	
	
	
	public Classification(String name, Float confidence, int fileId, String fileName) {
		super();
		this.name = name;
		this.confidence = confidence;
		this.fileId = fileId;
		this.fileName = fileName;
	}
	public Classification() {
		super();
	}
	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	

	public Float getConfidence() {
		return confidence;
	}
	
	
	public void setConfidence(Float confidence) {
		this.confidence = confidence;
	} 
	
	
}
