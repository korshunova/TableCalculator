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
            Calculator calc = new Calculator(matrix);
            Matrix result = calc.calculate();
            result.print();
        }catch(IOException io){
            System.out.println("IO error");
        } catch (IllegalArgumentException e) {
            System.out.println("Argument Exception: " + e.getMessage());
        } catch (IllegalStateException ex) {
            System.out.println("Bad expression cause " + ex.getMessage());
        }
    }
}
