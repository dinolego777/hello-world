package game;




import java.awt.*;
import java.io.*;

import java.util.*;

import javax.swing.*;

public class game_tester 
{
	
	 
	    
	 
	      
   public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException
   {
	   
	
	   FileInputStream loadFile = new FileInputStream("SavedObjects.venture");

		
		ObjectInputStream load = new ObjectInputStream(loadFile);
		 
		
		 int t=0;
	   int end=0;
	  int x=1;
	  String charName = null;
      String diff= "0";
      Scanner input = new Scanner(System.in);
      int inte=1;
	   while(x==1)
	   {
	   //hi dartainian, i"m a useless comment
		   //Useless comments are a waste of precious kilobytes, Daniel -_- Like this one...
		while(inte==1)
		{
		   System.out.println("Menu: \n\n1 - Create New Game\n2 - Load Game\n0 - Exit Game\n\nPress the desired key, then press Enter.");
	  String create = input.next();
	  if(create.equalsIgnoreCase("1"))
	  {
		  
		  System.out.println("Welcome to Venture!");
		  System.out.println("\nWhat is your name? ");
		  charName = input.next();
		  int y=0;
		 
		
		  while(y==0)
		  {
		  System.out.println("Would you like difficulty level 1, 2, or 3? ");
		  
		  diff = input.next();
		  if(diff.equalsIgnoreCase("1")||diff.equalsIgnoreCase("2")||diff.equalsIgnoreCase("3"))
		  {
		  System.out.println();
		  y=1;
	      inte=0;
		  }
	      else
	      {
	    	  System.out.println("That is not a valid choice.\n");
	      }
		  }
		  
	  }
	  
	  else if(create.equalsIgnoreCase("2"))
	  {
		  try{
			
		  charName = (String) load.readObject();
		  diff = (String) load.readObject();
		  
		  }
		  catch(Exception exc){
				exc.printStackTrace();
			}
		  t=2;
		  inte=0;
	  }
	  else if(create.equalsIgnoreCase("0"))
	  {
		  System.out.println("See you again soon!");
		  Thread.sleep(3000);
		  System.exit(0);
		  x=0;
	 
	  
	  }
	  else
	  {
	   System.out.println(" ");
		  System.out.println("That is not a valid choice.");
		  System.out.println(" ");
	   
	  }
   }
	    game g1 = new game(charName, diff);
	    if(t==2)
		  {
	    	g1.loadleft();
			 g1.load();
			 g1.loadhotbar();
			 g1.loadlevel();
		  }
		  
		 
		  
	      System.out.println(g1.playerInfo());
	   System.out.println("\nWelcome to the world of Venture!  You are about to embark on an exciting journey over\n"
	   		            + "colossal mountain ranges, through pitch-black forests, and across parched, arid deserts.\n"
	   		            + "You will encounter vicious monsters on your travels, make new allies, and become a legend\n"
	   		            + "in the lore of Venture!  Are you up to the challenge?\n");
		 if(t!=2)
		 {
	   System.out.println("You received: Basic Sword\n");
	 
   
  int y=1;
  
   while(y==1)
   {
	   System.out.println("Would you like to put this item in the inventory or hotbar?");
   System.out.println("1 - Inventory");
   System.out.println("0 - Hotbar");
	   int s = input.nextInt();
   if (s==1)
   {
	 
	   System.out.print("Enter the row where you would like the item:  ");
	   System.out.print(" (0 to ");
	   System.out.print(g1.getInventoryLength()-1+"):");
	   int row = input.nextInt();
	   System.out.println();
	   System.out.print("Enter the column where you would like the item:  ");
	   System.out.print(" (0 to ");
	   System.out.print(g1.getInventoryColumnLength()-1+"):");
	   int col = input.nextInt();
	   items basic_sword= new items("Basic Sword", 10, "Weapon");
	   g1.setInventory(basic_sword, row, col);
	  g1.playerInfo();
	 y=0;
   }
   else if(s==0)
   {
	   items basic_sword= new items("Basic Sword", 10, "Weapon");
	   System.out.print("Enter the row where you would like the item:  ");
	   System.out.print(" (0 to ");
	   System.out.print(g1.getHotbarLength()-1+"):");
	   int row = input.nextInt();
	  
	   g1.setHotbar(basic_sword, row);
	   System.out.println("");
	   g1.playerInfo();
	   y=0;
   }
	  
	  
   
   
   
   /*else if(s==454545 )
   {
	   if(g1.getDifficulty()==3)
	   {
	   items hidden_sword= new items("Hidden Sword", 30, "easter egg","easter egg");
	   System.out.print("Enter the row where you would like the item");
	   System.out.print(" (0 to ");
	   System.out.print(g1.getHotbarLength()-1+"):");
	   int row = input.nextInt();
	   g1.setHotbar(hidden_sword, row);
	   System.out.println("");
	   g1.playerInfo();
	  y=0;
	   }
	   else
	   {
		   System.out.println("not an option\n");
			  y=1; 
	   }
	  
   }*/
   
   else
   {
	  System.out.println("That is not an option.\n");
	  
   }
   }
		 }
	   
   System.out.println("You are ready to embark on your journey in the world of Venture!");
  int go=1;
  
  
 
  while(go==1)
  {
	  menu();
	  System.out.println("\t0 - Exit game");
	  int choice=input.nextInt();
    if(choice==1)
    {
    	try
    	{
    		FileOutputStream saveFile = new FileOutputStream("SavedObjects.venture");

    		   
    		
    		ObjectOutputStream save = new ObjectOutputStream(saveFile);
    	save.writeObject(charName);
		save.writeObject(diff);
		g1.save();
		g1.savehotbar();
		g1.savelevel();
		g1.saveleft();
    	}
    	catch(Exception exc){
			exc.printStackTrace(); 
		}
		
		
		

		
		
    }
    else if(choice==2)
     {
    	 System.out.println(g1.playerInfo());
     }
     else if(choice==3)
     {
    	 int area = (int) (Math.random()*3)+1;
    	 //if(area==1)
    	 //{
    		System.out.println("You have come across a forest."); 
    		 System.out.println(" Would you like to explore the forest?");
    		 System.out.println("\t1 - Yes");
    		 System.out.println("\t0 - No");
    		  int next=input.nextInt();
    		  
    		  while (next==1)
    		  {
    			  int explore = (int) (Math.random()*3)+1;
    			  if (explore==1)
    			 {
    				  System.out.println("You have found a dungeon hidden in the forest.");
    				  System.out.println(" Would you like to explore the dungeon?");
    		    		 System.out.println("\t1 - Yes");
    		    		 System.out.println("\t0 - No");
    		    		 int r=input.nextInt();
    		    		while(r==1)
    		    		{
    		    		 if(r==1)
    		    		 {
    		    			 monsters M1=new monsters("Troll", "Enemy",1,"Common", 50 );
    		    			 System.out.println("Your health: "+g1.gethealth());
    		    			 M1.getmonsterinfo();
    		    			 g1.GetHotbar();
    		    			 System.out.println(" Attack monster?");
        		    		 System.out.println("\t1 - Yes");
        		    		 System.out.println("\t0 - No");
        		    		 int w=input.nextInt();
        		    		 if(g1.emptyHotbar()!=0)
        		    		 {
        		    		 while(w==1)
        		    		 {
        		    		if(g1.gethealth()!=0.0)
        		    		{
        		    			 System.out.print("Choose the hotbar row of the desired item: (0-");
        		    		 System.out.println(g1.getHotbarLength()-1+")");
        		    		 int row=input.nextInt();
        		    		 M1.decrease_Monsterhealth(g1.doDamage(row));
        		    		 if(M1.getmonsterhealth()==0.0)
        		    		 {
        		    			 System.out.println("You defeated the monster!");
        		    			 g1.levelUp(.1);
        		    			 w=0;
        		    		 }
        		    		 else
        		    		 {
        		    			 int attack = (int) (Math.random()*15)+1;
        		    			 g1.decrease_health(attack);
        		    			 System.out.println("Your health: "+g1.gethealth()+"\n");
        		    			 if(g1.gethealth()!=0.0)
        		    			 M1.getmonsterinfo();
        		    		 }
        		    		 }
        		    		if(g1.gethealth()<=0.0)
        		    		{
        		    			System.out.println("You lose...");
        		    			go=0;
        		    			r=0;
        		    			w=0;
        		    			next=0;
        		    			end=1;
        		    		}
        		    		 }
        		    		 }
        		    		 else
        		    			 
        		    			System.out.println("You have no items in your hotbar.");
        		    		 if(g1.gethealth()!=0.0)
        		    		 {
        		    		 System.out.println("Explore the dungeon more?");
       		    		  System.out.println("\t1 - Yes");
        		    		 System.out.println("\t0 - No");
        		    		  r=input.nextInt();
        		    			 }
    		    		 }
    		    		}
    		    		if(g1.gethealth()!=0.0)
    		    		{
    		    		  System.out.println("Explore the forest more?");
    		    		  System.out.println("\t1 - Yes");
     		    		 System.out.println("\t0 - No");
     		    		  next=input.nextInt();
    		    		}
    		    		
    			 }
    			  else if(explore==2)
    			  {
    				  
    			 }
    			  else if(explore==3)
    			  {
    				  
    			  }
    		  }
    	// }
    	 /*else if(area==2)
    	 {
    	   System.out.println("you have come across a large mountain range");
    	   System.out.println(" explore mountains?");
    	   System.out.println("\t1 yes");
  		 System.out.println("\t0 no");
          choice=input.nextInt();
          *Daniel, you use the choice variable for the main menu interface.  Thus, I think we will have to change this.
    	 }
    	 else if(area==3)
    	 {
    		 System.out.println("you have come across a hot, dry desert");
    		 System.out.println(" explore desert?");
    		 System.out.println("\t1 yes");
    		 System.out.println("\t0 no");
    		  choice=input.nextInt();
    	 }
     */
     }
     else if(choice==4)
     {
    	 System.out.println("Would you like to remove an item in the inventory or hotbar?");
    	   System.out.println("1 - Inventory");
    	   System.out.println("0 - Hotbar");
    		   int j = input.nextInt();
    	   if (j==1)
    	   {
    		   System.out.print("Enter the row where you would like to remove the item:  ");
    		   System.out.print(" (0 to ");
    		   System.out.print(g1.getInventoryLength()-1+"):");
    		   int row = input.nextInt();
    		   System.out.println();
    		   System.out.print("Enter the column where you would like to remove the item:  ");
    		   System.out.print(" (0 to ");
    		   System.out.print(g1.getInventoryColumnLength()-1+"):");
    		   int col = input.nextInt();
    		   g1.deleteitem(row, col);
    		
    		   System.out.println("The item was successfully discarded.");
    		   g1.playerInfo();

    		   
    	   }
    	  
    	   else if(j==0)
    	   {
    		   System.out.print("Enter the row where you would like to remove the item:  ");
    		   System.out.print(" (0 to ");
    		   System.out.print(g1.getHotbarLength()-1+"):");
    		   int row = input.nextInt();
    		   g1.deleteitemhotbar(row);
    	    	System.out.println("The item was successfully discarded.");
    		   g1.playerInfo();

    	   } 
     }
     else if(choice==5)
     {
    	 g1.playerInfo();
    	 System.out.println("Is the item you'd like to move in the inventory or hotbar? ");
    	 System.out.println("1 - Inventory"
    	 		+ "\n0 - Hotbar");
    	 int we=input.nextInt();
    	 if(we==0)
    	 {
	   System.out.print("Enter the location of the item you want to move: (0-");
	   System.out.println(g1.getHotbarLength()-1+")");
	   int hotbar=input.nextInt();
	   System.out.println( "Would you like to move this item to the inventory or hotbar?");
	   System.out.println("1 - Inventory"
   	 		+ "\n0 - Hotbar");
	   int the =input.nextInt();
	   if(the==2)
	   {
	   System.out.print("Enter the row you want to move the item to: (0-");
	   System.out.println(g1.getHotbarLength()-1+")");
	   int hotbar2=input.nextInt();
	   g1.movehotbar(hotbar, hotbar2);
	 
	   }
	   if(the==1)
	   {
		   System.out.print("Enter the row you want to move the item to: (0-");
		   System.out.println(g1.getInventoryLength()-1+")");
	   int row=input.nextInt();
	   System.out.print("Enter the column you want to move the item to: (0-");
	   System.out.println(g1.getInventoryColumnLength()-1+")");
	   int col=input.nextInt();
	   g1.moveinventorytohotbar(row, col, hotbar);
	   g1.setslotdown();
	   g1.setleftup();
	   }
    	 }
    	 else if(we==1)
    	 {
    		 System.out.print("Enter the row of the item you want to move: (0-");
    		 System.out.println(g1.getInventoryLength()-1+")");
    		   int row=input.nextInt();
    		   System.out.print("Enter the column of the item you want to move: (0-");
    		   System.out.println(g1.getInventoryColumnLength()-1+")");
    		   int col=input.nextInt();
    		   System.out.println( "Would you like to move the item to the hotbar or inventory?");
    		   System.out.println("1 - Inventory"
    	   	 		+ "\n2 - Hotbar");
    		   int the =input.nextInt();
    		   if(the==2)
    		   {
    		   System.out.print("Enter the location you want to move the item to: (0-");
    		   System.out.println(g1.getHotbarLength()-1+")");
    		   int hotbar2=input.nextInt();
    		   g1.moveinventorytohotbar(row, col, hotbar2);
    		   g1.setslotup();
    		   g1.setleftdown();
    		   }
    		   if(the==1)
    		   {
    			   System.out.print("Enter the row you want to move the item to: (0-");
    			   System.out.println(g1.getInventoryLength()-1+")");
    		   int row2=input.nextInt();
    		   System.out.print("Enter the column you want to move the item to: (0-");
    		   System.out.println(g1.getInventoryColumnLength()-1+")");
    		   int col2=input.nextInt();
    		 
    		   
    	    	 
    		   g1.moveinventory(row, col, row2, col2);
    		   }
    	 }
     }
     else
     {
    	 go=0;
    	
     }
   }
  
  
  if(end==0)
  {
   System.out.println("Thanks for playing!");
   x=0;
   Thread.sleep(3000);
  }
  else if(end==1)
  {
	  System.out.println("Play again?");
	  System.out.println("1 - Yes");
	  System.out.println("0 - No");
	  int play=input.nextInt();
	  if(play==1)
	  {
		  x=1;
		  inte=1;
	  }
	  else
	  {
		  x=0;
	  }
  }
  else
  {
   System.out.println("Thanks for playing\nThe end!");
   Thread.sleep(3000);
  }
	   }
   
	  
   }








public static void menu()
{
	System.out.println("");
	System.out.println("Menu");
	System.out.println("\t1 - Save game");
	System.out.println("\t2 - View player info");
	System.out.println("\t3 - Go to another area");
	System.out.println("\t4 - Remove item");
	System.out.println("\t5 - Move item");
}










	
		
	

		
		
	}


/*d
 *a
 *n
 *i
 *e
 *l
 *
 *w
 *a
 *s
 *
 *h
 *e
 *r
 *e
 */

