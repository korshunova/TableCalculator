import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Reference extends Token {
    private int x;
    private int y;

    public Reference(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void proceed(Deque<Double> stack, Calculator calc) {
        Deque<Reference> trace = calc.getTrace();
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
