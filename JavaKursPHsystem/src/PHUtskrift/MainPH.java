package PHUtskrift;

public class MainPH {

	public static void main(String[] args) {
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Hello world  !");
		System.out.println("Magnus");
		System.out.println("Lars is with you");
		//----
  
	} 

}//Class

class Tekniker {
	
	//Variables
	private String namn;
	
	//Constructor
	public Tekniker(String namn) {
		this.namn = namn;
	}
	
	//Methods
	
	@Override
	public String toString() {
		return "tekniker" + getNamn();
	}
	
	public String getNamn() {
		return namn;
	}
	
	
}//Class
