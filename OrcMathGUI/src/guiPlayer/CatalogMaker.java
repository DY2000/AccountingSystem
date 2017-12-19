package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CatalogMaker {

	private ArrayList<Megaman> list;
	public static Scanner in = new Scanner(System.in);

	public CatalogMaker() {
		list = new ArrayList<Megaman>();
		list.add(new Megaman("buster","name","type"));

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
		System.out.println("Please input a buster, name, type.");
		String hi = in.nextLine();
		String[] reee = hi.split(",");
		while(reee.length!=3) {
			System.out.println("Please input a buster, name, type.");
			hi = in.nextLine();
			reee = hi.split(",");
		}
		System.out.println("You have successfully added this item!");

	}

	private void testSaveContent(String fileName) {

		try{    

			FileWriter fw=new FileWriter(fileName);    
			for(Megaman a: list) {
				fw.write(a.toString()+"\n");
			}    

			fw.close();    

			System.out.println("Success! File \""+fileName+"\" saved!");

		}catch(IOException e){

			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}



	}
	private static List<String> testFileLoading() {

		Scanner in = new Scanner(System.in);

		String fileName = "";

		List<String> content = new ArrayList<String>();

		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename

		boolean opened = false;

		while(!opened){

			try {

				System.out.println("Enter a file to open");

				fileName = in.nextLine();

				FileReader fileReader = new FileReader(new File(fileName));

				String line = "";

				//a BufferedReader enables us to read teh file one line at a time

				BufferedReader br = new BufferedReader(fileReader);

				while ((line = br.readLine()) != null) {
					String [] z = line.split(",");
					content.add(line);



					/*

					 * useful later:

					 * split only a comma that has an even number of quotes ahead of it

 String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

					 */





				}

				br.close();

				opened = true;

			}catch (IOException e) {

				System.out.println("The file name you specified does not exist.");

			}

		}





	}
}
