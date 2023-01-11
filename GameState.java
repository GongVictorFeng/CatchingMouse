import java.util.Random;

//Student 1: Gong(Victor) Feng,300176400

//this class is a game model, which store the data of the game
public class GameState {


		//static final variables public
		public static final int FREE_CUBE = 0;
		public static final int SELECTED = 1;
		public static final int RED_CUBE = 2;
		public static final int MAX_SELECTED = 5;
		
		//non-final variables private
		private int boardSize;
		private Point redCube;
		// YOUR INSTANCE VARIABLES HERE
        private Point[] greenCube;
        private int[][] state;

    /**
     * Constructor 
	 * initializes the state to the size of board
     *  The parameter size is the size of the board
     */
    public GameState(int size) {
	// YOUR CODE HERE
        boolean isUnique=false;
        boardSize=size;
        Random random1=new Random();

        //choose one of the 4 or 9 central points as mouse
        int x=0;
        int y=0;
        if(size%2==0){
            x=random1.nextInt(2)+size/2 -1;
            y=random1.nextInt(2)+size/2 -1;
        }
        else{
            x=random1.nextInt(3)+size/2 -1;
            y=random1.nextInt(3)+size/2 -1;
        }
        //set this central point as mouse.
        redCube=new Point(x,y);

        //keep choosing 5 points as snake until we get 6 different points, 5 are snakes, one is mouse.
        Point[] snakesAndMouse=new Point[6];
        while(!isUnique){
            Point[] snakes=getSnakes(size);
            for(int i=0;i<snakes.length;i++){
                snakesAndMouse[i]=snakes[i];
            }
            snakesAndMouse[5]=redCube;

            isUnique=isUnique(snakesAndMouse);
        }
        
        //set 5 different points as snake
        Point[] uniqueSnakes=new Point[5];
        for(int i=0;i<uniqueSnakes.length;i++){
            uniqueSnakes[i]=snakesAndMouse[i];
        }
        greenCube=uniqueSnakes;

        //build up a 2D array about the type correspongding to the location of the points, if the point is mouse, 2 will be stored in this location; if the point is snake
        //1 wiill be stored in this location; if the point is box, 0 will be stored in this location.
        int[][] state=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                Point p=new Point(i,j);
                if(p.equals(redCube)){
                    state[i][j]=RED_CUBE;
                }
                else{
                    state[i][j]=FREE_CUBE;
                }

                for(Point cube:greenCube){
                    if(p.equals(cube)){
                        state[i][j]=SELECTED;
                    }
                }
            }
        }
        this.state=state;
    }

	//


    //return the size of the board
    public  int getSize(){
	//YOUR CODE HERE
		return boardSize;
   }

    /**
     * returns the current status (FREE_CUBE, SELECTED or RED_CUBE) of a given cube in the game
     * 
     * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     * return the status of the cube at location (i,j)
     */   
    public int getCurrentStatus(int i, int j){
        Point p1=new Point(i,j);
        if(p1.equals(redCube)){
            return RED_CUBE;
        }
        for(int k=0;k<greenCube.length;k++){
            if(p1.equals(greenCube[k])){
                return SELECTED;
            }
        }

		return FREE_CUBE;//REPLACE THIS LINE WITH YOUR CODE 
    }



    /**
     * Sets the status of the cube at coordinate (i,j) to SELECTED
     * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     */   
    public void select(int i, int j){
	//YOUR CODE HERE
        Point p=new Point(i,j);
        Point[] greenCube2=new Point[greenCube.length+1];
        for(int k=0;k<greenCube.length;k++){
            greenCube2[k]=greenCube[k];
        }
        greenCube2[greenCube.length]=p;

        greenCube=greenCube2;
        state[i][j]=SELECTED;
    }

    /**
     * Puts the red cube at coordinate (i,j). Clears the previous location 
     * of the red cube.
     *
      * i is the x coordinate of the cube
     * j is the y coordinate of the cube
     */   
    public void setCube(int i, int j){
	//YOUR CODE HERE
        Point p=new Point(i,j);
        int x,y;
        x=redCube.getX();
        y=redCube.getY();
        //set former mouse to box
        state[x][y]=FREE_CUBE;
        //set new mouse
        redCube=p;
        state[i][j]=RED_CUBE;
   }

    /* Getter method for the current red cube
     * return the location of the curent red cube */   
    public Point getCurrentCube(){
		return redCube;//REPLACE THIS LINE WITH YOUR CODE 
    }

    //choose 5 points as snake randomly 
    public static Point[] getSnakes(int size){
        Point[] snakes=new Point[5];
        int x,y;
        Random random1=new Random();
        for(int i=0;i<5;i++){
            x=random1.nextInt(size);
            y=random1.nextInt(size);
            snakes[i]=new Point(x,y);
        }
        return snakes;
    }
    //check if all points are different or there are the same points in the array
    public static boolean isUnique(Point[] snakeMouse){
        for(int i=0;i<snakeMouse.length-1;i++){
            for(int j=i+1;j<snakeMouse.length;j++){
                if(snakeMouse[i].equals(snakeMouse[j])){
                    return false;
                }
            }
        }
        return true;
    }

    //return the matrix of points' type 
    public int[][] getState(){
        return state;
    }
    //keep choosing a point as mouse until we get a point which is not snake.
    public void getRandomMouse(){
        int x,y;
        boolean noSnake=false;
        while(!noSnake){
            Random random1=new Random();
            x=random1.nextInt(boardSize);
            y=random1.nextInt(boardSize);
            if(getCurrentStatus(x,y)!=1){
                setCube(x,y);
                noSnake=true;
            }
        }
    }
}
