public class OperatorNode extends ExpTree{                              //This class is used to represent the Operator node.
    private char operator;
    public OperatorNode(char op, ExpTree lChild, ExpTree rChild){       //Given two trees and an operator, this method creates an operator node that keeps track of the operator and adds the trees to its children
        operator = op;
        leftChild = lChild;
        rightChild = rChild;
    }

    public char getOperator(){                                          //This method returns the operator
        return operator;
    }

    private int getOperatorValue(){                                     //This method is used in transforming the operator in a priority level. This is used when trying to display the tree in order with parentheses.
        if(operator=='+'||operator=='-') return 0;
        if(operator=='-'||operator=='/'||operator=='%') return 1;
        return 2;
    }

    public String postOrder(){                                          //This recursive method is used to return a string displaying the tree in post-order
        String result="";
        if(leftChild instanceof OperatorNode){
            result+=((OperatorNode) leftChild).postOrder()+" ";
        }else result+=leftChild.toString()+" ";
        if(rightChild instanceof OperatorNode){
            result+=((OperatorNode) rightChild).postOrder()+" ";
        }else result+=rightChild.toString()+" ";
        return result+operator;
    }

    @Override
    public String toString() {                                                              //This recursive toString method is used to return the String value of the tree in-order
        String result = "";
        if (leftChild instanceof OperatorNode) {
            if ((this.getOperatorValue() > ((OperatorNode) leftChild).getOperatorValue())){
                result += "(" + leftChild.toString() + ")";
            }else result += leftChild.toString();
        }else result += leftChild.toString();

        result += operator;

        if (rightChild instanceof OperatorNode) {
            if ((this.getOperatorValue() > ((OperatorNode) rightChild).getOperatorValue())) {
                result += "(" + rightChild.toString() + ")";
            } else if(this.getOperator()=='-'){
                result += "(" + rightChild.toString() + ")";
            } else result+=rightChild.toString();
        }else result += rightChild.toString();
        return result;
    }

}
