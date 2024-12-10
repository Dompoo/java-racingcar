package racingcar.service.numberProvider;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberProvider implements NumberProvider {
	
	@Override
	public int providerNumberInRange(int startInclusive, int endInclusive) {
		return Randoms.pickNumberInRange(startInclusive, endInclusive);
	}
}
