/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import musica.entidades.GeneroUsuario;

public class GeneroDAO {

    private final Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public GeneroDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean cadastro(GeneroUsuario genero) {
        PreparedStatement st = null;
        String sql = "insert into generousuario(idUsuario,idGenero,dataInsercao) values (?,?,now())";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, genero.getIdUsuario());
            st.setInt(2, genero.getIdGenero());
            int adicionado = st.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {

                JOptionPane.showMessageDialog(null, "Você já possui esse genero como um favorito", "Já possui", JOptionPane.WARNING_MESSAGE);
                
                return false;
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
            //JOptionPane.showMessageDialog(null, "Não consegui", "Não consegui", JOptionPane.WARNING_MESSAGE);
           
        
        return false;
    }

    
    
    

    public boolean excluir(int idGenero) {
        PreparedStatement st = null;
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este genero?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from generousuario where idGeneroUsuario=?";
            try {
                st = conn.prepareStatement(sql);
                st.setInt(1, idGenero);
                int apagado = st.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Genero excluído com sucesso");
                    return true;
                }
            } catch (SQLIntegrityConstraintViolationException c) {
                JOptionPane.showMessageDialog(null, "Esse dado possui relacionamento com outra tabela do banco de dados e não é possível excluir");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return false;
    }
    /*public static void main(String args[]){
        Connection con = ModuloConexao.conector();
        GeneroDAO c = new GeneroDAO(con);
        Genero d = new Genero();
        d.setDescricao("MPB");
        d.setIdUsuario(2);
        if(c.cadastro(d)){
            System.out.println("Deu po");
        }else{
            System.out.println("deu ruim");
        }
    }*/

}
