package Arquivos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

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
