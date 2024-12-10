package racingcar.domain;

import racingcar.domain.moveCommandProvider.MoveCommandProvider;
import racingcar.dto.CarStatus;
import racingcar.exception.CustomExceptions;

import java.util.Objects;

public class Car {
	
	private static final int INITIAL_POSITION = 0;
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
		if (name.length() > MAX_NAME_LENGTH) {
			throw CustomExceptions.INVALID_CAR_NAME_LENGTH.get(MAX_NAME_LENGTH);
		}
	}
	
	public static Car from(String name) {
		return new Car(name, INITIAL_POSITION);
	}
	
	public CarStatus move(MoveCommandProvider moveCommandProvider) {
		if (moveCommandProvider.canMove()) {
			position++;
		}
		return new CarStatus(name, position);
	}
}
