import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GeneradorPsicofonias {
  // Atributos de clase
  private static final String[] listaCaracteres = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
  private static final double[] listaPesos = { 12.53, 1.42, 4.68, 5.86, 13.68, 0.69, 1.01, 0.70, 6.25, 0.44, 0.01, 4.97, 3.15, 6.71, 0.31, 8.68, 2.51, 0.88, 6.87, 7.98, 4.63, 3.93, 0.90, 0.2, 0.22, 0.90, 0.52 };

  
  // Constructores
  public GeneradorPsicofonias() {

  }
  
  // Métodos
  public static void generaArchivo(int numLineas) {
    String linea;
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("portadora.txt"))) {
      
      for (int i = 0; i < numLineas; i++) {
        linea = "";
        // Algoritmo de elección de carácter
        for (int z = 0; z < 100; z++) { // Escribimos 100 caracteres por línea
          switch ((int) (Math.random() * 5)) { // 20% De posibilidad de generar espacio, 80% de carácter
          case 0:
            linea += " ";
            break;
          case 1:
          case 2:
          case 3:
          case 4:
            int randomPos = -1;
            double randomNum = Math.random() * 100; // 100 es la suma de los pesos
            for (int j = 0; j < listaCaracteres.length; j++) { // Elegimos que letra seleccionar
              randomNum = randomNum - listaPesos[j]; // Va restando pesos hasta llegar a 0 o menos
              if (randomNum <= 0.0d) {
                randomPos = j;
                break;
              }
            }
            linea = linea + listaCaracteres[randomPos]; // randomPos será un número aleatorio dependiente de los pesos
            break;
          }
        }
        bw.write(linea + "\r\n");
      }
      System.out.println("##### Portadora generada! #####");
    } catch (IOException e) {
      System.out.println("Error de escritura/lectura: " + e.getMessage());
    }
  }
}
