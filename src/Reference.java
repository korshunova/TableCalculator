import java.util.Deque;

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
            double res = calc.calculate(x, y);
            stack.push(res);
            trace.pop();
        }else{
            throw new IllegalArgumentException("There are cyclical references.");
        }
    }
}
