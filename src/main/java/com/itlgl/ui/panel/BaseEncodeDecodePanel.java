/*
 * Created by JFormDesigner on Tue Apr 24 22:09:43 CST 2018
 */

package com.itlgl.ui.panel;

import javax.swing.border.*;
import com.google.common.io.BaseEncoding;
import com.itlgl.encode.base58.Base58;
import com.itlgl.java.util.ByteUtil;
import com.jgoodies.forms.factories.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;

/**
 * @author test
 */
public class BaseEncodeDecodePanel extends JPanel {
    public BaseEncodeDecodePanel() {
        initComponents();
    }

    byte[] getInputByte() throws Exception {
        byte[] result = null;
        if(rbInputHEX.isSelected()) {
            result = ByteUtil.fromHex(inputTextArea.getText());
        } else if(rbInputUTF8.isSelected()) {
            try {
                result = inputTextArea.getText().getBytes("utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new Exception("机器不支持UTF-8编码");
            }
        } else if(rbInputGBK.isSelected()) {
            try {
                result = inputTextArea.getText().getBytes("gbk");
            } catch (UnsupportedEncodingException e) {
                throw new Exception("机器不支持GBK编码");
            }
        }
        if(result == null) {
            throw new Exception("请输入Input的数据");
        }
        return result;
    }

    void setOutputText(byte[] output) throws Exception {
        if(rbOutputHEX.isSelected()) {
            outputTextArea.setText(ByteUtil.toHex(output));
        } else if(rbOutputUTF8.isSelected()) {
            try {
                outputTextArea.setText(new String(output, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new Exception("编码失败！\n" + e.getMessage());
            }
        } else if(rbOutputGBK.isSelected()) {
            try {
                outputTextArea.setText(new String(output, "GBK"));
            } catch (UnsupportedEncodingException e) {
                throw new Exception("编码失败！\n" + e.getMessage());
            }
        }
    }

    public String encode(byte[] src) throws Exception {
        if(rbBase64.isSelected()) {
            return BaseEncoding.base64().encode(src);
        } else if(rbBase64Url.isSelected()) {
            return BaseEncoding.base64Url().encode(src);
        } else if(rbBase32.isSelected()) {
            return BaseEncoding.base32().encode(src);
        } else if(rbBase32Hex.isSelected()) {
            return BaseEncoding.base32Hex().encode(src);
        } else if(rbBase58.isSelected()) {
            return Base58.toBase58(src);
        } else if(rbBase16.isSelected()) {
            return BaseEncoding.base16().encode(src);
        }
        throw new Exception("请选择一种编码方式");
    }

    public byte[] decode(String src) throws Exception {
        if(rbBase64.isSelected()) {
            return BaseEncoding.base64().decode(src);
        } else if(rbBase64Url.isSelected()) {
            return BaseEncoding.base64Url().decode(src);
        } else if(rbBase32.isSelected()) {
            return BaseEncoding.base32().decode(src);
        } else if(rbBase32Hex.isSelected()) {
            return BaseEncoding.base32Hex().decode(src);
        } else if(rbBase58.isSelected()) {
            return Base58.fromBase58(src);
        } else if(rbBase16.isSelected()) {
            return BaseEncoding.base16().decode(src);
        }
        throw new Exception("请选择一种解码方式");
    }

    private void encodeActionPerformed(ActionEvent e) {
        byte[] input = null;
        try {
            input = getInputByte();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
        String result = null;
        try {
            result = encode(input);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "编码失败！\n" + ex.getMessage());
            return;
        }
        outputTextArea.setText(result);
    }

    private void decodeActionPerformed(ActionEvent e) {
        String input = null;
        try {
            input = inputTextArea.getText().trim();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
        byte[] result = null;
        try {
            result = decode(input);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "解码失败！\n" + ex.getMessage());
            return;
        }
        try {
            setOutputText(result);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        panel6 = new JPanel();
        panel3 = new JPanel();
        rbBase64 = new JRadioButton();
        rbBase64Url = new JRadioButton();
        rbBase32 = new JRadioButton();
        rbBase32Hex = new JRadioButton();
        rbBase58 = new JRadioButton();
        rbBase16 = new JRadioButton();
        label1 = new JLabel();
        panel7 = new JPanel();
        label4 = new JLabel();
        rbInputHEX = new JRadioButton();
        rbInputUTF8 = new JRadioButton();
        rbInputGBK = new JRadioButton();
        scrollPane1 = new JScrollPane();
        inputTextArea = new JTextArea();
        label2 = new JLabel();
        panel8 = new JPanel();
        label5 = new JLabel();
        rbOutputHEX = new JRadioButton();
        rbOutputUTF8 = new JRadioButton();
        rbOutputGBK = new JRadioButton();
        scrollPane2 = new JScrollPane();
        outputTextArea = new JTextArea();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {500, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {300, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== panel1 ========
        {
            panel1.setBorder(Borders.DLU4);
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //======== panel6 ========
            {
                panel6.setLayout(new GridBagLayout());
                ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 300, 0};
                ((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 35, 105, 35, 105, 30, 0};
                ((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== panel3 ========
                {
                    panel3.setBorder(new CompoundBorder(
                        new TitledBorder("\u6a21\u5f0f\u9009\u62e9"),
                        new EmptyBorder(5, 5, 5, 5)));
                    panel3.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {135, 130};
                    ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {1.0, 1.0};

                    //---- rbBase64 ----
                    rbBase64.setText("Base64");
                    rbBase64.setSelected(true);
                    panel3.add(rbBase64, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- rbBase64Url ----
                    rbBase64Url.setText("Base64 URL");
                    panel3.add(rbBase64Url, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- rbBase32 ----
                    rbBase32.setText("Base32");
                    panel3.add(rbBase32, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- rbBase32Hex ----
                    rbBase32Hex.setText("Base32 HEX");
                    panel3.add(rbBase32Hex, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- rbBase58 ----
                    rbBase58.setText("Base58");
                    panel3.add(rbBase58, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- rbBase16 ----
                    rbBase16.setText("Base16");
                    panel3.add(rbBase16, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel6.add(panel3, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label1 ----
                label1.setText("\u8f93\u5165\uff1a");
                panel6.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel7 ========
                {
                    panel7.setLayout(new GridBagLayout());

                    //---- label4 ----
                    label4.setText("\u8f93\u6570\u636e\u7f16\u7801(\u7f16\u7801\u65f6\u7528):");
                    panel7.add(label4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- rbInputHEX ----
                    rbInputHEX.setText("HEX");
                    rbInputHEX.setSelected(true);
                    panel7.add(rbInputHEX, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- rbInputUTF8 ----
                    rbInputUTF8.setText("UTF-8");
                    panel7.add(rbInputUTF8, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- rbInputGBK ----
                    rbInputGBK.setText("GBK");
                    panel7.add(rbInputGBK, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel6.add(panel7, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- inputTextArea ----
                    inputTextArea.setLineWrap(true);
                    scrollPane1.setViewportView(inputTextArea);
                }
                panel6.add(scrollPane1, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label2 ----
                label2.setText("\u8f93\u51fa\uff1a");
                panel6.add(label2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //======== panel8 ========
                {
                    panel8.setLayout(new GridBagLayout());

                    //---- label5 ----
                    label5.setText("\u8f93\u51fa\u6570\u636e\u7f16\u7801(\u89e3\u7801\u65f6\u7528):");
                    panel8.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- rbOutputHEX ----
                    rbOutputHEX.setText("HEX");
                    rbOutputHEX.setSelected(true);
                    panel8.add(rbOutputHEX, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- rbOutputUTF8 ----
                    rbOutputUTF8.setText("UTF-8");
                    panel8.add(rbOutputUTF8, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- rbOutputGBK ----
                    rbOutputGBK.setText("GBK");
                    panel8.add(rbOutputGBK, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel6.add(panel8, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== scrollPane2 ========
                {

                    //---- outputTextArea ----
                    outputTextArea.setLineWrap(true);
                    scrollPane2.setViewportView(outputTextArea);
                }
                panel6.add(scrollPane2, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== panel2 ========
                {
                    panel2.setLayout(new GridBagLayout());

                    //---- button1 ----
                    button1.setText("\u7f16\u7801");
                    button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 4f));
                    button1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            encodeActionPerformed(e);
                        }
                    });
                    panel2.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- button2 ----
                    button2.setText("\u89e3\u7801");
                    button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
                    button2.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            decodeActionPerformed(e);
                        }
                    });
                    panel2.add(button2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel6.add(panel2, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel1.add(panel6, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- buttonGroup3 ----
        ButtonGroup buttonGroup3 = new ButtonGroup();
        buttonGroup3.add(rbBase64);
        buttonGroup3.add(rbBase64Url);
        buttonGroup3.add(rbBase32);
        buttonGroup3.add(rbBase32Hex);
        buttonGroup3.add(rbBase58);
        buttonGroup3.add(rbBase16);

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rbInputHEX);
        buttonGroup1.add(rbInputUTF8);
        buttonGroup1.add(rbInputGBK);

        //---- buttonGroup2 ----
        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(rbOutputHEX);
        buttonGroup2.add(rbOutputUTF8);
        buttonGroup2.add(rbOutputGBK);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel6;
    private JPanel panel3;
    private JRadioButton rbBase64;
    private JRadioButton rbBase64Url;
    private JRadioButton rbBase32;
    private JRadioButton rbBase32Hex;
    private JRadioButton rbBase58;
    private JRadioButton rbBase16;
    private JLabel label1;
    private JPanel panel7;
    private JLabel label4;
    private JRadioButton rbInputHEX;
    private JRadioButton rbInputUTF8;
    private JRadioButton rbInputGBK;
    private JScrollPane scrollPane1;
    private JTextArea inputTextArea;
    private JLabel label2;
    private JPanel panel8;
    private JLabel label5;
    private JRadioButton rbOutputHEX;
    private JRadioButton rbOutputUTF8;
    private JRadioButton rbOutputGBK;
    private JScrollPane scrollPane2;
    private JTextArea outputTextArea;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
