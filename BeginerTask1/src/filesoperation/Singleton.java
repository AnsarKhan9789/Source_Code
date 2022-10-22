package filesoperation;

public class Singleton {
   
    private static final Singleton single_instance = new Singleton();
  
    public String singletonName;
  
    private Singleton()
    {
    	singletonName = "Singleton Variable";
    }
  
    public static Singleton getInstance()
    {

        return single_instance;
    }
}
