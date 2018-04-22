import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;


public class SparseBoundedGrid<E> extends AbstractGrid<E>
{

	private SparseGridNode[] occupantArray ;

	private int numCols;
	private int numRows;

	public SparseBoundedGrid(int rows, int cols)
	{
		if (rows < 0)
		{
			throw new IllegalArgumentException("Rows < 0!");
		}
		if (cols < 0)
		{
			throw new IllegalArgumentException("Cols < 0!");
		}
		numRows = rows;
		numCols = cols;
		occupantArray = new SparseGridNode[rows];
	}

	public boolean isValid(Location loc)
	{
		return 0 <= loc.getRow() && loc.getRow() < getNumRows() && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	}

	public int getNumRows()
	{
		return numRows;
	}
	public int getNumCols()
	{
		return numCols;
	}
	public ArrayList<Location> getOccupiedLocations()
	{
		ArrayList<Location> locs = new ArrayList<Location>();

		for (int i = 0;i < getNumRows(); i++)
		{
			SparseGridNode s = occupantArray[i];
			while (s != null)
			{
				Location loc = new Location(i, s.getCol());
				locs.add(loc);
				s = s.getNext();
			}
		}
		return locs;
	}
	public E get(Location loc)
	{
		if (!isValid(loc))
		{
			throw new IllegalArgumentException("Location " + loc + " is not valid!");
		}
		SparseGridNode s = occupantArray[loc.getRow()];
		while (s != null)
		{
			if (loc.getCol() == s.getCol())
			{
				return (E)s.getOccupant();
			}
			s.getNext();
		}
		return null;
	}

	public E put(Location loc, E obj)
	{
		if (!isValid(loc))
		{
			throw new IllegalArgumentException("Location " + loc + " is not valid!");
		}
		if (obj == null)
		{
				throw new NullPointerException("obj == null");
		}
		E oldOccupant = remove(loc);

		SparseGridNode s = occupantArray[loc.getRow()];

		occupantArray[loc.getRow()] = new SparseGridNode(obj, loc.getCol(), s);

		return oldOccupant;
	}

	public E remove(Location loc)
	{
		if (!isValid(loc))
		{
			throw new IllegalArgumentException("Location " + loc + " is not valid!");
		}

		E obj = get(loc);

		if (obj == null)
		{
			return null;
		}
		SparseGridNode s = occupantArray[loc.getRow()];

		if (s != null)
		{
			if (s.getCol() == loc.getCol())
			{
				occupantArray[loc.getRow()] = s.getNext();
			}
			else
			{
				SparseGridNode search = s.getNext();
				while (search != null && search.getCol() != s.getCol())
				{
					s = s.getNext();
					search = search.getNext();
				}
				if (search != null)
				{
					s.setNext(search.getNext());
				}
			}
		}
		return obj;
	}
}