package Chessboard;

import lombok.var;

import java.util.List;

public class Chessboard {

    static String[] column = {"A", "B", "C", "D", "E", "F", "G"};
    static String[] row = {"1", "2", "3", "4", "5", "6", "7", "8"};

    public static List<String> possibleFields;

    public static List<String> getPossibleFields() {
        for (int i = 0; i < column.length; i++) {
            for (int j = 0; j < row.length; j++) {
                var fieldCombination = column[i] + row[j];
                possibleFields.add(fieldCombination);
            }
        }
        return possibleFields;
    }



}
