package com.magic.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * create table employees(
    id varchar2(10) not null,
    pass varchar2(10) not null,
    name varchar2(30) ,
    lev char(1) default 'A',
    enter date default sysdate,
    gener char(1) default '1',
    phone varchar2(30),
    primary key(id)
    );
 */

@Setter
@Getter
@ToString
public class EmployeesVO {
	private String id;
	private String pass;
	private String name;
	private String lev;
	private String gender;
	private Date enter;
	private String phone;
	
}
