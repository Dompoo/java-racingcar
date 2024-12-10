package racingcar.common.dto;

public record CarStatus(
		String name,
		int position
) implements Comparable<CarStatus> {
	
	@Override
	public int compareTo(CarStatus o) {
		if (this.position != o.position) {
			return o.position - this.position;
		}
		return this.name.compareTo(o.name);
	}
}
