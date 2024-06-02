package compoiteStrategy.strategy.impl;

import compoiteStrategy.strategy.Strategy;

public class RUPStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.print(" using Waterfall methodology");

    }
}
