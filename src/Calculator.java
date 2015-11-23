import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Calculator {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Matrix calculate(Matrix matrix) {
        State state = new State();
        state.setMatrix(matrix);
        List<Token>[][] content = matrix.getContent();
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                List<Token> res = new ArrayList<Token>();
                res.add(new Number(calculate(content[i][j])));
                content[i][j] = res;
            }
        }
        return matrix;
    }

    public double calculate(List<Token> tokens){
        for (Token token : tokens){
            token.proceed(state);
        }
        Double result = state.getStack().pop();
        if (result == null) {
            throw new IllegalStateException("Empty stack.");
        }
        return result;
    }
}
