
import java.util.Scanner;

public class Ayuda1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0, Tmax = 10, Tmin = 4, n = 0;
        float[] arrNotas = new float[Tmax];
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    System.out.println("Ingresar notas");
                    n = ingresar_notas(arrNotas, Tmax, Tmin);
                    break;
                case 2:
                    System.out.println("Promedio");
                    System.out.println("El promedio es: " + promedio(arrNotas, n));
                    break;
                case 3:
                    System.out.println("Aprobados y no aprobados");
                    aprobados_no_aprobados(arrNotas, n);
                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
        scanner.close();
    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("====MENU====");
        System.out.println("1. Ingresar notas");
        System.out.println("2. Promedio");
        System.out.println("3. Aprobados no aprobados");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        return opcion;
    }

    public static int ingresar_notas(float[] arrNotas, int Tmax, int Tmin) {
        Scanner scanner = new Scanner(System.in);
        int n, i;
        float notas;
        System.out.println("Ingrese cantidad de estudiantes: ");
        n = scanner.nextInt();
        while (n < Tmin || n > Tmax) {
            System.out.println("Ingrese cantidad valida: ");
            n = scanner.nextInt();
        }
        for (i = 0; i < n; i++) {
            System.out.println("Ingrese nota: ");
            notas = scanner.nextFloat();
            while (notas < 0.0 || notas > 5.0) {
                System.out.println("Ingrese nota valida: ");
                notas = scanner.nextFloat();
            }
            arrNotas[i] = notas;
        }
        return n;
    }

    public static float promedio(float[] arrNotas, int n) {
        float suma = 0, pro;
        int i;
        for (i = 0; i < n; i++) {
            suma = suma + arrNotas[i];
        }
        pro = suma / n;
        return pro;
    }

    public static void aprobados_no_aprobados(float[] arrNotas, int n) {
        int aprob = 0, naprob = 0;
        for (int i = 0; i <= n; i++) {
            if (arrNotas[i] < 3) {
                naprob = naprob + 1;
            } else {
                aprob = aprob + 1;
            }
        }
        System.out.println("Los estudiantes que aprobaron: " + aprob);
        System.out.println("Los estudiantes que no aprobaron: " + naprob);
    }
}
