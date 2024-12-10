package racingcar.config;

import racingcar.config.reader.ReaderConfig;
import racingcar.config.writer.WriterConfig;
import racingcar.io.input.InputHandler;
import racingcar.io.input.InputParser;
import racingcar.io.input.InputValidator;

public class InputHandlerConfig {
	
	private final InputHandler inputHandler;
	
	public InputHandlerConfig(ReaderConfig readerConfig, WriterConfig writerConfig) {
		this.inputHandler = new InputHandler(
				readerConfig.getReader(),
				writerConfig.getWriter(),
				new InputValidator(),
				new InputParser()
		);
	}
	
	public InputHandler getInputHandler() {
		return inputHandler;
	}
}
