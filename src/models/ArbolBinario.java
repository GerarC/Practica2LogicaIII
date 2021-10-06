package models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class ArbolBinario {

    //Attributes
    private NodoAB raiz;

    //Constructor
    public ArbolBinario(){
        raiz = null;
    }

    //Getters and Setter
    public NodoAB retornaRaiz() {
        return raiz;
    }
    public void asignaRaiz(NodoAB raiz) {
        this.raiz = raiz;
    }


    //Methods
    public void inorden(NodoAB r){
        if(r != null){
            inorden(r.retornaHI());
            System.out.print(r.retornaDato());
            inorden(r.retornaHD());
        }
    }

    public void preorden(NodoAB r){
        if(r != null){
            System.out.print(r.retornaDato());
            preorden(r.retornaHI());
            preorden(r.retornaHD());
        }
    }

    public void posorden(NodoAB r){
        if(r != null){
            posorden(r.retornaHI());
            posorden(r.retornaHD());
            System.out.print(r.retornaDato());
        }
    }

    public void construyeAB(String s) {
        Stack<NodoAB> pila = new Stack<>();
        NodoAB x, ultimo, padre;
        x = new NodoAB(null);
        this.asignaRaiz(x);
        if(s == null){
            return;
        }
        ultimo = x;
        padre = ultimo;
        int n = s.length();
        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    pila.push(ultimo);
                    padre = ultimo;
                    x = new NodoAB(null);
                    x.asignaPadre(padre);
                    c = s.charAt(i + 1);
                    if(c == ','){
                        padre.asignaHD(x);
                        i++;
                    }else{
                        padre.asignaHI(x);
                    }

                    ultimo = x;
                    break;
                case ',':
                    if(!(x.retornaDato() == null)){
                    x = new NodoAB(null);
                    }
                    x.asignaPadre(padre);
                    padre.asignaHD(x);
                    ultimo = x;
                    break;
                case ')':
                    ultimo = pila.pop();
                    if(ultimo.retornaPadre() != null){
                        padre = ultimo.retornaPadre();
                    }
                    else{
                        padre = ultimo;
                    }
                    break;
                default:
                    try{
                        int aux = Integer.parseInt(String.valueOf(c));
                        ultimo.asignaDato(aux);
                    }catch (Exception e){
                        ultimo.asignaDato(c);
                    }
                    break;
            }
        }
    }

    public int hojasAB(NodoAB r){
        int hojas;
        if(r == null) return 0;
        if(r.retornaHI() == null && r.retornaHD() == null) return 1;
        hojas = 0;
        hojas += hojasAB(r.retornaHI());
        hojas += hojasAB(r.retornaHD());
       return hojas;
    }

    public int alturaAB(NodoAB r, int nivel){
        int altura, alturaI, alturaD;
        if(r == null) return 0;
        if(r.retornaHI() == null && r.retornaHD() == null) return nivel;
        altura = 1;
        alturaI = alturaAB(r.retornaHI(), nivel + 1);
        alturaD = alturaAB(r.retornaHD(), nivel + 1);
        if(altura < nivel){
            altura = nivel + 1;
        }
        if(altura <= alturaI){
            altura = alturaI;
        }
        if(altura <= alturaD){
            altura = alturaD;
        }
        return altura;
    }

    public String nodosNivel(NodoAB raiz, int nivelActual, int nivelImprimir){
        StringBuilder nodos = new StringBuilder();
        if(raiz == null) return "";
        if(nivelActual == 0) return "";
        if(nivelImprimir == nivelActual) return raiz.retornaDato().toString();
        nodos.append(nodosNivel(raiz.retornaHI(), nivelActual + 1, nivelImprimir));
        nodos.append(nodosNivel(raiz.retornaHD(), nivelActual + 1, nivelImprimir));
        return nodos.toString();
    }

    public void printPreorden(NodoAB r){
        if(r != null){
            if (r.retornaHI() == null && r.retornaHD() == null) {
                return;
            }
            if(r.retornaPadre() == null || r.retornaPadre().retornaHD() != r) System.out.println("(");
            System.out.println(r.retornaDato());
            if (r.retornaHI() != null){
                System.out.println(preordenString(r.retornaHI()));
            }
            if(r.retornaHD() != null){
                if(r.retornaHI() == null) System.out.println("(");
                System.out.println(",");
                System.out.println(preordenString(r.retornaHD()));
            }
            if( r.retornaPadre() == null || r.retornaPadre().retornaHD() == null || r.retornaPadre().retornaHD() == r) System.out.println(")");
        }
    }

    public String preordenString(NodoAB r){
        StringBuilder sb = new StringBuilder();
        if(r != null){
            if(r.retornaPadre() == null || r.retornaPadre().retornaHD() != r) sb.append("(");
            sb.append(r.retornaDato());
            if (r.retornaHI() != null){
                sb.append(preordenString(r.retornaHI()));
            }
            if(r.retornaHD() != null){
                if(r.retornaHI() == null) sb.append("(");
                sb.append(",");
                sb.append(preordenString(r.retornaHD()));
            }
            if( r.retornaPadre() == null || r.retornaPadre().retornaHD() == null || r.retornaPadre().retornaHD() == r) sb.append(")");
        }
        return sb.toString();
    }

    //region Métodos para Crear un "Dibujo" del árbol

    private String creaStringConector(int altura){
        //Crea un String conector de nodos
        String s;
        if (altura == 0) return this.repiteString(" ", this.numeroSecucencia(altura));
        s = "╔";
        s = s + this.repiteString("═", this.numeroSecucencia(altura));
        s += "╩";
        s = s + this.repiteString("═", this.numeroSecucencia(altura));
        s = s + "╗";
        return s;
    }

    private String ponerEspacios(String str, int altura){
        //Pone los espacios necesesarios para separar nodos o conectores a determinada altura
        String espacio = this.repiteString(" ", this.numeroSecucencia(altura));
        str = espacio + str;
        str = str + espacio;
        return str;
    }

    private String repiteString(String str, int veces){
        //Como el nombre lo dice, repite un string n veces
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= veces; i++){
            sb.append(str);
        }
        return sb.toString();
    }

    private int numeroSecucencia(int x){
        //Calcula el número de la secuencia para determinada altura
        int n;
        if(x <= 1) return 0;
        else if(x == 2) return 1;
        n = 2;
        for(int i = 3; i < x; i++){
            n = (n*2)+1;
        }
        return n;
    }

    public String nodosNivelImprimir(NodoAB r, int nivelActual, int nivelImprimir){
        StringBuilder nodos =  new StringBuilder();
        if(r == null) {
            nodos.append(" ");
            return nodos.toString();
        }
        if(nivelActual == 0) return "";
        if(nivelImprimir == nivelActual) {
            nodos.append(r.retornaDato());
            return nodos.toString();
        }
        nodos.append(nodosNivelImprimir(r.retornaHI(), nivelActual + 1,nivelImprimir));
        nodos.append(nodosNivelImprimir(r.retornaHD(), nivelActual + 1,nivelImprimir));
        return nodos.toString();
    }

    public void dibujaArbol(NodoAB r){
        StringBuilder sb = new StringBuilder();
        String fila, espacioEntre, espacioFuera;
        int altura, alturaAux, numeroEspacio;
        altura = alturaAB(raiz, 1);
        alturaAux = altura + 2;
        for(int i = 1; i <= altura; i++){
            //if(i < altura){
                numeroEspacio = numeroSecucencia(alturaAux);
                espacioEntre = repiteString(" ", numeroEspacio);
                fila = nodosNivelImprimir(r, 1 , i);
                fila = String.join(espacioEntre, fila.split(""));
                fila = ponerEspacios(fila, alturaAux - 1);
                numeroEspacio = numeroSecucencia(alturaAux - 1);
                espacioFuera = repiteString(" ", numeroEspacio);
                System.out.println(fila);
                System.out.println(ponerEspacios(creaStringConector(altura + 1 -i) + espacioFuera + creaStringConector(altura + 1 -i) , altura + 1 - i) );
            //}else{

           // }
            alturaAux--;
        }
    }

    //endregion

    public NodoAB crearArbolRecursivamente(int n, String nodos){
        /*Este método crea aleatoria y recursivamente un arbol con la altura dada, y además,
        los caracteres de los nodos serán definidos por un String*/
        NodoAB raiz, hi, hd;
        int i;
        Random r;
        if(n <= 0){                                                       //El if hace que el método retorne nulo si se pasa de la altura buscada
            return null;
        }
        r = new Random();
        i = r.nextInt(nodos.length() + nodos.length() / 4);            //Hace un número pseudoaleatorio que será el que decida si el nodo existe o no, además de elegir también el átomo
        if(i < nodos.length()){                                          //Si i está en el rango del tamaño del String le pondrá como dato al nodo el caracter en la posición i, si no, entonces retornará null
            raiz = new NodoAB(nodos.charAt(i));
        }else{
            return null;
        }
        hi = crearArbolRecursivamente(n - 1, nodos);                   //Crea la raiz de lo que será el sub arbol izquierdo
        hd = crearArbolRecursivamente(n - 1, nodos);                   //Crea la raiz de lo que será el sub arbol derecho
        if(hi != null) {
            hi.asignaPadre(raiz);
        }
        if(hd != null) {
            hd.asignaPadre(raiz);
        }
        raiz.asignaHI(hi);
        raiz.asignaHD(hd);
        return raiz;
    }

    public static ArbolBinario crearArbolAleatorio(int n, String nodos){
       ArbolBinario ab;
       NodoAB raiz;

       ab = new ArbolBinario();
       do{
           raiz = ab.crearArbolRecursivamente(n, nodos);
       }while (raiz == null);

       ab.asignaRaiz(raiz);

       return ab;
    }

    public ArrayList<NodoAB> ancestrosDelNodo(NodoAB r){
        ArrayList<NodoAB> ancestros, aux;
        if (r != null){
            ancestros = new ArrayList<>();
            aux = null;
        }else {
            return null;
        }
        if(r.retornaPadre() != null){
            ancestros.add(r.retornaPadre());
            aux = ancestrosDelNodo(r.retornaPadre());
        }
        if (aux != null){
            for(NodoAB nab: aux){
                if(nab != null){
                    ancestros.add(nab);
                }
            }
        }
        return ancestros;
    }


}