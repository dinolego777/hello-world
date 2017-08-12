package game;

public class dungeon
{
   
	private int danger;
	private int reward;
	private String dungeon_name;
    
    public dungeon(int reward, String name, int danger)
    {
    	
    	this.reward =reward;
    	this.dungeon_name=name;
    	this.danger = danger;
    }
    
    public dungeon(int reward, String name)
    {
    	
    	this.reward =reward;
    	this.dungeon_name=name;
    	this.danger = 3;
    }
    
    
}
