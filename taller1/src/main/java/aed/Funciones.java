package aed;
import java.lang.Math;
class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        return Math.sqrt((x*x)+(y*y));
    }

    boolean esPar(int n) {
        return divideA(2,n);
    }

    boolean divideA(int d, int n) {
        return (n % d == 0);
    }

    boolean esBisiesto(int n) {
        return ((divideA(4,n) && !divideA(100, n)) || divideA(400, n));
    }

    int factorialIterativo(int n) {
        int res = 1;
        while (n != 0) {
            res *= n;
            n -= 1;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n != 0) {
            return factorialRecursivo(n-1)*n;
        }
        return res;
    }

    boolean esPrimo(int n) {
        return primo(n);
    }

    boolean primo(int n) {
        int contador = 0;
        for (int i=1; i <= n; i++) {
            if (divideA(i,n)) {
                contador += 1;
            }
        }
        return contador == 2;
    }
    
    int sumatoria(int[] numeros) {
        // COMPLETAR
        return 0;
    }

    int busqueda(int[] numeros, int buscado) {
        // COMPLETAR
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        // COMPLETAR
        return false;
    }

    boolean todosPares(int[] numeros) {
        // COMPLETAR
        return false;
    }

    boolean esPrefijo(String s1, String s2) {
        // COMPLETAR
        return false;
    }

    boolean esSufijo(String s1, String s2) {
        // COMPLETAR
        return false;
    }
}
