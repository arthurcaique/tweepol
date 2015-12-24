/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abreviaturas;

import exceptions.DadoInvalidoException;
import exceptions.ErroInternoException;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author W8
 */
public class AbreviaturasView extends javax.swing.JDialog {

    private TableModel tableModel;

    /**
     * Creates new form AbreviaturasView
     *
     * @param parent
     * @param modal
     */
    public AbreviaturasView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            setarTableModel();
        } catch (ErroInternoException ex) {
            ex.exibirMensagemAoUsuario(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPAbreviaturas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFAbv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTFWord = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAbrvs = new javax.swing.JTable();
        jXBAdd = new org.jdesktop.swingx.JXButton();
        jXBConcluir = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPAbreviaturas.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Abreviatura:");

        jTFAbv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFAbvFocusGained(evt);
            }
        });
        jTFAbv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFAbvKeyPressed(evt);
            }
        });

        jLabel2.setText("Palavra:");

        jTFWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFWordFocusGained(evt);
            }
        });

        jTAbrvs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTAbrvs);

        jXBAdd.setBackground(new java.awt.Color(255, 255, 255));
        jXBAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXBAdd.setText("Adicionar");
        jXBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXBAddActionPerformed(evt);
            }
        });

        jXBConcluir.setBackground(new java.awt.Color(255, 255, 255));
        jXBConcluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jXBConcluir.setText("Concluir");
        jXBConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXBConcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPAbreviaturasLayout = new javax.swing.GroupLayout(jPAbreviaturas);
        jPAbreviaturas.setLayout(jPAbreviaturasLayout);
        jPAbreviaturasLayout.setHorizontalGroup(
            jPAbreviaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAbreviaturasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAbreviaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPAbreviaturasLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jTFAbv, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFWord, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXBAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPAbreviaturasLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jXBConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPAbreviaturasLayout.setVerticalGroup(
            jPAbreviaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPAbreviaturasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPAbreviaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFAbv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTFWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jXBConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPAbreviaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPAbreviaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFAbvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFAbvFocusGained
        jTFAbv.selectAll();
    }//GEN-LAST:event_jTFAbvFocusGained

    private void jTFWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFWordFocusGained
        jTFWord.selectAll();
    }//GEN-LAST:event_jTFWordFocusGained

    private void jTFAbvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFAbvKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFWord.requestFocus();
        }
    }//GEN-LAST:event_jTFAbvKeyPressed

    private void jXBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jXBCancelActionPerformed

    private void jXBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXBAddActionPerformed
        String abv = jTFAbv.getText();
        String word = jTFWord.getText();
        if (!abv.trim().isEmpty()) {
            if (!word.trim().isEmpty()) {
                try {
                    Abreviatura abvr = new Abreviatura(abv, word);
                    tableModel.addAbv(abvr);
                    jTFAbv.setText("");
                    jTFWord.setText("");
                    AbreviaturaUtils.inserirAbv(abvr);
                } catch (ErroInternoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (DadoInvalidoException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_jXBAddActionPerformed

    private void jXBConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXBConcluirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jXBConcluirActionPerformed

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
            java.util.logging.Logger.getLogger(AbreviaturasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbreviaturasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbreviaturasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbreviaturasView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            AbreviaturasView dialog = new AbreviaturasView(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPAbreviaturas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAbrvs;
    private javax.swing.JTextField jTFAbv;
    private javax.swing.JTextField jTFWord;
    private org.jdesktop.swingx.JXButton jXBAdd;
    private org.jdesktop.swingx.JXButton jXBConcluir;
    // End of variables declaration//GEN-END:variables

    private void setarTableModel() throws ErroInternoException {
        tableModel = new TableModel(jTAbrvs);
        jTAbrvs.setModel(tableModel);
        tableModel.addRows(AbreviaturaUtils.recuperarAbv());
    }

    public class TableModel extends utilitarios.ModeloDeTabelaAbstrato {

        private final String[] colunas = new String[]{"Abv", "Palavra"};

        public TableModel(JTable tabela) {
            super(tabela);
        }

        @Override
        public int getColumnCount() {
            return this.colunas.length;
        }

        @Override
        public String getColumnName(int column) {
            return this.colunas[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Abreviatura abv = (Abreviatura) this.lista.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return abv.getAbv();
                case 1:
                    return abv.getNormal();
                default:
                    throw new IndexOutOfBoundsException();
            }
        }

        public void addAbv(Abreviatura abv) throws DadoInvalidoException {
            for (Abreviatura abv1 : (ArrayList<Abreviatura>) this.lista) {
                if (!abv.getAbv().equalsIgnoreCase(abv1.getAbv())) {
                    this.lista.add(abv);
                    fireTableDataChanged();
                    return;
                } 
                throw new DadoInvalidoException("Essa abreviatura já foi inserida!");
            }
        }

    }

}