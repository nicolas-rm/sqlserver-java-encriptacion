/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Sesion;
import Logico.SesionLog;
import ModeloTabla.ModeloTablaPersona;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Aniquila
 */
public class Registro extends javax.swing.JFrame {

    SesionLog personas;
    Sesion per;

    public Registro() {
        initComponents();
        personas = new SesionLog();
        ListarTabla();
    }

    private void ListarTabla() {
//        List<Persona> listas = personas.listado();
//        jTable1.setModel(new ModeloTablaPersona(listas));
//        jTable1.getRowSorter();
    }

    public void Limpiar() {
        jTextField1.setText("");
        jTextField2.setText("");
//        jTextField3.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        JB_aGREGAR = new javax.swing.JButton();
        JB_Eleminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("USUARIO");

        jLabel2.setText("CONTRASEÑA");

        JB_aGREGAR.setText("Agregar");
        JB_aGREGAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_aGREGARActionPerformed(evt);
            }
        });

        JB_Eleminar.setText("Regresar");
        JB_Eleminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EleminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                    .addComponent(JB_aGREGAR, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(JB_Eleminar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 86, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_aGREGAR)
                    .addComponent(JB_Eleminar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_aGREGARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_aGREGARActionPerformed
        Sesion person = new Sesion(jTextField1.getText(), jTextField2.getText(), "0");
        System.out.println("USER: " + jTextField1.getText());
        System.out.println("CONTRASEÑA : " + DigestUtils.sha512Hex(jTextField2.getText()));
//        System.out.println("ESTATUS : " + jTextField1.getText());
        boolean resp = personas.AgregarPass(person);
        if (resp == false) {
            JOptionPane.showMessageDialog(null, "Dato Agregdo");
            ListarTabla();
            Limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Dato no Agregdo");
        }
    }//GEN-LAST:event_JB_aGREGARActionPerformed

    private void JB_EleminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EleminarActionPerformed
        super.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_JB_EleminarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Eleminar;
    private javax.swing.JButton JB_aGREGAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
