import java.util.Deque;

/**
 * Created by lkorshunova on 22.11.15.
 */
public abstract class Token {
    abstract void proceed(Deque<Double> stack, Calculator calc);

    public static Token defineToken(String value) throws IllegalArgumentException {
        char c = value.charAt(0);
        if (c >= '0' && c <= '9') {
            return new Number(Integer.parseInt(value));
        } else if (c >= 'A' && c <= 'Z') {
            return new Reference(c - 'A', Integer.parseInt(value.substring(1)) - 1);
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
            return new Operator(Operator.OperatorTypeEnum.lookupSymbol(value));
        } else {
            throw new IllegalArgumentException("Wrong token type.");
        }
    }
}
