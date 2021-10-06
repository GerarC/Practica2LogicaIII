package models;

import java.util.ArrayList;

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

    //Methods
    public NodoAB retornaAbuelo(){
        if(this.retornaPadre() != null) return this.retornaPadre().retornaPadre();
        else return null;
    }

    public NodoAB retornaTio(){
        NodoAB abuelo, padre;
        padre = this.retornaPadre();
        abuelo = this.retornaAbuelo();

        if(padre != null && abuelo != null){
            if(abuelo.retornaHI() == padre) return abuelo.retornaHD();
            if(abuelo.retornaHD() == padre) return abuelo.retornaHI();
        }
        return null;
    }

    public NodoAB retornaHermano(){
        /*el método retorna al hermano del nodo, si es que tiene*/
        NodoAB padre = this.retornaPadre();
        if(padre != null){
            if(padre.retornaHI() == this) return padre.retornaHD();
            if(padre.retornaHD() == this) return padre.retornaHI();
        }
        return null;
    }

    public ArrayList<NodoAB> RetornaHijos(){
        ArrayList<NodoAB> hijos;
        if(this.retornaHI() == null && this.retornaHD() == null) return null;
        hijos = new ArrayList<>();

        if(this.retornaHI() != null) hijos.add(this.retornaHI());
        if(this.retornaHD() != null) hijos.add(this.retornaHD());

        return hijos;
    }

    public int retornaLado(){
        /*Este método retorna si el nodo es hijo izquierdo o derecho.
        Si el nodo es el hijo izquierdo retorna un 1, si el nodo es el hijo derecho retorna 0 y si el nodo no tiene padre retorna -1*/
        if(this.retornaPadre() != null){
            if(this.retornaPadre().retornaHI() == this) return 1;
            if(this.retornaPadre().retornaHD() == this) return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "NodoAB{" + "dato=" + dato + '}';
    }
}
