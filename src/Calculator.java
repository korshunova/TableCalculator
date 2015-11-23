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

    public Calculator(final Matrix matrix) {
        this.matrix = matrix;
        trace = new ArrayDeque<>();
    }

    public Matrix calculate() {
        for (int i = 0; i < matrix.getWidth(); i++) {
            for (int j = 0; j < matrix.getHeight(i); j++) {
                List<Token> res = new ArrayList<>();
                res.add(new Number(calculate(matrix.getCell(i, j))));
                matrix.setCell(i, j, res);
            }
        }
        return matrix;
    }

    public double calculate(List<Token> tokens){
        Deque<Double> stack = new ArrayDeque<>();
        for (Token token : tokens){
            token.proceed(stack, this);
        }
        Double result = stack.pop();
        if (result == null) {
            throw new IllegalStateException("Empty stack.");
        }
        return result;
    }
}
