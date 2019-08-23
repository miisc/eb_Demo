package com.demo.eb.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Item {
	int uid;
	// facilityUID, systemUID, subSystemUID;
	String id, name, status, className;
	String facilityName, systemName, subSystemName, locationName, subLocationName;

	// private int parentItemUID;
	// private String parentItemID, parentItemName;

	private Item parentItem;
	private List<Item> childItems;
	private List<Item> connectedFromItems;
	private List<Item> connectedToItems;
	private List<Document> documents;
	private List<ItemAttribute> attributes;

}
