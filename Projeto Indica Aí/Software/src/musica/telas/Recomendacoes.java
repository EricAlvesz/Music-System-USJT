/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica.telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import musica.entidades.Usuario;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Josemar-Not
 */
public class Recomendacoes extends javax.swing.JFrame {

    Connection con = null;
    int codigoUsuario;
    DefaultTableModel modelo;//tabela
    int setar = -1, codigoExclusao;
    ResultSet rs;
    List lista = new ArrayList();

    /**
     * Creates new form Recomendacoes
     */
    public Recomendacoes(Connection conexao, int codigoUsuario) {

        initComponents();
        con = conexao;
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.codigoUsuario = codigoUsuario;
        System.out.println(codigoUsuario);
        tabelaRelatorio.setDefaultEditor(Object.class, null);
        tabelaRelatorio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        buscaEscolha();
        preencheTabela();

    }

    public void preencheTabela() {

        PreparedStatement st = null;
        
        String[] colunasTabela = new String[]{ "idGenero", "Descricao", "Media" };  
DefaultTableModel modeloTabela = new DefaultTableModel(null,colunasTabela);

        try {
            st = con.prepareStatement("select * from topMusicas");

            //st.setInt(1, codigoGenero);
            rs = st.executeQuery();
            while(rs.next()){
                if(tem(rs.getString("idGenero"))){
                      modeloTabela.addRow(new String[] {                  
                rs.getString("idGenero"),  
                rs.getString("Descricao"),  
                rs.getString("Media")
            });                 }
                
          
    }

           /* tabelaRelatorio.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaRelatorio.getColumnModel().getColumn(1).setPreferredWidth(60);
            tabelaRelatorio.getColumnModel().getColumn(2).setPreferredWidth(60);
            tabelaRelatorio.getColumnModel().getColumn(0).setMinWidth(20);
            tabelaRelatorio.getColumnModel().getColumn(0).setMaxWidth(20);

            modelo = (DefaultTableModel) tabelaRelatorio.getModel();
            tabelaRelatorio.setRowSorter(new TableRowSorter<>(modelo));*/
            st.close();
            JTable table = new JTable();
            tabelaRelatorio.setModel(modeloTabela);
            tabelaRelatorio.getColumnModel().getColumn(0).setMinWidth(0);
            tabelaRelatorio.getColumnModel().getColumn(0).setMaxWidth(0);
            /*List lista2 = new ArrayList();
            for (int linha = 0; linha < tabelaRelatorio.getRowCount(); linha++) {
               int valorColuna = (int) tabelaRelatorio.getModel().getValueAt(linha, 0);
               System.out.println("Procurando: " + valorColuna);
                if (tem(valorColuna)) {
                    //System.out.println("Achei: " + valorColuna);
                } else {                          
                   System.out.println("Vou remover: " + valorColuna + " Linha: " + linha);
                    lista2.add(linha);
                }

            }
            removeLinha(lista2);
*/
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Atenção erro", JOptionPane.WARNING_MESSAGE);
        }
    }
    
   public boolean tem(String valor){
       for (Object c : lista) {
           if(c.toString().equals(valor)){
               return true;
           }
       }      
       return false;
   }

    public void removeLinha(List lista2) {

// Remove a linha do modelo
        DefaultTableModel dtm = (DefaultTableModel) tabelaRelatorio.getModel();

        for (Object c : lista2) {
            System.out.println("Removendo: " + c.toString());
            ((DefaultTableModel) tabelaRelatorio.getModel()).removeRow(Integer.parseInt(c.toString()));
        }
       tabelaRelatorio.setModel(dtm);
       tabelaRelatorio.updateUI();
    }
    
    public void removeLinha(int valor) {

// Remove a linha do modelo
        DefaultTableModel dtm = (DefaultTableModel) tabelaRelatorio.getModel();


            dtm.removeRow(valor);;
  
        
    }

    public void buscaEscolha() {
        PreparedStatement st = null;
        //logica principal para pesquisar no banco de dados
        String sql = "select idGenero from generousuario where idUsuario = ?";
        try {
//as linhas abaixo preparam a consulta em função do que foi 
//digitado nas caixas de texto. O ? é substituído pelo conteúdo
//das variáveis que são armazenadas em pst.setString
            st = con.prepareStatement(sql);
            st.setInt(1, codigoUsuario);

            //a linha abaixo executa a query(consulta)
            rs = st.executeQuery();
            //se existir um usuário e senha correspondente
            while (rs.next()) {
                //a linha abaixo obtem o conteúdo do campo perfil da tabela tbusuario

                //System.out.println(perfil);
                //a estrutura abaixo faz o tratamento do perfil do usuário
                lista.add(rs.getInt("idGenero"));

            }
            for (Object c : lista) {
                System.out.println("Pode: " + c.toString());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private Recomendacoes() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRelatorio = new javax.swing.JTable();
        button1 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Musica", "Posto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRelatorio.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelaRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRelatorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaRelatorio);

        button1.setLabel("Voltar");
        button1.setName(""); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Recomendações para você.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 75, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRelatorioMouseClicked
        // TODO add your handling code here:
        //setarCampos();
    }//GEN-LAST:event_tabelaRelatorioMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        Dashboard dash = new Dashboard(con, codigoUsuario);
        dash.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recomendacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recomendacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaRelatorio;
    // End of variables declaration//GEN-END:variables
}
