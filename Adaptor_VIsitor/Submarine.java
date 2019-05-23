public class Submarine extends function{
	private int maxspeed = 60;
	private int minheight = 5;
	private int maxheight = 50;
	
	public void VehicleWings(){
		System.out.println("Wings Folding up");
	}
	
	public void VehicleOperate(){
		System.out.println("Operating water jet");
	};
	
	public void VehicleHeight(){
		height("Water Depth" , minheight, maxheight);
	};	
	
	public void VehicleWheels(){
		System.out.println("Wheels Concealed Inside");
	}
	
	public void startingnewfunction(){
		System.out.println("Sonar Started");
	}
	
	public void VehicleSpeed(){
		speed("Speed" , maxspeed);
	}
}

//public abstract void wings();
//public abstract void wheels();
//public abstract void speed();