

import java.util.Random;

public class LightReparing extends Reparing{
	static String descriptions[] = {"headlight replaced", "signal light replaced", "brake light replaced"};
	public LightReparing(int number) {
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
        return "light part, ";
    }
}

