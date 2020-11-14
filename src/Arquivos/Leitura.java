package Arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Beatr
 */
public class Leitura {
    
    public String leitura(String file) throws IOException{
        Path caminho = Paths.get(file);
        try{
            byte [] texto = Files.readAllBytes(caminho);
            String leitura = new String(texto);
            return leitura;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
