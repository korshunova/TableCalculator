import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Matrix {
    private List<Token>[][] content;

    public Matrix(final List<Token>[][] content) {
        this.content = content;
    }

    public static Matrix read(BufferedReader br) throws IOException {
        String input;

        if ((input = br.readLine()) != null) {
            String[] dimensions = input.split(" ");
            if (dimensions.length != 2) {
                System.out.print("Wrong number of dimensions.");

            }
            int x = Integer.parseInt(dimensions[0]);
            int y = Integer.parseInt(dimensions[1]);
            List<Token>[][] matrix = new ArrayList[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if ((input = br.readLine()) != null) {
                        String[] values = input.split(" ");
                        List<Token> tokens = matrix[i][j];
                        for (String value : values) {
                            char c = value.charAt(0);
                            if (c >= '0' && c <= '9') {
                                Number num = new Number(Integer.parseInt(value));
                                tokens.add(num);
                            } else if (c >= 'A' && c <= 'Z') {
                                Reference ref = new Reference();
                                ref.setX(c - 'A');
                                ref.setY(Integer.parseInt(value.substring(1)) - 1);
                                tokens.add(ref);
                            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                                Operator op = new Operator(Operator.OperatorTypeEnum.lookupSymbol(value));
                                tokens.add(op);
                            }
                        }
                    }
                }
            }
            return new Matrix(matrix);
        }
        return new Matrix(new ArrayList[0][0]);
    }
    public void print() {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                System.out.print(String.format("%.5f", ((Number) content[i][j].get(0)).getValue()) + " ");
            }
            System.out.println();
        }
    }

}
