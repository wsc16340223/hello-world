public class OccupantInCol
{
    private Object occupant;
    private int col;

    public OccupantInCol(Object obj, int co)
    {
        occupant = obj;
        col = co;
    }
    public Object getOccupant()
    {
        return occupant;
    }
    public int getColNum()
    {
        return col;
    }
    public void setOccupant(Object obj)
    {
        occupant = obj;
    }
}