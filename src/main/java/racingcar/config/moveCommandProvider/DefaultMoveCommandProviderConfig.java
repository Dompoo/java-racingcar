package racingcar.config.moveCommandProvider;

import racingcar.config.numberProvider.NumberProviderConfig;
import racingcar.domain.moveCommandProvider.MoveCommandProvider;
import racingcar.domain.moveCommandProvider.NumberMoveCommandProvider;

public class DefaultMoveCommandProviderConfig implements MoveCommandProviderConfig {
	
	private final MoveCommandProvider moveCommandProvider;
	
	public DefaultMoveCommandProviderConfig(NumberProviderConfig numberProviderConfig) {
		this.moveCommandProvider = new NumberMoveCommandProvider(numberProviderConfig.getNumberProvider());
	}
	
	@Override
	public MoveCommandProvider getMoveCommandProvider() {
		return moveCommandProvider;
	}
}
