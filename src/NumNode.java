public class NumNode extends ExpTree{               //This node is used to represent Number nodes in the tree
    private int value;                              //This holds the number
    public NumNode(int val){                        //Given a number we check if it is a positive number, and if it is, we create the new number node, otherwise we throw an error.
        try{
            if(val < 0) throw new ExpTreeException("Negative node value");
            value=val;
            rightChild=leftChild=null;
        }catch (ExpTreeException e){
            System.out.println(e);
        }
    }

    public int getValue(){                          //This method returns the value
        return value;
    }

    @Override
    public String toString() {                      //This method returns the String version of the code
        return "" + value;
    }
}
