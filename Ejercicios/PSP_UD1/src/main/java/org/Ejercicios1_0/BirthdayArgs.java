package org.Ejercicios1_0;

public class BirthdayArgs {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int numCases = Integer.parseInt(args[0]);
        int cases = 1;
        while(cases <= numCases){
            int age = Integer.parseInt(args[cases]);
            String binaryAge = Integer.toBinaryString(age);
            int cont = 0;
            for (int i = 0; i < binaryAge.length(); i++){
                if (binaryAge.charAt(i) == '1'){
                    cont++;
                }
            }
            System.out.println(cont);
            cases ++;
        }


    }
}
