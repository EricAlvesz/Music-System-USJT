/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica.entidades;

import java.sql.Date;


public class GeneroUsuario {
    private int idGeneroUsuario;
    private int idUsuario;
    private int idGenero;
    private Date dataInsercao;

    public int getIdGeneroUsuario() {
        return idGeneroUsuario;
    }

    public void setIdGeneroUsuario(int idGeneroUsuario) {
        this.idGeneroUsuario = idGeneroUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public Date getDataInsercao() {
        return dataInsercao;
    }

    public void setDataInsercao(Date dataInsercao) {
        this.dataInsercao = dataInsercao;
    }
    
    
}
