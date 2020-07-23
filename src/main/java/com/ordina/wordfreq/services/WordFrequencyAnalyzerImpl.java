package com.ordina.wordfreq.services;

import com.ordina.wordfreq.model.WordFrequency;
import com.ordina.wordfreq.model.WordFrequencyImpl;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    @Override
    public int calculateHighestFrequency(String text) {
        return countWords(text).values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        if (word == null) {
            return 0;
        }
        Integer count = countWords(text).get(word.toLowerCase());
        return count != null ? count : 0;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        return countWords(text).entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .limit(n)
                .map(e -> new WordFrequencyImpl(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Calculates frequency of every word in the given string.
     * <p>
     * Words are defined as continuous sequences of characters a-z and A-Z. The rest are separators.
     * <p>
     * Implementation note: the implementation works with the input in the <a href="https://www.oracle.com/technical-resources/articles/javase/supplementary.html">Basic Multilingual Plane</a>
     * If processing of characters in Supplementary Planes is desired, the method has to be changed accordingly to work with codepoints instead of characters.
     *
     * @param str String to count words in.
     * @return Map containing found words in lowercase as keys and their count as values.
     *                          A null or empty input results in an empty map.
     */
    Map<String, Integer> countWords(String str) {

        if (str == null) {
            return Collections.emptyMap();
        }

        int len = str.length();
        if (len == 0) {
            return Collections.emptyMap();
        }

        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        int start = 0;
        boolean wordCharFound = false;
        while (i < len) {
            if (isSeparator(str.charAt(i))) {
                if (wordCharFound) {
                    incrementWordCount(map, str.substring(start, i));
                    wordCharFound = false;
                }
                start = ++i;
                continue;
            }
            wordCharFound = true;
            i++;
        }
        if (wordCharFound) {
            incrementWordCount(map, str.substring(start, i));
        }

        return map;
    }

    private static boolean isSeparator(char c) {
        return !('A' <= c && c <= 'Z' || 'a' <= c && c <= 'z');
    }

    private static void incrementWordCount(Map<String, Integer> map, String word) {

        word = word.toLowerCase();
        Integer count = map.get(word);
        if (count == null) {
            map.put(word, Integer.valueOf(1));
        } else {
            map.put(word, Integer.valueOf(count + 1));
        }
    }
}
