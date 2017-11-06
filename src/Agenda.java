import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Created by Alumnos on 25/10/2017.
 */
public class Agenda {
    private LinkedList<Contacto>contactos;
    public Agenda(){
        contactos=new LinkedList<>();
    }
    public void agregaContacto(Contacto nuevo){
      contactos.add(nuevo);
    }
    public void imprimeTodo(){
        /*for tradicional
            for(int i=0;i<contactos.size();i++){
            System.out.println(contactos.get(i));
        }*/
        //for-each
        //Sintaxis;
        //for (Tipo var : coleccion)
        //{
        // acciones con la variable var
        //}
        for(Contacto c : contactos)
        {
            System.out.println(c);
        }

    }
    public void guardar(String s) throws IOException{
        FileWriter archivo=new FileWriter(s);
        for(Contacto c:contactos){
            archivo.write(c.toString());
            archivo.write("\n");

        }
        archivo.close();
    }
    public void cargar(String nomArch)throws FileNotFoundException{
        Scanner archivo=new Scanner(new File(nomArch));
        while(archivo.hasNextLine()){
            String linea=archivo.nextLine();
            String[] arreglo=linea.split( ",");
            long tel=Long.parseLong(arreglo[2].trim());
            Contacto nuevo=new Contacto(arreglo[0],arreglo[1],tel);
            contactos.add(nuevo);
        }
    }
    public void eliminarContacto (long telEliminar){
    /*    for(Contacto c:contactos){
            if(telEliminar==c.dimeTel()){
                contactos.remove(c);
                break;
            }
        }*/
    //un iterador es un objeto que permite acceder a los
        //elementos de una coleccion uno por uno

        //el iterador se declara del tipo de dato(objeto)
        //que contiene la coleccion
        Iterator<Contacto>it;
        //El iterador se inicializa por medio del método iterator()
        //de la coleccion
        it=contactos.iterator();
        //El iterador tiene tres métodos
        //1.next()-regresa el siguiente elemento de la coleccion
        //2. hasNext()- verifica si todavia hay elementos en la coleccion
        //3.remove()- elimina el elemento actual de la coleccion
        while(it.hasNext()){
            Contacto c=it.next();
            if(telEliminar==c.dimeTel()){
                it.remove();
            }
        }
    }
}
