
public class MainPsicofonias {

  public static void main(String[] args) {
    // Genero Portadora
    GeneradorPsicofonias.generaArchivo(50);
    
    // Creo lector y escaneo portadora
    LectorPsicofonias lector = new LectorPsicofonias();
    lector.escaneaArchivo("portadora.txt", "spanish.lst"); // Le paso ruta de portadora y de diccionario como parámetros

  }

}
