/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoClient;

import java.awt.Color;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zero
 */
public class PusatForm extends javax.swing.JFrame {

    Pusat c;
    ConDB test;
    public String target;

    /**
     * Creates new form clientSide
     */
    public PusatForm() {
        initComponents();
        setTitle("Resto Pusat");
        test = new ConDB("localhost", "resto_pusat", "root", "");
    }

    public String getTarget() {
        return this.target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    public void cekSinkronisasi(){
        String respon = "";

        try {
            respon = this.c.getSinkronisasi();
        } catch (RemoteException ex) {
            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        String buka[] = respon.trim().split("<<<");

        int p = Integer.parseInt(buka[0]);
        int q = Integer.parseInt(buka[1]);

        Schmidt_Samoa satpam = new Schmidt_Samoa(p, q);

        if (buka.length < 3) {

            System.out.println("null");

        } else {

            String plaintext = satpam.decrypt(buka[2]);
            System.out.println(plaintext);

            String pecah[] = plaintext.trim().split("<<");
            //        System.out.println(Arrays.asList(pecah));

            DefaultTableModel model = (DefaultTableModel) tableTrans.getModel();
            model.getDataVector().removeAllElements();
            revalidate();
            for (int i = 0; i < pecah.length; i++) {
                String pecah2[] = pecah[i].trim().split("<");
                int id = Integer.parseInt(pecah2[0]);
                String barang = pecah2[1];
                int jumlah = Integer.parseInt(pecah2[2]);
                int harga = Integer.parseInt(pecah2[3]);
                String tanggal = pecah2[4];
                String ip = pecah2[5];
                //            int parseInt = Integer.parseInt(harga);

                test.setSinkronisasi(id, barang, jumlah, harga, tanggal, ip);

                System.out.println(Arrays.toString(pecah));

            }
        }

        sinLabel.setText("Tersinkronisasi");
        sinLabel.setForeground(Color.pink);
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
        jTextArea1 = new javax.swing.JTextArea();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jFrame4 = new javax.swing.JFrame();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        targetTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        targetBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        golekBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableTrans = new javax.swing.JTable();
        labelTotalHarga = new javax.swing.JLabel();
        datePicker = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        sinBtn = new javax.swing.JButton();
        sinLabel = new javax.swing.JLabel();
        statusKoneksi = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restoApp.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(612, 392));

        targetTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        targetTF.setText("127.0.0.1");
        targetTF.setBorder(null);
        targetTF.setMargin(new java.awt.Insets(2, 10, 2, 2));
        targetTF.setMinimumSize(new java.awt.Dimension(130, 20));
        targetTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetTFActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Aharoni", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Masukan IP Cabang");

        jLabel3.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selamat Datang Admin Pusat");

        targetBtn.setBackground(new java.awt.Color(153, 153, 255));
        targetBtn.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        targetBtn.setText("Mulai");
        targetBtn.setBorder(null);
        targetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                targetBtnMouseClicked(evt);
            }
        });
        targetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetBtnActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restoApp.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(59, 59, 59))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(targetTF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(targetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(267, 267, 267))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(targetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(targetTF, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, "card3");

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        golekBtn.setBackground(new java.awt.Color(153, 153, 255));
        golekBtn.setText("Cek");
        golekBtn.setBorder(null);
        golekBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                golekBtnMouseClicked(evt);
            }
        });
        golekBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                golekBtnActionPerformed(evt);
            }
        });

        tableTrans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Barang", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableTrans);
        if (tableTrans.getColumnModel().getColumnCount() > 0) {
            tableTrans.getColumnModel().getColumn(0).setMinWidth(30);
            tableTrans.getColumnModel().getColumn(0).setMaxWidth(30);
            tableTrans.getColumnModel().getColumn(1).setMinWidth(120);
            tableTrans.getColumnModel().getColumn(2).setMinWidth(50);
            tableTrans.getColumnModel().getColumn(2).setMaxWidth(100);
            tableTrans.getColumnModel().getColumn(3).setMinWidth(120);
        }

        labelTotalHarga.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalHarga.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalHarga.setText("0");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Harga :");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        sinBtn.setText("Sinkronisasi");
        sinBtn.setBorder(null);
        sinBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sinBtnMouseClicked(evt);
            }
        });
        sinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinBtnActionPerformed(evt);
            }
        });

        sinLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sinLabel.setForeground(new java.awt.Color(255, 0, 0));
        sinLabel.setText("Tidak Tersinkronisasi");

        statusKoneksi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusKoneksi.setForeground(new java.awt.Color(255, 0, 0));
        statusKoneksi.setText("Pusat tidak terhubung");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/restoApp.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sinLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusKoneksi, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sinBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusKoneksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sinLabel)
                .addGap(26, 26, 26))
        );

        jLabel5.setFont(new java.awt.Font("Aharoni", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pilih Tanggal");

        jLabel7.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cek Transaksi");

        backBtn.setText("Kembali");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(golekBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(backBtn)
                                    .addGap(196, 196, 196)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(114, 114, 114)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(golekBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalHarga))
                .addGap(33, 33, 33))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

//        String targetN[] = {
//            "resto",
//            "resto2",
//            "resto3"};
//        targetName.setModel(new DefaultComboBoxModel(targetN));
//        String targetA[] = {
//            "127.0.0.1",
//            "192.168.173.1",
//            "192.168.173.185",
//            "192.168.173.65"};
//        targetAdd.setModel(new DefaultComboBoxModel(targetA));
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");
//        final Date startDate = new Date( 0 );
//        format.set2DigitYearStart( startDate );

        datePicker.setFormats(format);
//        Pusat pusat;
//        try {
//            c = new Pusat();
//        } catch (RemoteException ex) {
//            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NotBoundException ex) {
//            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_formWindowOpened

    private void targetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_targetBtnMouseClicked
        // TODO add your handling code here:
//        String target = textTarget.getText();
        String targetInput = targetTF.getText();
        String target = targetInput + ":1010/resto";

        try {
            this.c = new Pusat(target);
            statusKoneksi.setText("Terhubung dengan " + targetInput);
            statusKoneksi.setForeground(Color.PINK);
            setTarget(targetInput);
        } catch (RemoteException ex) {
            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
        cekSinkronisasi();

    }//GEN-LAST:event_targetBtnMouseClicked

    private void targetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_targetBtnActionPerformed

    private void targetTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_targetTFActionPerformed

    private void sinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sinBtnActionPerformed

    private void sinBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinBtnMouseClicked
        cekSinkronisasi();
    }//GEN-LAST:event_sinBtnMouseClicked

    private void golekBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_golekBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_golekBtnActionPerformed

    private void golekBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_golekBtnMouseClicked

        //        UMPAN RESPON
        //        String respon = "";
        int totalHarga = 0;
        Date tanggal = datePicker.getDate();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy");
        String umpan = df.format(tanggal);

        String target = getTarget();

        String respon = test.getTrans(umpan, target);

        //        try {
            //            //            MENGISI RESPON DENGAN NILAI CEKTRANSAKSI DARI CLASS CLIENT DENGAN PAR TANGGAL
            //            respon = this.c.cekTransaksi(umpan);
            //        } catch (RemoteException ex) {
            //            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
            //        } catch (NotBoundException ex) {
            //            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
            //        } catch (MalformedURLException ex) {
            //            Logger.getLogger(PusatForm.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        DefaultTableModel model = (DefaultTableModel) tableTrans.getModel();
        model.getDataVector().removeAllElements();
        revalidate();

        if (respon.isEmpty()) {
            System.out.println("null");

            Object[] row = {null, "kosong...", null, null};

            model.addRow(row);
            labelTotalHarga.setText(totalHarga + "0");
        } else {
            int no = 0;
            String pecah[] = respon.trim().split("<<");
            //        System.out.println(Arrays.asList(pecah));

            for (int i = 0; i < pecah.length; i++) {
                no++;
                String pecah2[] = pecah[i].trim().split("<");
                String id = pecah2[0];
                String barang = pecah2[1];
                String jumlah = pecah2[2];
                String harga = pecah2[3];
                int parseInt = Integer.parseInt(harga);
                totalHarga += parseInt;

                Object[] row = {no, barang, jumlah, harga};

                model.addRow(row);
            }
            labelTotalHarga.setText(totalHarga + "");
        }
    }//GEN-LAST:event_golekBtnMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PusatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PusatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PusatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PusatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            public void run() {
                new PusatForm().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private org.jdesktop.swingx.JXDatePicker datePicker;
    private javax.swing.JButton golekBtn;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelTotalHarga;
    private javax.swing.JButton sinBtn;
    private javax.swing.JLabel sinLabel;
    private javax.swing.JLabel statusKoneksi;
    private javax.swing.JTable tableTrans;
    private javax.swing.JButton targetBtn;
    private javax.swing.JTextField targetTF;
    // End of variables declaration//GEN-END:variables
}
