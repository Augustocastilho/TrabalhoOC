package Arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * Onde é lido o arquivo .txt
 */

public class Leitura {
    
    public String leitura(String file) throws IOException{
        Path caminho = Paths.get("arquivos/"+file);
        try{
            byte [] texto = Files.readAllBytes(caminho);
            String leitura = new String(texto);
            return leitura;
        }catch(Exception e){
            System.out.println("Erro na leitura.");
        }
        return null;
    }
}
