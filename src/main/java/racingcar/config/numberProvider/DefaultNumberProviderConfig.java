package racingcar.config.numberProvider;

import racingcar.service.numberProvider.NumberProvider;
import racingcar.service.numberProvider.RandomNumberProvider;

public class DefaultNumberProviderConfig implements NumberProviderConfig {
	
	private final NumberProvider numberProvider;
	
	public DefaultNumberProviderConfig() {
		this.numberProvider = new RandomNumberProvider();
	}
	
	@Override
	public NumberProvider getNumberProvider() {
		return numberProvider;
	}
}
