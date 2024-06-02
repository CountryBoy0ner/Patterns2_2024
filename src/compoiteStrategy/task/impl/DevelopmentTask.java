package compoiteStrategy.task.impl;

import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.task.Task;

import static compoiteStrategy.constant.Constant.DEVELOPMENT;

public class DevelopmentTask extends AbstractTask {


    public DevelopmentTask(Strategy strategy) {
        super(strategy,DEVELOPMENT);
    }
}
