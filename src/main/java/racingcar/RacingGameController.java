package racingcar;

import racingcar.common.dto.GameResult;
import racingcar.common.dto.WinnerResult;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.domain.moveCommandProvider.MoveCommandProvider;
import racingcar.io.input.InputHandler;
import racingcar.io.output.OutputHandler;

import java.util.List;

public class RacingGameController {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final MoveCommandProvider moveCommandProvider;
	
	public RacingGameController(InputHandler inputHandler, OutputHandler outputHandler, MoveCommandProvider moveCommandProvider) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.moveCommandProvider = moveCommandProvider;
	}
	
	public void run() {
		List<String> carNames = inputHandler.handleCarNames();
		int lapCount = inputHandler.handleLapCount();
		Cars cars = Cars.from(carNames);
		RacingGame racingGame = new RacingGame(cars, lapCount);
		Referee referee = new Referee(cars);
		
		GameResult gameResult = racingGame.play(moveCommandProvider);
		WinnerResult winnerResult = referee.judgeWinner();
		outputHandler.handleGameResult(gameResult);
		outputHandler.handleWinnerResult(winnerResult);
	}
}
