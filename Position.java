public class Position {
    public final int row;
    public final int column;
    
    public Position(int row, int column) {
	this.row = row;
	this.column = column;
    }

    
    @Override
    //equals method necessary for stack's contains method
    public boolean equals(Object o)
    {
        if(o == this)
            return true;
        if(!(o instanceof Position))
            return false;

        Position p = (Position) o;
        if(this.row == p.row && this.column == p.column)
            return true;
        return false;
    }
}