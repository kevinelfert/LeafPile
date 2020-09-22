import java.util.Stack; //using stack
public class LeafPile {
	public static void main(String[] args) 
	{
		Ground map[][] = new Ground[7][11];
		generateRandomGround(map);
		printMap(map);
		System.out.println(largestLeafPile(map));
    }

	private static Stack<Position> stack = new Stack<Position>();

	private static int largestLeafPile(Ground map[][]) 
	{
		int maxSize = 0;
		for(int i = 0; i<map.length; i++)
		{
			for(int j = 0; j<map[i].length; j++)
			{
				if(map[i][j] == Ground.LEAF)
				{
					Position pos = new Position(i, j);
					stack.push(pos);
					int pile = sizeOfLeafPile(map, stack);
					if(pile>maxSize)
						maxSize = pile;
				}
			}
		}
        return maxSize;
	}

	private static int sizeOfLeafPile(Ground[][] map, Stack<Position> stack)
	{
		int size = 0;
		while(stack.empty()==false)
		{
			Position posPop = stack.pop();
			map[posPop.row][posPop.column] = Ground.GRASS;
			size++;

			//North
			if(posPop.row-1>=0)
			{
				if(map[posPop.row-1][posPop.column]==Ground.LEAF)
				{
					Position posNorth = new Position(posPop.row-1, posPop.column);
					if(stack.contains(posNorth)==false)
					{
						stack.push(posNorth);
					}
				}
			}

			//East
			if(posPop.column+1<map[posPop.row].length)
			{
				if(map[posPop.row][posPop.column+1]==Ground.LEAF)
				{
					Position posEast = new Position(posPop.row, posPop.column+1);
					if(stack.contains(posEast)==false)
					{
						stack.push(posEast);
					}
					
				}
			}

			//South
			if(posPop.row+1<map.length)
			{
				if(map[posPop.row+1][posPop.column]==Ground.LEAF)
				{
					Position posSouth = new Position(posPop.row+1, posPop.column);
					if(stack.contains(posSouth)==false)
					{
						stack.push(posSouth);
					}
					
				}
			}

			//West
			if(posPop.column-1>=0)
			{
				if(map[posPop.row][posPop.column-1]==Ground.LEAF)
				{
					Position posWest = new Position(posPop.row, posPop.column-1);
					if(stack.contains(posWest)==false)
					{
					stack.push(posWest);
					}
				}
			}	
		}
		return size;	
	}

	private static void printMap(Ground map[][]) 
	{
		for (int r = 0; r < map.length; r++) 
		{
			for (int c = 0; c < map[r].length; c++) 
			{
				System.out.print(map[r][c]);
				if (c < map[r].length - 1) 
				{
					System.out.print(' ');
				}
			}
			System.out.println();
		}
    }

	private static void generateRandomGround(Ground map[][]) 
	{
		double randGround;
		double randMax = 100;
		double percentGrass = .70;
		for (int r = 0; r < map.length; r++) 
		{
			for (int c = 0; c < map[r].length; c++) 
			{
				randGround = (Math.random() * randMax) + 1;
				map[r][c] = randGround <= randMax * percentGrass ? Ground.GRASS : Ground.LEAF;
			}
		}
    }
}