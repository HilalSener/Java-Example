
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class game extends javax.swing.JFrame {

    static int[][] userGrid= {
        /*
            {8, 3, 0, 1, 0, 0, 6, 0, 5},
            {0, 0, 0, 0, 0, 0, 0, 8, 0},
            {0, 0, 0, 7, 0, 0, 9, 0, 0},
            {0, 5, 0, 0, 1, 7, 0, 0, 0}, 
            {0, 0, 3, 0, 0, 0, 2, 0, 0},
            {0, 0, 0, 3, 4, 0, 0, 1, 0},
            {0, 0, 4, 0, 0, 8, 0, 0, 0},
            {0, 9, 0, 0, 0, 0, 0, 0, 0},
            {3, 0, 2, 0, 0, 6, 0, 4, 7}
        */
            {1,0,0,0,0,0,0,0,0},
            {2,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };
    
    static JTextField[][] tfCells = new JTextField[9][9];
    
    public game() {
        initComponents();
        puzzlePane.setVisible(false);
        setSize(500, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        puzzlePane.setLayout(new GridLayout(9 , 9));
        
        InputListener listener = new InputListener();
        
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                tfCells[y][x] = new JTextField();
                puzzlePane.add(tfCells[y][x]);
                if (userGrid[y][x] == 0) {
                    tfCells[y][x].setText("");     // Sıfır yazan yerleri boş göstermek için
                    tfCells[y][x].setEditable(true);
                    tfCells[y][x].setBackground(Color.YELLOW);

                    tfCells[y][x].addActionListener(listener);   // Düzenlenebilen tüm satır ve sütunlar için
                } else {
                    tfCells[y][x].setText(userGrid[y][x] + "");
                    tfCells[y][x].setEditable(false);
                    tfCells[y][x].setBackground(Color.LIGHT_GRAY);
                    tfCells[y][x].setForeground(Color.BLACK);
                }
                tfCells[y][x].setHorizontalAlignment(JTextField.CENTER);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputPane = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        puzzlePane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel1.setText("Input dosya yolunu giriniz");

        javax.swing.GroupLayout inputPaneLayout = new javax.swing.GroupLayout(inputPane);
        inputPane.setLayout(inputPaneLayout);
        inputPaneLayout.setHorizontalGroup(
            inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStart)
                .addContainerGap())
            .addGroup(inputPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        inputPaneLayout.setVerticalGroup(
            inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart)))
        );

        javax.swing.GroupLayout puzzlePaneLayout = new javax.swing.GroupLayout(puzzlePane);
        puzzlePane.setLayout(puzzlePaneLayout);
        puzzlePaneLayout.setHorizontalGroup(
            puzzlePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        puzzlePaneLayout.setVerticalGroup(
            puzzlePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(puzzlePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inputPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(puzzlePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        puzzlePane.setVisible(true);
    }//GEN-LAST:event_btnStartActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game().setVisible(true);
            }
        });
    }

    private class InputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
         int rowSelected = -1;
         int colSelected = -1;
 
         JTextField source = (JTextField)e.getSource();
         
         boolean found = false;
         for (int row = 0; row < 9 && !found; ++row) {
            for (int col = 0; col < 9 && !found; ++col) {
               if (tfCells[row][col] == source) {
                  rowSelected = row;
                  colSelected = col;
                  found = true;  
               }
            }
         }
         
         Controller c = new Controller();
             
         if(!c.checkRow(rowSelected, colSelected, tfCells))
         {
             tfCells[rowSelected][colSelected].setBackground(Color.RED);
             JOptionPane.showMessageDialog(
                                        null, 
                                        "Bu satır aynı sayıdan var!", 
                                        "Uyarı",
                                        JOptionPane.INFORMATION_MESSAGE
             );
         }
         else if(!c.checkColumn(rowSelected, colSelected, tfCells))
         {
             JOptionPane.showMessageDialog(
                                        null, 
                                        "Bu sütun aynı sayıdan var!", 
                                        "Uyarı",
                                        JOptionPane.INFORMATION_MESSAGE
             );
             tfCells[rowSelected][colSelected].setBackground(Color.RED);
         }
         else if(!c.checkSquare(rowSelected, colSelected, tfCells))
         {
             JOptionPane.showMessageDialog(
                                        null, 
                                        "Bu karede aynı sayıdan var!", 
                                        "Uyarı",
                                        JOptionPane.INFORMATION_MESSAGE
             );
             tfCells[rowSelected][colSelected].setBackground(Color.RED);
         }
         else if(!c.isValidRow(rowSelected, colSelected, tfCells))
         {
             tfCells[rowSelected][colSelected].setBackground(Color.RED);

             JOptionPane.showMessageDialog(
                                        null, 
                                        "Sadece sayı girişi yapılabilir", 
                                        "Uyarı",
                                        JOptionPane.INFORMATION_MESSAGE
             );
         }
         else 
             tfCells[rowSelected][colSelected].setBackground(Color.GREEN);
        }
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JPanel inputPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel puzzlePane;
    // End of variables declaration//GEN-END:variables
}
