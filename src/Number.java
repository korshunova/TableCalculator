import java.util.Deque;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Number extends Token {
    private double value;

    public Number(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public void proceed(Deque<Double> stack, Calculator calc) {
        stack.push(value);
    }
}
