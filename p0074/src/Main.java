
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (!checkForAddAndSub(matrix1, matrix2)) {
            return null;
        }
        int row = getRow(matrix1);
        int col = getCol(matrix1);
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (!checkForAddAndSub(matrix1, matrix2)) {
            return null;
        }
        int row = getRow(matrix1);
        int col = getCol(matrix1);

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (!checkForMulti(matrix1, matrix2)) {
            return null;
        }
        int row1 = getRow(matrix1);
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        int col2 = getCol(matrix2);

        int[][] result = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < row2; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void calculatorMatrix(int choice) {
        int[][] matrix1, matrix2;
        int[][] result;
        switch (choice) {
            case 1:
                System.out.println("-------Addition------");
                matrix1 = Validation.inputMatrix(1);
                matrix2 = Validation.inputMatrix(2);
                result = additionMatrix(matrix1, matrix2);
                if (result == null) {
                    System.err.println("Cannot add 2 matrix");
                    return;
                } else {
                    displayResultMatrix(matrix1, matrix2, result, '+');
                }
                break;
            case 2:
                System.out.println("-------Subtraction------");
                matrix1 = Validation.inputMatrix(1);
                matrix2 = Validation.inputMatrix(2);
                result = subtractionMatrix(matrix1, matrix2);
                if (result == null) {
                    System.err.println("Cannot sub 2 matrix");
                    return;
                } else {
                    displayResultMatrix(matrix1, matrix2, result, '-');
                }
                break;
            case 3:
                System.out.println("-------Multiplication------");
                matrix1 = Validation.inputMatrix(1);
                matrix2 = Validation.inputMatrix(2);
                result = multiplicationMatrix(matrix1, matrix2);
                if (result == null) {
                    System.err.println("Cannot multi 2 matrix");
                    return;
                } else {
                    displayResultMatrix(matrix1, matrix2, result, '*');
                }
                break;
        }
    }

    public static boolean checkForAddAndSub(int[][] matrix1, int[][] matrix2) {
        int row1 = getRow(matrix1);
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        int col2 = getCol(matrix2);
        if (row1 == row2 && col1 == col2) {
            return true;
        }
        return false;
    }

    public static boolean checkForMulti(int[][] matrix1, int[][] matrix2) {
        int col1 = getCol(matrix1);
        int row2 = getRow(matrix2);
        if (col1 == row2) {
            return true;
        }
        return false;
    }

    public static int getRow(int[][] matrix) {
        return matrix.length;
    }

    public static int getCol(int[][] matrix) {
        return matrix[0].length;
    }

    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static void displayResultMatrix(int[][] matrix1, int[][] matrix2, int[][] result, char msg) {
        System.out.println("----------Result-----------");
        displayMatrix(matrix1);
        System.out.println(msg);
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    public static void menu() {
        while (true) {
            System.out.println("=========Calculator program=========");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            int choice = Validation.inputIntegerNumber("Entere your choice: ", "Invalid, try again", 1, 4);
            switch (choice) {
                case 1:
                    calculatorMatrix(1);
                    break;
                case 2:
                    calculatorMatrix(2);
                    break;
                case 3:
                    calculatorMatrix(3);
                    break;
                case 4:
                    System.out.println("Exit program");
                    return;
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
