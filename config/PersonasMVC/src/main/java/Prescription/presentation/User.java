package main.java.Prescription.presentation;

import java.util.Objects;

/**
 * Clase abstracta base para todos los usuarios del sistema.
 * Entidad común para médicos, farmacéuticos y administradores.
 */
public abstract class User {
    protected String id;
    protected String name;
    protected String password;

    /**
     * Constructor de la clase User.
     * @param id   Identificador único del usuario.
     * @param name Nombre completo del usuario.
     * @param password Contraseña del usuario.
     */
    public User(String id,String password, String name){
        this.id = id;
        this.name = name;
        this.password = password;
    }
    /**
     * Constructor vació para XML

     */
    public User() {
        this("", "", "");
    }
    /**
     * Valida las credenciales del usuario.
     * @param id       Identificador a validar.
     * @param password Contraseña a validar.
     * @return true si las credenciales coinciden, false en caso contrario.
     */

    public boolean validateCredentials(String id,String password) {
        return this.id != null && this.password != null && this.id.equals(id) && this.password.equals(password);
    }

    /**
     * Cambia la contraseña del usuario
     * @param newPassword Nueva contraseña a establecer.
     */

