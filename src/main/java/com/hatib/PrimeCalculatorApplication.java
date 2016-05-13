package com.hatib;

import com.codahale.metrics.health.jvm.ThreadDeadlockHealthCheck;
import com.hatib.resources.naive.NaivePrimeCalculatorResource;
import com.hatib.resources.skipevennumbers.SkipEvenNumbersCalculatorResource;
import com.hatib.resources.squareroot.SquareRootPrimeCalculatorResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PrimeCalculatorApplication extends Application<PrimeCalculatorConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PrimeCalculatorApplication().run(args);
    }

    @Override
    public String getName() {
        return "PrimeCalculator";
    }

    @Override
    public void initialize(final Bootstrap<PrimeCalculatorConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PrimeCalculatorConfiguration configuration, final Environment environment) {
        environment.jersey().register(NaivePrimeCalculatorResource.class);
        environment.jersey().register(SkipEvenNumbersCalculatorResource.class);
        environment.jersey().register(SquareRootPrimeCalculatorResource.class);
        environment.healthChecks().register("deadlocks", new ThreadDeadlockHealthCheck());
        System.out.println(environment.healthChecks().getNames());

    }
}
