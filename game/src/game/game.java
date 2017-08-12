package game;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.ArrayList;
public class game implements Serializable
{
	private String one=null;
	private String two=null;
    private String mode_difficulty;
   private  items[] hotbar;
    private items[][]inventory;
    private String player_name;
    private double player_level;
    private int left;
    private int slot;
    private double health;
    
    public game(String name, String gamemode)  throws IOException
    {
    	

    	player_name= name;
        mode_difficulty=gamemode;
          player_level = 0;
        if (mode_difficulty.equalsIgnoreCase("1"))
        {
           hotbar = new items[15];
           inventory = new items[3][15];
           health= 150;
        }
        else if(mode_difficulty.equalsIgnoreCase("2"))
        {
            hotbar = new items[10] ;
             inventory = new items[3][10];
             health=100;
        }
        else if(mode_difficulty.equalsIgnoreCase("3"))
        {
            hotbar = new items[5] ;
             inventory = new items[3][5];
             health=50;
        }
         slot=inventory.length*inventory[0].length;
         left= hotbar.length;
    }
    
     public game(String name)
     {
        player_name= name;
        mode_difficulty="2";
         player_level = 0;
         if (mode_difficulty.equalsIgnoreCase("1"))
         {
            hotbar = new items[15];
            inventory = new items[3][15];
            health= 150;
         }
         else if(mode_difficulty.equalsIgnoreCase("2"))
         {
             hotbar = new items[10] ;
              inventory = new items[3][10];
              health=100;
         }
         else if(mode_difficulty.equalsIgnoreCase("3"))
         {
             hotbar = new items[5] ;
              inventory = new items[3][5];
              health=50;
         }
          slot=inventory.length*inventory[0].length;
          left= hotbar.length;
     }
     
    
    
    public String playerInfo()
    {
     
       String info= "\nName: "+player_name+"\n"+
       "Player level: "+player_level+"\n"+
        "Inventory slots remaining: "+slot+"\n"+
        "Hotbar slots remaining: " +left +"\n"+
        "Health remaining: "+ gethealth()+"\n" ;
       GetHotbar();
       GetInventory();
       return info;
    }
    
    public double gethealth() {
		if(health<=0.0)
		return 0.0;
		else
			return health;
	}

	public String GetInventory()
    {
  
        
        
    	System.out.println("Inventory:");
        
        int inventory_row = 0;
        for(int row = 0; row<inventory.length;row++)
         {
        for(int  col= 0; col<inventory[0].length;col++)
        {
       
       if(inventory[row][col]!=null)
       {
        	System.out.print(inventory[row][col].getItemName()+"; Damage: "+inventory[row][col].getItemDamage()+"; Item Type: "+inventory[row][col].GetItemType()+" "+"; Inventory location: "+row+","+col);
        	
        	inventory_row++;
        	
       }
        }
        
         if(inventory_row>=inventory[0].length)
         {
        	 System.out.println("");
         }
         else
         {
         
        	 
         }
         inventory_row=0;
        }
         return "";
    }
    public String GetHotbar()
    {
    System.out.println();
    System.out.println("Hotbar:");
    
    for(int row = 0; row<hotbar.length;row++)
    {
    	
    	
    	if (hotbar[row]!=null)
    System.out.print(hotbar[row].getItemName()+"; Damage: "+hotbar[row].getItemDamage()+"; Item Type: "+hotbar[row].GetItemType()+"; Hotbar location: "+row);
    	
   
    	
    	
    }
    System.out.println(" ");
    return "";
}
    
    public int getInventoryLength()
    {
   	  return inventory.length;
    
    }
    public int getInventoryColumnLength()
    {
    return inventory[0].length;	
    
    }
    
    public int getHotbarLength()
    {
    	
    return hotbar.length;
    }
    
    public  void setInventory(items item, int row, int col)
    {
    	
    
    	if(inventory[row][col]==null)
    	{
    	inventory[row][col]=item;
    	setslotdown();
    	}
    	else
    	{
    		System.out.println("An item already occupies this slot.");
    		
    	}
    	
    	
    }
    
    public void setHotbar(items item, int col)
    {
    	if(hotbar[col]==null)
    	{
    	hotbar[col]=item;
    	setleftdown();
    	}
    	else
    	{
    		System.out.println("An item already occupies this slot.");
    	}
    }
    
    public void setleftdown()
    {
    	left--;
    }
    public void setslotdown()
    {
    	slot--;
    }
    public void setleftup()
    {
    	left++;
    }
    public void setslotup()
    {
    	slot++;
    }
    public String getDifficulty()
    {
    	return this.mode_difficulty;
    }
    
    public void levelUp(double increase)
    {
        player_level+=increase;
    }
    
    public void leveldown(double decrease)
    {
        player_level-=decrease;
    }
    
    public void increase_health(double increase)
    {
    	health+=increase;
    }
    
    public void decrease_health(double decrease)
    {
    	health-=decrease;
    }
    public void deleteitem(int row, int col)
    {
    	if (inventory[row][col]!=null)
    	{
    	inventory[row][col]=null;
    	slot++;
    	}
    	else
    		System.out.println("No item occupies this slot.");
    }
    public void deleteitemhotbar( int col)
    {
    	if (hotbar[col]!=null)
    	{
    	hotbar[col]=null;
    	left++;
    	}
    	else
    		System.out.println("No item occupies this slot.");
    }
    public double doDamage(int row)
    {
    	
    	return hotbar[row].getItemDamage();
    }
    public int emptyHotbar()
    {
    	if(hotbar.length-left==0)
    	{
    		return 0;
    	}
    	else
    	{
    		return hotbar.length-left;
    	}
    	
    }
    public items[][] save()
	{
    	try
    	{
    		FileOutputStream saveFile = new FileOutputStream("inventory.venture");

    		   
    		
    		ObjectOutputStream save = new ObjectOutputStream(saveFile);
    	
		save.writeObject(inventory);
		
    	}
    	catch(Exception exc){
			exc.printStackTrace(); 
		}
		return inventory;
		
		
    }
    public items[][] load() throws IOException
	{
    	 try{
    	 FileInputStream loadFile = new FileInputStream("inventory.venture");

 		
 		ObjectInputStream load = new ObjectInputStream(loadFile);
    	
 			
   		  inventory = (items[][]) load.readObject();
   		  
   		 
   		  }
   		  catch(Exception exc){
   				exc.printStackTrace();
   			}
   		  return inventory;
   	  }

    public items[] savehotbar()
   	{
       	try
       	{
       		FileOutputStream saveFile2 = new FileOutputStream("inventory2.venture");

       		   
       		
       		ObjectOutputStream save2 = new ObjectOutputStream(saveFile2);
       	
   		save2.writeObject(hotbar);
   		
       	}
       	catch(Exception exc){
   			exc.printStackTrace(); 
   		}
   		return hotbar;
   	}
    public items[] loadhotbar() throws IOException
   	{
      
       	 try{
       	 	 FileInputStream loadFile2 = new FileInputStream("inventory2.venture");

     		
     		ObjectInputStream load2 = new ObjectInputStream(loadFile2);
      		  hotbar = (items[]) load2.readObject();
      		  
      		 
      		  }
      		  catch(Exception exc){
      				exc.printStackTrace();
      			}
      		  return hotbar;
      	  }
  
    public double loadlevel() throws IOException
    {
      	 try{
       	 	 FileInputStream loadFile3 = new FileInputStream("level.venture");

     		
     		ObjectInputStream load3 = new ObjectInputStream(loadFile3);
      		  player_level = (double) load3.readObject();
      		 health = (double) load3.readObject();
      		 
      		  }
      		  catch(Exception exc){
      				exc.printStackTrace();
      			}
    	return health;
    	
    }
    public double savelevel()
   	{
       	try
       	{
       		FileOutputStream saveFile3 = new FileOutputStream("level.venture");

       		   
       		
       		ObjectOutputStream save3 = new ObjectOutputStream(saveFile3);
       	
   		save3.writeObject(player_level);
   		save3.writeObject(health);
       	}
       	catch(Exception exc){
   			exc.printStackTrace(); 
   		}
   		return health;
   	}
    public int loadleft() throws IOException
    {
      	 try{
       	 	 FileInputStream loadFile4 = new FileInputStream("level2.venture");

     		
     		ObjectInputStream load3 = new ObjectInputStream(loadFile4);
      		  left = (int) load3.readObject();
      		 slot = (int) load3.readObject();
      		 
      		  }
      		  catch(Exception exc){
      				exc.printStackTrace();
      			}
    	return left;
    	
    }
    public int saveleft()
   	{
       	try
       	{
       		FileOutputStream saveFile4 = new FileOutputStream("level2.venture");

       		   
       		
       		ObjectOutputStream save4 = new ObjectOutputStream(saveFile4);
       	
   		save4.writeObject(left);
   		save4.writeObject(slot);
       	}
       	catch(Exception exc){
   			exc.printStackTrace(); 
   		}
   		return left;
   	}
    public void movehotbar(int row, int row2)
    {
    	items hi=hotbar[row];
    	hotbar[row]= hotbar[row2];
    	hotbar[row2]= hi;
    }
    public void moveinventory(int row,int col, int row2,int col2)
    {
    	items hi=inventory[row][col];
    	inventory[row][col]= inventory[row2][col2];
    	inventory[row2][col2]= hi;
    }
    public void moveinventorytohotbar(int row,int col, int row2)
    {
    	items hi=inventory[row][col];
    	inventory[row][col]= hotbar[row2];
    	hotbar[row2]= hi;
    	
    }
	}
	

    
    
     
