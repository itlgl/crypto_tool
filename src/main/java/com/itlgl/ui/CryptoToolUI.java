package com.itlgl.ui;

import java.awt.*;
import javax.swing.*;
import com.itlgl.ui.panel.*;

public class CryptoToolUI extends JFrame {

    public CryptoToolUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        baseEncodeDecodePanel1 = new BaseEncodeDecodePanel();
        dESPanel1 = new DESPanel();
        aESPanel1 = new AESPanel();

        //======== this ========
        setTitle("Crypto Tool");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== tabbedPane1 ========
        {
            tabbedPane1.addTab(" Base\u7f16\u89e3\u7801 ", baseEncodeDecodePanel1);
            tabbedPane1.addTab(" DES ", dESPanel1);
            tabbedPane1.addTab(" AES ", aESPanel1);
        }
        contentPane.add(tabbedPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private BaseEncodeDecodePanel baseEncodeDecodePanel1;
    private DESPanel dESPanel1;
    private AESPanel aESPanel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                CryptoToolUI cryptoToolUI = new CryptoToolUI();
                cryptoToolUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cryptoToolUI.setVisible(true);
            }
        });
    }
}
