import static org.junit.Assert.*;
import org.junit.*;

public class TicTacToeModelTest {

    @org.junit.Test
    public void initialStatusMustBeUndecided() {
        TicTacToeModel m = new TicTacToeModel();
        assertEquals(TicTacToeModel.Status.UNDECIDED, m.getStatus());
    }

    @org.junit.Test
    public void testXWonRow() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(1,0);
        m.play(2,2);
        m.play(1,1);
        m.play(2,1);
        m.play(1,2);
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @org.junit.Test
    public void testXWonColumn() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        m.play(2,2);
        m.play(1,0);
        m.play(2,1);
        m.play(2,0);
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @org.junit.Test
    public void testXWonDiagonal() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0);
        m.play(2,0);
        m.play(1,1);
        m.play(2,1);
        m.play(2,2);
        assertEquals(TicTacToeModel.Status.X_WON, m.getStatus());
    }

    @org.junit.Test
    public void testOWonRow() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(1,1);
        m.play(2,0);
        m.play(0,1);
        m.play(2,1);
        m.play(1,2);
        m.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }

    @org.junit.Test
    public void testOWonColumn() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(1,1);
        m.play(0,0);
        m.play(0,1);
        m.play(1,0);
        m.play(1,2);
        m.play(2,0);
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }

    @org.junit.Test
    public void testOWonDiagonal() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(1,0);
        m.play(0,0);
        m.play(0,1);
        m.play(1,1);
        m.play(1,2);
        m.play(2,2);
        assertEquals(TicTacToeModel.Status.O_WON, m.getStatus());
    }


    @org.junit.Test
    public void testTie() {
        TicTacToeModel m = new TicTacToeModel();
        m.play(0,0); //x
        m.play(0,1); // o
        m.play(1,1);//x
        m.play(0,2);//o
        m.play(1,2);//x
        m.play(1,0);//o
        m.play(2,0);//x
        m.play(2,2);
        m.play(2,1);
        assertEquals(TicTacToeModel.Status.TIE, m.getStatus());
    }

}