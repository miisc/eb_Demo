package com.demo.eb.entity;

import lombok.Data;

@Data
public class ItemClass {
	int uid;
	String name;
	ItemClass superClass;
}
