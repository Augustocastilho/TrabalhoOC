package Arquivos;

import Instrucoes.Instrucoes;
import Processamento.Processador;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
    
    public void Impressao(
            long pc, 
            Instrucoes memoria, 
            Processador processador,
            Map<String, Integer> registradores,
            String nomeInstrucao
    ){
        System.out.println("**************************Iteracao********************************");
        System.out.println("PC= "+pc+"Memoria="+memoria);
        System.out.println("Registradores temporarios: Alu: ");
        
    }
}
