package game;

public class small_town
{
   private int building_number;
   private boolean trades;
   
   public small_town(int num_building, boolean trades)
   {
    this.building_number = num_building;
    this.trades = trades;
   }
   
   public small_town(int num_building)
   {
    this.building_number = num_building;
    this.trades = true;
   }
}
