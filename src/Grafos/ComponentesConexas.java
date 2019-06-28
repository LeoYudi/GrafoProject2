package Grafos;

import java.util.ArrayList;

public class ComponentesConexas {
    private int numComp;
    private int componentes[] = null;
    
    public void execute() {
        componentes = new int[Grafo.numVert];
        buscaProfundidade();
    }

    private void buscaProfundidade() {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i] = -1;
        }
        int idComp = -1;
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] == -1) {
                idComp++;
                visita(i, idComp);
            }
        }
        this.numComp = idComp+1;
    }

    private void visita(int vert, int idComp) {
        componentes[vert] = idComp;
        ArrayList<No> adj = Grafo.vertices[vert].getAdjacentes();
        for(int i=0;i<adj.size();i++) {
            if (componentes[adj.get(i).getVertID()] == -1) {
                visita(adj.get(i).getVertID(), idComp);
            }
        }
    }

    public int getNumComponentes(){        
        return numComp;
    }

    public int[] getComponentes() {
        return componentes;
    }    
}
