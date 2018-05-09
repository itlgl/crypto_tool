/*
 * Created by JFormDesigner on Tue Apr 17 16:39:03 GMT+08:00 2018
 */

package com.itlgl.ui.panel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;

/**
 * @author itlgl
 */
public class DESPanel extends JPanel {
    public DESPanel() {
        initComponents();
    }

    private void encryptActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void decryptActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        rbDesEcb = new JRadioButton();
        rb3DesEdeEcb = new JRadioButton();
        rb3DesEeeEcb = new JRadioButton();
        rbDesCbc = new JRadioButton();
        rb3DesEdeCbc = new JRadioButton();
        rb3DesEeeCbc = new JRadioButton();
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

            //---- rbDesEcb ----
            rbDesEcb.setText("DES ECB");
            rbDesEcb.setSelected(true);
            panel1.add(rbDesEcb, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- rb3DesEdeEcb ----
            rb3DesEdeEcb.setText("3DES EDE ECB");
            panel1.add(rb3DesEdeEcb, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- rb3DesEeeEcb ----
            rb3DesEeeEcb.setText("3DES EEE ECB");
            panel1.add(rb3DesEeeEcb, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- rbDesCbc ----
            rbDesCbc.setText("DES CBC");
            panel1.add(rbDesCbc, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- rb3DesEdeCbc ----
            rb3DesEdeCbc.setText("3DES EDE CBC");
            panel1.add(rb3DesEdeCbc, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- rb3DesEeeCbc ----
            rb3DesEeeCbc.setText("3DES EEE CBC");
            panel1.add(rb3DesEeeCbc, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
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
                    icvTextArea.setText("0000000000000000");
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
        buttonGroup1.add(rbDesEcb);
        buttonGroup1.add(rb3DesEdeEcb);
        buttonGroup1.add(rb3DesEeeEcb);
        buttonGroup1.add(rbDesCbc);
        buttonGroup1.add(rb3DesEdeCbc);
        buttonGroup1.add(rb3DesEeeCbc);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JRadioButton rbDesEcb;
    private JRadioButton rb3DesEdeEcb;
    private JRadioButton rb3DesEeeEcb;
    private JRadioButton rbDesCbc;
    private JRadioButton rb3DesEdeCbc;
    private JRadioButton rb3DesEeeCbc;
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
