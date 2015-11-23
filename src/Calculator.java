import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    public List<Token>[][] calculate(List<Token>[][] matrix){
        State state = new State();
        state.setMatrix(matrix);
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                List<Token> res = new ArrayList<>();
                res.add(new Number(calculate(matrix[i][j])));
                matrix[i][j] = res;
            }
        }
        return matrix;
    }

    public double calculate(List<Token> tokens){
        for (Token token : tokens){
            token.proceed(state);
        }
        return state.getStack().pop();
    }
}
