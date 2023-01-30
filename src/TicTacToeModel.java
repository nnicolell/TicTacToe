import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {


    public static final int SIZE = 3;
    public static final boolean X = true;
    public static final boolean O = false;

    public enum Status {X_WON, O_WON, TIE, UNDECIDED};

    private char[][] grid;
    private boolean turn;
    private Status status;

    private List<TicTacToeView> views;
    int numSquares;


    public TicTacToeModel() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
        turn = X;
        status = Status.UNDECIDED;
        views = new ArrayList<>();
        numSquares = 9;

    }

    public void addTicTacToeView(TicTacToeView v){
        views.add(v);
    }
    private void changeTurn() {
        turn = !turn;
    }

    public Status getStatus() {return status;}

    private void updateStatus(int row, int col) {
        int xc = 0, xr = 0, xd = 0, xd2 = 0;
        int oc = 0, or = 0, od = 0, od2 = 0;
        for (int i = 0; i<SIZE; i++){
            if (grid[i][col] == 'X'){xr++;}
            if(grid[row][i] == 'X'){xc++;}
            if (grid[i][i] == 'X'){xd++;}
            if (grid[i][SIZE - i -1] == 'X'){xd2++;}
            if (grid[i][col] == 'O'){or++;}
            if(grid[row][i] == 'O'){oc++;}
            if (grid[i][i] == 'O'){od++;}
            if (grid[i][SIZE - i - 1] == 'O'){od2++;}
        }
        if (xr == SIZE || xc == SIZE || xd == SIZE || xd2 == SIZE){
            status = Status.X_WON;
        }
        else if(or == SIZE || oc == SIZE || od == SIZE || od2 == SIZE){
            status = Status.O_WON;
        }

    }

    public boolean getTurn() {return turn;}

    public void play(int x, int y) {
        if (grid[x][y] != ' ') return;
        grid[x][y] = turn? 'X' : 'O';
        numSquares--;
        updateStatus(x,y);
        if (numSquares == 0){
            status = Status.TIE;
        }

        for (TicTacToeView v : views){v.update(new TicTacToeEvent(this, x,y,turn, status));}


        changeTurn();
    }
}

