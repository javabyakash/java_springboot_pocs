package com.nt.test;

import com.nt.bean.Engine;

public class TestEngine {
	public static void main(String[] args) {
		Engine e = new Engine() {
			{
				System.out.println("#3 - FROM ANONYMOUS INNER CLASS");
			}
		};
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		System.out.println(e.getClass().getName());
	}
}
