package Grafos;

import java.util.ArrayList;

public class ComponentesConexas {
    private int numComp;
    private int componentes[] = null;
    
    public void execute(Grafo grafo) {
        componentes = new int[grafo.getNumVert()];
        buscaProfundidade(grafo);
    }

    private void buscaProfundidade(Grafo rep) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i] = -1;
        }
        int idComp = -1;
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] == -1) {
                idComp++;
                visita(rep, i, idComp);
            }
        }
        this.numComp = idComp+1;
    }

    private void visita(Grafo rep, int vert, int idComp) {
        componentes[vert] = idComp;
        ArrayList<No> adj = rep.getAdjacentes(vert);
        for(int i=0;i<adj.size();i++) {
            if (componentes[adj.get(i).getVertID()] == -1) {
                visita(rep, adj.get(i).getVertID(), idComp);
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
