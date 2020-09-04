package letterarrangement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LetterArrangement extends javax.swing.JFrame {
    
    //Variables declration
    
    String[] numberOfWords = {"SUN" , "GAME" , "MONDAY" , "HELP" , "TO" }; //First we define Words, which should have letter less and equal to 6(why 6? because we initilize only 6 button and label in design part if we have more then 6 letter than should initilaze that much label and button)
    int totalNumberOfWords = 5; //5 words present in numberOfWords Array 
    String word; //takes one word from numberOfWords[]
    int letter_present_in_word; //how many letter in word suppose word="TO" then letter_present_in_word = 2
    
    boolean ClickButton1 = true; // from ClickButton1 to ClickButton6 it keep track of Button Click 
    boolean ClickButton2 = true; // ClickButton1 Track on JButton1 and ClickButton2 track on JButoon2.
    boolean ClickButton3 = true; // when it true , for example ClickButton1 = true then text on JButton1 is copy to JLabel's
    boolean ClickButton4 = true; // when it false , for example ClickButton1 = false then it just remove text from JLabel
    boolean ClickButton5 = true;
    boolean ClickButton6 = true;
    
    int moves=12; // Total moves for each Letter Arrangement is 12,Click on any Button Value of moves Decrement
    
    
    public LetterArrangement() {
        initComponents();
        randomWordsFromNumberOfWords();
        setVisibleBoxes();
        setValuesOnBox();
    }
    
    //this method helps to choose perticular word from Array ofnumberOfWords
    public void randomWordsFromNumberOfWords()
     {
          if(totalNumberOfWords > 0)
         {    
            int random_words = (int)(Math.random() * totalNumberOfWords); 
            word = numberOfWords[random_words];
            if(random_words < totalNumberOfWords-1) 
                 numberOfWords[random_words] = numberOfWords[totalNumberOfWords-1];
            totalNumberOfWords--;
            letter_present_in_word = word.length(); //for example,suppose random word if MONDAY , then letter_present_in_word is 6
             
         }
         else
          {
                int result = JOptionPane.showOptionDialog(this, "DO YOU WANT TO PLAY GAME AGAIN","WORD_PUZZLE" , JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null, null);
                if(result == JOptionPane.OK_OPTION)
                 {
                     this.setVisible(false);
                     LetterArrangement LA= new LetterArrangement();
                     LA.setVisible(true);
                 }
                 else
                      System.exit(0);
          }
     }
    
    //this methods helps to visibility of boxes i.e JLabel and JButton
    public void setVisibleBoxes()
    {
        for(int i=0 ; i < letter_present_in_word;i++)
        {
            switch(i)
            {
                case 0 :
                    jLabel1.setVisible(true);
                    break;
                case 1 :
                    jLabel2.setVisible(true);
                    jLabel3.setVisible(false);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(false);
                    jLabel6.setVisible(false);
                    
                    jButton2.setVisible(true);
                    jButton3.setVisible(false);
                    jButton4.setVisible(false);
                    jButton5.setVisible(false);
                    jButton6.setVisible(false);
                    break;
                case 2 :
                    jLabel3.setVisible(true);
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(false);
                    jLabel6.setVisible(false);

                    jButton3.setVisible(true);
                    jButton4.setVisible(false);
                    jButton5.setVisible(false);
                    jButton6.setVisible(false);
                    break;
                case 3 :
                    jLabel4.setVisible(true);
                    jLabel5.setVisible(false);
                    jLabel6.setVisible(false);

                    jButton4.setVisible(true);
                    jButton5.setVisible(false);
                    jButton6.setVisible(false);
                    break;
                case 4 :
                    jLabel5.setVisible(true);
                    jLabel6.setVisible(false);

                    jButton5.setVisible(true);
                    jButton6.setVisible(false);
                    break;
                case 5 :
                    jLabel6.setVisible(true);

                    jButton6.setVisible(true); 

            }
        }
                   
    }
    
    //this method helps place words's letter randomly on each button -- for example-"MONDAY" should as place on button like MDAYNO 
      public void setValuesOnBox()
      {
         JButton[] collectionOfButton={jButton1,jButton2,jButton3,jButton4,jButton5,jButton6};
         int copyOfnumberofEachChar = letter_present_in_word;
         char[] wordChar = word.toCharArray(); //put string into arrayOFCharacter like word = "MONDAY" into wordchar[]=['M','O','N','D','A','Y'];
         for(int m=0 ; m < letter_present_in_word ; m++)
         {
            int random_letter=(int)(Math.random()*copyOfnumberofEachChar);
            collectionOfButton[m].setText(String.valueOf(wordChar[random_letter]));
            if(random_letter < (copyOfnumberofEachChar-1))
            {
                wordChar[random_letter] = wordChar[copyOfnumberofEachChar-1];
            }
            copyOfnumberofEachChar--;
               
          }
      }
      
   // this method helps-when click any button,suppose u click on jbutton1 after clicking the text on jbuuton1 is copy to jlabel  
     public void setValuesOnLabel(JButton b)
     {
         if(moves > 0)
         {
                if(jLabel1.getText() == "") 
                {
                   jLabel1.setText(b.getText());
                   jLabel7.setText("MOVE : "+(--moves));
                }

                else if(jLabel2.getText() == "")
                {
                   jLabel2.setText(b.getText());
                   jLabel7.setText("MOVE : "+(--moves));
                  
                }

                else if(jLabel3.getText() == "")
                {
                  jLabel3.setText(b.getText());
                  jLabel7.setText("MOVE : "+(--moves));
                 
                }

                else if(jLabel4.getText() == "")
                {
                  jLabel4.setText(b.getText());
                  jLabel7.setText("MOVE : "+(--moves));
                 
                }

                else if(jLabel5.getText() == "")
                {
                  jLabel5.setText(b.getText());
                  jLabel7.setText("MOVE : "+(--moves));
                  
                }
                else if(jLabel6.getText() == "")
                {
                   jLabel6.setText(b.getText());
                   jLabel7.setText("MOVE : "+(--moves));
                   
                }
         }
         else
         {
            int result = JOptionPane.showOptionDialog(this, "TRY AGAIN","" , JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(result == JOptionPane.OK_OPTION)
            {
               jLabel7.setText("MOVE : 12 ");
               resetAllValuesFromLabel();
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
               moves = 12;
            }
            else 
                System.exit(0);
         }
                    
     }
    
     // this method helps resetLabel , for example you click on jbutton1,after clicking jbotton's text copy to jlabel1
     // then again click on jbutton it remove text from label
     public void reverseletter(JButton b)
     {
        if(b.getText() == jLabel1.getText())
            jLabel1.setText("");
        else if(b.getText() == jLabel2.getText())
            jLabel2.setText("");
        else if(b.getText() == jLabel3.getText())
            jLabel3.setText("");
        else if(b.getText() == jLabel4.getText())
            jLabel4.setText("");
        else if(b.getText() == jLabel5.getText())
            jLabel5.setText("");
        else if(b.getText() == jLabel6.getText())
            jLabel6.setText("");
     }
       
     //this method is Checking Winning Possibility
     public int winningCondition()
     {
        boolean f=true;
        JLabel[] j={jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6};
        for(int i=0 ; i < letter_present_in_word ; i++)
        {
           if(!(j[i].getText().equals(String.valueOf(word.charAt(i)))))
            {
                f=false;
                return 0;
            }
        }
        if(f == true)
        {
            JOptionPane.showMessageDialog(this, "YOU WIN");
            resetAllValuesFromLabel();
            randomWordsFromNumberOfWords();
            setVisibleBoxes();
            setValuesOnBox();
            return 1;
            
        }
        return 0;
     }
     
    public void resetAllValuesFromLabel()
    {
         
        JLabel[] j={jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6};
        for(int i=0 ; i < letter_present_in_word ;i++)
            j[i].setText("");
        jLabel7.setText("MOVE : 12");
        moves=12;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("MOVE : 12");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(ClickButton1)  
        {
           setValuesOnLabel(jButton1);
           ClickButton1=false;
           if(winningCondition() == 1)
           {
               
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
           }
           
        }
        else
        {
            ClickButton1=true;
            reverseletter(jButton1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         if(ClickButton2)  
        {
           setValuesOnLabel(jButton2);
           ClickButton2=false;
           if(winningCondition() == 1)
           {
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
           }
        }
        else
        {
            ClickButton2=true;
            reverseletter(jButton2);  
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if(ClickButton3)  
        {
           
           setValuesOnLabel(jButton3);
           ClickButton3=false;
           if(winningCondition() == 1)
           {
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
           }
        }
        else
        {
            ClickButton3=true;
            reverseletter(jButton3); 
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         if(ClickButton4)  
        {
           setValuesOnLabel(jButton4);
           ClickButton4=false;
           if(winningCondition() == 1)
           {
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
           }
        }
        else
        {
            ClickButton4=true;
            reverseletter(jButton4);  
           
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if(ClickButton5)  
        {
           setValuesOnLabel(jButton5);
           ClickButton5=false;
           if(winningCondition() == 1)
           {
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
           }
        }
        else
        {
           
            ClickButton5=true;
            reverseletter(jButton5); 
             if(winningCondition() == 1)
             {
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
             }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         if(ClickButton6)  
        {
           setValuesOnLabel(jButton6);
           ClickButton6=false;
           if(winningCondition() == 1)
           {
                ClickButton1=true;  
                ClickButton2=true;
                ClickButton3=true;
                ClickButton4=true;
                ClickButton5=true;
                ClickButton6=true;
           }
        }
        else
        {
            ClickButton6=true;
            reverseletter(jButton6); 
           
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(LetterArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LetterArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LetterArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LetterArrangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LetterArrangement().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
