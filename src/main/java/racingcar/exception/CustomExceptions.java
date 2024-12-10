package racingcar.exception;

public enum CustomExceptions {
	
	INVALID_LAP_COUNT(
			"시도할 회수는 %d~%d번 사이 입니다.",
			IllegalArgumentException.class
	),
	INVALID_CAR_NAME_LENGTH(
			"자동차 이름은 최대 %d자 입니다.",
			IllegalArgumentException.class
	),
	DUPLICATED_CAR_NAME(
			"자동차 이름은 중복될 수 없습니다.",
			IllegalArgumentException.class
	),
	INVALID_CAR_COUNT(
			"자동차 개수는 %d~%d개 입니다.",
			IllegalArgumentException.class
	),
	;
	
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
