package Processamento;

import Instrucoes.TipoR;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * simula o procedimento feito por um porcessador MIPS
 */
public class Processador {

    private HashMap<Integer, String> mapaInstrucoes = new HashMap<>();
    private String nomeInstrucao;

    /**
     * cria um dicionario com todas as operacoes possiveis
     */
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

    /**
     * @param entrada1 recebe o primeiro valor vindo do registrador
     * @param entrada2 recebe o segundo valor vindo do registrador
     * @param controleAlu indica qual operacao logica/matematica sera realizada
     * @return retorna o resultado da operacao
     */
    public int alu(int entrada1, int entrada2, int controleAlu) {
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
                        resultado = funcoes.slt(entrada1, entrada2);
                        break;
                    case "sll":
                        resultado = funcoes.sll(entrada1, entrada2);
                        break;
                    case "jr":
                        //resultado = funcoes.jr(entrada1, entrada2);
                        break;
                    default:
                        break;
                }
                break;
        }
        return resultado;
    }

    /**
     * 
     * @param read1 Recebe IR[25:21]
     * @param read2 Recebe IR[20:16]
     * @param write Recebe IR[15:11]
     * @param writeData 
     * @param regWrite Registrador de memoria
     * @return Lista com os valores de A e B
     */
    public List<Integer> registradores(
            int read1,
            int read2,
            int write,
            int writeData,
            int regWrite
    ) {
        Map<String, Integer> registrador = new HashMap<>();
        registrador.put("Read register 1", read1);
        registrador.put("Read register 2", read2);
        registrador.put("Write register", write);
        registrador.put("Write Data", writeData);

        List<Integer> saidas = new ArrayList<>();

        switch (regWrite) {
            case 1:

                break;
            default:
                break;
        }

        saidas.set(0, read1);
        saidas.set(1, read2);
        
        return saidas;
    }

}
