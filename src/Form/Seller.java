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

public class Seller {
    private DefaultTableModel DftTblModel_seller;
    private String SQL;

    private JTextField firstName;
    private JPanel sellerPanel;
    private JTextField lastName;
    private JTextField email;
    private JTextField address;
    private JTextField username;
    private JPasswordField password;
    private JTable sellerTable;
    private JScrollPane sellerScrollPanel;
    private JButton simpanButton;
    private JButton editButton;
    private JButton hapusButton;

    public Seller() {
        this.TampilData();
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Connection conn = Database.getConnection();
                    PreparedStatement stmt = conn.prepareStatement("insert into sellers(username,password,first_name,last_name,email,address) values(?,?,?,?,?,?)");
                    stmt.setString(1, username.getText());
                    stmt.setString(2, password.getPassword().toString());
                    stmt.setString(3, firstName.getText());
                    stmt.setString(4, lastName.getText());
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
                    PreparedStatement stmt = conn.prepareStatement("update sellers set username=?,password=?,first_name=?,last_name=?,email=?,address=? where username=?");
                    stmt.setString(1, username.getText());
                    stmt.setString(2, password.getPassword().toString());
                    stmt.setString(3, firstName.getText());
                    stmt.setString(4, lastName.getText());
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
                        PreparedStatement stmt = conn.prepareStatement("delete from sellers where username ='" + username.getText() + "'");
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                        TampilData();
                        username.setText("");
                        password.setText("");
                        firstName.setText("");
                        lastName.setText("");
                        email.setText("");
                        address.setText("");
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Data gagal di hapus" + e.getMessage(), "Pesan", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        sellerTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = sellerTable.getSelectedRow();
                username.setText(DftTblModel_seller.getValueAt(baris, 0).toString());
                password.setText(DftTblModel_seller.getValueAt(baris, 1).toString());
                firstName.setText(DftTblModel_seller.getValueAt(baris, 2).toString());
                lastName.setText(DftTblModel_seller.getValueAt(baris, 3).toString());
                email.setText(DftTblModel_seller.getValueAt(baris, 4).toString());
                address.setText(DftTblModel_seller.getValueAt(baris, 5).toString());
            }
        });
    }

    public void TampilData() {
        DftTblModel_seller = new DefaultTableModel();
        DftTblModel_seller.addColumn("Username");
        DftTblModel_seller.addColumn("Password");
        DftTblModel_seller.addColumn("First Name");
        DftTblModel_seller.addColumn("Last Name");
        DftTblModel_seller.addColumn("Email");
        DftTblModel_seller.addColumn("Address");
        sellerTable.setModel(DftTblModel_seller);
        Connection conn = Database.getConnection();
        try {
            Statement stmt = conn.createStatement();
            SQL = "select * from sellers";
            ResultSet res = stmt.executeQuery(SQL);
            while (res.next()) {
                DftTblModel_seller.addRow(new Object[]{
                        res.getString("username"),
                        res.getString("password"),
                        res.getString("first_name"),
                        res.getString("last_name"),
                        res.getString("email"),
                        res.getString("address")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Seller");
        frame.setContentPane(new Seller().sellerPanel);
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
        sellerPanel = new JPanel();
        sellerPanel.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:grow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow"));
        sellerPanel.setForeground(new Color(-4473925));
        sellerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Seller", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, null, null));
        firstName = new JTextField();
        CellConstraints cc = new CellConstraints();
        sellerPanel.add(firstName, cc.xyw(3, 1, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        lastName = new JTextField();
        sellerPanel.add(lastName, cc.xyw(3, 3, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        email = new JTextField();
        sellerPanel.add(email, cc.xyw(3, 5, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        address = new JTextField();
        address.setText("");
        sellerPanel.add(address, cc.xyw(3, 7, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        username = new JTextField();
        username.setText("");
        sellerPanel.add(username, cc.xyw(3, 9, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label1 = new JLabel();
        label1.setText("First Name");
        sellerPanel.add(label1, cc.xy(1, 1));
        final JLabel label2 = new JLabel();
        label2.setText("Last Name");
        sellerPanel.add(label2, cc.xy(1, 3));
        final JLabel label3 = new JLabel();
        label3.setText("Email");
        sellerPanel.add(label3, cc.xy(1, 5));
        final JLabel label4 = new JLabel();
        label4.setText("Address");
        sellerPanel.add(label4, cc.xy(1, 7));
        final JLabel label5 = new JLabel();
        label5.setText("Username");
        sellerPanel.add(label5, cc.xy(1, 9));
        password = new JPasswordField();
        password.setText("");
        sellerPanel.add(password, cc.xyw(3, 11, 11, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label6 = new JLabel();
        label6.setText("Password");
        sellerPanel.add(label6, cc.xy(1, 11));
        sellerScrollPanel = new JScrollPane();
        sellerPanel.add(sellerScrollPanel, cc.xyw(3, 15, 11, CellConstraints.FILL, CellConstraints.FILL));
        sellerTable = new JTable();
        sellerScrollPanel.setViewportView(sellerTable);
        simpanButton = new JButton();
        simpanButton.setText("Simpan");
        sellerPanel.add(simpanButton, cc.xy(3, 13));
        editButton = new JButton();
        editButton.setText("Edit");
        sellerPanel.add(editButton, cc.xy(5, 13));
        hapusButton = new JButton();
        hapusButton.setText("Hapus");
        sellerPanel.add(hapusButton, cc.xy(7, 13));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return sellerPanel;
    }
}
