package filesoperation;

public class PojoForFiles {
	
private String name;
private int age;

public PojoForFiles() {
	
}
public PojoForFiles(String name,int age) {
	this.name=name;
	this.age=age;
	
}
public String toString() {
	StringBuilder returnVar=new StringBuilder();
	returnVar.append(this.name);
	returnVar.append(this.age);
	String returnVari=returnVar.toString();  //this.name+" "+this.age;//thoo -- instead of concat i use StringBuilder
	return returnVari;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
