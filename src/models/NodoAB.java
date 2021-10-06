package models;

public class NodoAB {

    //Attribute
    private NodoAB padre;
    private NodoAB hijoIzquierdo;
    private NodoAB hijoDerecho;
    private Object dato;

    //Constructor
    public NodoAB(Object d){
        this.dato = d;
        padre = null;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    //Getters && Setters
    public NodoAB retornaPadre() {
        return padre;
    }

    public void asignaPadre(NodoAB padre) {
        this.padre = padre;
    }

    public NodoAB retornaHI() {
        return hijoIzquierdo;
    }

    public void asignaHI(NodoAB hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoAB retornaHD() {
        return hijoDerecho;
    }

    public void asignaHD(NodoAB hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public Object retornaDato() {
        return dato;
    }

    public void asignaDato(Object dato) {
        this.dato = dato;
    }

    public NodoAB retornaAbuelo(){
        if(this.retornaPadre() != null){
            return this.retornaPadre().retornaPadre();
        }else {
            return null;
        }
    }
}
