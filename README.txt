Mindfield Game

Minefield Problem:

You a robot placed on an n by n grid that contains contains your starting square, a goal square, and a number of mines.  You are also given a map of the grid with your start location, the goal location, and the locations of all the mines marked.  You can only move Up, Down, Left, and Right.  You must produce a sequence of moves to get you from your starting location to the goal location without moving into any mine locations and without moving off the grid.  Also, the length this sequence must be minimal.  (There must not be a shorter sequence of moves that also gets you to the goal location.)

 

Input:

The input consists of one or more problems. You must stop reading input once you have read the full problem description and produce a solution before you continue reading input.  Note that problems are NOT separated by blank lines.

Each problem consists of the following (You may want to refer to the example below as your read the description.)

A problem begins with a number on a line by itself.  This is n, or the height and width of the grid.
The next line also contains a number by itself.  This number tells you how many rows in the grid have at least one mine.  Call this number R.
The next R lines tell you about the locations of mines in a particular row.
Each of these lines begins with the number of the row it is describing.  In other words, if the first number is 5, this line is talking about mines in row number 5.
The line then contains one or more numbers telling you which columns in that row contain mines.
You can assume that the rows are given in increasing order (information about row 3 is given before information about row 8).
You can assume that if a row is listed, it has at least one mine.
You can assume the columns for a row are listed in increasing order (if a row has mines in columns 5 and 9, column 5 is listed before column 9).
All the numbers in a line are separated from each other by a single space.
The next line contains two numbers separated by a space.  The first is the row of your starting location and the second is the column of your starting location.
The next line contains two numbers separated by a space.  The first is the row of your goal location and the second is the column of your goal location.
Please note the following about each problem description:

Each problem contains at least 4 lines.
The second line of a problem contains a number called R.  The problem is guaranteed to contain a total of R+4 lines.
The row numbers run from 0 at the topmost row of the grid to n-1 at the bottommost row of the grid.
The column numbers run from 0 at the leftmost column of the grid to n-1 at the rightmost column of the grid.
 

End of all Input:

The end of all input will be marked by a blank line at the end.  Note this this blank line would come after the goal location of the previous problem (where you would normally expect to see the size of the grid for the next problem.

 

Output:

Your output consists of a sequence of Up, Down, Left, and Right moves (indicated with U, D, L, and R) on a single line.  This sequence must be a shortest path from the start location on the grid to the goal location on the grid and it must avoid all mine locations.

 

Example:

Consider the gird below.  The start location is colored green.  The goal location is colored blue.  Mine locations are colored black.  A solution path is indicated by the purple arrows.



The input you would receive for this problem would be:

10
8
0 8
1 0 1 8
2 0 5 8
3 0 5
4 5
5 1 2 3 4
7 3
8 3
3 2
8 8

The output for the solution indicated by the purple arrows would be:
RRUURRDDDDDDDRR
 