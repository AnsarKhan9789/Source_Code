package filesoperation;

public enum Rainbow {
	
	    RED(1),
	    Orange(2),
	    Yellow(3),
		Green(4),
		Blue(5),Indigo(6),
		Violet(7),;
		final int value;
		Rainbow(int i) {
			this.value=i;
		} 
		public int getValue() {
			return this.value;
		}
		
	
}
