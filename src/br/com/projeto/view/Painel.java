
package br.com.projeto.view;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Painel extends javax.swing.JFrame {

    public Painel() {
        initComponents();
        jTableProduct.getColumnModel().getColumn(0).setPreferredWidth(200);
    }
    
    public void inserindoEmTabela(String nomeComida,double precoComida){
        String quantidadeComida=JOptionPane.showInputDialog(null,"Por favor insira a quantidade","1");
        if(quantidadeComida.equals("") || quantidadeComida.equals("0")){
            JOptionPane.showMessageDialog(rootPane, "Por favor informe a quantidade correta!");
        }else{
        
        double quantidadeTotal=Double.valueOf(quantidadeComida);
        double precoTotalDaCompra=precoComida * quantidadeTotal;
        
        DefaultTableModel tablemodel=(DefaultTableModel)jTableProduct.getModel();
        Vector vect=new Vector();
        vect.add(nomeComida);
        vect.add(quantidadeComida);
        vect.add(precoTotalDaCompra);
        tablemodel.addRow(vect);
        
        adicionandoValorSubTotalCarrinho();
        }
        
    }
   
    public void adicionandoValorSubTotalCarrinho(){
        int numero=jTableProduct.getRowCount();
        double total=0.0;
        
        for(int i=0; i < numero; i++){
            double valor=Double.valueOf(jTableProduct.getValueAt(i, 2).toString());
            total+=valor;
        }
        DecimalFormat dformat=new DecimalFormat("00.00");
        String d1TotalFormat=dformat.format(total);
        subtTotal.setText(d1TotalFormat);
        
        // total
        double tax=Double.valueOf(taxa.getText());
        double desconto=Double.valueOf(descontoT.getText());
        double calculoTotalFinal= total + tax - desconto;
 
        totalT.setText(String.valueOf(calculoTotalFinal));
        
    }
    public double verificandoValores(double value1,double value2){
        double total=0.0;
        if(value1 < value2){
            JOptionPane.showMessageDialog(rootPane, "Valor impossível de ser calculado");
             DefaultTableModel dt=(DefaultTableModel)jTableProduct.getModel();
            dt.setRowCount(0);
     
            recibo.setText("");
            subtTotal.setText("");
            totalT.setText("");
            pagamento.setText("");
        }else{
            total=value1 - value2;
        }
        return total;
    };
    public void reciboDaCompra(){
        recibo.setText("      La´via SISTEMA CAIXA\n");
        recibo.setText(recibo.getText()+ "   Rua C, 89,\n");
        recibo.setText(recibo.getText()+ "  Santo Antônio de Jesus, BA\n");
        recibo.setText(recibo.getText()+ "   (75)988764532\n");
        recibo.setText(recibo.getText()+ "--------------------------------------------------\n");
        recibo.setText(recibo.getText()+ "Item \t Qtd \t Preço \n");
        recibo.setText(recibo.getText()+ "---------------------------------------------------\n");
        
        DefaultTableModel dtableModel=(DefaultTableModel)jTableProduct.getModel();
        for(int i=0; i < jTableProduct.getRowCount(); i++){
            String itemNome=dtableModel.getValueAt(i, 0).toString();
            String qtdItem=dtableModel.getValueAt(i, 1).toString();
            String precoItem=dtableModel.getValueAt(i, 2).toString();
            recibo.setText(recibo.getText()+ itemNome + "\t" + qtdItem + "\t" + precoItem + "\n");
        }
        
          recibo.setText(recibo.getText()+ "---------------------------------------------------\n");
          recibo.setText(recibo.getText()+ "Subtotal:\t" + subtTotal.getText() + "\n");
          recibo.setText(recibo.getText()+ "Taxa:\t" + taxa.getText() + "\n");
          recibo.setText(recibo.getText()+ "Desconto:\t" + descontoT.getText() + "\n");
          recibo.setText(recibo.getText()+ "-------------------------------------------------------\n");
          recibo.setText(recibo.getText()+ "Total:\t" + totalT.getText() + "\n");
          recibo.setText(recibo.getText()+ "Valor Recebido:\t" + pagamento.getText() + "\n");
          recibo.setText(recibo.getText()+ "Troco:\t" + troco.getText() + "\n");
          recibo.setText(recibo.getText()+ "-----------------------------------------------------------\n");
          
          Date dataAtualDaCompra=new Date();
          SimpleDateFormat data=new SimpleDateFormat("MM/dd/yyyy");
          SimpleDateFormat timer=new SimpleDateFormat("hh:mm:ss");
          
          String dataFormat=data.format(dataAtualDaCompra);
          String timeFormat=timer.format(dataAtualDaCompra);
          
          recibo.setText(recibo.getText()+ "Data:" + dataFormat + " \tHorário: " + timeFormat + "\n");
          recibo.setText(recibo.getText()+ "*************************************\n");
          recibo.setText(recibo.getText()+ "La´via AGRADECE PELA PREFERÊNCIA!\n");
          recibo.setText(recibo.getText()+ "**************************************\n");
           recibo.setText(recibo.getText()+ "Software Back-end Java - João Queiroz");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pedido1 = new javax.swing.JButton();
        pedido2 = new javax.swing.JButton();
        pedido3 = new javax.swing.JButton();
        pedido4 = new javax.swing.JButton();
        pedido5 = new javax.swing.JButton();
        pedido6 = new javax.swing.JButton();
        pedido7 = new javax.swing.JButton();
        pedido8 = new javax.swing.JButton();
        pedido9 = new javax.swing.JButton();
        pedido10 = new javax.swing.JButton();
        pedido11 = new javax.swing.JButton();
        pedido12 = new javax.swing.JButton();
        pedido13 = new javax.swing.JButton();
        pedido14 = new javax.swing.JButton();
        pedido15 = new javax.swing.JButton();
        pedido16 = new javax.swing.JButton();
        pedido17 = new javax.swing.JButton();
        pedido18 = new javax.swing.JButton();
        pedido19 = new javax.swing.JButton();
        pedido20 = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        descontoT = new javax.swing.JTextField();
        totalT = new javax.swing.JTextField();
        pagamento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        subtTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        taxa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnPagar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        troco = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        recibo = new javax.swing.JTextArea();
        btnDeleteItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("La´via");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pedido1.setBackground(new java.awt.Color(204, 102, 0));
        pedido1.setForeground(new java.awt.Color(255, 255, 255));
        pedido1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/1.png"))); // NOI18N
        pedido1.setText("$ 45");
        pedido1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Queijo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido1ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 110));

        pedido2.setBackground(new java.awt.Color(204, 102, 0));
        pedido2.setForeground(new java.awt.Color(255, 255, 255));
        pedido2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/2.png"))); // NOI18N
        pedido2.setText("$ 10");
        pedido2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tradicional", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido2ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 74, -1));

        pedido3.setBackground(new java.awt.Color(204, 102, 0));
        pedido3.setForeground(new java.awt.Color(255, 255, 255));
        pedido3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/6.png"))); // NOI18N
        pedido3.setText("$ 50");
        pedido3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gorgonzola", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido3ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 80, -1));

        pedido4.setBackground(new java.awt.Color(204, 102, 0));
        pedido4.setForeground(new java.awt.Color(255, 255, 255));
        pedido4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/10.png"))); // NOI18N
        pedido4.setText("$ 20");
        pedido4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Donn Blue", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido4ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 74, -1));

        pedido5.setBackground(new java.awt.Color(204, 102, 0));
        pedido5.setForeground(new java.awt.Color(255, 255, 255));
        pedido5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/8.png"))); // NOI18N
        pedido5.setText("$ 30");
        pedido5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calabresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255)))); // NOI18N
        pedido5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido5ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 74, -1));

        pedido6.setBackground(new java.awt.Color(204, 102, 0));
        pedido6.setForeground(new java.awt.Color(255, 255, 255));
        pedido6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/4.png"))); // NOI18N
        pedido6.setText("$ 25");
        pedido6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duplo Bbacon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido6ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 74, -1));

        pedido7.setBackground(new java.awt.Color(204, 102, 0));
        pedido7.setForeground(new java.awt.Color(255, 255, 255));
        pedido7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/5.png"))); // NOI18N
        pedido7.setText("$ 45");
        pedido7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Passas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido7ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 118, 74, -1));

        pedido8.setBackground(new java.awt.Color(204, 102, 0));
        pedido8.setForeground(new java.awt.Color(255, 255, 255));
        pedido8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/34.png"))); // NOI18N
        pedido8.setText("$ 40");
        pedido8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cerveja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido8ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 74, -1));

        pedido9.setBackground(new java.awt.Color(204, 102, 0));
        pedido9.setForeground(new java.awt.Color(255, 255, 255));
        pedido9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/7.png"))); // NOI18N
        pedido9.setText("$ 15");
        pedido9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "XBacon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido9ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido9, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 118, 74, -1));

        pedido10.setBackground(new java.awt.Color(204, 102, 0));
        pedido10.setForeground(new java.awt.Color(255, 255, 255));
        pedido10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/36.png"))); // NOI18N
        pedido10.setText("$ 12");
        pedido10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Laranja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido10ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 74, -1));

        pedido11.setBackground(new java.awt.Color(204, 102, 0));
        pedido11.setForeground(new java.awt.Color(255, 255, 255));
        pedido11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/5_1.png"))); // NOI18N
        pedido11.setText("$ 18.90");
        pedido11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Penne", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido11ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 74, -1));

        pedido12.setBackground(new java.awt.Color(204, 102, 0));
        pedido12.setForeground(new java.awt.Color(255, 255, 255));
        pedido12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/6_1.png"))); // NOI18N
        pedido12.setText("$ 30.90");
        pedido12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bolonhesa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido12ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 74, -1));

        pedido13.setBackground(new java.awt.Color(204, 102, 0));
        pedido13.setForeground(new java.awt.Color(255, 255, 255));
        pedido13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/29.png"))); // NOI18N
        pedido13.setText("$ 15");
        pedido13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Limonada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido13ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 74, -1));

        pedido14.setBackground(new java.awt.Color(204, 102, 0));
        pedido14.setForeground(new java.awt.Color(255, 255, 255));
        pedido14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/31.png"))); // NOI18N
        pedido14.setText("$ 15.90");
        pedido14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drink", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255)))); // NOI18N
        pedido14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido14ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 74, -1));

        pedido15.setBackground(new java.awt.Color(204, 102, 0));
        pedido15.setForeground(new java.awt.Color(255, 255, 255));
        pedido15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/2_1.png"))); // NOI18N
        pedido15.setText("$ 20");
        pedido15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sorvete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido15ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 74, -1));

        pedido16.setBackground(new java.awt.Color(204, 102, 0));
        pedido16.setForeground(new java.awt.Color(255, 255, 255));
        pedido16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/3.png"))); // NOI18N
        pedido16.setText("$ 30");
        pedido16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kit donnuts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido16ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 74, -1));

        pedido17.setBackground(new java.awt.Color(204, 102, 0));
        pedido17.setForeground(new java.awt.Color(255, 255, 255));
        pedido17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/10_1.png"))); // NOI18N
        pedido17.setText("$ 80.90");
        pedido17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Moqueca", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido17ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 74, -1));

        pedido18.setBackground(new java.awt.Color(204, 102, 0));
        pedido18.setForeground(new java.awt.Color(255, 255, 255));
        pedido18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/19.png"))); // NOI18N
        pedido18.setText("$ 50");
        pedido18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Baianão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido18ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 74, 110));

        pedido19.setBackground(new java.awt.Color(204, 102, 0));
        pedido19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/1.png"))); // NOI18N
        pedido19.setText("$ 30");
        pedido19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(pedido19, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 379, 74, -1));

        pedido20.setBackground(new java.awt.Color(204, 102, 0));
        pedido20.setForeground(new java.awt.Color(255, 255, 255));
        pedido20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/1_1.png"))); // NOI18N
        pedido20.setText("$ 30");
        pedido20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Peixe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        pedido20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pedido20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedido20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedido20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedido20ActionPerformed(evt);
            }
        });
        jPanel2.add(pedido20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 74, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 470));

        btnNovo.setBackground(new java.awt.Color(204, 102, 0));
        btnNovo.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnNovo.setForeground(new java.awt.Color(255, 255, 255));
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 590, 100, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/DeliveryLigueJa.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 484, 440, 170));

        jTableProduct.setBackground(new java.awt.Color(204, 204, 204));
        jTableProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTableProduct.setForeground(new java.awt.Color(0, 0, 0));
        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Qtd", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableProduct);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 260, 410));

        jPanel4.setBackground(new java.awt.Color(204, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fluxo de Pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Subtotal :");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Total :");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Paga:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        descontoT.setBackground(new java.awt.Color(204, 204, 204));
        descontoT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        descontoT.setForeground(new java.awt.Color(0, 0, 0));
        descontoT.setText("2.50");
        descontoT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        descontoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descontoTActionPerformed(evt);
            }
        });
        descontoT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descontoTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descontoTKeyReleased(evt);
            }
        });
        jPanel4.add(descontoT, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 60, 25));

        totalT.setBackground(new java.awt.Color(204, 204, 204));
        totalT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalT.setForeground(new java.awt.Color(0, 0, 0));
        totalT.setText("0");
        totalT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        totalT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTActionPerformed(evt);
            }
        });
        jPanel4.add(totalT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 90, 30));

        pagamento.setBackground(new java.awt.Color(204, 204, 204));
        pagamento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pagamento.setForeground(new java.awt.Color(0, 0, 0));
        pagamento.setText("0");
        pagamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagamentoActionPerformed(evt);
            }
        });
        jPanel4.add(pagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 90, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Desconto:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        subtTotal.setBackground(new java.awt.Color(204, 204, 204));
        subtTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        subtTotal.setForeground(new java.awt.Color(0, 0, 0));
        subtTotal.setText("0");
        subtTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(subtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 100, 25));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Taxa :");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, -1));

        taxa.setBackground(new java.awt.Color(204, 204, 204));
        taxa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        taxa.setForeground(new java.awt.Color(0, 0, 0));
        taxa.setText("5.0");
        taxa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        taxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taxaActionPerformed(evt);
            }
        });
        taxa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                taxaKeyReleased(evt);
            }
        });
        jPanel4.add(taxa, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 100, 25));

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Recibo");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 80, 60));

        btnPagar.setBackground(new java.awt.Color(255, 0, 0));
        btnPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel4.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 80, 60));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Troco :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        troco.setBackground(new java.awt.Color(204, 204, 204));
        troco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        troco.setForeground(new java.awt.Color(0, 0, 0));
        troco.setText("0.0");
        troco.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        troco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trocoActionPerformed(evt);
            }
        });
        jPanel4.add(troco, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 550, 150));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));

        recibo.setColumns(20);
        recibo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        recibo.setRows(5);
        jScrollPane2.setViewportView(recibo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(724, 10, 300, 480));

        btnDeleteItem.setBackground(new java.awt.Color(255, 255, 255));
        btnDeleteItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDeleteItem.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/projeto/image/error.png"))); // NOI18N
        btnDeleteItem.setText("Deletar Item");
        btnDeleteItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteItemActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pedido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido2ActionPerformed
         inserindoEmTabela("Hamburguer Tradicional", 10.0);
    }//GEN-LAST:event_pedido2ActionPerformed

    private void totalTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
        recibo.print();
       }catch(Exception e){
           System.out.println(e);
           JOptionPane.showMessageDialog(this, "Erro tente novamente!");
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
       double total=Double.valueOf(totalT.getText());
       double pagamentoCliente=Double.valueOf(pagamento.getText());
       
       //double balancoDoPagamentoETroco=pagamentoCliente - total;
       verificandoValores(pagamentoCliente, total);
       troco.setText(String.valueOf(verificandoValores(pagamentoCliente, total)));
       
        reciboDaCompra();
    }//GEN-LAST:event_btnPagarActionPerformed

    private void pedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido1ActionPerformed
        inserindoEmTabela("Pizza Queijo", 45.0);
    }//GEN-LAST:event_pedido1ActionPerformed

    private void pedido3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido3ActionPerformed
        inserindoEmTabela("Pizza Gorgonzola", 50.0);
    }//GEN-LAST:event_pedido3ActionPerformed

    private void pedido12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido12ActionPerformed
       inserindoEmTabela("Macarrão Bolonhesa", 30.90);
    }//GEN-LAST:event_pedido12ActionPerformed

    private void pedido17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido17ActionPerformed
        inserindoEmTabela("Moqueca de peixe", 80.90);
    }//GEN-LAST:event_pedido17ActionPerformed

    private void pedido4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido4ActionPerformed
        inserindoEmTabela("Donnut Blue", 20.0);
    }//GEN-LAST:event_pedido4ActionPerformed

    private void pedido6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido6ActionPerformed
         inserindoEmTabela("Duplo Bacon", 25.0);
    }//GEN-LAST:event_pedido6ActionPerformed

    private void pedido7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido7ActionPerformed
        inserindoEmTabela("Pizza de Passas", 45.0);
    }//GEN-LAST:event_pedido7ActionPerformed

    private void pedido9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido9ActionPerformed
         inserindoEmTabela("Xbacon", 15.0);
    }//GEN-LAST:event_pedido9ActionPerformed

    private void pedido5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido5ActionPerformed
         inserindoEmTabela("Pizza de Calabresa", 30.0);
    }//GEN-LAST:event_pedido5ActionPerformed

    private void pedido13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido13ActionPerformed
        inserindoEmTabela("Limonada Siciliana", 15.0);
    }//GEN-LAST:event_pedido13ActionPerformed

    private void pedido8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido8ActionPerformed
        inserindoEmTabela("Balde Cerveja", 40.0);
    }//GEN-LAST:event_pedido8ActionPerformed

    private void pedido10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido10ActionPerformed
        inserindoEmTabela("Suco de Laranja Jarra", 12.0);
    }//GEN-LAST:event_pedido10ActionPerformed

    private void pedido11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido11ActionPerformed
        inserindoEmTabela("Macarrão Penne", 18.90);
    }//GEN-LAST:event_pedido11ActionPerformed

    private void pedido20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido20ActionPerformed
         inserindoEmTabela("Peixe ao molho branco", 30.0);
    }//GEN-LAST:event_pedido20ActionPerformed

    private void pedido18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido18ActionPerformed
         inserindoEmTabela("Baianão", 50.0);
    }//GEN-LAST:event_pedido18ActionPerformed

    private void pedido16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido16ActionPerformed
        inserindoEmTabela("Kit donnuts", 30.0);
    }//GEN-LAST:event_pedido16ActionPerformed

    private void pedido15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido15ActionPerformed
        inserindoEmTabela("Sorvete 3 bolas", 20.0);
    }//GEN-LAST:event_pedido15ActionPerformed

    private void pedido14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedido14ActionPerformed
         inserindoEmTabela("Drink especial da casa", 15.90);
    }//GEN-LAST:event_pedido14ActionPerformed

    private void taxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taxaActionPerformed
        adicionandoValorSubTotalCarrinho();
    }//GEN-LAST:event_taxaActionPerformed

    private void descontoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descontoTActionPerformed
      adicionandoValorSubTotalCarrinho();
    }//GEN-LAST:event_descontoTActionPerformed

    private void descontoTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descontoTKeyPressed
       adicionandoValorSubTotalCarrinho();
    }//GEN-LAST:event_descontoTKeyPressed

    private void taxaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taxaKeyReleased
       adicionandoValorSubTotalCarrinho();
    }//GEN-LAST:event_taxaKeyReleased

    private void descontoTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descontoTKeyReleased
      adicionandoValorSubTotalCarrinho();
    }//GEN-LAST:event_descontoTKeyReleased

    private void pagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagamentoActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
       DefaultTableModel dt=(DefaultTableModel)jTableProduct.getModel();
       dt.setRowCount(0);
     
       recibo.setText("");
       subtTotal.setText("");
       totalT.setText("");
       pagamento.setText("");
    }//GEN-LAST:event_btnNovoActionPerformed

    private void trocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trocoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trocoActionPerformed

    private void btnDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteItemActionPerformed
        deletandoItemVerificacao();
    }//GEN-LAST:event_btnDeleteItemActionPerformed
    
    public void deletandoItemVerificacao(){
          if(jTableProduct.getRowCount() > 0){
            if(JOptionPane.showConfirmDialog(this, "Deseja Excluir?", "Excluir Item", JOptionPane.YES_NO_OPTION, 0
                        ) == JOptionPane.YES_OPTION) {
                
                ((DefaultTableModel)jTableProduct.getModel()).removeRow(jTableProduct.getSelectedRow());
                 //recibo.setText(recibo.getText());
                 adicionandoValorSubTotalCarrinho();
                 
            }else{
                  JOptionPane.showMessageDialog(rootPane, "Selecione um item");
              }
         }
    }
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Painel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteItem;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPagar;
    private javax.swing.JTextField descontoT;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTextField pagamento;
    private javax.swing.JButton pedido1;
    private javax.swing.JButton pedido10;
    private javax.swing.JButton pedido11;
    private javax.swing.JButton pedido12;
    private javax.swing.JButton pedido13;
    private javax.swing.JButton pedido14;
    private javax.swing.JButton pedido15;
    private javax.swing.JButton pedido16;
    private javax.swing.JButton pedido17;
    private javax.swing.JButton pedido18;
    private javax.swing.JButton pedido19;
    private javax.swing.JButton pedido2;
    private javax.swing.JButton pedido20;
    private javax.swing.JButton pedido3;
    private javax.swing.JButton pedido4;
    private javax.swing.JButton pedido5;
    private javax.swing.JButton pedido6;
    private javax.swing.JButton pedido7;
    private javax.swing.JButton pedido8;
    private javax.swing.JButton pedido9;
    private javax.swing.JTextArea recibo;
    private javax.swing.JTextField subtTotal;
    private javax.swing.JTextField taxa;
    private javax.swing.JTextField totalT;
    private javax.swing.JTextField troco;
    // End of variables declaration//GEN-END:variables
}
