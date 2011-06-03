/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dojoarvorebmais;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArvoreBMais {

    //Metadados da árvore B+
    //dizem se o nó raiz é uma folha ou nào, e contém o ponteiro para o nó folha
    /**
     * Cria uma arvore B+ mais vazia de ordem 2
     * Ponteiros NULL devem ter valor -1
     * @param nomeArquivoIndice nome do arquivo de indice a ser criado (que contera a arvore B+)
     * @param nomeArquivoDados nome do arquivo de dados a ser criado (que contera as folhas da arvore B+)     
     */
    public void criaArvoreBMais(String nomeArquivoIndice, String nomeArquivoDados) throws IOException {
        RandomAccessFile arqIndice = null;
        RandomAccessFile arqDados = null;
        try {
            arqIndice = new RandomAccessFile(new File(nomeArquivoIndice), "rw");
            arqDados = new RandomAccessFile(new File(nomeArquivoDados), "rw");
            Metadados tabMetadados = new Metadados();
            tabMetadados.salva(arqIndice);
            NoFolha tabDados = new NoFolha();
            tabDados.salva(arqDados);

        }finally{
            if (arqIndice != null){
                arqIndice.close();
            }
            if (arqDados != null){
                arqDados.close();
            }
        }
    }

    /**
     * Executa busca em Arquivos utilizando Arvore B+ como indice
     * Assumir que ponteiro para próximo nó é igual a -1 quando não houver próximo nó
     * @param codCli: chave do cliente que está sendo buscado
     * @param nomeArquivoIndice nome do arquivo de indice a ser criado (que contera a arvore B+)
     * @param nomeArquivoDados nome do arquivo de dados a ser criado (que contera as folhas da arvore B+)
     * @return uma instancia de ResultBusca, preenchida da seguinte forma:
     * Caso a chave codCli seja encontrada:
    encontrou = true
    pontFolha aponta para a página folha que contém a chave
    pos aponta para a posição em que a chave se encontra dentro da página

    Caso a chave codCli não seja encontrada:
    encontrou = false
    pontFolha aponta para a última página folha examinada
    pos informa a posição, nessa página, onde a chave deveria estar inserida
     */
    public ResultBusca busca(int codCli, String nomeArquivoIndice, String nomeArquivoDados) throws Exception {
        //TODO: Inserir aqui o código do algoritmo
        RandomAccessFile arqIndice = null;
        RandomAccessFile arqDados = null;
        try {
            arqIndice = new RandomAccessFile(new File(nomeArquivoIndice), "r");
            arqDados = new RandomAccessFile(new File(nomeArquivoDados), "r");
            Metadados tabMetadados = null;
            Metadados m = tabMetadados.le(arqIndice);
            NoFolha tabDados = null;
            NoFolha f = tabDados.le(arqDados);
            f.equals(codCli);
            int i = f.m;
            
        }finally{
            if (arqIndice != null){
                arqIndice.close();
            }
            if (arqDados != null){
                arqDados.close();
            }
        }
        ResultBusca result = new ResultBusca(Integer.MAX_VALUE, Integer.MAX_VALUE, false);
        return result;
    }

    /**
     * Executa inserção em Arquivos Indexados por Arvore B+
     * @param codCli: código do cliente a ser inserido
     * @param nomeCli: nome do Cliente a ser inserido
     * @param nomeArquivoIndice nome do arquivo de indice a ser criado (que contera a arvore B+)
     * @param nomeArquivoDados nome do arquivo de dados a ser criado (que contera as folhas da arvore B+)
     * @return endereço da folha onde o cliente foi inserido, -1 se não conseguiu inserir
     */
    public int insere(int codCli, String nomeCli, String nomeArquivoIndice, String nomeArquivoDados) throws Exception {
        //TODO: Inserir aqui o código do algoritmo de inserção        
        return Integer.MAX_VALUE;

    }

    /**
     * Executa exclusão em Arquivos Indexados por Arvores B+
     * @param codCli: chave do cliente a ser excluído
     * @param nomeArquivoIndice nome do arquivo de indice a ser criado (que contera a arvore B+)
     * @param nomeArquivoDados nome do arquivo de dados a ser criado (que contera as folhas da arvore B+)
     * @return endereço do cliente que foi excluído, -1 se cliente não existe
     */
    public int exclui(int CodCli, String nomeArquivoHash, String nomeArquivoDados) {
        //TODO: Inserir aqui o código do algoritmo de remoção
        return Integer.MAX_VALUE;
    }
}
