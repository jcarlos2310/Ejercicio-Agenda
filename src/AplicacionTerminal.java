import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class AplicacionTerminal {
    private Agenda agenda;

    public AplicacionTerminal(){
        agenda=new Agenda();
    }
    public void demo(){
        Contacto c1=new Contacto("carlos", "uaslp", 745617560);
        Contacto c2=new Contacto("juan", "mx", 746351678);
        Contacto c3=new Contacto("luis", "slp", 746314656);

        //    Agenda agenda=new Agenda();
        agenda.agregaContacto(c1);
        agenda.agregaContacto(c2);
        agenda.agregaContacto(c3);
        agenda.imprimeTodo();
    }
    public void entradaUsuario(){
        Scanner entrada=new Scanner(System.in);
        String opcion="";
        do{
            try {
                System.out.println("Opciones: agregar -cargar- eliminar - guardar - imprimir - terminar");
                opcion = entrada.nextLine();
                switch (opcion) {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "cargar":
                        cargar(entrada);
                        break;
                    case "eliminar":
                        eliminar(entrada);
                        break;
                    case "guardar":
                        guardar(entrada);
                        break;
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                }
            }
            catch(IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                opcion="";
            }
            catch (InputMismatchException ex){
                System.out.println("el telefono debe tener digitos unicamente");
                opcion="";
            }
            catch(StringIndexOutOfBoundsException ex){
                System.out.println(ex.getMessage());
                opcion="";
            }

            catch (FileNotFoundException ex){
                System.out.println("El archivo no existe");
                opcion = "";
            }
            catch(IOException e){
                System.out.println(e.getMessage());
                opcion = "";

            }

        }while(opcion != "terminar");
    }
    private void eliminar(Scanner entrada){
        System.out.println("Numero de telefono a eliminar:");
        long telEliminar=entrada.nextLong();
        agenda.eliminarContacto(telEliminar);
    }
    private void guardar(Scanner entrada)throws IOException{
        System.out.println("Nombre del archivo:");
        String nomArch=entrada.nextLine();
        agenda.cargar(nomArch);
    }
    private void cargar(Scanner entrada)throws FileNotFoundException{
        System.out.println("Nombre del archivo:");
        String nomArch=entrada.nextLine();
        agenda.cargar(nomArch);

    }

    private void agregar(Scanner entrada){
        System.out.println("Agregar un contacto nuevo:");
        System.out.println("Nombre");
        String nombre=entrada.nextLine();
        System.out.println("Direccion");
        String direccion=entrada.nextLine();
        System.out.println("Telefono");
        long tel=entrada.nextLong();
        Contacto nuevo=new Contacto(nombre,direccion,tel);
        agenda.agregaContacto(nuevo);
    }
    public static void main(String[] args){
       AplicacionTerminal aplicacion=new AplicacionTerminal();
       aplicacion.entradaUsuario();
    }
}
