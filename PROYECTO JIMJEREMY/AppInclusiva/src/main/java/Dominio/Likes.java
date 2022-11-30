/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Alumno Mañana
 */
public class Likes {
    private int likesID;
    private int typeID;
    private int refID;
    private int usuarioIDFK;

    public Likes(int likesID, int typeID, int refID, int usuarioIDFK) {
        this.likesID = likesID;
        this.typeID = typeID;
        this.refID = refID;
        this.usuarioIDFK = usuarioIDFK;
    }

    public Likes(int likesID, int usuarioIDFK) {
        this.likesID = likesID;
        this.usuarioIDFK = usuarioIDFK;
    }

    public Likes() {
    }

    public int getLikesID() {
        return likesID;
    }

    public void setLikesID(int likesID) {
        this.likesID = likesID;
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

    public int getUsuarioIDFK() {
        return usuarioIDFK;
    }

    public void setUsuarioIDFK(int usuarioIDFK) {
        this.usuarioIDFK = usuarioIDFK;
    }
    
    
}
