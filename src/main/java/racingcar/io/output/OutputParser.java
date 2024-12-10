package racingcar.io.output;

import racingcar.common.dto.GameResult;
import racingcar.common.dto.LapResult;
import racingcar.common.dto.MoveResult;
import racingcar.common.dto.WinnerResult;

import java.util.StringJoiner;

public class OutputParser {
	
	public String parseGameResult(GameResult gameResult) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n실행 결과\n");
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
		return moveResult.name() + " : " + "-".repeat(moveResult.position());
	}
	
	public String parseWinnerResult(WinnerResult winnerResult) {
		StringJoiner winnerNameJoiner = new StringJoiner(", ");
		for (String winnerName : winnerResult.winnerNames()) {
			winnerNameJoiner.add(winnerName);
		}
		return "최종 우승자 : " + winnerNameJoiner;
	}
}
