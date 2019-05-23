

public abstract class Reparing {
	protected int number;
	protected String description;
    private Reparing next;
    
    public Reparing(int number, String description) {
        this.number = number;
        this.description = description;
    }
    public Reparing setNext(Reparing next) {
        this.next = next;
        return next;
    }
    
    public final void support(Problem problem) {
        if (resolve(problem)) {
            done(problem);
        } else if (next != null) {
        	fail(problem);
        	System.out.print("->");
            next.support(problem);
        } else {
            fail(problem);
        }
    }

    protected abstract boolean resolve(Problem problem);
    protected void done(Problem problem) {
        System.out.println(this + description + "\n");
    }
    protected void fail(Problem problem) {
        System.out.println(this + "not solved");
    }
}
