package racingcar.config;

import racingcar.config.moveCommandProvider.MoveCommandProviderConfig;
import racingcar.controller.RacingGameController;

public class RacingGameControllerConfig {
	
	private final RacingGameController racingGameController;
	
	public RacingGameControllerConfig(
			InputHandlerConfig inputHandlerConfig,
			OutputHandlerConfig outputHandlerConfig,
			MoveCommandProviderConfig moveCommandProviderConfig
	) {
		this.racingGameController = new RacingGameController(
				inputHandlerConfig.getInputHandler(),
				outputHandlerConfig.getOutputHandler(),
				moveCommandProviderConfig.getMoveCommandProvider()
		);
	}
	
	public RacingGameController getRacingGameController() {
		return racingGameController;
	}
}
