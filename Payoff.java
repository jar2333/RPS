/**
 * Data containing class. Contains the payoff matrix for the 
 * computer. Payoff matrix can implemented explicitly as two-dimensional 
 * array or implicitly by modulo arithmetic. The former is simple, while 
 * the latter is scalable. 
 * 
 * @author Jose A. Ramos
 *
 */
public class Payoff {
	/**
	 * Gets the computer payoff given the indexes for computer and player throws.
	 * 
	 * @param computerThrowIndex
	 * @param playerThrowIndex
	 * @return payoff for the computer
	 */
	public static int getPayoff(int computerThrowIndex, int playerThrowIndex) {
		return payoffMatrix[computerThrowIndex][playerThrowIndex];
	}
	
	private static int[][] payoffMatrix = new int[][] {{0,-1,1},{1,0,-1},{-1,1,0}};
}
