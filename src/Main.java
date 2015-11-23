import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Main {
    public static void main(String args[ ]){
        try{
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String input;

            if ((input=br.readLine()) != null){
                String[] dimensions = input.split(" ");
                if (dimensions.length!= 2){
                    System.out.print("Wrong number of dimensions.");

                }
                try{
                    int x = Integer.parseInt(dimensions[0]);
                    int y = Integer.parseInt(dimensions[1]);
                    List<Token>[][] matrix = new ArrayList[x][y];
                    for (int i=0; i< x; i++){
                        for (int j=0;j<y; j++){
                            if((input=br.readLine())!=null){
                                String[] values = input.split(" ");
                                List<Token> tokens = matrix[i][j];
                                for (String value : values) {
                                    char c = value.charAt(0);
                                    if (c >= '0' && c <= '9') {
                                        Number num = new Number(Integer.parseInt(value));
                                        tokens.add(num);
                                    }else if (c >= 'A' && c <= 'Z') {
                                        Reference ref = new Reference();
                                        ref.setX(c - 'A');
                                        ref.setY(Integer.parseInt(value.substring(1))-1);
                                        tokens.add(ref);
                                    }else if (c == '+' || c == '-' || c == '*' || c == '/') {
                                        Operator op = new Operator(Operator.OperatorTypeEnum.lookupSymbol(value));
                                        tokens.add(op);
                                    }
                                }
                            }
                        }
                    }
                    Calculator calc = new Calculator();
                    List<Token>[][] result = calc.calculate(matrix);
                    for (int i = 0; i< x; i++){
                        for (int j = 0; j < y; j++){
                            System.out.print(String.format("%.5f", ((Number) result[i][j].get(0)).getValue()) + " ");
                        }
                        System.out.println();
                    }
                }catch(NumberFormatException e){
                    System.out.print("Token is not a number.");
                }
            }

        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
