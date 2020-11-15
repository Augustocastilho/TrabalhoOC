package Instrucoes;

/**
 * Constroi uma operacao de qualquer tipo
 */
public class Instrucoes {

    private String valor;
    private double valorDecimal;

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

}
