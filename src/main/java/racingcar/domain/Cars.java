package racingcar.domain;

import racingcar.exception.CustomExceptions;

import java.util.List;
import java.util.Objects;

public class Cars {
	
	private static final int MIN_CAR_COUNT = 2;
	private static final int MAX_CAR_COUNT = 30;

	private final List<Car> cars;
	
	public Cars(List<Car> cars) {
		Objects.requireNonNull(cars);
		validate(cars);
		this.cars = cars;
	}
	
	private static void validate(List<Car> cars) {
		if (cars.size() < MIN_CAR_COUNT || cars.size() > MAX_CAR_COUNT) {
			throw CustomExceptions.INVALID_CAR_COUNT.get(MIN_CAR_COUNT, MAX_CAR_COUNT);
		}
	}
}
