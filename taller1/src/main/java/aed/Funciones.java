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
        int res = 0;
        for (int i=0; i < numeros.length; i++) {
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (primo(numeros[i])) {
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (!divideA(2, numeros[i])) {
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i=0; i < s2.length(); i++) {
            if (i < s1.length() && (s1.charAt(i) != s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        // Invertir s2 y luego s1 para ejecutar esPrefijo? gfedcba
        return (esPrefijo(invertirString(s1), invertirString(s2)));
    }
    
    String invertirString(String palabra) {
        String res = "";
        for (int i = palabra.length() -1; i > -1; i--) {
            res += palabra.charAt(i);
        }
        return res;
    }
}
