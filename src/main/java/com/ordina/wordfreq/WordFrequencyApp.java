package com.ordina.wordfreq;

import com.ordina.wordfreq.rest.WordFrequencyDeserializer;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.ContextResolver;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class WordFrequencyApp extends Application {
}
