package ru.job4j.ood.isp;

public class Developer implements EmployeeToDo {
    @Override
    public void work() {
        System.out.println("Developer work");
    }

    @Override
    public void takeBreak() {
        System.out.println("Developer walk alone");
    }

    @Override
    public void attendMeeting() {
        System.out.println("Developer on meeting");
    }

    @Override
    public void generateReport() {
        throw new UnsupportedOperationException("Developers don't generate reports");
    }

    @Override
    public void handleCustomerQueries() {
        throw new UnsupportedOperationException("Developers don't handle customer queries");
    }
}

