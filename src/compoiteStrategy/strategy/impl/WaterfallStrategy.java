package compoiteStrategy.strategy.impl;

import compoiteStrategy.strategy.Strategy;

public class WaterfallStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.print(" using RUP methodology");

    }
}
