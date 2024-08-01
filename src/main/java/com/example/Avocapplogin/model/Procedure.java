package com.example.Avocapplogin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "procedures_table")
public class Procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String etape;
    private String numero;
    private String reference;
    private int annee;
    private String typeTribunal;
    private String ville;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dossier", nullable = false)
    @JsonBackReference
    private Dossier dossier;

    @OneToMany(mappedBy = "procedure", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tabligh> tablighs;

    @OneToMany(mappedBy = "procedure", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Maktoubat> maktoubats;

    @OneToMany(mappedBy = "procedure", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Jalassat> jalassats;

    @OneToMany(mappedBy = "procedure", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Ahkam> ahkams;

    @OneToMany(mappedBy = "procedure", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tanfid> tanfids;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtape() {
        return etape;
    }

    public void setEtape(String etape) {
        this.etape = etape;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getTypeTribunal() {
        return typeTribunal;
    }

    public void setTypeTribunal(String typeTribunal) {
        this.typeTribunal = typeTribunal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public List<Tabligh> getTablighs() {
        return tablighs;
    }

    public void setTablighs(List<Tabligh> tablighs) {
        this.tablighs = tablighs;
    }

    public List<Maktoubat> getMaktoubats() {
        return maktoubats;
    }

    public void setMaktoubats(List<Maktoubat> maktoubats) {
        this.maktoubats = maktoubats;
    }

    public List<Jalassat> getJalassats() {
        return jalassats;
    }

    public void setJalassats(List<Jalassat> jalassats) {
        this.jalassats = jalassats;
    }

    public List<Ahkam> getAhkams() {
        return ahkams;
    }

    public void setAhkams(List<Ahkam> ahkams) {
        this.ahkams = ahkams;
    }

    public List<Tanfid> getTanfids() {
        return tanfids;
    }

    public void setTanfids(List<Tanfid> tanfids) {
        this.tanfids = tanfids;
    }
}
