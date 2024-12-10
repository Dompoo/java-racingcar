package racingcar.domain.moveCommandProvider;

import racingcar.service.numberProvider.NumberProvider;

public class NumberMoveCommandProvider implements MoveCommandProvider {
	
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final int MIN_CAN_MOVE_NUMBER = 4;
	private static final int MAX_CAN_MOVE_NUMBER = 9;
	
	private final NumberProvider numberProvider;
	
	public NumberMoveCommandProvider(NumberProvider numberProvider) {
		this.numberProvider = numberProvider;
	}
	
	@Override
	public boolean canMove() {
		int number = numberProvider.providerNumberInRange(MIN_NUMBER, MAX_NUMBER);
		return number >= MIN_CAN_MOVE_NUMBER && number <= MAX_CAN_MOVE_NUMBER;
	}
}
