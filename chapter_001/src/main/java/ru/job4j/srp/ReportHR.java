package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportHR implements Report {
    private Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        List<Employee> rsl = store.findBy(filter).stream()
                .sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary()))
                .collect(Collectors.toList());
        rsl.forEach(employee -> text
                .append(employee.getName()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator())
        );
        return text.toString();
    }
}

/*
for (Employee employee : rsl) {
            text
            .append(employee.getName()).append(";")
            .append(employee.getSalary()).append(";")
            .append(System.lineSeparator());
        }

sorted()

sorted(Comparator comparator) – сортирует стрим (сортировка как у TreeMap):
stream.sorted().forEach(x -> System.out.println(x));
 */