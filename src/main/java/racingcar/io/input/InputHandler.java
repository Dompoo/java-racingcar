package racingcar.io.input;

import racingcar.io.reader.Reader;
import racingcar.io.writer.Writer;

import java.util.List;

public class InputHandler {
	
	private final Reader reader;
	private final Writer writer;
	private final InputValidator inputValidator;
	private final InputParser inputParser;
	
	public InputHandler(Reader reader, Writer writer, InputValidator inputValidator, InputParser inputParser) {
		this.reader = reader;
		this.writer = writer;
		this.inputValidator = inputValidator;
		this.inputParser = inputParser;
	}
	
	public List<String> handleCarNames() {
		writer.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNamesInput = reader.readLine();
		inputValidator.validateCarNames(carNamesInput);
		return inputParser.parseCarNames(carNamesInput);
	}
}
