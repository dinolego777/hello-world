package game;

public class trading_village 
{
	private String trader_types;
	private  int[][] trade;
	private String trader_name;
	
	public trading_village(int number_col,int number_rows, String trader_name)
	{
		trade= new int[number_col][number_rows];
		this.trader_name=trader_name;
	}
	
	 
}