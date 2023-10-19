package com.saeyan.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * create table product(
    code number(5) primary key,
    name VARCHAR2(100),
    price NUMBER(8),
    pictureurl VARCHAR2(50),
    description varchar2(1000)
);
 */
@Setter
@Getter
@ToString
public class ProductVO {
	
	private int code;
	private String name;
	private int price;
	private String pictureurl;
	private String description;
}
