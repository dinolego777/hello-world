package game;

public class monsters
{
   private String monster_name;
   private String monster_type;
   private int monster_difficulty;
   private String monster_rarity;
   private boolean sleeping;
   private double health;
   public monsters(String monster_name, String monster_type, int monster_difficulty, String monster_rarity, int health)
   {
	  this.monster_name=monster_name;
	  this.monster_type=monster_type;
	  this.monster_difficulty=monster_difficulty;
	  this.monster_rarity=monster_rarity;
	  this.sleeping=false;
	  this.health=health;
   }
   
   public monsters(String monster_name, String monster_type, int monster_difficulty, String monster_rarity, boolean sleeping)
   {
	  this.monster_name=monster_name;
	  this.monster_type=monster_type;
	  this.monster_difficulty=monster_difficulty;
	  this.monster_rarity=monster_rarity;
	  this.sleeping=sleeping;
   }
   public String isSleeping()
   {
	   String y = null;
	   if(this.sleeping=true)
    {
    	 y = "This monster is asleep. Perhaps you should sneak away before it wakes.";
    }
    else
    {
    
    }
	   return"";
	
	
   }
   
   public void SetSleeping(boolean x)
   {
	   this.sleeping=x;
   }
   public String getmonsterinfo()
   {
	   System.out.println(monster_name+" health: "+health);
   return " ";
   }
   public void increase_Monsterhealth(double increase)
   {
   	health+=increase;
   }
   
   public void decrease_Monsterhealth(double decrease)
   {
   	health-=decrease;
   }
   public double getmonsterhealth()
   {
	  
   return health;
   }
}
