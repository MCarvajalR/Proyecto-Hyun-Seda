/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import co.com.hyunseda.market.entities.Category;
import co.com.hyunseda.market.entities.Item;
import co.com.hyunseda.market.entities.Order;
import co.com.hyunseda.market.entities.Product;
import co.com.hyunseda.market.service.OrderService;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN CARLOS MELO
 */
public class OrdenInfoGUI extends javax.swing.JFrame {

    private Order orderActual;
    private OrderService orderService;

    /**
     * Creates new form OrdenInfoGUI
     */
    public OrdenInfoGUI(OrderService orderService) {
        initComponents();
        this.orderService = orderService;
        setLocationRelativeTo(null);
        setSize(610, 500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelNorte = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblEstado = new javax.swing.JLabel();
        cbxEstados = new javax.swing.JComboBox<>();
        lblPaso = new javax.swing.JLabel();
        jPanelSur = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanelCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaItems = new javax.swing.JList<>();

        setLayout(new java.awt.BorderLayout());

        jPanelNorte.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout());

        jId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jId.setText("     Id :  ");
        jPanel2.add(jId);

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        jPanel2.add(txtId);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar);

        jPanel1.setLayout(new java.awt.GridLayout());
        jPanel2.add(jPanel1);

        jPanelNorte.add(jPanel2, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        lblEstado.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lblEstado, new java.awt.GridBagConstraints());

        cbxEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                                         " }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        jPanel4.add(cbxEstados, gridBagConstraints);

        lblPaso.setText("paso: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel4.add(lblPaso, gridBagConstraints);

        jPanelNorte.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanelNorte, java.awt.BorderLayout.PAGE_START);

        jPanelSur.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new java.awt.BorderLayout());

        lblTotal.setText("Total: 0.0");
        jPanel12.add(lblTotal, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel12, java.awt.BorderLayout.LINE_START);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jButton3.setText("Actualizar estado");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3, java.awt.BorderLayout.LINE_END);

        jPanel11.add(jPanel13, java.awt.BorderLayout.LINE_END);

        jPanel9.add(jPanel11, java.awt.BorderLayout.PAGE_END);

        jPanelSur.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        add(jPanelSur, java.awt.BorderLayout.PAGE_END);

        jPanelCentro.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setViewportView(ListaItems);

        jPanelCentro.add(jScrollPane1);

        add(jPanelCentro, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        limitarNumeros(evt);
    }//GEN-LAST:event_txtIdKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(txtId.getText() == null || txtId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "EL id esta vacio", "Error campos vacios", JOptionPane.ERROR_MESSAGE);
            return;
        }
        orderActual = orderService.findOrderById(Long.valueOf(txtId.getText())).orElse(null);
        if (orderActual != null) {
            loadOrder();
        } else {
            JOptionPane.showMessageDialog(null, "Orden no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (orderActual != null) {
            // Switch con cadenas
            switch (cbxEstados.getSelectedIndex()) {
            case 0:
                orderActual=orderService.actualizarEstado(orderActual.getId(), "siguiente");
                loadOrder();
                break;
            case 1:
                orderActual=orderService.actualizarEstado(orderActual.getId(), "cancelar");
                loadOrder();
                break;
            default:
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay una orden seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void loadOrder(){
        loadAllItems(orderActual.getItems());
        loadEstado(orderActual);
        lblTotal.setText("Total:"+orderActual.getTotal());
    }
    private void loadEstado(Order order) {
        lblEstado.setText("Estado actual: "+order.getState()+"     ");
        cbxEstados.removeAllItems();
        cbxEstados.addItem("siguiente");
        cbxEstados.addItem("cancelar");
    }
    private void loadAllItems(List<Item> items) {
        try {
            
            DefaultListModel listModel = new DefaultListModel();

            for (Item item : items) {
                listModel.addElement(item.getProduct().getId()+"-"+item.getProduct().getName());
                listModel.addElement( "Precio: " +item.getProduct().getPrice() + " Cant: " + item.getAmount() + "  Total: " + item.getTotal());
            }
            ListaItems.setModel(listModel);
        } catch (Exception ex) {
            Logger.getLogger(ListaProductosGUI.class.getName()).log(Level.SEVERE, "Error al cargar platos", ex);
        }
    }

    public void limitarNumeros(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume(); // Ignorar el carácter no válido
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListaItems;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbxEstados;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelCentro;
    private javax.swing.JPanel jPanelNorte;
    private javax.swing.JPanel jPanelSur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblPaso;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}