package com.mytech.hellobeans.app;

public class Main {
	public static void main(String[] args) {
		EJBClient1 client1 = new EJBClient1();
		EJBClient2 client2 = new EJBClient2();
		
		client1.add();
		client2.add();
		
		client1.print();
		client2.print();
	}


}