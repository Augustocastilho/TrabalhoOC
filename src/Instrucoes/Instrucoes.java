package Instrucoes;

/**
 * Constroi uma operacao de qualquer tipo
 */
public class Instrucoes {

    private String valor;
    private long valorDecimal;

    private long op; //6 bits
    private long rs; //5 bits
    private long rt; //5 bits
    private long rd; //5 bits
    private long shamt; //5 bits
    private long funct; //6 bits
    private long address; //16 bits

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
     *
     * @param val String com o valor a ser convertido
     */
    public long converteValor(String val) {
        long novoVal = 0;
        for (int i = 0; i < val.length(); i++) {
            char x = val.charAt(val.length() - 1 - i);
            if (x == '1') {
                long y = (long) Math.pow(2, i);
                novoVal = novoVal + y;
            }
        }
        return novoVal;
    }

    public long getValorDecimal() {
        return this.valorDecimal;
    }

    public void setValorDecimal(long valor) {
        this.valorDecimal = valor;
    }

    public void atribuiValores() {
        this.op = converteValor(getValor().substring(0, 6));
        this.rs = converteValor(getValor().substring(6, 11));
        this.rt = converteValor(getValor().substring(11, 16));
        if (getOp() != 0) { //intrucoes tipo I e J
            this.address = converteValor(getValor().substring(16, 32));
        } else { //instrucoes tipo R
            this.rd = converteValor(getValor().substring(16, 21));
            this.shamt = converteValor(getValor().substring(21, 26));
            this.funct = converteValor(getValor().substring(26, 32));
        }
    }
    
    public long getOp() {
        return op;
    }

    public long getRs() {
        return rs;
    }

    public long getRt() {
        return rt;
    }

    public long getRd() {
        return rd;
    }

    public long getShamt() {
        return shamt;
    }

    public long getFunct() {
        return funct;
    }

    public long getAddress() {
        return address;
    }


}
