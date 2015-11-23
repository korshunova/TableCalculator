import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Main {
    public static void main(String args[ ]){
        try{
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            Matrix matrix = Matrix.read(br);
                    Calculator calc = new Calculator();
                    List<Token>[][] result = calc.calculate(matrix);
                   new Matrix(result).print();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
