import java.util.ArrayList;
import java.util.*;
import info.gridworld.grid.*;

public class UnboundedGrid2<E> extends AbstractGrid<E>
{
    private int dimension;
    private Object[][] occupantArray;

    public UnboundedGrid2()
    {
        dimension = 16;
        occupantArray = new Object[dimension][dimension];
    }
    public int getNumRows()
    {
        return -1;
    }
    public int getNumCols()
    {
        return -1;
    }
    public boolean isValid(Location loc)
    {
        return loc.getRow() >= 0 && loc.getCol() >= 0;
    }
    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();

        for (int r = 0; r < dimension; r++)
        {
            for (int c = 0; c < dimension; c++)
            {
                Location loc = new Location(r, c);
                if (get(loc) != null)
                {
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
        if (loc.getRow() >= dimension || loc.getCol() >= dimension)
        {
            return null;
        }
        return (E)occupantArray[loc.getRow()][loc.getCol()];
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
        if (loc.getRow() >= dimension || loc.getCol() >= dimension)
        {
            resize(loc);
        }
        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }
    public E remove(Location loc)
    {
        if (!isValid(loc))
		{
			throw new IllegalArgumentException("Location " + loc + " is not valid!");
        }
        if (loc.getRow() >= dimension || loc.getCol() >= dimension)
        {
            return null;
        }
        
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }
    private void resize(Location loc)
    {
        int size = dimension;
        while (loc.getRow() >= dimension || loc.getCol() >= dimension)
        {
            size *= 2;
        }
        Object[][] temp = new Object[size][size];
        for (int r = 0; r < dimension; r++)
        {
            for (int c = 0; c < dimension;c ++)
            {
                temp[r][c] = occupantArray[r][c];
            }
        }

        occupantArray = temp;
        dimension = size;
    }
}