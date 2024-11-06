package tampilan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import kelas.category;
import kelas.Product;


public class fremeProduct extends javax.swing.JFrame {

    
    public fremeProduct() {
        initComponents();
        loadTabel();
        comboCategory();
        otoID();
        reset();

    }

    void loadTabel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Deskripsi");
        model.addColumn("Harga");
        model.addColumn("Kategori");

        try {
            Product prod = new Product();
            ResultSet data = prod.tampilProduct();

            while (data.next()) {
                model.addRow(new Object[]{
                    data.getString("product_id"),
                    data.getString("product_name"),
                    data.getString("product_desc"),
                    data.getString("product_price"),
                    data.getString("category_name"),});

            }

        } catch (SQLException sQLException) {
        }

        tProduct.setModel(model);

    }

    void comboCategory() {
        try {
            category cat = new category();
            ResultSet data = cat.tampilComboBox();

            while (data.next()) {
                String isi = data.getString("category_name");
                jCat.addItem(isi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(fremeProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void otoID() {
        try {
            Product prod = new Product();
            ResultSet id = prod.otoID();

            if (id.next()) {
                int auto = id.getInt("product_id") + 1;
                jId.setText(String.valueOf(auto));

            } else {
                jId.setText("1");
            }
            jId.setEditable(false);

        } catch (SQLException sQLException) {
        }

    }

    void reset() {

        otoID();
        jName.setText(null);
        jDesc.setText(null);
        jPrice.setText(null);
        jCat.setSelectedItem(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jId = new javax.swing.JTextField();
        jName = new javax.swing.JTextField();
        jDesc = new javax.swing.JTextField();
        jPrice = new javax.swing.JTextField();
        jCat = new javax.swing.JComboBox<>();
        bTambah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 3, 18)); // NOI18N
        jLabel1.setText("PRODUCT");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel2.setText("ID");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel7.setText("Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel8.setText("Desc");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel9.setText("Price");

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jLabel10.setText("Cat ID");

        jName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNameActionPerformed(evt);
            }
        });

        jPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPriceActionPerformed(evt);
            }
        });

        jCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCatActionPerformed(evt);
            }
        });

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        tProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        tProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tProduct);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bTambah)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel10)
                                .addComponent(jLabel2)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jName, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addComponent(jDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addComponent(jPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                .addComponent(jCat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bHapus)
                                .addGap(59, 59, 59)
                                .addComponent(bUbah)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bTambah)
                            .addComponent(bHapus)
                            .addComponent(bUbah)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        try {
            Product prod = new Product();
            category cat = new category();
            prod.setProduct_id(Integer.parseInt(jId.getText()));
            prod.setProduct_name(jName.getText());
            prod.setProduct_desc(jDesc.getText());
            prod.setProduct_price(Integer.parseInt(jPrice.getText()));
            String selectedCategory = (String) jCat.getSelectedItem();
            cat.setCategory_name(jCat.getSelectedItem().toString());
            ResultSet data = cat.Konversi();

            if (data.next()) {
                String isi = data.getString("category_id");
                prod.setProduct_cat_id(Integer.parseInt(isi));
            }

            prod.tambahProduct();
        } catch (SQLException sQLException) {
            System.out.println("Data tidak masuk");
        }
        loadTabel();
        reset();
    }//GEN-LAST:event_bTambahActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        try {
            Product Prod = new Product();
            Prod.setProduct_id(Integer.parseInt(jId.getText()));
            Prod.hapusProduct();
        } catch (SQLException sQLException) {
        }
        loadTabel();
        reset();

    }//GEN-LAST:event_bHapusActionPerformed

    private void tProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tProductMouseClicked
        // TODO add your handling code here:
        int baris = tProduct.rowAtPoint(evt.getPoint());
        String productID = tProduct.getValueAt(baris, 0).toString();
        String productName = tProduct.getValueAt(baris, 1).toString();
        String productDesc = tProduct.getValueAt(baris, 2).toString();
        String productPrice = tProduct.getValueAt(baris, 3).toString();
        String productCat = tProduct.getValueAt(baris, 4).toString();

        jId.setText(productID);
        jId.setEditable(false);
        jName.setText(productName);
        jDesc.setText(productDesc);
        jPrice.setText(productPrice);
        jCat.setSelectedItem(productCat);
    }//GEN-LAST:event_tProductMouseClicked

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
        // TODO add your handling code here:
        try {
            Product prod = new Product();
            category cat = new category();

            prod.setProduct_id(Integer.parseInt(jId.getText()));
            prod.setProduct_name(jName.getText());
            prod.setProduct_desc(jDesc.getText());
            prod.setProduct_price(Integer.parseInt(jPrice.getText()));

            cat.setCategory_name(jCat.getSelectedItem().toString());
            ResultSet data = cat.Konversi();

            if (data.next()) {
                String isi = data.getString("category_id");
                prod.setProduct_id(Integer.parseInt(isi));
            }

            prod.ubahProduct();
        } catch (SQLException sQLException) {
            System.out.println("data tidak masuk");
        }

        loadTabel();
        reset();

    }//GEN-LAST:event_bUbahActionPerformed

    private void jCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCatActionPerformed

    private void jPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPriceActionPerformed

    private void jNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNameActionPerformed

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
            java.util.logging.Logger.getLogger(fremeProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fremeProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fremeProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fremeProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fremeProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUbah;
    private javax.swing.JComboBox<String> jCat;
    private javax.swing.JTextField jDesc;
    private javax.swing.JTextField jId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jName;
    private javax.swing.JTextField jPrice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tProduct;
    // End of variables declaration//GEN-END:variables
}
