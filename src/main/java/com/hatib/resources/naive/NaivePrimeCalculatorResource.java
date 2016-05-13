package com.hatib.resources.naive;

import com.hatib.resources.AbstractPrimeCalculatorResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 * Created by Hatib on 11/05/2016.
 */
@Singleton
@Path("/primes")
public class NaivePrimeCalculatorResource extends AbstractPrimeCalculatorResource {

    private final static Logger logger = LoggerFactory.getLogger(NaivePrimeCalculatorResource.class);

    public NaivePrimeCalculatorResource() {
        super(new NaivePrimeCalculator(new NaivePrimeChecker()));
    }

    @GET
    @Path("/naive/calculate/{primeposition}")
    public void calculate(@Suspended final AsyncResponse asyncResponse, @PathParam("primeposition") @NotNull Integer primeNumberPosition) {
        logger.info(String.format("calculate primeNumberPosition = %d", primeNumberPosition));
        super.calculateAsynchronously(asyncResponse, primeNumberPosition);
    }
}
