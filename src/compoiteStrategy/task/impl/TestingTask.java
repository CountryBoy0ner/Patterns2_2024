package compoiteStrategy.task.impl;

import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.task.Task;

import static compoiteStrategy.constant.Constant.TESTING;

public class TestingTask extends AbstractTask {

    public TestingTask(Strategy strategy) {
        super(strategy, TESTING);
    }
}
