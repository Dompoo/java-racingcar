package racingcar.domain;

import racingcar.domain.moveCommandProvider.MoveCommandProvider;
import racingcar.dto.LapResult;
import racingcar.dto.MoveResult;
import racingcar.exception.CustomExceptions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Cars {
	
	private static final int MIN_CAR_COUNT = 2;
	private static final int MAX_CAR_COUNT = 30;

	private final List<Car> cars;
	
	private Cars(List<Car> cars) {
		Objects.requireNonNull(cars);
		validate(cars);
		this.cars = cars;
	}
	
	private static void validate(List<Car> cars) {
		if (cars.size() < MIN_CAR_COUNT || cars.size() > MAX_CAR_COUNT) {
			throw CustomExceptions.INVALID_CAR_COUNT.get(MIN_CAR_COUNT, MAX_CAR_COUNT);
		}
	}
	
	public static Cars from(List<String> carNames) {
		Objects.requireNonNull(carNames);
		validateCarNameDuplication(carNames);
		List<Car> cars = carNames.stream()
				.map(Car::from)
				.toList();
		return new Cars(cars);
	}
	
	private static void validateCarNameDuplication(List<String> carNames) {
		if (new HashSet<>(carNames).size() != carNames.size()) {
			throw CustomExceptions.DUPLICATED_CAR_NAME.get();
		}
	}
	
	public LapResult playOneLap(MoveCommandProvider moveCommandProvider) {
		List<MoveResult> moveResults = new ArrayList<>();
		for (Car car : cars) {
			MoveResult moveResult = car.move(moveCommandProvider);
			moveResults.add(moveResult);
		}
		return new LapResult(moveResults);
	}
}
