package racingcar;

import racingcar.domain.moveCommandProvider.NumberMoveCommandProvider;
import racingcar.io.input.InputHandler;
import racingcar.io.input.InputParser;
import racingcar.io.input.InputValidator;
import racingcar.io.output.OutputHandler;
import racingcar.io.output.OutputParser;
import racingcar.io.reader.ConsoleReader;
import racingcar.io.writer.ConsoleWriter;
import racingcar.io.writer.Writer;
import racingcar.service.numberProvider.RandomNumberProvider;

public class Application {
    public static void main(String[] args) {
        Writer writer = new ConsoleWriter();
        new RacingGameController(
                new InputHandler(
                        new ConsoleReader(),
                        writer,
                        new InputValidator(),
                        new InputParser()
                ),
                new OutputHandler(
                        writer,
                        new OutputParser()
                ),
                new NumberMoveCommandProvider(
                        new RandomNumberProvider()
                )
        ).run();
    }
}
