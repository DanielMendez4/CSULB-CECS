package week11;

public class Stopwatch {
	
	private long start;
    private long now;
    
    /**
     * Initializes a new stop watch.
     */
    public Stopwatch() {
        start = 0;
        now = 0;
    } 

    public void start() {
    	start = System.currentTimeMillis();
    }
    
    public void stop() {
    	now = System.currentTimeMillis();
    }

    public void reset() {
    	start = 0;
    	now = 0;
    }
    
    /**
     * Returns the elapsed CPU time (in seconds) since the stop watch was created.
     *
     * @return elapsed CPU time (in seconds) since the stop watch was created
     */
    public double elapsedTime() {
        
        return (now - start) / 1000.0;
    }
}
