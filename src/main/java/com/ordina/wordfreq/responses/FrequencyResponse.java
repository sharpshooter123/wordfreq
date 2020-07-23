package com.ordina.wordfreq.responses;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class FrequencyResponse {

    private final int frequency;

    @JsonbCreator
    public FrequencyResponse(@JsonbProperty("frequency") int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}
