package com.exampleSaad.Saad;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Register {

	private Integer Regis_id;
	private Integer Salary;
	private String Name;
	private String Address;
	private Integer Phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Hire_date;
	private String Gmail;
	private String College;
	private String Course;
	public Integer getRegis_id() {
		return Regis_id;
	}
	public void setRegis_id(Integer regis_id) {
		Regis_id = regis_id;
	}
	public Integer getSalary() {
		return Salary;
	}
	public void setSalary(Integer salary) {
		Salary = salary;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Integer getPhone() {
		return Phone;
	}
	public void setPhone(Integer phone) {
		Phone = phone;
	}
	public LocalDate getHire_date() {
		return Hire_date;
	}
	public void setHire_date(LocalDate hire_date) {
		Hire_date = hire_date;
	}
	public String getGmail() {
		return Gmail;
	}
	public void setGmail(String gmail) {
		Gmail = gmail;
	}
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public String getCourse() {
		return Course;
	}
	public void setCourse(String course) {
		Course = course;
	}
	@Override
	public String toString() {
		return "Register [Regis_id=" + Regis_id + ", Salary=" + Salary + ", Name=" + Name + ", Address=" + Address
				+ ", Phone=" + Phone + ", Hire_date=" + Hire_date + ", Gmail=" + Gmail + ", College=" + College
				+ ", Course=" + Course + "]";
	}
	
	
	
	
	
}
