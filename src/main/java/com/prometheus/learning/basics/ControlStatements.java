package com.prometheus.learning.basics;

public class ControlStatements {

    public void ifElseStatements() {

        //If-statements are used to check an expression against a condition,
        //and execute one group of statements if the condition is matched, and optionally
        //execute other group of statements if the condition is not matched.

        int a = 10;

        //Without curly braces, only one statement after if is executed;
        if(a == 10) System.out.println("This statement is executed if a == 10");
        System.out.println("This statements is executed no matter the condition");

        //To execute multiple statements incase of condition match, code block must be used
        if(a == 10) {
            System.out.println("Statement 1");
            System.out.println("Statement 2");
        }

        //No semicolon after if-else blocks

        //If condition is false, an alternative statements can be executed with else keyword
        if(a == 15) {
            System.out.println("Statement");
        } else  {
            System.out.println("Alternative statement when a != 15");
        }

        //Multiple conditional checks can be stacked with else-if
        if(a == 15) {
            System.out.println("a == 15");
        } else if(a == 12) {
            System.out.println("a == 12");
        } else {
            System.out.println("a != 15 and a != 12");
        }

        //if, else-if and else statements can be used within each other
        if(a < 15) {
            if(a < 12) {
                if(a == 11) {

                } else if(a == 10) {

                } else  {

                }
            }
        }

        //It is possible to use variables outside the block from inside the block,
        //but it is not possible to use variables declared inside a block outside of that block,
        //variables are block local
        {
            int localVariable = a;
        }
        {
            int localVariable = a;
        }
        //System.out.println(localVariable); //not available

        if(a == 10); //Incase of a == 10, no statements gets executed (emoty statements),
        // and then the block below is executed
        {
            System.out.println("Is valid");
        }

    }

    enum Enum {Enum1}
    public void switchStatements() {

        byte switchValue = 3;

        /** ========================= SWITCH STRUCTURES ============================== */


        /** When a switch case is matched, all the statements starting from that case
         *  until a break; or end of the switch is reached */
        switch (switchValue) {
            case 1: {

                break;
            }
            case 2: {

                break;
            }
            case 3: case 4: case 5: {
                break;
            }
            default: {

            }
        }

        switch (switchValue) {
            case 1: System.out.println("Value was 1"); break;
            case 2:
                System.out.println("Value was 2");
                System.out.println("Another printout");
                break;
            case 3: System.out.println("Value was 2"); break;
            default: System.out.println("Unrecognized value");
        }

        /** default case can appear before other cases, and can even be first */
        switch(switchValue) {
            case 1: ;
            default:
            case 2:
        }

        /** switch statement can be empty */
        switch(switchValue) {}

        /** Switch can only contain a single case and no default */
        switch(switchValue) {
            case 1:
        }

        /** Switch can only contain default */
        switch(switchValue) {
            default:
        }



        /** ================== SUPPORTED SWITCH TYPES ======================= */

        /** byte, short, int char primitives are supported */
        switch((byte)switchValue){}   switch((short)switchValue){}
        switch((int)switchValue){}    switch((char)switchValue){}

        /** Wrappers Byte, Short, Integer, Character are supported */
        switch(Byte.valueOf(switchValue)){}     switch(Short.valueOf(switchValue)){}
        switch(Integer.valueOf(switchValue)){}  switch(Character.valueOf((char)switchValue)){}

        /** Enums and Strings are supported */
        switch ("String"){} switch (Enum.Enum1){}

        /** long, float, double, boolean are NOT supported */
        //switch((long)switchValue){}    //switch((float)switchValue){}
        //switch((double)switchValue){}  //switch (true){}

        /** Wrappers Long, Float, Double and Boolean are NOT supported */
        //switch(Long.valueOf(1L)){};    //switch(Float.valueOf(1F)){};
        //switch(Double.valueOf(1D)){};  //switch (Boolean.valueOf(true)){}



        /** ======================= SUPPORTED SWITCH CASES ====================== */

        /** Switch case must be a compile time constant */
        int caseInt1 = 1;
        //switch (switchValue) { case caseInt1: } //doesn't compile

        final int caseInt2; caseInt2 = 1;
        //switch (1) { case caseInt2: } //doesn't compile

        final int caseInt3 = 1;
        switch (1) { case caseInt3 :}

        String caseStr = "caseString";
        /** Valid since the value of the string concatenation is known at compile time */
        switch ("a"+"b") { case "a"+"b": }
        //switch ("caseString1") { case caseStr+"1":} //doesn't compile since caseStr is not compile time constant

        /** Switch cases cannot contain duplicate values */
        //switch (1){ case caseInt3+1: case 2} //doesn't compile, duplicate label 2

        /** The supported types for a switch case are the same as for switch argument */

    }

    public void loops() {

        /** ============================== FOR LOOP ========================= */

        //for(assigment ; condition ; afterActions) {}

        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //for(;;); //valid for loop

        /** Multiple variables can be initialized in for loop */
        for(int i = 0, j = 0; i < 5 && j < 5; i++, j++) {
            System.out.println("i = j = " + i);
        }


        /** The update part of the loop can contain multiple expressions, they must be separated by comma */
        for(int i = 0; i < 10; i++, System.out.println("statement1"), System.out.println("statement2"));



        /** ================================ FOREACH LOOP ======================= */

        String[] strArray = {"1","2","3","4","5"};
        /** For-each loop */
        for(String nrStr : strArray) {
            System.out.println(nrStr);
            nrStr = "abc"; //will not affect array, since nrStr is newly created local object
            /** Other objects can be modified, since they refer to myStr */
        }

        /** Objects can be initializd and used in for loop */
        int var = 0;
        for(Object obj = new Object(); var > 0; obj.toString()) {}



        /** ============================== WHILE LOOP ============================ */

        int counter = 0;
        while(counter < 10) {
            System.out.println("In while loop");
            counter++;
        }


        /** ============================ DO-WHILE LOOP =============================== */

        counter = 0;
        do {
            System.out.println("In while loop");
            counter++;
        } while(counter < 10);

        /** doesn't compile: k defined in do block will not be visible to while() */
        /*do {
            int k = 10;
        } while (k > 10); */

        counter = 0;
        /** do-while can be without curly brackets */
        do System.out.println(counter);
        while(counter == 0);


        /** Doesn't compile, unreachable statement */
        /*while(false) {
            System.out.println("unreachable");
        } */




        /** ======================== LOOP AND BLOCK LABELS ========================== */

        /** Loops can be labelled, so they can be called with break or continue */

        outerLoop:
        for(int i = 0 ; i < 5; i++) {
            innerLoop:
            for(int j = 0; j < 10; j++) {
                if(j == 5) break outerLoop;
                else continue innerLoop;
            }
        }

        /** Labels can also be used on blocks */
        blockLabel: {
            blockLabel2: {
                break blockLabel;
            }
        }


    }

}
