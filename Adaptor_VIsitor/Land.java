public class Land extends function{
	private int maxspeed = 150;
	public void VehicleWings(){
		System.out.println("Wings folding into the body");
	}
	
	public void VehicleWheels(){
		System.out.println("Wheels ready on ground");
	}
	
	public void startingnewfunction(){
		System.out.println("Starting Engine");
	}
	
	public void VehicleSpeed(){
		speed("Speed" , maxspeed);
	}
}

//public abstract void wings();
//public abstract void wheels();
//public abstract void speed();