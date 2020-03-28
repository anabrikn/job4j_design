package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportSalary implements Report {
    private Store store;

    public ReportSalary(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(System.lineSeparator());
        store.findBy(filter).forEach(employee -> text.append(employee.getName()).append(";")
                .append(employee.getHired().getTime()).append(";")
                .append(employee.getFired().getTime()).append(";")
                .append(employee.getSalary() * 0.84).append(";")
                .append(System.lineSeparator())
        );
        return text.toString();
    }
}
/*
for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired().getTime()).append(";")
                    .append(employee.getFired().getTime()).append(";")
                    .append(employee.getSalary() * 0.84).append(";")
                    .append(System.lineSeparator());
        }
 */