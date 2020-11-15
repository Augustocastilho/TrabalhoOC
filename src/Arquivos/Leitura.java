package Arquivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
/**
 *
 * Onde é lido o arquivo .txt
 */

public class Leitura {
    
    public LinkedList<String> leitura(String file) throws IOException{
        String linha;
        LinkedList<String> lista = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader("arquivos/"+file));
        while ((linha = br.readLine()) != null) {
            lista.add(linha);
        }
        br.close();
        return lista;
    }
}
