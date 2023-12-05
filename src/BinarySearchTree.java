import java.util.NoSuchElementException;

public class BinarySearchTree<E> {

    private static int size, leaf;
    private TreeNode<Integer> root;

    public BinarySearchTree() {

        root = null;
        size = 0;

    }

    public TreeNode getRoot() {

        return root;

    }

    public void printTree(TreeNode node) {

        if (node == null) {

            System.out.println("Empty Tree");
            return;

        }

        System.out.println(node.getValue());
        printTree(node.getLeftChild());
        printTree(node.getRightChild());


    }

    /**
     * adds a new TreeNode to the BinarySearchTree
     *
     * @param value
     */
    public void add(E value) {

        if (size == 0) {

            root = new TreeNode((Comparable) value, null, null);
            size++;
            return;

        }

        if (size == 1) {

            if (root.getValue().compareTo((Integer) value) > 0) {

                root.setLeftChild(new TreeNode<Integer>((Integer) value, null, null));

            } else {

                root.setRightChild(new TreeNode<Integer>((Integer) value, null, null));

            }
            size++;
            return;

        }

        TreeNode temp = root;
        char leRi = '0';
        while (temp.getValue() != null) {

            if (temp.getValue().compareTo(value) > 0) {
                leRi = 'l';
                if (temp.getLeftChild() == null) break;
                else {
                    temp = temp.getLeftChild();
                }

            }

            if (temp.getValue().compareTo(value) <= 0) {

                leRi = 'r';
                if (temp.getRightChild() == null) break;
                else {
                    temp = temp.getRightChild();
                }

            }

        }

        if (leRi == 'l') {

            temp.setLeftChild(new TreeNode<Integer>((Integer) value, null, null));

        } else if (leRi == 'r') {

            temp.setRightChild(new TreeNode<Integer>((Integer) value, null, null));

        } else {

            throw new IndexOutOfBoundsException();

        }

        size++;

    }

    /**
     * uses the helper method TraverseTree
     *
     * @param value
     * @return value is present
     */
    public boolean contains(E value) {

        return traverseTree((int) value, getRoot());

    }

    /**
     * Uses recursion to sort through tree
     * terminates if the node is null
     * returns true if it finds the value
     *
     * @param value
     * @param node
     * @return node == value
     */
    private static boolean traverseTree(int value, TreeNode node) {

        if (node == null) return false;
        if (node.getValue().equals(value)) return true;

        return traverseTree(value, node.getLeftChild()) || traverseTree(value, node.getRightChild());

    }

    /**
     * returns the total amount of nodes in the binary search tree
     * size modified by add and delete methods
     *
     * @return size
     */
    public int countNodes() {

        return size;

    }

    /**
     * calls the countLeaf() helper method
     * returns leaf after countLeaf() runs
     *
     * @return leaf
     */
    public int countLeafNodes() {

        countLeaf(getRoot());
        return leaf;

    }

    /**
     * recursively goes through the tree
     * increments leaf if a node is a leaf node
     * determines if a node is a leaf by checking if it has any child nodes
     * if not, increment, otherwise, continue
     *
     * @param node
     */
    private static void countLeaf(TreeNode node) {

        if (node == null) return;
        if (node.getLeftChild() == null && node.getRightChild() == null) leaf++;

        countLeaf(node.getLeftChild());
        countLeaf(node.getRightChild());

    }

    /**
     * calls the helper method maxHeight and passes the root node
     * returns the height of the tree
     *
     * @return maxHeight(getRoot ())
     */
    public int getHeight() {

        return maxHeight(getRoot());

    }

    /**
     * recursively traverses the tree to find the height
     * if the left height is greater, return lHeight + 1
     * if the right height is greater, return rHeight + 1
     *
     * @param node
     * @return height
     */
    private static int maxHeight(TreeNode node) {

        if (node == null) return 0;

        int leftHeight = maxHeight(node.getLeftChild());
        int rightHeight = maxHeight(node.getRightChild());

        if (leftHeight > rightHeight) return leftHeight + 1;
        else return rightHeight + 1;

    }

    public void printInOrder() {

        inOrderHelp(getRoot());

    }

    private static void inOrderHelp(TreeNode node) {

        if (node == null) return;
        inOrderHelp(node.getLeftChild());
        System.out.print(node.getValue() + " ");
        inOrderHelp(node.getRightChild());

    }

    public void printPreOrder() {

        preOrderHelp(getRoot());

    }

    private static void preOrderHelp(TreeNode node) {

        if (node == null) return;
        System.out.print(node.getValue() + " ");
        preOrderHelp(node.getLeftChild());
        preOrderHelp(node.getRightChild());

    }

    public void printPostOrder() {

        postOrderHelp(getRoot());

    }

    private static void postOrderHelp(TreeNode node) {

        if (node == null) return;
        postOrderHelp(node.getLeftChild());
        postOrderHelp(node.getRightChild());
        System.out.print(node.getValue() + " ");

    }



    public E delete(E value) {

        TreeNode[] nodes = findValue(getRoot(), (int) value);

        if (nodes[1].getLeftChild() == null && nodes[1].getRightChild() == null) {

            TreeNode temp = nodes[1];

            if (nodes[0].getLeftChild().equals(nodes[1])) {

                nodes[0].setLeftChild(null);

            } else {

                nodes[0].setRightChild(null);

            }

            size--;
            return (E) temp;

        } else if (nodes[1].getLeftChild() == null ^ nodes[1].getRightChild() == null) {

            TreeNode temp = nodes[1];

            if (nodes[1].getLeftChild() != null) {

                nodes[1] = nodes[1].getLeftChild();
                nodes[1].setLeftChild(null);

            } else {

                nodes[1] = nodes[1].getRightChild();
                nodes[1].setRightChild(null);

            }

            size--;
            return (E) temp;


        } else {

            TreeNode temp = nodes[1];

            size--;
            return (E) temp;

        }

    }

    private static TreeNode[] findValue(TreeNode node, int value) {

        if (node == null) {

            System.out.println("whoops");
            throw new NoSuchElementException();

        }

        if (node.getLeftChild().getValue().equals(value) || node.getRightChild().getValue().equals(value)) {

            if (node.getLeftChild().getValue().equals(value)) return new TreeNode[]{node, node.getLeftChild()};
            else if (node.getRightChild().getValue().equals(value)) return new TreeNode[]{node, node.getRightChild()};
            else throw new IndexOutOfBoundsException("Something went wrong!");

        }

        findValue(node.getLeftChild(), value);
        findValue(node.getRightChild(), value);

        return null;

    }


}
