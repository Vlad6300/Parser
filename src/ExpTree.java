import java.util.HashMap;

public abstract class ExpTree {                                                     //This is the abstract class that is used as the basis for the classes that will hold the elements of the expression tree
    protected ExpTree leftChild, rightChild;                                        //This holds a reference to its children
    public static HashMap<String,Integer> identifierMap = new HashMap<>();          //This HashMap is used to keep track of identifier to value relations.

    public ExpTree getLeftChild(){                                                  //This method returns the left child
        return leftChild;
    }

    public ExpTree getRightChild(){                                                 //This method returns the right child
        return rightChild;
    }

    public abstract String toString();                                              //This is the abstract version of the toString method that is overwritten in this classes descendants

    public static String postOrder(ExpTree root){                                   //Given a node, this method will output the tree below that node in post order
        String result="";
        if(root instanceof LetNode) root = root.getRightChild();
        if(root.getLeftChild() instanceof OperatorNode){
            result+=((OperatorNode) root.getLeftChild()).postOrder()+" ";
        }else result+=root.getLeftChild().toString()+" ";

        if(root.getRightChild() instanceof OperatorNode){
            result+=((OperatorNode) root.getRightChild()).postOrder()+" ";
        }else result+=root.getRightChild().toString()+" ";

        if(root instanceof OperatorNode) result+=((OperatorNode) root).getOperator();
        else if(root instanceof NumNode) result+=((NumNode) root).getValue();
        else if(root instanceof IdentifierNode) result+=((IdentifierNode) root).getIdentifier();

        return result;
    }

    private void addIdVal(){                                                         //This method is used to add an identifier-value pair in the HashMap

        if(this instanceof EqualsNode){
            String id = ((IdentifierNode) this.getLeftChild()).getIdentifier();
            int val = this.rightChild.evalExpression();
            identifierMap.put(id,val);
        }else if(this instanceof AndNode){
            this.getRightChild().addIdVal();
            this.getLeftChild().addIdVal();
        }
    }

    public int evalExpression(){                                                        //This recursive method is used to evaluate the expression and, if necessary, the identifier-value pairs inputted
        if(this instanceof NumNode) return ((NumNode) this).getValue();
        if(this instanceof IdentifierNode) {
            int res;
            if(identifierMap.get(((IdentifierNode) this).getIdentifier())==null){       //If an identifier is used without being given a value, we output a warning
                System.out.println("Identifier "+((IdentifierNode) this).getIdentifier()+" used without a given value");
                res=0;
            }else res = identifierMap.get(((IdentifierNode) this).getIdentifier());
            return res;
        }
        if(this instanceof LetNode){                                                    //Check if we need to add for identifier-value pairs
            this.getLeftChild().addIdVal();
            return this.getRightChild().evalExpression();
        }
        int result=1;
        if(this instanceof OperatorNode){                                               //Perform the math necessary, and return the result
            int left = this.getLeftChild().evalExpression();
            int right = this.getRightChild().evalExpression();
            switch (((OperatorNode) this).getOperator()) {
                case '+':   result=left+right;
                            break;
                case '-':   result=left-right;
                            break;
                case '*':   result=left*right;
                            break;
                case '/':   if(right==0) throw new ArithmeticException();
                            result=left/right;
                            break;
                case '%':   result=left%right;
                            break;
                case '^':   if(right<0) throw new ArithmeticException();
                            int cpy=right;
                            while(cpy>0){
                                result*=left;
                                cpy--;
                            }
            }
        }
        return result;

    }


    class ExpTreeException extends Exception {                                          //Define a class specific exception
        public ExpTreeException(String errorMessage) {
            super(errorMessage);
        }
    }
}



