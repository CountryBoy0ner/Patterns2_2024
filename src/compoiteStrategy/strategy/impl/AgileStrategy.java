package compoiteStrategy.strategy.impl;

import compoiteStrategy.observer.Observer;
import compoiteStrategy.strategy.Strategy;

public class AgileStrategy implements Strategy {
    private Observer observer;


    @Override
    public void execute() {
        if (observer != null) {
            observer.update();
        }
    }

    @Override
    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public String message() {
        return "agileStrategy";
    }
}
