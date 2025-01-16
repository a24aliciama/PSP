package org.example;

public class BirthdayArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided");
            return;
        }else{
            int numCases = Integer.parseInt(args[0]);
            if ( numCases == args.length - 1) {
                int cases = 0;
                while (cases < numCases) {
                    int age = Integer.parseInt(args[cases]);
                    String bynaryAge = Integer.toBinaryString(age);
                    int cont = 0;
                    for (int i = 0; i < bynaryAge.length(); i++) {
                        if (bynaryAge.charAt(i) == '1') {
                            cont++;
                        }
                    }
                    System.out.println(cont);
                    cases++;
                }
            }else {
                System.out.println("Number of cases does not match the number of arguments");
                return;
            }
        }
    }
}
