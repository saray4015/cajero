import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
public class Cajero extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Cajero.class.getName());
    
    private HashMap<Integer, Integer> billetes = new HashMap<>();
    private String textoIngresado = "";
    private DefaultTableModel modeloTabla;
    
    public Cajero() {
        
        initComponents();
        billetes.put(10000, 100);
        billetes.put(20000, 100);
        billetes.put(50000, 100);
        billetes.put(100000, 100);

        modeloTabla = new DefaultTableModel(new String[]{"Denominación", "Disponibles", "Total Dinero"}, 0);
        jTable2.setModel(modeloTabla);
        actualizarTabla();
    }
    private void actualizarTabla() {
        modeloTabla.setRowCount(0);
        int[] denominaciones = {100000, 50000, 20000, 10000};
        
        for (int d : denominaciones) {
            int cantidad = billetes.get(d);
            long total = (long) d * cantidad;
            modeloTabla.addRow(new Object[]{String.format("$%,d", d), cantidad, String.format("$%,d", total)});
        }
    }
    private void manejarDigito(String digito) {
        if (!digito.matches("[0-9]")) {
            return;
        }
        if (textoIngresado.length() >= 7) {
            txtPantalla.setText("AVISO: Límite máximo alcanzado.");
            return;
        }
        textoIngresado += digito;
        txtPantalla.setText(textoIngresado);
    }

    private void limpiarPantalla() {
        textoIngresado = "";
        txtPantalla.setText("");
    }

    private void retroceso() {
        if (textoIngresado.length() > 0) {
            textoIngresado = textoIngresado.substring(0, textoIngresado.length() - 1);
            txtPantalla.setText(textoIngresado);
        }
    }
    private void retirarDinero() {
        if (textoIngresado.equals("")) {
            txtPantalla.setText("Ingrese un monto");
            return;
        }
        
        int monto = Integer.parseInt(textoIngresado);
        
        if (monto % 10000 != 0) {
            txtPantalla.setText("El monto debe ser múltiplo de 10000");  // se verifica que sea múltiplo de 10000
            return;
        }
        
        int b100 = billetes.get(100000);
        int b50 = billetes.get(50000);    //Se saca cuántos billetes hay en el inventario actual usando la variable billetes
        int b20 = billetes.get(20000);
        int b10 = billetes.get(10000);
        
        int aux = monto;
        
        int usar100 = aux / 100000;     //para ver cuántos billetes de 100 mil necesito y se pueden usar
        if (usar100 > b100) {    
            usar100 = b100;
        }
        aux = aux - (usar100 * 100000);
        
        int usar50 = aux / 50000;      //para ver cuántos billetes de 50 mil hay
        if (usar50 > b50) {
            usar50 = b50;
        }
        aux = aux - (usar50 * 50000);
        
        int usar20 = aux / 20000;     //para ver cuántos billetes de 20 mil hay
        if (usar20 > b20) {
            usar20 = b20;
        }
        aux = aux - (usar20 * 20000);
        
        int usar10 = aux / 10000;
        if (usar10 > b10) {
            usar10 = b10;
        }
        aux = aux - (usar10 * 10000);
        
        if (aux > 0) {          //Si sobra dinero es porque no se completa con los billetes que hay
            txtPantalla.setText("No hay suficientes billetes");
            return;
        }
        
        billetes.put(100000, b100 - usar100);      //es para restar los billetes del inventario real
        billetes.put(50000, b50 - usar50);
        billetes.put(20000, b20 - usar20);
        billetes.put(10000, b10 - usar10);
        
        actualizarTabla();       //para actualizar la tabla y que se vea el cambio
        
        txtPantalla.setText("Retiro exitoso: $" + monto);
        textoIngresado = "";
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPantalla = new javax.swing.JTextArea();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnRetroceso = new javax.swing.JButton();
        btnRetirar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtPantalla.setColumns(20);
        txtPantalla.setRows(5);
        jScrollPane2.setViewportView(txtPantalla);

        btn0.setText("0");
        btn0.addActionListener(this::btn0ActionPerformed);

        btn1.setText("1");
        btn1.addActionListener(this::btn1ActionPerformed);

        btn2.setText("2");
        btn2.addActionListener(this::btn2ActionPerformed);

        btn3.setText("3");
        btn3.addActionListener(this::btn3ActionPerformed);

        btn4.setText("4");
        btn4.addActionListener(this::btn4ActionPerformed);

        btn5.setText("5");
        btn5.addActionListener(this::btn5ActionPerformed);

        btn6.setText("6");
        btn6.addActionListener(this::btn6ActionPerformed);

        btn7.setText("7");
        btn7.addActionListener(this::btn7ActionPerformed);

        btn8.setText("8");
        btn8.addActionListener(this::btn8ActionPerformed);

        btn9.setText("9");
        btn9.addActionListener(this::btn9ActionPerformed);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        btnRetroceso.setText("Retroceso");
        btnRetroceso.addActionListener(this::btnRetrocesoActionPerformed);

        btnRetirar.setText("Retirar");
        btnRetirar.addActionListener(this::btnRetirarActionPerformed);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRetroceso)
                        .addGap(212, 212, 212)
                        .addComponent(btnLimpiar)
                        .addGap(117, 117, 117))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRetirar)
                        .addGap(259, 259, 259))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(btn2)
                    .addComponent(btn3))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4)
                    .addComponent(btn5)
                    .addComponent(btn6))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7)
                    .addComponent(btn8)
                    .addComponent(btn9))
                .addGap(35, 35, 35)
                .addComponent(btn0)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRetroceso)
                    .addComponent(btnLimpiar))
                .addGap(39, 39, 39)
                .addComponent(btnRetirar)
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
    manejarDigito("0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
    manejarDigito("1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
    manejarDigito("2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
    manejarDigito("3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
    manejarDigito("4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
    manejarDigito("5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
    manejarDigito("6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
    manejarDigito("7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
    manejarDigito("8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
    manejarDigito("9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnRetrocesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetrocesoActionPerformed
    retroceso();
    }//GEN-LAST:event_btnRetrocesoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    limpiarPantalla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
    retirarDinero();
    }//GEN-LAST:event_btnRetirarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Cajero().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JButton btnRetroceso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea txtPantalla;
    // End of variables declaration//GEN-END:variables
}
