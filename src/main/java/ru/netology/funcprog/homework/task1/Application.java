package ru.netology.funcprog.homework.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void run() throws IOException {
        System.out.println("Text of note: ");
        List<String> wordsList = intoDictionary(reader.readLine());
        showDictionary(wordsList);
    }

    private static List<String> intoDictionary(String word) {
        List<String> wordsInDictionary = new ArrayList<>(Arrays.asList(word.trim().split(" ")));
        return wordsInDictionary.stream().filter(x -> x.length() > 0)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private static void showDictionary(List<String> dictionary) {
        System.out.println("\nNew words in dictionary: ");
        for (String s : dictionary) {
            System.out.println(s);
        }
    }
}
