package br.com.coder.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.coder.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener{ 
	
	private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
	private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
	private final Color COR_LARANJA = new Color(242, 163, 60);
	
	//TELA DE BAIXO!! (TECLADO)
	public Teclado() {
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		
		c.weightx = 1; // SERVE PRA PREENCHER OS BOTÕES NO EIXO X
		c.weighty = 1; // SERVE PRA PREENCHER OS BOTÕES NO EIXO Y
		c.fill = GridBagConstraints.BOTH;
		
		// LINHA 1   ±
		c.gridwidth = 2; // COMO COMENTEI DOIS BOTÕES, MUDOU A LARGURA PRA NÃO FICAR UM BURACO ENTRE BOTÕES
		adicionarBotao("AC", COR_CINZA_ESCURO, c , 0, 0);
		c.gridwidth = 1; // RESTAURANDO AO NORMAL PRA NÃO "BUGAR"
		adicionarBotao("±", COR_CINZA_ESCURO, c , 2, 0);
	//	adicionarBotao("+-", COR_CINZA_ESCURO, c , 1, 0);
	//	adicionarBotao("%", COR_CINZA_ESCURO, c , 2, 0);
		adicionarBotao("/", COR_LARANJA, c , 3, 0);
		
		// LINHA 2
		adicionarBotao("7", COR_CINZA_CLARO, c , 0, 1);
		adicionarBotao("8", COR_CINZA_CLARO, c , 1, 1);
		adicionarBotao("9", COR_CINZA_CLARO, c , 2, 1);
		adicionarBotao("*", COR_LARANJA, c , 3, 1);
		
		// LINHA 3
		adicionarBotao("4", COR_CINZA_CLARO, c , 0, 2);
		adicionarBotao("5", COR_CINZA_CLARO, c , 1, 2);
		adicionarBotao("6", COR_CINZA_CLARO, c , 2, 2);
		adicionarBotao("-", COR_LARANJA, c , 3, 2);
		
		// LINHA 4
		adicionarBotao("1", COR_CINZA_CLARO, c , 0, 3);
		adicionarBotao("2", COR_CINZA_CLARO, c , 1, 3);
		adicionarBotao("3", COR_CINZA_CLARO, c , 2, 3);
		adicionarBotao("+", COR_LARANJA, c , 3, 3);
		
		// LINHA 5
		c.gridwidth = 2; //PRA O ZERO OCUPAR DOIS ESPAÇOS
		adicionarBotao("0", COR_CINZA_CLARO, c , 0, 4);
	//	adicionarBotao("0", COR_CINZA_CLARO, c , 1, 4);
		c.gridwidth = 1;
		adicionarBotao(",", COR_CINZA_CLARO, c , 2, 4);
		adicionarBotao("=", COR_LARANJA, c , 3, 4);
		
		//c.gridx = 0;
		//c.gridy = 0;
		//add(new Botao("AC", COR_CINZA_ESCURO), c);
		//c.gridx = 1;
		//add(new Botao("+/-", COR_CINZA_ESCURO), c);
		//c.gridx = 2;
		//add(new Botao("%", COR_CINZA_ESCURO), c);
		//c.gridx = 3;
		//add(new Botao("/", COR_LARANJA), c);
		//c.gridx = 0;
		//c.gridy = 1;
		//add(new Botao("7", COR_CINZA_CLARO), c);
		//add(new Botao("8", COR_CINZA_CLARO), c);
		//add(new Botao("9", COR_CINZA_CLARO), c);
		//add(new Botao("*", COR_LARANJA), c);
		
		//add(new Botao("4", COR_CINZA_CLARO), c);
		//add(new Botao("5", COR_CINZA_CLARO), c);
		//add(new Botao("6", COR_CINZA_CLARO), c);
		//add(new Botao("-", COR_LARANJA), c);
		
		//add(new Botao("1", COR_CINZA_CLARO), c);
		//add(new Botao("2", COR_CINZA_CLARO), c);
		//add(new Botao("3", COR_CINZA_CLARO), c);
		//add(new Botao("+", COR_LARANJA), c);
	}

	
	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {

		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) { // instanceof = testar se um objeto é uma instância de uma classe específica
			JButton botao = (JButton) e.getSource();
			//System.out.println(botao.getText());
			Memoria.getInstancia().processarComando(botao.getText()); // LEMBRANDO QUE INSTÂNCIA VEIO DA CLASSE MEMÓRIA!
		}
	}
}
