package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Calendar;

public class ReportSalaryTest {
    @Test
    public void whenCountGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Vano", now, now, 150);
        Employee worker3 = new Employee("Johan", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        ReportSalary engine = new ReportSalary(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getHired().getTime()).append(";")
                .append(worker1.getFired().getTime()).append(";")
                .append("84.0").append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getHired().getTime()).append(";")
                .append(worker2.getFired().getTime()).append(";")
                .append("126.0").append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getHired().getTime()).append(";")
                .append(worker3.getFired().getTime()).append(";")
                .append("168.0").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}