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
    
    public void ImpressaoTipoR(
            long pc, 
            Instrucoes memoria, 
            Processador processador,
            Map<String, Integer> registradores,
            String nomeInstrucao,
            int numRegistrador,
            long resultadoAlu,
            long address
    ){
        List<Integer> saidas = processador.registrador(registradores.get(""), registradores.get(""), numRegistrador , registradores.get("Write register"), registradores.get("Write Data"));
        System.out.println("**************************Iteracao********************************");
        System.out.println("PC: "+pc);
        System.out.println("Instrução: "+nomeInstrucao);
        System.out.println("Read Data 1: "+registradores.get("Read register 1"));
        System.out.println("Read Data 2: "+registradores.get("Read register 2"));
        System.out.println("Write register : "+registradores.get("Write register"));
        System.out.println("Write data : "+registradores.get("Write Data"));
        System.out.println("Read data 1: "+saidas.get(0));
        System.out.println("Read data 2: "+saidas.get(1));
        System.out.println("Resultado: "+resultadoAlu);
        System.out.println("Address: "+address);
        System.out.println("Write data: "+registradores.get("Write Data"));
        System.out.println("Read data: "+resultadoAlu); // mudar a saida
    }
}
