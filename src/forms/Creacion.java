/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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

/**
 *
 * @author willi
 */
public class Creacion extends javax.swing.JFrame {

    private static JTextArea textArea;
    private static JTextArea lines;
    private JScrollPane jsp;
    private static JTextArea textArea2;
    private static JTextArea lines2;
    private JScrollPane jsp2;
    private String usuario_logeado;

    /**
     * Creates new form Creacion
     */
    public Creacion() {
        initComponents();
        usuario_logeado = "";
        jsp = new JScrollPane();
        textArea = new JTextArea();
        lines = new JTextArea("1");
        lines.setBackground(Color.LIGHT_GRAY);
        lines.setEditable(false);
        //  Code to implement line numbers inside the JTextArea
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public String getText() {
                int caretPosition = textArea.getDocument().getLength();
                Element root = textArea.getDocument().getDefaultRootElement();
                String text = "1" + System.getProperty("line.separator");
                for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                    text += i + System.getProperty("line.separator");
                }
                return text;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }

            @Override
            public void insertUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                lines.setText(getText());
            }

        });
        jsp.getViewport().add(textArea);
        jsp.setRowHeaderView(lines);
        jsp.setBounds(0, 0, pan1.getWidth(), pan1.getHeight());

        jsp2 = new JScrollPane();
        textArea2 = new JTextArea();
        lines2 = new JTextArea("1");
        lines2.setBackground(Color.LIGHT_GRAY);
        lines2.setEditable(false);
        //  Code to implement line numbers inside the JTextArea
        textArea2.getDocument().addDocumentListener(new DocumentListener() {
            public String getText() {
                int caretPosition = textArea2.getDocument().getLength();
                Element root = textArea2.getDocument().getDefaultRootElement();
                String text = "1" + System.getProperty("line.separator");
                for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                    text += i + System.getProperty("line.separator");
                }
                return text;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }

            @Override
            public void insertUpdate(DocumentEvent de) {
                lines2.setText(getText());
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                lines2.setText(getText());
            }

        });
        jsp2.getViewport().add(textArea2);
        jsp2.setRowHeaderView(lines2);
        jsp2.setBounds(0, 0, pan2.getWidth(), pan2.getHeight());
        pan2.add(jsp2);
        pan1.add(jsp);
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

        pan1 = new javax.swing.JPanel();
        pan2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_cargar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jlabel_path = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formularios");
        setMinimumSize(new java.awt.Dimension(620, 510));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

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
            .addGap(0, 165, Short.MAX_VALUE)
        );

        pan2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pan2ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout pan2Layout = new javax.swing.GroupLayout(pan2);
        pan2.setLayout(pan2Layout);
        pan2Layout.setHorizontalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pan2Layout.setVerticalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AREA DE INGRESO DE SOLICITUDES");

        btn_cargar.setText("CARGAR ARCHIVO");
        btn_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("LIMPIAR");
        btn_limpiar.setEnabled(false);
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        jlabel_path.setText("-");

        jButton1.setText("Prueba");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pan2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlabel_path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cargar)
                    .addComponent(jlabel_path)
                    .addComponent(btn_limpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            String nuevo = "";

            if (path.length() < 40) {
                nuevo = path;
            } else {
                nuevo = "..." + path.substring(path.length() - 40, path.length());
            }
            jlabel_path.setText(nuevo);
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

    private void pan2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pan2ComponentResized
        jsp2.setBounds(0, 0, pan2.getWidth(), pan2.getHeight());
    }//GEN-LAST:event_pan2ComponentResized

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

    public void prueba() throws Exception {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpPost httppost = new HttpPost("http://localhost:8080/Test1/Crear");

            // It may be more appropriate to use FileEntity class in this particular
            // instance but we are using a more generic InputStreamEntity to demonstrate
            // the capability to stream out data from any arbitrary source
            //
            // FileEntity entity = new FileEntity(file, "binary/octet-stream");
            httppost.setEntity(new StringEntity("hola"));

            System.out.println("Executing request " + httppost.getMethod() + " " + httppost.getUri());
            try (final CloseableHttpResponse response = httpclient.execute(httppost)) {
                System.out.println("----------------------------------------");
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } catch (IOException | ParseException ex) {
                java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void comunicacionServidor() throws Exception {
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpPost httppost = new HttpPost("http://localhost:8080/WForms/Creacion");
            List<NameValuePair> params = new ArrayList<>(2);
            String texto = textArea.getText();
            params.add(new BasicNameValuePair("entrada", texto));
            params.add(new BasicNameValuePair("usuario", "ozymandias"));
            httppost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
            System.out.println("Executing request " + httppost.getMethod() + " " + httppost.getUri());
            try (final CloseableHttpResponse response = httpclient.execute(httppost)) {
                System.out.println("----------------------------------------");
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                String respuesta = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                Gson gson = new Gson();
                Map<String, String> map = gson.fromJson(respuesta, Map.class);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println("LLAVE: " + entry.getKey() + " VALOR: " + entry.getValue());
                    if (entry.getKey().equals("respuesta")){
                        textArea2.setText(entry.getValue());
                    }
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public String getUsuario_logeado() {
        return usuario_logeado;
    }

    public void setUsuario_logeado(String usuario_logeado) {
        this.usuario_logeado = usuario_logeado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cargar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlabel_path;
    private javax.swing.JPanel pan1;
    private javax.swing.JPanel pan2;
    // End of variables declaration//GEN-END:variables
}
