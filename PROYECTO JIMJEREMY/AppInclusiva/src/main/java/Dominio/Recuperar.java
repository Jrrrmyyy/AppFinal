/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author Alumno Mañana
 */
public class Recuperar {
    private int recuperarID;
    private String codigo;
    private boolean activo;
    private Date fueCreado;
    private int usuarioIDFK;

    public Recuperar(int recuperarID, String codigo, boolean activo, Date fueCreado, int usuarioIDFK) {
        this.recuperarID = recuperarID;
        this.codigo = codigo;
        this.activo = activo;
        this.fueCreado = fueCreado;
        this.usuarioIDFK = usuarioIDFK;
    }

    public Recuperar() {
    }

    public int getRecuperarID() {
        return recuperarID;
    }

    public void setRecuperarID(int recuperarID) {
        this.recuperarID = recuperarID;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFueCreado() {
        return fueCreado;
    }

    public void setFueCreado(Date fueCreado) {
        this.fueCreado = fueCreado;
    }

    public int getUsuarioIDFK() {
        return usuarioIDFK;
    }

    public void setUsuarioIDFK(int usuarioIDFK) {
        this.usuarioIDFK = usuarioIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.recuperarID;
        hash = 71 * hash + this.usuarioIDFK;
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
        final Recuperar other = (Recuperar) obj;
        if (this.recuperarID != other.recuperarID) {
            return false;
        }
        if (this.usuarioIDFK != other.usuarioIDFK) {
            return false;
        }
        return true;
    }
    
    
}
