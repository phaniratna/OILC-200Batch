package com.model;

public class Product {
   private int pid;
   public int getPid() {
	return pid;
}
public String getPname() {
	return pname;
}
public double getPrice() {
	return price;
}
private String pname;
   private double price;
   public Product(int pid,String pname,double price) {
	   this.pid = pid;
	   this.pname = pname;
	   this.price = price;
   }
@Override
public String toString() {
	return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
}
}
