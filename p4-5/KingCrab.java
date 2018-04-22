/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class KingCrab extends CrabCritter
{
    public KingCrab()
    {
        setColor(Color.ORANGE);
    }


    public int distance(Location loc1, Location loc2)
    {
    	int x1 = loc1.getRow();
    	int y1 = loc1.getCol();
    	int x2 = loc2.getRow();
    	int y2 = loc2.getCol();
    	double dis = Math.sqrt((x1 - x2)*(x1-x2) + (y1-y2)*(y1-y2)) + .5;
    	return (int)Math.floor(dis);
    }

    private boolean moveOther(Actor a)
    {
    	ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation());

    	for (Location loc: locs)
    	{
    		if (distance(getLocation(), loc) > 1)
    		{
    			a.moveTo(loc);
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * A crab gets the actors in the three locations immediately in front, to its
     * front-right and to its front-left
     * @return a list of actors occupying these locations
     */
    

    /**
     * @return list of empty locations immediately to the right and to the left
     */
    

   
    /**
     * If the crab critter doesn't move, it randomly turns left or right.
     */
   
    
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public void processActors(ArrayList<Actor> actors)
    {
    	for (Actor a : actors)
    	{
    		if (!moveOther(a))
    		{
    			a.removeSelfFromGrid();
    		}
    	}
    } 
}

