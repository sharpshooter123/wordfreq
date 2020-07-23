package com.ordina.wordfreq.rest;

import com.ordina.wordfreq.model.WordFrequency;
import com.ordina.wordfreq.model.WordFrequencyImpl;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

public class WordFrequencyDeserializer implements JsonbDeserializer<WordFrequency> {

    private static final Jsonb JSONB = JsonbBuilder.create();

    @Override public WordFrequency deserialize(JsonParser parser, DeserializationContext ctx, Type rtType) {
        return JSONB.fromJson(parser.getObject().toString(), WordFrequencyImpl.class);
    }
}
