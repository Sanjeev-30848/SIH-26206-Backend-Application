package com.klef.sih;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LombokDemo 
{
	private int id;
	private String name;
	private String email;
	
	public void test()
	{
		LombokDemo demo = new LombokDemo();
		//lombok generated setter methods
		 demo.setId(101);
	     demo.setName("KLU");
	     demo.setEmail("demo@gmail.com");
	     
	  // Lombok-generated getter methods
	        System.out.println("ID    : " + demo.getId());
	        System.out.println("Name  : " + demo.getName());
	        System.out.println("Email : " + demo.getEmail());
	}
}
