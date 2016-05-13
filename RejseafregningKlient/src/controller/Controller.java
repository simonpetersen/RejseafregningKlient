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
	Boolean running = true;

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
			ui.print("Det var ikke et match, prÃ¸v igen.");
			run();
		}
	}

	public void menukald() throws IOException {
		String valgtInfo;
		
		while(running) {
			int valg = ui.menu();
			switch(valg){
			case 1:
				valgtInfo = data.stringFromUrl(url+"info/");
				ui.print(valgtInfo);
				break;
				
			case 2:
				valgtInfo = data.stringFromUrl(url+"info/" + brugernavn);	
				ui.print(valgtInfo);
				break;
				
			case 3:
				valgtInfo = data.stringFromUrl(url + "info/" + brugernavn + "/" + password);
				ui.print(valgtInfo);
				break;
				
			case 4:
				String adr = ui.adresse();
				valgtInfo = data.putUrl(url + "opdater/" + brugernavn + "/" + password + adr, brugernavn + "/" + password + adr);
				break;
				
			case 9:
				ui.print("Farvel");
				running = false;
				break;
				
			default:
				ui.print("Du skal vælge en af de tilgængelige valgmuligheder.");
			}
		} 
	}
}
