import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            Matrix result = calc.calculate(matrix);
            result.print();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
