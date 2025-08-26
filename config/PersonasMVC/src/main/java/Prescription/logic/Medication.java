package main.java.Prescription.logic;

import java.util.Objects;
/**
 * Clase medicamento
 * Info básica para prescripciones
 */

public class Medication {
    private String code;
    private String name;
    private String presentation;

    /**
     * @param presentation Presentación (dosis, forma, etc.)
     */
    public Medication(String code, String name, String presentation) {
        this.code = code;
        this.name = name;
        this.presentation = presentation;
    }

    // Constructor vacío para XML
    public Medication() {
    }

    public Medication(String code, String name) {
        this.code = code;
        this.name = name;
        this.presentation = "";
    }

    public String getFullDescription() {
        if (presentation != null && !presentation.trim().isEmpty()) {
            return name + " - " + presentation;
        }
        return name != null ? name : "";
    }

    public String getSearchString() {
        StringBuilder sb = new StringBuilder();
        if (code != null) sb.append(code).append(" ");
        if (name != null) sb.append(name).append(" ");
        if (presentation != null) sb.append(presentation);
        return sb.toString().toLowerCase();
    }

    /**
     * Valida si los datos del medicamento son completos y correctos.
     *
     * @return true si los datos son válidos
     */
    public boolean isDataComplete() {
        return Validador.validarCodigoMedicamento(code) &&
                Validador.validarNombre(name);
        Validador.validarPresentacion(presentation);
    }

    public boolean matchesSearchCriteria(String criteria) {
        if (criteria == null || criteria.trim().isEmpty()) {
            return false;
        }

        String searchTerm = criteria.toLowerCase().trim();
        return getSearchString().contains(searchTerm) ||
                (code != null && code.toLowerCase().contains(searchTerm));
    }

    // Getters y Setters
    public String getCode() {
        return code;

    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medication)) return false;
        Medication medication = (Medication) o;
        return Objects.equals(code, medication.code);
    }
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
    @Override
    public String toString() {
        return "Medication{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", presentation='" + presentation + '\'' +
                '}';
    }







}