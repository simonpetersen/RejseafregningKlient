package controller;

import java.io.IOException;

import data.DataGetter;
import ui.UI;

public class Controller {

	private String url;
	private DataGetter data;
	private UI ui;
	String brugernavn;
	String password;

	public Controller() {
		url = "http://ec2-52-39-152-237.us-west-2.compute.amazonaws.com:8080/Rejseafregning/api/";
		data = new DataGetter();
		ui = new UI();
	}

	public void run() throws IOException {
		brugernavn = ui.loginbrugernavn();
		password = ui.loginpassword();
		String bruger = data.stringFromUrl(url+"opdater/" + brugernavn + "/" + password);
		if(bruger.substring(0,17).equals("Koden er korrekt.")) {
			menukald();
		}
		else {
			System.out.println("Det var ikke et match, prøv igen.");
			run();
		}
	}

	public void menukald() throws IOException {
		String valgtInfo;
		
		while(true) {
			int valg = ui.menu();
			if(valg == 1) {
				valgtInfo = data.stringFromUrl(url+"info/");
				ui.print(valgtInfo);
			}
			else if(valg == 2) {
				valgtInfo = data.stringFromUrl(url+"info/" + brugernavn);	
				ui.print(valgtInfo);
			}
			else if(valg == 3) {
				valgtInfo = data.stringFromUrl(url + "info/" + brugernavn + "/" + password);
				ui.print(valgtInfo);
			}
			else if(valg == 9) {
				System.out.println("Farvel");
				break;
			}
		} 
	}
}
