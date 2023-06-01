public class BSTNode {
    private int key;
    private String value;
    private BSTNode left;
    private BSTNode right;
    private int count;

    public BSTNode() {
        this.key = 0;
        this.value = null;
        this.left = null;
        this.right = null;
        this.count = 0;
    }

    public BSTNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.count = 1;
    }

    public void insert(int key, String value) {
        if (key == this.key) {
            this.value = value;
        } else if (key < this.key) {
            if (left == null) {
                left = new BSTNode(key, value);
            } else {
                left.insert(key, value);
            }
        } else {
            if (right == null) {
                right = new BSTNode(key, value);
            } else {
                right.insert(key, value);
            }
        }
        count++;
    }

    public void remove(int key) {
        BSTNode parent = null;
        BSTNode current = this;
        boolean isLeftChild = false;

        while (current != null && current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            return;
        }

        if (current.left == null && current.right == null) {
            if (current == this) {
                this.key = 0;
                this.value = null;
            } else {
                if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        else if (current.right == null) {
            if (current == this) {
                this.key = current.left.key;
                this.value = current.left.value;
                this.left = current.left.left;
                this.right = current.left.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            }
        } else if (current.left == null) {
            if (current == this) {
                this.key = current.right.key;
                this.value = current.right.value;
                this.left = current.right.left;
                this.right = current.right.right;
            } else {
                if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        }
        else {
            BSTNode successor = getSuccessor(current);
            if (current == this) {
                this.key = successor.key;
                this.value = successor.value;
            } else {
                if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
        }
        count--;
    }

    public String search(int key) {
        if (key == this.key) {
            return value;
        } else if (key < this.key) {
            return left != null ? left.search(key) : null;
        } else {
            return right != null ? right.search(key) : null;
        }
    }

    public void traverse() {
        if (left != null) {
            left.traverse();
        }
        System.out.println(key + ": " + value);
        if (right != null) {
            right.traverse();
        }
    }

    public int getNodeCount() {
        return count;
    }

    private BSTNode getSuccessor(BSTNode node) {
        BSTNode successorParent = node;
        BSTNode successor = node;
        BSTNode current = node.right;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != node.right) {
            successorParent.left = successor.right;
            successor.right = node.right;
        }

        successor.left = node.left;

        return successor;
    }
}