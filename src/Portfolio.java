import java.util.ArrayList;
import java.util.List;

public class Portfolio {
	private ArrayList<Stock> myStocks;
	private double myLiquid;
	
	public ArrayList<Stock> portfolio(){
		myStocks = new ArrayList<Stock>();
		myLiquid = 0;
		return myStocks;
	}
	
	public void addLiquid(double liquid){
		this.myLiquid += liquid;
	}
	
	public void removeLiquid(double liquid){
		this.myLiquid -= liquid;
		if(this.myLiquid < 0){
			throw new IllegalArgumentException("liquid value cannot be negative");
		}
	}
	
	public void addStock(String name, double value, double shares){
		myStocks.add(new Stock(name, value, shares));
	}
	
	public double portfolioValue(){
		double value = 0;
		for(int i = 0; i<myStocks.size(); i++){
			value += myStocks.get(i).getTotalValue();
		}
		return value;
	}
	
	//adds liquid value, evenly subtracts from stocks
	public void sellStocks(int liquid){
		List<Double> percents = new ArrayList<Double>();//list of percentage of each stock
		List<Double> liquidPercents = new ArrayList<Double>();//amount of liquid per percentage
		double portfolioValue = this.portfolioValue();
		for (int i = 0; i < percents.size(); i++){
			//calculate percentage value of each stock in portfolio
			percents.add(myStocks.get(i).getTotalValue()/portfolioValue);
			liquidPercents.add(liquid * percents.get(i));
			this.myStocks.get(i).reduceShareValue(liquidPercents.get(i));
			this.myLiquid += liquidPercents.get(i);
		}
	}
}