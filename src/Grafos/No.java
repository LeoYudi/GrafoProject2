package Grafos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Queue;

public class No {
    private int vertID;
    private Color cor;
    private int distancia;
    private int predecessor;
    private int tempoChegada;
    private int tempoFim;

    public No(int vertID) {
        this.vertID = vertID;
        this.cor = Color.white;
        this.distancia = -1;
        this.predecessor = -1;
    }

    public int getVertID() {
        return vertID;
    }

    public void setVertID(int vertID) {
        this.vertID = vertID;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(int predecessor) {
        this.predecessor = predecessor;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getTempoFim() {
        return tempoFim;
    }

    public void setTempoFim(int tempoFim) {
        this.tempoFim = tempoFim;
    }    
    
    public ArrayList getAdjacentes(){
        ArrayList<No> adj = new ArrayList<>();
        for(int i=0; i<Grafo.matriz.length;i++) {
            if(Grafo.matriz[this.vertID][i] != -1)
                adj.add(new No(i));
        }
        return adj;
    }
    
    public int visita(No grafo[], int tempo, Queue<No> fila){
        this.setCor(Color.gray);
        this.setTempoChegada(tempo++);
        for (int i = 0; i < Grafo.matriz.length; i++) {
            if (Grafo.matriz[this.getVertID()][i] != -1) {
                if (grafo[i].getCor() == Color.black) {
                    grafo[i].setPredecessor(this.getVertID());
                    tempo = grafo[i].visita(grafo, tempo, fila);
                }
            }
        }
        this.setCor(Color.black);
        this.setTempoFim(tempo++);
        fila.add(this);
        return tempo;
    }

}