### PrimeCalculator

DropWizard implementation of 4 different algorithims for calculating primes at specific positions. 

*The dropwizard resource packages and request url paths reflect the different algorithims. For example, 
to retrieve the naive implementation to calculate the prime at position 5 you would make a request as follows:*

http://localhost:8080/primes/naive/calculate/11 

*This would return a json response,* `{"position":11,"primeNumber":31,"calculationTimeInMilliSecs":322} `

To run please add `server primecalcultaor.yml` to the prgram arguments in your ide

*A description of all 4 Algorithims with links using the default port for drop wizard 8080 URLs follows:*

####Naive

[Naive Link on 8080](http://localhost:8080/primes/naive/calculate/11)

Iterates through sequence of numbers filtering out prime numbers with isPrime, until the nth prime number is reached.
isPrime checks if number is prime by checking for divisors, from 1 to half the numbers size
 
####Square Root

[Square Root link on local host 8080](http://localhost:8080/primes/squareroot/calculate/11)

Iterates through sequence of numbers filtering out prime numbers, with isPrime until the nth prime number is reached. 
isPrime checks if number is prime by checking for for divisors, from 1 to the square root of the number

####Skip Even Numbers

[Skip Even Numbers link on local host8080](http://localhost:8080/primes/skipevennumbers/calculate/11)

Iterates through sequence of numbers filtering out prime numbers, with isPrime until the nth prime number is reached.
isPrime checks if number is prime by checking for divisors, from 1 to the square root of the number, but skipping all even numbers
 
####Sieve

[Sieve link on local host 8080](http://localhost:8080/primes/sieve/calculate/11)

First estimates number close to desired prime, then seives out prime numbers in a sequence starting from 2.
Algorithim is a mix of imperative loop and functional streams, to get around lack of tail recursion in java.
This was the most efficient algorithim.

