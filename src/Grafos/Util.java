package Grafos;

import Interface.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Util {
    
    
    
    public static void inicializa(No[] grafo, int noInicial) {
        for(int i = 0; i < grafo.length; i++) {
            grafo[i].setDistancia(30000);
            grafo[i].setPredecessor(-1);
        }
        grafo[noInicial].setDistancia(0);
        grafo[noInicial].setPredecessor(0);
    }
    
    public static No[] buscaLargura(int noInicial) {
        No[] grafo = new No[Grafo.numVert];
        Queue<No> fila = new LinkedList<>();
        No atual;
        int [][] matriz;
        matriz = Grafo.matriz;
        for (int i = 0; i < grafo.length; i++) {
            grafo[i] = new No(i);
        }
        grafo[noInicial].setCor(Color.gray);
        fila.add(grafo[noInicial]);
        while (!fila.isEmpty()) {
            atual = fila.remove();
            for (int i = 0; i < matriz[atual.getVertID()].length; i++) {
                if (matriz[atual.getVertID()][i] != -1) {
                    No adj = grafo[i];
                    if (adj != null) {
                        if (adj.getCor() == Color.white) {
                            adj.setCor(Color.gray);
                            adj.setDistancia(grafo[atual.getVertID()].getDistancia() + 1);
                            adj.setPredecessor(grafo[atual.getVertID()].getVertID());
                            fila.add(adj);
                        }
                    }
                }
            }
            grafo[atual.getVertID()].setCor(Color.black);
        }
        return grafo;
    }
    
    public static void imprLargura(No[] grafo, int noInicial) {	
        System.out.printf("     Grafo raiz: %d\n\n", noInicial);
        for (int i=0; i<grafo.length; i++) {
            if(grafo[i].getVertID() != noInicial) {
                System.out.printf("     Grafo %d\n     Distância: %d\n     Caminho: [%d] ", 
                        grafo[i].getVertID(),
                        grafo[i].getDistancia(), 
                        grafo[i].getVertID());
                int j = grafo[i].getVertID();
                while(j != noInicial) {
                    j = grafo[j].getPredecessor();
                    if (j == -1) {
                        System.out.printf("<-- null");
                        break;
                    }
                    else System.out.printf("<-- [%d] ", grafo[j].getVertID());              
                }
                System.out.printf("\n\n");
            }
        }
    }
    
    public static void relaxa(No u, No v, int peso) {
        int soma = u.getDistancia() + peso;
        if(v.getDistancia() > soma) {
            v.setDistancia(soma);
            v.setPredecessor(u.getVertID());
        }
    }
    
    public static No[] bellmanFord(int noInicial, boolean cicloNeg) {
        int [][] matriz;
        matriz = Grafo.matriz;
        No[] grafo = new No[matriz.length];
        for(int i = 0; i < grafo.length; i++) {
            grafo[i] = new No(i);
        }
        int cont;
        Util.inicializa(grafo, noInicial);
        for(int i = 1; i <= Grafo.matriz.length-1; i++) {
            for(int j = 0; j < matriz.length; j++) {        /*  para cada  */
                cont = -1;                                  /* aresta(u,v) */
                for(int k = 0; k < matriz[j].length; k++) { /*  do grafo   */
                    if(matriz[j][k] != -1) {
                        cont++;
                        No v = grafo[k];
                        if(v != null) {
                            Util.relaxa(grafo[j], v, matriz[j][k]);
                        }
                    }
                }
            }
        }
        for(int j = 0; j < matriz.length; j++) {        /*  para cada  */
            cont = -1;                                  /* aresta(u,v) */
            for(int k = 0; k < matriz[j].length; k++) { /*  do grafo   */
                if(matriz[j][k] != -1) {
                    cont++;
                    No v = grafo[k];
                    if(v != null) {
                        if(v.getDistancia() > grafo[j].getDistancia() + matriz[j][cont]) {
                            cicloNeg = false;
                        }
                    }
                }
            }
        }
        return grafo;
    }
    
    public static void imprCaminhoBellman(No grafo[], int ini) {
        for (int i = 0; i < grafo.length; i++) {
            System.out.println("");
            if(verifCaminhoBellman(ini, i))
                System.out.println("\n     Distância = " + grafo[i].getDistancia());
        }
    }
    
    public static boolean verifCaminhoBellman(int u, int v) {
        No grafo[];
        boolean cicloNeg = true;
        grafo = bellmanFord(u, cicloNeg);
        int atual = v;
        int caminho[];
        caminho = new int[grafo.length];
        int i;

        for (i = 0; i < grafo.length; i++)
            caminho[i] = -1;
        for (i = 0; atual != u; i++) {
            caminho[i] = atual;
            if (grafo[atual].getPredecessor() != -1)
                atual = grafo[atual].getPredecessor();
            else
                break;
        }
        caminho[i] = atual;
        if (caminho[i] != u){
            System.out.println("     Não existe caminho entre " + u + " e " + v + "!");
            return false;
        }
        else {
            System.out.printf("     ");
            for (; i > 0; i--)
                System.out.printf(caminho[i] + " --> ");
            System.out.printf(caminho[i] + "");
            return true;
        }
    }
    
    public static int[][] transposicao(Graph desenho) {
        int tamanho = Grafo.matriz.length;
        
        int[][] transposta;
        transposta = new int[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                transposta[i][j] = -1;
            }
        }
        ArrayList<Edge> novasArestas = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (Grafo.matriz[i][j] != -1) {
                    transposta[j][i] = Grafo.matriz[i][j];
                    // remove a aresta da representacao
                    Edge aresta = desenho.remEdgeCorrespondente(i, j);
                    // troca o inicio e final da aresta
                    Vertex aux = aresta.getSource();
                    aresta.setSource(aresta.getTarget());
                    aresta.setTarget(aux);
                    // guarda a nova aresta numa lista
                    novasArestas.add(aresta);
                }
            }
        }
        // com todas as novas arestas em maos, elas serao armazenadas novamente na representacao
        int num = novasArestas.size();
        for (int i=0; i<num; i++)
            desenho.addEdge(novasArestas.remove(0));
        return transposta;
    }
    
    public static Queue<No> buscaProfundidade(int noInicial) {
        No[] grafo = new No[Grafo.numVert];
        Queue<No> fila = new LinkedList<>();
        for (int i = 0; i < grafo.length; i++) {
            grafo[i] = new No(i);
        }
        int tempo = 1;
        for (int i = noInicial; i < grafo.length; i++) { // Iniciando pelo no inicial
            if (grafo[i].getCor() == Color.white) {
                tempo = grafo[i].visita(grafo, tempo, fila);
            }
        }
        for (int i = 0; i < noInicial; i++) { // Percorrendo os nos anteriores ao incial
            if (grafo[i].getCor() == Color.white) {
                tempo = grafo[i].visita(grafo, tempo, fila);
            }
        }
        return fila;
    }
    
    public static void ordenacaoTopologica(Queue<No> fila) {
        while(!fila.isEmpty()) {
            System.out.printf(fila.remove().getVertID() + " ");
        }
    }
}
