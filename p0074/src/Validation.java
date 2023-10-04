
import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

    public static int inputIntegerNumber(String msg, String err, int min, int max) {
        int n;
        while (true) {
            System.out.print(msg);
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }

    public static int[][] inputMatrix(int n) {
        int row = inputIntegerNumber("Enter Row Matrix " + n + ": ", "Invalid, try again", 1, Integer.MAX_VALUE);
        int col = inputIntegerNumber("Enter Column Matrix " + n + ": ", "Invalid, try again", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = inputIntegerNumber("Enter Matrix" + n + "[" + (i + 1) + "][" + (j + 1) + "]: ", "Values of matrix must be the number", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        return matrix;
    }

    

}
