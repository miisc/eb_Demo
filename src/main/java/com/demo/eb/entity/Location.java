package com.demo.eb.entity;

import lombok.Data;

@Data
public class Location {
	int uid;
	String id, name;
	Location subLocation;
}
