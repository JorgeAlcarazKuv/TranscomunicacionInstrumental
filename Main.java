import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    boolean salir = false;
    int eleccion = 0;
    Scanner teclado = new Scanner(System.in);
    LectorPsicofonias lector = new LectorPsicofonias("spanish.lst");
    
    System.out.println("Bienvenido al programa favorito de los magufos, elige una opción: ");
    while (!salir) {
      System.out.println("1 - Generar nueva portadora. ");
      System.out.println("2 - Analizar la última portadora generada.");
      System.out.println("3 - Mostrar estadísticas.");
      System.out.println("4 - Salir. ");
      System.out.print("Elige una opción: ");
      
      eleccion = teclado.nextInt();
      switch(eleccion) {
        case 4:
          salir = true;
          break;
        case 1:
          System.out.print("Cuantas líneas debe tener la portadora?: ");
          GeneradorPsicofonias.generaArchivo(teclado.nextInt());
          break;
        case 2:
          lector.escaneaArchivo("portadora.txt");
          break;
        case 3:
          System.out.println("Se ha encontrado un total de " + lector.getNumPalabras() + " palabras del diccionario español");
          System.out.printf("Se han encontrado de media 1 palabra española por cada %.2f palabras en la portadora.\n", lector.getMediaDistancias());    
          break;
        default:
          System.out.println("Elección no válida, introduce una opción correcta.");
      
      }
      
    }

  }

}
