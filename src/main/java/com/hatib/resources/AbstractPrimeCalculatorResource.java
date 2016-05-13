package com.hatib.resources;

import jersey.repackaged.com.google.common.cache.CacheBuilder;
import jersey.repackaged.com.google.common.cache.CacheLoader;
import jersey.repackaged.com.google.common.cache.LoadingCache;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;

/**
 * Created by Hatib on 11/05/2016.
 *
 * asynchronously handles the calls received by the endpoints/resources and checks cache. if prime not in cache will calculate the prime.
 *
 * uses template pattern to facilitate the different ways the endpoints use to calculate the prime numbers
 *
 */
public abstract class AbstractPrimeCalculatorResource {

    private final static Logger logger = LoggerFactory.getLogger(AbstractPrimeCalculatorResource.class);

    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();

    protected LoadingCache<Integer, Long> primesCache;

    public AbstractPrimeCalculatorResource(final PrimeCalculator primeCalculator) {
        final CacheLoader<Integer, Long> loader = new CacheLoader<Integer, Long>() {
            @Override
            public Long load(Integer primeNumberPosition) throws Exception {
                return primeCalculator.getNthPrimeNumber(primeNumberPosition);
            }
        };

        primesCache = CacheBuilder.newBuilder()
                .concurrencyLevel(4)
                .maximumSize(1000)
                .build(loader);
    }

    protected void calculateAsynchronously(final AsyncResponse asyncResponse, final Integer primeNumberPosition) {
        executorService.submit(() -> {
            Response response =  getPrime(primeNumberPosition);
            asyncResponse.resume(response);
        });
    }

    private Response getPrime(final Integer primeNumberPosition) {
        try {
            long startTime = DateTime.now().getMillis();
            final Long result = this.primesCache.get(primeNumberPosition);
            long calculationTimeInMilliSecs = (DateTime.now().getMillis() - startTime);
            final PrimeCalculationResult primeCalculationResult = new PrimeCalculationResult(primeNumberPosition, result, calculationTimeInMilliSecs);
            logger.info(String.format("getPrime, primeCalculationResult = %s ", primeCalculationResult));
            return Response.ok(primeCalculationResult).build();
        } catch (Exception e) {
            final String errMessage = String.format("Error when calculating primeNumberPosition = %d", primeNumberPosition);
            logger.error(errMessage, e);
            final ErrorMessage errorMessage = new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), errMessage);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).type(MediaType.APPLICATION_JSON_TYPE).build();
        }
    }
}

