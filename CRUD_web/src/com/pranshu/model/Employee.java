package com.pranshu.model;

public class Employee {
	private int id;
	private String name;
	private long mobile;
	private String dept;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name
                + ", mobile=" + mobile + ", dept=" + dept + "]";
    }    
}
