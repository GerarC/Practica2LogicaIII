package models;

public class Model {
    public static ArbolBinario ArbolInicial;
    public static int Tamaño;

    public Model(ArbolBinario x, int y) {
        ArbolInicial=x;
        Tamaño=y;

    }


    public static ArbolBinario getArbolInicial() {
        return ArbolInicial;
    }

    public static void setArbolInicial(ArbolBinario arbolInicial) {

        ArbolInicial = arbolInicial;
    }

}
