package LeetCode_Easy;

public class LeetCode_999_AvailableCapturesforRook {

    //board.length == board[i].length == 8
    //board[i][j] is either 'R', '.', 'B', or 'p'
    //There is exactly one cell with board[i][j] == 'R'
    public static void main(String[] args) {
        System.out.println(numRookCaptures(new char[][]{
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'b', '.', '.', '.', '.'},
                new char[]{'.', 'w', 'b', 'R', 'b', 'b', '.', 'p'},
                new char[]{'.', '.', '.', 'b', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 's', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', 'p', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.'}}));
    }

    public static int numRookCaptures(char[][] board) {
        int[] rook = extractRook(board);
        int n = availableCapture(board, rook, 'n');
        int s = availableCapture(board, rook, 's');
        int e = availableCapture(board, rook, 'e');
        int w = availableCapture(board, rook, 'w');
        return n + s + e + w;
    }

    private static int availableCapture(char[][] board, int[] rook, char direction) {
        if (direction == 'n') {
            for (int n = rook[0] - 1; n >= 0; n--) {
                char temp = board[n][rook[1]];
                if (temp == 'p') {
                    return 1;
                } else if (temp == 'B') {
                    return 0;
                }
            }
        } else if (direction == 'e') {
            for (int e = rook[1] + 1; e < 8; e++) {
                char temp = board[rook[0]][e];
                if (temp == 'p') {
                    return 1;
                } else if (temp == 'B') {
                    return 0;
                }
            }
        } else if (direction == 's') {
            for (int s = rook[0] + 1; s < 8; s++) {
                char temp = board[s][rook[1]];
                if (temp == 'p') {
                    return 1;
                } else if (temp == 'B') {
                    return 0;
                }
            }
        } else if (direction == 'w') {
            for (int w = rook[1] - 1; w >= 0; w--) {
                char temp = board[rook[0]][w];
                if (temp == 'p') {
                    return 1;
                } else if (temp == 'B') {
                    return 0;
                }
            }
        }
        return 0;
    }

    private static int[] extractRook(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
