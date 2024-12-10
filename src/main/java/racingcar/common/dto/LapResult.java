package racingcar.common.dto;

import java.util.List;

public record LapResult(
		List<MoveResult> moveResults
) {
}
