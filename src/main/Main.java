package main;

import compoiteStrategy.composite.CompositeTask;
import compoiteStrategy.strategy.Strategy;
import compoiteStrategy.strategy.impl.AgileStrategy;
import compoiteStrategy.strategy.impl.RUPStrategy;
import compoiteStrategy.strategy.impl.SpiralStrategy;
import compoiteStrategy.strategy.impl.WaterfallStrategy;
import compoiteStrategy.task.Task;
import compoiteStrategy.task.impl.DesignTask;
import compoiteStrategy.task.impl.DevelopmentTask;
import compoiteStrategy.task.impl.TestingTask;

import static compoiteStrategy.constant.Constant.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Task design = new DesignTask(new AgileStrategy());
        Task testing = new TestingTask(new RUPStrategy());
        Task development = new DevelopmentTask(new SpiralStrategy());
        Task secondDevelopment =  new DevelopmentTask(new WaterfallStrategy());


        CompositeTask project = new CompositeTask("developmentTestingDesignTask");
        project.addTask(design);
        project.execute();

        project.addTask(testing);
        project.addTask(development);
        project.execute();

        project.removeTask(development);
        project.addTask(secondDevelopment);
        project.execute();

        project.removeTask(testing);
        project.removeTask(design);
        System.out.println("---");
        project.getSubtask(0).execute();

    }
}


//    Composite и Strategy:
//Задача: Разработать систему для управления задачами в проектном менеджере.
//Описание: Создайте классы для задач разных типов (например, задачи на разработку,
// тестирование, дизайн). Используйте Composite для объединения задач в древовидную структуру (подзадачи и проекты).
// Для каждой задачи примените Strategy, чтобы определить,
// какой алгоритм ее выполнения использовать (н-р, Agile, Waterfall, Spiral, RUP).

//### Вариант 4
//Создайте систему для обработки заказов с использованием паттернов Factory Method,
// Composite и Strategy. Factory Method будет создавать различные типы заказов,
// Composite будет представлять структуру заказа с различными компонентами,
// а Strategy будет определять способ обработки заказа.