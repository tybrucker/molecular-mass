import java.util.Scanner;

public class MolecularMass {

    private IntStack stack = new IntStack();
    private int parens = 0;


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the molecule: ");
        String molecule = input.nextLine();
        MolecularMass a = new MolecularMass();
        System.out.println("The Molecular Mass of " + molecule + " is " + a.calcMass(molecule));
    }

    // Takes string as input and returns mass of molecule (only handles C, H, and O)
    public int calcMass(String str){
        
        int x = 0;

        for(int i = 0; i < str.length(); i++) {
            
            /* 
            This switch does 3 things:
            - Handles the characters H, C, and O
            - Handles parenthesis
            - Handles basic numbers (multiplies previous node)
            */
            switch(str.charAt(i)) {
                case 'H':
                    stack.push(1);
                    break;
                case 'C':
                    stack.push(12);
                    break;
                case 'O':
                    stack.push(16);
                    break;
                case '(':
                    stack.push(0);
                    parens++;
                    break;
                case ')':
                    stack.push(parenHandler());
                    parens--;
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    stack.push(stack.pop() * Character.getNumericValue(str.charAt(i)));
                    break;
                default:
                    break;
            }
        }

        //Add all of the numbers in the stack and return
        while(!stack.isEmpty()) {
            x = x + stack.pop();
        }

        return x;
    }

    // Adds stack up until 0 (paren marker) and returns the sum
    public int parenHandler() {
        int ret = 0;
        while(stack.peek() != 0) {
            ret = ret + stack.pop();
        }
        stack.pop();
        return ret;
    }
}
