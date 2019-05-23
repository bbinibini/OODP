
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	int m = 0;
    	Scanner scan = new Scanner(System.in);
    	

    	while(m != 7){
    		System.out.println("-----------------------");
			System.out.println("Select the problem");
			System.out.println("1. engine problem");
			System.out.println("2. tire exchange");
			System.out.println("3. transmission");
			System.out.println("4. scratch, dent ,body");
			System.out.println("5. light problem");
			System.out.println("6. audio problem");
			System.out.println("7. quit");
			System.out.println("-----------------------" +"\n");
    	 
	    	 try{
	    		 m = scan.nextInt();
	    		 scan.nextLine();
	         }catch(Exception e){
	        	 System.out.println("잘 못 입력하셨습니다.");
	        	 break;
	         }
	    	 
	    	 Client client = new Client();
	    	 client.StartReparing(m);
	    	 
		}
	}
}
