package cliente;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    BarraDeProgresso barra;
    Thread threadBarra, threadLabel;
    private String NomeDoArquivo;
    private String[] ListaServidoresArquivo;
    private int cont;

    public TelaPrincipal() {
        initComponents();
        setLocationRelativeTo(this);
        jProgressBar1.setStringPainted(true);
        ListaServidoresArquivo = new String[0];
        this.cont = 0;
        LabelMensagem.setText("Pesquisando arquivo...");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FiedNomeArquivo = new javax.swing.JTextField();
        BotaoBuscarArquivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableOfServerFile = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        BotaoBaixarArquivo = new javax.swing.JButton();
        LabelServidorSelecionado = new javax.swing.JLabel();
        LabelMensagem = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do arquivo :");

        FiedNomeArquivo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        BotaoBuscarArquivo.setText("Pesquisar");
        BotaoBuscarArquivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BotaoBuscarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarArquivoActionPerformed(evt);
            }
        });

        TableOfServerFile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Servidor de arquivo", "IP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableOfServerFile);
        if (TableOfServerFile.getColumnModel().getColumnCount() > 0) {
            TableOfServerFile.getColumnModel().getColumn(0).setResizable(false);
        }

        jProgressBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BotaoBaixarArquivo.setText("Download");
        BotaoBaixarArquivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BotaoBaixarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBaixarArquivoActionPerformed(evt);
            }
        });

        LabelServidorSelecionado.setText("Selecione o servidor abaixo e pressione o botão Download para iniciar o download.");

        LabelMensagem.setText("Pesquisando arquivo...");

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(FiedNomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotaoBuscarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotaoBaixarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LabelServidorSelecionado)
                            .addComponent(LabelMensagem))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        PanelPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {FiedNomeArquivo, jScrollPane1});

        PanelPrincipalLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotaoBaixarArquivo, BotaoBuscarArquivo});

        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoBuscarArquivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FiedNomeArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelServidorSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBaixarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(LabelMensagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipalLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotaoBaixarArquivo, BotaoBuscarArquivo, FiedNomeArquivo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoBuscarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarArquivoActionPerformed
        AcaoBotaobuscarArquivo();
    }//GEN-LAST:event_BotaoBuscarArquivoActionPerformed

    private void BotaoBaixarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBaixarArquivoActionPerformed
        AcaoBotaoBaixarArquivo();
    }//GEN-LAST:event_BotaoBaixarArquivoActionPerformed

    public void startProcessing() {
        barra = new BarraDeProgresso();
        barra.setProgressBar(jProgressBar1);
        threadBarra = new Thread(barra);
        threadBarra.start();
    }

    public void stopProcessing() {
        barra.setInterrupted(true);
        try {
            if (threadBarra != null) {
                threadBarra.join();
            }
        } catch (InterruptedException ex) {
        }
        jProgressBar1.setValue(jProgressBar1.getValue());
    }

    public void PreencherTabela(String[] ServidoresArquivo) {
        for (int i = 0; i < ServidoresArquivo.length; i++) {
            //Nome do Servidor    
            TableOfServerFile.setValueAt(ServidoresArquivo[i].split("#")[1], i, 0);
            //Ip do Servidor
            TableOfServerFile.setValueAt(ServidoresArquivo[i].split("#")[0], i, 1);
        }
    }

    public void LimparTabela() {
        for (int i = 0; i < 10; i++) {
            TableOfServerFile.setValueAt("", i, 0);
        }
    }

    private void AcaoBotaoBaixarArquivo() {

        if (TableOfServerFile.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Favor, selecione o Servidor que deseja fazer o download!!!");
            return;
        }
        if (TableOfServerFile.getSelectedRow() > ListaServidoresArquivo.length - 1) {
            JOptionPane.showMessageDialog(null, "Favor, selecione um Servidor válido!!!");
            return;
        }
        LabelMensagem.setText("Baixando o arquivo...");
        String IPServeArquivo  = ListaServidoresArquivo[TableOfServerFile.getSelectedRow()].split("#")[0];
        baixarArquivo(IPServeArquivo , NomeDoArquivo);
        startProcessing();
    }

    private void AcaoBotaobuscarArquivo() {
        LabelMensagem.setText("Pesquisando arquivo...");

        if (!FiedNomeArquivo.getText().equals("")) {
            NomeDoArquivo = FiedNomeArquivo.getText();
            LimparTabela();
            ListaServidoresArquivo = solicitarArquivo(NomeDoArquivo);
            if (ListaServidoresArquivo != null) {
                
                PreencherTabela(ListaServidoresArquivo);
                LabelMensagem.setText("Arquivo encontrado...");
            } else {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado!!!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite o nome do Arquivo");
        }
    }

    //SOLICITAR ARQUIVO AO SERVIDOR PRINCIPAL
    public String[] solicitarArquivo(String nomeArquivo) {
        String enderecoServer = "localhost";
        String modifiedSentence = "";
        try {
            Socket clientSocket = new Socket(enderecoServer, 6789);
            DataOutputStream outToServer = new DataOutputStream(
                    clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(nomeArquivo + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("Recebeu: " + modifiedSentence);
            clientSocket.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Servidor Principal está desligado!!!");
        }

        // testando se nenhum servidor de arquivo que encotrou o arquivo
        if (modifiedSentence.split(";")[0].equals("")) {
            return null;
        }

        return modifiedSentence.split(";");
    }

    //BAIXAR ARQUIVO DO SERVIDOR DE ARQUIVO SELECIONADO NA TABELA!!!
    public void baixarArquivo(String ip_ServerData, String nomeArquivo) {
        int current = 0;
        cont++;
        try {
            Socket sock = new Socket(ip_ServerData, 6001);
            byte[] mybytearray = new byte[1024];
            InputStream is = sock.getInputStream();
            DataOutputStream outToServer = new DataOutputStream(
                    sock.getOutputStream());
            outToServer.writeBytes(nomeArquivo + '\n');
            FileOutputStream fos = new FileOutputStream(
                    "Download_" + ip_ServerData + "_" + cont + "_" + nomeArquivo);

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            while ((current = is.read(mybytearray)) > 0) {
                bos.write(mybytearray, 0, current);
            }
            bos.flush();
            bos.close();
            is.close();
            sock.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Erro aqui");
        }
    }

    public static void main(String args[]) {

        JOptionPane.showMessageDialog(null, "Certifique-se que o Servidor Principal e o(s)\n "
                + "Servidor(s) de Arquivo estão executando!!!");

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoBaixarArquivo;
    private javax.swing.JButton BotaoBuscarArquivo;
    private javax.swing.JTextField FiedNomeArquivo;
    private javax.swing.JLabel LabelMensagem;
    private javax.swing.JLabel LabelServidorSelecionado;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JTable TableOfServerFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
