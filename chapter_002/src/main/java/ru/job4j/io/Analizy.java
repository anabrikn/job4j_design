package ru.job4j.io;

import java.io.*;
import java.util.LinkedList;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            LinkedList<String> list = new LinkedList<>();
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("200")) {
                    line = line.replace("200", "1");
                }
                if (line.startsWith("300")) {
                    line = line.replace("300", "1");
                }
                if (line.startsWith("400")) {
                    line = line.replace("400", "0");
                }
                if (line.startsWith("500")) {
                    line = line.replace("500", "0");
                }
                list.add(line);
            }
            reader.close();
            try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
                String start;
                String end;
                int first;
                int second;
                for (int i = 0; i < list.size() - 1; i++) {
                    first = Integer.parseInt(list.get(i).split(" ")[0]);
                    second = Integer.parseInt(list.get(i + 1).split(" ")[0]);
                    if (first > second) {
                        start = list.get(i + 1).split(" ")[1];
                        out.write(start + ";");
                    }
                    if (first < second) {
                        end = list.get(i + 1).split(" ")[1];
                        out.write(end + System.lineSeparator());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
