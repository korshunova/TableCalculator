import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class State {
    private Deque<Double> stack;
    private Deque<Reference> trace;
    private Matrix matrix;

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

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
