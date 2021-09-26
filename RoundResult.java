
public class RoundResult {
	
	private final int COMPUTER_WIN = 0;
	private final int COMPUTER_LOSS = 1;
	private final int TIE = 2;
	
	private Throw computerThrow;
	private Throw playerThrow;
	private int result;

	public RoundResult(Throw computerThrow, 
			Throw playerThrow, int result) {
		this.computerThrow = computerThrow;
		this.playerThrow = playerThrow;
		this.result = result;
	}
	
	public Throw getComputerThrow() {
		return computerThrow;
	}
	
	public Throw getPlayerThrow() {
		return playerThrow;
	}
	
	public int getResult() {
		return this.result;
	}
	
	public boolean isTie() {
		return result == TIE;
	}
	
}
