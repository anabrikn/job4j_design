package ru.job4j.srp;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.function.Predicate;

public class ReportHTML implements Report {
    private Store store;

    public ReportHTML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<title>Отчет</title>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator());
        text.append("<body>").append(System.lineSeparator());
        text.append("<h1>Name; Hired; Fired; Salary;</h1>").append(System.lineSeparator());

        text.append("<ol>").append(System.lineSeparator());
        store.findBy(filter).forEach(employee -> text.append("<li>")
                .append(employee.getName()).append(";")
                .append(employee.getHired().getTime()).append(";")
                .append(employee.getFired().getTime()).append(";")
                .append(employee.getSalary()).append(";")
                .append("</li>")
                .append(System.lineSeparator())
        );
        text.append("</ol>").append(System.lineSeparator());

        text.append("</body>").append(System.lineSeparator());
        text.append("</html>").append(System.lineSeparator());
        return text.toString();
    }
}
/*
for (Employee employee : store.findBy(filter)) {
            text.append("<li>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired().getTime()).append(";")
                    .append(employee.getFired().getTime()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</li>")
                    .append(System.lineSeparator());
        }
 */

/*
<html>
  <head>
    <meta charset="utf-8">
    <title>Абзацы</title>
    <link rel="stylesheet" href="style.css">
  </head>
  <body>
    <h1>Список изученных тегов</h1>
    <ul>
      <li>html</li>
      <li>head</li>
      <li>body</li>
      <!-- добавьте пункты сюда -->
    </ul>
    <p>Неупорядоченный список используется для простого перечисления объектов, когда порядок неважен.</p>

    <h1>Какие бывают заголовки?</h1>
    <p>Теги заголовков и подзаголовков в порядке убывания значимости:</p>
    <ol>
      <li>h1</li>
      <li>h2</li>
      <li>h3</li>
      <!-- добавьте пункты сюда -->
    </ol>
    <p>Упорядоченный список используется для перечисления объектов или действий, когда важен порядок.</p>
  </body>
</html>
 */