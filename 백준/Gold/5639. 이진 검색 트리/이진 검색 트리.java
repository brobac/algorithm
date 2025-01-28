import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;

            int v = Integer.parseInt(input);
            tree.add(v);

        }
        tree.postOrder();

    }


    static class BinarySearchTree<T extends Comparable<T>> {
        private Node<T> root;
        private StringBuilder sb;

        public void add(T v) {
            if (root == null) {
                root = new Node<>(v);
                return;
            }

            Node<T> cur = root;

            while (true) {
                if (0 < cur.key.compareTo(v)) {
                    if (cur.left == null) {
                        cur.left = new Node<>(v);
                        break;
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = new Node<>(v);
                        break;
                    }
                    cur = cur.right;
                }

            }
        }

        public void postOrder() {
            if (root == null) return;
            sb = new StringBuilder();
            postOrder(root);

            System.out.println(sb);
        }

        private void postOrder(Node<T> node) {
            //left
            if (node.left != null) {
                postOrder(node.left);
            }
            //right
            if (node.right != null) {
                postOrder(node.right);
            }
            sb.append(node.key).append("\n");
        }
    }

    static class Node<T extends Comparable<T>> {
        T key;
        Node<T> left, right;


        public Node(T key) {
            this.key = key;
        }
    }
}