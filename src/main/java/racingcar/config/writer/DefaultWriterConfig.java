package racingcar.config.writer;

import racingcar.io.writer.ConsoleWriter;
import racingcar.io.writer.Writer;

public class DefaultWriterConfig implements WriterConfig {
	
	private final Writer writer;
	
	public DefaultWriterConfig() {
		this.writer = new ConsoleWriter();
	}
	
	@Override
	public Writer getWriter() {
		return writer;
	}
}
