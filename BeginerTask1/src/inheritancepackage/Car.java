package inheritancepackage;

public class Car {
	
	 
	public int yearOfMake;
	
	public String engineNumber;
	
	public String type;
	
	
	public void maintanance() {
		System.out.println("Under Maintanance");
	}
	public Car(){
		
	}
	Car(String str){
		System.out.println(str);
	}
	//type
	public String getType() {
		return type;
	}
	public void setType(String typeOfCar) {
		this.type=typeOfCar;
		
	}
	//Engine
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber=engineNumber;
		
	}
	//Year
	  public int getYearOfMake() {
		    return yearOfMake;
		  }
		 public void setYearOfMake(int year) {
		    this.yearOfMake = year;
		  }

}
