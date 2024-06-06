package com.ehu.VerhkavodkoTsimur.solution.strategy;

import com.ehu.VerhkavodkoTsimur.solution.observer.Observer;

public interface Strategy {
    void execute();
    void setObserver(Observer observer);
    String message();
}
