import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class SparseBoundedGrid2<E> extends AbstractGrid<E>
{
    private ArrayList<LinkedList> occupantArray;

    private int numCols;
    private int numRows;

    public SparseBoundedGrid2(int rows, int cols)
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
        occupantArray = new ArrayList<LinkedList>();
        for (int i = 0; i < rows; i++)
        {
            occupantArray.add(new LinkedList<OccupantInCol>());
        }
    }

    public int getNumRows()
    {
        return  numRows;
    }
    public int getNumCols()
    {
        return numCols;
    }

    public boolean isValid(Location loc)
    {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows() && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();

        for (int r = 0; r < getNumRows(); r++)
        {
            LinkedList<OccupantInCol> row = occupantArray.get(r);
            if (row != null)
            {
                for (OccupantInCol occ: row)
                {
                    Location loc = new Location(r, occ.getColNum());
                    locs.add(loc);
                }
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
        
        LinkedList<OccupantInCol> row = occupantArray.get(loc.getRow());

        if (row != null)
        {
            for (OccupantInCol occ : row)
            {
                if (loc.getCol() == occ.getColNum())
                {
                    return (E)occ.getOccupant();
                }
            }
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
        
        occupantArray.get(loc.getRow()).add(new OccupantInCol(obj, loc.getCol()));
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
        
        LinkedList<OccupantInCol> row = occupantArray.get(loc.getRow());

        if (row != null)
        {
            Iterator<OccupantInCol> itr = row.iterator();
            while(itr.hasNext())
            {
                if (itr.next().getColNum() == loc.getCol())
                {
                    itr.remove();
                    break;
                }
            }
        }
        return obj;
    }
}