package compoiteStrategy.composite;

import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.task.Task;

import java.util.ArrayList;
import java.util.List;

public class CompositeTask implements Task {
    private String name;
    private List<Task> tasks = new ArrayList<>();

    public CompositeTask(String name) {
        this.name = name;
    }


    @Override
    public void execute() {
        System.out.println("-------------------------\n"+name + " contains the following tasks:");
        for (Task task : tasks) {
            task.execute();
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(Task task) {
        tasks.remove(task);
    }
    public Task getSubtask(int i) {
        return tasks.get(i);
    }

}
