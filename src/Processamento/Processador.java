package Processamento;

import Instrucoes.TipoR;
import java.util.HashMap;
import java.util.Map;

public class Processador {

    private HashMap<Integer, String> mapaInstrucoes = new HashMap<>();
    private String nomeInstrucao;

    private void criaMap() {
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

    public void setNomeInstrucao(int controle) {
        for (Map.Entry<Integer, String> map : mapaInstrucoes.entrySet()) {
            if (controle == map.getKey()) {
                nomeInstrucao = map.getValue();
            }
        }
    }

    public String getNomeInstrucao() {
        return this.nomeInstrucao;
    }

    public int Alu(int entrada1, int entrada2, int controleAlu) {
        TipoR funcoes = new TipoR();
        int resultado = 0;
        int zero = 0;
        switch (zero) {
            case 1:
                return 0;
            default:
                switch (nomeInstrucao) {
                    case "add":
                        resultado = funcoes.add(entrada1, entrada2);
                        break;
                    case "sub":
                        resultado = funcoes.sub(entrada1, entrada2);
                        break;
                    case "mult":
                        resultado = funcoes.mult(entrada1, entrada2);
                        break;
                    case "div":
                        resultado = funcoes.div(entrada1, entrada2);
                        break;
                    case "and":
                        resultado = funcoes.and(entrada1, entrada2);
                        break;
                    case "or":
                        resultado = funcoes.or(entrada1, entrada2);
                        break;
                    case "slt":
                        //resultado = funcoes.slt(entrada1, entrada2);
                        break;
                    case "sll":
                        //resultado = funcoes.sll(entrada1, entrada2);
                        break;
                    case "jr":
                        //resultado = funcoes.jr(entrada1, entrada2);
                        break;
                    default: break;
                }
                break;
        }
        return resultado;
    }
}
