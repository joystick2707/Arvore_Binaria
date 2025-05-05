import javax.swing.*;
import java.awt.*;

public class TreeVisualizer extends JFrame {

    // Classe Node para a árvore binária de busca
    static class Node {
        char letter;
        Node left, right;

        Node(char letter) {
            this.letter = letter;
        }
    }

    static class MorseBST {
        private Node root;

        public void insert(char letter, String morseCode) {
            if (root == null) root = new Node(' ');
            Node current = root;
            for (char c : morseCode.toCharArray()) {
                if (c == '.') {
                    if (current.left == null)
                        current.left = new Node(' ');
                    current = current.left;
                } else if (c == '-') {
                    if (current.right == null)
                        current.right = new Node(' ');
                    current = current.right;
                }
            }
            current.letter = letter;
        }

        public int getHeight() {
            return getHeight(root);
        }

        private int getHeight(Node node) {
            if (node == null) return 0;
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        public void drawTree(Graphics g, int width, int height) {
            drawNode(g, root, width / 2, 40, width / 4, 1);
        }

        private void drawNode(Graphics g, Node node, int x, int y, int xOffset, int level) {
            if (node == null) return;

            g.setColor(Color.BLACK);
            g.drawOval(x - 15, y - 15, 30, 30);
            g.drawString(String.valueOf(node.letter), x - 5, y + 5);

            if (node.left != null) {
                int newX = x - xOffset;
                int newY = y + 100;
                g.drawLine(x, y + 15, newX, newY - 15);
                drawNode(g, node.left, newX, newY, xOffset / 2, level + 1);
            }
            if (node.right != null) {
                int newX = x + xOffset;
                int newY = y + 100;
                g.drawLine(x, y + 15, newX, newY - 15);
                drawNode(g, node.right, newX, newY, xOffset / 2, level + 1);
            }
        }
    }

    public TreeVisualizer() {
        setTitle("Visualizador de Árvore Morse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MorseBST bst = new MorseBST();

        bst.insert('A', ".-");
        bst.insert('B', "-...");
        bst.insert('C', "-.-.");
        bst.insert('D', "-..");
        bst.insert('E', ".");
        bst.insert('F', "..-.");
        bst.insert('G', "--.");
        bst.insert('H', "....");
        bst.insert('I', "..");
        bst.insert('J', ".---");
        bst.insert('K', "-.-");
        bst.insert('L', ".-..");
        bst.insert('M', "--");
        bst.insert('N', "-.");
        bst.insert('O', "---");
        bst.insert('P', ".--.");
        bst.insert('Q', "--.-");
        bst.insert('R', ".-.");
        bst.insert('S', "...");
        bst.insert('T', "-");
        bst.insert('U', "..-");
        bst.insert('V', "...-");
        bst.insert('W', ".--");
        bst.insert('X', "-..-");
        bst.insert('Y', "-.--");
        bst.insert('Z', "--..");

        int height = bst.getHeight();
        int canvasHeight = 100 + height * 100;
        int canvasWidth = (int) Math.pow(2, height) * 40;

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                bst.drawTree(g, getWidth(), getHeight());
            }
        };

        panel.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        add(new JScrollPane(panel));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TreeVisualizer::new);
    }
}
