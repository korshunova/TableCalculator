import java.util.Deque;

/**
 * Created by lkorshunova on 22.11.15.
 */
public interface Token {
    void proceed(State state);
}
