

import java.util.Random;

public class TireReparing extends Reparing{
	static String descriptions[] = {"flat tire repaired", "front tire replaced", "wheel alignment"};
	public TireReparing(int number) {
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
        return "Tire part, ";
    }
}

