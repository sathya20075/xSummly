package com.apps.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Intersection
{
	
	public static void main(String[] args)
	{
		Collection<String> listOne = new ArrayList<String>(Arrays.asList("Amazon","Flipkart", "Alibaba", "Snapdeal", "instrument", "engineering", "information"));
		Collection<String> listTwo = new ArrayList<String>(Arrays.asList("information", "iga", "Snapdeal", "Flipkart", "dingo"));

		listOne.retainAll( listTwo );
		System.out.println( listOne );
	}

}
