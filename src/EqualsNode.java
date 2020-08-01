public class EqualsNode extends ExpTree{                                                    //This class is used to represent Equals nodes in the tree.
    public EqualsNode(String identifier,ExpTree expression){                                //This is the constructor. It creates an Identifier node using the String input int the left child and the tree holding the expression in the right child
        leftChild =new IdentifierNode(identifier);
        rightChild = expression;
    }

    @Override
    public String toString() {                                                             //This method returns the String version of the node and call the toString method of its children.
        return leftChild.toString()+"="+rightChild.toString();
    }
}
