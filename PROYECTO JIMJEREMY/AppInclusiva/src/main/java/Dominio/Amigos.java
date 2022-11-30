/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;

/**
 *
 * @author Alumno Mañana
 */
public class Amigos implements Serializable {
    private int amigosID;
    private boolean esAceptado;
    private boolean esLeido;

    public Amigos(int amigosID, boolean esAceptado, boolean esLeido) {
        this.amigosID = amigosID;
        this.esAceptado = esAceptado;
        this.esLeido = esLeido;
    }

    public Amigos() {
    }

    public int getAmigosID() {
        return amigosID;
    }

    public void setAmigosID(int amigosID) {
        this.amigosID = amigosID;
    }

    public boolean isEsAceptado() {
        return esAceptado;
    }

    public void setEsAceptado(boolean esAceptado) {
        this.esAceptado = esAceptado;
    }

    public boolean isEsLeido() {
        return esLeido;
    }

    public void setEsLeido(boolean esLeido) {
        this.esLeido = esLeido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.amigosID;
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
        final Amigos other = (Amigos) obj;
        if (this.amigosID != other.amigosID) {
            return false;
        }
        return true;
    }
  
    
}
