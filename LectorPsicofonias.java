import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorPsicofonias {
  List<Integer> distanciasPalabras;
  int numPalabras;
  Diccionario diccionario;
  
  public LectorPsicofonias(String rutaDiccionario) {
    numPalabras = 0;
    distanciasPalabras = new ArrayList<>();
    diccionario = new Diccionario(rutaDiccionario);
  }
  
  
  public void escaneaArchivo(String rutaPortadora) {
    String[] palabrasEnLinea;
    System.out.println("##### Portadora analizada: #####");
    try (BufferedReader br = new BufferedReader(new FileReader(rutaPortadora))) {
      String linea = br.readLine();
      while (linea != null) {
        int contPalabras = 0;
        palabrasEnLinea = linea.split(" ");
        for (String palabrita : palabrasEnLinea) {
          if (diccionario.contienePalabra(palabrita)) {
            System.out.print("[[" + palabrita + "]] "); // Mi consola no soporta colores, uso [[ ]]
            this.numPalabras++;
            distanciasPalabras.add(contPalabras);
            contPalabras = 0;
            
          } else {
            System.out.print(palabrita + " ");
            contPalabras++;
          }
        }
        System.out.println();
        linea = br.readLine();
      }
    } catch (IOException e) {
      System.out.println("Error de escritura/lectura: " + e.getMessage());
    }
  }
  
  public double getMediaDistancias() {
    double suma = 0.0;
    for(int contador : distanciasPalabras) {
      suma += contador;
    }
    return suma/distanciasPalabras.size();
  }
  
  public int getNumPalabras() {
    return this.numPalabras;
  }
}
