package administracion.vista;

import administracion.controlador.Aplicaciones;
import administracion.controlador.ProcesosRepetidos;
import administracion.controlador.UsuarioAplicacion;
import administracion.controlador.Usuarios;
import administracion.modelo.AplicacionesDAO;
import administracion.modelo.UsuarioAplicacionDAO;
import administracion.modelo.UsuariosDAO;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author leeluis
 */
public class Asn_UsuarioAplicacion extends javax.swing.JInternalFrame {

    ProcesosRepetidos procesosr = new ProcesosRepetidos();
    Aplicaciones app = new Aplicaciones();
    UsuarioAplicacion asignaciones = new UsuarioAplicacion();
    UsuarioAplicacionDAO asignacionesDAO = new UsuarioAplicacionDAO();
    Boolean modificar = false;
    String idApp = "0030";

    /**
     * Creates new form Asn_UsuarioAplicacion
     */
    public Asn_UsuarioAplicacion() {
        initComponents();
        cargarAcciones();
        diseño();
        cargarAplicaciones();
    }

    public void diseño() {
        setTitle("Asignación Usuarios a Aplicaciones");
        procesosr.cursorMano(Tbl_aplicaciones,Tbl_asignaciones, Btn_ayuda, Btn_cancelar, Btn_guardarT, Btn_guardarU, Btn_quitarU, Btn_quitarT);
    }

    private void cargarAplicaciones() {
        ProcesosRepetidos procesosr = new ProcesosRepetidos();
        String encabezado[] = {"ID", "NOMBRE"};
        int cantidadcolumnas = encabezado.length;
        procesosr.llenarColumnas(encabezado, cantidadcolumnas, Tbl_aplicaciones);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 300};
        AplicacionesDAO appDAO = new AplicacionesDAO();
        List<Aplicaciones> apps = appDAO.selectUA();
        for (Aplicaciones app : apps) {
            if (app.getEstado().equals("1")) {
                datos[0] = app.getId();
                datos[1] = app.getNombre();
                procesosr.llenarFilas(datos, tamaño, Tbl_aplicaciones);
            }
        }
    }

    private void cargarAsignaciones() {
        ProcesosRepetidos procesosr = new ProcesosRepetidos();
        String encabezado[] = {"ID USUARIO", "ID APLICACION", "GUARDAR", "BUSCAR", "MODIFICAR", "ELIMINAR"};
        int cantidadcolumnas = encabezado.length;
        procesosr.llenarColumnas(encabezado, cantidadcolumnas, Tbl_asignaciones);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {150, 150, 75, 75, 75, 75};
        UsuarioAplicacionDAO asignacionesDAO = new UsuarioAplicacionDAO();
        UsuarioAplicacion asignaciones = new UsuarioAplicacion();
        asignaciones.setIdUsuario(Txt_busqueda.getText());
        List<UsuarioAplicacion> listaAsignaciones = asignacionesDAO.selectUA(asignaciones);
        for (UsuarioAplicacion asignacion : listaAsignaciones) {
            datos[0] = asignacion.getIdUsuario();
            datos[1] = asignacion.getIdAplicacion();
            if (asignacion.getGuardar().equals("1")) {
                datos[2] = "si";
            } else {
                datos[2] = "no";
            }
            if (asignacion.getBuscar().equals("1")) {
                datos[3] = "si";
            } else {
                datos[3] = "no";
            }
            if (asignacion.getModificar().equals("1")) {
                datos[4] = "si";
            } else {
                datos[4] = "no";
            }
            if (asignacion.getEliminar().equals("1")) {
                datos[5] = "si";
            } else {
                datos[5] = "no";
            }
            procesosr.llenarFilas(datos, tamaño, Tbl_asignaciones);
        }
    }

    void cargarAcciones() {

        Btn_guardarU.setVisible(false);
        Btn_guardarT.setVisible(false);
        Btn_quitarU.setVisible(false);
        Btn_quitarT.setVisible(false);
        Btn_cargarUsuario.setVisible(false);

        UsuarioAplicacion permisos = new UsuarioAplicacion();
        UsuarioAplicacionDAO permisosDAO = new UsuarioAplicacionDAO();

        permisos.setIdUsuario(LOGIN_Administracion.idUsuario);
        permisos.setIdAplicacion(idApp);

        permisos = permisosDAO.selectV(permisos);

        if (permisos.getBuscar().equals("1")) {
            Btn_cargarUsuario.setVisible(true);
        }
        if (permisos.getGuardar().equals("1")) {
            Btn_guardarU.setVisible(true);
            Btn_guardarT.setVisible(true);
        }
        if (permisos.getModificar().equals("1")) {
            modificar = true;
        }
        if (permisos.getEliminar().equals("1")) {
            Btn_quitarU.setVisible(true);
            Btn_quitarT.setVisible(true);
        }
    }

    /**
     * Esto es codigo generado automaticamente por el IDE debido al Design *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_ingresoDatos = new javax.swing.JPanel();
        Btn_listaUsuarios = new javax.swing.JButton();
        Lbl_id = new javax.swing.JLabel();
        Txt_busqueda = new javax.swing.JTextField();
        Btn_cargarUsuario = new javax.swing.JButton();
        Lbl_nombre = new javax.swing.JLabel();
        Txt_nombre = new javax.swing.JTextField();
        Lbl_descripcion = new javax.swing.JLabel();
        Lbl_estado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_aplicaciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_asignaciones = new javax.swing.JTable();
        Btn_fondoGuardarU = new javax.swing.JPanel();
        Btn_guardarU = new javax.swing.JLabel();
        Btn_fondoGuardarT = new javax.swing.JPanel();
        Btn_guardarT = new javax.swing.JLabel();
        Btn_fondoQuitarU = new javax.swing.JPanel();
        Btn_quitarU = new javax.swing.JLabel();
        Btn_fondoQuitarT = new javax.swing.JPanel();
        Btn_quitarT = new javax.swing.JLabel();
        Btn_fondoAyuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondoCancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        Btn_fondoReportes = new javax.swing.JPanel();
        Btn_Reportes = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(163, 177, 138));
        Pnl_ingresoDatos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(52, 78, 65), 1, true));

        Btn_listaUsuarios.setText("LISTADO DE USUARIOS");
        Btn_listaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_listaUsuariosActionPerformed(evt);
            }
        });

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("ID USUARIO:");

        Txt_busqueda.setBackground(new java.awt.Color(163, 177, 138));
        Txt_busqueda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_busqueda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(88, 129, 87)));

        Btn_cargarUsuario.setText("CARGAR");
        Btn_cargarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cargarUsuarioActionPerformed(evt);
            }
        });

        Lbl_nombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre.setText("NOMBRE:");

        Txt_nombre.setBackground(new java.awt.Color(163, 177, 138));
        Txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(88, 129, 87)));

        Lbl_descripcion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_descripcion.setText("APLICACIONES:");

        Lbl_estado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_estado.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_estado.setText("ASIGNACIONES:");

        Tbl_aplicaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tbl_aplicaciones);

        Tbl_asignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_asignaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_asignacionesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Tbl_asignaciones);

        Btn_fondoGuardarU.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoGuardarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoGuardarU.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_guardarU.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardarU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardarU.setText("ASIGNAR 1:1");
        Btn_guardarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_guardarU.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_guardarU.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_guardarU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardarUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarUMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardarULayout = new javax.swing.GroupLayout(Btn_fondoGuardarU);
        Btn_fondoGuardarU.setLayout(Btn_fondoGuardarULayout);
        Btn_fondoGuardarULayout.setHorizontalGroup(
            Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardarU, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
        );
        Btn_fondoGuardarULayout.setVerticalGroup(
            Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardarU, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondoGuardarT.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoGuardarT.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoGuardarT.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_guardarT.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardarT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardarT.setText("ASIGNAR TODOS");
        Btn_guardarT.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_guardarT.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_guardarT.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_guardarT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardarTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarTMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardarTLayout = new javax.swing.GroupLayout(Btn_fondoGuardarT);
        Btn_fondoGuardarT.setLayout(Btn_fondoGuardarTLayout);
        Btn_fondoGuardarTLayout.setHorizontalGroup(
            Btn_fondoGuardarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_guardarT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoGuardarTLayout.setVerticalGroup(
            Btn_fondoGuardarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_guardarT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoQuitarU.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoQuitarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoQuitarU.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_quitarU.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_quitarU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_quitarU.setText("QUITAR 1:1");
        Btn_quitarU.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_quitarU.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_quitarU.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_quitarU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_quitarUMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_quitarUMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_quitarUMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoQuitarULayout = new javax.swing.GroupLayout(Btn_fondoQuitarU);
        Btn_fondoQuitarU.setLayout(Btn_fondoQuitarULayout);
        Btn_fondoQuitarULayout.setHorizontalGroup(
            Btn_fondoQuitarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_quitarU, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        Btn_fondoQuitarULayout.setVerticalGroup(
            Btn_fondoQuitarULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_quitarU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoQuitarT.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoQuitarT.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoQuitarT.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_quitarT.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_quitarT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_quitarT.setText("QUITAR TODOS");
        Btn_quitarT.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_quitarT.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_quitarT.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_quitarT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_quitarTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_quitarTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_quitarTMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoQuitarTLayout = new javax.swing.GroupLayout(Btn_fondoQuitarT);
        Btn_fondoQuitarT.setLayout(Btn_fondoQuitarTLayout);
        Btn_fondoQuitarTLayout.setHorizontalGroup(
            Btn_fondoQuitarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_quitarT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        Btn_fondoQuitarTLayout.setVerticalGroup(
            Btn_fondoQuitarTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_quitarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoAyuda.setBackground(new java.awt.Color(253, 255, 182));
        Btn_fondoAyuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoAyuda.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("AYUDA");
        Btn_ayuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoAyudaLayout = new javax.swing.GroupLayout(Btn_fondoAyuda);
        Btn_fondoAyuda.setLayout(Btn_fondoAyudaLayout);
        Btn_fondoAyudaLayout.setHorizontalGroup(
            Btn_fondoAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoAyudaLayout.setVerticalGroup(
            Btn_fondoAyudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoCancelar.setBackground(new java.awt.Color(255, 128, 115));
        Btn_fondoCancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoCancelar.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("CANCELAR");
        Btn_cancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoCancelarLayout = new javax.swing.GroupLayout(Btn_fondoCancelar);
        Btn_fondoCancelar.setLayout(Btn_fondoCancelarLayout);
        Btn_fondoCancelarLayout.setHorizontalGroup(
            Btn_fondoCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoCancelarLayout.setVerticalGroup(
            Btn_fondoCancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondoReportes.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoReportes.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoReportes.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_Reportes.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_Reportes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_Reportes.setText("REPORTE");
        Btn_Reportes.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_Reportes.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_Reportes.setPreferredSize(new java.awt.Dimension(104, 40));
        Btn_Reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ReportesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoReportesLayout = new javax.swing.GroupLayout(Btn_fondoReportes);
        Btn_fondoReportes.setLayout(Btn_fondoReportesLayout);
        Btn_fondoReportesLayout.setHorizontalGroup(
            Btn_fondoReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Reportes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondoReportesLayout.setVerticalGroup(
            Btn_fondoReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Reportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Lbl_descripcion)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Btn_listaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(Lbl_id))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Btn_fondoGuardarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_fondoGuardarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Txt_busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_cargarUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Lbl_estado)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Btn_fondoQuitarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_fondoQuitarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_fondoReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_fondoAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btn_fondoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_listaUsuarios)
                    .addComponent(Lbl_id)
                    .addComponent(Txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_cargarUsuario)
                    .addComponent(Lbl_nombre)
                    .addComponent(Txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_descripcion)
                    .addComponent(Lbl_estado))
                .addGap(0, 0, 0)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_fondoGuardarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_fondoGuardarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_fondoQuitarU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_fondoQuitarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Btn_fondoAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btn_fondoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_fondoReportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarUMouseClicked
        if (procesosr.isEmptyTxf(Txt_nombre)) {
            boolean duplicada = true;
            int filaSeleccionada = Tbl_aplicaciones.getSelectedRow();
            if (filaSeleccionada >= 0) {
                UsuarioAplicacion asignaciones = new UsuarioAplicacion();
                asignaciones.setIdUsuario(Txt_busqueda.getText());
                asignaciones.setIdAplicacion(Tbl_aplicaciones.getValueAt(filaSeleccionada, 0).toString());
                asignaciones = asignacionesDAO.selectV(asignaciones);
                if (asignaciones.getBuscar() == null) {
                    duplicada = false;
                } else {
                    JOptionPane.showMessageDialog(null, "ASIGNACIÓN YA EXISTENTE");
                }
            }
            if (!duplicada) {
                asignaciones.setIdUsuario(Txt_busqueda.getText());
                asignaciones.setIdAplicacion(Tbl_aplicaciones.getValueAt(filaSeleccionada, 0).toString());
                int guardar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de GUARDAR?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (guardar == 0) {
                    asignaciones.setGuardar("1");
                } else {
                    asignaciones.setGuardar("0");
                }
                int buscar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de BUSQUEDA?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (buscar == 0) {
                    asignaciones.setBuscar("1");
                } else {
                    asignaciones.setBuscar("0");
                }
                int modififcar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de EDICIÓN?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (modififcar == 0) {
                    asignaciones.setModificar("1");
                } else {
                    asignaciones.setModificar("0");
                }
                int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de ELIMINAR?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (eliminar == 0) {
                    asignaciones.setEliminar("1");
                } else {
                    asignaciones.setEliminar("0");
                }
                asignacionesDAO.insert(asignaciones);
                cargarAsignaciones();
            }
        }
    }//GEN-LAST:event_Btn_guardarUMouseClicked

    private void Btn_guardarUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarUMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoGuardarU);
    }//GEN-LAST:event_Btn_guardarUMouseEntered

    private void Btn_guardarUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarUMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoGuardarU);
    }//GEN-LAST:event_Btn_guardarUMouseExited

    private void Btn_guardarTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarTMouseClicked
        if (procesosr.isEmptyTxf(Txt_nombre)) {
            String valorPermisos;
            int valor = JOptionPane.showConfirmDialog(null, "¿AGREGAR TODOS CON PERMISOS SI?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
            if (valor == 0) {
                valorPermisos = "1";
            } else {
                valorPermisos = "0";
            }
            boolean duplicada = true;
            for (int i = 0; i < Tbl_aplicaciones.getRowCount(); i++) {
                UsuarioAplicacion asignaciones = new UsuarioAplicacion();
                asignaciones.setIdUsuario(Txt_busqueda.getText());
                asignaciones.setIdAplicacion(Tbl_aplicaciones.getValueAt(i, 0).toString());
                asignaciones = asignacionesDAO.selectV(asignaciones);
                if (asignaciones.getBuscar() == null) {
                    asignaciones.setIdUsuario(Txt_busqueda.getText());
                    asignaciones.setIdAplicacion(Tbl_aplicaciones.getValueAt(i, 0).toString());
                    asignaciones.setGuardar(valorPermisos);
                    asignaciones.setEliminar(valorPermisos);
                    asignaciones.setBuscar(valorPermisos);
                    asignaciones.setModificar(valorPermisos);
                    asignacionesDAO.insert(asignaciones);
                    cargarAsignaciones();
                }
            }
        }
    }//GEN-LAST:event_Btn_guardarTMouseClicked

    private void Btn_guardarTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarTMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoGuardarT);
    }//GEN-LAST:event_Btn_guardarTMouseEntered

    private void Btn_guardarTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarTMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoGuardarT);
    }//GEN-LAST:event_Btn_guardarTMouseExited

    private void Btn_quitarUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarUMouseClicked
        if (procesosr.isEmptyTxf(Txt_nombre)) {
            boolean duplicada = true;
            int filaSeleccionada = Tbl_asignaciones.getSelectedRow();
            if (filaSeleccionada >= 0) {
                if (procesosr.confirmarEliminación("la asignación de la aplicacion: #" + Tbl_asignaciones.getValueAt(filaSeleccionada, 1).toString())) {
                    asignaciones.setIdUsuario(Tbl_asignaciones.getValueAt(filaSeleccionada, 0).toString());
                    asignaciones.setIdAplicacion(Tbl_asignaciones.getValueAt(filaSeleccionada, 1).toString());
                    asignacionesDAO.delete(asignaciones);
                    cargarAsignaciones();
                }
            }
        }
    }//GEN-LAST:event_Btn_quitarUMouseClicked

    private void Btn_quitarUMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarUMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoQuitarU);
    }//GEN-LAST:event_Btn_quitarUMouseEntered

    private void Btn_quitarUMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarUMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoQuitarU);
    }//GEN-LAST:event_Btn_quitarUMouseExited

    private void Btn_quitarTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarTMouseClicked
        if (procesosr.isEmptyTxf(Txt_nombre)) {
            boolean duplicada = true;
            if (procesosr.confirmarEliminación(" todos las asignaciones para el usuario: " + Txt_nombre.getText())) {
                for (int i = 0; i < Tbl_asignaciones.getRowCount(); i++) {
                    UsuarioAplicacion asignaciones = new UsuarioAplicacion();
                    UsuarioAplicacionDAO asignacionesDAO = new UsuarioAplicacionDAO();
                    asignaciones.setIdUsuario(Tbl_asignaciones.getValueAt(i, 0).toString());
                    asignaciones.setIdAplicacion(Tbl_asignaciones.getValueAt(i, 1).toString());
                    asignaciones = asignacionesDAO.selectV(asignaciones);
                    if (asignaciones.getBuscar() == null) {
                    } else {
                        asignaciones.setIdUsuario(Tbl_asignaciones.getValueAt(i, 0).toString());
                        asignaciones.setIdAplicacion(Tbl_asignaciones.getValueAt(i, 1).toString());
                        asignacionesDAO.delete(asignaciones);
                    }
                }
                cargarAsignaciones();
            }
        }
    }//GEN-LAST:event_Btn_quitarTMouseClicked

    private void Btn_quitarTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarTMouseEntered
        procesosr.pintarComponente("sVerde", Btn_fondoQuitarT);
    }//GEN-LAST:event_Btn_quitarTMouseEntered

    private void Btn_quitarTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_quitarTMouseExited
        procesosr.pintarComponente("dsVerde", Btn_fondoQuitarT);
    }//GEN-LAST:event_Btn_quitarTMouseExited

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        System.out.println("ayuda");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        procesosr.pintarComponente("sAmarillo", Btn_fondoAyuda);
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        procesosr.pintarComponente("dsAmarillo", Btn_fondoAyuda);
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked

    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        procesosr.pintarComponente("sRojo", Btn_fondoCancelar);
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        procesosr.pintarComponente("dsRojo", Btn_fondoCancelar);
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_cargarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cargarUsuarioActionPerformed
        if (procesosr.isEmptyTxf(Txt_busqueda)) {
            if (procesosr.isNumeric(Txt_busqueda)) {
                Usuarios usuarios = new Usuarios();
                UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuarios.setId(Txt_busqueda.getText());
                usuarios = usuariosDAO.selectUA(usuarios);
                if (usuarios.getNombre() == null) {
                    procesosr.accionErronea("¡ERROR!", "USUARIO NO ENCONTRADO");
                } else {
                    if (usuarios.getEstado().equals("0")) {
                        procesosr.accionErronea("¡ERROR!", "USUARIO NO ACTIVO");
                    } else {
                        Txt_nombre.setText(usuarios.getNombre() + " " + usuarios.getApellido());
                        cargarAsignaciones();
                    }
                }
            }
        }
    }//GEN-LAST:event_Btn_cargarUsuarioActionPerformed

    private void Btn_ReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReportesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_ReportesMouseClicked

    private void Btn_ReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReportesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_ReportesMouseEntered

    private void Btn_ReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ReportesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_ReportesMouseExited

    private void Tbl_asignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_asignacionesMouseClicked
        if (modificar) {
            int filaSeleccionada = Tbl_asignaciones.getSelectedRow();
            if (evt.getClickCount() == 2) {
                asignaciones.setIdUsuario(Txt_busqueda.getText());
                asignaciones.setIdAplicacion(Tbl_asignaciones.getValueAt(filaSeleccionada, 1).toString());
                int guardar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de GUARDAR?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (guardar == 0) {
                    asignaciones.setGuardar("1");
                } else {
                    asignaciones.setGuardar("0");
                }
                int buscar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de BUSQUEDA?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (buscar == 0) {
                    asignaciones.setBuscar("1");
                } else {
                    asignaciones.setBuscar("0");
                }
                int modififcar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de EDICIÓN?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (modififcar == 0) {
                    asignaciones.setModificar("1");
                } else {
                    asignaciones.setModificar("0");
                }
                int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea darle permisos de ELIMINAR?", "Verifiación de permisos", JOptionPane.YES_NO_OPTION);
                if (eliminar == 0) {
                    asignaciones.setEliminar("1");
                } else {
                    asignaciones.setEliminar("0");
                }
                asignacionesDAO.update(asignaciones);
                cargarAsignaciones();
            }
        }
    }//GEN-LAST:event_Tbl_asignacionesMouseClicked

    private void Btn_listaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_listaUsuariosActionPerformed
        Vst_Usuarios vst_usuario = new Vst_Usuarios();
        vst_usuario.setVisible(true);
    }//GEN-LAST:event_Btn_listaUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btn_Reportes;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JButton Btn_cargarUsuario;
    private javax.swing.JPanel Btn_fondoAyuda;
    private javax.swing.JPanel Btn_fondoCancelar;
    private javax.swing.JPanel Btn_fondoGuardarT;
    private javax.swing.JPanel Btn_fondoGuardarU;
    private javax.swing.JPanel Btn_fondoQuitarT;
    private javax.swing.JPanel Btn_fondoQuitarU;
    private javax.swing.JPanel Btn_fondoReportes;
    private javax.swing.JLabel Btn_guardarT;
    private javax.swing.JLabel Btn_guardarU;
    private javax.swing.JButton Btn_listaUsuarios;
    private javax.swing.JLabel Btn_quitarT;
    private javax.swing.JLabel Btn_quitarU;
    private javax.swing.JLabel Lbl_descripcion;
    private javax.swing.JLabel Lbl_estado;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JLabel Lbl_nombre;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JTable Tbl_aplicaciones;
    private javax.swing.JTable Tbl_asignaciones;
    private javax.swing.JTextField Txt_busqueda;
    private javax.swing.JTextField Txt_nombre;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

}
