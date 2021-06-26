
import java.awt.*;
import javax.swing.*;
import java.util.Random; //Para crear n�meros random
import javax.swing.JFrame; //Para crear una ventana "JFrame" por m�todo swing
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener; //Para a�adir la funcionalidad de "MouseListener" que detecta cualquier evento o acci�n del mouse
import java.awt.event.ActionListener; //Para a�adir la funcionalidad de "ActionListener"

public class PanelEstadisticas extends JPanel 
{	
	PanelEstadisticas() //Constructor del JPanel de Estad�sticas
	{
		setBounds(0,0,1000,675); //Da un tama�o a la ventana
		setLayout(null); //Quita la ubicaci�n autom�tica de los objetos del JPanel
		setVisible(false); //Hace invisible el JPanel
		//Definici�n y construcci�n de objetos tipo ImageIcon
		ImageIcon EstadisticasFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon EstadisticasBorde = new ImageIcon("Imagenes/borde1.png");
		ImageIcon EstadisticasTitulo = new ImageIcon("Imagenes/EstadisticasTitulo.png");
		//Definici�n y construcci�n de objetos tipo JLabel
		JLabel EstadisticaslblFondo1 = new JLabel(EstadisticasFondo1);
		JLabel EstadisticaslblTitulo = new JLabel(EstadisticasTitulo);
		JLabel EstadisticaslblBorde = new JLabel(EstadisticasBorde);
		//Se agregan elementos al JPanel
		add(EstadisticaslblTitulo);
		add(EstadisticaslblBorde);
		add(EstadisticaslblFondo1);
		//Se ubican y redimensionan las variables tipo objeto
		EstadisticaslblBorde.setBounds(60,30,14,75);
		EstadisticaslblTitulo.setBounds(40,20,448,96);
		EstadisticaslblFondo1.setBounds(0,0,1000,675);
	}
}
