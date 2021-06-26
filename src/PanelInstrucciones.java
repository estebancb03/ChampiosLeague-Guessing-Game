import java.awt.*;
import javax.swing.*;
import java.util.Random; //Para crear n�meros random
import javax.swing.JFrame; //Para crear una ventana "JFrame" por m�todo swing
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener; //Para a�adir la funcionalidad de "MouseListener" que detecta cualquier evento o acci�n del mouse
import java.awt.event.ActionListener; //Para a�adir la funcionalidad de "ActionListener"

public class PanelInstrucciones extends JPanel 
{
	PanelInstrucciones()
	{
		setBounds(0,0,1000,675); //Da un tama�o a la ventana
		setLayout(null); //Quita la ubicaci�n autom�tica de los objetos del JPanel
		setVisible(false); //Hace invisible el JPanel
		//Definici�n y construcci�n de objetos tipo ImageIcon
		ImageIcon InstruccionesFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon InstruccionesTitulo = new ImageIcon("Imagenes/InstruccionesTitulo.png");
		ImageIcon InstruccionesChampionsLogo = new ImageIcon("Imagenes/Championslogo.png");
		ImageIcon InstruccionesBorde = new ImageIcon("Imagenes/borde1.png");
		ImageIcon InstruccionesTexto = new ImageIcon("Imagenes/Instruccionestexto.png");
		//Definici�n y construcci�n de objetos tipo JLabel
		JLabel InstruccioneslblBorde = new JLabel(InstruccionesBorde);
		JLabel InstruccioneslblLogo = new JLabel(InstruccionesChampionsLogo);
		JLabel InstruccioneslblTexto = new JLabel(InstruccionesTexto);
		JLabel InstruccioneslblBorde2 = new JLabel(InstruccionesBorde);
		JLabel InstruccioneslblFondo1 = new JLabel(InstruccionesFondo1);
		JLabel InstruccioneslblTitulo = new JLabel(InstruccionesTitulo);
		//Se agregan elementos al JPanel
		add(InstruccioneslblTitulo);
		add(InstruccioneslblTexto);
		add(InstruccioneslblLogo);
		add(InstruccioneslblBorde);
		add(InstruccioneslblBorde2);
		add(InstruccioneslblFondo1);
		//Se ubican y redimensionan las variables tipo objeto
		InstruccioneslblTitulo.setBounds(60,20,448,96);
		InstruccioneslblLogo.setBounds(60,160,300,323);
		InstruccioneslblTexto.setBounds(413,150,522,350);
		InstruccioneslblBorde.setBounds(60,30,14,75);
		InstruccioneslblBorde2.setBounds(400,150,14,350);
		InstruccioneslblFondo1.setBounds(0,0,1000,675);
	}
}
