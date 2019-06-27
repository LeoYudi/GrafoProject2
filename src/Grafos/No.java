package Grafos;

import java.awt.Color;

public class No {
    private int vertID;
    private Color cor;
    private int distancia;
    private int predecessor;

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

}