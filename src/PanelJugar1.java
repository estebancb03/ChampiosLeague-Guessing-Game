import java.awt.*;
import javax.swing.*;
import java.util.Random; //Para crear números random
import javax.swing.JFrame; //Para crear una ventana "JFrame" por método swing
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener; //Para añadir la funcionalidad de "MouseListener" que detecta cualquier evento o acción del mouse
import java.awt.event.ActionListener; //Para añadir la funcionalidad de "ActionListener"

public class PanelJugar1 extends JPanel
{
	PanelJugar1()
	{
		setBounds(0,0,1000,675); //Da un tamaño a la ventana
		setLayout(null); //Quita la ubicación automática de los objetos del JPanel
		setVisible(false); //Hace invisible el JPanel
		//Definición y construcción de objetos tipo ImageIcon
		ImageIcon JugarFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon JugarBorde1 = new ImageIcon("Imagenes/borde1.png");
		ImageIcon JugarTitulo1 = new ImageIcon("Imagenes/JugarTitulo1.png");
		ImageIcon JugarDificultadTexto1 = new ImageIcon("Imagenes/dificultadtexto");
		//Definición y construcción de objetos tipo JLabel
		JLabel JugarlblFondo1 = new JLabel(JugarFondo1);
		JLabel JugarlblBorde1 = new JLabel(JugarBorde1);
		JLabel JugarlblTitulo1 = new JLabel(JugarTitulo1);
		JLabel JugarlblDificultadTexto1 = new JLabel(JugarDificultadTexto1);
		//Se agregan elementos al JPanel
		add(JugarlblDificultadTexto1);
		add(JugarlblTitulo1);
		add(JugarlblBorde1);
		add(JugarlblFondo1);
		//Se ubican y redimensionan las variables tipo objeto
		JugarlblBorde1.setBounds(60,30,14,75);
		JugarlblDificultadTexto1.setBounds(0,150,448,96);
		JugarlblTitulo1.setBounds(100,20,448,96);
		JugarlblFondo1.setBounds(0,0,1000,675);
	}
}
