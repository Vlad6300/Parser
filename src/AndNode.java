public class AndNode extends ExpTree{                                       //This class is used to represent And nodes in the tree

    public AndNode (ExpTree l, ExpTree r){                                  //This is the constructor for the AndNode class. It sets the nodes left and right child using the input
        leftChild=l;
        rightChild=r;
    }

    @Override
    public String toString() {                                              //This method returns String version of the node and is used to call the toString of its children.
        return leftChild.toString() +" and "+rightChild.toString();
    }
}
