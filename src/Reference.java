import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Reference extends Token {
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
            double res = calc.calculate(state.getMatrix().getCell(x, y));
            List<Token> list = new ArrayList<>();
            list.add(new Number(res));
            state.getMatrix().setCell(x, y, list);
            state.getStack().push(res);
            trace.pop();
        }else{
            throw new IllegalArgumentException("There are cyclical references.");
        }
    }
}
