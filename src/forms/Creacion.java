/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Element;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import java.nio.charset.StandardCharsets;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

/**
 *
 * @author willi
 */
public class Creacion extends javax.swing.JFrame {

    private static JTextArea textArea;
    private static JTextArea lines;
    private JScrollPane jsp;
    private static JTextArea textArea2;
    private static JTextPane textPane;
    private static JTextArea textArea3;
    private static JTextArea textArea4;
    private static JTextPane textPane2;
    private static JTextArea lines2;
    private JScrollPane jsp2;
    private JScrollPane jsp3;
    private JScrollPane jsp4;
    private String logeado;

    /**
     * Creates new form Creacion
     */
    public Creacion() {
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        logeado = "";
        jsp = new JScrollPane();
        textArea = new JTextArea();
        TextLineNumber tln = new TextLineNumber(textArea);
        tln.setBorderGap(1);
        tln.setBackground(Color.BLACK);
        tln.setForeground(Color.WHITE);
        tln.setCurrentLineForeground(Color.YELLOW);
        textArea.setBackground(new Color(97, 97, 97));
        jsp.getViewport().add(textArea);
        jsp.setBorder(null);
        jsp.setRowHeaderView(tln);
        jsp.setBounds(0, 0, pan1.getWidth(), pan1.getHeight());
        pan1.add(jsp);
        jtab.setEnabledAt(2, false);
        jtab.setEnabledAt(1, false);
        jsp3 = new JScrollPane();
        textArea3 = new JTextArea();
        TextLineNumber tln3 = new TextLineNumber(textArea3);
        tln3.setBorderGap(1);
        tln3.setBackground(Color.BLACK);
        tln3.setForeground(Color.WHITE);
        tln3.setCurrentLineForeground(Color.YELLOW);
        textArea3.setBackground(new Color(97, 97, 97));
        jsp3.getViewport().add(textArea3);
        jsp3.setBorder(null);
        jsp3.setRowHeaderView(tln3);
        jsp3.setBounds(0, 0, panel3.getWidth(), panel3.getHeight());
        panel3.add(jsp3);

        jsp2 = new JScrollPane();
        textArea2 = new JTextArea();
        textArea2.setBackground(new Color(97, 97, 97));
        textPane = new JTextPane();
        textPane.setOpaque(false);
        textPane.setBackground(new Color(97, 97, 97));
        jsp2.getViewport().add(textArea2);
        TextLineNumber tln2 = new TextLineNumber(textArea2);
        tln2.setBorderGap(1);
        tln2.setBackground(Color.BLACK);
        tln2.setForeground(Color.WHITE);
        tln2.setCurrentLineForeground(Color.YELLOW);
        jsp2.setRowHeaderView(tln2);
        jsp2.setBorder(null);
        jsp2.setBounds(0, 0, pan2.getWidth(), pan2.getHeight());
        pan2.add(jsp2);
        pan2.setBackground(new Color(97, 97, 97));

        jsp4 = new JScrollPane();
        textArea4 = new JTextArea();
        textArea4.setBackground(new Color(97, 97, 97));
        textPane2 = new JTextPane();
        textPane2.setOpaque(false);
        textPane2.setBackground(new Color(97, 97, 97));
        jsp4.getViewport().add(textArea4);
        TextLineNumber tln4 = new TextLineNumber(textArea4);
        tln4.setBorderGap(1);
        tln4.setBackground(Color.BLACK);
        tln4.setForeground(Color.WHITE);
        tln4.setCurrentLineForeground(Color.YELLOW);
        jsp4.setRowHeaderView(tln4);
        jsp4.setBorder(null);
        jsp4.setBounds(0, 0, panel4.getWidth(), panel4.getHeight());
        panel4.add(jsp4);
        panel4.setBackground(new Color(97, 97, 97));

        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jlabel_path = new javax.swing.JLabel();
        pan1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        panel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pan2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formularios");
        setBackground(new java.awt.Color(25, 25, 25));
        setMinimumSize(new java.awt.Dimension(620, 510));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jtab.setBackground(new java.awt.Color(25, 25, 25));
        jtab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel1.setBackground(new java.awt.Color(25, 25, 25));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(216, 255, 144));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AREA DE INGRESO DE SOLICITUDES");

        btn_cargar.setBackground(new java.awt.Color(25, 25, 25));
        btn_cargar.setForeground(new java.awt.Color(216, 255, 144));
        btn_cargar.setText("<html>CARGAR<br>ARCHIVO</html>");
        btn_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarActionPerformed(evt);
            }
        });

        btn_limpiar.setBackground(new java.awt.Color(25, 25, 25));
        btn_limpiar.setForeground(new java.awt.Color(216, 255, 144));
        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.setEnabled(false);
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jlabel_path.setForeground(new java.awt.Color(216, 255, 144));
        jlabel_path.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel_path.setText("-");

        pan1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pan1ComponentResized(evt);
            }
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pan1ComponentShown(evt);
            }
        });

        javax.swing.GroupLayout pan1Layout = new javax.swing.GroupLayout(pan1);
        pan1.setLayout(pan1Layout);
        pan1Layout.setHorizontalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pan1Layout.setVerticalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(25, 25, 25));
        jButton1.setForeground(new java.awt.Color(216, 255, 144));
        jButton1.setText("ENVIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(25, 25, 25));
        btn_login.setForeground(new java.awt.Color(255, 0, 0));
        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/offrz.png"))); // NOI18N
        btn_login.setText("<html>SIN<br>LOGIN</html>");
        btn_login.setContentAreaFilled(false);
        btn_login.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/img/offrz.png"))); // NOI18N
        btn_login.setEnabled(false);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_limpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_cargar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_login, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(jlabel_path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_path, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))))
        );

        jtab.addTab("AREA SOLICITUDES", jPanel1);

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AREA DE INGRESO DE CONSULTAS");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 206, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AREA DE RESPUESTA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtab.addTab("AREA CONSULTAS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(25, 25, 25));

        javax.swing.GroupLayout pan2Layout = new javax.swing.GroupLayout(pan2);
        pan2.setLayout(pan2Layout);
        pan2Layout.setHorizontalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pan2Layout.setVerticalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 255, 144));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RESPUESTA DEL SERVIDOR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtab.addTab("AREA RESPUESTA", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtab, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        textArea.setText("");
        jlabel_path.setText("");
        btn_limpiar.setEnabled(false);
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("Archivos de texto", "txt");
        chooser.setFileFilter(filtro2);
        int resultado = chooser.showOpenDialog(this);
        if (resultado == 0) {
            File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
            String path = chooser.getSelectedFile().getAbsolutePath();
            String nuevo = path;
            jlabel_path.setText("Archivo cargado: " + nuevo);
            String ST;
            try {
                ST = new String(Files.readAllBytes(archivo.toPath()));
                textArea.setText(ST);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            btn_limpiar.setEnabled(true);
        } else {
            jlabel_path.setText("");
            btn_limpiar.setEnabled(false);
        }
    }//GEN-LAST:event_btn_cargarActionPerformed

    private void pan1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pan1ComponentResized
        jsp.setBounds(0, 0, pan1.getWidth(), pan1.getHeight());
    }//GEN-LAST:event_pan1ComponentResized

    private void pan1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pan1ComponentShown
        jsp.setBounds(0, 0, pan1.getWidth(), pan1.getHeight());
    }//GEN-LAST:event_pan1ComponentShown

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jsp.setBounds(0, 0, pan1.getWidth(), pan1.getHeight());
        jsp2.setBounds(0, 0, pan2.getWidth(), pan2.getHeight());
        String txt1 = textArea.getText();
        String txt2 = textArea2.getText();
        textArea.setEditable(false);
        textArea2.setEditable(false);
        textArea.setEditable(true);
        textArea2.setEditable(true);
    }//GEN-LAST:event_formComponentResized

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            comunicacionServidor();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        setLogeado("");
        btn_login.setText("<html><font color=red>SIN</font><br><font color =red>LOGIN</font></html>");
        btn_login.setEnabled(false);
        btn_login.setContentAreaFilled(false);
        btn_login.setIcon(new ImageIcon("C:\\Users\\willi\\OneDrive\\Documentos\\NetBeansProjects\\Forms\\src\\img\\offrz.png"));
    }//GEN-LAST:event_btn_loginActionPerformed

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
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Creacion().setVisible(true);
            }
        });
    }

    public void comunicacionServidor() throws Exception {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpPost httppost = new HttpPost("http://localhost:8080/WForms/Creacion");
            List<NameValuePair> params = new ArrayList<>(2);

            String texto = textArea.getText();
            //posicionar(10,18);
            params.add(new BasicNameValuePair("entrada", texto));
            params.add(new BasicNameValuePair("usuario", getLogeado()));
            httppost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
            System.out.println("Executing request " + httppost.getMethod() + " " + httppost.getUri());
            try (final CloseableHttpResponse response = httpclient.execute(httppost)) {
                System.out.println("----------------------------------------");
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                String respuesta = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                Gson gson = new Gson();
                Map<String, String> map = gson.fromJson(respuesta, Map.class);
                if (!map.containsKey("ERROR")) {
                    textArea2.setText(map.get("respuesta"));
                    jtab.setSelectedIndex(2);
                    jtab.setEnabledAt(1, true);
                    jtab.setEnabledAt(2, true);
                    setLogeado(map.get("usuario"));
                    btn_login.setText("<html><span style=\"color: #D8FF90; font-size: 7px;\">CERRAR</span><br><span style=\"color: #D8FF90; font-size: 7px;\">SESION</span></html>");
                    btn_login.setEnabled(true);
                    btn_login.setContentAreaFilled(true);
                    btn_login.setIcon(new ImageIcon("C:\\Users\\willi\\OneDrive\\Documentos\\NetBeansProjects\\Forms\\src\\img\\onrz.png"));
                } else {
                    JOptionPane.showMessageDialog(null, map.get("ERROR"));
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void posicionar(int linea, int columna) {
        String texto = textArea.getText();
        String[] lineas1 = texto.split("\n");
        int[] cuantos = new int[lineas1.length];
        for (int i = 0; i < lineas1.length; i++) {
            cuantos[i] = lineas1[i].length();
        }
        int donde = 0;
        for (int i = 0; i < (linea-1); i++) {
            donde += cuantos[i]+1;
        }
        donde += (columna-1);
        textArea.setCaretPosition(donde);
    }

    public String getLogeado() {
        return logeado;
    }

    public void setLogeado(String logeado) {
        this.logeado = logeado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlabel_path;
    private javax.swing.JTabbedPane jtab;
    private javax.swing.JPanel pan1;
    private javax.swing.JPanel pan2;
    private javax.swing.JPanel panel3;
    private javax.swing.JPanel panel4;
    // End of variables declaration//GEN-END:variables
}
