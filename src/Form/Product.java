package Form;

import Configuration.Database;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Product {
    private DefaultTableModel DftTblModel_customer;
    private String SQL;

    private JTextField name;
    private JPanel productPanel;
    private JTextField unit;
    private JTextField stock;
    private JTextField price;
    private JButton simpanButton;
    private JButton editButton;
    private JButton hapusButton;
    private JScrollPane productScrollPanel;
    private JTable productTable;
    private String id;

    public Product() {
        this.TampilData();
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Connection conn = Database.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("insert into products(name,stock,unit,price) values(?,?,?,?)");
                    stmt.setString(1, name.getText());
                    stmt.setString(2, stock.getText());
                    stmt.setString(3, unit.getText());
                    stmt.setString(4, price.getText());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                    TampilData();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Connection conn = Database.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("update products set name=?,stock=?,unit=?,price=? where id=?");
                    stmt.setString(1, name.getText());
                    stmt.setString(2, stock.getText());
                    stmt.setString(3, unit.getText());
                    stmt.setString(4, price.getText());
                    stmt.setString(5, id);
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                    TampilData();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Connection conn = Database.getConnection();
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data tersebut?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == 0) {
                    try {
                        PreparedStatement stmt = conn.prepareStatement("delete from products where id =?");
                        stmt.setString(1, id);
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                        TampilData();
                        name.setText("");
                        stock.setText("");
                        unit.setText("");
                        price.setText("");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di hapus" + e.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = productTable.getSelectedRow();
                name.setText(DftTblModel_customer.getValueAt(baris, 0).toString());
                stock.setText(DftTblModel_customer.getValueAt(baris, 1).toString());
                unit.setText(DftTblModel_customer.getValueAt(baris, 2).toString());
                price.setText(DftTblModel_customer.getValueAt(baris, 3).toString());
            }
        });
    }

    public void TampilData() {
        DftTblModel_customer = new DefaultTableModel();
        DftTblModel_customer.addColumn("Name");
        DftTblModel_customer.addColumn("Stock");
        DftTblModel_customer.addColumn("Unit");
        DftTblModel_customer.addColumn("Price");
        DftTblModel_customer.addColumn("Id");
        productTable.setModel(DftTblModel_customer);
        Connection conn = Database.getConnection();
        try {
            Statement stmt = conn.createStatement();
            SQL = "select * from products";
            ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_customer.addRow(new Object[]{
                        res.getString("name"),
                        res.getString("stock"),
                        res.getString("unit"),
                        res.getString("price"),
                        res.getString("id"),
                });
                id = res.getString("id");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Product");
        frame.setContentPane(new Product().productPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        productPanel = new JPanel();
        productPanel.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow"));
        productPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Product", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
        name = new JTextField();
        name.setText("");
        CellConstraints cc = new CellConstraints();
        productPanel.add(name, cc.xyw(3, 1, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        unit = new JTextField();
        productPanel.add(unit, cc.xyw(3, 3, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        stock = new JTextField();
        productPanel.add(stock, cc.xyw(3, 5, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label1 = new JLabel();
        label1.setText("Name");
        productPanel.add(label1, cc.xy(1, 1));
        final JLabel label2 = new JLabel();
        label2.setText("Unit");
        productPanel.add(label2, cc.xy(1, 3));
        final JLabel label3 = new JLabel();
        label3.setText("Stock");
        productPanel.add(label3, cc.xy(1, 5));
        price = new JTextField();
        productPanel.add(price, cc.xyw(3, 7, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label4 = new JLabel();
        label4.setText("Price");
        productPanel.add(label4, cc.xy(1, 7));
        simpanButton = new JButton();
        simpanButton.setText("Simpan");
        productPanel.add(simpanButton, cc.xy(3, 9));
        editButton = new JButton();
        editButton.setText("Edit");
        productPanel.add(editButton, cc.xy(5, 9));
        hapusButton = new JButton();
        hapusButton.setText("Hapus");
        productPanel.add(hapusButton, cc.xy(7, 9));
        productScrollPanel = new JScrollPane();
        productPanel.add(productScrollPanel, cc.xyw(3, 11, 5, CellConstraints.FILL, CellConstraints.FILL));
        productTable = new JTable();
        productScrollPanel.setViewportView(productTable);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return productPanel;
    }
}
