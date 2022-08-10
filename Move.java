
/**
 * Write a description of class Move here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
