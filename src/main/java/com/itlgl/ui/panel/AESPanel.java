/*
 * Created by JFormDesigner on Fri Apr 27 22:43:56 CST 2018
 */

package com.itlgl.ui.panel;

import com.itlgl.cryptoutil.aes.AESException;
import com.itlgl.cryptoutil.aes.AESUtil;
import com.itlgl.cryptoutil.des.DesException;
import com.itlgl.cryptoutil.des.DesUtil;
import com.itlgl.java.util.ByteUtil;
import com.jgoodies.forms.factories.Borders;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author test
 */
public class AESPanel extends JPanel {
    public AESPanel() {
        initComponents();
    }

    private byte[] getICV() throws Exception {
        String icvStr = icvTextArea.getText().trim();
        byte[] icv = ByteUtil.fromHex(icvStr);
        if(icv == null || icv.length != 16) {
            throw new Exception("请输入16字节长度的ICV");
        }
        return icv;
    }

    private byte[] getKey() throws Exception {
        String keyStr = keyTextArea.getText().trim();
        byte[] key = ByteUtil.fromHex(keyStr);
        if(rbAes128Ecb.isSelected() || rbAes128Cbc.isSelected()) {
            if(key == null || key.length != 16) {
                throw new Exception("请输入16字节长度的KEY");
            }
        } else if(rbAes192Ecb.isSelected() || rbAes192Cbc.isSelected()) {
            if(key == null || key.length != 24) {
                throw new Exception("请输入24字节长度的KEY");
            }
        } else if(rbAes256Ecb.isSelected() || rbAes256Cbc.isSelected()) {
            if(key == null || key.length != 32) {
                throw new Exception("请输入32字节长度的KEY");
            }
        }
        return key;
    }

    private byte[] getInput() throws Exception {
        String inputStr = inputTextArea.getText().trim();
        byte[] input = ByteUtil.fromHex(inputStr);
        if(rbAes128Ecb.isSelected() || rbAes128Cbc.isSelected()) {
            if(input == null || input.length != 16) {
                throw new Exception("请输入16字节长度的数据");
            }
        } else if(rbAes192Ecb.isSelected() || rbAes192Cbc.isSelected()) {
            if(input == null || input.length != 24) {
                throw new Exception("请输入24字节长度的数据");
            }
        } else if(rbAes256Ecb.isSelected() || rbAes256Cbc.isSelected()) {
            if(input == null || input.length != 32) {
                throw new Exception("请输入32字节长度的数据");
            }
        }
        return input;
    }

    private void encryptActionPerformed(ActionEvent e) {
        byte[] key = null;
        try {
            key = getKey();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "加密失败！\n" + ex.getMessage());
            return;
        }
        byte[] icv = null;
        if(rbAes128Cbc.isSelected() || rbAes192Cbc.isSelected() || rbAes256Cbc.isSelected()) {
            try {
                icv = getICV();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "加密失败！\n" + ex.getMessage());
                return;
            }
        }
        byte[] input = null;
        try {
            input = getInput();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "加密失败！\n" + ex.getMessage());
            return;
        }
        byte[] output = null;
        try {
            if(rbAes128Ecb.isSelected()) {
                output = AESUtil.aes128Ecb(key, input, true);
            } else if(rbAes128Cbc.isSelected()) {
                output = AESUtil.aes128Cbc(key, icv, input, true);
            } else if(rbAes192Ecb.isSelected()) {
                output = AESUtil.aes192Ecb(key, input, true);
            } else if(rbAes192Cbc.isSelected()) {
                output = AESUtil.aes192Cbc(key, icv, input, true);
            } else if(rbAes256Ecb.isSelected()) {
                output = AESUtil.aes256Ecb(key, input, true);
            } else if(rbAes256Cbc.isSelected()) {
                output = AESUtil.aes256Cbc(key, icv, input, true);
            }
        } catch (AESException ex) {
            JOptionPane.showMessageDialog(this, "加密失败！\n" + ex.getMessage());
            return;
        }
        outputTextArea.setText(ByteUtil.toHex(output));
    }

    private void decryptActionPerformed(ActionEvent e) {
        byte[] key = null;
        try {
            key = getKey();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "解密失败！\n" + ex.getMessage());
            return;
        }
        byte[] icv = null;
        if(rbAes128Cbc.isSelected() || rbAes192Cbc.isSelected() || rbAes256Cbc.isSelected()) {
            try {
                icv = getICV();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "解密失败！\n" + ex.getMessage());
                return;
            }
        }
        byte[] input = null;
        try {
            input = getInput();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "解密失败！\n" + ex.getMessage());
            return;
        }
        byte[] output = null;
        try {
            if(rbAes128Ecb.isSelected()) {
                output = AESUtil.aes128Ecb(key, input, false);
            } else if(rbAes128Cbc.isSelected()) {
                output = AESUtil.aes128Cbc(key, icv, input, false);
            } else if(rbAes192Ecb.isSelected()) {
                output = AESUtil.aes192Ecb(key, input, false);
            } else if(rbAes192Cbc.isSelected()) {
                output = AESUtil.aes192Cbc(key, icv, input, false);
            } else if(rbAes256Ecb.isSelected()) {
                output = AESUtil.aes256Ecb(key, input, false);
            } else if(rbAes256Cbc.isSelected()) {
                output = AESUtil.aes256Cbc(key, icv, input, false);
            }
        } catch (AESException ex) {
            JOptionPane.showMessageDialog(this, "解密失败！\n" + ex.getMessage());
            return;
        }
        outputTextArea.setText(ByteUtil.toHex(output));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        rbAes128Ecb = new JRadioButton();
        rbAes192Ecb = new JRadioButton();
        rbAes256Ecb = new JRadioButton();
        rbAes128Cbc = new JRadioButton();
        rbAes192Cbc = new JRadioButton();
        rbAes256Cbc = new JRadioButton();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        icvTextArea = new JTextArea();
        panel4 = new JPanel();
        label4 = new JLabel();
        scrollPane4 = new JScrollPane();
        keyTextArea = new JTextArea();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        inputTextArea = new JTextArea();
        label3 = new JLabel();
        scrollPane3 = new JScrollPane();
        outputTextArea = new JTextArea();
        panel6 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setBorder(Borders.DLU4);
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {500, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {105, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

        //======== panel1 ========
        {
            panel1.setBorder(new CompoundBorder(
                new TitledBorder("\u6a21\u5f0f\u9009\u62e9"),
                new EmptyBorder(5, 5, 5, 5)));
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

            //---- rbAes128Ecb ----
            rbAes128Ecb.setText("AES 128 ECB");
            rbAes128Ecb.setSelected(true);
            panel1.add(rbAes128Ecb, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- rbAes192Ecb ----
            rbAes192Ecb.setText("AES 192 ECB");
            panel1.add(rbAes192Ecb, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- rbAes256Ecb ----
            rbAes256Ecb.setText("AES 256 ECB");
            panel1.add(rbAes256Ecb, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- rbAes128Cbc ----
            rbAes128Cbc.setText("AES 128 CBC");
            panel1.add(rbAes128Cbc, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- rbAes192Cbc ----
            rbAes192Cbc.setText("AES 192 CBC");
            panel1.add(rbAes192Cbc, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- rbAes256Cbc ----
            rbAes256Cbc.setText("AES 256 CBC");
            panel1.add(rbAes256Cbc, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {45, 0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //======== panel3 ========
            {
                panel3.setBorder(new CompoundBorder(
                    new TitledBorder("ICV"),
                    Borders.DLU2));
                panel3.setLayout(new GridBagLayout());
                ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {25, 0};
                ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("CBC\u6a21\u5f0f\u65f6\u7684\u5411\u91cf\uff1a");
                label1.setBorder(null);
                panel3.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- icvTextArea ----
                    icvTextArea.setText("00000000000000000000000000000000");
                    scrollPane1.setViewportView(icvTextArea);
                }
                panel3.add(scrollPane1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel2.add(panel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel4 ========
            {
                panel4.setLayout(new GridBagLayout());
                ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {30, 105, 105, 0, 0};
                ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- label4 ----
                label4.setText("\u5bc6\u94a5\uff1a");
                panel4.add(label4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(keyTextArea);
                }
                panel4.add(scrollPane4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label2 ----
                label2.setText("\u8f93\u5165\uff1a");
                label2.setVerticalAlignment(SwingConstants.TOP);
                panel4.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== scrollPane2 ========
                {

                    //---- inputTextArea ----
                    inputTextArea.setLineWrap(true);
                    inputTextArea.setMinimumSize(new Dimension(511, 200));
                    inputTextArea.setWrapStyleWord(true);
                    scrollPane2.setViewportView(inputTextArea);
                }
                panel4.add(scrollPane2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label3 ----
                label3.setText("\u8f93\u51fa\uff1a");
                label3.setVerticalAlignment(SwingConstants.TOP);
                panel4.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== scrollPane3 ========
                {

                    //---- outputTextArea ----
                    outputTextArea.setLineWrap(true);
                    scrollPane3.setViewportView(outputTextArea);
                }
                panel4.add(scrollPane3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== panel6 ========
                {
                    panel6.setLayout(new GridBagLayout());

                    //---- button1 ----
                    button1.setText("\u52a0\u5bc6");
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            encryptActionPerformed(e);
                        }
                    });
                    panel6.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- button2 ----
                    button2.setText("\u89e3\u5bc6");
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            decryptActionPerformed(e);
                        }
                    });
                    panel6.add(button2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel4.add(panel6, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel2.add(panel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rbAes128Ecb);
        buttonGroup1.add(rbAes192Ecb);
        buttonGroup1.add(rbAes256Ecb);
        buttonGroup1.add(rbAes128Cbc);
        buttonGroup1.add(rbAes192Cbc);
        buttonGroup1.add(rbAes256Cbc);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JRadioButton rbAes128Ecb;
    private JRadioButton rbAes192Ecb;
    private JRadioButton rbAes256Ecb;
    private JRadioButton rbAes128Cbc;
    private JRadioButton rbAes192Cbc;
    private JRadioButton rbAes256Cbc;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTextArea icvTextArea;
    private JPanel panel4;
    private JLabel label4;
    private JScrollPane scrollPane4;
    private JTextArea keyTextArea;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTextArea inputTextArea;
    private JLabel label3;
    private JScrollPane scrollPane3;
    private JTextArea outputTextArea;
    private JPanel panel6;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
