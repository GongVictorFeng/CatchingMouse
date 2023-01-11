//Student 1: Gong(Victor) Feng,300176400

import javax.swing.*;
import java.awt.*;

//this class is a inner view for user to play the game.
public class BoardUserInterface extends JPanel {

    //YOUR INSTANCE VARIABLES HERE
	private Cube[][] cubes;
	private JPanel[] panels;
	private GameState gameState;//a variable refer to the class GameState

    public BoardUserInterface(GameState gameState, GameLogic gameLogic) {
		//Your code goes here
		this.gameState=gameState;
		//declare a 2D array of cubes and a set of JPanels.
		cubes=new Cube[gameState.getSize()][gameState.getSize()];
		panels=new JPanel[gameState.getSize()];


		//this loop is key of this program, creating a 2D array of cubes corresponding to the data in GameState, and Create a set of JPanels,put the cubes in the same row
		//to a JPanels, if the row is even, shift the panel to left, if the row is odd, shift the panel to right. 
		for(int i=0;i<gameState.getSize();i++){
			panels[i]=new JPanel();
			if(i%2==0){
				panels[i].setLayout(new FlowLayout(FlowLayout.LEADING,10,5));
			}
			else{
				panels[i].setLayout(new FlowLayout(FlowLayout.TRAILING,10,5));
			}
			for(int j=0;j<gameState.getSize();j++){
				cubes[i][j]=new Cube(i,j,gameState.getCurrentStatus(i,j));
				cubes[i][j].addActionListener(gameLogic);
				panels[i].add(cubes[i][j]);
			}
		}

		//put those JPanels into BoardUserInterface and set Gridayout for it.
		this.setLayout(new GridLayout(gameState.getSize(),1,0,0));
		for(int i=0;i<gameState.getSize();i++){
			this.add(panels[i]);
		}

    }


    //updates the status of the board's cubes instances following the game state
	//calls setType() from the class Cube, as needed.
    public void update(){
		//Your code goes here
		int[][] newState=gameState.getState();
		for(int i=0;i<gameState.getSize();i++){
			for(int j=0;j<gameState.getSize();j++){
				cubes[i][j].setType(newState[i][j]);
			}
		}
    }

    public Cube[][] getCubes(){
    	return cubes;
    }

}
