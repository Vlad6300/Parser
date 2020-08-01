public class IdentifierNode extends ExpTree{        //This class is used to represent Identifier nodes in the tree
    private String  identifier;                     //This String keeps track of the identifier

    public IdentifierNode(String id){               //Given an identifier, this method constructs the Identifier node
            identifier = id;
            rightChild=leftChild=null;
    }

    public String getIdentifier(){                  //This method returns the identifier
        return identifier;
    }

    @Override
    public String toString() {                     //This method returns the String version of this node
        return ""+identifier;
    }
}
