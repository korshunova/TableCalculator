import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Operator extends Token {
    @Override
    public void proceed(Deque<Double> stack, Calculator calc) {
        System.out.println("operator: " + type.getSymbol());
        Double first = stack.pop();
        System.out.println("first: " + first);
        if (first == null) {
            throw new IllegalStateException("Empty stack.");
        }
        Double second = stack.peek();
        System.out.println("second: " + second);
        if (second == null && type != OperatorTypeEnum.INCREMENT && type != OperatorTypeEnum.DECREMENT) {
            throw new IllegalStateException("Empty stack.");
        }
        switch (type) {
            case INCREMENT: stack.push(first+1);
                break;
            case DECREMENT: stack.push(first-1);
                break;
            case ADDITION: stack.push(first + stack.pop());
                break;
            case DIFFERENCE:
                stack.push(stack.pop() - first);
                break;
            case MULTIPLICATION:stack.push(first * stack.pop());
                break;
            case DIVISION:
                stack.push(stack.pop() / first);
        }
    }

    public enum OperatorTypeEnum{
        ADDITION("+"), DIFFERENCE("-"), MULTIPLICATION("*"), DIVISION("/"), INCREMENT("++"), DECREMENT("--");

        private static final Map<String, OperatorTypeEnum> lookup = new HashMap<>();
        static {
            for(OperatorTypeEnum otEnum : EnumSet.allOf(OperatorTypeEnum.class))
                lookup.put(otEnum.getSymbol(), otEnum);
        }
        private String symbol;
        OperatorTypeEnum(String symbol){
            this.symbol = symbol;
        }
        public String getSymbol(){
            return symbol;
        }
        public static OperatorTypeEnum lookupSymbol(String symbol){
            return lookup.get(symbol);
        }
    }
    private OperatorTypeEnum type;

    public Operator(OperatorTypeEnum type) {
        this.type = type;
    }
}
