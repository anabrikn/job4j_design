package ru.job4j.tdd.cinema;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    int sessionCount = 0;
    boolean[][] tickets = {{true, false, false, false}, {false, false, false, false}};

    public Cinema3D() {
        super();
    }

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        Ticket3D result = null;
        if (tickets[row][column]) {
            result = new Ticket3D();
        }
        return result;

    }

    @Override
    public void add(Session session) {
        sessionCount++;
    }
}