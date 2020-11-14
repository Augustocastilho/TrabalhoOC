package Instrucoes;

import java.util.HashMap;
import java.util.Map;

public class TipoR extends Instrucoes{

    private int op ; //6 bits
    private int rs ; //5 bits
    private int rt; //5 bits
    private int rd; //5 bits
    private int shamt; //5 bits
    private int funct; //6 bits
    
    private String nomeInstrucao;    
    private HashMap<Integer, String> mapaInstrucoes = new HashMap<>();
    
    private void atribuiValores(){
        this.op = Integer.parseInt(getValor().substring(0, 5));
        this.rs = Integer.parseInt(getValor().substring(6, 10));
        this.rt = Integer.parseInt(getValor().substring(11, 15));
        this.rd = Integer.parseInt(getValor().substring(16, 20));
        this.shamt = Integer.parseInt(getValor().substring(21, 25));
        this.funct = Integer.parseInt(getValor().substring(26, 31));
    }
    
    private void criaMap(){
        mapaInstrucoes.put(100000, "add");
        mapaInstrucoes.put(100010, "sub");
        mapaInstrucoes.put(011000, "mult");
        mapaInstrucoes.put(011010, "div");
        mapaInstrucoes.put(100100, "and");
        mapaInstrucoes.put(100101, "or");
        mapaInstrucoes.put(101010, "slt");
        mapaInstrucoes.put(000000, "sll");
        mapaInstrucoes.put(001000, "jr");
    }
    
    public void setNomeInstrucao(){       
        for(Map.Entry<Integer, String> map : mapaInstrucoes.entrySet()){
            if(op == map.getKey())
                nomeInstrucao = map.getValue();
        }
    }
    
    public String getNomeInstrucao(){
        return this.nomeInstrucao;
    }
    
    public int add(int val, int val2){
        return val+val2;
    }
    
}
