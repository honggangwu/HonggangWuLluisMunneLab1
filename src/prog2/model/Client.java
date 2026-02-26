package prog2.model;

import prog2.vista.ExcepcioReserva;

public class Client{
    private String nom;
    private String Dni;

    public Client(String nom,String Dni) throws ExcepcioReserva {
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

    public void setDni(String Dni) throws ExcepcioReserva {
        if (Dni.length() == 9) {
            this.Dni = Dni;  // Assignem el valor del paràmetre a l'atribut
        } else {
            throw new ExcepcioReserva("ERROR: El DNI ha de tenir 9 caràcters.");
        }
    }


    public String toString(){
        return "Nom=" + getNom() + ", Dni=" + getDni();
    }

}
