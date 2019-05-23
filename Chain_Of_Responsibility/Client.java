
public class Client{
	public int m;	
	Reparing engine     = new EngineReparing(1);
	Reparing tire    = new TireReparing(2);
	Reparing transmission     = new TransmissionReparing(3);
	Reparing audio     = new AudioReparing(6);
    Reparing light   = new LightReparing(5);
    Reparing body    = new BodyReparing(4);
	
    
    public Client(){
    	engine.setNext(tire).setNext(transmission).setNext(body).setNext(light).setNext(audio);
    }
    
	public final void StartReparing(int m){
		switch(m){
		    case 1: 
		    	engine.support(new Problem(1));
		        break;
		    case 2:
		    	engine.support(new Problem(2));
		        break;
		    case 3 :
		    	engine.support(new Problem(3));
		        break;
		    case 4: 
		    	engine.support(new Problem(4));
		        break;
		    case 5:
		    	engine.support(new Problem(5));
		        break;
		    case 6 : 
		    	engine.support(new Problem(6));
		        break;
		    case 7 :
		        System.out.println("quit");
		        break;    	            
		    default :
		        System.out.println("다시 입력해주세요");
		}
	}
}

