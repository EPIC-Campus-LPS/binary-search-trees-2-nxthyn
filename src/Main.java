public class Main {

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.add(10);
//        tree.add(20);
//        tree.add(8);
//        tree.add(9);
//        tree.add(6);
//        tree.add(15);
//        tree.add(2);
        System.out.println(tree.delete(10));
        tree.printTree(tree.getRoot());

    }



}
