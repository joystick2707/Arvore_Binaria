public class Morse {

    private Node root;

    public Morse() {
        root = new Node(' ');
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
    }

    // Método recursivo para codificar a palavra
    public String encode(String text) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toUpperCase().toCharArray()) {
            if (ch == ' ') {
                result.append(" / "); // separador entre palavras
            } else {
                String morseCode = findMorseCode(root, ch, "");
                if (morseCode.isEmpty()) {
                    result.append("? ");
                } else {
                    result.append(morseCode).append(" ");
                }
            }
        }
        return result.toString().trim();
    }

    // Método recursivo para encontrar o código Morse
    private String findMorseCode(Node node, char letter, String path) {
        if (node == null) {
            return ""; // Se o node for null, significa que não encontrou a letra
        }

        if (node.letter == letter) {
            return path; // Encontrou a letra, retorna o caminho Morse
        }

        // Tenta procurar à esquerda e à direita
        String leftPath = findMorseCode(node.left, letter, path + ".");
        if (!leftPath.isEmpty()) {
            return leftPath; // Se encontrou à esquerda, retorna o caminho
        }

        // Caso não tenha encontrado à esquerda, tenta à direita
        return findMorseCode(node.right, letter, path + "-");
    }

    // Método para decodificar uma sequência em código Morse
    public String decode(String morseWord) {
        StringBuilder result = new StringBuilder();
        for (String morseChar : morseWord.split(" ")) {
            result.append(decodeChar(root, morseChar));
        }
        return result.toString();
    }

    // Método recursivo para decodificar um único caractere Morse
    private char decodeChar(Node node, String morseChar) {
        for (char c : morseChar.toCharArray()) {
            if (c == '.') {
                node = node.left; // Avança para a esquerda
            } else if (c == '-') {
                node = node.right; // Avança para a direita
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
