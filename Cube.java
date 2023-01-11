//Student 1: Gong(Victor) Feng,300176400

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;


/********************************************************************
 * The Cube is a type of JButton that represents a cube in the game 
*********************************************************************/

public class Cube extends JButton {

    // ADD YOUR INSTANCE VARIABLES HERE
    private int type;
    private int row;
    private int column;
    private final ImageIcon mouse=new ImageIcon("square-2.png");
    private final ImageIcon snake=new ImageIcon("square-1.png");
    private final ImageIcon box=new ImageIcon("square-0.png");

    /**
     * Constructor*/

    public Cube(int row, int column, int type) {
		//YOUR CODE HERE
        this.type=type;
        this.row=row;
        this.column=column;

        //set size and Icon for every cube
        this.setPreferredSize(new Dimension(40,40));
        if(type==2){
            this.setIcon(mouse);
        }
        else if(type==1){
            this.setIcon(snake);
        }
        else{
            this.setIcon(box);
        }

    }


     //Sets the type of a square. 
	 //sets the icon of the square.
    public void setType(int type) {
		//Your code here
        this.type=type;
        if(type==2){
            this.setIcon(mouse);
        }
        else if(type==1){
            this.setIcon(snake);
        }
        else{
            this.setIcon(box);
        }
    }

 
    // Getter method for the attribute row.
    public int getRow() {
		return row;//REPLACE THIS LINE WITH YOUR CODE 
    }

    //Getter method for the attribute column.
    public int getColumn() {
		return column;//REPLACE THIS LINE WITH YOUR CODE 
    }
}
