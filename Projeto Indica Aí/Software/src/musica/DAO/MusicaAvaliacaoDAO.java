
package musica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import musica.entidades.MusicaAvaliacao;


public class MusicaAvaliacaoDAO {
    
    private final Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public MusicaAvaliacaoDAO(Connection conn) {
        this.conn = conn;
    }
    
    public boolean cadastro(MusicaAvaliacao musica) {
        PreparedStatement st = null;
        String sql = "insert into musicaavaliacao(nota,idUsuario,idMusica,dataAvaliacao) values (?,?,?,now())";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, musica.getNota());
            st.setInt(2, musica.getIdUsuario());
            st.setInt(3, musica.getIdMusica());
            int adicionado = st.executeUpdate();
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Avaliado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        } catch (SQLIntegrityConstraintViolationException e) {

                JOptionPane.showMessageDialog(null, "Você já avaliou essa musica", "Já possui", JOptionPane.WARNING_MESSAGE);
                
                return false;
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
            //JOptionPane.showMessageDialog(null, "Não consegui", "Não consegui", JOptionPane.WARNING_MESSAGE);
           
        
        return false;
    }

    
    
}
