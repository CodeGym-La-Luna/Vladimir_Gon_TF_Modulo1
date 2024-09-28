import java.util.ArrayList;

public class Cipher {
    private static ArrayList<Character> alfabeto;

    public Cipher() {
        cargarAlfabeto();
    }


    private void cargarAlfabeto(){
        //Creamos nuestro alfabeto con los caracteres imprimibles del codigo ASCII extendido
        //Al cargar omitimos el caracter 127 DEL (Suprimir)
        ArrayList<Character> alfabeto = new ArrayList<>(221);
        for (int i = 32; i < 254; i++) {
            if (i != 127){
                alfabeto.add((char) (i));
            }
        }
        Cipher.alfabeto = alfabeto;
    }

    public String encrypt(String text, int shift) {
        StringBuilder textoEncriptado = new StringBuilder("");
        char actualChar;
        char newChar;
        for (int i = 0; i < text.length(); i++) {
            actualChar = text.charAt(i);
            newChar = getNewCharForEncrypt(actualChar, shift);
            textoEncriptado.append(newChar);
        }
        return textoEncriptado.toString();
    }

    private char getNewCharForEncrypt(char actualChar, int shift) {
        char newChar;
        int indiceActual = alfabeto.indexOf(actualChar);
        int nuevoIndice = indiceActual + shift % alfabeto.size();
        if (nuevoIndice > alfabeto.size()-1) {
            nuevoIndice -= alfabeto.size();
        }
        newChar = alfabeto.get(nuevoIndice);
        return newChar;
    }

    public String decrypt(String encryptedText, int shift) {
        StringBuilder textoDesencriptado = new StringBuilder("");
        char actualChar;
        char newChar;
        for (int i = 0; i < encryptedText.length(); i++) {
            actualChar = encryptedText.charAt(i);
            newChar = getNewCharForDecrypt(actualChar, shift);
            textoDesencriptado.append(newChar);
        }
        return textoDesencriptado.toString();
    }

    private char getNewCharForDecrypt(char actualChar, int shift) {
        int newChar;
        int indiceActual = alfabeto.indexOf(actualChar);
        int nuevoIndice = indiceActual - shift % alfabeto.size();
        if (nuevoIndice < 0) {
            nuevoIndice += alfabeto.size();
        }
        newChar = alfabeto.get(nuevoIndice);
        return (char) newChar;
    }
}