package prog2.model;

public class Client{
    private String nom;
    private String Dni;

    public Client(String nom,String Dni) {
        this.nom=nom;
        setDni(Dni);
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom=nom;
    }

    public String getDni(){
        return this.Dni;
    }

    public void setDni(String Dni){
        if (Dni.length() == 9) {
            this.Dni = Dni;  // Assignem el valor del paràmetre a l'atribut
        }
    }


    public String toString(){
        return getNom()+ " amb DNI: "+ getDni()+". ";
    }

}
