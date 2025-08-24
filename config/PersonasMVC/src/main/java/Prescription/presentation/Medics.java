package main.java.Prescription.presentation;

/**
 * Clase médico
 * Hereda de User
 */

public class Medics extends User{
    private String specialty;

    public Medics(String id, String password, String name, String specialty) {
        super(id, password, name);
        this.specialty = specialty;
    }
    /**
     * Constructor vació para XML
     */
    public Medics() {
        this("", "", "", "");
    }

    public Medics (String id,String name,String specialty){
        super (id,"",name);
        this.specialty = specialty;
    }
    @Override
    public String getTipoUsuario() {
        return "Médico";
    }
    //Getters y Setters
    public String getSpecialty() {
        return specialty;
    }
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
    @Override
    public String toString() {
        return "Médico{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}