package deber9;

public class ABB<E extends Comparable<E>> {

    //---------------- nested Node class ----------------
    private static class Node<E> {

        private E element;// reference to the element stored at this node
        private Node<E> left;
        private Node<E> right;

        public E getElement() {
            return element;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRigh() {
            return right;
        }

        public void setLeft(Node<E> n) {
            left = n;
        }

        public void setRight(Node<E> n) {
            right = n;
        }

        public Node() {
        }

        public Node(E rootData) {
            element = rootData;
        }

        public boolean esHoja() {
            return this.getRigh() == null && this.getLeft() == null;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    } //----------- end of nested Node class ---------

    // instance variables of BinaryTree
    private Node<E> root = null;// root node of the tree (or null if empty)

    public ABB() {
    }// constructs an initially empty tree

    public ABB(E rootData) {
        root = new Node(rootData);
    }

    public Node<E> getRoot() {
        return root;
    }

    public String preOrden() {
        return preOrden(root).replaceAll(" +", " ").substring(1);
    }

    private String preOrden(Node<E> p) {
        if (p == null) {
            return " ";
        }
        return " " + p.toString() + " " + preOrden(p.left) + " " + preOrden(p.right);
    }

    public String inOrden() {
        if (root == null) {
            return "";
        }
        return inOrden(root).replaceAll(" +", " ").substring(1);
    }

    private String inOrden(Node<E> p) {
        if (p == null) {
            return "";
        }
        return " " + inOrden(p.left) + " " + p.toString() + " " + inOrden(p.right);
    }

    public String postOrden() {
        if (root == null) {
            return "";
        }
        return postOrden(root).replaceAll(" +", " ").substring(1);
    }

    private String postOrden(Node<E> p) {
        if (p == null) {
            return "";
        }
        return " " + postOrden(p.left) + " " + postOrden(p.right) + " " + p.toString();
    }

    public boolean contains(E element) {
        if (element == null) {
            return false;
        }
        return contains(root, element);
    }

    private boolean contains(Node<E> p, E element) {
        if (p == null) {
            return false;
        }
        if (element.compareTo(p.element) == 0) {
            return true;
        }
        if (element.compareTo(p.element) > 0) {
            return contains(p.right, element);
        }
        return contains(p.left, element);
    }

    public boolean add(E element) {
        if (element == null) {
            return false;
        }
        root = add(root, element);
        return true;
    }

    private Node<E> add(Node<E> p, E element) {
        if (p == null) {
            return new Node(element);
        }
        if (element.compareTo(p.element) == 0) {
            return p;
        }
        if (element.compareTo(p.element) > 0) {
            p.right = add(p.right, element);
        } else {
            p.left = add(p.left, element);
        }
        return p;
    }

    public int altura() {
        return altura(root);
    }

    private int altura(Node<E> n) {
        if (n == null) {
            return 0;
        }
        return 1 + Math.max(altura(n.right), altura(n.left));
    }

    public int size() {
        if (root == null) {
            return 0;
        }
        return size(root);
    }

    private int size(Node<E> n) {
        if (n == null) {
            return 0;
        }
        return 1 + size(root.getLeft()) + size(root.getRigh());
    }


    public int hojas() {
        if (root == null) {
            return 0;
        }
        return hojas(root);
    }

    private int hojas(Node<E> n) {
        if(n == null) {
            return 0;
        }
        if (n.esHoja()) {
            return 1;
        }
        return hojas(n.getLeft()) + hojas(n.getRigh());
    }


    public int izquierdo() {
        if (root == null) {
            return 0;
        }
        return izquierdo(root);
    }

    private int izquierdo(Node<E> n) {
        if (n == null) {
            return 0;
        }
        if (n.getLeft() != null) {
            return 1 + izquierdo(n.left) + izquierdo(n.right);
        }
        return izquierdo(n.getRigh());
    }
    
    
    public boolean esEspejo(ABB<E> arbol2) {
        if (arbol2 == null) {
            return false;
        }
        return esEspejo(root, arbol2.root);
    }
    private boolean esEspejo(Node<E> n1, Node<E> n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null && n2 != null) {
            return false;
        }
        if (n1 != null && n2 == null) {
            return false;
        }
        if (n1.element.compareTo(n2.element) != 0) {
            return false;
        }
       return esEspejo(n1.left, n2.right) && esEspejo(n1.right, n2.left); 
    }

    public ABB<E> espejo() {
        if(root == null){
            return null;
        }
        ABB<E> arbolEspejo = new ABB<>();
        arbolEspejo.root = espejo(root);
        return arbolEspejo;
    }
    private Node<E> espejo(Node<E> p) {
        if (p == null) {
            return null;
        }
        Node<E> nuevo = new Node<>();
        nuevo.element = p.element;
        nuevo.left = espejo(p.right);
        nuevo.right = espejo(p.left);
        return nuevo;
    }

}
