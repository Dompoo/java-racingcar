package racingcar;

import racingcar.config.InputHandlerConfig;
import racingcar.config.OutputHandlerConfig;
import racingcar.config.RacingGameControllerConfig;
import racingcar.config.moveCommandProvider.DefaultMoveCommandProviderConfig;
import racingcar.config.numberProvider.DefaultNumberProviderConfig;
import racingcar.config.reader.DefaultReaderConfig;
import racingcar.config.writer.DefaultWriterConfig;
import racingcar.config.writer.WriterConfig;
import racingcar.controller.RacingGameController;

public class RacingGameApplication {
	
	private static RacingGameController racingGameController;
	
	public static void run() {
		if (racingGameController == null) {
			initRacingGameController();
		}
		racingGameController.run();
	}
	
	private static void initRacingGameController() {
		WriterConfig writerConfig = new DefaultWriterConfig();
		RacingGameControllerConfig racingGameControllerConfig = new RacingGameControllerConfig(
				new InputHandlerConfig(new DefaultReaderConfig(), writerConfig),
				new OutputHandlerConfig(writerConfig),
				new DefaultMoveCommandProviderConfig(new DefaultNumberProviderConfig())
		);
		racingGameController = racingGameControllerConfig.getRacingGameController();
	}
}
