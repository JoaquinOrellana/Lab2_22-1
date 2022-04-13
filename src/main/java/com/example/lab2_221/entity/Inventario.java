package com.example.lab2_221.entity;


import javax.persistence.*;

@Entity
@Table(name="inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="idinventario")
    private Integer idinventario;
    @Column(name="nombre")
    private String nombre;
    @Column(name="idtipo")
    private Integer idtipo;
    @Column(name="numeroserie")
    private String numeroserie;
    @Column(name="idsede")
    private Integer idsede;
    @Column(name="idmarca")
    private Integer id;
    @Column(name="estado")
    private String estado;

    public Integer getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(Integer idinventario) {
        this.idinventario = idinventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getNumeroserie() {
        return numeroserie;
    }

    public void setNumeroserie(String numeroserie) {
        this.numeroserie = numeroserie;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
