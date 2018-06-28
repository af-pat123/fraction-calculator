package com.company;

public class Fraction {

    private int Numerator=0;
    private int Denominator=1 ;


    //constructor for fractions in the form of a/b
    public Fraction(int Numerator, int Denominator){

        if (Denominator == 0){
            throw new IllegalArgumentException("denominator is 0");
        }

        //change fraction form from a/-b to -a/b
        if (Denominator<0){
            Numerator=-Numerator;
            Denominator=-Denominator;
        }
        this.Numerator=Numerator;
        this.Denominator = Denominator;
    }

    //constructors for whole numbers
    public Fraction(int wholeNum){
        this.Numerator=wholeNum;
        this.Denominator=1;
    }

    public int getNumerator(){
        return this.Numerator;
    }

    public int getDenominator(){
        return this.Denominator;
    }

    //return decimal version of fraction
    private double toDouble(){
        return (double)this.Numerator/this.Denominator;
    }

    //returns the sum of the other and this fractions
    public Fraction add(Fraction other){
        int Num;
        int Den;
        Den = other.Denominator *this.Denominator;
        Num = this.Denominator*other.Numerator+other.Denominator*this.Numerator;
        Fraction fract = new Fraction(Num,Den);
        fract.toLowestTerms();
        return fract;

    }

    //returns a new Fraction that is the difference between the other and this fraction
    public Fraction subtract(Fraction other){
        int Num;
        int Den;
        Den = other.Denominator *this.Denominator;
        Num = this.Denominator*other.Numerator-other.Denominator*this.Numerator;
        Fraction fract = new Fraction(Num,Den);
        fract.toLowestTerms();
        return fract;

    }

    //returns a new Fraction that is the product of the other and this fraction
    public Fraction multiply(Fraction other){
        int Num;
        int Den;
        Den = other.Denominator *this.Denominator;
        Num = this.Numerator*other.Numerator;
        Fraction fract = new Fraction(Num,Den);
        fract.toLowestTerms();
        return fract;

    }

    /*returns a new Fraction that is the division of the other and this fraction, throw an IllegalArgumentException()
    if the user asks you to divide by 0*/
    public Fraction divide(Fraction other){
        int Num;
        int Den;
        if (this.Numerator == 0){
            throw new IllegalArgumentException("can't divide by 0");
        }
        Num = other.Numerator*this.Denominator;
        Den = other.Denominator *this.Numerator;
        Fraction fract = new Fraction(Num,Den);
        fract.toLowestTerms();
        return fract;

    }

    //checks if two fractions are equal by seeing if their decimal forms are equal
    public Boolean equals(Fraction other){
        Boolean Check = this.toDouble()==other.toDouble();
        return Check;

    }

    //returns a string representation of the fraction
    public String toString(){
        if(this.Denominator==1){
            return Integer.toString(this.Numerator);
        }
        return Integer.toString(this.Numerator) + "/" + Integer.toString(this.Denominator);

    }

    //returns the current fraction in lowest terms
    private void toLowestTerms(){
        if (this.Numerator==0){
            this.Denominator=1;
        }
        else{
            int commonDen = gcd(this.Numerator,this.Denominator);
            this.Numerator=this.Numerator/commonDen;
            this.Denominator=this.Denominator/commonDen;
        }
    }


    //returns the greatest common denominator of two integers
    private static int gcd(int num, int den){
        int remainder;
        //algorithm for finding gcd
        while(num!=0&&den!=0){
            remainder= num%den;
            num=den;
            den=remainder;
        }
        //make gcd positive if a negative number is found
        if(num<0){
            num=-num;
        }
        return num;
    }

}
