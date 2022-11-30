/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;
import java.io.Serializable;

/**
 *
 * @author Alumno Mañana
 */
public class Notificaciones implements Serializable {
    private int notificacionesID;
    private int nottypeID;
    private int typeID;
    private int refID;
    private boolean esLeido;
    private Date fueCreada;

    public Notificaciones(int notificacionesID, int nottypeID, int typeID, int refID, boolean esLeido, Date fueCreada) {
        this.notificacionesID = notificacionesID;
        this.nottypeID = nottypeID;
        this.typeID = typeID;
        this.refID = refID;
        this.esLeido = esLeido;
        this.fueCreada = fueCreada;
    }

    public Notificaciones(int notificacionesID, int typeID, int refID, boolean esLeido, Date fueCreada) {
        this.notificacionesID = notificacionesID;
        this.typeID = typeID;
        this.refID = refID;
        this.esLeido = esLeido;
        this.fueCreada = fueCreada;
    }

    
    
    public Notificaciones() {
    }

    public int getNotificacionesID() {
        return notificacionesID;
    }

    public void setNotificacionesID(int notificacionesID) {
        this.notificacionesID = notificacionesID;
    }

    public int getNottypeID() {
        return nottypeID;
    }

    public void setNottypeID(int nottypeID) {
        this.nottypeID = nottypeID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getRefID() {
        return refID;
    }

    public void setRefID(int refID) {
        this.refID = refID;
    }

    public boolean isEsLeido() {
        return esLeido;
    }

    public void setEsLeido(boolean esLeido) {
        this.esLeido = esLeido;
    }

    public Date getFueCreada() {
        return fueCreada;
    }

    public void setFueCreada(Date fueCreada) {
        this.fueCreada = fueCreada;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.notificacionesID;
        hash = 47 * hash + this.nottypeID;
        hash = 47 * hash + this.typeID;
        hash = 47 * hash + this.refID;
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
        final Notificaciones other = (Notificaciones) obj;
        if (this.notificacionesID != other.notificacionesID) {
            return false;
        }
        if (this.nottypeID != other.nottypeID) {
            return false;
        }
        if (this.typeID != other.typeID) {
            return false;
        }
        if (this.refID != other.refID) {
            return false;
        }
        return true;
    }
  
    
    
}
