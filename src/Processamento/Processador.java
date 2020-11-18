package Processamento;

import Arquivos.Escrita;
import Instrucoes.Instrucoes;
import Instrucoes.TipoIeJ;
import Instrucoes.TipoR;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * simula o procedimento feito por um porcessador MIPS
 */
public class Processador {

    private Instrucoes memoriaInstrucao;
    private Map<String, Long> memoriaDados;
    private Map<Integer, String> mapaInstrucoes;
    private String nomeInstrucao;
    private Map<String, Long> sinaisDeControle;
    private String caminhoDoArquivo;
    private Map<String, Long> registradores;
    private Map<String, Long> saidasRegistrador;
    private LinkedList<Instrucoes> memoria;

    private long aluOut = 0;
    private long aluControl = 0;

    private long indice;

    /**
     *
     * @param pc inicia o processador MIPS
     */
    public Processador(Instrucoes pc, String caminho, LinkedList<Instrucoes> memoria) {
        memoriaInstrucao = new Instrucoes();
        this.memoriaInstrucao = pc;
        caminhoDoArquivo = caminho;
        memoriaInstrucao.atribuiValores();
        this.sinaisDeControle = new HashMap<>();
        if (memoriaInstrucao.getOp() == 0) {
            criaSinaisControleR();
        } else {
            criaSinaisControleIeJ();
        }
        this.registradores = new HashMap<>();
        this.memoriaDados = new HashMap<>();
        this.mapaInstrucoes = new HashMap<>();
        this.saidasRegistrador = new HashMap<>();
        this.memoria = new LinkedList<>();
        this.memoria.addAll(memoria);
    }

    //MÉTODOS GETS
    public String getNomeInstrucao() {
        return this.nomeInstrucao;
    }

    public long getIndice() {
        return this.indice;
    }

    public String getCaminhoDoArquivo() {
        return this.caminhoDoArquivo;
    }

    public Instrucoes getMemoriaInstrucao() {
        return memoriaInstrucao;
    }

    public Map<String, Long> getMemoriaDados() {
        return memoriaDados;
    }

    public Map<Integer, String> getMapaInstrucoes() {
        return mapaInstrucoes;
    }

    public Map<String, Long> getSinaisDeControle() {
        return sinaisDeControle;
    }

    public Map<String, Long> getRegistradores() {
        return registradores;
    }

    public Map<String, Long> getSaidasRegistrador() {
        return saidasRegistrador;
    }

    public long getAluOut() {
        return aluOut;
    }

    public long getAluControl() {
        return aluControl;
    }

    //Processamento    
    public void criaSinaisControleR() {

        sinaisDeControle.put("ALUOp", (long) 2);
        sinaisDeControle.put("ALUSrc", (long) 0);
        sinaisDeControle.put("RegWrite", (long) 1);
        sinaisDeControle.put("RegDst", (long) 1);
        sinaisDeControle.put("MemWrite", (long) 0);
        sinaisDeControle.put("MemToReg", (long) 0);
        sinaisDeControle.put("MemRead", (long) 0);
        sinaisDeControle.put("Jump", (long) 0);
        sinaisDeControle.put("Branch", (long) 0);

    }

    public void criaSinaisControleIeJ() {

        switch ((int) memoriaInstrucao.getOp()) {
            case 8:
                sinaisDeControle.put("ALUOp", (long) 0);
                sinaisDeControle.put("ALUSrc", (long) 1);
                sinaisDeControle.put("RegWrite", (long) 1);
                sinaisDeControle.put("RegDst", (long) 0);
                sinaisDeControle.put("MemWrite", (long) 0);
                sinaisDeControle.put("MemToReg", (long) 0);
                sinaisDeControle.put("MemRead", (long) 0);
                sinaisDeControle.put("Jump", (long) 0);
                sinaisDeControle.put("Branch", (long) 0);
                break;
            case 35:
                sinaisDeControle.put("ALUOp", (long) 0);
                sinaisDeControle.put("ALUSrc", (long) 1);
                sinaisDeControle.put("RegWrite", (long) 1);
                sinaisDeControle.put("RegDst", (long) 0);
                sinaisDeControle.put("MemWrite", (long) 0);
                sinaisDeControle.put("MemToReg", (long) 1);
                sinaisDeControle.put("MemRead", (long) 1);
                sinaisDeControle.put("Jump", (long) 0);
                sinaisDeControle.put("Branch", (long) 0);
                break;
            case 43:
                sinaisDeControle.put("ALUOp", (long) 0);
                sinaisDeControle.put("ALUSrc", (long) 1);
                sinaisDeControle.put("RegWrite", (long) 0);
                sinaisDeControle.put("RegDst", (long) 0);
                sinaisDeControle.put("MemWrite", (long) 1);
                sinaisDeControle.put("MemToReg", (long) 0);
                sinaisDeControle.put("MemRead", (long) 0);
                sinaisDeControle.put("Jump", (long) 0);
                sinaisDeControle.put("Branch", (long) 0);
                break;
            case 4:
                sinaisDeControle.put("ALUOp", (long) 1);
                sinaisDeControle.put("ALUSrc", (long) 0);
                sinaisDeControle.put("RegWrite", (long) 0);
                sinaisDeControle.put("RegDst", (long) 0);
                sinaisDeControle.put("MemWrite", (long) 0);
                sinaisDeControle.put("MemToReg", (long) 0);
                sinaisDeControle.put("MemRead", (long) 0);
                sinaisDeControle.put("Jump", (long) 0);
                sinaisDeControle.put("Branch", (long) 0);
                break;
            case 5:
                sinaisDeControle.put("ALUOp", (long) 1);
                sinaisDeControle.put("ALUSrc", (long) 0);
                sinaisDeControle.put("RegWrite", (long) 0);
                sinaisDeControle.put("RegDst", (long) 0);
                sinaisDeControle.put("MemWrite", (long) 0);
                sinaisDeControle.put("MemToReg", (long) 0);
                sinaisDeControle.put("MemRead", (long) 0);
                sinaisDeControle.put("Jump", (long) 0);
                sinaisDeControle.put("Branch", (long) 0);
                break;
            case 2 | 3:
                sinaisDeControle.put("ALUOp", (long) 0);
                sinaisDeControle.put("ALUSrc", (long) 0);
                sinaisDeControle.put("RegWrite", (long) 0);
                sinaisDeControle.put("RegDst", (long) 0);
                sinaisDeControle.put("MemWrite", (long) 0);
                sinaisDeControle.put("MemToReg", (long) 0);
                sinaisDeControle.put("MemRead", (long) 0);
                sinaisDeControle.put("Jump", (long) 1);
                sinaisDeControle.put("Branch", (long) 0);
                break;
        }
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

    private void setNomeInstrucao() {
        switch ((int) memoriaInstrucao.getOp()) {
            case 0:
                for (Map.Entry<Integer, String> map : mapaInstrucoes.entrySet()) {
                    if (memoriaInstrucao.getFunct() == map.getKey()) {
                        this.nomeInstrucao = map.getValue();
                    }
                }
                break;
            default:
                for (Map.Entry<Integer, String> map : mapaInstrucoes.entrySet()) {
                    if (memoriaInstrucao.getOp() == map.getKey()) {
                        this.nomeInstrucao = map.getValue();
                    }
                }
                break;
        }
    }

    /**
     * @param entrada1 recebe o primeiro valor vindo do registrador ou PC
     * @param entrada2 recebe o segundo valor vindo do registrador
     * @param controleAlu indica qual operacao logica/aritimetica sera realizada
     * @return retorna o resultado da operacao
     */
    private long alu(long entrada1, long entrada2, long controleAlu) {
        TipoR funcoes = new TipoR();
        TipoIeJ funcoesIJ = new TipoIeJ();
        long resultado = 0;
        int zero = (int) funcoes.sub(entrada1, entrada2) + 1;
        switch (zero) {
            case 1:
                return 0;
            default:
                switch ((int) controleAlu) {
                    case 32:
                        resultado = funcoes.add(entrada1, entrada2);
                        break;
                    case 34:
                        resultado = funcoes.sub(entrada1, entrada2);
                        break;
                    case 24:
                        resultado = funcoes.mult(entrada1, entrada2);
                        break;
                    case 26:
                        resultado = funcoes.div(entrada1, entrada2);
                        break;
                    case 36:
                        resultado = funcoes.and(entrada1, entrada2);
                        break;
                    case 37:
                        resultado = funcoes.or(entrada1, entrada2);
                        break;
                    case 42:
                        resultado = funcoes.slt(entrada1, entrada2);
                        break;
                    case 0:
                        resultado = funcoes.sll(entrada1, entrada2);
                        break;
                    case 8:
                        resultado = funcoes.jr(entrada1);
                        break;
                    case 35:
                        resultado = funcoesIJ.lw(entrada1, entrada2);
                        break;
                    case 43:
                        resultado = funcoesIJ.sw(entrada1, entrada2);
                        break;
                    default:
                        break;
                }
                break;
        }
        return resultado;
    }

    private Long memoriaDeDados(long address, long writeData, long memWrite, long memRead) {
        memoriaDados.put("address", address);
        memoriaDados.put("writeData", writeData);
        memoriaDados.put("MemWrite", memWrite);
        memoriaDados.put("MemRead", memRead);

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
     * @param numRegistrador recebe o numero do registrador que vai ser
     * utilizado
     * @param readRegister1 Recebe IR[25:21]
     * @param readRegister2 Recebe IR[20:16]
     * @param writeRegister Recebe IR[15:11]
     * @param writeData
     */
    private void registrador(
            long readRegister1,
            long readRegister2,
            long writeRegister,
            long writeData
    ) {

        long regWrite = sinaisDeControle.get("RegWrite");

        registradores.put("Read register 1", readRegister1);
        registradores.put("Read register 2", readRegister2);
        switch ((int) regWrite) {
            case 1:
                writeRegister = writeData;
                registradores.put("Write register", writeRegister);
                registradores.put("Write Data", writeData);
                break;
            default:
                registradores.put("Write register", (long) 0);
                registradores.put("Write Data", (long) 0);
                break;
        }

        saidasRegistrador.put("Read data 1", readRegister1);
        saidasRegistrador.put("Read data 2", readRegister2);
    }

    /**
     * Se address for positivo soma 0s, se for negativo adiciona 1s
     *
     * @return valor acrescido de 0s ou 1s
     */
    private long singExtend() {
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

    public void resetaProcessador() {
        this.memoriaInstrucao.clear();
        this.sinaisDeControle.clear();
        this.registradores.clear();
        this.memoriaDados.clear();
        this.mapaInstrucoes.clear();
        this.saidasRegistrador.clear();
        this.memoria.clear();
    }

    public int iniciaProcessador(int pc) {
        this.indice = pc;
        Escrita escrita = new Escrita();
        memoriaDeDados(memoriaInstrucao.getValorDecimal(), (long) -1, sinaisDeControle.get("MemWrite"), sinaisDeControle.get("MemRead"));
        if (memoriaInstrucao.getOp() == 0) {
            criaMapR();
            setNomeInstrucao();
            long regDst = sinaisDeControle.get("RegDst");
            switch ((int) regDst) {
                case 0:
                    registrador(
                            memoriaInstrucao.getRs(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getValorDecimal()
                    );
                    break;
                default:
                    registrador(
                            memoriaInstrucao.getRs(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getRd(),
                            memoriaInstrucao.getValorDecimal()
                    );
                    //memoriaInstrucao.setValorDecimal(regDst);
                    break;
            }
            long aluSrc = sinaisDeControle.get("ALUSrc");
            switch ((int) aluSrc) {
                case 0:
                    aluOut = alu(
                            memoriaInstrucao.getValorDecimal(),
                            saidasRegistrador.get("Read data 2"),
                            memoriaInstrucao.getFunct());
                    registrador(
                            memoriaInstrucao.getRs(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getRd(),
                            aluOut);
                    break;
                default:
                    aluOut = alu(
                            saidasRegistrador.get("Read data 1"),
                            saidasRegistrador.get("Read data 2"),
                            memoriaInstrucao.getFunct());
                    break;
            }
        } else {
            criaMapIeJ();
            setNomeInstrucao();
            TipoIeJ funcoes = new TipoIeJ();
            long resultado = 0;
            long regDst = sinaisDeControle.get("RegDst");
            switch ((int) regDst) {
                case 0:
                    registrador(
                            memoriaInstrucao.getRs(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getValorDecimal()
                    );
                    break;
                default:
                    registrador(
                            memoriaInstrucao.getRs(),
                            memoriaInstrucao.getRt(),
                            memoriaInstrucao.getRd(),
                            memoriaInstrucao.getValorDecimal()
                    );
                    //memoriaInstrucao.setValorDecimal(regDst);
                    break;
            }
            switch ((int) memoriaInstrucao.getOp()) {
                case 8:
                    resultado = funcoes.addi(memoriaInstrucao.getRt(), memoriaInstrucao.getAddress());
                    break;
                case 35:
                    resultado = alu(memoriaInstrucao.getAddress(), indice, memoriaInstrucao.getOp());
                    memoriaInstrucao.setRS(resultado);
                    break;
                case 43:
                    resultado = alu(indice, memoriaInstrucao.getAddress(), memoriaInstrucao.getOp());
                    memoria.get((int) indice).setValorDecimal(memoria.get((int) resultado).getValorDecimal());
                    break;
                case 4:
                    resultado = funcoes.beq(memoriaInstrucao.getRs(), memoriaInstrucao.getRt(), memoriaInstrucao.getAddress(), memoriaInstrucao.getValorDecimal());
                    if (resultado == -1) {
                        break;
                    }
                    escrita.Impressao(this);
                    return (int) resultado;
                case 5:
                    resultado = funcoes.bne(memoriaInstrucao.getRs(), memoriaInstrucao.getRt(), memoriaInstrucao.getAddress(), memoriaInstrucao.getValorDecimal());
                    if (resultado == -1) {
                        break;
                    }
                    escrita.Impressao(this);
                    return (int) resultado;
                case 2:
                    resultado = funcoes.jump(memoriaInstrucao.getAddress());
                    if (resultado < 0 || resultado > memoria.size()) {
                        break;
                    }
                    escrita.Impressao(this);
                    return (int) resultado;
                case 3:
                    resultado = funcoes.jal(memoriaInstrucao.getAddress());
                    if (resultado < 0 || resultado > memoria.size()) {
                        break;
                    }
                    escrita.Impressao(this);
                    return (int) resultado;
            }
        }
        escrita.Impressao(this);
        return pc = pc + 1;
    }
}
