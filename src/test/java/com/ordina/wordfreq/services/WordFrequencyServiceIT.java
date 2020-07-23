package com.ordina.wordfreq.services;

import com.ordina.wordfreq.model.WordFrequencyImpl;
import com.ordina.wordfreq.rest.WordFrequencyService;
import org.junit.jupiter.api.Test;
import org.microshed.testing.SharedContainerConfig;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;

import static org.assertj.core.api.Assertions.assertThat;

@MicroShedTest
@SharedContainerConfig(AppDeploymentConfig.class)
public class WordFrequencyServiceIT {
    
    @RESTClient
    public static WordFrequencyService service;

    @Test
    void test_calculateHighestFrequency_calculates_correctly() {
        assertThat(service.calculateHighestFrequency("The sun shines over the lake").getFrequency()).isEqualTo(2);
    }

    @Test
    void test_calculateFrequencyForWord_calculates_correctly() {
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "the").getFrequency()).isEqualTo(2);
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "The").getFrequency()).isEqualTo(2);
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "sun").getFrequency()).isEqualTo(1);
        assertThat(service.calculateFrequencyForWord("The sun shines over the lake", "moon").getFrequency()).isEqualTo(0);
    }

    @Test
    void test_calculateMostFrequentNWords_calculates_correctly() {

        assertThat(service.calculateMostFrequentNWords("The the sun the Sun lake", 3).getMostFrequent())
                .containsExactlyInAnyOrder(
                        new WordFrequencyImpl("the", 3),
                        new WordFrequencyImpl("sun", 2),
                        new WordFrequencyImpl("lake", 1)
                );

        assertThat(service.calculateMostFrequentNWords("The sun shines over the lake", 0).getMostFrequent()).isEmpty();
    }
}
