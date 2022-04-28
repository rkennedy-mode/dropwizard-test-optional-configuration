package com.mode.ryankennedy.dwoptional;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import java.util.Optional;

public class TestConfiguration extends Configuration {
    @JsonProperty
    private Optional<String> optionalConfig = Optional.empty();

    public Optional<String> getOptionalConfig() {
        return optionalConfig;
    }
}
