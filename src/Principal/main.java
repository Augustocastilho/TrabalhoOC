package Principal;

import Arquivos.Leitura;
import Instrucoes.Instrucoes;
import Processamento.Processador;
import java.util.LinkedList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        //Iniciado a entrada dos dados tanto pelo teclado, tanto por um arquivo .txt
        Leitura output = new Leitura();
        System.out.println("Para ler os dados atraves do teclado, digite '0'");
        System.out.println("Para ler os dados de um arquivo, digite '1'");
        System.out.println("Para sair, digite '2'");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        LinkedList<Instrucoes> entradas = new LinkedList<>();

        switch (input) {
            case 0:
                //Lê os dados do teclado
                System.out.println("Os dados serao lidos do teclado, voce deve digitar cada instrucao em uma linha. "
                        + "\nCada instrucao deve conter um total de 32 digitos, caso seja menor, sera completado com zeros a esquerda. "
                        + "\nPara finalizar a leitura de dados e iniciar a execucao do programa, digite 2");
                entradas.add(new Instrucoes());
                entradas.getLast().setValor(scanner.nextLine().trim());

                while (!entradas.getLast().getValor().equals("2")) {
                    entradas.add(new Instrucoes());
                    entradas.getLast().setValor(scanner.nextLine().trim());
                }

                System.out.println("Leitura de dados finalizada.");

                //Remove a última entrada que é a flag para parar a entrada de dados
                entradas.remove(entradas.size() - 1);
                entradas.remove(0);

                //Caso o usuário entre com bits de tamanho menor que 32, preenchemos todos os bits a direita com 0
                for (Instrucoes entrada : entradas) {
                    while (entrada.getValor().length() < 32) {
                        entrada.setValor(entrada.getValor().concat("0"));
                    }
                }

                for (int i = 0; i < entradas.size(); i++)
                    entradas.get(i).setValorDecimal(entradas.get(i).converteValor(entradas.get(i).getValor()));

                break;
            case 1:
                //Pede para que o usuário entre com o nome do arquivo para que seja lido
                System.out.println("Entre com o nome do arquivo de leitura (colocando o nome do arquivo com o final .txt): ");
                String caminho = scanner.next();
                try {
                    String arquivo = output.leitura(caminho);
                    System.out.println(arquivo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                //precisa implementar a inserçao de cada linha do arquivo no vetor
                /*entradas.add(new Instrucoes());
                
                
                for (int i = 0; i < entradas.size(); i++) {
                    entradas.get(i).converteValor();
                }*/
                
                break;
            case 2:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Entrada inválida!");
                break;
        }
        long pc = entradas.getFirst().getValorDecimal();
        Processador mips = new Processador(pc);
        

        //for (int i = 0; i < entradas.size(); i++)
          //  System.out.println(entradas.get(i).getValor() + "     valor convertido: " + entradas.get(i).getValorDecimal());
        

        entradas.clear(); //Libera memória
    }
}
