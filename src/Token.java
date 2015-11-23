/**
 * Created by lkorshunova on 22.11.15.
 */
public abstract class Token {
    abstract void proceed(State state);

    public static Token defineToken(String value) throws IllegalArgumentException {
        char c = value.charAt(0);
        if (c >= '0' && c <= '9') {
            return new Number(Integer.parseInt(value));
        } else if (c >= 'A' && c <= 'Z') {
            Reference ref = new Reference();
            ref.setX(c - 'A');
            ref.setY(Integer.parseInt(value.substring(1)) - 1);
            return ref;
        } else if (c == '+' || c == '-' || c == '*' || c == '/') {
            return new Operator(Operator.OperatorTypeEnum.lookupSymbol(value));
        } else {
            throw new IllegalArgumentException("Wrong token type.");
        }
    }
}
