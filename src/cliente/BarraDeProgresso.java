package cliente;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class BarraDeProgresso implements Runnable {

    private JProgressBar jBarraProgresso;
    private boolean interrupted = false;
    private int contBarra;

    public void setContBarra(int contBarra) {
        this.contBarra = contBarra;
    }

    public BarraDeProgresso() {
        contBarra = 0;
    }

    public void setProgressBar(JProgressBar jpb) {
        this.jBarraProgresso = jpb;

    }

    public void setInterrupted(boolean interrupted) {
        this.interrupted = interrupted;
    }

    @Override
    public void run() {

        for (contBarra = this.contBarra; contBarra <= 100 && !interrupted; ++contBarra) {
            try {

                Thread.sleep(40);

            } catch (InterruptedException ex) {
            }
            this.jBarraProgresso.setValue(contBarra);
        }
        JOptionPane.showMessageDialog(null, "Download concluido com sucesso!!!");
    }

}
