package racingcar.domain;

import racingcar.exception.CustomExceptions;

import java.util.Objects;

public class Car {
	
	private static final int INITIAL_POSITION = 0;
	private static final int MAX_NAME_LENGTH = 5;
	
	private final String name;
	private final int position;
	
	private Car(String name, int position) {
		Objects.requireNonNull(name);
		validate(name);
		this.name = name;
		this.position = position;
	}
	
	public static Car from(String name) {
		return new Car(name, INITIAL_POSITION);
	}
	
	private static void validate(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw CustomExceptions.INVALID_CAR_NAME_LENGTH.get(MAX_NAME_LENGTH);
		}
	}
}
