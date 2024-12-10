package racingcar.domain;

import racingcar.common.dto.CarStatus;
import racingcar.common.dto.WinnerResult;

import java.util.List;
import java.util.Objects;

public class Referee {
	
	private final Cars cars;
	
	public Referee(Cars cars) {
		Objects.requireNonNull(cars);
		this.cars = cars;
	}
	
	public WinnerResult judgeWinner() {
		List<CarStatus> carStatuses = cars.getCarStatuses();
		int maxPosition = getMaxPosition(carStatuses);
		List<String> winnerNames = getWinnerNames(carStatuses, maxPosition);
		return new WinnerResult(winnerNames);
	}
	
	private static int getMaxPosition(List<CarStatus> carStatuses) {
		return carStatuses.stream()
				.sorted()
				.toList()
				.getFirst()
				.position();
	}
	
	private static List<String> getWinnerNames(List<CarStatus> carStatuses, int maxPosition) {
		return carStatuses.stream()
				.filter(carStatus -> carStatus.position() == maxPosition)
				.map(CarStatus::name)
				.toList();
	}
}
