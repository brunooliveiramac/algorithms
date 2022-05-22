public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {

            if (value == this.value) {
                return true;
            }

            if (value > this.value) {
                if (this.right != null) {
                    return this.right.contains(value);
                }
            } else {
                if (this.left != null) {
                    return this.left.contains(value);
                }
            }

            return false;
        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null) {
                    left.remove(value, this);
                }
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                if (hasEdges(this)) {
                    this.value = right.getMinValue();
                    right.remove(value, this);
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {
                        //Single node
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }

        }

        private int getMinValue() {
            if (left == null) {
                return this.value;
            } else {
                return left.getMinValue();
            }
        }

        private boolean hasSingleEdge(BST bst) {
            return (bst.left != null && bst.right == null) || (bst.left == null && bst.right != null);
        }

        private boolean hasEdges(BST bst) {
            return bst.left != null && bst.right != null;
        }

        void removeMin(BST parent) {
            if (parent.right.left == null) {
                parent.right = null;
                return;
            }
            removeLeftMin(parent.right, parent);
        }

        private void removeLeftMin(BST bst, BST parent) {
            if (bst.left == null) {
                parent.left = null;
            } else {
                removeLeftMin(bst.left, bst);
            }
        }

        BST getMin(BST bst) {
            if (bst.right.left == null) {
                return bst.right;
            }
            return getLeftMin(bst.right);
        }

        private BST getLeftMin(BST bst) {
            if (bst.left == null) {
                return bst;
            }
            return getLeftMin(bst.left);
        }
    }


    public static void main(String[] args) {

        BST a = new BST(10);
        a.insert(5);
        a.insert(15);
        a.insert(2);
        a.insert(5);
        a.insert(22);
        a.insert(1);
        a.insert(14);
        a.insert(12);
        a.remove(5);
        a.remove(5);
        a.remove(12);
        a.remove(13);
        a.remove(14);
        a.remove(22);
        a.remove(2);
        a.remove(1);
        a.contains(15);


        System.out.println(a);


    }


}
