package racingcar.io.input;

import java.util.Arrays;
import java.util.List;

public class InputParser {
	
	public List<String> parseCarNames(String carNamesInput) {
		return Arrays.stream(carNamesInput.split(","))
				.map(String::trim)
				.toList();
	}
	
	public int parseLapCount(String lapCountInput) {
		return Integer.parseInt(lapCountInput);
	}
}
