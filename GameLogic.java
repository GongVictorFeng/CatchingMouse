//Student 1: Gong(Victor) Feng,300176400

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;

//This class implements the interface ActionListener so that it is called when the player makes a move. 
//It calculates the next step of the game
//It updates state and userInterface.


public class GameLogic implements ActionListener {

 // ADD YOUR INSTANCE VARIABLES HERE
  private boolean start=false;
  private GameState game;//a variable refer to GameState
  private GameUserInterface frame;//a variable refer to GameUserInterface


  public GameLogic(int size) { //The parameter size is the size of the board on which the game will be played
	// YOUR CODE HERE
	// It creates the game's userInterface and the game's state instance

    game=new GameState(size);
    frame=new GameUserInterface(game,this);
  }  



  
    /**
     * Starts the game
     */
  public void start(){
	// YOUR CODE HERE
      start=true;
    }

 
    /**
     * resets the game
     */
  public void reset(){
	// YOUR CODE HERE
      frame.dispose();
      game=new GameState(game.getSize());
      frame=new GameUserInterface(game,this);
    }

  public void actionPerformed(ActionEvent e) {
	//the logic of the game goes in this method        
	// YOUR CODE HERE
    Cube clickedCube;
    int row=0;
    int column=0;
    BoardUserInterface board=frame.getBoardUserInterface();

    //check which button was click by user, if it is reset, reset the game; if it is quite, exit the system; if it is cube, cast it to a cube.
    if(e.getSource()==frame.getReset()){
      reset();
    }

    else if(e.getSource()==frame.getQuit()){
      frame.dispose();
      System.exit(0);
    }
    else{
      clickedCube=(Cube)e.getSource();
      column=clickedCube.getColumn();
      row=clickedCube.getRow();
    }

    //check the surrounding of the clicked Cube, if there is a snake next to clicked cube.
    if(isNextToSnake(row,column)){
      //if it is next to a snake and it is a box, turn it to snake
      if(game.getCurrentStatus(row,column)==0){
        game.select(row,column);
        game.getRandomMouse();
        board.update();
        
        //check if the mouse is in the edge of board.
        if(game.getCurrentCube().getX()==0||game.getCurrentCube().getY()==0||game.getCurrentCube().getX()==game.getSize()-1||game.getCurrentCube().getY()==game.getSize()-1){
          JFrame message=new JFrame();
          //create a ConfirmDialog
          int yesNo=JOptionPane.showConfirmDialog(message, "You lose, do you want to continue playing?",null,JOptionPane.YES_NO_OPTION);
          if(yesNo==0){
            reset();
          }
          else{
            frame.dispose();
            System.exit(0);
          }
        }
      }

      //check if the user catches the mouse.
      else if(game.getCurrentStatus(row,column)==2){
        JFrame message=new JFrame();
        JOptionPane.showMessageDialog(message, "You win");
        reset();
      }
    }
  }
  //method to check if there is a snake next to a button.
  public boolean isNextToSnake(int row,int column){
    if(row%2==0){
      if(game.getCurrentStatus(row,column+1)==1||game.getCurrentStatus(row,column-1)==1||game.getCurrentStatus(row+1,column)==1||game.getCurrentStatus(row-1,column)==1||
        game.getCurrentStatus(row+1,column-1)==1||game.getCurrentStatus(row-1,column-1)==1){
        return true;
      }
      else{
        return false;
      }
    }
    else{
      if(game.getCurrentStatus(row,column+1)==1||game.getCurrentStatus(row,column-1)==1||game.getCurrentStatus(row+1,column)==1||game.getCurrentStatus(row-1,column)==1||
        game.getCurrentStatus(row+1,column+1)==1||game.getCurrentStatus(row-1,column+1)==1){
        return true;
      }
      else{
        return false;
      }
    }
  }

 
}

