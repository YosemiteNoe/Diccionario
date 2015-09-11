

// An implementation of nodes for use in binary trees.
// (c) 1998, 2001 duane a. bailey
//https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&ved=0CCcQFjABahUKEwjrm6HggevHAhWLph4KHdqEDUE&url=http%3A%2F%2Fwww.cs.pomona.edu%2F~dkauchak%2Fclasses%2Fs10%2Fcs062-s10%2Fdemos%2FBinaryTree%2FBinaryTree.java&usg=AFQjCNG6Egvkf14uwdGbJ8r1injUA5WFDA&sig2=5UeWNG8JYwa2nV5gilGkSw
//packageture5;
import java.lang.Math;
import java.util.Iterator;

/**
 * This class implements a single node of a binary tree.  It is a
 * recursive structure.  Relationships between nodes are 
 * doubly linked, with parent and child references.  Many characteristics
 * of trees may be detected with static methods.
 *
 * @version $Id: BinaryTree.java 34 2007-08-09 14:43:44Z bailey $
 * @author, 2001 duane a. bailey
 * @see structure.BinaryTree
 * @see structure.BinarySearchTree
 */
public class BinaryTree<E>
{
    /**
     * The value associated with this node
     */
    protected E val; // value associated with node
    /**
     * The parent of this node
     */
    private BinaryTree<E> parent; // parent of node
    /**
     * The left child of this node, or an "empty" node
     */
    private BinaryTree<E> left, right; // children of node
    /**
     * The association of this node
     */
    private Association<String,String> word;
    

    public BinaryTree(){
    
    }
    /**
     * Constructs a tree node with no children.  Value of the node
     * and subtrees are provided by the user
     *
     * @post Returns a tree referencing value and two empty subtrees
     * @param value A non-null value to be referenced by node
     */
    
    public BinaryTree(E value)
    {
        
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Constructs a tree node with two children.  Value of the node
     * and subtrees are provided by the user.
     *
     * @post Returns a tree referencing value and two subtrees
     * @param value A non-null value to be referenced by node
     * @param left The subtree to be left subtree of node
     * @param right The subtree to be right subtree of node
     */
    public BinaryTree(BinaryTree right, BinaryTree left,String wordIng, String wordEsp)
    {
       super();   //
       this.right=right;
       this.left=left;
       word = new Association<String,String>(wordIng,wordEsp);
       
    }

    /**
     * Get left subtree of current node
     *
     * @post Returns reference to (possibly empty) left subtree
     *
     * @return The left subtree of this node
     */
    public BinaryTree<E> getLeft()
    {
        return left;
    }

    /**
     * Get right subtree of current node
     *
     * @post Returns reference to (possibly empty) right subtree
     * 
     * @return The right subtree of this node
     */
    public BinaryTree<E> getRight()
    {
        return right;
    }

    /**
     * Get reference to parent of this node
     *
     * @post Returns reference to parent node, or null
     * 
     * @return Reference to parent of this node
     */
    public BinaryTree<E> parent()
    {
        return parent;
    }
    
    /**
     * Update the left subtree of this node.  Parent of the left subtree
     * is updated consistently.  Existing subtree is detached
     *
     * @post Sets left subtree to newLeft
     *       re-parents newLeft if not null
     * 
     * @param newLeft The root of the new left subtree
     */
    public void setLeft(BinaryTree newLeft)
    {     
        left = newLeft;    
    }

    /**
     * Update the right subtree of this node.  Parent of the right subtree
     * is updated consistently.  Existing subtree is detached
     *
     * @post Sets left subtree to newRight
     *       re-parents newRight if not null
     * 
     * @param newRight A reference to the new right subtree of this node
     */
    public void setRight(BinaryTree<E> newRight)
    {
        right = newRight;
    }

    /**
     * Update the parent of this node
     *
     * @post Re-parents this node to parent reference, or null
     *
     * @param newParent A reference to the new parent of this node
     */
    protected void setParent(BinaryTree<E> newParent)
    {
        if (!isEmpty()) {
            parent = newParent;
        }
    }
    
    public void setWordIng(String newWordIng){
        word.setKey(newWordIng);
    }
    
    public void setWordEsp(String newWordEsp){
        word.setValue(newWordEsp);
    }
    
    public String getWordIng(){
        return word.getKey();
    }
    
    public String getWordEsp(){
        return word.getValue();
    }
    /**
     * Returns the number of descendants of node
     *
     * @post Returns the size of the subtree
     * @return Size of subtree
     */
    public int size()
    {
        if (isEmpty()) return 0;
        return getLeft().size() + getRight().size() + 1;
    }

    /**
     * Returns reference to root of tree containing n
     *
     * @post Returns the root of the tree node n
     * @return Root of tree
     */
    public BinaryTree<E> root()
    {
        if (parent() == null) return this;
        else return parent().root();
    }

    /**
     * Returns height of node in tree.  Height is maximum path
     * length to descendant
     *
     * @post Returns the height of a node in its tree
     * @return The height of the node in the tree
     */
    public int height()
    {
        if (isEmpty()) return -1;
        return 1 + Math.max(left.height(),right.height());
    }

    /**
     * Compute the depth of a node.  The depth is the path length
     * from node to root
     *
     * @post Returns the depth of a node in the tree
     * @return The path length to root of tree
     */
    public int depth()
    {
        if (parent() == null) return 0;
        return 1 + parent.depth();
    }


    /**
     * Returns true if tree is empty.
     * @post Returns true iff the tree rooted at node is empty
     * @return True iff tree is empty
     */
    public boolean isEmpty()
    {
        return val == null;
    }
    
    /**
     * Return whether tree is complete.  A complete tree has minimal height
     * and any holes in tree would appear in last level to right.       
     *
     * @post Returns true iff the tree rooted at node is complete
     * @return True iff the subtree is complete
     */
    public boolean isComplete()
    {
        int leftHeight, rightHeight;
        boolean leftIsFull, rightIsFull;
        boolean leftIsComplete, rightIsComplete;
        if (isEmpty()) return true;
        leftHeight = getLeft().height();
        rightHeight = getRight().height();
        leftIsComplete = getLeft().isComplete();
        rightIsComplete = getRight().isComplete();
        return false;
    }


    /**
     * Determine if this node is a left child
     *
     * @post Returns true if this is a left child of parent
     * 
     * @return True iff this node is a left child of parent
     */
    public boolean isLeftChild()
    {
        if (parent() == null) return false;
        return this == parent().getLeft();
    }

    /**
     * Determine if this node is a right child
     *
     * @post Returns true if this is a right child of parent
     * 
     * @return True iff this node is a right child of parent
     */
    public boolean isRightChild()
    {
        if (parent() == null) return false;
        return this == parent().getRight();
    }

    /**
     * Returns value associated with this node
     *
     * @post Returns value associated with this node
     * 
     * @return The node's value
     */
    public E getValue()
    {
        return val;
    }

    /**
     * Sets value associated with this node
     *
     * @post Sets the value associated with this node
     * @param value The new value of this node
     */
    public void setValue(E value)
    {
        val = value;
    }
    
    /**
     * Returns a string representing the tree rooted at this node.
     * <font color="#FF0000">WARNING</font> this can be a very long string.
     * 
     * @return A string representing the tree rooted at this node.
     */
    public String treeString(){
        String s = "";
        for (int i=0; i < this.depth(); i++){
            s += "\t|";
        }
        
        s += ("<" + val + " : " + getHand() + ">\n");
        
        if (!left.isEmpty()) s += left.treeString();
        if (!right.isEmpty()) s += right.treeString();

        return s;
    }
    
    /**
     * Support method for {@link #toString}. Returns R if this is node 
     * is a right child, L if this node is a left child and Root if this
     * node is the root.
     * 
     * @return R if this is node 
     * is a right child, L if this node is a left child and Root if this
     * node is the root.
     */
    private String getHand(){
        if (isRightChild()) return "R";
        if (isLeftChild()) return "L";
        return "Root";  
    }
    
}

