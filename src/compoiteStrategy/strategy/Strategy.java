package compoiteStrategy.strategy;

import compoiteStrategy.observer.Observer;

public interface Strategy {
    void execute();
    void setObserver(Observer observer);
    String message();
}
