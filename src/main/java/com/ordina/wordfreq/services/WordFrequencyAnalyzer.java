package com.ordina.wordfreq.services;

import com.ordina.wordfreq.model.WordFrequency;

import java.util.List;

/**
 * Calculates frequencies of words in the given text.
 * <p>
 * General assumptions:
 * <ul>
 * <li>Word: A word is represented by a sequence of one or more
 * characters between „a‟ and „z‟ or between „A‟ and „Z‟. For example “agdfBh”.
 * <li>Letter Case: When counting frequencies, we are interested in the case insensitive
 * frequency (i.e. in the text “The sun shines over the lake” 2 occurrences for any of the
 * words “the” or “The” or “tHE” should be counted, etc).
 * <li>Input Text: The input text contains words separated by various separator characters.
 * Note that the characters from „a‟ and „z‟ and from „A‟ and „Z‟ can only appear within words.
 * <li>Available Memory: There is enough memory to store the whole input text.
 * </ul>
 */
public interface WordFrequencyAnalyzer {

    /**
     * Calculates the highest frequency in the text (several words might actually have this frequency).
     *
     * @param text input text to find the highest frequency of words in
     * @return highest frequency of words in the text or 0 if the given text is null or empty
     */
    int calculateHighestFrequency(String text);

    /**
     * Returns the frequency of the specified word.
     *
     * @param text input text to find the frequency of the given word in
     * @param word word for which to calculate the frequency
     * @return frequency of the given word in the text, 0 if the word is not found in the text,
     *                          the text is null or empty
     */
    int calculateFrequencyForWord(String text, String word);

    /**
     * Returns a list of the most frequent "n" words in the input text, all the words returned
     * in lower case. If several words have the same frequency, this method returns them
     * in ascendant alphabetical order (for input text “The sun shines over the lake” and n = 3,
     * it should return the list {(“the”, 2), (“lake”, 1), (“over”, 1) }.
     *
     * @param text input text to find the frequency of words in
     * @param n return up to n words and their frequencies
     * @return list with words and their frequencies. Empty list if the given
     *                      text is null or empty
     */
    List<WordFrequency> calculateMostFrequentNWords(String text, int n);
}
