
public class Client {
    public static void main(String[] args) {
        BinaryTree<Integer> treeData = new BinaryTree<>();

        treeData.add(50);
        treeData.add(25);
        treeData.add(75);
        treeData.add(63);
        treeData.add(89);
        treeData.add(12);
        treeData.add(19);
        treeData.add(6);
        treeData.add(9);
        treeData.add(37);
        treeData.add(28);
        treeData.add(27);
        treeData.add(32);
        treeData.add(45);
        treeData.add(22);
        treeData.add(15);


        System.out.println(treeData.contains(25));
        System.out.println(treeData.contains(1));

        System.out.println(treeData.getMin());
        System.out.println(treeData.getMax());

        treeData.printInOrder();
        System.out.println("");
        System.out.println(treeData.size(treeData));
        treeData.delete(1);
        treeData.delete(25);
        System.out.println("");
    }
}
