import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkorshunova on 22.11.15.
 */
public class Matrix {
    private List<Token>[][] content;

    private Matrix(final List<Token>[][] content) {
        this.content = content;
    }

    public int getWidth() {
        return content.length;
    }

    public int getHeight(int x) {
        return content[x].length;
    }

    public List<Token> getCell(int x, int y) {
        return content[x][y];
    }

    public void setCell(int x, int y, List<Token> val) {
        content[x][y] = val;
    }

    public static Matrix read(BufferedReader br) throws IllegalArgumentException, IOException {
        String input;

        if ((input = br.readLine()) == null) {
            throw new IllegalArgumentException("Empty input.");
        }
        String[] dimensions = input.split(" ");
        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Wrong number of dimensions.");
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
    public void print() {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                System.out.print(String.format("%.5f", ((Number) content[i][j].get(0)).getValue()) + " ");
            }
            System.out.println();
        }
    }

}
