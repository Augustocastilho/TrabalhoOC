package Instrucoes;

import java.util.HashMap;
import java.util.Map;

/**
 * Constroi uma operacao de qualquer tipo
 */
public class Instrucoes {

    private String valor;
    private long valorDecimal;
    private Map<String, Long> registradores = new HashMap<>();
    
    private long op; //6 bits
    private long rs; //5 bits
    private long rt; //5 bits
    private long rd; //5 bits
    private long shamt; //5 bits
    private long funct; //6 bits
        
    public Instrucoes() {
        this.valor = null;
        valorDecimal = 0;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Converte a representacao binaria em um valor inteiro
     * @param val String com o valor a ser convertido
     */
    public long converteValor(String val) {
        long novoVal = 0;
        for (int i = 0; i < val.length(); i++) {
            char x = val.charAt(val.length() - 1 - i);
            if (x == '1') {
                long y = (long)Math.pow(2, i);
                novoVal = novoVal + y;
            }
        }
        return novoVal;
    }
    
    public long getValorDecimal(){
        return this.valorDecimal;
    }
    
    public void setValorDecimal(long valor) {
        this.valorDecimal = valor;
    }
    
    private void atribuiValores(){
        this.op = converteValor(getValor().substring(0, 5));
        this.rs = converteValor(getValor().substring(6, 10));
        this.rt = converteValor(getValor().substring(11, 15));
        this.rd = converteValor(getValor().substring(16, 20));
        this.shamt = converteValor(getValor().substring(21, 25));
        this.funct = converteValor(getValor().substring(26, 31));
    }

    public void criaRegistradoresTemporarios() {
        //tipos I
        registradores.put("RegWrite", op);
        registradores.put("MemToReg", op);
        registradores.put("Branch", op);
        registradores.put("MemRead", op);
        registradores.put("MemWrite", op);
        registradores.put("RegDst", op);
        registradores.put("ALUOp", op);
        registradores.put("ALUSrc", op);
        registradores.put("PC", op);
        registradores.put("ReadData1", op);
        registradores.put("ReadData2", op);
        registradores.put("ImmediateValue", op);
        registradores.put("rs", op);
        registradores.put("Destino1", op);
        registradores.put("Destino2", op);
    }

}
