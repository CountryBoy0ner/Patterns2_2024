package compoiteStrategy.task.impl;

import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.task.Task;

public abstract class AbstractTask implements Task {
    private String name;
    private Strategy strategy;

    public AbstractTask(Strategy strategy, String name) {
        this.strategy = strategy;
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public Strategy getStrategy() {
        return this.strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void execute() {
        System.out.print("executing " + this.name + "Task");
        this.strategy.execute();
        System.out.println();
    }
}