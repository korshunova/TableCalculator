import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Calculator {
    private Matrix matrix;
    private Deque<Reference> trace;

    public Deque<Reference> getTrace() {
        return trace;
    }

    public Calculator(final Matrix matrix) {
        this.matrix = matrix;
        trace = new ArrayDeque<>();
    }

    public Matrix calculate() {
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(i); j++) {
                calculate(i, j);
            }
        }
        return matrix;
    }

    public double calculate(int x, int y) {
        Deque<Double> stack = new ArrayDeque<>();
        List<Token> tokens = matrix.getCell(x, y);
        for (Token token : tokens){
            token.proceed(stack, this);
        }
        Double result = stack.pop();
        if (result == null) {
            throw new IllegalStateException("Empty stack.");
        }
        List<Token> list = new ArrayList<>();
        list.add(new Number(result));
        matrix.setCell(x, y, list);
        return result;
    }
}
