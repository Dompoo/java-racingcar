package racingcar.domain;

import racingcar.exception.CustomExceptions;

import java.util.Objects;

public class Car {
	
	private static final int MAX_NAME_LENGTH = 5;
	
	private final String name;
	private final int position;
	
	public Car(String name, int position) {
		Objects.requireNonNull(name);
		validate(name);
		this.name = name;
		this.position = position;
	}
	
	private static void validate(String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw CustomExceptions.CAR_NAME_LENGTH_EXCEED.get(MAX_NAME_LENGTH);
		}
	}
}
