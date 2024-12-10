package racingcar.io.output;

import racingcar.common.dto.GameResult;
import racingcar.common.dto.WinnerResult;
import racingcar.io.writer.Writer;

public class OutputHandler {
	
	private final Writer writer;
	private final OutputParser outputParser;
	
	public OutputHandler(Writer writer, OutputParser outputParser) {
		this.writer = writer;
		this.outputParser = outputParser;
	}
	
	public void handleGameResult(GameResult gameResult) {
		String result = outputParser.parseGameResult(gameResult);
		writer.write(result);
	}
	
	public void handleWinnerResult(WinnerResult winnerResult) {
		String result = outputParser.parseWinnerResult(winnerResult);
		writer.write(result);
	}
}
