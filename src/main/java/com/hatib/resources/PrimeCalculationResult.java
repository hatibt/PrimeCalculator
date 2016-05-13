package com.hatib.resources;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PrimeCalculationResult {
    private int position;
    private long primeNumber;
    private long calculationTimeInMilliSecs;

    public PrimeCalculationResult() {
    }

    public PrimeCalculationResult(Integer position, long primeNumber, long calculationTimeInMilliSecs) {
        this.position = position;
        this.primeNumber = primeNumber;
        this.calculationTimeInMilliSecs = calculationTimeInMilliSecs;
    }

    public Integer getPosition() {
        return position;
    }

    public Long getPrimeNumber() {
        return primeNumber;
    }

    public Long getCalculationTimeInMilliSecs() {
        return calculationTimeInMilliSecs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        PrimeCalculationResult that = (PrimeCalculationResult) o;

        return new EqualsBuilder()
                .append(position, that.position)
                .append(primeNumber, that.primeNumber)
                .append(calculationTimeInMilliSecs, that.calculationTimeInMilliSecs)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(position)
                .append(primeNumber)
                .append(calculationTimeInMilliSecs)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("position", position)
                .append("primeNumber", primeNumber)
                .append("calculationTimeInMilliSecs", calculationTimeInMilliSecs)
                .toString();
    }
}
