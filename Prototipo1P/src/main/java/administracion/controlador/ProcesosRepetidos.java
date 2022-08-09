

package administracion.controlador;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

 /**
 * @author H. Leonel Dominguez C.
 * @github https://github.com/leoneldc
 */

public class ProcesosRepetidos {
    
    java.util.Date fecha = new java.util.Date();
    
    Color sVerde = new Color(114, 243, 227);
    Color dsVerde = new Color(97, 212, 195);
    Color sAmarillo = new Color(255, 255, 102);
    Color dsAmarillo = new Color(255, 255, 153);
    Color sRojo = new Color(255, 51, 51);
    Color dsRojo = new Color(255, 102, 102);
    Color aLogin = new Color(52, 78, 65);
    Color tLogin = new Color(83,107,120);
    Color cLogin = new Color(250,229,136);
    
    
    //diseño
    public void pintarComponente(String accion, Component... componentes){
        for (Component componente : componentes) {
            switch (accion) {
                case "sVerde":
                    componente.setBackground(sVerde);
                break;
                case "dsVerde":
                    componente.setBackground(dsVerde);
                break;
                case "sAmarillo":
                    componente.setBackground(sAmarillo);
                break;
                case "dsAmarillo":
                    componente.setBackground(dsAmarillo);
                break;
                case "sRojo":
                    componente.setBackground(sRojo);
                break;
                case "dsRojo":
                    componente.setBackground(dsRojo);
                break;
                case "aLogin":
                    componente.setBackground(aLogin);
                break;
                case "tLogin":
                    componente.setBackground(tLogin);
                break;
                case "cLogin":
                    componente.setBackground(cLogin);
                break;
            }
        }
    }

    public void cursorMano(Component... componentes) {
        java.awt.Cursor cursor = java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR);
        for (Component componente : componentes) {
            componente.setCursor(cursor);
        }
    }
    
    //funciones 
    public String getFechaActual(String formato) {
        SimpleDateFormat formatoFecha=null;
        if (formato.equals("gt")) {
            formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        }
        if (formato.equals("us")) {
            formatoFecha = new SimpleDateFormat("YYYY/MM/dd");
        }
        return formatoFecha.format(fecha);
    }

    public String getHoraActual() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm:ss");
        return formatoFecha.format(fecha);
    }
    
    //funciones de validaciones de campos
    public boolean isNumeric(JTextField... texto) {
        for (JTextField jTextField : texto) {
            try {
                Integer.parseInt(jTextField.getText());
            } catch (Exception e) {
                accionErronea("¡ERROR!","Existen campos que únicamente acepta unicamente números, revise e intentelo nuevamente");
                return false;
            }
        }
        return true;
    }

    public boolean isEmptyTxf(JTextField... texto) {
        for (JTextField jTextField : texto) {
            String palabra = jTextField.getText();
            palabra = palabra.replaceAll(" ", "");
            if (palabra.isEmpty()) {
                accionErronea("¡ERROR!","Existen campos que estan vaciós, revise e intentelo nuevamente");
                return false;
            }
        }
        return true;
    }

    public boolean isSelectedCbx(JComboBox... texto) {
        for (JComboBox jComboBox : texto) {
            if (jComboBox.getSelectedIndex() == 0) {
                accionErronea("¡ERROR!", "Existen campos que no se ah seleccionado una opción, revise e intentelo nuevamente");
                return false;
            }
        }
        return true;
    }

    public boolean isEmptyTxa(JTextArea... texto) {
        for (JTextArea jTextArea : texto) {
            String palabra = jTextArea.getText();
            palabra = palabra.replaceAll(" ", "");
            if (palabra.isEmpty()) {
                accionErronea("¡ERROR!","Existen campos que estan vaciós, revise e intentelo nuevamente");
                return false;
            }
        }
        return true;
    }

    public boolean isSelectedRbt(JRadioButton... radioButtons) {
        int flat = 0;
        for (JRadioButton button : radioButtons) {
            if (button.isSelected()) {
                flat++;
            }
        }
        if (flat == 0) {
            accionErronea("¡ERROR!","Existen botones que no se selecciono una opción, revise e intentelo nuevamente");
            return false;
        }
        return true;
    }
    
    public Boolean ValidarEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[_.])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()==true) {
            return matcher.matches();
        }
        accionErronea("¡ERROR!","El email ingresado es invalido, revise e intentelo nuevamente");    
        return matcher.matches();
    }
    
    //limpieza de componentes
    public void limpiarTxf(JTextField... texto){
        for (JTextField jTextField : texto) {
            jTextField.setText("");
        }
    }
    
    public void limpiarCbx(JComboBox... texto){
        for (JComboBox jComboBox : texto) {
            jComboBox.setSelectedIndex(0);
        }
    }
    
    public void limpiarTxa(JTextArea... texto){
        for (JTextArea jTextArea : texto) {
            jTextArea.setText("");
        }
    }
    
    //funciones de alertas
    public void accionExitosa(String titulo, String descripcion) {
        ImageIcon icon = new ImageIcon("src/main/java/assets/alerta_ok.png");
        JOptionPane.showMessageDialog(null, descripcion, titulo, 0, icon);
    }
    
    public void accionErronea( String titulo, String descripcion) {
        JOptionPane.showMessageDialog(null, descripcion, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
    public boolean confirmarEliminación(String objeto){
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar " + objeto + "?", "Verifiación de Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmar == 0) {
            return true;
        }
        return false;
    }
    
    
    //funciones de llenado de información
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column > 20) {
                return true;
            }
            return false;
        }
    };
    DefaultTableCellRenderer centro = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            if (row % 2 == 0) {
                setBackground(new Color(229, 229, 229));
                setForeground(Color.BLACK);
            } else {
                setBackground(Color.white);
                setForeground(Color.BLACK);
            }

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    };
    int totalColumnas;
    public void llenarColumnas(String datos[], int cantidad, JTable tabla) {
        totalColumnas = cantidad;
        for (int j = 0; j < cantidad; j++) {
            modelo.addColumn(datos[j]);
        }
        tabla.setModel(modelo);
    }
    public void llenarFilas(Object fila[], int tamaño[], JTable tabla) {
        for (int i = 0; i < totalColumnas; i++) {
            centro.setHorizontalAlignment(JLabel.CENTER);
            tabla.getColumnModel().getColumn(i).setCellRenderer(centro);
            tabla.getColumnModel().getColumn(i).setPreferredWidth(tamaño[i]);
        }
        modelo.addRow(fila);
        tabla.setModel(modelo);
    }

}
