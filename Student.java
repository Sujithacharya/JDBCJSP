package model;

import java.util.Date;

public class Student
{
private int studentNo;
private String name;
private String dob;
private String doj;

public Student(String name, String dob, String doj) {
	super();
	this.name = name;
	this.dob = dob;
	this.doj = doj;
}
public Student(int studentNo, String name, String dob, String doj) {
	super();
	this.studentNo = studentNo;
	this.name = name;
	this.dob = dob;
	this.doj = doj;
}
public int getStudentNo() {
	return studentNo;
}
public void setStudentNo(int studentNo) {
	this.studentNo = studentNo;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}

}
