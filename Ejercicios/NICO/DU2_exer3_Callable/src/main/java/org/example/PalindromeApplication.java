package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


class PalindromeChecker implements Callable<String> {
    private final String word;

    public PalindromeChecker(String word) {
        this.word = word;
    }

    @Override
    public String call() {
        String reversed = new StringBuilder(word).reverse().toString();
        boolean isPalindrome = word.equalsIgnoreCase(reversed);
        return word + " is " + (isPalindrome ? "" : "not ") + "a palindrome.";
    }
}

public class PalindromeApplication {
    public static void main(String[] args) {
        String[] words = {"kayak", "deified", "rotator", "hello", "deed", "java", "wow", "noon", "civic", "level"};
        List<Callable<String>> tasks = new ArrayList<>();

        for (String word : words) {
            tasks.add(new PalindromeChecker(word));
        }

        tasks.parallelStream().forEach(task -> {
            try {
                System.out.println(task.call());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
