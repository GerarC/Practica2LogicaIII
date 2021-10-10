import models.ArbolBinario;
import models.NodoAB;

import java.util.ArrayList;

public class Pruebas {

    public static void main(String[] args){
        ArrayList<NodoAB> ancestros, hijos, hojas;
        NodoAB tio, hermano;
        String arbolString, nodosString;
        ArbolBinario ab;
        nodosString = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        ab = ArbolBinario.crearArbolAleatorio(6, nodosString); /*"ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"*/
        System.out.println(ab.ArbolString(ab.retornaRaiz()));
        System.out.println(ab.preordenString(ab.retornaRaiz()));


        arbolString = "(H(K(N),U(R(S(P,J),N(J,A)),O(,S(N,Ñ)))))";



        ab.construyeAB(arbolString);
        System.out.println(arbolString);
        System.out.println(ab.preordenString(ab.retornaRaiz()));
        System.out.println(ab.ArbolString(ab.retornaRaiz()));


        arbolString = "(A(B(,V(6(,T(H,B)),Y)),F(V,L))";
        ab.construyeAB(arbolString);
        System.out.println(ab.ArbolString(ab.retornaRaiz()));
        System.out.println(ab.preordenString(ab.retornaRaiz()));


        ancestros = ab.ancestrosDelNodo(ab.retornaRaiz().retornaHI().retornaHD().retornaHD());
        System.out.println("\nAncestros = " + ancestros);
        for(NodoAB nab: ancestros){
            System.out.println(nab);
        }

        hijos = ab.retornaRaiz().retornaHI().retornaHD().retornaHI().retornaHD().RetornaHijos();
        System.out.println("\nHijos = " + hijos);
        System.out.println(ab.retornaRaiz().retornaHI().retornaHD().retornaHI().retornaHD());
        for(NodoAB nab: hijos){
            System.out.println(nab);
        }

        tio = ab.retornaRaiz().retornaHD().retornaHI().retornaTio();
        System.out.println("\nTio = " + tio);
        System.out.println(ab.retornaRaiz().retornaHD().retornaHI());
        System.out.println(tio.retornaLado());


        hermano = ab.retornaRaiz().retornaHD().retornaHI().retornaHermano();
        System.out.println("\nHermano = " + hermano);
        System.out.println(ab.retornaRaiz().retornaHD().retornaHI());
        System.out.println(hermano.retornaLado());

        System.out.println("\nGrado = " + ab.gradoAB(ab.retornaRaiz()));

        System.out.println("\nHojas = " +ab.retornaHojasAB(ab.retornaRaiz()));
    }


}
