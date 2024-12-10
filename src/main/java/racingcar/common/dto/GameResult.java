package racingcar.common.dto;

import java.util.List;

public record GameResult(
		List<LapResult> lapResults
) {
}
