package Principal;

import Arquivos.Leitura;
import Instrucoes.Instrucoes;
import java.util.LinkedList;
import java.util.Scanner;


public class main {

    /*public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Instrucoes> entradas = new LinkedList<>();

        System.out.println("Para ler os dados atraves do teclado, digite '0'");
        System.out.println("Para ler os dados de um arquivo, digite '1'");
        int input = scanner.nextInt();

        switch (input) {
            case 0:
                System.out.println("Digite o nome do arquivo com sua extensao:");
                try {
                    BufferedReader leitura = new BufferedReader(new FileReader(scanner.nextLine()));
                    String linha = leitura.readLine();
                    linha = leitura.readLine();
                    
                    while (linha != null) {
                        entradas.add(new Instrucoes());
                        entradas.getLast().setValor(linha);
                        linha = leitura.readLine();
                    }
                    
                    leitura.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("ERRO: Não foi possível ler o arquivo de categorias!");
                } break;
            case 1:
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
                entradas.remove(entradas.size() - 1);
                break;
            default:
                System.out.println("Entrada invalida!");
                break;
        }

        System.out.println("Impressao de valores:");
        for (Instrucoes valor : entradas) {
            System.out.println(valor.getValor());
        }
        entradas.clear(); //libera memória
    }*/
    public static void main(String[] args) {
        Leitura output = new Leitura();
        System.out.println("Para ler os dados atraves do teclado, digite '0'");
        System.out.println("Para ler os dados de um arquivo, digite '1'");
        System.out.println("Para sair, digite '2'");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        LinkedList<Instrucoes> entradas = new LinkedList<>();
        
        switch (input) {  
            case 0:
                System.out.println("Os dados serao lidos do teclado, voce deve digitar cada instrucao em uma linha. "
                        + "\nCada instrucao deve conter um total de 32 digitos, caso seja menor, sera completado com zeros a esquerda. "
                        + "\nPara finalizar a leitura de dados e iniciar a execucao do programa, digite 2");
                entradas.add(new Instrucoes());
                entradas.getLast().setValor(scanner.nextLine().trim());
                
                while (!entradas.getLast().getValor().equals("2")) {
                    entradas.add(new Instrucoes());
                    entradas.getLast().setValor(scanner.next().trim());
                }
                
                System.out.println("Leitura de dados finalizada.");
                entradas.remove(entradas.size() - 1);
                entradas.remove(0);
                for (Instrucoes entrada : entradas) {
                    while(entrada.getValor().length() < 32){
                        entrada.setValor(entrada.getValor().concat("0"));
                    } 
                }
                break;
            case 1:
                System.out.println("Entre com o caminho para o arquivo de leitura (colocando o nome do arquivo com o final .txt): ");
                String caminho = scanner.next();
                try{
                    String arquivo = output.leitura(caminho);
                    System.out.println(arquivo);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Entrada inválida!");
                break;
        } 
        for(int i=0; i<entradas.size();i++)
            System.out.println(entradas.get(i).getValor());
        
        entradas.clear(); //Libera memória
    }
}
