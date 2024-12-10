package racingcar.io.input;

import racingcar.common.exception.CustomExceptions;

import java.util.regex.Pattern;

public class InputValidator {
	
	private static final Pattern CAR_MAMES_PATTERN = Pattern.compile("(.+,)+.+");
	
	public void validateCarNames(String carNamesInput) {
		if (!CAR_MAMES_PATTERN.matcher(carNamesInput).matches()) {
			throw CustomExceptions.ILLEGAL_CAR_NAME_INPUT.get();
		}
	}
	
	public void validateLapCount(String lapCountInput) {
		try {
			Integer.parseInt(lapCountInput);
		} catch (IllegalArgumentException e) {
			throw CustomExceptions.ILLEGAL_LAP_COUNT_INPUT.get();
		}
	}
}
