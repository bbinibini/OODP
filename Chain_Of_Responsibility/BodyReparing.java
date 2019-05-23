

import java.util.Random;

public class BodyReparing extends Reparing{
	static String descriptions[] = {"scratch removed", "front dent restored", "door dent restored"};
	public BodyReparing(int number) {
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
        return "body part, ";
    }
}

