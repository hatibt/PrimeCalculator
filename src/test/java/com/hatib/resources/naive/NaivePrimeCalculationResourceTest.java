package com.hatib.resources.naive;


import com.hatib.resources.PrimeCalculationResult;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by Hatib on 11/05/2016.
 */
public class NaivePrimeCalculationResourceTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new NaivePrimeCalculatorResource())
            .setTestContainerFactory(new GrizzlyWebTestContainerFactory())
            .build();


    @Test
    public void testInvalidRequestPrimeNumberPositionMissing() {
        Response response = resources.getJerseyTest().target("/primes/naive/calculate/").request().buildGet().invoke();
        Assert.assertEquals(response.getStatus(), 404);
    }


    @Test
    public void testInvalidRequestPrimeNumberPositionIsNotANumber() {
        Response response = resources.getJerseyTest().target("/primes/naive/calculate/A").request().buildGet().invoke();
        Assert.assertEquals(response.getStatus(), 404);
    }


    @Test
    public void testValidRequestPrimeNumberPositionIsAnInteger() {
        final Response response = resources.getJerseyTest().target("/primes/naive/calculate/99").request().buildGet().invoke();
        final PrimeCalculationResult primeCalculationResult = response.readEntity(PrimeCalculationResult.class);

        Assert.assertEquals(response.getStatus(), 200);
        Assert.assertEquals(primeCalculationResult.getPosition().longValue(), 99l);
        Assert.assertEquals(primeCalculationResult.getPrimeNumber().longValue(), 523l);
    }

    @Test
    public void testValidRequestPrimeNumberPositionIsTooLargeToBeAnInteger() {
        Response response = resources.getJerseyTest().target("/primes/naive/calculate/9999999999999999999999999").request().buildGet().invoke();
        Assert.assertEquals(response.getStatus(), 404);
    }

}