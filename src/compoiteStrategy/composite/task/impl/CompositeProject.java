package compoiteStrategy.composite.task.impl;

import compoiteStrategy.composite.ProjectComponent;
import compoiteStrategy.observer.Observer;
import compoiteStrategy.observer.Subject;
import compoiteStrategy.strategy.Strategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CompositeProject implements ProjectComponent, Observer, Subject {
    private boolean done = false;
    private long id;
    private List<Observer> observers = new ArrayList<>();
    private Strategy strategy;
    private LinkedList<ProjectComponent> listComponent = new LinkedList<>();

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
        this.strategy.setObserver(this);
        this.done = false;
    }
    public Strategy getStrategy() {
        return strategy;
    }

    public CompositeProject(long id) {
        this.id = id;
    }

    public CompositeProject(long id, Strategy strategy) {
        this.id = id;
        this.strategy = strategy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public void add(ProjectComponent component) {
        listComponent.add(component);
    }

    @Override
    public void remove(ProjectComponent component) {
        listComponent.remove(component);
    }

    @Override
    public boolean checkIfDone() {
        for (ProjectComponent component : listComponent) {
            if (!component.checkIfDone()) {
                return false;
            }
        }
        return this.done;
    }

    @Override
    public void execute() {
        System.out.println("Executing composite task " + id +" using "+this.getStrategy().message());
        for (ProjectComponent component : listComponent) {
            component.execute();
        }
        this.done = true;
        notifyObservers();
    }

    @Override
    public void update() {
        this.execute();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
