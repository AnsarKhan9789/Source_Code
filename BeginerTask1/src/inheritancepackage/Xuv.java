package inheritancepackage;

public class Xuv extends Car {
public int seats, airBags;
public String model, color;
Xuv(){
	super("str");
}


public int getSeats()
{
return 	seats;
}
public void setSeats(int seats) {
	this.seats=seats;
}
public int getAirBags()
{
return 	airBags;
}
public void setAirBags(int airBags) {
	this.airBags=airBags;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model=model;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color=color;
}
}
