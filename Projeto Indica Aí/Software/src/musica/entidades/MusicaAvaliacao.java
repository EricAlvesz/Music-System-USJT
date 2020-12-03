/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica.entidades;

import java.sql.Date;

/**
 *
 * @author Josemar-Not
 */
public class MusicaAvaliacao {
    private int idMusicaAvaliacao;
    private int nota;
    private Date dataAvaliacao;
    private int idMusica;
    private int idUsuario;

    public int getIdMusicaAvaliacao() {
        return idMusicaAvaliacao;
    }

    public void setIdMusicaAvaliacao(int idMusicaAvaliacao) {
        this.idMusicaAvaliacao = idMusicaAvaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(int idMusica) {
        this.idMusica = idMusica;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    
}
