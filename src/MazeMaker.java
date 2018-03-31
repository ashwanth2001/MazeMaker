import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//select a random cell to start
		
		//call selectNextPath method with the randomly selected cell
		
		return maze;
	}

	private static void selectNextPath(Cell currentCell) {
		// mark current cell as visited
		currentCell.setBeenVisited(true);
		
		// check for unvisited neighbors
		Cell[] store = new Cell[4];
		int x = 0;
		if(currentCell.getX()<5-1&&!maze.getCell(currentCell.getX()+1, currentCell.getY()).hasBeenVisited()) {
			store[x] = maze.getCell(currentCell.getX(), currentCell.getY());
			x++;
		}
		if(currentCell.getX()>0&&!maze.getCell(currentCell.getX()-1, currentCell.getY()).hasBeenVisited()) {
			store[x] = maze.getCell(currentCell.getX(), currentCell.getY());
			x++;
		}
		if(currentCell.getY()<5-1&&!maze.getCell(currentCell.getX(), currentCell.getY()+1).hasBeenVisited()) {
			store[x] = maze.getCell(currentCell.getX(), currentCell.getY());
			x++;
		}
		if(currentCell.getY()>0&&!maze.getCell(currentCell.getX(), currentCell.getY()-1).hasBeenVisited()) {
			store[x] = maze.getCell(currentCell.getX(), currentCell.getY());
			x++;
		}
		System.out.println(x);
		
		// if has unvisited neighbors,
			// select one at random.
			// push it to the stack
			// remove the wall between the two cells
			// make the new cell the current cell and mark it as visited
		
			//call the selectNextPath method with the current cell
			
		// if all neighbors are visited
			//if the stack is not empty
				// pop a cell from the stack
				// make that the current cell
		
				//call the selectNextPath method with the current cell
		
		if(x>0) {
			int rand = (int)(Math.random()*(x+1));
			uncheckedCells.push(store[rand]);
			removeWalls(currentCell, store[rand]);
			selectNextPath(store[rand]);
		}
		else if(uncheckedCells.size()>0){
			Cell c = uncheckedCells.pop();
			selectNextPath(c);
		}
	}

	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX()<c2.getX()) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}
		if(c1.getX()>c2.getX()) {
			c2.setEastWall(false);
			c1.setWestWall(false);
		}
		if(c1.getY()<c2.getY()) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}
		if(c1.getY()>c2.getY()) {
			c2.setNorthWall(false);
			c1.setSouthWall(false);
		}
	}

	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}