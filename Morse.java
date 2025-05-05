import java.util.HashMap;
import java.util.Map;

public class Morse {

    public static class Node {
        char letter;
        Node left, right;

        Node(char letter) {
            this.letter = letter;
        }
    }

    private Node root;
    private Map<Character, String> morseMap; // novo

    public Morse() {
        root = new Node(' ');
        morseMap = new HashMap<>();
    }

    public void insert(char letter, String morseCode) {
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
        morseMap.put(letter, morseCode); // armazena para codificação
    }

    public String decode(String morseWord) {
        StringBuilder result = new StringBuilder();
        for (String morseChar : morseWord.split(" ")) {
            result.append(decodeChar(morseChar));
        }
        return result.toString();
    }

    private char decodeChar(String morseChar) {
        Node current = root;
        for (char c : morseChar.toCharArray()) {
            if (c == '.') current = current.left;
            else if (c == '-') current = current.right;
            if (current == null) return '?';
        }
        return current.letter;
    }

    // Método para codificar para Morse
    public String encode(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toUpperCase().toCharArray()) {
            if (ch == ' ') {
                result.append(" / "); // separador entre palavras
            } else if (morseMap.containsKey(ch)) {
                result.append(morseMap.get(ch)).append(" ");
            } else {
                result.append("? ");
            }
        }
        return result.toString().trim();
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public Node getRoot() {
        return root;
    }
}
