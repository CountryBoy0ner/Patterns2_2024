package compoiteStrategy.task.impl;

import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.task.Task;

import static compoiteStrategy.constant.Constant.DESIGN;

public class DesignTask extends AbstractTask {

    public DesignTask(Strategy strategy) {
        super(strategy,DESIGN );
    }
}

