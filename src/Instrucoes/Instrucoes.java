package Instrucoes;

import java.util.HashMap;
import java.util.Map;

/**
 * Constroi uma operacao de qualquer tipo
 */
public class Instrucoes {

    private String valor;
    private double valorDecimal;
    private Map<String, Registradores> registradores = new HashMap<>();

    public Instrucoes() {
        this.valor = "00000000000000000000000000000000";
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Converte a representacao binaria em um valor inteiro
     */
    public void converteValor() {
        for (int i = 0; i < this.valor.length(); i++) {
            char y = this.valor.charAt(this.valor.length() - 1 - i);
            if (y == '1') {
                double z = Math.pow(2, i);
                valorDecimal = valorDecimal + z;
            }
        }
    }

    public void criaRegistradores() {
        //tipos I
        registradores.put("RegWrite", new Registradores(1));
        registradores.put("MemToReg", new Registradores(1));
        registradores.put("Branch", new Registradores(1));
        registradores.put("MemRead", new Registradores(1));
        registradores.put("MemWrite", new Registradores(1));
        registradores.put("RegDst", new Registradores(1));
        registradores.put("ALUOp", new Registradores(2));
        registradores.put("ALUSrc", new Registradores(1));
        registradores.put("PC", new Registradores(32));
        registradores.put("ReadData1", new Registradores(32));
        registradores.put("ReadData2", new Registradores(32));
        registradores.put("ImmediateValue", new Registradores(32));
        registradores.put("rs", new Registradores(5));
        registradores.put("Destino1", new Registradores(5));
        registradores.put("Destino2", new Registradores(5));
    }

}
