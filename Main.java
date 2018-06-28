package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int numerator;
        int denominator;
        String operator;
        Fraction firstFract;
        Fraction secondFract;
        Fraction answerFract;
        Boolean equals;
        Scanner input = new Scanner(System.in);

        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b where a and b are integers.");
        System.out.println("Please enter an operation(+,-,/,*,= or q to quit)");
        System.out.println("--------------------------------------------------------");

        while(true){
            operator=getOperation(input);

            //close program if user enters 'q' or 'Q'
            if(("Q".equals(operator))||("q".equals(operator))){
                input.close();
                System.exit(0);
            }

            firstFract=getFraction(input);
            secondFract=getFraction(input);

            System.out.print(firstFract.toString());
            System.out.print(" " + operator + " ");
            System.out.print(secondFract.toString());

            //perform the operation associated with each operator
            switch (operator) {
                case "-":;
                    answerFract=secondFract.subtract(firstFract);
                    System.out.println(" = " + answerFract.toString());
                    break;
                case "+":;
                    answerFract=secondFract.add(firstFract);
                    System.out.println(" = " + answerFract.toString());
                    break;
                case "/":;
                    if(secondFract.getNumerator()==0){
                        System.out.println(" = Undefined");
                    }
                    else{
                        answerFract=secondFract.divide(firstFract);
                        System.out.println(" = " + answerFract.toString());
                    }
                    break;
                case "*":;
                    answerFract=secondFract.multiply(firstFract);
                    System.out.println(" = " + answerFract.toString());
                    break;
                case "=":;
                    equals=secondFract.equals(firstFract);
                    System.out.println(" is " + equals);
                    break;

            }
            System.out.println("--------------------------------------------------------");


        }


    }

    //asks the user to enter an operation, re-prompts user until user enters a valid operation
    public static String getOperation(Scanner input){
        String operator;
        System.out.print("Please enter an operation(+,-,/,*,= or q to quit):");
        operator=input.nextLine();


        while((!"-".equals(operator)) &&(!"+".equals(operator))&&(!"*".equals(operator))&&(!"/".equals(operator))&&(!"=".equals(operator))&&(!"q".equals(operator))&&(!"Q".equals(operator))){
            System.out.print("Invalid input (“+”, “-“, “/”, “*”, “=”, or “Q” to quit):");
            operator=input.nextLine();
        }
        return operator;
    }

    //gets input from the user and returns a fraction in the form of an integer or in the form of a/b
    public static Fraction getFraction(Scanner input){
        String fraction;
        int num;
        int den;
        int seperator;
        String top;
        String bottom;

        //loops until user enters a valid input and a fraction is returned
        while(true){
            seperator=0;
            System.out.print("Please enter a fraction (a/b) or integer(a):");
            fraction =input.nextLine();

            //checks if the fraction entered is an integer and returns it if it is
            if(isNumber(fraction)){
                num = Integer.parseInt(fraction);
                Fraction recievedFract= new Fraction(num);
                return recievedFract;
            }

            //finds where the '/' is in the fraction
            for(int i =0;i<fraction.length();i++){
                if(fraction.charAt(i)=='/'){
                    seperator =i;
                }

            }

            // '/' can't be the first element in the string
            if(seperator!=0){
                //seperates the fraction into two parts
                top = fraction.substring(0,seperator);
                bottom = fraction.substring(seperator+1);

                //if both the top and bottom are valid numbers fraction is returned is the form a/b
                if(isNumber(top)&&isNumber(bottom)){
                    num = Integer.parseInt(top);
                    den = Integer.parseInt(bottom);
                    //fraction not valid if denominator is 0
                    if(den!=0){
                        Fraction recievedFract = new Fraction(num,den);
                        return recievedFract;
                    }
                }
            }
            System.out.print("Invalid Input ");
        }
    }

    //checks if a sting is a number by trying Integer.parseInt(str)
    public static boolean isNumber(String str){
        try {
            Integer.parseInt(str);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }

        return true;
    }

}

