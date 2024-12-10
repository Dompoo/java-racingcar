package racingcar.io.output;

import racingcar.common.dto.GameResult;
import racingcar.common.dto.LapResult;
import racingcar.common.dto.MoveResult;

public class OutputParser {
	
	public String parseGameResult(GameResult gameResult) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("실행 결과\n");
		for (LapResult lapResult : gameResult.lapResults()) {
			stringBuilder.append(parseLapResult(lapResult));
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	private String parseLapResult(LapResult lapResult) {
		StringBuilder stringBuilder = new StringBuilder();
		for (MoveResult moveResult : lapResult.moveResults()) {
			stringBuilder.append(parseMoveResult(moveResult));
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
	
	private String parseMoveResult(MoveResult moveResult) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(moveResult.name());
		stringBuilder.append(" : ");
		stringBuilder.append("-".repeat(moveResult.position()));
		return stringBuilder.toString();
	}
}
