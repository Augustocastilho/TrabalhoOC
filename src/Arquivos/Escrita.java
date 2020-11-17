package Arquivos;

import Processamento.Processador;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * É escrito em um arquivo .txt o valor da saída
 */

public class Escrita {
    
    public void escrita (String caminho, String conteudo) throws IOException{
        
        Path arquivo = Paths.get(caminho);
        try{
            byte [] escrita = conteudo.getBytes();
            Files.write(arquivo, escrita);
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
        System.out.println("Read Data 1: "+processador.getRegistradores().get("Read data 1"));
        System.out.println("Read Data 2: "+processador.getRegistradores().get("Read register 2"));
        System.out.println("Write register : "+processador.getRegistradores().get("Write register"));
        System.out.println("Write data : "+processador.getRegistradores().get("Write Data"));
        System.out.println("Read data 1: "+processador.getSaidasRegistrador().get("Read data 1"));
        System.out.println("Read data 2: "+processador.getSaidasRegistrador().get("Read data 2"));
        System.out.println("Resultado: "+processador.getAluOut());
        System.out.println("Address: "+processador.getMemoriaDados());
    }
}
