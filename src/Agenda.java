import java.util.LinkedList;

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
}
