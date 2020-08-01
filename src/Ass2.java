import java.util.HashMap;

public class Ass2 {                                                                     //This class is used to run the code

    public static void main(String[] args) {
        System.out.println("Registration number: 1801629");
        System.out.println("Welcome to vd18143's expression evaluation program");       //Print introductory text
        Parser p = new Parser();                                                        //Create parser object
        String temp="";
        do{                                                                             //Loop through the program
            ExpTree myTree = null;
            System.out.print("Please type an expression: ");                            //Ask for user input
            try{
               myTree = p.parseLine();                                                  //Try to parse the user input
               System.out.println("Post-order: "+ExpTree.postOrder(myTree));            //Display the tree in post-order
               System.out.println("String (in-order): "+myTree.toString());             //Display the tree in-order
               System.out.println("Result: " + myTree.evalExpression());               //Try to evaluate the expression
            }catch (Exception e){                                                       //If it exists catch the error in user input
                System.out.println(e);
                System.out.println("Invalid expression");
            }

            System.out.print("Another expression? (y/n): ");                            //Ask if the user wants to input another expression
            temp = p.getLine();
            if(!temp.equals("y")&&!temp.equals("n")){                                   //Check user input and exit if needed
                System.out.println("Invalid input, end.");
            }
            System.out.println();
            myTree.identifierMap=new HashMap<>();                                       //Empty the map used for previous expression
        }while (temp.equals("y"));
    }
}


//For part 6, I use the Equals node to keep track of both the identifier and the expression it is equal to as children
//We use the evalExpression method and match the identifier with the result from its expression, afterwards we add the pair to a hashmap.