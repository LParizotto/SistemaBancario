import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.*;
import static java.lang.Double.parseDouble;

public class SistemBancario {
    private JLabel lblSaldo;
    private JTextField txtSaque;
    private JButton btnSaque;
    private JButton btnDeposito;
    private JTextField txtDeposito;
    private JTextArea areaMensagem;
    private JPanel sistemaBancario;


    public SistemBancario() {

        double valorInicial = 500.0;
        final double[] valorAtual = {valorInicial};


        btnSaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String saqueString = txtSaque.getText();

                if(saqueString.isEmpty()) {
                    areaMensagem.append("Informe algum valor!!!\n");
                }

                double saque = parseDouble(saqueString);

                if (saque < 0 || valorAtual[0] < saque)  {
                    areaMensagem.append("Favor informar um valor válido!!!");
                    areaMensagem.append("\n");
                }


                else{
                    valorAtual[0] -= saque;
                    lblSaldo.setText("R$ " + String.format("%.2f", valorAtual[0]));
                    areaMensagem.append("O valor foi sacado. Volte Sempre");
                    areaMensagem.append("\n");



                }
            }

        });
        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String depositoString = txtDeposito.getText();

                if(depositoString.isEmpty()) {
                    areaMensagem.append("Informe algum valor!!!\n");
                }

                double deposito = Double.parseDouble(depositoString);

                if(deposito > 1000 || deposito < 0){
                    areaMensagem.append("Coloque um valor abaixo de R$ 1000,00!!!");
                    areaMensagem.append("\n");

                }


                else{
                    valorAtual[0] += deposito;
                    lblSaldo.setText("R$ " + String.format("%.2f", valorAtual[0]));
                    areaMensagem.append("O valor foi depositado. Volte Sempre");
                    areaMensagem.append("\n");


                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistem Bancário");
        frame.setContentPane(new SistemBancario().sistemaBancario);
        frame.setSize(600,500);
        frame.setVisible(true);

    }

}
