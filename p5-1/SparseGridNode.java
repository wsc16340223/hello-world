public class SparseGridNode 
{ 
	private Object occupant; 
	private int col; 
	private SparseGridNode next; 
	
	public SparseGridNode(Object oc, int c, SparseGridNode nextNode)
	{
		occupant = oc;
		col = c;
		next = nextNode;
	}

	public Object getObject()
	{
		return occupant;
	}
	public int getCol()
	{
		return col;
	}
	public SparseGridNode getNext()
	{
		return next;
	}
	public void setOccupant(Object occ)
	{
		occupant = occ;
	}
	public void setCol(int co)
	{
		col = co;
	}
	public void setNext(SparseGridNode nextNode)
	{
		next = nextNode;
	}
	
}

