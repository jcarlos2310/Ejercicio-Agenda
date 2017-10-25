public class AplicacionTerminal {
    public static void main(String[] args){
        Contacto c1=new Contacto("carlos", "uaslp", 745617560);
        Contacto c2=new Contacto("juan", "mx", 746351678);
        Contacto c3=new Contacto("luis", "slp", 746314656);

        Agenda agenda=new Agenda();
        agenda.agregaContacto(c1);
        agenda.agregaContacto(c2);
        agenda.agregaContacto(c3);
        agenda.imprimeTodo();
    }
}
