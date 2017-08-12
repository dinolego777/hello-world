package game;

import java.io.*;
import java.util.ArrayList;

public class RestoreObjects{

	public static void main(String[] arg){

		
		boolean powerSwitch=false;
		int x=0, y=0, z=0;
		String name="", setting="", plant="";
		ArrayList<String> stuff = new ArrayList<String>();
		
		
		try{
			
			FileInputStream saveFile = new FileInputStream("SavedObjects.sav");

			
			ObjectInputStream save = new ObjectInputStream(saveFile);

			
			powerSwitch = (Boolean) save.readObject();
			x = (Integer) save.readObject();
			y = (Integer) save.readObject();
			z = (Integer) save.readObject();
			name = (String) save.readObject();
			setting = (String) save.readObject();
			plant = (String) save.readObject();
			stuff = (ArrayList<String>) save.readObject();

			
			save.close(); 
		}
		catch(Exception exc){
			exc.printStackTrace();
		}

	
		System.out.println("\nRestored Object Values:\n");
		System.out.println("\tpowerSwitch: " + powerSwitch);
		System.out.println("\tx=" + x + " y=" + y + " z=" + z);
		System.out.println("\tname: " + name);
		System.out.println("\tsetting: " + setting);
		System.out.println("\tplant: " + plant);
		System.out.println("\tContents of stuff: ");
		System.out.println("\t\t" + stuff);
		System.out.println();

		
	}
}
