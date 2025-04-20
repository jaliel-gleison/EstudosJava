import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do saldo inicial
        double saldoInicial = scanner.nextDouble();

        // TODO: Na linha abaixo, implemente a entrada das três transações:
        double[] transacoes = new double[3];
        for (int i = 0; i < transacoes.length; i++) {
        
            transacoes[i] = scanner.nextDouble();
        }

        // TODO: Na linha abaixo, realize o cálculo do saldo final:
       
       
          double saldoFinal = saldoInicial; 

           for (double transacao : transacoes) {
                saldoFinal += transacao; 
            }
         
        // Saldo final
        System.out.printf("Saldo final: %.2f\n",saldoFinal);

        scanner.close();
    }
}
