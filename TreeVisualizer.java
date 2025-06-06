import javax.swing.*;
import java.awt.*;

// Classe TreeVisualizer que herda de JFrame para exibir uma janela gráfica
public class TreeVisualizer extends JFrame {
    private Node root;

    // Construtor: recebe a raiz da árvore e configura a janela
    public TreeVisualizer(Node morseRoot) {
        setTitle("Árvore Morse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.root = morseRoot;

        int height = getHeight(root);
        int canvasHeight = 100 + height * 100;
        int canvasWidth = (int) Math.pow(2, height) * 40;

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(g, getWidth(), getHeight());
            }
        };

        panel.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        add(new JScrollPane(panel));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private void drawTree(Graphics g, int width, int height) {
        drawNode(g, root, width / 2, 40, width / 4, 1);
    }

    private void drawNode(Graphics g, Node node, int x, int y, int xOffset, int level) {
        if (node == null) return;

        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(String.valueOf(node.letter), x - 5, y + 5);

          // Desenha linha e recursivamente o nó da esquerda ('.')
        if (node.left != null) {
            int newX = x - xOffset;
            int newY = y + 100;
            g.drawLine(x, y + 15, newX, newY - 15);
            drawNode(g, node.left, newX, newY, xOffset / 2, level + 1);
        }

        // Desenha linha e recursivamente o nó da direita ('-')
        if (node.right != null) {
            int newX = x + xOffset;
            int newY = y + 100;
            g.drawLine(x, y + 15, newX, newY - 15);
            drawNode(g, node.right, newX, newY, xOffset / 2, level + 1);
        }
    }
}
