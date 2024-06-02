package compoiteStrategy.strategy.impl;

import compoiteStrategy.strategy.Strategy;

public class AgileStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.print(" using Agile methodology");

    }
}
