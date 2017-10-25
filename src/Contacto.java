import javax.print.DocFlavor;

/**
 * Created by Alumnos on 25/10/2017.
 */
public class Contacto {
    private String direccion;
    private String nombre;
    private long telefono;

  public Contacto(String nom, String dir,long tel){
    if(nom.charAt(0)>= 'a'&& nom.charAt(0)<='z'||nom.charAt(0)>= 'A'&& nom.charAt(0)<='Z')
    {
        this.nombre=nom;
    }
    else
    {
        RuntimeException ex=new IllegalArgumentException("El nombre debe:");
        throw ex;
    }
    dir=dir.trim();
    if(dir.isEmpty()){
        throw new IllegalArgumentException("la direccion no debe estar vacia");
    }
    else{
        this.direccion=dir;
    }
    String cadTel=Long.toString(tel);
    if(cadTel.length()==10){
        this.telefono=tel;
    }
    else{
        throw new IllegalArgumentException("el telefono debe tener 10 digitos");
    }
}
 @Override
  public String toString(){
      return nombre+","+ direccion+","+telefono;
 }
}