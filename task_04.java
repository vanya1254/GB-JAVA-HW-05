import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

public class task_04 {
    public static void main(String[] args) {
        List<List<String>> board = getEmptyBoard();
        System.out.println(board);
        showBoard(board);
        showBoard(get8QueensOnBoard(board));
    }

    public static List<List<String>> cloneList(List<List<String>> list) {
        List<List<String>> clone = new ArrayList<>(list.size());
                                                                        // создает клон списка списков строк
        for (List<String> item : list) {
            clone.add(item);
        }
        return clone;
    }


    public static boolean setQueen(List<List<String>> board, int cQ, int rQ, int count) {
        List<List<String>> cloneB = cloneList(board);

        if (cloneB.get(rQ).get(cQ).equals("■")) {
            cloneB.get(rQ).set(cQ, "Q");
            count++;
        } else return false;

        for (int i = 0; i < cloneB.size(); i++) {
            if (!cloneB.get(rQ).get(i).equals("Q")) {
                cloneB.get(rQ).set(i, "*");
            }
        }
        for (int i = 0; i < cloneB.size(); i++) {
            if (!cloneB.get(i).get(cQ).equals("Q")) {
                cloneB.get(i).set(cQ, "*");
            }
        }
        for (int i = 0; i < cloneB.size(); i++) {
            setDiag1(cloneB, cQ, rQ, i);
            setDiag2(cloneB, cQ, rQ, i);
        }
        board = cloneB;
        return true;
    }

    public static void setDiag1(List<List<String>> board, int cQ, int rQ, int ind) {
        try {
            if (!board.get(rQ - rQ + ind).get(cQ - rQ + ind).equals("Q")) {
                board.get(rQ - rQ + ind).set(cQ - rQ + ind, "*");
            }
        } catch (Exception e) {
        }
    }

    public static void setDiag2(List<List<String>> board, int cQ, int rQ, int ind) {
        try {
            if (!board.get(rQ - rQ + ind).get(rQ + cQ - ind).equals("Q")) {
                board.get(rQ - rQ + ind).set(rQ + cQ - ind, "*");
            }
        } catch (Exception e) {
        }
    }

    private static List<List<String>> get8QueensOnBoard(List<List<String>> emptyBoard) {
        
        Random rnd = new Random();
        int countQ = 0;

        List<List<String>> board = getEmptyBoard();
        while(countQ != 8){
            int colQ = rnd.nextInt(0, 8);
            int rowQ = rnd.nextInt(0, 8);
            
            if (!setQueen(board, colQ, rowQ, countQ)) {
                --countQ;
            }

            

            showBoard(board);
            
        }

        return emptyBoard;
    }

    private static void showBoard(List<List<String>> emptyBoard) {
        String[] columns = new String[] { "A", "B", "C", "D",
                "E", "F", "G", "H" };
        int rows = 8;

        System.out.println();
        for (List<String> row : emptyBoard) {
            System.out.printf("\t%d", rows--);               // печатает названия рядов
            for (String cell : row) {
                System.out.printf("  %s", cell);             // печатает саму доску
            }
            System.out.println();
        }
        System.out.printf("\t ");
        for (String col : columns) {                                // печатает названия столбцов
            System.out.printf("  %s", col);
        }
        System.out.println();
    }

    private static List<List<String>> getEmptyBoard() {
        List<List<String>> emptyBoard = new ArrayList<>();
        int countColRow = 8;

        for (int i = 0; i < countColRow; i++) {
            emptyBoard.add(new ArrayList<String>());
            for (int j = 0; j < countColRow; j++) {
                emptyBoard.get(i).add("■");                      // ■ ♕ ¤
            }
        }
        return emptyBoard;
    }
}