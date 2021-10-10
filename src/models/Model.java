package models;

public class Model {
    public static ArbolBinario ArbolInicial;


    public Model(ArbolBinario x) {
        ArbolInicial=x;

    }


    public static ArbolBinario getArbolInicial() {
        return ArbolInicial;
    }

    public static void setArbolInicial(ArbolBinario arbolInicial) {

        ArbolInicial = arbolInicial;
    }

}
