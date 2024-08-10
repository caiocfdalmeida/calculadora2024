package br.com.coder.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.coder.calc.modelo.Memoria;
import br.com.coder.calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {

	
	
	private JLabel label = new JLabel();
	
	//ESSE É A TELA DE CIMA!!
	public Display () {
	
		Memoria.getInstancia().adicionarObservador(this); // O DISPLAY INCLUI UM OBSERVADOR PRA SER NOTIFICADO
		
		setBackground(new Color(46, 49, 50));
		label = new JLabel(Memoria.getInstancia().getTextoAtual()); // AGORA PEDE O TEXTO ATUAL!!
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
		
		add(label);
	}
	
	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}
}
