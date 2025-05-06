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
        int option;

        do {
            System.out.println("[1] Codificar");
            System.out.println("[2] Decodificar");
            System.out.println("[3] Visualizar Árvore");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    System.out.print("Digite uma palavra para codificar: ");
                    String text = scanner.nextLine().toUpperCase();
                    String encoded = tree.encode(text);
                    System.out.println("Codificado: " + encoded);
                    break;

                case 2:
                    System.out.print("Digite código Morse: ");
                    String morse = scanner.nextLine();
                    String decoded = tree.decode(morse);
                    System.out.println("Decodificado: " + decoded);
                    break;

                case 3:
                    new TreeVisualizer(tree.getRoot());
                    break;

                case 4:
                    System.out.println("Saindo do programa");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (option != 4);

        scanner.close();
    }
}
