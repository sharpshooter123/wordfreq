package com.ordina.wordfreq.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.util.Objects;

public class WordFrequencyImpl implements WordFrequency {

    private final String word;
    private final int frequency;

    @JsonbCreator
    public WordFrequencyImpl(@JsonbProperty("word") String word,
                             @JsonbProperty("frequency") int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordFrequencyImpl that = (WordFrequencyImpl) o;
        return frequency == that.frequency &&
                Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, frequency);
    }

    @Override
    public String toString() {
        return "WordFrequencyImpl{" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }
}
