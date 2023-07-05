
package br.com.projeto.view;

import javax.swing.JOptionPane;

public class EntradaView extends javax.swing.JFrame {

    public EntradaView() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        progresso = new javax.swing.JProgressBar();
        carregar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Entrada Sistema");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 1010));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progresso.setForeground(new java.awt.Color(204, 102, 0));
        jPanel1.add(progresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 500, 550, 20));

        carregar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        carregar.setForeground(new java.awt.Color(255, 255, 255));
        carregar.setText("99");
        jPanel1.add(carregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 50, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/loading (2).gif"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 430, 80, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/La´ via restaurant (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -80, 1810, 1090));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1660, 1070));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public static void CarregandoProgressBar(){
        EntradaView load=new EntradaView();
         load.setLocationRelativeTo(load);
                load.setVisible(true);
                try{
                    for(int i=0; i <= 100; i+=3){
                        Thread.sleep(70);
                        load.progresso.setValue(i);
                        load.carregar.setText(Integer.toString(i) + "%");
                    }
                    load.dispose();
                    Painel painel=new Painel();
                    painel.setLocationRelativeTo(null);
                    painel.setVisible(true);
                    
                }catch(InterruptedException e){
                    JOptionPane.showConfirmDialog(null,"Ocorreu um erro");
                    System.out.println("Erro ao tentar executar" + e);
                }
   }
    public static void main(String args[]) {
      
        CarregandoProgressBar();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EntradaView viewEntrada=new EntradaView();
                viewEntrada.setLocationRelativeTo(null);
               
            }
        });
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progresso;
    // End of variables declaration//GEN-END:variables
}
