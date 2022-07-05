package com.example.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameGenerator {

    private List<String> names;

    public NameGenerator() {

        names = new ArrayList<>();
        BufferedReader reader = null;

        try {

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("names.csv");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = reader.readLine()) != null) {
                names.add(line);
            }

        } catch (IOException e) {
            System.err.println("error occurred.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.print("error occurred");
            }
        }
    }

    public String generateName() {
        int index = new Random().nextInt(1000);
        return names.get(index);
    }

    public static void main(String[] args) throws IOException {
        NameGenerator generator = new NameGenerator();
        String name = generator.generateName();
        System.out.println(name);
    }
}