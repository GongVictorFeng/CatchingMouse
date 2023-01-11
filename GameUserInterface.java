//Student 1: Gong(Victor) Feng,300176400


import javax.swing.*;
import java.awt.*;

 /*the class GameUserInterface provides the user interface of the Game. It extends
 JFrame and lays out an instance of BoardUserInterface and  two instances of JButton: one to reset and the second the quit the game at any time.*/

public class GameUserInterface extends JFrame {

	private JButton reset;
	private JButton quit;
	// ADD YOUR INSTANCE VARIABLES HERE
	private BoardUserInterface myPanel; //a variable refer to BoardUserInterface.
 
    /* Constructor 
	 * initializes the board
     * takes as parameters the state of the game and the gameLogic */

    public GameUserInterface(GameState state, GameLogic gameLogic) {
		//Your code here
		//Create a frame, set the size, which is proportional to the cubes. 
		myPanel=new BoardUserInterface(state,gameLogic);

		this.setTitle("Catch the mouse");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(50*(state.getSize()+1),50*(state.getSize()+2));
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		//create a JPanel, and put button reset and quite into that JPanel, then put this panel on the bottom of the frame.
		JPanel bottomPanel=new JPanel();
		bottomPanel.setPreferredSize(new Dimension(50,50));
		this.add(bottomPanel,BorderLayout.SOUTH);

		reset=new JButton("reset");
		quit=new JButton("quit");
		reset.addActionListener(gameLogic);
		quit.addActionListener(gameLogic);
		bottomPanel.add(reset);
		bottomPanel.add(quit);
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.add(reset);
		bottomPanel.add(quit);

		//put BoardUserInterface into the frame.
		this.add(myPanel,BorderLayout.NORTH);
		

		this.setVisible(true);
	}

	//return reset
	public JButton getReset(){
		return this.reset;
	}
	//return quite
	public JButton getQuit(){
		return this.quit;
	}
	//return BoaardUserInterface
    public BoardUserInterface getBoardUserInterface(){
		//YOUR CODE HERE
		return myPanel;
   }

}
