package week06;

public class Main {
    public static void main(String[] args) {
        try {
            BinarySearchTree bst = new BinarySearchTree();
            bst.insert(5);
            bst.insert(7);
            bst.insert(9);
            bst.insert(20);
            System.out.println(bst.search(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
