package Views;

import Dao.ClientesDao;
import Dao.DetalleVentasDao;
import Dao.VentasDao;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

public class menu extends JPanel {
    public menu() {
        initComponents();
    }
    public void setClientesLlena(){
        try(ClientesDao n= new ClientesDao()) {
            DefaultTableModel model = (DefaultTableModel) clientestable.getModel();
            model.setRowCount(0);
            n.obtenerTodosLosClientes().forEach((cliente) -> {
                model.addRow(new Object[]{cliente.getIdCliente(), cliente.getNombre(), cliente.getApellido(), cliente.getFechaNacimiento(), cliente.getDireccion()});
            });
            clientestable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setVentasPorCliente(int idCliente) {
        try(VentasDao ven =new VentasDao()) {
            DefaultTableModel model = (DefaultTableModel) ventastable.getModel();
            model.setRowCount(0);
            ven.obtenerTodosLasVentasPorCliente(idCliente).forEach((venta) -> {
                model.addRow(new Object[]{venta.getIdVenta(), venta.getFecha(), venta.getIdCliente()});
            });
            ventastable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void setDetalleVentaPorId(int idVenta) {
        try(DetalleVentasDao detaven =new DetalleVentasDao()) {
            DefaultTableModel model = (DefaultTableModel) detalletable.getModel();
            model.setRowCount(0);
            detaven.obtenerTodosLosDetalleVentasPorCliente(idVenta).forEach((detalle) -> {
                model.addRow(new Object[]{detalle.getIdVenta(), detalle.getIdProducto(), detalle.getCantidad(), detalle.getDescuento()});
            });
            detalletable.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {

        label3 = new JLabel();
        label4 = new JLabel();
        scrollPane3 = new JScrollPane();
        clientestable = new JTable();
        label5 = new JLabel();
        scrollPane4 = new JScrollPane();
        ventastable = new JTable();
        label6 = new JLabel();
        scrollPane5 = new JScrollPane();
        detalletable = new JTable();
        textField1 = new JTextField();

        //======== this ========

        //---- label3 ----
        label3.setText("Detalle");

        //---- label4 ----
        label4.setText("Clientes");

        //======== scrollPane3 ========
        {

            //---- clientestable ----
            clientestable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "IdCliente", "Nombre", "Apellido", "FechaNacimiento", "Direccion"
                }
            ));
            clientestable.setDefaultEditor(Object.class, null);
            scrollPane3.setViewportView(clientestable);
        }


        clientestable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = clientestable.rowAtPoint(evt.getPoint());
                int col = clientestable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    int idCliente = (int) clientestable.getValueAt(row, 0);
                    setVentasPorCliente(idCliente);
                }
            }

        });

        //---- label5 ----
        label5.setText("Ventas");

        //======== scrollPane4 ========
        {

            //---- ventastable ----
            ventastable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "IdVenta", "Fecha", "IdCliente"
                }
            ));
            ventastable.setDefaultEditor(Object.class, null);
            scrollPane4.setViewportView(ventastable);

        }
        //cuando se selecciona algun venta de la ventastable se llena la tabla de detalle
        ventastable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = ventastable.rowAtPoint(evt.getPoint());
                int col = ventastable.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    int idVenta = (int) ventastable.getValueAt(row, 0);
                    setDetalleVentaPorId(idVenta);
                }
            }
        });


        //---- label6 ----
        label6.setText("Detalle");

        //======== scrollPane5 ========
        {

            //---- detalletable ----
            detalletable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "IdVenta", "IdProducto", "Cantidad", "Descuento"
                }
            ));
            detalletable.setDefaultEditor(Object.class, null);
            scrollPane5.setViewportView(detalletable);
        }

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setForeground(new Color(0xff0033));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textField1))
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(scrollPane4, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                                        .addComponent(label6)
                                        .addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE))))))
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(label6)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 642, GroupLayout.PREFERRED_SIZE)))
                    .addGap(982, 982, 982)
                    .addComponent(label3))
        );
        setClientesLlena();


    }

    private JLabel label3;
    private JLabel label4;
    private JScrollPane scrollPane3;
    private JTable clientestable;
    private JLabel label5;
    private JScrollPane scrollPane4;
    private JTable ventastable;
    private JLabel label6;
    private JScrollPane scrollPane5;
    private JTable detalletable;
    private JTextField textField1;
}
