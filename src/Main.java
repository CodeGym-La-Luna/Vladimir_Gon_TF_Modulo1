import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainApp main = new MainApp();
        int opcion = main.escogerOpcion();
        while (opcion != 0) {
            switch (opcion) {
                //Cifrado del archivo
                case 1: {
                    main.encriptar();
                    break;
                }
                //Descifrado del archivo
                case 2: {
                    main.desencriptar();
                    break;
                }
                //Descifrado por fuerza bruta
                case 3:
                    main.bruteForce();
            }
            opcion = main.escogerOpcion();
        }

    }
}