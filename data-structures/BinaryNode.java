public class BinaryNode {

    private int value;
    private BinaryNode leftNode;
    private BinaryNode rightNode;

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return this.rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryNode(int value){
        this.value = value;
    }
    
    @Override
    public String toString(){
        return "Binary node: " + this.getValue()+"\nLeft Node Value: " + 
        this.getLeftNode().getValue() +
        "\nRight Node Value: "+this.getRightNode().getValue();
    }
    
    public String infixTraversal(){
        String str = "";
        //checking left subtree
        if(this.leftNode != null)
        {str = str +this.leftNode.infixTraversal();}

        //concatinating the value itself:
        str = str+" " + this.getValue();

        //check right subtree:
        if(this.rightNode != null)
        {str = str +this.rightNode.infixTraversal();}

        return str;
    }

    public boolean BinarySearch(int target){

        int searchValue = this.getValue(); //root value
        boolean result = false;

        //comparing the target with the root value
        if(searchValue==target){
            result=true;
            return result;
        }

        //if it's not equal to the left side, it will go back to the target
        if(result==false && this.leftNode!=null){
            result = this.leftNode.BinarySearch(target);
        }

        //if it's not equal to the right side, it will go back to the target
        if(result ==false && this.rightNode!=null){
            result = this.rightNode.BinarySearch(target);
        }

        return result;

    }

    public void binaryInsert(BinaryNode node){

        /* transversing from the root until we find an empty spot*/
        int compareValue = this.getValue();

        //value to be inserted 
        int valuetemp = node.getValue();

        //if right is empty and value to be inserted  is greater than the reference, add it 
        if(this.getRightNode()==null && valuetemp>compareValue){
            this.setRightNode(node);
        }

        //if left is empty and value is smaller than the reference, add it
        else if(this.getLeftNode()==null && valuetemp<compareValue){
            this.setLeftNode(node);
        }

        //if right of left is full, continue searching
        else if(valuetemp>compareValue){
            this.getRightNode().binaryInsert(node);
        }
       
        else if(valuetemp<compareValue){
            this.getLeftNode().binaryInsert(node);
        }
    }

    
    public static void main(String[] args) {
        BinaryNode nd = new BinaryNode(123);
        BinaryNode ndLeft = new BinaryNode(66);
        BinaryNode ndRight = new BinaryNode(200);
        BinaryNode ndLL = new BinaryNode(44);
        BinaryNode ndLR = new BinaryNode(76);
        BinaryNode ndRR = new BinaryNode(456);
        BinaryNode ndRL = new BinaryNode(199);

        //setting the nodes of the binary tree
        //commenting the below nodes because the binaryInsert will add them manually

        /*nd.setLeftNode(ndLeft);
        nd.setRightNode(ndRight);
        System.out.println(nd);
        ndLeft.setLeftNode(ndLL);
        ndLeft.setRightNode(ndLR);
        ndRight.setLeftNode(ndRL);
        ndRight.setRightNode(ndRR);

        System.out.println(nd.infixTraversal());
        System.out.println(nd.BinarySearch(122));*/

        nd.binaryInsert(ndLeft);
        nd.binaryInsert(ndRight);
        nd.binaryInsert(ndLL);
        nd.binaryInsert(ndLR);
        nd.binaryInsert(ndRR);
        nd.binaryInsert(ndRL);

        System.out.println(nd.infixTraversal());
    }
}