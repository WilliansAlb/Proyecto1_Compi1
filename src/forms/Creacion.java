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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author willi
 */
public class Creacion extends javax.swing.JFrame {

    private static JTextArea textArea;
    private static JTextArea lines;
    private JScrollPane jsp;
    private static JTextArea textArea2;
    private static JTextArea textArea5;
    private static JTextPane textPane;
    private static JTextPane textPane2;
    private static JTextArea lines2;
    private JScrollPane jsp2;
    private JScrollPane jsp5;
    private String logeado;
    private ArrayList<Reporte> reportes = new ArrayList<>();
    private ArrayList<Errores> list_errores = new ArrayList<>();
    private int report_actual = 0;
    private int error_actual = 0;

    /**
     * Creates new form Creacion
     */
    public Creacion() {
        initComponents();
        getContentPane().setBackground(Color.BLACK);
        btn_reportes.setVisible(false);
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
        jtab.setEnabledAt(3, false);

        jsp2 = new JScrollPane();
        textArea2 = new JTextArea();
        textArea2.setBackground(new Color(97, 97, 97));
        textArea2.setEditable(false);
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

        jsp5 = new JScrollPane();
        textArea5 = new JTextArea();
        textArea5.setBackground(new Color(97, 97, 97));
        textArea5.setEditable(false);
        jsp5.getViewport().add(textArea5);
        TextLineNumber tln5 = new TextLineNumber(textArea5);
        tln5.setBorderGap(1);
        tln5.setBackground(Color.BLACK);
        tln5.setForeground(Color.WHITE);
        tln5.setCurrentLineForeground(Color.YELLOW);
        jsp5.setRowHeaderView(tln5);
        jsp5.setBorder(null);
        jsp5.setBounds(0, 0, panel5.getWidth(), panel5.getHeight());
        panel5.add(jsp5);
        panel5.setBackground(new Color(97, 97, 97));

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
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pan2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_reportes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        actual_consulta = new javax.swing.JLabel();
        jlabel_id = new javax.swing.JLabel();
        btn_anterior = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlabel_consulta = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jlabel_error = new javax.swing.JLabel();
        btn_last = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_errores = new javax.swing.JTable();
        panel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WForms");
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

        jButton2.setBackground(new java.awt.Color(25, 25, 25));
        jButton2.setForeground(new java.awt.Color(216, 255, 144));
        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
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
                                    .addComponent(btn_login, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addContainerGap(242, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))))
        );

        jtab.addTab("AREA SOLICITUDES", jPanel1);

        jPanel3.setBackground(new java.awt.Color(25, 25, 25));

        javax.swing.GroupLayout pan2Layout = new javax.swing.GroupLayout(pan2);
        pan2.setLayout(pan2Layout);
        pan2Layout.setHorizontalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pan2Layout.setVerticalGroup(
            pan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 255, 144));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RESPUESTA DEL SERVIDOR");

        btn_reportes.setText("VER REPORTES (0)");
        btn_reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reportesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtab.addTab("AREA RESPUESTA", jPanel3);

        jPanel2.setBackground(new java.awt.Color(25, 25, 25));

        actual_consulta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        actual_consulta.setForeground(new java.awt.Color(216, 255, 144));
        actual_consulta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actual_consulta.setText("AREA DE DESPLIEGUE DE REPORTES");

        jlabel_id.setForeground(new java.awt.Color(216, 255, 144));
        jlabel_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel_id.setText("ACÁ APARECERA EL ID DE LA CONSULTA");

        btn_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left.png"))); // NOI18N
        btn_anterior.setEnabled(false);
        btn_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorActionPerformed(evt);
            }
        });

        btn_siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/right.png"))); // NOI18N
        btn_siguiente.setEnabled(false);
        btn_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguienteActionPerformed(evt);
            }
        });

        tabla_reporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_reporte);

        jlabel_consulta.setEditable(false);
        jlabel_consulta.setBackground(new java.awt.Color(25, 25, 25));
        jlabel_consulta.setColumns(20);
        jlabel_consulta.setForeground(new java.awt.Color(216, 255, 144));
        jlabel_consulta.setRows(5);
        jScrollPane2.setViewportView(jlabel_consulta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(actual_consulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                    .addComponent(jlabel_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_anterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_siguiente)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actual_consulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabel_id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btn_anterior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btn_siguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        );

        jtab.addTab("AREA REPORTES", jPanel2);

        jPanel4.setBackground(new java.awt.Color(25, 25, 25));

        jlabel_error.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jlabel_error.setForeground(new java.awt.Color(216, 255, 144));
        jlabel_error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel_error.setText("ERROR");

        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/left.png"))); // NOI18N
        btn_last.setEnabled(false);
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/right.png"))); // NOI18N
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        tabla_errores.setBackground(new java.awt.Color(25, 25, 25));
        tabla_errores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabla_errores.setForeground(new java.awt.Color(216, 255, 144));
        tabla_errores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Valor", "Nombre", "Esperados", "Tipo", "Fila", "Columna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_errores.setEnabled(false);
        tabla_errores.setGridColor(new java.awt.Color(216, 255, 144));
        tabla_errores.setSelectionForeground(new java.awt.Color(26, 26, 26));
        tabla_errores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_erroresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_errores);
        if (tabla_errores.getColumnModel().getColumnCount() > 0) {
            tabla_errores.getColumnModel().getColumn(0).setResizable(false);
            tabla_errores.getColumnModel().getColumn(1).setResizable(false);
            tabla_errores.getColumnModel().getColumn(2).setResizable(false);
            tabla_errores.getColumnModel().getColumn(3).setResizable(false);
            tabla_errores.getColumnModel().getColumn(4).setResizable(false);
            tabla_errores.getColumnModel().getColumn(5).setResizable(false);
        }
        tabla_errores.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlabel_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_last)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlabel_error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtab.addTab("VISUALIZAR ERRORES", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtab)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtab)
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
        jsp5.setBounds(0, 0, panel5.getWidth(), panel5.getHeight());
        String txt1 = textArea.getText();
        String txt2 = textArea2.getText();
        String txt5 = textArea5.getText();
        textArea.setEditable(false);
        textArea2.setEditable(true);
        textArea.setEditable(true);
        textArea2.setEditable(false);
        textArea5.setEditable(true);
        textArea5.setEditable(false);
    }//GEN-LAST:event_formComponentResized

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            comunicacionServidor();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        String[] options = {"SI", "NO"};
        int x = JOptionPane.showOptionDialog(null, "¿Estás seguro de cerrar sesión?",
                "CERRAR SESION",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:\\Users\\willi\\OneDrive\\Documentos\\NetBeansProjects\\Forms\\src\\img\\arrow.png"), options, options[0]);
        if (x == 0) {
            setLogeado("");
            btn_login.setText("<html><font color=red>SIN</font><br><font color =red>LOGIN</font></html>");
            btn_login.setEnabled(false);
            btn_login.setContentAreaFilled(false);
            btn_login.setIcon(new ImageIcon("C:\\Users\\willi\\OneDrive\\Documentos\\NetBeansProjects\\Forms\\src\\img\\offrz.png"));
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed
        report_actual++;
        if (report_actual == (reportes.size() - 1)) {
            btn_siguiente.setEnabled(false);
            btn_anterior.setEnabled(true);
        } else {
            btn_anterior.setEnabled(true);
        }
        Object[] objArray = reportes.get(report_actual).getColumnas().toArray();
        ArrayList<String> d = reportes.get(report_actual).getDatos();
        jlabel_id.setText(reportes.get(report_actual).getId_consulta());
        jlabel_consulta.setText(reportes.get(report_actual).getConsulta());
        DefaultTableModel dtm = new DefaultTableModel(objArray, 0);
        ArrayList<String> escribiendo = new ArrayList<>();
        int conteo = 0;
        for (int i = 0; i < d.size(); i++) {
            if (conteo == (objArray.length - 1)) {
                escribiendo.add(d.get(i));
                dtm.addRow(escribiendo.toArray());
                escribiendo = new ArrayList<>();
                conteo = 0;
            } else {
                escribiendo.add(d.get(i));
                conteo++;
            }
        }
        tabla_reporte.setModel(dtm);
        actual_consulta.setText("Reporte " + (report_actual + 1) + " de " + reportes.size());
    }//GEN-LAST:event_btn_siguienteActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        error_actual++;
        if (error_actual == (list_errores.size() - 1)) {
            btn_next.setEnabled(false);
            btn_last.setEnabled(true);
        } else {
            btn_last.setEnabled(true);
        }
        int valor = (int) tabla_errores.getValueAt(0, 4);
        int valor2 = (int) tabla_errores.getValueAt(0, 5);
        String valor0 = (String) tabla_errores.getValueAt(0, 0);
        Object[] objArray = {list_errores.get(error_actual).getValor(), list_errores.get(error_actual).getNombre(), list_errores.get(error_actual).getEsperados(),
            list_errores.get(error_actual).getTipo(), list_errores.get(error_actual).getFila() + 1, list_errores.get(error_actual).getColumna() + 1};
        Object[] lagran = {"LEXEMA", "NOMBRE TOKEN", "TOKEN ESPERADOS", "ERROR TIPO", "FILA", "COLUMNA"};
        DefaultTableModel dtm = new DefaultTableModel(lagran, 0);
        dtm.addRow(objArray);
        tabla_errores.setModel(dtm);
        jlabel_error.setText("ERROR " + (error_actual + 1) + " de " + list_errores.size());
        posicionar(valor, valor2, valor0);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        error_actual--;
        if (error_actual == 0) {
            btn_next.setEnabled(true);
            btn_last.setEnabled(false);
        } else {
            btn_next.setEnabled(true);
        }
        Object[] objArray = {list_errores.get(error_actual).getValor(), list_errores.get(error_actual).getNombre(), list_errores.get(error_actual).getEsperados(),
            list_errores.get(error_actual).getTipo(), list_errores.get(error_actual).getFila() + 1, list_errores.get(error_actual).getColumna() + 1};
        Object[] lagran = {"LEXEMA", "NOMBRE TOKEN", "TOKEN ESPERADOS", "ERROR TIPO", "FILA", "COLUMNA"};
        DefaultTableModel dtm = new DefaultTableModel(lagran, 0);
        dtm.addRow(objArray);
        tabla_errores.setModel(dtm);
        int valor = (int) tabla_errores.getValueAt(0, 4);
        int valor2 = (int) tabla_errores.getValueAt(0, 5);
        String valor0 = (String) tabla_errores.getValueAt(0, 0);
        jlabel_error.setText("ERROR " + (error_actual + 1) + " de " + list_errores.size());
        posicionar(valor, valor2, valor0);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void btn_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorActionPerformed
        report_actual--;
        if (report_actual == 0) {
            btn_siguiente.setEnabled(true);
            btn_anterior.setEnabled(false);
        } else {
            btn_siguiente.setEnabled(true);
        }
        Object[] objArray = reportes.get(report_actual).getColumnas().toArray();
        ArrayList<String> d = reportes.get(report_actual).getDatos();
        jlabel_id.setText(reportes.get(report_actual).getId_consulta());
        jlabel_consulta.setText(reportes.get(report_actual).getConsulta());
        DefaultTableModel dtm = new DefaultTableModel(objArray, 0);
        ArrayList<String> escribiendo = new ArrayList<>();
        int conteo = 0;
        for (int i = 0; i < d.size(); i++) {
            if (conteo == (objArray.length - 1)) {
                escribiendo.add(d.get(i));
                dtm.addRow(escribiendo.toArray());
                escribiendo = new ArrayList<>();
                conteo = 0;
            } else {
                escribiendo.add(d.get(i));
                conteo++;
            }
        }
        tabla_reporte.setModel(dtm);
        actual_consulta.setText("Reporte " + (report_actual + 1) + " de " + reportes.size());
    }//GEN-LAST:event_btn_anteriorActionPerformed

    private void btn_reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reportesActionPerformed
        jtab.setSelectedIndex(2);
    }//GEN-LAST:event_btn_reportesActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (textArea.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Ingresa algo al campo de solicitudes antes de querer guardar");
        } else {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //Mostrar la ventana para abrir archivo y recoger la respuesta
            //En el parámetro del showOpenDialog se indica la ventana
            //  al que estará asociado. Con el valor this se asocia a la
            //  ventana que la abre.
            int respuesta = fc.showSaveDialog(this);
            //Comprobar si se ha pulsado Aceptar
            if (respuesta == JFileChooser.APPROVE_OPTION) {
                String content = textArea.getText();
                String path = fc.getSelectedFile().getAbsolutePath() + "\\actual.txt";
                try {
                    Files.write(Paths.get(path), content.getBytes());
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Creacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabla_erroresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_erroresMouseClicked
        int valor = (int) tabla_errores.getValueAt(0, 4);
        int valor2 = (int) tabla_errores.getValueAt(0, 5);
        String valor0 = (String) tabla_errores.getValueAt(0, 0);
        posicionar(valor, valor2, valor0);
    }//GEN-LAST:event_tabla_erroresMouseClicked

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
        jtab.setEnabledAt(2, false);
        jtab.setEnabledAt(1, false);
        jtab.setEnabledAt(3, false);
        jtab.setSelectedIndex(0);
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            final HttpPost httppost = new HttpPost("http://localhost:8080/WForms/Creacion");
            List<NameValuePair> params = new ArrayList<>(2);

            String texto = textArea.getText();
            //posicionar(10,18);
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
                if (!map.containsKey("ERROR")) {
                    if (map.containsKey("errores")) {
                        list_errores = new ArrayList<>();
                        String[] parts = map.get("errores").split("\t");
                        for (String p : parts) {
                            String[] columns = p.split("\n");
                            Errores nuevo = new Errores(Integer.parseInt(columns[4]), Integer.parseInt(columns[5]), columns[0], columns[1], columns[2], columns[3]);
                            list_errores.add(nuevo);
                        }
                        Object[] objArray = {list_errores.get(0).getValor(), list_errores.get(0).getNombre(), list_errores.get(0).getEsperados(),
                            list_errores.get(0).getTipo(), list_errores.get(0).getFila() + 1, list_errores.get(0).getColumna() + 1};
                        Object[] lagran = {"LEXEMA", "NOMBRE TOKEN", "TOKEN ESPERADOS", "ERROR TIPO", "FILA", "COLUMNA"};
                        DefaultTableModel dtm = new DefaultTableModel(lagran, 0);
                        dtm.addRow(objArray);
                        tabla_errores.setModel(dtm);
                        textArea5.setText(textArea.getText());
                        jlabel_error.setText("ERROR 1 de " + list_errores.size());
                        jtab.setSelectedIndex(3);
                        posicionar(list_errores.get(0).getFila() + 1, list_errores.get(0).getColumna() + 1, list_errores.get(0).getValor());
                        error_actual = 0;
                        if (list_errores.size() > 1) {
                            btn_next.setEnabled(true);
                            btn_last.setEnabled(false);
                        } else {
                            btn_next.setEnabled(false);
                            btn_last.setEnabled(false);
                        }
                        jtab.setEnabledAt(3, true);
                    } else {
                        textArea2.setText(map.get("respuesta"));
                        if (map.containsKey("reportes")) {
                            reportes = new ArrayList<>();
                            String[] partes_consulta = map.get("reportes").split("\t");
                            for (String part : partes_consulta) {
                                String[] parti = part.split("\n");
                                Reporte nuevo = new Reporte();
                                nuevo.setId_consulta(parti[0]);
                                nuevo.setConsulta(parti[1]);
                                String[] cols = parti[2].split("<///>");
                                for (String col : cols) {
                                    nuevo.getColumnas().add(col);
                                }
                                nuevo.setNoColumnas(nuevo.getColumnas().size());
                                String[] dat = parti[3].split("<///>");
                                for (String col : dat) {
                                    nuevo.getDatos().add(col);
                                }
                                reportes.add(nuevo);
                            }
                            if (!reportes.isEmpty()) {
                                Object[] objArray = reportes.get(0).getColumnas().toArray();
                                ArrayList<String> d = reportes.get(0).getDatos();
                                jlabel_id.setText(reportes.get(0).getId_consulta());
                                jlabel_consulta.setText(reportes.get(0).getConsulta());
                                DefaultTableModel dtm = new DefaultTableModel(objArray, 0);
                                ArrayList<String> escribiendo = new ArrayList<>();
                                int conteo = 0;
                                for (int i = 0; i < d.size(); i++) {
                                    if (conteo == (objArray.length - 1)) {
                                        escribiendo.add(d.get(i));
                                        dtm.addRow(escribiendo.toArray());
                                        escribiendo = new ArrayList<>();
                                        conteo = 0;
                                    } else {
                                        escribiendo.add(d.get(i));
                                        conteo++;
                                    }
                                }
                                tabla_reporte.setModel(dtm);
                                actual_consulta.setText("Reporte 1 de " + reportes.size());
                                report_actual = 0;
                                if (reportes.size() > 1) {
                                    btn_siguiente.setEnabled(true);
                                    btn_anterior.setEnabled(false);
                                } else {
                                    btn_siguiente.setEnabled(false);
                                    btn_anterior.setEnabled(false);
                                }
                            }
                            btn_reportes.setVisible(true);
                            btn_reportes.setText("VER REPORTES (" + reportes.size() + ")");
                        }
                        jtab.setSelectedIndex(1);
                        jtab.setEnabledAt(1, true);
                        jtab.setEnabledAt(2, true);
                        setLogeado(map.get("usuario"));
                        btn_login.setText("<html><span style=\"color: #D8FF90; font-size: 7px;\">CERRAR</span><br><span style=\"color: #D8FF90; font-size: 7px;\">SESION</span></html>");
                        btn_login.setEnabled(true);
                        btn_login.setContentAreaFilled(true);
                        btn_login.setIcon(new ImageIcon("C:\\Users\\willi\\OneDrive\\Documentos\\NetBeansProjects\\Forms\\src\\img\\onrz.png"));
                    }
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

    public void posicionar(int linea, int columna, String palabra) {
        String texto = textArea5.getText();
        textArea5.requestFocus();
        String[] lineas1 = texto.split("\n");
        int[] cuantos = new int[lineas1.length];
        for (int i = 0; i < lineas1.length; i++) {
            cuantos[i] = lineas1[i].length();
        }
        int donde = 0;
        for (int i = 0; i < (linea - 1); i++) {
            donde += cuantos[i] + 1;
        }
        donde += (columna - 1);
        textArea5.setCaretPosition(donde);
        textArea5.moveCaretPosition(donde + palabra.length());
    }

    public String getLogeado() {
        return logeado;
    }

    public void setLogeado(String logeado) {
        this.logeado = logeado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actual_consulta;
    private javax.swing.JButton btn_anterior;
    private javax.swing.JButton btn_cargar;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_reportes;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jlabel_consulta;
    private javax.swing.JLabel jlabel_error;
    private javax.swing.JLabel jlabel_id;
    private javax.swing.JLabel jlabel_path;
    private javax.swing.JTabbedPane jtab;
    private javax.swing.JPanel pan1;
    private javax.swing.JPanel pan2;
    private javax.swing.JPanel panel5;
    private javax.swing.JTable tabla_errores;
    private javax.swing.JTable tabla_reporte;
    // End of variables declaration//GEN-END:variables
}
