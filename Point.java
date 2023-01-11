//Student 1: Gong(Victor) Feng,300176400

//this class is to set 2 coordinates to a point
public class Point {

   // YOUR INSTANCE VARIABLES HERE
   private int x;
   private int y;

    /*Constructor 
     * The parameters x and y are the coordinates
     */
   public Point(int x, int y){
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
      this.x=x;
      this.y=y;
   }

    //Getter method, return the value of instance variable x
   public int getX(){
		return x;//REPLACE THIS LINE WITH YOUR CODE 
   }
    
    //Getter method, return the value of instance variable y
   public int getY(){
		return y;//REPLACE THIS LINE WITH YOUR CODE 
   }
    

    //Setter method, sets the values of instance variables x and y
   public void reset(int x, int y){
	//YOUR CODE HERE
      this.x=x;
      this.y=y;
   }

   //overload a equal method to compare two poinds.
   public boolean equals(Point p){
      return this.x==p.x&&this.y==p.y;
   }

   public String toString(){
      return "("+x+","+y+")";
   }


}
