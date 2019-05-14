

public class Node {
private String name;
private String price;
private String money;
private String address;
private String url;
private String time;
	public Node(String name,String url) {
	this.name=name;
	this.price=this.price;
	this.money=this.money;
	this.address=this.address;
	this.url=url;
}
	public void SetName(String name) {
		this.name=name;
	}
	public void SetPrice(String price) {
		this.price=price;
	}
	public void SetMoney(String money) {
		this.money=money;
	}
	public void SetAddress(String address) {
		this.address=address;
	}
	public void SetTime(String time) {
		this.time=time;
	}
	
	public String GetName() {
		return this.name;
	}
	public String GetPrice() {
		return this.price;
	}
	public String GetMoney() {
		return this.money;
	}
	public String GetAddress() {
		return this.address;
	}
	public String GetTime() {
		return this.time;
	}
	public String Geturl() {
		return this.url;
	}
}
