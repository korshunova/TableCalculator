import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Operator implements Token {
    @Override
    public void proceed(State state) {
        Deque<Double> stack = state.getStack();
        switch (type) {
            case INCREMENT: stack.push(stack.pop()+1);
            case DECREMENT: stack.push(stack.pop()-1);
            case ADDITION: stack.push(stack.pop() + stack.pop());
            case DIFFERENCE: stack.push(-(stack.pop()) + stack.pop());
            case MULTIPLICATION:stack.push(stack.pop() * stack.pop());
            case DIVISION: stack.push(1 / stack.pop() * stack.pop());
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

    public OperatorTypeEnum getType() {
        return type;
    }

    public void setType(OperatorTypeEnum type) {
        this.type = type;
    }
}
