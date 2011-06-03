/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dojoarvorebmais;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author vanessa
 * Esta classe representa os metadados da árvore B+
 */
public class Metadados {
    public static int TAMANHO = 4 + 1;
    //ponteiro para a raiz da arvore
    public int pontRaiz;
    //flag que diz se a raiz eh uma folha (nesse caso ela esta no arquivo de dados)
    public boolean raizFolha;

    /*
     * Construtor dos Metadados 
     */
    public Metadados() {
        this.pontRaiz = 0;
        this.raizFolha = true;
    }

    public Metadados(int pontRaiz, boolean raizFolha) {
        this.pontRaiz = pontRaiz;
        this.raizFolha = raizFolha;
    }

    /*
     * Grava os metadados no arquivo em disco 
     */
    public void salva(RandomAccessFile out) throws IOException {
        out.writeInt(pontRaiz);
        out.writeBoolean(raizFolha);
    }

    /*
     * Le os metadados do disco
     */
    public static Metadados le(RandomAccessFile in) throws IOException {
        Metadados m = new Metadados();
        m.pontRaiz = in.readInt();
        m.raizFolha = in.readBoolean();
        
        return m;
    }
}
