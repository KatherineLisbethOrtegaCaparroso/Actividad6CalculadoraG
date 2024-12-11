    import java.util.Scanner;

    public class CalculadoraGeome {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double[] resultados = new double[10];  // Arreglo para almacenar los resultados
            int contador = 0;  // Contador para resultados

            while (true) {
                try {
                    System.out.println("Seleccione la figura geométrica:");
                    System.out.println("1. Círculo");
                    System.out.println("2. Cuadrado");
                    System.out.println("3. Triángulo");
                    System.out.println("4. Rectángulo");
                    System.out.println("5. Pentágono");
                    System.out.print("Ingrese el número de la figura (1-5): ");
                    int figura = Integer.parseInt(scanner.nextLine());

                    if (figura < 1 || figura > 5) {
                        System.out.println("Figura no válida. Intente de nuevo.");
                        continue;
                    }

                    System.out.println("Seleccione la operación:");
                    System.out.println("1. Área");
                    System.out.println("2. Perímetro");
                    System.out.print("Ingrese el número de la operación (1-2): ");
                    int operacion = Integer.parseInt(scanner.nextLine());

                    if (operacion < 1 || operacion > 2) {
                        System.out.println("Operación no válida. Intente de nuevo.");
                        continue;
                    }

                    double resultado = 0.0;

                    switch (figura) {
                        case 1:
                            System.out.print("Ingrese el radio del círculo: ");
                            double radio = Double.parseDouble(scanner.nextLine());
                            if (operacion == 1) {
                                resultado = Math.PI * Math.pow(radio, 2); // Área
                            } else if (operacion == 2) {
                                resultado = 2 * Math.PI * radio; // Perímetro
                            }
                            break;
                        case 2:
                            System.out.print("Ingrese la longitud del lado del cuadrado: ");
                            double ladoCuadrado = Double.parseDouble(scanner.nextLine());
                            if (operacion == 1) {
                                resultado = Math.pow(ladoCuadrado, 2); // Área
                            } else if (operacion == 2) {
                                resultado = 4 * ladoCuadrado; // Perímetro
                            }
                            break;
                        case 3:
                            System.out.print("Ingrese la base del triángulo: ");
                            double baseTriangulo = Double.parseDouble(scanner.nextLine());
                            System.out.print("Ingrese la altura del triángulo: ");
                            double alturaTriangulo = Double.parseDouble(scanner.nextLine());
                            if (operacion == 1) {
                                resultado = (baseTriangulo * alturaTriangulo) / 2; // Área
                            } else if (operacion == 2) {
                                System.out.print("Ingrese la longitud de los otros dos lados: ");
                                double lado1 = Double.parseDouble(scanner.nextLine());
                                double lado2 = Double.parseDouble(scanner.nextLine());
                                resultado = baseTriangulo + lado1 + lado2; // Perímetro
                            }
                            break;
                        case 4:
                            System.out.print("Ingrese la longitud del rectángulo: ");
                            double longitud = Double.parseDouble(scanner.nextLine());
                            System.out.print("Ingrese el ancho del rectángulo: ");
                            double ancho = Double.parseDouble(scanner.nextLine());
                            if (operacion == 1) {
                                resultado = longitud * ancho; // Área
                            } else if (operacion == 2) {
                                resultado = 2 * (longitud + ancho); // Perímetro
                            }
                            break;
                        case 5:
                            System.out.print("Ingrese la longitud del lado del pentágono: ");
                            double ladoPentagono = Double.parseDouble(scanner.nextLine());
                            if (operacion == 1) {
                                resultado = (5 * ladoPentagono * ladoPentagono) / (4 * Math.tan(Math.PI / 5)); // Área
                            } else if (operacion == 2) {
                                resultado = 5 * ladoPentagono; // Perímetro
                            }
                            break;
                        default:
                            System.out.println("Figura no válida.");
                            break;
                    }

                    // Guardar el resultado
                    if (contador < resultados.length) {
                        resultados[contador++] = resultado; // Almacenar el resultado en el arreglo
                        System.out.println("El resultado es: " + resultado);
                    } else {
                        System.out.println("No se pueden almacenar más resultados.");
                        break; // Si el arreglo se llena, salimos del ciclo
                    }

                    // Preguntar si el usuario desea continuar
                    System.out.print("¿Desea realizar otra operación? (sí/no): ");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("no")) {
                        break; // Terminar el programa si el usuario dice "no"
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                }
            }

            // Mostrar los resultados almacenados
            System.out.println("\nResultados almacenados:");
            for (int i = 0; i < contador; i++) {
                System.out.println("Resultado " + (i + 1) + ": " + resultados[i]);
            }

            scanner.close();
        }
    }