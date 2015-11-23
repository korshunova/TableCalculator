import java.lang.IllegalArgumentException;
import java.util.Deque;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Reference implements Token {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void proceed(State state) {
        Deque<Reference> trace = state.getTrace();
        if(!trace.contains(this)){
            trace.push(this);
            Calculator calc = new Calculator();
            calc.getState().setTrace(trace);
            state.getStack().push(calc.calculate(state.getMatrix()[x][y]));
            trace.pop();
        }else{
            throw new IllegalArgumentException("There are cyclical references.");
        }
    }
}
