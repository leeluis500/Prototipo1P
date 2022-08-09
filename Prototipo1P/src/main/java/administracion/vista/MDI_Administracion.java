package administracion.vista;

import administracion.controlador.GenerarPermisos;
import administracion.controlador.ProcesosRepetidos;
import administracion.controlador.Usuarios;
import administracion.modelo.UsuariosDAO;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MDI_Administracion extends javax.swing.JFrame {

    ProcesosRepetidos procesoRepetido = new ProcesosRepetidos();
    GenerarPermisos gpermisos = new GenerarPermisos();
    String idBusqueda = LOGIN_Administracion.idUsuario;

    public static JLabel Jl_logo = new JLabel();
    
    private Asn_UsuarioAplicacion asn_usuarioAplicacion;
    private Mnt_Producto Mnt_prod;
    
    public MDI_Administracion() {
        initComponents();
        InicioSesion();
        Diseño();
    }

    public void Diseño() {
        Jdp_contenedor.setBackground(new Color(52, 78, 65));
        procesoRepetido.cursorMano(Mnb_menu);
        setTitle("[ USUARIO: " + LOGIN_Administracion.nomUsuario.toUpperCase() + "  " + procesoRepetido.getFechaActual("gt") + " ]  ");
        logo();
        Jdp_contenedor.add(Jl_logo);
    }

    private void InicioSesion() {
        Usuarios user = new Usuarios();
        UsuariosDAO userDAO = new UsuariosDAO();
        gpermisos.cargarAplicaciones(idBusqueda);
        user.setId(idBusqueda);
        user.setUltimaConexion(procesoRepetido.getFechaActual("us")+" "+procesoRepetido.getHoraActual());
        userDAO.updateL(user);
    }

    public void logo() {
        ImageIcon icon = new ImageIcon("src/main/java/assets/logoA.png");
        Jl_logo.setSize(512, 512);
        if (icon != null) {
            Jl_logo.setIcon(icon);
        } else {
            System.out.println("error al cargar el logo");
        }
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = Jl_logo.getSize();
        Jl_logo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jdp_contenedor = new javax.swing.JDesktopPane();
        Mnb_menu = new javax.swing.JMenuBar();
        Sbm_actualizarPermisos = new javax.swing.JMenu();
        Sbm_archivos = new javax.swing.JMenu();
        Sbm_catalogo = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        Mnt_Producto = new javax.swing.JMenuItem();
        Sbm_procesos = new javax.swing.JMenu();
        Mnu_procesos = new javax.swing.JMenu();
        MnI_UsuarioAplicacion = new javax.swing.JMenuItem();
        Sbm_herramientas = new javax.swing.JMenu();
        Sbm_ayuda = new javax.swing.JMenu();
        Btn_cerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        Jdp_contenedor.setBackground(new java.awt.Color(52, 78, 65));

        javax.swing.GroupLayout Jdp_contenedorLayout = new javax.swing.GroupLayout(Jdp_contenedor);
        Jdp_contenedor.setLayout(Jdp_contenedorLayout);
        Jdp_contenedorLayout.setHorizontalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        Jdp_contenedorLayout.setVerticalGroup(
            Jdp_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 727, Short.MAX_VALUE)
        );

        Sbm_actualizarPermisos.setText("*");
        Sbm_actualizarPermisos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Sbm_actualizarPermisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Sbm_actualizarPermisosMouseClicked(evt);
            }
        });
        Mnb_menu.add(Sbm_actualizarPermisos);

        Sbm_archivos.setText("Archivos");
        Sbm_archivos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_archivos);

        Sbm_catalogo.setText("Catalogo");
        Sbm_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        jMenu1.setText("Mantenimientos");

        Mnt_Producto.setText("Producto");
        Mnt_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mnt_ProductoActionPerformed(evt);
            }
        });
        jMenu1.add(Mnt_Producto);

        Sbm_catalogo.add(jMenu1);

        Mnb_menu.add(Sbm_catalogo);

        Sbm_procesos.setText("Procesos");
        Sbm_procesos.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N

        Mnu_procesos.setText("Procesos");

        MnI_UsuarioAplicacion.setText("Asignacion Usuario Aplicacion");
        MnI_UsuarioAplicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnI_UsuarioAplicacionActionPerformed(evt);
            }
        });
        Mnu_procesos.add(MnI_UsuarioAplicacion);

        Sbm_procesos.add(Mnu_procesos);

        Mnb_menu.add(Sbm_procesos);

        Sbm_herramientas.setText("Herramientas");
        Sbm_herramientas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_herramientas);

        Sbm_ayuda.setText("Ayuda");
        Sbm_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Sbm_ayuda);

        Btn_cerrarSesion.setText("Cerrar Sesión");
        Btn_cerrarSesion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Mnb_menu.add(Btn_cerrarSesion);

        setJMenuBar(Mnb_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jdp_contenedor)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        logo();
    }//GEN-LAST:event_formComponentResized

    private void Sbm_actualizarPermisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Sbm_actualizarPermisosMouseClicked
        gpermisos.cargarAplicaciones(idBusqueda);
    }//GEN-LAST:event_Sbm_actualizarPermisosMouseClicked

    private void MnI_UsuarioAplicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnI_UsuarioAplicacionActionPerformed
        asn_usuarioAplicacion = new Asn_UsuarioAplicacion();

        Jdp_contenedor.add(asn_usuarioAplicacion);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = asn_usuarioAplicacion.getSize();
        asn_usuarioAplicacion.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        asn_usuarioAplicacion.setVisible(true);
        asn_usuarioAplicacion.toFront();
    }//GEN-LAST:event_MnI_UsuarioAplicacionActionPerformed

    private void Mnt_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mnt_ProductoActionPerformed
        // TODO add your handling code here:
        Mnt_prod = new Mnt_Producto();

        Jdp_contenedor.add(Mnt_prod);
        Dimension desktopSize = Jdp_contenedor.getSize();
        Dimension FrameSize = Mnt_prod.getSize();
        Mnt_prod.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        Mnt_prod.setVisible(true);
        Mnt_prod.toFront();
    }//GEN-LAST:event_Mnt_ProductoActionPerformed

    public static void main(String args[]) {
        //FLATLAF
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDI_Administracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu Btn_cerrarSesion;
    private javax.swing.JDesktopPane Jdp_contenedor;
    public static javax.swing.JMenuItem MnI_UsuarioAplicacion;
    public static javax.swing.JMenuBar Mnb_menu;
    public static javax.swing.JMenuItem Mnt_Producto;
    public static javax.swing.JMenu Mnu_procesos;
    public static javax.swing.JMenu Sbm_actualizarPermisos;
    public static javax.swing.JMenu Sbm_archivos;
    public static javax.swing.JMenu Sbm_ayuda;
    public static javax.swing.JMenu Sbm_catalogo;
    public static javax.swing.JMenu Sbm_herramientas;
    public static javax.swing.JMenu Sbm_procesos;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
