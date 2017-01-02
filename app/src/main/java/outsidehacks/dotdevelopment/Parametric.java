package outsidehacks.dotdevelopment;

/**
 * Created by varunjain on 11/30/16.
 */

public class Parametric {
    public int x[];
    public int y[];
    public int t[];
    public int nextIndex;
    public float lastx;
    public float lasty;
    public int start;
    public boolean newVal;

    public Parametric(int[] x, int[] y, int[] t, int start)    {
        this.x = x;
        this.y = y;
        this.t = t;
        this.start = start;
        this.nextIndex = 0;
        lastx = x[0];
        lasty = y[0];
    }

    public void updateCurrent() {
        while (nextIndex < t.length && t[nextIndex] + start <= MyView.elapsed)    {
            nextIndex++;
        }
        newVal = false;
       if (nextIndex < t.length && nextIndex > 0 && (MyView.elapsed - t[nextIndex - 1] - start) <= (t[nextIndex]- t[nextIndex - 1])) {
           lastx = (float)(x[nextIndex] - x[nextIndex - 1])*(MyView.elapsed - t[nextIndex - 1] - start)/(t[nextIndex]- t[nextIndex - 1]) + x[nextIndex - 1];
           lasty = (float)(y[nextIndex] - y[nextIndex - 1])*(MyView.elapsed - t[nextIndex - 1] - start)/(t[nextIndex]- t[nextIndex - 1]) + y[nextIndex - 1];
           newVal = true;
        }
    }

}
