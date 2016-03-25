package week06;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable> {
    class Node {
        private T m_value;
        private Node m_left;
        private Node m_right;

        public Node(T value) {
            m_value = value;
            m_left = null;
            m_right = null;
        }

        public T getValue() {
            return m_value;
        }
    }

    private Node m_root;

    public BinarySearchTree() {
        m_root = null;
    }

    public void insert(T value) throws DuplicateItemException {
        m_root = insert(value, m_root);
    }

    private Node insert(T value, Node subRoot) throws DuplicateItemException {
        if (subRoot == null) {
            subRoot = new Node(value);
        } else if (value.compareTo(subRoot.m_value) < 0) {
            subRoot.m_left = insert(value, subRoot.m_left);
        } else if (value.compareTo(subRoot.m_value) > 0){
            subRoot.m_right = insert(value, subRoot.m_right);
        } else {
            throw new DuplicateItemException(value.toString());
        }
        return subRoot;
    }

    public Node search(T value) {
        return search(m_root, value);
    }

    public Node search(Node root, T value) {
        if (root == null || root.m_value == value) {
            return root;
        } else if (value.compareTo(root.m_value) == -1) {
            return search(root.m_left, value);
        } else {
            return search(root.m_right, value);
        }
    }

    public void delete(T value) {
        m_root = delete(value, m_root);
    }

    private Node delete(T toDelete, Node subRoot) {
        if (subRoot == null) {
            throw new NoSuchElementException();
        }
        if (toDelete.compareTo(subRoot.m_value) < 0) {
            subRoot.m_left = delete(toDelete, subRoot.m_left);
        } else if (toDelete.compareTo(subRoot.m_value) > 0) {
            subRoot.m_right = delete(toDelete, subRoot.m_right);
        } else if (subRoot.m_left != null && subRoot.m_right != null) {
            subRoot.m_value = findMin(subRoot.m_right).m_value;
            subRoot.m_right = removeMin(subRoot.m_right);
        } else {
            subRoot = null;
        }
        return subRoot;
    }

    public int getHeight(T value) {
        Node current = search(value);
        if (current == null) {
            throw new NoSuchElementException();
        }
        return getHeight(current);
    }

    private int getHeight(Node current) {
        if (current == null) {
            return -1;
        } else {
            return Math.max(getHeight(current.m_left), getHeight(current.m_right)) + 1;
        }
    }

    public T findMin() {
        return findMin(m_root).m_value;
    }

    private Node findMin(Node root) {
        if (root == null) {
            return root;
        }
        while (root.m_left != null) {
            root = root.m_left;
        }
        return root;
    }

    public T findMax() {
        return findMax(m_root).m_value;
    }

    private Node findMax(Node root) {
        if (root == null) {
            return root;
        }
        while (root.m_right != null) {
            root = root.m_right;
        }
        return root;
    }

    private Node removeMin(Node root) {
        if (root == null) {
            return root;
        }
        if (root.m_left != null) {
            root.m_left = removeMin(root.m_left);
            return root;
        }
        return root.m_right;
    }
}

class DuplicateItemException extends Exception {
    public DuplicateItemException() {
        super();
    }
    public DuplicateItemException(String message) {
        super(message);
    }
}
