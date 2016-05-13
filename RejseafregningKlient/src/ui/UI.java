package ui;

import java.io.IOException;
import java.util.Scanner;

import controller.Controller;

public class UI {
	
	Scanner scan = new Scanner(System.in);
	
	
	public void print(String info) throws IOException {
		System.out.println(info);
	}
	
	public String loginbrugernavn() {
		String brugernavn;
		
		System.out.println("Indtast brugernavn: ");
		brugernavn = scan.nextLine();
		
		return brugernavn;
		
	}
	public String loginpassword() {
		String password;
		
		System.out.println("Indtast password: ");
		password = scan.nextLine();
		
		return password;
		
	}
	public int menu() {
		System.out.println("Vælg funktion: "); 
		System.out.println("1. Info om antal rejseafregninger og bruger.");
		System.out.println("2. Se dine informationer.");
		System.out.println("3. Se dine rejseafregningere");
		System.out.println("9. Afslut");
		
		int valg;
		valg = scan.nextInt();
		
		return valg;
	}

}
