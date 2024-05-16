package examen_1_carlosflores;

import java.util.ArrayList;
import java.util.Arrays;

public class Examen_1_CarlosFlores {

    public static double calcularDuracion(long startTime) {
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e6;
    }

    public static double sumaDePrimosUsandoFunciones() {
        long startTime = System.nanoTime();
        int[] matrizEnteros = {1, 5, 10}; // [0, 10, 17]
        //int[] matrizEnteros = {5, 50, 500}; // [10, 328, 21536]
        //int[] matrizEnteros = {10, 100, 1000}; // [17, 1060, 767127]
        //int[] matrizEnteros = {1000, 10000, 100000}; // [76127, 5736396, 454396537]
        ArrayList<Integer> sumaPrimos = new ArrayList<Integer>();
        System.out.println("LA SUMA DE NUMEROS PRIMOS USANDO FUNCIONES:");
        System.out.println("  DE LA MATRIZ: " + Arrays.toString(matrizEnteros));
        System.out.println("  RESULTADO 1 = " + sumarPrimosEnArreglo(matrizEnteros));
        System.out.println("  RESULTADO 2 = " + sumarPrimosEnArregloYGenerarLista(matrizEnteros, sumaPrimos) + " " + sumaPrimos);
        double duracion = calcularDuracion(startTime);
        System.out.println("     DURACION = " + duracion + " ms\n");
        return duracion;
    }

    public static double sumaDePrimosUsandoRecursividad() {
        long startTime = System.nanoTime();
        int[] matrizEnteros = {1, 5, 10}; // [0, 10, 17]
        //int[] matrizEnteros = {5, 50, 500}; // [10, 328, 21536]
        //int[] matrizEnteros = {10, 100, 1000}; // [17, 1060, 767127]
        //int[] matrizEnteros = {1000, 10000, 100000}; // FUNCIONES WINS -> FATALITY! => StackOverflowError!
        ArrayList<Integer> sumaPrimos = new ArrayList<Integer>();
        System.out.println("LA SUMA DE NUMEROS PRIMOS USANDO RECURSIVIDAD:");
        System.out.println("  DE LA MATRIZ: " + Arrays.toString(matrizEnteros));
        //System.out.println("  RESULTADO 1 = " + sumarPrimosEnArregloRecursiva(matrizEnteros, 0));
        //System.out.println("  RESULTADO 2 = " + sumarPrimosEnArregloYGenerarListaRecursiva(matrizEnteros, 0, sumaPrimos) + " " + sumaPrimos);
        double duracion = calcularDuracion(startTime);
        System.out.println("     DURACION = " + duracion + " ms\n");
        return duracion;
    }

    public static void main(String[] args) {
        String quien = "RECURSIVAS";
        double duracionFunciones = sumaDePrimosUsandoFunciones();
        double duracionRecursivas = sumaDePrimosUsandoRecursividad();
        if (duracionFunciones < duracionRecursivas)
            quien = "FUNCIONES";
        System.out.println(quien + " WINS!");
    }
    
    public static boolean esPrimo(int numero){
        boolean check = false;
        int contDivisores = 0;
        for (int i = 2; i <= numero; i++) {
            if(numero % i == 0){
                contDivisores++;
            }
        }
        if(contDivisores == 1){
            check = true;
        }
        return check;
    }
    
    public static boolean esPrimoRecursiva(int numero, int indx, int contDivisores){
        boolean check = false;
        if(numero % indx == 0){
            contDivisores++;
        }
        indx++;
        if(indx <= numero){
            esPrimoRecursiva(numero, indx, contDivisores);
        }
        if(contDivisores == 1){
            check = true;
        }
        return check;
    }
    
    public static int sumarPrimos(int numero){
        int result = 0;
        for (int i = 2; i <= numero; i++) {
            if(esPrimo(i)){
                result = result + i;
            }
        }
        return result;
    }
    //NO LOGRE LA RECURSIVA :(
    public static int sumarPrimosRecursiva(int numero, int indx, int result){
        if(esPrimoRecursiva(numero, indx, 0)){
            result += indx;
        }
        indx++;
        if(indx <= numero){
            sumarPrimosRecursiva(numero, indx, result);
        }
        return result;
    }
    
    public static int sumarPrimosEnArreglo(int [] arreglo){
        int result = 0;
        for (int elementoActual : arreglo) {
            result = result + sumarPrimos(elementoActual);
        }
        return result;
    }
    
    //NO LOGRE LA RECURSIVA :(
    public static int sumarPrimosEnArregloRecursiva(int [] arreglo,int indice){
        int result = 0;
        result += sumarPrimosRecursiva(arreglo[indice],2, result);
        indice++;
        if(indice < arreglo.length){
            sumarPrimosEnArregloRecursiva(arreglo,indice);
        }
        return result;
    }
    
    public static String sumarPrimosEnArregloYGenerarLista(int [] arreglo, ArrayList<Integer> lista){
        for (int i = 0; i < arreglo.length; i++) {
            lista.add(sumarPrimos(arreglo[i]));
        }
        return Integer.toString(sumarPrimosEnArreglo(arreglo));
    }
    
}
