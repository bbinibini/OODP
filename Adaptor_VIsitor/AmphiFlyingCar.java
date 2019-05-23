import java.util.Scanner;
public class AmphiFlyingCar {
	public static Element[] LandList= {new Engine(), new Wheel(), new Light()};
	public static Element[] AirList = {new Propeller(), new Wing(), new Tailwing(), new Pressure()};
	public static Element[] SubmarineList = { new WaterP(), new Sonar(), new Cabin()};
	public static Element[] WaterList = {new Propeller2(), new Radar(), new Navigator()};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   	String m = "";
    	Scanner scan = new Scanner(System.in);
    	Vehicle vehicle;

    	while(!m.toUpperCase().equals("E")){
    		Element[] list = {};
    		System.out.println("\n-----------------------");
			System.out.println("Choose the mode of your car");
			System.out.println("(L)and (A)ir (W)ater (S)ubmarine (E)xit");
			System.out.println("-----------------------" +"\n");
    	 
	    	 try{
	    		 m = scan.next();
	    		 scan.nextLine();
	         }catch(Exception e){
	        	 System.out.println("잘 못 입력하셨습니다.");
	        	 break;
	         }
	    	 
	    	 String M = m.toUpperCase();
	    	 if(M.equals("L")) {
	    		 vehicle = new LandAdaptor();
	    		 list = LandList;
	    	 }
	    	 else if(M.equals("A")) {
	    		 vehicle = new AirAdaptor();
	    		 list = AirList;
	    	 }
	    	 else if(M.equals("S")) {
	    		 vehicle = new SubmarineAdaptor();
	    		 list = SubmarineList;
	    	 }
	    	 else if(M.equals("W")) {
	    		 vehicle = new WaterAdaptor();
	    		 list = WaterList;
	    	 }
	    	 else if(M.equals("E")) continue;
	    	 else {System.out.println("wrong input"); continue; }
	    	 
	    	 vehicle.wings();
	    	 vehicle.operate();
	    	 vehicle.Height();
	    	 vehicle.wheels();
	    	 vehicle.start();
	    	 vehicle.speed();
	    	 
	    	 System.out.println("\nChecking functionalities : ");
	    	 Visitor visitor = new Component();
	    	 for (int i=0; i<list.length; i++){
	    		 list[i].accpet(visitor);;
	    	 }
		}
    	scan.close();
	}
}
