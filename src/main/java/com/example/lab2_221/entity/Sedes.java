package com.example.lab2_221.entity;

import javax.persistence.*;

@Entity
@Table(name="sedes")
public class Sedes {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="idsede")
    private Integer idsede;
    @Column(name="nombresede")
    private String nombresede;
    @Column(name="direccion")
    private String direccion;

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public String getNombresede() {
        return nombresede;
    }

    public void setNombresede(String nombresede) {
        this.nombresede = nombresede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
