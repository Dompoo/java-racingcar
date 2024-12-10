package racingcar.dto;

import java.util.List;

public record LapStatus(
		List<CarStatus> carStatuses
) {
}
