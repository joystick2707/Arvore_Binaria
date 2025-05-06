// Classe Node representa um nó da árvore binária usada para o código Morse
public class Node {
    public char letter;
    public Node left, right;

     // Construtor: inicializa o nó com uma letra (ou espaço ' ' se for intermediário)
    public Node(char letter) {
        this.letter = letter;
    }
}
