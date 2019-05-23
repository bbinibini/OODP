
public interface Visitor {
	public void visit(Engine engine);
	public void visit(Wheel wheel);
	public void visit(Light light);
	public void visit(Propeller propeller);
	public void visit(Propeller2 propeller);
	public void visit(Wing wing);
	public void visit(Tailwing tailwing);
	public void visit(Pressure pressure);
	public void visit(WaterP water);
	public void visit(Sonar sonar);
	public void visit(Cabin cabin);
	public void visit(Radar radar);
	public void visit(Navigator navigator);
}
