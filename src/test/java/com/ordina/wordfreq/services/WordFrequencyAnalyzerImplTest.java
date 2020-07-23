package com.ordina.wordfreq.services;

import com.ordina.wordfreq.model.WordFrequencyImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.MapEntry.entry;

public class WordFrequencyAnalyzerImplTest {

    private WordFrequencyAnalyzerImpl service;

    @BeforeEach
    void setUp() {
        service = new WordFrequencyAnalyzerImpl();
    }

    @Test
    void test_calculateHighestFrequency_calculates_correctly() {
        assertThat(service.calculateHighestFrequency("The sun shines over the lake")).isEqualTo(2);
    }
    @Test
    void test_calculateHighestFrequency_handles_null_and_empty_input() {
        assertThat(service.calculateHighestFrequency(null)).isEqualTo(0);
        assertThat(service.calculateHighestFrequency("")).isEqualTo(0);
    }

    @Test
    void test_calculateFrequencyForWord_calculates_correctly() {
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "the")).isEqualTo(2);
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "The")).isEqualTo(2);
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "sun")).isEqualTo(1);
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "moon")).isEqualTo(0);
    }

    @Test
    void test_calculateFrequencyForWord_handles_null_and_empty_input() {
        assertThat(service.calculateFrequencyForWord(null, "the")).isEqualTo(0);
        assertThat(service.calculateFrequencyForWord("", "the")).isEqualTo(0);
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", null)).isEqualTo(0);
    }

    @Test
    void test_calculateMostFrequentNWords_calculates_correctly() {

        assertThat(service.calculateMostFrequentNWords("The sun shines over the lake", 3))
                .containsExactly(
                        new WordFrequencyImpl("the", 2),
                        new WordFrequencyImpl("lake", 1),
                        new WordFrequencyImpl("over", 1)
                );

        assertThat(service.calculateMostFrequentNWords("The the sun the Sun lake", 3))
                .containsExactly(
                        new WordFrequencyImpl("the", 3),
                        new WordFrequencyImpl("sun", 2),
                        new WordFrequencyImpl("lake", 1)
                );

        assertThat(service.calculateMostFrequentNWords("The sun shines over the lake", 0)).isEmpty();
    }

    @Test
    void test_calculateMostFrequentNWords_handles_null_and_empty_input() {
        assertThat(service.calculateMostFrequentNWords(null, 10)).isEmpty();
        assertThat(service.calculateMostFrequentNWords("", 10)).isEmpty();
    }

    @Test
    void test_countWords_handles_null_and_empty_input() {
        assertThat(service.countWords(null)).isEmpty();
        assertThat(service.countWords("")).isEmpty();
    }

    @Test
    void test_countWords_counts_correctly() {
        assertThat(service.countWords("The sun shines over the lake")).containsOnly(
                entry("the", 2),
                entry("sun", 1),
                entry("shines", 1),
                entry("over", 1),
                entry("lake", 1)
        );
    }

    @Test
    void test_countWords_various_separators() {
        assertThat(service.countWords("Test123string$%^test")).containsOnly(
                entry("test", 2),
                entry("string", 1)
        );
    }

    @Test
    void test_countWords_trailing_separators() {
        assertThat(service.countWords("   Test string test   ")).containsOnly(
                entry("test", 2),
                entry("string", 1)
        );
    }
}