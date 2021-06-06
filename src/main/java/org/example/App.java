package org.example;

/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Chad Higgins
 */

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/*
Simple interest is something you use only when making a quick guess.
Most investments use a compound interest formula, which will be much more accurate.
And this formula requires you to incorporate exponents into your programs.

Write a program to compute the value of an investment compounded over time.
The program should ask for the starting amount, the number of years to invest,
the interest rate, and the number of periods per year to compound.

The formula you’ll use for this is A = P(1 + r/n)^(n*t) where

P is the principal amount.
r is the annual rate of interest.
t is the number of years the amount is invested.
n is the number of times the interest is compounded per year.
A is the amount at the end of the investment.

Example Output
What is the principal amount? 1500
What is the rate? 4.3
What is the number of years? 6
What is the number of times the interest is compounded per year? 4
$1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.

Constraints
Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
Ensure that fractions of a cent are rounded up to the next penny.
Ensure that the output is formatted as money.
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the principal: ");
        BigDecimal rPrincipal = BigDecimal.valueOf(in.nextDouble());

        System.out.println("Enter the rate of interest: ");
        BigDecimal rInterest = BigDecimal.valueOf(in.nextDouble());

        System.out.println("Enter the number of years: ");
        BigDecimal rYears = BigDecimal.valueOf(in.nextInt());

        System.out.println("What is the number of times the interest is compounded per year? ");
        BigDecimal rCompound = BigDecimal.valueOf(in.nextDouble());

        //A = P(1 + r/n)^(n*t)

        BigDecimal percentInterest = rInterest.multiply(BigDecimal.valueOf(0.01));

        //I hate this... working with money
        BigDecimal Result = rPrincipal.multiply( new BigDecimal(Math.pow(BigDecimal.valueOf(1).add(percentInterest.divide(rCompound)).doubleValue(), (rYears.doubleValue()*rCompound.doubleValue())))).setScale(2, RoundingMode.HALF_UP);
        System.out.println("$"+rPrincipal.setScale(0, RoundingMode.HALF_UP)+" invested at "+rInterest+" for "+rYears+" years compounded "+rCompound.setScale(0, RoundingMode.HALF_UP)+" times per year is $"+Result+".");
    }
}
