package racingcar.common.exception;

public enum CustomExceptions {
	
	ILLEGAL_CAR_NAME_INPUT(
			"자동차 이름 입력 포맷이 잘못되었습니다.",
			IllegalArgumentException.class
	),
	ILLEGAL_LAP_COUNT_INPUT(
			"시도 회수 입력 포맷이 잘못되었습니다.",
			IllegalArgumentException.class
	),
	INVALID_LAP_COUNT(
			"시도할 회수는 %d~%d번 사이 입니다.",
			IllegalArgumentException.class
	),
	INVALID_CAR_NAME_LENGTH(
			"자동차 이름은 %d~%d자 사이 입니다.",
			IllegalArgumentException.class
	),
	DUPLICATED_CAR_NAME(
			"자동차 이름은 중복될 수 없습니다.",
			IllegalArgumentException.class
	),
	INVALID_CAR_COUNT(
			"자동차 개수는 %d~%d개 사이 입니다.",
			IllegalArgumentException.class
	);
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	CustomExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get(Object... args) {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message.formatted(args));
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}
