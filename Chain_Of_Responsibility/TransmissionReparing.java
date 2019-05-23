

import java.util.Random;

public class TransmissionReparing extends Reparing{
	static String descriptions[] = {"exchanged", "front tire replaced", "wheel alignment"};
	public TransmissionReparing(int number) {
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
        return "transmission, ";
    }
}

