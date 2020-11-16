package Processamento;

import Instrucoes.Instrucoes;
import Instrucoes.TipoR;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * simula o procedimento feito por um porcessador MIPS
 */
public class Processador {

    private Instrucoes memoriaInstrucao = new Instrucoes();
    private Map<String, Long> memoriaDados = new HashMap<>();
    private Map<Integer, String> mapaInstrucoes = new HashMap<>();
    private String nomeInstrucao; //usado para verificacao no ALU

    private List<Map<String, Integer>> registradores = new LinkedList<>();
    private Map<String, Long> sinaisDeControle = new HashMap<>();

    /**
     *
     * @param pc inicia o processador MIPS
     */
    public Processador(Instrucoes pc) {
        this.memoriaInstrucao = pc;
        memoriaInstrucao.atribuiValores();
        if (memoriaInstrucao.getOp() == 0) {
            criaMapR();
        } else {
            criaMapIeJ();
        }

    }

    public void criaSinaisControle() {
        //tipos I
        sinaisDeControle.put("RegWrite", memoriaInstrucao.getOp());
        sinaisDeControle.put("MemToReg", memoriaInstrucao.getOp());
        sinaisDeControle.put("Branch", memoriaInstrucao.getOp());
        sinaisDeControle.put("MemRead", memoriaInstrucao.getOp());
        sinaisDeControle.put("MemWrite", memoriaInstrucao.getOp());
        sinaisDeControle.put("RegDst", memoriaInstrucao.getOp());
        sinaisDeControle.put("ALUOp", memoriaInstrucao.getOp());
        sinaisDeControle.put("ALUSrc", memoriaInstrucao.getOp());
        sinaisDeControle.put("PC", memoriaInstrucao.getOp());
        sinaisDeControle.put("ReadData1", memoriaInstrucao.getOp());
        sinaisDeControle.put("ReadData2", memoriaInstrucao.getOp());
        sinaisDeControle.put("ImmediateValue", memoriaInstrucao.getOp());
        sinaisDeControle.put("rs", memoriaInstrucao.getOp());
        sinaisDeControle.put("Destino1", memoriaInstrucao.getOp());
        sinaisDeControle.put("Destino2", memoriaInstrucao.getOp());
    }

    /**
     * cria um dicionario com todas as operacoes possiveis do tipo R
     */
    private void criaMapR() {
        mapaInstrucoes.put(32, "add");
        mapaInstrucoes.put(34, "sub");
        mapaInstrucoes.put(24, "mult");
        mapaInstrucoes.put(26, "div");
        mapaInstrucoes.put(36, "and");
        mapaInstrucoes.put(37, "or");
        mapaInstrucoes.put(42, "slt");
        mapaInstrucoes.put(0, "sll");
        mapaInstrucoes.put(8, "jr");
    }

    /**
     * cria um dicionario com todas as operacoes possiveis do tipo I e J
     */
    private void criaMapIeJ() {
        mapaInstrucoes.put(8, "addi");
        mapaInstrucoes.put(35, "lw");
        mapaInstrucoes.put(43, "sw");
        mapaInstrucoes.put(4, "beq");
        mapaInstrucoes.put(5, "bne");
        mapaInstrucoes.put(2, "j");
        mapaInstrucoes.put(3, "jal");
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
    public long alu(long entrada1, long entrada2, long controleAlu) {
        TipoR funcoes = new TipoR();
        long resultado = 0;
        int zero = (int) funcoes.sub(entrada1, entrada2) + 1;
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
                        resultado = funcoes.jr(entrada1);
                        break;
                    default:
                        break;
                }
                break;
        }
        return resultado;
    }

    public Long memoriaDeDados(Long address, Long writeData) {
        memoriaDados.put("address", address);
        memoriaDados.put("writeData", writeData);
        memoriaDados.put("MemWrite", sinaisDeControle.get("MemWrite"));
        memoriaDados.put("MemRead", sinaisDeControle.get("MemRead"));

        long memWrite = sinaisDeControle.get("MemWrite");
        long memRead = sinaisDeControle.get("MemRead");

        switch ((int) memWrite) {
            case 1:
                memoriaDados.put("ReadData", writeData);
                break;
            default:
                break;
        }

        switch ((int) memRead) {
            case 1:
                memoriaDados.put("ReadData", address);
                break;
            default:
                break;
        }

        return memoriaDados.get("ReadData");
    }

    /**
     * @param read1 Recebe IR[25:21]
     * @param read2 Recebe IR[20:16]
     * @param write Recebe IR[15:11]
     * @param writeData
     * @return Lista com os valores de A e B
     */
    public List<Integer> registrador(
            int numRegistrador,
            int read1,
            int read2,
            int write,
            int writeData
    ) {
        List<Integer> saidas = new ArrayList<>();
        long regWrite = sinaisDeControle.get("RegWrite");

        switch ((int) regWrite) {
            case 1:
                write = writeData;
                break;
            default:
                break;
        }

        registradores.get(numRegistrador).put("Read register 1", read1);
        registradores.get(numRegistrador).put("Read register 2", read2);
        registradores.get(numRegistrador).put("Write register", write);
        registradores.get(numRegistrador).put("Write Data", writeData);

        saidas.set(0, read1);
        saidas.set(1, read2);

        return saidas;
    }

    /**
     * Se address for positivo soma 0s, se for negativo adiciona 1s
     *
     * @return valor acrescido de 0s ou 1s
     */
    public long singextend() {
        char aux = memoriaInstrucao.getValor().charAt(16);
        long val = 0;
        switch (aux) {
            case '1':
                for (int i = 16; i < 32; i++) {
                    long y = (long) Math.pow(2, i);
                    val = val + y;
                }
                return val + memoriaInstrucao.getAddress();
            default:
                return memoriaInstrucao.getAddress();
        }
    }

}
