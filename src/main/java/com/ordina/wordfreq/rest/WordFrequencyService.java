package com.ordina.wordfreq.rest;

import com.ordina.wordfreq.responses.FrequencyResponse;
import com.ordina.wordfreq.responses.MostFrequentResponse;
import com.ordina.wordfreq.services.WordFrequencyAnalyzer;
import com.ordina.wordfreq.services.WordFrequencyAnalyzerImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WordFrequencyService {

    private WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzerImpl();

    @GET
    @Path("/calculateHighestFrequency")
    public FrequencyResponse calculateHighestFrequency(@QueryParam("text") @NotEmpty String text) {
        return new FrequencyResponse(analyzer.calculateHighestFrequency(text));
    }

    @GET
    @Path("/calculateFrequencyForWord")
    public FrequencyResponse calculateFrequencyForWord(@QueryParam("text") @NotEmpty String text,
                                                       @QueryParam("word") @NotEmpty String word) {
        return new FrequencyResponse(analyzer.calculateFrequencyForWord(text, word));
    }

    @GET
    @Path("/calculateMostFrequentNWords")
    public MostFrequentResponse calculateMostFrequentNWords(@QueryParam("text") @NotEmpty String text,
                                                       @QueryParam("n") int n) {
        return new MostFrequentResponse(analyzer.calculateMostFrequentNWords(text, n));
    }
}
