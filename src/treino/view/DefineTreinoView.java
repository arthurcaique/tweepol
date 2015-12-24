/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treino.view;

import amostra.TableModelDefineConjuntoTreino;
import exceptions.DadoInvalidoException;
import java.util.ArrayList;
import tweet.Tweet;
import exceptions.ErroInternoException;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import libsvm.svm;
import libsvm.svm_model;
import libsvm.svm_parameter;
import svm_tweet.KernelType;
import treino.control.ControladorDefineTreinoView;
import treino.control.ControladorTreino;
import utilitarios.ArquivoUtils;
import utilitarios.TipoParticaoDados;

/**
 *
 * @author Arthur Caique
 */
public class DefineTreinoView extends javax.swing.JDialog {

    private TableModelDefineConjuntoTreino tableModel;
    private float acuracia;

    /**
     * Creates new form DefineTreinoView
     *
     * @param parent
     * @param modal
     */
    public DefineTreinoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setarTableModel();
        setarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDefineTreino = new javax.swing.JTable();
        jBDefinir = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jCBSelecionarTds = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jCB_tipo_particao = new javax.swing.JComboBox();
        jTF_K = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTDefineTreino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTDefineTreino.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTDefineTreino);

        jBDefinir.setText("Definir");
        jBDefinir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDefinirActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jCBSelecionarTds.setBackground(new java.awt.Color(255, 255, 255));
        jCBSelecionarTds.setText("Selecionar todos");
        jCBSelecionarTds.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCBSelecionarTdsItemStateChanged(evt);
            }
        });

        jLabel7.setText("Partição:");

        jTF_K.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTF_KFocusGained(evt);
            }
        });

        jLabel1.setText("K:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 845, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCB_tipo_particao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_K, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(238, 238, 238))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCBSelecionarTds)
                        .addGap(466, 466, 466)
                        .addComponent(jBDefinir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBCancelar, jBDefinir});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jCB_tipo_particao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBCancelar)
                        .addComponent(jBDefinir))
                    .addComponent(jCBSelecionarTds))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBDefinirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDefinirActionPerformed
        try {
            treinarTestar();
        } catch (ErroInternoException ex) {
            ex.exibirMensagemAoUsuario(ex);
        } catch (ArquivoUtils.ArquivoNaoSalvoException | DadoInvalidoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(DefineTreinoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBDefinirActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jCBSelecionarTdsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCBSelecionarTdsItemStateChanged
        selecionarTodos(jCBSelecionarTds.isSelected());
    }//GEN-LAST:event_jCBSelecionarTdsItemStateChanged

    private void jTF_KFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTF_KFocusGained
        jTF_K.selectAll();
    }//GEN-LAST:event_jTF_KFocusGained

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
            java.util.logging.Logger.getLogger(DefineTreinoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefineTreinoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefineTreinoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefineTreinoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DefineTreinoView dialog = new DefineTreinoView(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBDefinir;
    private javax.swing.JCheckBox jCBSelecionarTds;
    private javax.swing.JComboBox jCB_tipo_particao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDefineTreino;
    private javax.swing.JTextField jTF_K;
    // End of variables declaration//GEN-END:variables

    public void abrirParaSelecao(ArrayList<Tweet> tweets) {
        for (Tweet tweet : tweets) {
            tableModel.addRow(tableModel.new TweetTreino(tweet, false));
        }
    }

    private void definirConjuntoTreino() throws ErroInternoException, ArquivoUtils.ArquivoNaoSalvoException, DadoInvalidoException {
        ArrayList<Tweet> listaTreino = new ArrayList<>();
        ArrayList<Tweet> listaTeste = new ArrayList<>();
        tableModel.getTweetsTreino().stream().forEach((tweet) -> {
            if (tweet.isTreino()) {
                listaTreino.add(tweet.getTweet());
            } else {
                listaTeste.add(tweet.getTweet());
            }
        });
        svm_parameter parameter = new svm_parameter();
        parameter.kernel_type = KernelType.LINEAR.getId();
        parameter.probability = 1;
        parameter.cache_size = listaTreino.size();
        parameter.eps = 0.001;
        parameter.C = 1;
        ControladorDefineTreinoView.treinar(parameter, listaTreino, listaTeste);
        this.dispose();
    }

    private void treinarTestar() throws ErroInternoException, ArquivoUtils.ArquivoNaoSalvoException, DadoInvalidoException, IOException {
        ArrayList<Tweet> lista = this.tableModel.getTweets();
        svm_model model = null;
        if (jCB_tipo_particao.getSelectedItem() == TipoParticaoDados.HOLDOUT) {
            model = treinoTesteHoldout(lista);
        } else if (jCB_tipo_particao.getSelectedItem() == TipoParticaoDados.STRATIFIED_K_FOLD_CROSS_VALIDATION) {
            model = treinoTesteStratified(lista, Integer.valueOf(jTF_K.getText()));
        }
        if (model != null) {
            int r = JOptionPane.showOptionDialog(null, "Deseja salvar o modelo com acurácia " + this.acuracia + "?", "Pergunta", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sim", "Não"}, 0);
            if (r == 0) {
                File dir = ArquivoUtils.selecionarDiretorio();
                svm.svm_save_model(dir.getAbsolutePath() + "\\modelo.model", model);
            }
        }
        this.dispose();
    }

    public svm_model treinoTesteStratified(ArrayList<Tweet> lista, int k) throws ErroInternoException {
        float oldAcerto = 0;
        svm_model model = null;
        ArrayList<Tweet> pos = new ArrayList<>();
        ArrayList<Tweet> neg = new ArrayList<>();
        for (Tweet tweet : lista) {
            if (tweet.getPolaridade() == Tweet.Polaridade.POSITIVA) {
                pos.add(tweet);
            } else {
                neg.add(tweet);
            }
        }
        List<List<Tweet>> partesPos = chopIntoParts(pos, k);
        List<List<Tweet>> partesNeg = chopIntoParts(neg, k);
        for (int i = 0; i < k; i++) {
            List<Tweet> treino = new ArrayList<>();
            List<List<Tweet>> partsPosTemp = new ArrayList<>(partesPos);
            partsPosTemp.remove(i);
            for (List<Tweet> partsPosTemp1 : partsPosTemp) {
                treino.addAll(partsPosTemp1);
            }
            List<List<Tweet>> partesNegTemp = new ArrayList<>(partesNeg);
            partesNegTemp.remove(i);
            for (List<Tweet> partesNegTemp1 : partesNegTemp) {
                treino.addAll(partesNegTemp1);
            }

            List<Tweet> teste = new ArrayList<>();
            List<Tweet> testePos = partesPos.get(i);
            List<Tweet> testeNeg = partesNeg.get(i);
            teste.addAll(testePos);
            teste.addAll(testeNeg);

            svm_parameter parameter = new svm_parameter();
            parameter.probability = 1;
            parameter.cache_size = treino.size();
            parameter.eps = 0.001;
            parameter.C = 1;
            svm_model modelo = ControladorTreino.treinar(parameter, treino);
            float acerto = ControladorDefineTreinoView.testarModelo(modelo, teste);
            if (acerto > oldAcerto) {
                model = modelo;
                oldAcerto = acerto;
            }
        }
        this.acuracia = oldAcerto;
        return model;
    }

    public static <T> List<List<T>> chopIntoParts(final List<T> ls, final int iParts) {
        final List<List<T>> lsParts = new ArrayList<List<T>>();
        final int iChunkSize = ls.size() / iParts;
        int iLeftOver = ls.size() % iParts;
        int iTake = iChunkSize;
        for (int i = 0, iT = ls.size(); i < iT; i += iTake) {
            if (iLeftOver > 0) {
                iLeftOver--;
                iTake = iChunkSize + 1;
            } else {
                iTake = iChunkSize;
            }
            lsParts.add(new ArrayList<T>(ls.subList(i, Math.min(iT, i + iTake))));
        }
        return lsParts;
    }

    public svm_model treinoTesteHoldout(ArrayList<Tweet> lista) throws ErroInternoException {
        ArrayList<Tweet> listaTreino = new ArrayList<>();
        ArrayList<Tweet> listaTeste = new ArrayList<>();
        int tamLista = lista.size();
        int tamTreino = (tamLista / 3) * 2;
        Collections.shuffle(lista);
        for (Tweet tweet : lista) {
            int indice = lista.indexOf(tweet);
            if (indice + 1 <= tamTreino) {
                listaTreino.add(tweet);
            } else {
                listaTeste.add(tweet);
            }
        }
        svm_parameter parameter = new svm_parameter();
        parameter.probability = 1;
        parameter.cache_size = listaTreino.size();
        parameter.eps = 0.001;
        parameter.C = 1;
        File dir = ArquivoUtils.selecionarDiretorio();
        svm_model modelo = ControladorTreino.treinar(parameter, listaTreino, dir.getParent());
        this.acuracia = ControladorDefineTreinoView.testarModelo(modelo, listaTeste);
        return modelo;
    }

    private void setarTableModel() {
        this.tableModel = new TableModelDefineConjuntoTreino(this.jTDefineTreino);
        this.jTDefineTreino.setModel(this.tableModel);
        this.jTDefineTreino.getColumnModel().getColumn(0).setPreferredWidth(1000);
        this.jTDefineTreino.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.jTDefineTreino.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void selecionarTodos(boolean selected) {
        tableModel.getTweetsTreino().stream().forEach((t) -> {
            t.setTreino(selected);
        });
        tableModel.fireTableDataChanged();
    }

    private void setarCombo() {
        for (utilitarios.TipoParticaoDados tipoParticao : TipoParticaoDados.values()) {
            jCB_tipo_particao.addItem(tipoParticao);
        }
    }
}