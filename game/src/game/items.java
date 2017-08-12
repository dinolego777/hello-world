package game;

import java.io.Serializable;

public class items implements Serializable
{
  private String item_name;
  private double item_damage;
  private String item_rarity;
  private String item_type;
  
  public items(String name, int damage, String rarity, String type)
  {
   item_name = name;
   item_damage = damage;
   item_rarity = rarity;
   item_type = type;
  }
  
  public items(String name, double damage, String type)
  {
   item_name = name;
   item_damage = damage;
   item_rarity = "Common";
   item_type = type;
  }
  public String getItemName()
  {
	String name= item_name;
    return name;
  }
  public void setItemName(String item_name)
  {
   this.item_name = item_name;
  }
  
  public void SetItemdamage(int damage)
  {
	  item_damage+=damage;
  }
  
  public double getItemDamage()
  {
	double damage= item_damage;
    return damage;
  }
  
  public String GetItemRarity()
  {
   String rare = item_rarity;
   return rare;
  }
  
  public String GetItemType()
  {
	  String type = item_type;
	  return type;
  }
  
  
 
}
