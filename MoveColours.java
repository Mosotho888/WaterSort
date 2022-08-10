
/**
 * @author (Tebogo Mofokeng)
 */
public class Move
{
    private int source;
    private int target;
    
    public Move()
    {}
    
    public Move(int source, int target)
    {
        this.source = source;
        this.target = target;
    }
    
    public int getSource()
    {
        return source;
    }
    
    public int getTarget()
    {
        return target;
    }
}
