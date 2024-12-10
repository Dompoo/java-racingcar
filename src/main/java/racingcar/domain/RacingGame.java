package racingcar.domain;

import racingcar.domain.moveCommandProvider.MoveCommandProvider;
import racingcar.dto.GameResult;
import racingcar.dto.LapResult;
import racingcar.exception.CustomExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
	
	private static final int MIN_LAP_COUNT = 3;
	private static final int MAX_LAP_COUNT = 30;
	
	private final Cars cars;
	private final MoveCommandProvider moveCommandProvider;
	private final int lapCount;
	
	public RacingGame(Cars cars, MoveCommandProvider moveCommandProvider, int lapCount) {
		Objects.requireNonNull(cars);
		Objects.requireNonNull(moveCommandProvider);
		validate(lapCount);
		this.cars = cars;
		this.moveCommandProvider = moveCommandProvider;
		this.lapCount = lapCount;
	}
	
	private static void validate(int lapCount) {
		if (lapCount < MIN_LAP_COUNT || lapCount > MAX_LAP_COUNT) {
			throw CustomExceptions.INVALID_LAP_COUNT.get(MIN_LAP_COUNT, MAX_LAP_COUNT);
		}
	}
	
	public GameResult play() {
		List<LapResult> lapResults = new ArrayList<>();
		for (int lap = 0; lap < lapCount; lap++) {
			LapResult lapResult = cars.playOneLap(moveCommandProvider);
			lapResults.add(lapResult);
		}
		return new GameResult(lapResults);
	}
}
