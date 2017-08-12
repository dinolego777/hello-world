package game;

public class Buildings {
	 private String building_name;
	 private String building_type;
	 private boolean building_trades;
	 private boolean open;
	 public Buildings(String building_name, String building_type,boolean building_trades)
	 {
		 this.building_name=building_name;
		 this.building_type=building_type;
		 this.building_trades=building_trades;
		 this.open=true;
	 }
	 
	 public Buildings(String building_name, String building_type)
	 {
		 this.building_name=building_name;
		 this.building_type=building_type;
		 this.building_trades=false;
	 }
	 
	 public void setOpen(boolean open)
	 {
		 this.open=open;
	 }
	 public String isOpen()
	  {
		 String x = null;
		 if(this.open=false)
		  {
			  x=" ";
		  }
		  else
		  {
			  x= "This shop looks closed i should come back later";
		  }
		  return x;
	  }
	  
	  
	}
