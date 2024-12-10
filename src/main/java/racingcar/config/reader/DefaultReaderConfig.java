package racingcar.config.reader;

import racingcar.io.reader.ConsoleReader;
import racingcar.io.reader.Reader;

public class DefaultReaderConfig implements ReaderConfig {
	
	private final Reader reader;
	
	public DefaultReaderConfig() {
		this.reader = new ConsoleReader();
	}
	
	@Override
	public Reader getReader() {
		return reader;
	}
}
