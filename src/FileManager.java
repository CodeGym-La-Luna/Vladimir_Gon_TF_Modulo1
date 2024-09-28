import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {

    public static String leerArchivo(String ruta) {
        Path rutaArchivo = Path.of(ruta);
        try (FileChannel channel = FileChannel.open(rutaArchivo, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            int bytesLeidos;
            while ((bytesLeidos = channel.read(buffer)) > 0) {
                buffer.flip();
                byte[] bytes = new byte[bytesLeidos];
                buffer.get(bytes);
                String texto = new String(bytes);
                buffer.clear();
                return texto;
            }
        } catch (IOException e) {

        }
        return null;
    }

    public static void escribirArchivo(String textoEncriptado, String ruta) {
        Path rutaArchivo = Path.of(ruta);
        if (Files.exists(rutaArchivo)) {
            try {
                Files.delete(rutaArchivo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.createFile(rutaArchivo);
        } catch (IOException e) {

        }
        try (FileChannel channel = FileChannel.open(rutaArchivo, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.wrap(textoEncriptado.getBytes());
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {

        }
    }

    public static String leerArchivoEncriptado(String ruta) {
        Path rutaArchivo = Path.of(ruta);
        try (FileChannel channel = FileChannel.open(rutaArchivo, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesLeidos;
            while ((bytesLeidos = channel.read(buffer)) > 0) {
                buffer.flip();
                byte[] bytes = new byte[bytesLeidos];
                buffer.get(bytes);
                String texto = new String(bytes);
                buffer.clear();
                return texto;
            }
        } catch (IOException e) {

        }
        return null;
    }

    public static void escribirArchivoDesencriptado(String textoDesencriptado, String ruta) {
        Path rutaArchivo = Path.of(ruta);
        if (Files.exists(rutaArchivo)) {
            try {
                Files.delete(rutaArchivo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.createFile(rutaArchivo);
        } catch (IOException e) {

        }
        try (FileChannel channel = FileChannel.open(rutaArchivo, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.wrap(textoDesencriptado.getBytes());
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {

        }
    }
}
