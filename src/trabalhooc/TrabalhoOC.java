package trabalhooc;

import java.util.LinkedList;
import java.util.Scanner;
import Instrucoes.Instrucoes;

public class TrabalhoOC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Instrucoes> entradas = new LinkedList<Instrucoes>();
        
        System.out.println("Para ler os dados atraves do teclado, digite '0'");
        System.out.println("Para ler os dados de um arquivo, digite '1'");
        int input = scanner.nextInt();
        
        
        if(input == 0){
            System.out.println("Digite o nome do arquivo com sua extensao:");
            
        }
        else if(input == 1){
            System.out.println("Os dados serao lidos do teclado, voce deve digitar cada instrucao em uma linha, "
                    + "cada instrucao deve conter um total de 32 digitos, caso seja menor, sera completado com zeros a esquerda. "
                    + "Para finalizar a leitura de dados e iniciar a execucao do programa, digite '2'"); //ou a direita, sei la
            entradas.add(new Instrucoes());
            entradas.getLast().setValor(scanner.nextLine());
            
            if(entradas.getLast().getValor().equals("2"))
            {
                System.out.println("Leitura de dados finalizada.");
                entradas.remove(entradas.size()-1);
            }
        }
        else
            System.out.println("Entrada invalida!");
    }
    
}
