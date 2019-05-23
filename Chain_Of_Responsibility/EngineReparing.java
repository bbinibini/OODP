

import java.util.Random;

public class EngineReparing extends Reparing{
	static String descriptions[] = {"oil changed", "coolant supply", "timing belt adjusted"};
	public EngineReparing(int number) {
        super(number, descriptions[des()]);
    }

    protected boolean resolve(Problem problem) {
    	
        if (problem.getNumber() == number) {
            return true;
        } else {
            return false;
        }
    }
    
    public static int des(){
    	Random generator = new Random();
    	int i = generator.nextInt(3);
    	return i;
    }
    
    public String toString() {
        return "Engine part, ";
    }
}
