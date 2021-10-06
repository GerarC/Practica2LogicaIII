import models.ArbolBinario;

public class Pruebas {

    public static void main(String[] args){
        String arbolString, nodosString;
        ArbolBinario ab;
        arbolString = "(A(B(,V(6(,T(H,B)),Y)),F(V,F))";
        nodosString = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        ab = ArbolBinario.crearArbolAleatorio(5, nodosString);/*"ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"*/
        ab.dibujaArbol(ab.retornaRaiz());
        System.out.println(ab.preordenString(ab.retornaRaiz()));



        ab.construyeAB(arbolString);
        System.out.println(arbolString);
        System.out.println(ab.preordenString(ab.retornaRaiz()));


    }


}
