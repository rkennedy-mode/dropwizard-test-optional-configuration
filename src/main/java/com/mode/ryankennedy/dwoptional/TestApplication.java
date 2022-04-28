package com.mode.ryankennedy.dwoptional;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TestApplication extends Application<TestConfiguration> {
    public static void main(String[] args) throws Exception {
        new TestApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(true, false)
                )
        );
    }

    @Override
    public void run(TestConfiguration testConfiguration, Environment environment) throws Exception {
        System.out.printf("optionalConfig = %s%n",
                testConfiguration.getOptionalConfig().orElse("no value specified"));
    }
}
