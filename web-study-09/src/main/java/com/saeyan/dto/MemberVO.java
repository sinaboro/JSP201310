package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
NAME            VARCHAR2(20) 
USERID NOT NULL VARCHAR2(10) 
PWD             VARCHAR2(10) 
EMAIL           VARCHAR2(20) 
PHONE           CHAR(13)     
ADMIN           NUMBER(1) 
 */
@Setter
@Getter
@ToString
public class MemberVO {

	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
//	private Integer admin;
	
}
