package App;

import java.util.Arrays;

public class App {
    static String[][] inputMatrix = {
            {"*", "*", "*", "*", "*"},
            {"*", "@", "@", "@", "*"},
            {"*", "@", "*", "@", "*"},
            {"*", "@", "@", "@", "*"},
            {"*", "*", "*", "*", "*"}
    };

    public static void main(String[] args) {
        printMatrix("InputMatrix:", inputMatrix);
        String[][] scaledMatrix = scaleMatrix(inputMatrix, 2);
        printMatrix("OutputMatrix:", scaledMatrix);
    }

    static String[][] scaleMatrix(String[][] inputMatrix, int scaleFactor) {
        String[] newElArray = new String[scaleFactor];
        String[][] newRowArray = new String[scaleFactor][scaleFactor];
        return Arrays.stream(inputMatrix).flatMap((matrixRow) -> {
            String[] scaledRow = Arrays.stream(matrixRow).flatMap((el) -> Arrays.stream(newElArray).map((newEl) -> el)).toArray(String[]::new);
            return Arrays.stream(newRowArray).map((newRow) -> scaledRow);
        }).toArray(String[][]::new);

    }

    static void printMatrix(String message, String[][] matrix) {
        System.out.println(message);
        Arrays.stream(matrix).forEach((row) -> System.out.println(Arrays.toString(row)));
    }
}
