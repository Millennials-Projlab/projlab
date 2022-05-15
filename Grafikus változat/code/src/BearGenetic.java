public class BearGenetic extends Genetics{
	public BearGenetic() {}
	
    public BearGenetic(int aminoCount, int nukleoCount) {
		super(aminoCount, nukleoCount);
	}
	
	/** 
	 * @return String
	 */
	public String toString() {
		return "DanceGenetic";
	}

    @Override
    public Agent generate(Virologist virologist, int liveTime) {
        return null;
    }
}
