package main.java.Prescription.logic;

import java.util.Date;
import java.util.Calendar;
import java.util.Objects;

/**
 * Clase paciente
 * Info básica para prescripciones
 */
public class Patient {
    private String id;
    private String name;
    private Date birthDate;
    private String phoneNumber;

    public Patient(String id, String name, Date birthDate, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    // Constructor vacío para XML
    public Patient() {
    }

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
        this.birthDate = null;
        this.phoneNumber = "";
    }

    public int calculateAge() {
        if (birthDate == null) return -1;
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public boolean isDataComplete() {
        return Validador.validarId(id) &&
                Validador.validarNombre(name) &&
                Validador.validarTelefono(phoneNumber) &&
                Validador.validarFecha(birthDate);
    }

    public String getSearchString() {
        return (id != null ? id : "") + " " +
                (name != null ? name : "");
    }

    // Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + calculateAge() +
                ", phone='" + phoneNumber + '\'' +
                '}';
    }
}