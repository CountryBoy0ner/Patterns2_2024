package compoiteStrategy.composite.task.impl;

import compoiteStrategy.observer.Observer;
import compoiteStrategy.observer.Subject;
import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.composite.ProjectComponent;

import java.util.ArrayList;
import java.util.List;

public class Task implements ProjectComponent, Subject, Observer {
    private long id;
    private TaskType type;
    private Strategy strategy;
    private boolean done = false;
    private List<Observer> observers = new ArrayList<>();

    public Task(long id, TaskType type, Strategy strategy) {
        this.id = id;
        this.type = type;
        this.strategy = strategy;
        this.strategy.setObserver(this);
    }

    public Task(long id, TaskType type) {
        this.id = id;
        this.type = type;

    }

    @Override
    public void add(ProjectComponent component) {
        // пусто
    }

    @Override
    public void remove(ProjectComponent component) {
        // пусто
    }

    @Override
    public boolean checkIfDone() {
        return this.done;
    }

    @Override
    public void execute() {
        System.out.println("Executing task " + id+" using "+this.getStrategy().message());
        this.setDone(true);
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
            this.strategy.setObserver(this);
            this.done = false;
    }

    public void setDone(boolean done) {
        this.done = done;
        notifyObservers();
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public boolean isDone() {
        return done;
    }

    public TaskType getType() {
        return type;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", type=" + type +
                ", strategy=" + strategy +
                ", done=" + done +
                '}';
    }
}