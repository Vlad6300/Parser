public class LetNode extends ExpTree{                                   //This class is used to represent Let nodes in the tree

    public LetNode(ExpTree l, ExpTree r){                               //Given two expression trees, this constructor creates a new tree with the root being the Let node
        leftChild=l;
        rightChild=r;
    }

    @Override
    public String toString() {                                         //This method adds the String version of the node to the result to be returned and calls the toString methods of its children in order to return the String version of the tree
        return "Let "+leftChild.toString()+" "+rightChild.toString();
    }
}
