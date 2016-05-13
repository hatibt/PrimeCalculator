package com.hatib.resources.sieve;

import com.hatib.resources.AbstractPrimeCalculatorResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

/**
 * Created by Hatib on 13/05/2016.
 */
@Singleton
@Path("/primes")
public class SievePrimeCalculatorResource extends AbstractPrimeCalculatorResource {

    private final static Logger logger = LoggerFactory.getLogger(SievePrimeCalculatorResource.class);

    public SievePrimeCalculatorResource() {
        super(new SievePrimeCalculator());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sieve/calculate/{primeposition}")
    public void calculate(@Suspended final AsyncResponse asyncResponse,  @NotNull() @Min(1) @PathParam("primeposition")  Integer primeNumberPosition) {
        logger.info(String.format("calculate primeNumberPosition = %d", primeNumberPosition));
        super.calculateAsynchronously(asyncResponse, primeNumberPosition);
    }
}
