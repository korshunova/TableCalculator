import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class State {
    private Deque<Double> stack;
    private Deque<Reference> trace;
    private List<Token>[][] matrix;

    public State() {
        stack = new ArrayDeque<>();
        trace = new ArrayDeque<>();
    }

    public Deque<Double> getStack() {
        return stack;
    }

    public void setStack(Deque<Double> stack) {
        this.stack = stack;
    }

    public Deque<Reference> getTrace() {
        return trace;
    }

    public void setTrace(Deque<Reference> trace) {
        this.trace = trace;
    }

    public List<Token>[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(List<Token>[][] matrix) {
        this.matrix = matrix;
    }
}
