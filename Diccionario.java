
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class Diccionario {
  private Set<String> listaPalabras;
  
  public Diccionario(String ruta) {
    listaPalabras = new TreeSet<>();
    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
      String palabra = br.readLine();
      while (palabra != null) {
        this.listaPalabras.add(palabra);
        palabra = br.readLine();
      }
    } catch (IOException e) {
      
    }
  }
  
  public boolean contienePalabra(String palabra) {
    return this.listaPalabras.contains(palabra);
  }
  
  public Set<String> getListaPalabras () {
    return this.listaPalabras;
  }
}
