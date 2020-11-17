package Arquivos;

import Processamento.Processador;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * É escrito em um arquivo .txt o valor da saída
 */

public class Escrita {
    
    public void escrita (String caminho, String conteudo) throws IOException{
        
        File arquivo = new File("arquivos/"+caminho);
        FileWriter fileWriter = new FileWriter(arquivo, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        try{
            if(!arquivo.exists()){
                arquivo.createNewFile();
                printWriter.println(conteudo);
                printWriter.flush();
                printWriter.close();
            }                
            else{
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
   
        String conteudo = "**************************Iteracao********************************"+"\n"+
                        "PC: "+processador.getIndice()+ "\n"+
                        "Instrução: "+processador.getNomeInstrucao() + "\n"+
                        "Read register 1: "+processador.getRegistradores().get("Read register 1") + "\n"+
                        "Read register 2: "+processador.getRegistradores().get("Read register 2") + "\n"+
                        "Write register : "+processador.getRegistradores().get("Write register") + "\n"+
                        "Write data : "+processador.getRegistradores().get("Write Data") + "\n"+
                        "Read Data 1: "+processador.getSaidasRegistrador().get("Read data 1") + "\n"+
                        "Read Data 2: "+processador.getSaidasRegistrador().get("Read data 2") + "\n"+
                        "Resultado: "+processador.getAluOut() + "\n"+
                        "Address: "+processador.getMemoriaDados().get("address") + "\n";
        System.out.println(conteudo);
        String arquivo = "\n" + "**************************Memória de dados e sinal de controle*************************" + "\n"+
                        "Read Data - Memória de dados: "+processador.getMemoriaDados()+"\n"+
                        "RegWrite: "+processador.getSinaisDeControle().get("RegWrite")+"\n"+
                        "MemToReg: "+processador.getSinaisDeControle().get("MemToReg")+"\n"+
                        "Branch: "+processador.getSinaisDeControle().get("Branch")+"\n"+
                        "MemRead: "+processador.getSinaisDeControle().get("MemRead")+"\n"+
                        "MemWrite: "+processador.getSinaisDeControle().get("MemWrite")+"\n"+
                        "RegDst: "+processador.getSinaisDeControle().get("RegDst")+"\n"+
                        "ALUOp: "+processador.getSinaisDeControle().get("ALUOp")+ "\n"+
                        "ALUSrc: "+processador.getSinaisDeControle().get("ALUSrc")+ "\n"+
                        "Jump: "+processador.getSinaisDeControle().get("Jump")+"\n";          
        String print = conteudo.concat(arquivo);
        gravaArquivo(print, processador);
    }
    
    public void gravaArquivo(String conteudo, Processador processador){
        try{
            escrita(processador.getCaminhoDoArquivo(), conteudo);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
