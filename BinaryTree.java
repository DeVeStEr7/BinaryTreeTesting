public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private TreeNode<T> forwardRoot = root;
    private TreeNode<T> currentRoot = forwardRoot;
    private int counter;

    public void add(T data) {
        if(root == null) {
            root = new TreeNode<>(null, data, null);
            counter++;
        }
        else {
            TreeNode<T> currentNode = forwardRoot;
            if (data.compareTo(currentNode.getData()) >= 0) {
                if(currentNode.getRight() == null) {
                    currentNode.setRight(new TreeNode<>(null, data, null));
                    counter++;
                }
                else {
                    forwardRoot = currentNode.getRight();
                    add(data);
                }
            } else if (data.compareTo(currentNode.getData()) < 0) {
                if(currentNode.getLeft() == null) {
                    currentNode.setLeft(new TreeNode<>(null, data, null));
                    counter++;
                }
                else {
                    forwardRoot = currentNode.getLeft();
                    add(data);
                }
            }
        }
        forwardRoot = root;
    }

    public boolean contains(T data) {
        TreeNode<T> currentRoot = forwardRoot;
        if(root == null || forwardRoot == null) {
            forwardRoot = root;
            return false;
        }
        else {
            if(currentRoot.getData().equals(data)) {
                forwardRoot = root;
                return true;
            } else if (currentRoot.getData().compareTo(data) > 0) {
                forwardRoot = currentRoot.getLeft();
                return contains(data);
            } else if (currentRoot.getData().compareTo(data) < 0) {
                forwardRoot = currentRoot.getRight();
                return contains(data);
            } else {
                return false;
            }
        }
    }

    public void delete(T data) {
        TreeNode<T> previousRoot = currentRoot;
        currentRoot = forwardRoot;
        if(!contains(data)) {
            System.out.println("Not in the tree");
        }
        else {
            if(currentRoot.getData().equals(data)) {
                if(currentRoot.getLeft() != null) {
                    TreeNode<T> lowestRoot = currentRoot.getLeft();
                    while(lowestRoot.getRight() != null) {
                        previousRoot = lowestRoot;
                        lowestRoot = lowestRoot.getRight();
                    }
                    currentRoot.setData(lowestRoot.getData());
                    previousRoot.setRight(null);
                    if(currentRoot.getLeft().getData() == null)
                        currentRoot.setLeft(null);
                    lowestRoot.setData(null);
                }
                else if(currentRoot.getRight() != null) {
                    TreeNode<T> lowestRoot = currentRoot.getRight();

                    if(lowestRoot.getLeft() == null) {
                        previousRoot = currentRoot;
                    }
                    while(lowestRoot.getLeft() != null) {
                        previousRoot = lowestRoot;
                        lowestRoot = lowestRoot.getLeft();
                    }
                    currentRoot.setData(lowestRoot.getData());
                    previousRoot.setLeft(null);
                    if(currentRoot.getRight().getData() == null)
                        currentRoot.setRight(null);
                    lowestRoot.setData(null);
                }
                else {
                    if(previousRoot.getLeft() == currentRoot) {
                        previousRoot.setLeft(null);
                    }
                    else {
                        previousRoot.setRight(null);
                    }
                    currentRoot.setData(null);
                    currentRoot = null;
                }

            } else if (currentRoot.getData().compareTo(data) > 0) {
                forwardRoot = currentRoot.getLeft();
                delete(data);
            } else if (currentRoot.getData().compareTo(data) < 0) {
                forwardRoot = currentRoot.getRight();
                delete(data);
            }
        }
        forwardRoot = root;
    }

    public void printInOrder() {
        TreeNode<T> currentRoot = forwardRoot;
        if(root == null) {
            System.out.println("null");
        }
        if(forwardRoot.getLeft() != null){
            forwardRoot = forwardRoot.getLeft();
            printInOrder();
        }
        System.out.print(currentRoot.getData() + " ");
        forwardRoot = currentRoot;
        if(forwardRoot.getRight() != null) {
            forwardRoot = forwardRoot.getRight();
            printInOrder();
        }
        forwardRoot = root;
    }

    public T getMin() {
        TreeNode<T> lowestRoot = root;
        while(lowestRoot.getLeft() != null) {
            lowestRoot = lowestRoot.getLeft();
        }
        return lowestRoot.getData();
    }

    public T getMax() {
        TreeNode<T> highestRoot = root;
        while(highestRoot.getRight() != null) {
            highestRoot = highestRoot.getRight();
        }
        return highestRoot.getData();
    }

    public int size(BinaryTree<T> tree){
        return counter;
    }
}
