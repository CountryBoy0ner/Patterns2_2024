package main;

import compoiteStrategy.composite.task.impl.CompositeProject;
import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.strategy.impl.AgileStrategy;
import compoiteStrategy.strategy.impl.RUPStrategy;
import compoiteStrategy.strategy.impl.SpiralStrategy;
import compoiteStrategy.strategy.impl.WaterfallStrategy;
import compoiteStrategy.composite.task.impl.TaskType;
import compoiteStrategy.composite.task.impl.Task;

public class Main {
    public static void main(String[] args) {
        Strategy agileStrategy = new AgileStrategy();
        Strategy rupStrategy = new RUPStrategy();
        Strategy spiralStrategy = new SpiralStrategy();
        Strategy waterfallStrategy = new WaterfallStrategy();

        Task subtask1 = new Task(700, TaskType.DESIGN, agileStrategy);
        Task subtask2 = new Task(701, TaskType.TESTING, rupStrategy);
        Task subtask3 = new Task(707, TaskType.DEVELOPMENT, spiralStrategy);
        Task subtask4 = new Task(777, TaskType.DEVELOPMENT, waterfallStrategy);
        Task subtask5 = new Task(717, TaskType.DESIGN, rupStrategy);
        Task subtask6 = new Task(771, TaskType.TESTING, waterfallStrategy);

        CompositeProject project = new CompositeProject(1,waterfallStrategy);
        CompositeProject task1 = new CompositeProject(2,waterfallStrategy);
        CompositeProject task2 = new CompositeProject(3,waterfallStrategy);

        project.add(task1);
        project.add(task2);
        project.add(subtask1);
        project.add(subtask6);

        task1.add(subtask2);
        subtask1.setStrategy(waterfallStrategy);
        task1.add(subtask4);
        task2.add(subtask3);
        task2.add(subtask5);

        System.out.println("project status isDone: " + project.checkIfDone());
        System.out.println("task2 status isDone: " + task2.checkIfDone());

        project.setStrategy(waterfallStrategy);
        project.getStrategy().execute();
        System.out.println("project status isDone: " + project.checkIfDone());

        project.setDone(false);
        subtask1.setDone(false);
        subtask2.setDone(false);
        subtask3.setDone(false);
        subtask4.setDone(false);
        subtask5.setDone(false);
        subtask6.setDone(false);
        System.out.println("project status isDone: " + project.checkIfDone());

        project.setStrategy(agileStrategy);
        project.getStrategy().execute();
        System.out.println("project status isDone: " + project.checkIfDone());
    }
}
