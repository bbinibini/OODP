
import java.util.Random;

public class AudioReparing extends Reparing{
	static String descriptions[] = {"speaker exchanged", "USB repaired", "CD changer repaired"};
	public AudioReparing(int number) {
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
        return "audio part, ";
    }
}

