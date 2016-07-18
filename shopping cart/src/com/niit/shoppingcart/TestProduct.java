package com.niit.shoppingcart;

public class TestProduct {
	public static void main(String[] args) {
		Product product=new Product("0086","dell laptop");
		product.setId("086");
		product.setName("mobile");
		product.setPrice(25000);
		System.out.println( product.getId());
		System.out.println( product.getName());
		System.out.println( product.getPrice());
		
	}

}
