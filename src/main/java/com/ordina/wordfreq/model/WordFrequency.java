package com.ordina.wordfreq.model;

import com.ordina.wordfreq.rest.WordFrequencyDeserializer;

import javax.json.bind.annotation.JsonbTypeDeserializer;

@JsonbTypeDeserializer(WordFrequencyDeserializer.class)
public interface WordFrequency {

    String getWord();

    int getFrequency();
}
