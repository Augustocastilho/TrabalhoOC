package Arquivos;

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
    
    public void Impressao(){
        System.out.println("**************************Iteracao********************************");
        //System.out.println("PC="+pc -> +"Memoria="+memoria ->+"");
        //System.out.println("Registradores temporarios: Alu.."+alu+", papa\n");
        
    }
}
