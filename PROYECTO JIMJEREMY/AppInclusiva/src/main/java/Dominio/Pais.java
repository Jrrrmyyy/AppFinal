/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */
public class Pais {
    private int paisID;
    private String nombrePais;
    private String prefijoPais;

    public Pais(int paisID, String nombrePais, String prefijoPais) {
        this.paisID = paisID;
        this.nombrePais = nombrePais;
        this.prefijoPais = prefijoPais;
    }

    public Pais() {
    }

    public int getPaisID() {
        return paisID;
    }

    public void setPaisID(int paisID) {
        this.paisID = paisID;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getPrefijoPais() {
        return prefijoPais;
    }

    public void setPrefijoPais(String prefijoPais) {
        this.prefijoPais = prefijoPais;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.paisID;
        hash = 97 * hash + Objects.hashCode(this.nombrePais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        if (this.paisID != other.paisID) {
            return false;
        }
        if (!Objects.equals(this.nombrePais, other.nombrePais)) {
            return false;
        }
        return true;
    }
    
    
}
