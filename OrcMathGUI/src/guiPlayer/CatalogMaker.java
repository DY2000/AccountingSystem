package guiPlayer;

import java.util.ArrayList;
import java.util.Scanner;


public class CatalogMaker {
	
	private ArrayList<Megaman> list;
	
	public CatalogMaker() {
		list = new ArrayList<Megaman>();
		list.add(new Megaman("The main man buster","name","type"));
		
	}
	public String getCSVcontent() {
		String data = "buster,name,type\n";
		for(Megaman n: list) {
			data += n + "\n";
		}
		return data;
	}

	public static void main(String[] args) {
		CatalogMaker cata = new CatalogMaker();
		System.out.println(cata.getCSVcontent());
		
	
	}
	public void addNewItem() {
		System.out.println("You have successfully added this item!");
		Scanner in = new Scanner(System.in);
		String next = in.nextLine();
	}

	
	

}
