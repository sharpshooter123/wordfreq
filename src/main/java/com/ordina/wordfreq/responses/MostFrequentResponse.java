package com.ordina.wordfreq.responses;

import com.ordina.wordfreq.model.WordFrequency;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class MostFrequentResponse {

    private final List<WordFrequency> mostFrequent;

    @JsonbCreator
    public MostFrequentResponse(@JsonbProperty("mostFrequent") List<WordFrequency> mostFrequent) {
        this.mostFrequent = mostFrequent;
    }

    public List<WordFrequency> getMostFrequent() {
        return mostFrequent;
    }
}
