/*
 * The MIT License
 *
 * Copyright 2015 Eziama Ubachukwu (eziama.ubachukwu@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package inf2b.algobench.ui.components;

import inf2b.algobench.util.ITaskSubPanel;
import javax.swing.JPanel;

/**
 *
 * @author Nevena Blagoeva
 */
public class QueueTaskSubPanel extends JPanel implements ITaskSubPanel {

    /**
     * Creates new form QueueTaskSubPanel
     */
    public QueueTaskSubPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelQueue = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelNumRuns = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNumCompletedTasks = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCurrentInputSize = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelMemUsage = new javax.swing.JLabel();
        jLabelLimitsLabel1 = new javax.swing.JLabel();
        jLabelPercentage = new javax.swing.JLabel();
        jPanelDetailSearch = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelStartSize = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelStepSize = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelOpType = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelFinalSize = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelDataElement = new javax.swing.JLabel();
        jLabelElem = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.GridLayout(1, 0));

        jPanelQueue.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Execution Progress Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, jLabel2.getFont()));
        jPanelQueue.setOpaque(false);
        jPanelQueue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(jLabel4.getFont().deriveFont((float)13));
        jLabel4.setText("No. of scheduled tasks:");
        jPanelQueue.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 110, 185, 20));

        jLabelNumRuns.setFont(jLabelNumRuns.getFont().deriveFont((float)13));
        jLabelNumRuns.setText("--");
        jPanelQueue.add(jLabelNumRuns, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 110, 150, 20));

        jLabel5.setFont(jLabel5.getFont().deriveFont((float)13));
        jLabel5.setText("No. of completed tasks:");
        jPanelQueue.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 145, 185, 20));

        jLabelNumCompletedTasks.setFont(jLabelNumCompletedTasks.getFont().deriveFont((float)13));
        jLabelNumCompletedTasks.setText("--");
        jPanelQueue.add(jLabelNumCompletedTasks, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 145, 150, 20));

        jLabel7.setFont(jLabel7.getFont().deriveFont((float)13));
        jLabel7.setText("Current input size:");
        jPanelQueue.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 40, 185, 20));

        jLabelCurrentInputSize.setFont(jLabelCurrentInputSize.getFont().deriveFont((float)13));
        jLabelCurrentInputSize.setText("--");
        jPanelQueue.add(jLabelCurrentInputSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 40, 150, 20));

        jLabel8.setFont(jLabel8.getFont().deriveFont((float)13));
        jLabel8.setText("Memory footprint (approx.):");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(150, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanelQueue.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 75, 185, 20));

        jLabelMemUsage.setFont(jLabelMemUsage.getFont().deriveFont((float)13));
        jLabelMemUsage.setForeground(new java.awt.Color(255, 0, 51));
        jLabelMemUsage.setText("--");
        jPanelQueue.add(jLabelMemUsage, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 75, 150, 20));

        jLabelLimitsLabel1.setFont(jLabelLimitsLabel1.getFont().deriveFont((float)13));
        jLabelLimitsLabel1.setText("Percentage completion:");
        jPanelQueue.add(jLabelLimitsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 180, 185, 20));

        jLabelPercentage.setFont(jLabelPercentage.getFont().deriveFont(jLabelPercentage.getFont().getStyle() | java.awt.Font.BOLD, 13));
        jLabelPercentage.setText("--");
        jPanelQueue.add(jLabelPercentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 180, 150, 20));

        add(jPanelQueue);

        jPanelDetailSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input Setup Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, jLabel6.getFont()));
        jPanelDetailSearch.setOpaque(false);
        jPanelDetailSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)13));
        jLabel2.setText("Initial size:");
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(150, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanelDetailSearch.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 40, 150, 20));

        jLabelStartSize.setFont(jLabelStartSize.getFont().deriveFont((float)13));
        jLabelStartSize.setText("--");
        jPanelDetailSearch.add(jLabelStartSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 40, 180, 20));

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)13));
        jLabel3.setText("Increment size:");
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 20));
        jLabel3.setMinimumSize(new java.awt.Dimension(150, 20));
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanelDetailSearch.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 110, 150, 20));

        jLabelStepSize.setFont(jLabelStepSize.getFont().deriveFont((float)13));
        jLabelStepSize.setText("--");
        jPanelDetailSearch.add(jLabelStepSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 110, 180, 20));

        jLabel12.setFont(jLabel12.getFont().deriveFont((float)13));
        jLabel12.setText("Operation:");
        jLabel12.setMaximumSize(new java.awt.Dimension(150, 20));
        jLabel12.setMinimumSize(new java.awt.Dimension(150, 20));
        jLabel12.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanelDetailSearch.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 145, 150, -1));

        jLabelOpType.setFont(jLabelOpType.getFont().deriveFont((float)13));
        jLabelOpType.setText("--");
        jPanelDetailSearch.add(jLabelOpType, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 145, 180, 20));

        jLabel6.setFont(jLabel6.getFont().deriveFont((float)13));
        jLabel6.setText("Final size:");
        jLabel6.setMaximumSize(new java.awt.Dimension(150, 20));
        jLabel6.setMinimumSize(new java.awt.Dimension(150, 20));
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanelDetailSearch.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 75, 150, 20));

        jLabelFinalSize.setFont(jLabelFinalSize.getFont().deriveFont((float)13));
        jLabelFinalSize.setText("--");
        jPanelDetailSearch.add(jLabelFinalSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 75, 180, 20));

        jLabel13.setFont(jLabel13.getFont().deriveFont((float)13));
        jLabel13.setText("Operation:");
        jLabel13.setMaximumSize(new java.awt.Dimension(150, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(150, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanelDetailSearch.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 165, 150, 0));

        jLabelDataElement.setFont(jLabelDataElement.getFont().deriveFont((float)13));
        jLabelDataElement.setText("Data Element:");
        jPanelDetailSearch.add(jLabelDataElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 180, 185, 20));

        jLabelElem.setFont(jLabelElem.getFont().deriveFont((float)13));
        jLabelElem.setText("--");
        jPanelDetailSearch.add(jLabelElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 179, 200, 20));

        add(jPanelDetailSearch);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void setInputSize(String size) {
        jLabelCurrentInputSize.setText(size);
    }

    @Override
    public void setCurrentSize(String currentSize) {
        jLabelCurrentInputSize.setText(currentSize);
    }

    @Override
    public void setInitialSize(String startSize) {
        jLabelStartSize.setText(startSize);
    }

    @Override
    public void setFinalSize(String startSize) {
        jLabelFinalSize.setText(startSize);
    }

    @Override
    public void setStepSize(String stepSize) {
        jLabelStepSize.setText(stepSize);
    }

    @Override
    public void setNumCompletedTasks(String numCompletedTasks) {
        jLabelNumCompletedTasks.setText(numCompletedTasks);
        Integer p = Integer.parseInt(numCompletedTasks) * 100
                / Integer.parseInt(jLabelNumRuns.getText());
        jLabelPercentage.setText(p.toString() + "%");
    }

    @Override
    public void setMemUsage(String memUsage) {
        jLabelMemUsage.setText(memUsage);
    }

    @Override
    public void setNumTasks(String numTasks) {
        jLabelNumRuns.setText(numTasks);
    }

    public void setOpType(String opType){
        jLabelOpType.setText(opType);
    }
    
    public void setDataElement(String element){
        jLabelElem.setText(element);
    }
    
    public void setMinInputValue(String minInputValue) {
        this.jLabelOpType.setText(minInputValue);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCurrentInputSize;
    private javax.swing.JLabel jLabelDataElement;
    private javax.swing.JLabel jLabelElem;
    private javax.swing.JLabel jLabelFinalSize;
    private javax.swing.JLabel jLabelLimitsLabel1;
    private javax.swing.JLabel jLabelMemUsage;
    private javax.swing.JLabel jLabelNumCompletedTasks;
    private javax.swing.JLabel jLabelNumRuns;
    private javax.swing.JLabel jLabelOpType;
    private javax.swing.JLabel jLabelPercentage;
    private javax.swing.JLabel jLabelStartSize;
    private javax.swing.JLabel jLabelStepSize;
    private javax.swing.JPanel jPanelDetailSearch;
    private javax.swing.JPanel jPanelQueue;
    // End of variables declaration//GEN-END:variables

}
