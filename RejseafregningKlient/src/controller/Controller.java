package controller;

import java.io.IOException;

import data.DataGetter;
import ui.UI;

public class Controller {

	private String url;
	private DataGetter data;
	private UI ui;

	public Controller() {
		url = "http://ec2-52-39-152-237.us-west-2.compute.amazonaws.com:8080/Rejseafregning/api/";
		data = new DataGetter();
		ui = new UI();
	}

	public void run() throws IOException {
		String info;
		menukald();

	}

	public void menukald() throws IOException {
		String brugernavn = ui.loginbrugernavn();
		int valg = ui.menu();
		String valgtInfo;
		while(true) {
			
			if(valg == 1) {
				valgtInfo = data.stringFromUrl(url+"info/");
				ui.print(valgtInfo);
			}
			else if(valg == 2) {
				valgtInfo = data.stringFromUrl(url+"info/" + brugernavn);	
				ui.print(valgtInfo);
			}
			else if(valg == 3) {
				//valgtInfo = data.stringFromUrl(url+"info/" + );
			}
			else if(valg == 9) {
				break;
			}
		} 
	}
}
