
public class function {
	public void speed(String name, int max){
		
		int speed = (int)(Math.random()*(max-10)) + 10 ;  //10~i
		System.out.print(name + ": " + speed +"km/h -> ");
		
//		speed = (int)Math.random()*i + speed;
		speed = (int)(Math.random()*(max-speed)) + speed;
		System.out.print(speed + "km/h -> ");
		
		speed = (int)(Math.random()*(max-speed))+ speed;
		System.out.print(speed + "km/h -> ");
		
		speed = (int)(Math.random()*(max-speed))+ speed;
		System.out.println(speed + "km/h");
	}
	
	public void height(String name, int min, int max){
		int speed = (int)(Math.random()*(max-min)) + min ;  //min~i
		System.out.print(name + ": " + speed +"m -> ");
		
		
		speed = (int)(Math.random()*(max-speed)) + speed;
		System.out.print(speed + "m -> ");
		speed = (int)(Math.random()*(max-speed)) + speed;
		System.out.print(speed + "m -> ");
		speed = (int)(Math.random()*(max-speed)) + speed;
		System.out.println(speed + "m");
	}
}

