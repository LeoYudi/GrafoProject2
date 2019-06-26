package Grafos;

import java.awt.Color;

public class No {
    private int vertID;
    private Color cor;

    public No(int vertID) {
        this.vertID = vertID;
        this.cor = Color.white;
    }

    public int getVertID() {
        return vertID;
    }

    public void setVertID(int vertID) {
        this.vertID = vertID;
    }

}