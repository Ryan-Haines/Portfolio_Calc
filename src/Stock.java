
public class Stock extends Main {
	private String myName;
	private double myValue; //in dollars
	private double myShares;
	
	public Stock(){
		this.myName = "noNameStock";
		this.myValue = 0;
		this.myShares = 0;
	}
	
	public Stock(String name, double value, double shares){
		this.myName = name;
		this.myValue = value;
		this.myShares = shares;
	}
	
	public void setName(String name){
		this.myName = name;
	}
	
	public void setValue(double value){
		this.myValue = value;
	}
	
	public void setShares(double shares){
		this.myShares = shares;
	}
	
	public String getName(){
		return this.myName;
	}
	
	//value of a single share
	public double getShareValue(){
		return this.myValue;
	}
	
	private double getShares(){
		return this.myShares;
	}
	
	//value of all shares of stock
	public double getTotalValue(){
		return (this.getShareValue() * this.getShares());
	}
	
	//reduce value per share
	public void reduceShareValue(double subtract){
		this.myValue = this.myValue - subtract;
		if (this.myValue < 0){
			throw new IllegalArgumentException("stock value cannot be negative");
		}
	}
	
	//increase value per share
	public void addShareValue(double add){
		this.myValue = this.myValue + add;
	}
	
	//add # shares to total equal to calculated value
	public void addValue(double add){
		this.myShares += (add/this.myValue);
	}
	
	//remove # shares equal to calculated value
	public void removeValue(double subtract){
		this.myShares -= (subtract/this.myValue);
		if (this.myShares < 0){
			throw new IllegalArgumentException("stock shares cannot be negative");
		}
	}
	
	//reduce # shares
	public void reduceShares(double subtract){
		this.myShares = this.myShares - subtract;
		if (this.myShares < 0){
			throw new IllegalArgumentException("stock shares cannot be negative");
		}
	}
	
	//add # shares
	public void addShares(double add){
		this.myShares = this.myShares + add;
	}
}
