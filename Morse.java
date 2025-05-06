// Classe que representa uma árvore binária para codificação e decodificação em código Morse
public class Morse {

    private Node root;

    public Morse() {
        root = new Node(' ');
    }
    
    // Insere uma letra na árvore com base em seu código Morse
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
    }

    // Codifica uma string de texto para código Morse
    public String encode(String text) {
        String result = "";
        for (char ch : text.toUpperCase().toCharArray()) {
            if (ch == ' ') {
                result += " / "; // separador entre palavras
            } else {
                String morseCode = findMorseCode(root, ch, "");
                if (morseCode.isEmpty()) {
                    result += "? ";
                } else {
                    result += morseCode + " ";
                }
            }
        }
        return result.trim();
    }

    private String findMorseCode(Node node, char letter, String path) {
        if (node == null) {
            return "";
        }

        if (node.letter == letter) {
            return path;
        }

        String leftPath = findMorseCode(node.left, letter, path + ".");
        if (!leftPath.isEmpty()) {
            return leftPath;
        }

        return findMorseCode(node.right, letter, path + "-");
    }

    public String decode(String morseWord) {
        String result = "";
        for (String morseChar : morseWord.split(" ")) {
            result += decodeChar(root, morseChar);
        }
        return result;
    }

    private char decodeChar(Node node, String morseChar) {
        for (char c : morseChar.toCharArray()) {
            if (c == '.') {
                node = node.left;
            } else if (c == '-') {
                node = node.right;
            }
            if (node == null) {
                return '?';
            }
        }
        return node.letter;
    }

    public Node getRoot() {
        return root;
    }
}
