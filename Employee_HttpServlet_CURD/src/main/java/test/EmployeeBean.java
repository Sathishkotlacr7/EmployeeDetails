package test;
import java.io.*;
@SuppressWarnings("serial")
public class EmployeeBean implements Serializable
{
 private String id,name,desg;
 private float tSal;
 private int bSal;
 public EmployeeBean()
 {
	//private Constructor 
 }
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDesg() {
	return desg;
}
public void setDesg(String desg) {
	this.desg = desg;
}
public float gettSal() {
	return tSal;
}
public void settSal(float tSal) {
	this.tSal = tSal;
}
public int getbSal() {
	return bSal;
}
public void setbSal(int bSal) {
	this.bSal = bSal;
}

 
}
