import javax.swing.*;
import java.awt.*;

public class TicTacToeFrame extends JFrame implements TicTacToeView{


    private JButton[][] buttons;
    private TicTacToeModel model = new TicTacToeModel();

    public TicTacToeFrame(){
        super("Tic Tac Toe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(TicTacToeModel.SIZE, TicTacToeModel.SIZE));

        model.addTicTacToeView(this);

        buttons = new JButton[TicTacToeModel.SIZE][TicTacToeModel.SIZE];

        //TicTacToeController tttc = new TicTacToeController(model);

        for (int i = 0; i < TicTacToeModel.SIZE; i++) {
            for (int j = 0; j < TicTacToeModel.SIZE; j++) {
                JButton b = new JButton(" ");
                b.setActionCommand(i + " " + j);
                buttons[i][j] = b;
                int x = i;
                int y = j;
                b.addActionListener(e -> model.play(x,y));
                this.add(b);
            }
        }
        this.setSize(300,300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TicTacToeFrame();
    }

    @Override
    public void update(TicTacToeEvent ticTacToeEvent) {
        String label = ticTacToeEvent.isTurn()? "X" : "O"; //Ternary opertator
        buttons[ticTacToeEvent.getX()][ticTacToeEvent.getY()].setText(label);

        if (model.getStatus() == TicTacToeModel.Status.X_WON){
            JOptionPane.showMessageDialog(this,"X won!");
        }
        else if(model.getStatus() == TicTacToeModel.Status.O_WON){
            JOptionPane.showMessageDialog(this,"O won!");
        }
        else if(model.getStatus() == TicTacToeModel.Status.TIE){
            JOptionPane.showMessageDialog(this, "It's a tie!");
        }
    }
}
