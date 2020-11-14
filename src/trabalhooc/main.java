package trabalhooc;

import Arquivos.Leitura;
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
        Scanner in = new Scanner(System.in);
        System.out.println("Entre com o caminho para o arquivo de leitura (colocando o nome do arquivo com o final .txt): ");
        String caminho = in.nextLine();
        try{
            String arquivo = output.leitura(caminho);
            System.out.println(arquivo);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
