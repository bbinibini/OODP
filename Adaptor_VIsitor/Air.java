public class Air extends function{
	private int maxspeed = 150;
	private int minheight = 10;
	private int maxheight = 500;
	
	public void VehicleWings(){
		System.out.println("Wings Extruding");
	}
	
	public void VehicleOperate(){
		System.out.println("Rotor Propeller Starting");
	};
	
	public void VehicleHeight(){
		height("Altimeter" , minheight, maxheight);
	};	
	
	public void VehicleWheels(){
		System.out.println("Wheels Concealed Inside");
	}
	
	public void startingnewfunction(){
		System.out.println("Starting Radar");
	}
	
	public void VehicleSpeed(){
		speed("Speed" ,maxspeed);
	}
}

//public abstract void wings();
//public abstract void wheels();
//public abstract void speed();