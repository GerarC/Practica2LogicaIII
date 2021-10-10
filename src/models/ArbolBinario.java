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

    public int gradoAB(NodoAB raiz){
        int g;
        g = 0;
        if(raiz != null){
            if(raiz.retornaHI() != null && raiz.retornaHD() != null){
                g = 2;
            }else {
                if(raiz.retornaHI() != null || raiz.retornaHD() != null){
                    g = 1;
                }
            }
            if (g == 2) return g;
            g = gradoAB(raiz.retornaHI());
            if (g == 2) return g;
            g = gradoAB(raiz.retornaHD());
        }
        return g;
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

    public ArrayList<NodoAB> retornaHojasAB(NodoAB r){
        ArrayList<NodoAB> hojas, hojasI, hojasD;
        if(r == null) return null;
        hojas = new ArrayList<>();
        if(r.retornaHI() == null && r.retornaHD() == null) hojas.add(r);

        hojasI = retornaHojasAB(r.retornaHI());
        hojasD = retornaHojasAB(r.retornaHD());

        if (hojasI != null){
            for(NodoAB nab: hojasI){
                if(nab != null){
                    hojas.add(nab);
                }
            }
        }
        if (hojasD != null){
            for(NodoAB nab: hojasD){
                if(nab != null){
                    hojas.add(nab);
                }
            }
        }

        return hojas;
    }

    //region Métodos para Crear un "Dibujo" del árbol

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
            nodos.append("0");
            return nodos.toString();
        }
        if(nivelActual == 0) return " ";
        if(nivelImprimir == nivelActual) {
            nodos.append(r.retornaDato());
            return nodos.toString();
        }
        if(r.retornaHI() == null){
            NodoAB aux = new NodoAB(" ");
            nodos.append(nodosNivelImprimir(aux, nivelActual + 1,nivelImprimir));
        }else{
            nodos.append(nodosNivelImprimir(r.retornaHI(), nivelActual + 1,nivelImprimir));
        }
        if(r.retornaHD() == null){
            NodoAB aux = new NodoAB(" ");
            nodos.append(nodosNivelImprimir(aux, nivelActual + 1,nivelImprimir));
        }else {
            nodos.append(nodosNivelImprimir(r.retornaHD(), nivelActual + 1,nivelImprimir));
        }

        return nodos.toString();
    }


    public String ArbolString(NodoAB r){
        StringBuilder sb, sbAux;
        String fila, espacioEntre;
        int altura, alturaAux, numeroEspacio;
        sb = new StringBuilder();
        altura = alturaAB(raiz, 1);
        alturaAux = altura;
        if(altura >= 7){
            for(int i = 1; i <= altura; i++){
                numeroEspacio = numeroSecucencia(alturaAux + 1);
                espacioEntre = repiteString(" ", numeroEspacio);
                fila = nodosNivelImprimir(r, 1 , i);
                if(i < altura){
                    fila = String.join(espacioEntre, fila.split(""));
                    fila = ponerEspacios(fila, alturaAux);
                }else{
                    String[] filaChar = fila.split("");
                    sbAux = new StringBuilder();
                    for(int j = 0; j < filaChar.length; j++){
                        sbAux.append(filaChar[j]);
                        sbAux.append("");
                        if(j%2 == 0){
                            sbAux.append(" ");
                        }
                    }
                    fila = sbAux.toString();
                }
                sb.append(fila);
                sb.append("\n");
                alturaAux--;
            }
        }
        else{
            for(int i = 1; i <= altura; i++){
                numeroEspacio = numeroSecucencia(alturaAux + 2);
                espacioEntre = repiteString(" ", numeroEspacio);
                fila = nodosNivelImprimir(r, 1 , i);
                if(i < altura){
                    fila = String.join(espacioEntre, fila.split(""));
                    fila = ponerEspacios(fila, alturaAux  + 1);
                }else{
                    String[] filaChar = fila.split("");
                    sbAux = new StringBuilder();
                    for(int j = 0; j < filaChar.length; j++){
                        sbAux.append(filaChar[j]);
                        sbAux.append(" ");
                        if(j%2 == 0){
                            sbAux.append("  ");
                        }
                    }
                    fila = sbAux.toString();
                }
                sb.append(fila);
                sb.append("\n");
                alturaAux--;
            }
        }

        return sb.toString();
    }
    //endregion

}
