package com.ehu.VerhkavodkoTsimur.solution.strategy.impl;

import com.ehu.VerhkavodkoTsimur.solution.observer.Observer;
import com.ehu.VerhkavodkoTsimur.solution.strategy.Strategy;

public class WaterfallStrategy implements Strategy {
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
        return "waterfall strategy";
    }
}