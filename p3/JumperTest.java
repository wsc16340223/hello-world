 import static org.junit.Assert.*; 
 import org.junit.Test;
 import info.gridworld.grid.Location;
 import info.gridworld.actor.*;
 import info.gridworld.actor.Jumper;
public class JumperTest
{
	// move
	@Test
	public void testMove()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(8, 2), alice);
		Location lo = alice.getLocation();
		Location next1 = lo.getAdjacentLocation(alice.getDirection());
        Location next2 = next1.getAdjacentLocation(alice.getDirection());
		alice.move();
		assertEquals(alice.getLocation(), next2);
	}

	// not move
	@Test
	public void testAct1()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(8, 2), alice);
    	Bug a = new Bug();
    	world.add(new Location(6, 2), a);
    	Location loc = alice.getLocation();
    	alice.act();
    	assertEquals(alice.getLocation(), loc);
	}

	// move
	@Test
	public void testAct2()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(8, 2), alice);
    	Bug a = new Bug();
    	world.add(new Location(7, 2), a);
    	Location lo = alice.getLocation();
		Location next1 = lo.getAdjacentLocation(alice.getDirection());
        Location next2 = next1.getAdjacentLocation(alice.getDirection());
    	alice.act();
    	assertEquals(alice.getLocation(), next2);
	}

	// move
	@Test
	public void testAct3()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(8, 2), alice);
    	Flower a = new Flower();
    	world.add(new Location(6, 2), a);
    	Location lo = alice.getLocation();
		Location next1 = lo.getAdjacentLocation(alice.getDirection());
        Location next2 = next1.getAdjacentLocation(alice.getDirection());
    	alice.act();
    	assertEquals(alice.getLocation(), next2);
	}

	// not move
	@Test
	public void testAct4()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(1, 2), alice);
    	
    	Location loc = alice.getLocation();
    	alice.act();
    	assertEquals(alice.getLocation(), loc);
	}

	// not move 
	@Test
	public void testAct5()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(0, 2), alice);
    	
    	Location loc = alice.getLocation();
    	alice.act();
    	assertEquals(alice.getLocation(), loc);
	}

	// not move 
	@Test
	public void testAct6()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(6, 2), alice);
    	Jumper bob = new Jumper();
    	world.add(new Location(4, 2), bob);
    	Location loc = alice.getLocation();
    	alice.act();
    	assertEquals(alice.getLocation(), loc);
	}

	//  move 
	@Test
	public void testAct7()
	{
		ActorWorld world = new ActorWorld();
    	Jumper alice = new Jumper();
    	world.add(new Location(6, 2), alice);
    	Jumper bob = new Jumper();
    	world.add(new Location(5, 2), bob);
    	Location lo = alice.getLocation();
		Location next1 = lo.getAdjacentLocation(alice.getDirection());
        Location next2 = next1.getAdjacentLocation(alice.getDirection());
    	alice.act();
    	assertEquals(alice.getLocation(), next2);
	}
}

