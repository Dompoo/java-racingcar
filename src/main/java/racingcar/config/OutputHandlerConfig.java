package racingcar.config;

import racingcar.config.writer.WriterConfig;
import racingcar.io.output.OutputHandler;
import racingcar.io.output.OutputParser;

public class OutputHandlerConfig {
	
	private final OutputHandler outputHandler;
	
	public OutputHandlerConfig(WriterConfig writerConfig) {
		this.outputHandler = new OutputHandler(
				writerConfig.getWriter(),
				new OutputParser()
		);
	}
	
	public OutputHandler getOutputHandler() {
		return outputHandler;
	}
}
