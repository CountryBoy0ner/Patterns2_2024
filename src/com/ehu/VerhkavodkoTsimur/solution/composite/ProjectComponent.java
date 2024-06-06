package com.ehu.VerhkavodkoTsimur.solution.composite;

public interface ProjectComponent {

    void add(ProjectComponent component);
    void remove(ProjectComponent component);
    boolean checkIfDone();
    void execute();
}
