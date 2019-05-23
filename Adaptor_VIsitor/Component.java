
public class Component implements Visitor {
	public void visit(Engine engine){
		int listIndex = 3;
		String list[] = {"OK", "Overheat", "Knocking"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Engine : " + list[i]);
	}
	public void visit(Wheel wheel){
		int listIndex = 3;
		String list[] = {"low pressure", "OK","alignment needed"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Wheel : " + list[i]);
	}
	public void visit(Light light){
		int listIndex = 2;
		String list[] = {"bulb less bright", "bulb not working"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Light : " + list[i]);
	}
	public void visit(Propeller propeller){
		int listIndex = 3;
		String list[] = {"Normal", "Oil in Need", "Vibrating"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Propeller : " + list[i]);
	}
	public void visit(Wing wing){
		int listIndex = 3;
		String list[] = {"Left wing has vibration", "Right wing has vibration", "Normal"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Wing : " + list[i]);
	}
	public void visit(Tailwing tailwing){
		int listIndex = 3;
		String list[] = {"Left wing has vibration", "Right wing has vibration", "Normal"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Tail wing  : " + list[i]);
	}
	public void visit(Pressure pressure){
		int listIndex = 3;
		String list[] = {"Low", "Normal", "High"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Cabin Pressure : " + list[i]);
	}
	public void visit(WaterP water){
		int listIndex = 3;
		String list[] = {"weak", "normal", "strong"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Water jet : " + list[i]);
	}
	public void visit(Sonar sonar){
		int listIndex = 3;
		String list[] = {"Signal Week", "Normal", "Signal Strong"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Sonar : " + list[i]);
	}
	public void visit(Cabin cabin){
		int listIndex = 3;
		String list[] = {"Low", "Normal", "High"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Cabin Pressure : " + list[i]);
	}
	public void visit(Propeller2 propeller){
		int listIndex = 3;
		String list[] = {"Oil Check", "normal", "Wing Check"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Screw Propeller : " + list[i]);
	}
	public void visit(Radar radar){
		int listIndex = 3;
		String list[] = {"Range Check", "Normal", "Signal Weak"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Radar : " + list[i]);
	}
	public void visit(Navigator navigator){
		int listIndex = 3;
		String list[] = {"Satellite Mode", "Wifi Mode", "Map Check"};
		int i = (int) (Math.random()*(listIndex-1));
		System.out.println("Nautical Navigator : " + list[i]);
	}
}
