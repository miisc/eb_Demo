package com.demo.eb.entity;

import lombok.Data;

@Data
public class Document {
	int uid;
	String id, name, documentClassName, ebDocumentClassName, docUrl;
//	Date creationDate;
}
