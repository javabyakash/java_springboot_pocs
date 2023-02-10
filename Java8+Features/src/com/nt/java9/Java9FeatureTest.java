package com.nt.java9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java9FeatureTest {
	
	public static void main(String[] args) {
		/*List<String> list = new ArrayList<>();
		list.add("SUN");
		list.add("MON");
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		System.out.println(unmodifiableList);
		unmodifiableList.add("FRI");
		System.out.println(unmodifiableList);*/
		
		/*List<String> unmodifiableList = List.of("SUN","MON");
		System.out.println(unmodifiableList);
		unmodifiableList.add("FRI");
		System.out.println(unmodifiableList);*/
		
		/*var i =10;
		System.out.println(i);
		i=78;*/
		
		/*List<Integer> list = List.of(10,15,18,20,25,40,50);
		
		List<Integer> filteredList = list.stream().filter(i->i%3==0).collect(Collectors.toUnmodifiableList());
		System.out.println(filteredList);
		filteredList.add(90);
		System.out.println(filteredList);*/
		
		/*//java11
		String str = "a,b,c";
		String st[] = str.split(",");
		
		for(String s:st) {
			System.out.println(s);
		}
		
		System.out.println(str.isBlank());*/
		
		/*String str = " Akash Hiwale ";
		System.out.println(str);
		String s1 = str.trim();
		System.out.println(s1);
		String s = str.strip();
		System.out.println(s);*/
		
		/*System.out.println("AKASH ".repeat(10));*/
		
		Optional<String> str = Optional.of(" ");
		System.out.println(str.isEmpty());
	}
}
