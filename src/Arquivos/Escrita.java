package Arquivos;

import Processamento.Processador;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * É escrito em um arquivo .txt o valor da saída
 */

public class Escrita {
    
    public void escrita (String caminho, String conteudo) throws IOException{
        
        File arquivo = new File("arquivos/"+caminho);
        FileWriter fileWriter = new FileWriter(arquivo, true);
        try{
            if(!arquivo.exists())
                arquivo.createNewFile();
            else{
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(conteudo);
                printWriter.flush();
                printWriter.close();
            }     
            System.out.println("Salvo com sucesso.");
        }catch (Exception e){
            System.out.println("Erro ao salvar.");
        }
    }
    
    public void ImpressaoTipoR(
            Processador processador
    ){
   
        System.out.println("**************************Iteracao********************************");
        System.out.println("PC: "+processador.getIndice());
        System.out.println("Instrução: "+processador.getNomeInstrucao());
        System.out.println("Read register 1: "+processador.getRegistradores().get("Read register 1"));
        System.out.println("Read register 2: "+processador.getRegistradores().get("Read register 2"));
        System.out.println("Write register : "+processador.getRegistradores().get("Write register"));
        System.out.println("Write data : "+processador.getRegistradores().get("Write Data"));
        System.out.println("Read Data 1: "+processador.getSaidasRegistrador().get("Read data 1"));
        System.out.println("Read Data 2: "+processador.getSaidasRegistrador().get("Read data 2"));
        System.out.println("Resultado: "+processador.getAluOut());
        System.out.println("Address: "+processador.getMemoriaDados().get("address"));
        
    }
}
