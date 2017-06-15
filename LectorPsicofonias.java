import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorPsicofonias {

  public void escaneaArchivo(String rutaPortadora, String rutaDiccionario) {
    String[] palabrasEnLinea;
    Diccionario diccionario = new Diccionario(rutaDiccionario);
    System.out.println("##### Portadora analizada: #####");
    try (BufferedReader br = new BufferedReader(new FileReader(rutaPortadora))) {
      String linea = br.readLine();
      while (linea != null) {
        palabrasEnLinea = linea.split(" ");
        for (String palabrita : palabrasEnLinea) {
          System.out.print(diccionario.contienePalabra(palabrita) ? "[[" + palabrita + "]] " : palabrita + " ");
        }
        System.out.println();
        linea = br.readLine();
      }
    } catch (IOException e) {
      System.out.println("Error de escritura/lectura: " + e.getMessage());
    }
  }
}
