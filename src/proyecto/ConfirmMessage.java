/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Edu
 */
public class ConfirmMessage extends javax.swing.JFrame {

    private String dia;
    private String hora;
    private String dni;
    private String ID;
    private EditorAlumno EA;
    private ViewerClaseSemanal VCS;
    private EditorClaseSemanal ECS;
    private ConfirmType type;
    private final DBConnection dbconn;
    
    /**
     * Creates new form ConfirmMessage
     */
    public ConfirmMessage() {
        initComponents();
        dbconn = new DBConnection();
    }
    
    public void setDNI(String dni){
        this.dni = dni;
    }
    
    public void setEA(EditorAlumno EA){
        this.EA = EA;
    }
    
    public void setVCS(ViewerClaseSemanal VCS){
        this.VCS = VCS;
    }
    
    public void setECS(EditorClaseSemanal ECS){
        this.ECS = ECS;
    }

    public void setClase(String dia, String hora){
        this.dia = dia;
        this.hora = hora;
    }
    
    public void setType(ConfirmType type){
        this.type = type;
    }
    
    public void setIDClase(String ID){
        this.ID = ID;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        question = new javax.swing.JLabel();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        question.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("Esta seguro que desea eliminarlo?");

        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(question)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(question, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        switch (type) {
            case alumno:{
                String statement = "DELETE FROM `alumnos` WHERE `alumnos`.`DNI` = " + dni;
                dbconn.modificationStatement(statement);
                dispose();
                EA.dispose();
                PopupMessage pum = new PopupMessage(PopupType.A_ELIMINADO);
                pum.setVisible(true);
                    break;
                }
            case clase:{
                String statement = "DELETE FROM `clasesemanal` WHERE `clasesemanal`.`hora` = '" + hora + "' AND `clasesemanal`.`diasemana` = '" + dia + "'";
                dbconn.modificationStatement(statement);
                dispose();
                VCS.dispose();
                ECS.dispose();
                PopupMessage pum = new PopupMessage(PopupType.C_ELIMINADA);
                pum.setVisible(true);
                    break;
                }
            case clasealumno:
                String statement = "DELETE FROM `clasesalumnos` WHERE `dni_alumno` = '" + dni + "' AND `id_clase` = '" + ID + "'";
                dbconn.modificationStatement(statement);
                dispose();
                EA.eliminarClase(ID);
                break;
        }
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main2(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConfirmMessage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel question;
    // End of variables declaration//GEN-END:variables
}
