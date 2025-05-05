import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Morse tree = new Morse();

        tree.insert('A', ".-");
        tree.insert('B', "-...");
        tree.insert('C', "-.-.");
        tree.insert('D', "-..");
        tree.insert('E', ".");
        tree.insert('F', "..-.");
        tree.insert('G', "--.");
        tree.insert('H', "....");
        tree.insert('I', "..");
        tree.insert('J', ".---");
        tree.insert('K', "-.-");
        tree.insert('L', ".-..");
        tree.insert('M', "--");
        tree.insert('N', "-.");
        tree.insert('O', "---");
        tree.insert('P', ".--.");
        tree.insert('Q', "--.-");
        tree.insert('R', ".-.");
        tree.insert('S', "...");
        tree.insert('T', "-");
        tree.insert('U', "..-");
        tree.insert('V', "...-");
        tree.insert('W', ".--");
        tree.insert('X', "-..-");
        tree.insert('Y', "-.--");
        tree.insert('Z', "--..");

        Scanner scanner = new Scanner(System.in);

        System.out.println("[1] Codificar");
        System.out.println("[2] Decodificar");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.print("Digite uma palavra para codificar: ");
            String text = scanner.nextLine().toUpperCase();
            String encoded = tree.encode(text);
            System.out.println("Codificado: " + encoded);

        } else if (option == 2) {
            System.out.print("Digite código Morse: ");
            String morse = scanner.nextLine();
            String decoded = tree.decode(morse);
            System.out.println("Decodificado: " + decoded);

        } else {
            System.out.println("Opção inválida.");
        }

        new TreeVisualizer();
    }
}
