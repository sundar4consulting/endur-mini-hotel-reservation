package com.endur.miniproj;

import com.opencsv.bean.CsvBindByName;

public class NamedColumnBean extends CSVBean {

	
	

    @CsvBindByName(column = "name")
    private String name;

    @CsvBindByName
    private int age;
    
    
    
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
