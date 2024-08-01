package com.example.Avocapplogin.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "dossier")
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String refBureau;
    private String refTribunal;
    private Date dateReception;
    private Double montantTotal;
    private Double montantAvance;
    private String etat;
    private Date created;
    private Date updated;

    @OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Procedure> procedures;

    @OneToMany(mappedBy = "dossier")
    private Set<PersonnesDossier> personnesDossiers;

    @OneToMany(mappedBy = "dossier")
    private Set<AssurancesDossier> assurancesDossiers;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefBureau() {
        return refBureau;
    }

    public void setRefBureau(String refBureau) {
        this.refBureau = refBureau;
    }

    public String getRefTribunal() {
        return refTribunal;
    }

    public void setRefTribunal(String refTribunal) {
        this.refTribunal = refTribunal;
    }

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public Double getMontantAvance() {
        return montantAvance;
    }

    public void setMontantAvance(Double montantAvance) {
        this.montantAvance = montantAvance;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Set<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<Procedure> procedures) {
        this.procedures = procedures;
    }

    public Set<PersonnesDossier> getPersonnesDossiers() {
        return personnesDossiers;
    }

    public void setPersonnesDossiers(Set<PersonnesDossier> personnesDossiers) {
        this.personnesDossiers = personnesDossiers;
    }

    public Set<AssurancesDossier> getAssurancesDossiers() {
        return assurancesDossiers;
    }

    public void setAssurancesDossiers(Set<AssurancesDossier> assurancesDossiers) {
        this.assurancesDossiers = assurancesDossiers;
    }
}
