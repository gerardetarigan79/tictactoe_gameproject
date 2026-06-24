import java.util.Random;

public class GameLogic {

    private char[] board;

    public GameLogic() {

        board = new char[9];

        for(int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }

    public boolean makeMove(int position, char symbol) {

        if(board[position] != ' ') {
            return false;
        }

        board[position] = symbol;
        return true;
    }

    public boolean checkWinner(char symbol) {

        int[][] wins = {

            {0,1,2},
            {3,4,5},
            {6,7,8},

            {0,3,6},
            {1,4,7},
            {2,5,8},

            {0,4,8},
            {2,4,6}
        };

        for(int[] combo : wins) {

            if(board[combo[0]] == symbol &&
               board[combo[1]] == symbol &&
               board[combo[2]] == symbol) {

                return true;
            }
        }

        return false;
    }

    public boolean isDraw() {

        for(char cell : board) {

            if(cell == ' ') {
                return false;
            }
        }

        return true;
    }

    public int computerMove() {

        Random random = new Random();

        while(true) {

            int move =
                random.nextInt(9);

            if(board[move] == ' ') {

                board[move] = 'O';
                return move;
            }
        }
    }
}