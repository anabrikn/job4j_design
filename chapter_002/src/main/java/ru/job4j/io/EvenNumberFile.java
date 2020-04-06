package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = fileInputStream.read()) != -1) {
                text.append((char) read);
            }

            int number;
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                number = Integer.parseInt(line);
                System.out.println(number + (number % 2 == 0 ? " четное" : " нечетное"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}