/* this.frequency = frequency;
        N = 44100 / frequency;
        int N2 = (int) Math.ceil(N);
        buffer = new RingBuffer(N2);
        for (int i = 0; i < N; i++) {
            buffer.enqueue(0);
        }*/

/*************************************************************************
 * Name:
 *  This is a template file for GuitarString.java. It lists the constructors
 *  and methods you need, along with descriptions of what they're supposed
 *  to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 *****************************************************************************/

public class GuitarString {

    private RingBuffer buffer; // ring buffer
    // YOUR OTHER INSTANCE VARIABLES HERE
    private double frequency;
    private double[] init;
    private double N;
    private double samplingrate = 44100;
    private int ticCalls;

    // create a guitar string of the given frequency
    public GuitarString(double frequency) {
        this.frequency = frequency;
        N = 44100 / frequency;
        int N2 = (int) Math.ceil(N);
        buffer = new RingBuffer(N2);
        for (int i = 0; i < N; i++) {
            buffer.enqueue(0);
        }

    }

    // create a guitar string with size & initial values given by the array
    public GuitarString(double[] init) {
        this.buffer = new RingBuffer(init.length);
        for (int i = 0; i < init.length; i++) {
            buffer.enqueue(init[i]);
        }
    }

    // pluck the guitar string by replacing the buffer with white noise
    public void pluck() {
        for (int i = 0; i < N; i++) {
            buffer.dequeue();
            buffer.enqueue(Math.random() - 0.5);
        }
       /* int size = buffer.size();
        for (int i = 0; i <= size; i++) {
            buffer.dequeue();
        }

        for (int i = 0; i < size; i++) {
            int n = i;
            if ((int) (Math.random() * 2) == 1) {
                n = -1;
            }
            buffer.enqueue(Math.random() * .5 * n);
        }*/
    }

    // advance the simulation one time step
    public void tic() {
        double first = buffer.dequeue();
        double second = buffer.peek();
        buffer.enqueue((double) (.994 * (0.5) * (first + second)));
        ticCalls++;
    }

    // return the current sample
    public double sample() {
        return buffer.peek();
    }

    // return number of times tic was called
    public int time() {
        return ticCalls;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double[] samples = {.2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3};
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < N; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }

}
