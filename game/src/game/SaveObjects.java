package game;

import java.io.*;
import java.util.ArrayList;

public class SaveObjects{

	public static void main(String[] arg){

		boolean powerSwitch=true;
		int x=9, y=150, z= 675;
		String name="Galormadron", setting="on", plant="rutabaga";
		ArrayList<String> stuff = new ArrayList<String>();
		stuff.add("One");
		stuff.add("Two");
		stuff.add("Three");
		stuff.add("Four");
		stuff.add("Five");

		try{
			
			FileOutputStream saveFile = new FileOutputStream("SavedObjects.sav");

			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);

			
			save.writeObject(powerSwitch);
			save.writeObject(x);
			save.writeObject(y);
			save.writeObject(z);
			save.writeObject(name);
			save.writeObject(setting);
			save.writeObject(plant);
			save.writeObject(stuff);

			
			save.close(); 
		}
		catch(Exception exc){
			exc.printStackTrace(); 
		}
	}
}
