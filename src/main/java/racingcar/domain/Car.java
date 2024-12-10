package racingcar.domain;

import racingcar.common.dto.CarStatus;
import racingcar.common.dto.MoveResult;
import racingcar.common.exception.CustomExceptions;
import racingcar.domain.moveCommandProvider.MoveCommandProvider;

import java.util.Objects;

public class Car {
	
	private static final int INITIAL_POSITION = 0;
	private static final int MIN_NAME_LENGTH = 2;
	private static final int MAX_NAME_LENGTH = 5;
	
	private final String name;
	private int position;
	
	private Car(String name, int position) {
		Objects.requireNonNull(name);
		validate(name);
		this.name = name;
		this.position = position;
	}
	
	private static void validate(String name) {
		if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
			throw CustomExceptions.INVALID_CAR_NAME_LENGTH.get(MAX_NAME_LENGTH, MIN_NAME_LENGTH);
		}
	}
	
	public static Car from(String name) {
		return new Car(name, INITIAL_POSITION);
	}
	
	public MoveResult move(MoveCommandProvider moveCommandProvider) {
		if (moveCommandProvider.canMove()) {
			position++;
		}
		return new MoveResult(name, position);
	}
	
	public CarStatus getCarStatus() {
		return new CarStatus(name, position);
	}
}
