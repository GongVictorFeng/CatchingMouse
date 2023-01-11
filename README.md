# CatchingMouse
A game "Catch the mouse" with a simple user interface

The game's user interface shows a board, made of a cubes, with the same numbre of rows and columns. The board contains grey(free) cubes, green (snakes) cubes,
and one red (mouse) cube.

The player tries to catch the red mouse before it reaches the edge. If the mouse (red cube) reaches the edge, the player loses. If the player clicks any square, there
are for cases:
      -If the square is already a green cube (a snake) nothing happens.
      -If it is a square that is a neighbor o another snake, it turns into snake too.
      -If it is a squre that is not a neighbor of any other snake, nothing happens.
      -If it is a red cube (a mouse) and it is currently next to any snake, the game is won.
Note: a position is a "neighbor" of another one if we can go from the first position to the second in a single move, without skipping any cube.
The mouse cannot move to any of the squares already clicked by the user, which turn into snakes. If the player clicks it before it reaches the edge, the player wins!
