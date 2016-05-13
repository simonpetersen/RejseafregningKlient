package controller;

import java.io.IOException;

import data.DataGetter;

public class Controller {
	
	private String url;
	private DataGetter data;
	
	public Controller() {
		url = "http://ec2-52-39-152-237.us-west-2.compute.amazonaws.com:8080/Rejseafregning/api/";
		data = new DataGetter();
	}

	
	public void run() {
		try {
			System.out.println(data.stringFromUrl(url+"info/dimo"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
