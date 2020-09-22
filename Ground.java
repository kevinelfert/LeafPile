public enum Ground {
    GRASS('-'), LEAF('~');
    
    private char symbol;
    
    private Ground(char value) {
	symbol = value;
    }
    
    public String toString() {
	return "" + symbol;
    }
}