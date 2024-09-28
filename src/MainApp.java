import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private final Cipher cipher;

    public MainApp() {
        this.cipher = new Cipher();
    }

    public int escogerOpcion() {
        System.out.println("Menu");
        System.out.println("1. Encryption");
        System.out.println("2. Decryption with key");
        System.out.println("3. Brute Force");
        System.out.println("0. Exit");
        int opcion;
        Scanner scanner = new Scanner(System.in);
        opcion = scanner.nextInt();
        while (true) {
            if (opcion > 3 || opcion < 0) {
                System.out.println("Numero invalido, intente de nuevo");
                opcion = scanner.nextInt();
            } else break;
        }
        return opcion;
    }

    public void encriptar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la ruta de su archivo .txt:");
        String ruta = scanner.nextLine();
        String text = FileManager.leerArchivo(ruta);
        System.out.println("Por favor ingrese el codigo para el encriptado:");
        int shift = scanner.nextInt();
        String textoEncriptado = cipher.encrypt(text, shift);
        //System.out.println(textoEncriptado);
        FileManager.escribirArchivo(textoEncriptado, "src\\Resources\\TextoEncriptado.txt");
        System.out.println("Encriptado con exito!");
        System.out.println("Ruta:\"src\\Resources\\TextoEncriptado.txt\"");
    }

    public void desencriptar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la ruta de su archivo encriptado .txt:");
        String ruta = scanner.nextLine();
        String text = FileManager.leerArchivo(ruta);
        System.out.println("Por favor ingrese el codigo para el desencriptado:");
        int shift = scanner.nextInt();
        String textoDesencriptado = cipher.decrypt(text, shift);
        //System.out.println(textoDesencriptado);
        FileManager.escribirArchivo(textoDesencriptado, "src\\Resources\\TextoDesencriptado.txt");
        System.out.println("Desencriptado con exito!");
        System.out.println("Ruta: \"src\\Resources\\TextoDesencriptado.txt\"");
    }

    public void bruteForce() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingrese la ruta de su archivo encriptado .txt:");
        String ruta = scanner.nextLine();
        String text = FileManager.leerArchivo(ruta);
        String sample = text.substring(0, Math.min(text.length(), 50));
        System.out.println("A continuacion se muestran todas las combinaciones posibles en un Sample:");
        for (int i = 1; i < 221; i++) {
            String textoDesencriptado = cipher.decrypt(sample, i);
            System.out.println("Clave: " + i);
            System.out.println(textoDesencriptado);
        }
    }
}


