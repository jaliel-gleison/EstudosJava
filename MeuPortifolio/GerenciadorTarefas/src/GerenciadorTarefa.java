import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

public class GerenciadorTarefa {
    private static final ArrayList<Tarefa> tarefas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int opcao;
        do {
            mostrarMenu();
            opcao = lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 5);

       scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n---- Gerenciador de Tarefas ----");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Atualizar tarefa");
        System.out.println("4. Remover tarefa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida! Digite um número.");
            return -1;
        }
    }

    private static void executarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarTarefa();
                break;
            case 2:
                listarTarefas();
                break;
            case 3:
                atualizarTarefa();
                break;
            case 4:
                removerTarefa();
                break;
            case 5:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
        }
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a nova tarefa: ");
        tarefas.add(new Tarefa(scanner.nextLine()));
        System.out.println("Tarefa adicionada!");
    }

    private static void listarTarefas() {
        System.out.println("\nTarefas:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + ". " + tarefas.get(i).getDescricao());
        }
    }

    private static void atualizarTarefa() {
        System.out.print("Digite o número da tarefa a ser atualizada: ");
        int indice = lerIndice();
        if (indice != -1) {
            System.out.print("Digite a nova descrição: ");
            tarefas.get(indice).setDescricao(scanner.nextLine());
            System.out.println("Tarefa atualizada!");
        }
    }

    private static void removerTarefa() {
        System.out.print("Digite o número da tarefa a ser removida: ");
        int indice = lerIndice();
        if (indice != -1) {
            tarefas.remove(indice);
            System.out.println("Tarefa removida!");
        }
    }

    private static int lerIndice() {
        try {
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            if (indice >= 0 && indice < tarefas.size()) {
                return indice;
            }
            System.out.println("Número inválido!");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite um número.");
        }
        return -1;
    }

    }

