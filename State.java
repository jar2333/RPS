/**
 * Holds relevant information about the last round. This is the indeces of the two player throws.
 * 
 * @author Jose A. Ramos
 *
 */
public class State {
	public int computerThrowIndex;
	public int playerThrowIndex;
	
	public State(int computerThrowIndex, int playerThrowIndex) {
		this.computerThrowIndex = computerThrowIndex;
		this.playerThrowIndex = playerThrowIndex;
	}
}