import info.gridworld.grid.Grid;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
    private int numCols;
    private int numRows;
    
    private Map<Location, E> occupantMap;

    public SparseBoundedGrid(int rows, int cols)
    {
        occupantMap = new HashMap<Location, E>();
        numCols = cols;
        numRows = rows;
    }

    public int getNumRows()
    {
        return numRows;
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
        ArrayList<Location> a = new ArrayList<Location>();
        for (Location loc : occupantMap.keySet())
        {
            a.add(loc);
        }
        return a;
    }

    public E get(Location loc)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null!");
        }
        return occupantMap.get(loc);
    }

    public E put(Location loc, E obj)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null!");
        }
        if (obj == null)
        {
            throw new NullPointerException("obj == null");
        }
        return occupantMap.put(loc, obj);
    }

    public E remove(Location loc)
    {
        if (loc == null)
        {
            throw new NullPointerException("loc == null!");
        }
        return occupantMap.remove(loc);
    }
}