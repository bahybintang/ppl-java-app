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

public class Customer {
    private DefaultTableModel DftTblModel_customer;
    private String SQL;

    private JTextField firstName;
    private JPanel customerPanel;
    private JTextField lastName;
    private JTextField email;
    private JTextField address;
    private JTextField username;
    private JPasswordField password;
    private JTable customerTable;
    private JScrollPane customerScrollPanel;
    private JButton simpanButton;
    private JButton editButton;
    private JButton hapusButton;

    public Customer() {
        this.TampilData();
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Connection conn = Database.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("insert into customers(first_name,last_name,username,password,email,address) values(?,?,?,?,?,?)");
                    stmt.setString(1, firstName.getText());
                    stmt.setString(2, lastName.getText());
                    stmt.setString(3, username.getText());
                    stmt.setString(4, password.getPassword().toString());
                    stmt.setString(5, email.getText());
                    stmt.setString(6, address.getText());
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
                    PreparedStatement stmt = conn.prepareStatement("update customers set first_name=?,last_name=?,username=?,password=?,email=?,address=? where username=?");
                    stmt.setString(1, firstName.getText());
                    stmt.setString(2, lastName.getText());
                    stmt.setString(3, username.getText());
                    stmt.setString(4, password.getPassword().toString());
                    stmt.setString(5, email.getText());
                    stmt.setString(6, address.getText());
                    stmt.setString(7, username.getText());
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
                        PreparedStatement stmt = conn.prepareStatement("delete from customers where username ='" + username.getText() + "'");
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                        TampilData();
                        firstName.setText("");
                        lastName.setText("");
                        username.setText("");
                        password.setText("");
                        email.setText("");
                        address.setText("");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di hapus" + e.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        customerTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = customerTable.getSelectedRow();
                firstName.setText(DftTblModel_customer.getValueAt(baris, 0).toString());
                lastName.setText(DftTblModel_customer.getValueAt(baris, 1).toString());
                username.setText(DftTblModel_customer.getValueAt(baris, 2).toString());
                password.setText(DftTblModel_customer.getValueAt(baris, 3).toString());
                email.setText(DftTblModel_customer.getValueAt(baris, 4).toString());
                address.setText(DftTblModel_customer.getValueAt(baris, 5).toString());
            }
        });
    }

    public void TampilData() {
        DftTblModel_customer = new DefaultTableModel();
        DftTblModel_customer.addColumn("First Name");
        DftTblModel_customer.addColumn("Last Name");
        DftTblModel_customer.addColumn("Username");
        DftTblModel_customer.addColumn("Password");
        DftTblModel_customer.addColumn("Email");
        DftTblModel_customer.addColumn("Address");
        customerTable.setModel(DftTblModel_customer);
        Connection conn = Database.getConnection();
        try {
            Statement stmt = conn.createStatement();
            SQL = "select * from customers";
            ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_customer.addRow(new Object[]{
                        res.getString("first_name"),
                        res.getString("last_name"),
                        res.getString("username"),
                        res.getString("password"),
                        res.getString("email"),
                        res.getString("address")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Customer");
        frame.setContentPane(new Customer().customerPanel);
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
        customerPanel = new JPanel();
        customerPanel.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow"));
        customerPanel.setForeground(new Color(-4473925));
        customerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Customer", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
        firstName = new JTextField();
        CellConstraints cc = new CellConstraints();
        customerPanel.add(firstName, cc.xyw(3, 1, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        lastName = new JTextField();
        customerPanel.add(lastName, cc.xyw(3, 3, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        email = new JTextField();
        customerPanel.add(email, cc.xyw(3, 5, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        address = new JTextField();
        address.setText("");
        customerPanel.add(address, cc.xyw(3, 7, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        username = new JTextField();
        username.setText("");
        customerPanel.add(username, cc.xyw(3, 9, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label1 = new JLabel();
        label1.setText("First Name");
        customerPanel.add(label1, cc.xy(1, 1));
        final JLabel label2 = new JLabel();
        label2.setText("Last Name");
        customerPanel.add(label2, cc.xy(1, 3));
        final JLabel label3 = new JLabel();
        label3.setText("Email");
        customerPanel.add(label3, cc.xy(1, 5));
        final JLabel label4 = new JLabel();
        label4.setText("Address");
        customerPanel.add(label4, cc.xy(1, 7));
        final JLabel label5 = new JLabel();
        label5.setText("Username");
        customerPanel.add(label5, cc.xy(1, 9));
        password = new JPasswordField();
        password.setText("");
        customerPanel.add(password, cc.xyw(3, 11, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label6 = new JLabel();
        label6.setText("Password");
        customerPanel.add(label6, cc.xy(1, 11));
        customerScrollPanel = new JScrollPane();
        customerPanel.add(customerScrollPanel, cc.xyw(3, 15, 11, CellConstraints.FILL, CellConstraints.FILL));
        customerTable = new JTable();
        customerScrollPanel.setViewportView(customerTable);
        simpanButton = new JButton();
        simpanButton.setText("Simpan");
        customerPanel.add(simpanButton, cc.xy(3, 13));
        editButton = new JButton();
        editButton.setText("Edit");
        customerPanel.add(editButton, cc.xy(5, 13));
        hapusButton = new JButton();
        hapusButton.setText("Hapus");
        customerPanel.add(hapusButton, cc.xy(7, 13));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return customerPanel;
    }
}
