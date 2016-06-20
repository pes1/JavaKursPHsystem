package PHUtskrift;

public class MainPH {

	public static void main(String[] args) {
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Magnus");
  
	} 

}//Class

class Tekniker {
	
	//Variables
	private String namn;
	
	//Methods
	
	@Override
	public String toString() {
		return "tekniker" + getNamn();
	}
	
	public String getNamn() {
		return namn;
	}
	
	
}//Class
