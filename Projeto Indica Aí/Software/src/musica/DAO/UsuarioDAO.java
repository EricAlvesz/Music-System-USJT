/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import musica.entidades.Usuario;


public class UsuarioDAO {
    
    private final Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    
    public int logar(Usuario usuario) {

        //logica principal para pesquisar no banco de dados
        String sql = "select * from usuarios where nomeUsuario = ? and senha = ?";
        try {
//as linhas abaixo preparam a consulta em função do que foi 
//digitado nas caixas de texto. O ? é substituído pelo conteúdo
//das variáveis que são armazenadas em pst.setString
            pst = conn.prepareStatement(sql);
            pst.setString(1, usuario.getNomeUsuario());
            pst.setString(2, usuario.getSenha());
            //a linha abaixo executa a query(consulta)
            rs = pst.executeQuery();
            //se existir um usuário e senha correspondente
            if (rs.next()) {
                //a linha abaixo obtem o conteúdo do campo perfil da tabela tbusuario
                
                //System.out.println(perfil);
                //a estrutura abaixo faz o tratamento do perfil do usuário
                System.out.println(rs.getInt("idUsuarios"));
                return rs.getInt("idUsuarios");
                
                   
                                                    
            } else {
                
                return 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return 0;

    }
    
    
    
    public boolean cadastro(Usuario usuario){
        PreparedStatement st = null;
		String sql = "insert into usuarios(nomeUsuario,senha) values (?,?)";
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, usuario.getNomeUsuario());
			st.setString(2, usuario.getSenha());			
			int adicionado = st.executeUpdate();
			if (adicionado > 0) {
                            JOptionPane.showMessageDialog(null, "Adicionado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		JOptionPane.showMessageDialog(null, "Não consegui", "Não consegui", JOptionPane.WARNING_MESSAGE);
		return false;
    }
    
    
    
}
