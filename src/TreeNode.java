
/**
 * A class representing a node in a binary tree
 *
 * @param <E> the kind of elements the tree will hold
 */
public class TreeNode<E extends Comparable<E>> {
    private E value;
    private TreeNode<E> leftChild;
    private TreeNode<E> rightChild;

    /**
     * Creates a new TreeNode
     * @param val - the value held at the node
     * @param left - the left child
     * @param right - the right child
     */
    public TreeNode(E val, TreeNode<E> left, TreeNode<E> right){
        value = val;
        leftChild = left;
        rightChild = right;
    }

    /**
     * Retrieves the left child of this node
     * @return the left child of the node
     */
    public TreeNode<E> getLeftChild(){
        return leftChild;
    }

    /**
     * Retrieves the right child of this node
     * @return the right child of this node
     */
    public TreeNode<E> getRightChild(){
        return rightChild;
    }

    /**
     * Retrieves the value of this node
     * @return the value contained at this node
     */
    public E getValue(){
        return value;
    }

    /**
     * Sets the left child to the node given
     * @param left the new left child node
     */
    public void setLeftChild(TreeNode<E> left){
        leftChild = left;
    }

    /**
     * Sets the right child to the node given
     * @param right the new right child node
     */
    public void setRightChild(TreeNode<E> right){
        rightChild = right;
    }

    /**
     * Sets the value to the value given
     * @param val the new value of the node
     */
    public void setValue(E val){
        value = val;
    }

}
