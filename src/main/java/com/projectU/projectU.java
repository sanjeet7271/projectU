package com.projectU;

import org.testng.annotations.Test;

import com.projectU.framework.Jstorm;

public class projectU  extends Jstorm{
	/*public static void main(String[] args) {
		executeTestNGXML("src/main/resources/xml/testNg.xml");
	}*/
	@Test
	public void ExecuteMain() {
		executeTestNGXML("src/main/resources/xml/testNg.xml");
	}

}
