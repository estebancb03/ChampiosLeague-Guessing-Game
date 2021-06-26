/*
Proyecto No.1: Memory Game: Champions League 2018 Edition
Estudiante: Esteban Castañeda Blanco
Sección: 11-4A
Descripción: Juego desarollado en un JFrame con varios JPanels. Es un juego de 
			 memoria cuyo objetivo es que el usurio una parejas de imágenes sin 
			 que él conozca en donde se encuentran con un cierto número de 
			 intentos y con niveles de dificultad. Se usará las propiedades de 
			 "ActionListener" y "MouseListener"
*/

import java.awt.*;
import javax.swing.*;
import java.util.Random; //Para crear números random
import javax.swing.JFrame; //Para crear una ventana "JFrame" por método swing
import java.awt.event.MouseEvent; //Para utilizar los eventos del mouse
import java.awt.event.ActionEvent; //Para utilizar los "Action Events"
import java.awt.event.MouseListener; //Para añadir la funcionalidad de "MouseListener" que detecta cualquier evento o acción del mouse
import java.awt.event.ActionListener; //Para añadir la funcionalidad de "ActionListener"

public class Proyecto1 extends JFrame implements MouseListener
{
	//--------------------------------------------------------------------------------------------------------------------------------
	//Objetos para todos los modos
	ImageIcon lblPuntajeTexto = new ImageIcon("Imagenes/puntajetexto.png");
	ImageIcon lblIntentosTexto = new ImageIcon("Imagenes/intentostexto.png");
	ImageIcon JugarCartaCubierta = new ImageIcon("Imagenes/Carta.png"); //Carta Cubierta
	ImageIcon JugarCartaRoma = new ImageIcon("Imagenes/3.png"); //Carta de la AS Roma
	ImageIcon JugarCartaReal = new ImageIcon("Imagenes/0.png"); //Cara del Real Madrid
	ImageIcon JugarCartaBarca = new ImageIcon("Imagenes/1.png"); //Carta del Barca
	ImageIcon JugarCartaJuve = new ImageIcon("Imagenes/2.png"); //Carta de la Juvestus
	ImageIcon JugarCartaSpurs = new ImageIcon("Imagenes/4.png"); //Carta de los Spurs
	ImageIcon JugarCartaSporting = new ImageIcon("Imagenes/5.png"); //Carta del Sporting
	ImageIcon JugarCartaBayer = new ImageIcon("Imagenes/6.png"); //Carta del Bayer Munich
	ImageIcon JugarCartaAjax = new ImageIcon("Imagenes/7.png"); //Carta del Liverpool
	ImageIcon JugarCartaPSG = new ImageIcon("Imagenes/8.png"); //Carta del PSG
	Font Letra1 = new Font("Agency", Font.CENTER_BASELINE + Font.PLAIN,40); //Fuente para tirar los resultados
	String NombreJugador;
	int confirm1;
	//---------------------------------------------------------------------------------------------------------------------------------
	//Objetos para el modo fácil
	ImageIcon JugarFacilBotonNuevo = new ImageIcon("Imagenes/jugardenuevoboton.png");
	JLabel JugarFacillblCarta1 = new JLabel(JugarCartaReal);
	JLabel JugarFacillblCarta2 = new JLabel(JugarCartaJuve); 
	JLabel JugarFacillblCarta3 = new JLabel(JugarCartaBarca); 
	JLabel JugarFacillblCarta4 = new JLabel(JugarCartaRoma); 
	JLabel JugarFacillblCarta5 = new JLabel(JugarCartaSpurs); 
	JLabel JugarFacillblCarta6 = new JLabel(JugarCartaSpurs); 
	JLabel JugarFacillblCarta7 = new JLabel(JugarCartaRoma); 
	JLabel JugarFacillblCarta8 = new JLabel(JugarCartaBarca); 
	JLabel JugarFacillblCarta9 = new JLabel(JugarCartaJuve); 
	JLabel JugarFacillblCarta10 = new JLabel(JugarCartaReal); 
	JLabel JugarFacilPuntos = new JLabel();
	JLabel JugarFacilIntentos = new JLabel();
	JButton JugarFacilbtndeNuevo = new JButton(JugarFacilBotonNuevo);
	int confirmFacil;
	int puntosHechosFacil = 0;
	int intentosPerdidosFacil = 0;
	int intentosRestaFacil = 0;
	int parejasFormadasFacil = 0;
	int parejasRestaFacil = 0;
	//---------------------------------------------------------------------------------------------------------------------------------
	//Objetos para el modo normal
	ImageIcon JugarNormalBotonNuevo = new ImageIcon("Imagenes/jugardenuevoboton.png");
	JLabel JugarNormallblCarta1 = new JLabel(JugarCartaReal);
	JLabel JugarNormallblCarta2 = new JLabel(JugarCartaJuve); 
	JLabel JugarNormallblCarta3 = new JLabel(JugarCartaBarca); 
	JLabel JugarNormallblCarta4 = new JLabel(JugarCartaRoma); 
	JLabel JugarNormallblCarta5 = new JLabel(JugarCartaSpurs); 
	JLabel JugarNormallblCarta6 = new JLabel(JugarCartaSpurs); 
	JLabel JugarNormallblCarta7 = new JLabel(JugarCartaRoma); 
	JLabel JugarNormallblCarta8 = new JLabel(JugarCartaBarca); 
	JLabel JugarNormallblCarta9 = new JLabel(JugarCartaJuve); 
	JLabel JugarNormallblCarta10 = new JLabel(JugarCartaReal);
	JLabel JugarNormallblCarta11 = new JLabel(JugarCartaSporting);
	JLabel JugarNormallblCarta12 = new JLabel(JugarCartaSporting); 
	JLabel JugarNormallblCarta13 = new JLabel(JugarCartaBayer);
	JLabel JugarNormallblCarta14 = new JLabel(JugarCartaBayer);
	JLabel JugarNormalPuntos = new JLabel();
	JLabel JugarNormalIntentos = new JLabel();
	JButton JugarNormalbtndeNuevo = new JButton(JugarFacilBotonNuevo);
	int confirmNormal;
	int puntosHechosNormal = 0;
	int intentosPerdidosNormal = 0;
	int intentosRestaNormal = 0;
	int parejasFormadasNormal = 0;
	int parejasRestaNormal = 0;
	//---------------------------------------------------------------------------------------------------------------------------------	
	//Objetos para el modo dificil
	ImageIcon JugarDificilBotonNuevo = new ImageIcon("Imagenes/jugardenuevoboton.png");
	JLabel JugarDificillblCarta1 = new JLabel(JugarCartaReal);
	JLabel JugarDificillblCarta2 = new JLabel(JugarCartaJuve); 
	JLabel JugarDificillblCarta3 = new JLabel(JugarCartaBarca); 
	JLabel JugarDificillblCarta4 = new JLabel(JugarCartaRoma); 
	JLabel JugarDificillblCarta5 = new JLabel(JugarCartaSpurs); 
	JLabel JugarDificillblCarta6 = new JLabel(JugarCartaSpurs); 
	JLabel JugarDificillblCarta7 = new JLabel(JugarCartaRoma); 
	JLabel JugarDificillblCarta8 = new JLabel(JugarCartaBarca); 
	JLabel JugarDificillblCarta9 = new JLabel(JugarCartaJuve); 
	JLabel JugarDificillblCarta10 = new JLabel(JugarCartaReal);
	JLabel JugarDificillblCarta11 = new JLabel(JugarCartaSporting);
	JLabel JugarDificillblCarta12 = new JLabel(JugarCartaSporting); 
	JLabel JugarDificillblCarta13 = new JLabel(JugarCartaBayer);
	JLabel JugarDificillblCarta14 = new JLabel(JugarCartaBayer);
	JLabel JugarDificillblCarta15 = new JLabel(JugarCartaAjax);
	JLabel JugarDificillblCarta16 = new JLabel(JugarCartaAjax);
	JLabel JugarDificillblCarta17 = new JLabel(JugarCartaPSG);
	JLabel JugarDificillblCarta18 = new JLabel(JugarCartaPSG);
	JLabel JugarDificilPuntos = new JLabel();
	JLabel JugarDificilIntentos = new JLabel();
	JButton JugarDificilbtndeNuevo = new JButton(JugarDificilBotonNuevo);
	int confirmDificil;
	int puntosHechosDificil = 0;
	int intentosPerdidosDificil = 0;
	int intentosRestaDificil = 0;
	int parejasFormadasDificil = 0;
	int parejasRestaDificil = 0;
	//---------------------------------------------------------------------------------------------------------------------------------
	//Objetos para las estadisticas
	JLabel EstadisticaslblNombrejugador = new JLabel();
	JLabel EstadisticaslblPartidasjugadas = new JLabel();
	JLabel EstadisticaslblPartidasganadas = new JLabel();
	JLabel EstadisticaslblPartidasperdidas = new JLabel();
	JLabel EstadisticaslblPuntosHechos = new JLabel();
	JLabel EstadisticaslblIntentosPerdidos = new JLabel();
	JLabel EstadisticaslblParejasFormadas = new JLabel();
	int partidasJugadas = 0,partidasGanadas = 0,partidasPerdidas = 0,intentosPerdidos = 0,parejasFormadas = 0;
	int puntosHechos = 0;
	//---------------------------------------------------------------------------------------------------------------------------------
	//Paneles
	JPanel jplVentanaPrincipal; //JPanel para la pantalla de inicio
	JPanel jplVentanaInstrucciones; //JPanel para la pantalla de instrucciones
	JPanel jplVentanaEstadisticas; //JPanel para la pantalla de estadísticas
	JPanel jplVentanaJugar1; //JPanel para la pantalla del menú de juego
	JPanel jplVentanaJugarFacil; //JPanel para la pantalla del modo de juego Fácil
	JPanel jplVentanaJugarNormal; //JPanel para la pantalla del modo de juego Normal
	JPanel jplVentanaJugarDificil; //JPanel para la pantalla del modo de juego Difícil
	
	//Constructor del JFrame
	Proyecto1()
	{
		setTitle("Memory Game: Champions League 2018"); //Pone nombre a la ventana del programa
		setIconImage(new ImageIcon(getClass().getResource("Imagenes/JFrameIcon.png")).getImage()); //Cambia la icono del JFrame
		setSize(1000,675); //Cambia el tamaño del JFrame
		setVisible(true); //Hace visible el Jframe
		InicioComponentes(); //Método que contiene los componentes gráficos y objetos del JFrame
		setLocationRelativeTo(null); //Ubica el JFrame en el centro de la pantalla
		this.setResizable(false); //Bloquea la opción de cambiar el tamaño del JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Mata procesos cuando se cierra el JFrame
	}
	int ModoRandom() //Función para la creación de numeros random que controlen la opción "Aleatoria"
	{
		int posicion;
		Random AleatorioModo = new Random(); //Se crea un número random
		posicion = AleatorioModo.nextInt(3); //El número random puede tener como resultado 0, 1 o 2
		return posicion; //Se retorna el número random optenido
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	//Métodos para el modo de juego "Fácil"
	JLabel ArreglodeImagenesFacil[] = new JLabel[10]; //Se crea el nuevo arreglo con imagenes
	int ArregloNumeroImagenesFacil[] = new int[10]; //Arreglo de enteros
	int ArregloRepeticionesFacil[] = new int[5]; //Arreglo que controla las repeticiones
	int ArregloControlPrejasFacil[] = new int[10]; //Arreglo que controla las parejas
	int ArregloControlClicksFacil[] = new int[10]; //Controla los eventos producidos cada vez que se da click en una imagen
	int PuntajeFacil = 0; //Variable que controla los puntos
	int IntentosFacil = 6; //Variable que controla los intentos
	int ClicksConteoFacil = 0; //Variable que maneja los clicks
	int FacilEntrada1 = 0,FacilEntrada2 = 0; //Variables que identifican a la 1er y 2da carta volteada
	
	private void InicializarArreglosFacil() //Método que inicializa los arreglos Faciles
	{
		//Perzonalización de los JLabels
		JugarFacilPuntos.setFont(Letra1);
		JugarFacilIntentos.setFont(Letra1);
		JugarFacilPuntos.setForeground(Color.white);
		JugarFacilIntentos.setForeground(Color.white);
		JugarFacilPuntos.setText(""+PuntajeFacil);
		JugarFacilIntentos.setText(""+IntentosFacil);
		InicilizarArregloImagenesFacil();
		//Se inicializan o llenan con 0 los diferentes arreglos del nivel
		LlenarArregloFacil(ArregloNumeroImagenesFacil);
		LlenarArregloFacil(ArregloRepeticionesFacil); 
		LlenarArregloFacil(ArregloControlPrejasFacil);
		LlenarArregloFacil(ArregloControlClicksFacil);
		
		int PosicionImagenFacil; //Variable a la que se le asignará el número random generado
		Random AleatorioFacil = new Random(); //Crea una variable para generar pares de numeros random
		for (int i = 0; i < ArregloNumeroImagenesFacil.length; i++)
		{
			PosicionImagenFacil = AleatorioFacil.nextInt(5); //Genera aleatorios del 0 al 4
			if(ArregloRepeticionesFacil[PosicionImagenFacil] < 2) //Condicional para que el número generado solo se repita 2 veces
			{
				ArregloNumeroImagenesFacil[i] = PosicionImagenFacil; //Guarda el numero generado aleatoriamente en el arreglo
				ArregloRepeticionesFacil[PosicionImagenFacil]++;	
			}
			else
			{
				i--; //Se devuelve en 1 la posición de la matriz
			}
		}
	}
	
	private void LlenarArregloFacil(int[] Arreglo) //Método que inicializa el arreglo
	{
		for (int i = 0; i < Arreglo.length; i++) //Ciclo que recorre el arreglo	
			Arreglo[i] = 0; //Cada posición del arreglo se llena con un "0"
	}
	
	private void InicilizarArregloImagenesFacil() //Método que inicializa los arreglos de imagenes Fácil
	{
		//A cada parte de el arreglo se le asigna una imagen o carta
		ArreglodeImagenesFacil[0] = JugarFacillblCarta1;
		ArreglodeImagenesFacil[1] = JugarFacillblCarta2;
		ArreglodeImagenesFacil[2] = JugarFacillblCarta3;
		ArreglodeImagenesFacil[3] = JugarFacillblCarta4;
		ArreglodeImagenesFacil[4] = JugarFacillblCarta5;
		ArreglodeImagenesFacil[5] = JugarFacillblCarta6;
		ArreglodeImagenesFacil[6] = JugarFacillblCarta7;
		ArreglodeImagenesFacil[7] = JugarFacillblCarta8;
		ArreglodeImagenesFacil[8] = JugarFacillblCarta9;
		ArreglodeImagenesFacil[9] = JugarFacillblCarta10;
		//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesFacil.length; i++)
		{
			//Oculta las imagenes de cada carta, superponiendo a todas otra imagen
			ArreglodeImagenesFacil[i].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png"))); 
			ArreglodeImagenesFacil[i].addMouseListener(this); // El arreglo va a estar a la escucha de lo que haga el mouse
		}
	}
	//Método que valida que las cartas seleccionadas sean pareja o no
	private void ValidarParejasFacil(int e1,int e2)
	{
		//Condicional si los numeros del arreglo de imagenes son los mismos
		if(ArregloNumeroImagenesFacil[e1] == ArregloNumeroImagenesFacil[e2])
		{
			PuntajeFacil += 10; //El usuario gana 10 Puntos
			puntosHechosFacil += 10;
			parejasFormadasFacil++;
			parejasRestaFacil++;
			ArregloControlPrejasFacil[e1] = 1; //Se le asigna 1 a la primera carta seleccionada si formó una pareja
			ArregloControlPrejasFacil[e2] = 1; //Se le asigna 1 a la segunda carta seleccionada si formó una pareja
		}
		else
		{
			ArreglodeImagenesFacil[e1].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png")));
			ArreglodeImagenesFacil[e2].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png")));
			ArregloControlClicksFacil[e1] = 0; //Se reinicia la validación de clicks en el 1er JLabel Seleccionado
			ArregloControlClicksFacil[e2] = 0; //Se reinicia la validación de clicks en el 2do JLabel Seleccionado
			ArregloControlPrejasFacil[e1] = 0; //Se reinicia la validación de parejas si las cartas seleccionadas no forman 1 pareja
			ArregloControlPrejasFacil[e2] = 0; //Se reinicia la validación de parejas si las cartas seleccionadas no forman 1 pareja
			IntentosFacil--;
			intentosPerdidosFacil++;
			intentosRestaFacil++;
			if(IntentosFacil <= 0) //Si el usuario pierde
			{
				JOptionPane.showMessageDialog(null,"¡Ops! Perdiste :c, Inténtalo de nuevo :)",
				"Perdiste",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/error.png")); //Mensaje que el usuario perdió
				InicializarArreglosFacil(); //Voltea de nuevo las cartas a su forma oculta
				partidasJugadas++;
				partidasPerdidas++;
    			IntentosFacil = 6;
    			intentosRestaFacil = 0;
    			parejasRestaFacil = 0;
    			PuntajeFacil = 0;
    			ClicksConteoFacil = 0;
    			FacilEntrada1 = 0;
    			FacilEntrada2 = 0;
    			JugarFacilPuntos.setText("0");
    			JugarFacilIntentos.setText("6");
			}
		}
		//Perzonalización de JLabels
		JugarFacilPuntos.setFont(Letra1);
		JugarFacilIntentos.setFont(Letra1);
		JugarFacilPuntos.setForeground(Color.white);
		JugarFacilIntentos.setForeground(Color.white);
		JugarFacilPuntos.setText(""+PuntajeFacil);
		JugarFacilIntentos.setText(""+IntentosFacil);
	}
	//Método que verifica si ya se encontró una pareja para deshabilitarla
	private boolean VerificaParejasEncontradasFacil(int i)
	{
		if(ArregloControlPrejasFacil[i] != 1) //Condicional si ya la pareja se formó
		{
			return true; //Retorna "verdadero"
		}
		else //Condicional si no se formó la pareja correcta
		{
			return false; //Retorna "falso"
		}
	}
	
	//Método que contiene las características graficas y objetos del JPanel "jplVentanaJugarFacil"
	private void ComponentesPanelJugarFacil()
	{
		InicializarArreglosFacil(); //Inicializa los arreglos normales y arreglos JLabel
		//Definición y construcción de objetos tipo ImageIcon
		ImageIcon JugarFacilFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon JugarFacilEstadisticas = new ImageIcon("Imagenes/ImgEstadisticas.png");
		ImageIcon JugarFacilBorde = new ImageIcon("Imagenes/borde1.png");
		ImageIcon JagarFacilTitulo = new ImageIcon("Imagenes/FacilTitulo.png");
		ImageIcon JugarFacilBotonAtras = new ImageIcon("Imagenes/regresarboton2.png");
		//------------------------------------------------------------------------------------------
		//Definición y construcción de objetos tipo JButton
		JButton JugarFacilbtnAtras = new JButton(JugarFacilBotonAtras);
		//------------------------------------------------------------------------------------------
		//Definición y construcción de objetos tipo JLabel
		JLabel JugarFacillblFondo1 = new JLabel(JugarFacilFondo1);
		JLabel JugarFacilPuntajeTexto = new JLabel(lblPuntajeTexto);
		JLabel JugarFacilIntentosTexto = new JLabel(lblIntentosTexto);
		JLabel JugarFacillblEstadisticas = new JLabel(JugarFacilEstadisticas);
		JLabel JugarFacillblTitulo = new JLabel(JagarFacilTitulo);
		JLabel JugarFacillblBorde = new JLabel(JugarFacilBorde);
		JLabel JugarFacillblBorde2 = new JLabel(JugarFacilBorde);
		//------------------------------------------------------------------------------------------
		//Se agregan las cartas al JPanel
		jplVentanaJugarFacil.add(JugarFacillblCarta1);
		jplVentanaJugarFacil.add(JugarFacillblCarta2);
		jplVentanaJugarFacil.add(JugarFacillblCarta3);
		jplVentanaJugarFacil.add(JugarFacillblCarta4);
		jplVentanaJugarFacil.add(JugarFacillblCarta5);
		jplVentanaJugarFacil.add(JugarFacillblCarta6);
		jplVentanaJugarFacil.add(JugarFacillblCarta7);
		jplVentanaJugarFacil.add(JugarFacillblCarta8);
		jplVentanaJugarFacil.add(JugarFacillblCarta9);
		jplVentanaJugarFacil.add(JugarFacillblCarta10);
		//------------------------------------------------------------------------------------------
		//Se agregan elementos al JPanel
		jplVentanaJugarFacil.add(JugarFacilbtndeNuevo);
		jplVentanaJugarFacil.add(JugarFacilbtnAtras);
		jplVentanaJugarFacil.add(JugarFacilIntentosTexto);
		jplVentanaJugarFacil.add(JugarFacilPuntos);
		jplVentanaJugarFacil.add(JugarFacilIntentos);
		jplVentanaJugarFacil.add(JugarFacilPuntajeTexto);
		jplVentanaJugarFacil.add(JugarFacillblTitulo);
		jplVentanaJugarFacil.add(JugarFacillblBorde2);
		jplVentanaJugarFacil.add(JugarFacillblBorde);
		jplVentanaJugarFacil.add(JugarFacillblEstadisticas);
		jplVentanaJugarFacil.add(JugarFacillblFondo1);
		//------------------------------------------------------------------------------------------
		//Se ubican las cartas en el JPanel
		JugarFacillblCarta1.setBounds(240,150,85,132);
		JugarFacillblCarta2.setBounds(340,150,85,132);
		JugarFacillblCarta3.setBounds(440,150,85,132);
		JugarFacillblCarta4.setBounds(540,150,85,132);
		JugarFacillblCarta5.setBounds(640,150,85,132);
		JugarFacillblCarta6.setBounds(240,300,85,132);
		JugarFacillblCarta7.setBounds(340,300,85,132);
		JugarFacillblCarta8.setBounds(440,300,85,132);
		JugarFacillblCarta9.setBounds(540,300,85,132);
		JugarFacillblCarta10.setBounds(640,300,85,132);
		//------------------------------------------------------------------------------------------
		//Se ubican y redimensionan las variables tipo objeto
		JugarFacilPuntos.setBounds(700,450,530,145);
		JugarFacilIntentos.setBounds(725,515,530,145);
		JugarFacilbtndeNuevo.setBounds(60,480,285,63);
		JugarFacilbtnAtras.setBounds(60,560,285,63);
		JugarFacillblTitulo.setBounds(80,20,448,96);
		JugarFacillblBorde2.setBounds(410,480,14,145);
		JugarFacillblBorde.setBounds(60,30,14,75);
		JugarFacilPuntajeTexto.setBounds(325,450,530,145);
		JugarFacilIntentosTexto.setBounds(335,515,530,145);
		JugarFacillblEstadisticas.setBounds(410,480,530,145);
		JugarFacillblFondo1.setBounds(0,0,1000,675);
		//------------------------------------------------------------------------------------------
		//Programación de los JButtons del JPanel
		//Programación del JButton "JugarFacilbtndeNuevo"
		JugarFacilbtndeNuevo.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				//Reinicia el modo
				InicializarArreglosFacil();
    			IntentosFacil = 6;
    			PuntajeFacil = 0;
    			ClicksConteoFacil = 0;
    			intentosRestaFacil = 0;
    			FacilEntrada1 = 0;
    			FacilEntrada2 = 0;
    			JugarFacilPuntos.setText("0");
    			JugarFacilIntentos.setText("6");
			}
    	});
		//Programación del JButton "JugarFacilbtnAtras"
		JugarFacilbtnAtras.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(PuntajeFacil < 50) //Condicionar para validar el botón de regresar
				{
					confirmFacil = JOptionPane.showConfirmDialog(null,
					"¿Estás seguro de volver al menú de juego?, perderás tu progreso en esta partida");
					if(confirmFacil == JOptionPane.OK_OPTION)
					{
						InicializarArreglosFacil(); //Se reinician las cartas a su estado de escondidas aleatoriamente
						jplVentanaJugarFacil.setVisible(false); //Hace invisible la ventana del nivel
						jplVentanaJugar1.setVisible(true); //Hace visible la ventada del menú de niveles de juego
						puntosHechosFacil -= PuntajeFacil;
						intentosPerdidosFacil -= intentosRestaFacil;
						parejasFormadasFacil -= parejasRestaFacil;
						partidasJugadas--;
						IntentosFacil = 6;
						intentosRestaFacil = 0;
						parejasRestaFacil = 0;
    					PuntajeFacil = 0;
    					JugarFacilPuntos.setText("0");
    					JugarFacilIntentos.setText("6");
					}
				}
			}
		});
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	//Métodos de la modalidad de juego "Normal"
	JLabel ArreglodeImagenesNormal[] = new JLabel[14]; //Se crea el nuevo arreglo con imagenes
	int ArregloNumeroImagenesNormal[] = new int[14]; //Arreglo de enteros
	int ArregloRepeticionesNormal[] = new int[7]; //Arreglo que controla las repeticiones
	int ArregloControlPrejasNormal[] = new int[14]; //Arreglo que controla las parejas
	int ArregloControlClicksNormal[] = new int[14]; //Controla los eventos producidos cada vez que se da click en una imagen
	int PuntajeNormal = 0; //Variable que controla los puntos
	int IntentosNormal = 8; //Variable que controla los intentos
	int ClicksConteoNormal = 0; //Variable que maneja los clicks
	int NormalEntrada1 = 0,NormalEntrada2 = 0; //Variables que identifican a la 1er y 2da carta volteada
	
	private void InicializarArreglosNormal() //Método que inicializa los arreglos Faciles
	{
		//Perzonalización de JLabels
		JugarNormalPuntos.setFont(Letra1);
		JugarNormalIntentos.setFont(Letra1);
		JugarNormalPuntos.setForeground(Color.white);
		JugarNormalIntentos.setForeground(Color.white);
		JugarNormalPuntos.setText(""+PuntajeNormal);
		JugarNormalIntentos.setText(""+IntentosNormal);
		
		InicilizarArregloImagenesNormal();
		//Se inicializan o llenan con 0 los diferentes arreglos del nivel
		LlenarArregloNormal(ArregloNumeroImagenesNormal);
		LlenarArregloNormal(ArregloRepeticionesNormal); 
		LlenarArregloNormal(ArregloControlPrejasNormal);
		LlenarArregloNormal(ArregloControlClicksNormal);
		
		int PosicionImagenNormal; //Variable que guardará el número generado aleatoriamente
		Random AleatorioNormal = new Random(); //Crea una variable´para generar pares de numeros random
		for (int i = 0; i < ArregloNumeroImagenesNormal.length; i++)
		{
			PosicionImagenNormal = AleatorioNormal.nextInt(7); //Genera numeros aleatorios del 0 al 6
			if(ArregloRepeticionesNormal[PosicionImagenNormal] < 2) //Condicional para que el número generado solo se repita 2 veces
			{
				ArregloNumeroImagenesNormal[i] = PosicionImagenNormal; //Guarda el numero generado aleatoriamente en el arreglo
				ArregloRepeticionesNormal[PosicionImagenNormal]++;	
			}
			else
			{
				i--; //Se devuelve en 1 la posición de la matriz
			}
		}
	}
	
	private void LlenarArregloNormal(int[] Arreglo) //Método que inicializa el arreglo con "0"
	{
		for (int i = 0; i < Arreglo.length; i++) //Ciclo que recorre el arreglo
			Arreglo[i] = 0; //Se llena con "0" cada posición del arreglo
	}
	
	private void InicilizarArregloImagenesNormal() //Método que inicializa los arreglos de imagenes No.1
	{
		//A cada parte de el arreglo se le asigna una imagen o carta
		ArreglodeImagenesNormal[0] = JugarNormallblCarta1;
		ArreglodeImagenesNormal[1] = JugarNormallblCarta2;
		ArreglodeImagenesNormal[2] = JugarNormallblCarta3;
		ArreglodeImagenesNormal[3] = JugarNormallblCarta4;
		ArreglodeImagenesNormal[4] = JugarNormallblCarta5;
		ArreglodeImagenesNormal[5] = JugarNormallblCarta6;
		ArreglodeImagenesNormal[6] = JugarNormallblCarta7;
		ArreglodeImagenesNormal[7] = JugarNormallblCarta8;
		ArreglodeImagenesNormal[8] = JugarNormallblCarta9;
		ArreglodeImagenesNormal[9] = JugarNormallblCarta10;
		ArreglodeImagenesNormal[10] = JugarNormallblCarta11;
		ArreglodeImagenesNormal[11] = JugarNormallblCarta12;
		ArreglodeImagenesNormal[12] = JugarNormallblCarta13;
		ArreglodeImagenesNormal[13] = JugarNormallblCarta14;
		//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesNormal.length; i++)
		{
			//Oculta las imagenes de cada carta, superponiendo a todas otra imagen
			ArreglodeImagenesNormal[i].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png"))); 
			ArreglodeImagenesNormal[i].addMouseListener(this); // El arreglo va a estar a la escucha de lo que haga el mouse
		}
	}
	
	private void ValidarParejasNormal(int e1,int e2) //Método que valida que las parejas formadas sean correctas
	{
		//Condicional si los numeros del arreglo de imagenes son los mismos
		if(ArregloNumeroImagenesNormal[e1] == ArregloNumeroImagenesNormal[e2]) 
		{
			PuntajeNormal += 10; //El usuario gana 10 Puntos
			puntosHechosNormal += 10;
			parejasFormadasNormal++;
			parejasRestaNormal++;
			ArregloControlPrejasNormal[e1] = 1; //Se le asigna 1 a la primera carta seleccionada si formó una pareja
			ArregloControlPrejasNormal[e2] = 1; //Se le asigna 1 a la primera carta seleccionada si formó una pareja
		}
		else
		{
			ArreglodeImagenesNormal[e1].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png")));
			ArreglodeImagenesNormal[e2].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png")));
			ArregloControlClicksNormal[e1] = 0; //Se reinicia la validación de clicks en el 1er JLabel Seleccionado
			ArregloControlClicksNormal[e2] = 0; //Se reinicia la validación de clicks en el 2do JLabel Seleccionado
			ArregloControlPrejasNormal[e1] = 0; //Se reinicia la validación de la 1ra carta seleccionada de la pareja fallida
			ArregloControlPrejasNormal[e2] = 0; //Se reinicia la validación de la 2da carta seleccionada de la pareja fallida
			IntentosNormal--;
			intentosPerdidosNormal++;
			intentosRestaNormal++;
			if(IntentosNormal <= 0) //Si el usuario pierde
			{
				JOptionPane.showMessageDialog(null,"¡Ops! Perdiste :c, Inténtalo de nuevo :)",
				"Perdiste",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/error.png")); //Mensaje de que el usuario perdió
				InicializarArreglosNormal(); //Voltea de nuevo las cartas a su forma oculta
    			partidasJugadas++;
    			partidasPerdidas++;
    			IntentosNormal = 10;
    			intentosRestaNormal = 0;
    			PuntajeNormal = 0;
    			ClicksConteoNormal = 0;
    			parejasRestaNormal = 0;
    			NormalEntrada1 = 0;
    			NormalEntrada2 = 0;
    			JugarNormalPuntos.setText("0");
    			JugarNormalIntentos.setText("10");
			}
		}
		//Perzonalización de JLabels
		JugarNormalPuntos.setFont(Letra1);
		JugarNormalIntentos.setFont(Letra1);
		JugarNormalPuntos.setForeground(Color.white);
		JugarNormalIntentos.setForeground(Color.white);
		JugarNormalPuntos.setText(""+PuntajeNormal);
		JugarNormalIntentos.setText(""+IntentosNormal);
	}
	//Método que verifica si ya se encontró una pareja para deshabilitarla
	private boolean VerificaParejasEncontradasNormal(int i)
	{
		if(ArregloControlPrejasNormal[i] != 1) //Condicional que verifica si se formó una pareja correcta
		{
			return true; //Retorna un "verdadero"
		}
		else //Condicional por si la pareja formada no es correcta
		{
			return false; //Retorna un "falso"
		}
	}
	
	//Método que contiene las características graficas y objetos del JPanel "jplVentanaJugarFacil"
	private void ComponentesPanelJugarNormal()
	{
		InicializarArreglosNormal();	
		//Definición y construcción de objetos tipo ImageIcon
		ImageIcon JugarNormalFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon JugarNormalEstadisticas = new ImageIcon("Imagenes/ImgEstadisticas.png");
		ImageIcon JugarNormalBorde = new ImageIcon("Imagenes/borde1.png");
		ImageIcon JagarNormalTitulo = new ImageIcon("Imagenes/NormalTitulo.png");
		ImageIcon JugarNormalBotonAtras = new ImageIcon("Imagenes/regresarboton2.png");
		//------------------------------------------------------------------------------------------
		//Definición y construcción de objetos tipo JButton
		JButton JugarNormalbtnAtras = new JButton(JugarNormalBotonAtras);
		//------------------------------------------------------------------------------------------
		//Definición y construcción de objetos tipo JLabel
		JLabel JugarNormallblFondo1 = new JLabel(JugarNormalFondo1);
		JLabel JugarNormalPuntajeTexto = new JLabel(lblPuntajeTexto);
		JLabel JugarNormalIntentosTexto = new JLabel(lblIntentosTexto);
		JLabel JugarNormallblEstadisticas = new JLabel(JugarNormalEstadisticas);
		JLabel JugarNormallblTitulo = new JLabel(JagarNormalTitulo);
		JLabel JugarNormallblBorde = new JLabel(JugarNormalBorde);
		JLabel JugarNormallblBorde2 = new JLabel(JugarNormalBorde);
		//------------------------------------------------------------------------------------------
		//Se agregan las cartas al JPanel
		jplVentanaJugarNormal.add(JugarNormallblCarta1);
		jplVentanaJugarNormal.add(JugarNormallblCarta2);
		jplVentanaJugarNormal.add(JugarNormallblCarta3);
		jplVentanaJugarNormal.add(JugarNormallblCarta4);
		jplVentanaJugarNormal.add(JugarNormallblCarta5);
		jplVentanaJugarNormal.add(JugarNormallblCarta6);
		jplVentanaJugarNormal.add(JugarNormallblCarta7);
		jplVentanaJugarNormal.add(JugarNormallblCarta8);
		jplVentanaJugarNormal.add(JugarNormallblCarta9);
		jplVentanaJugarNormal.add(JugarNormallblCarta10);
		jplVentanaJugarNormal.add(JugarNormallblCarta11);
		jplVentanaJugarNormal.add(JugarNormallblCarta12);
		jplVentanaJugarNormal.add(JugarNormallblCarta13);
		jplVentanaJugarNormal.add(JugarNormallblCarta14);
		//------------------------------------------------------------------------------------------
		//Se agregan elementos al JPanel
		jplVentanaJugarNormal.add(JugarNormalbtndeNuevo);
		jplVentanaJugarNormal.add(JugarNormalbtnAtras);
		jplVentanaJugarNormal.add(JugarNormalIntentosTexto);
		jplVentanaJugarNormal.add(JugarNormalPuntos);
		jplVentanaJugarNormal.add(JugarNormalIntentos);
		jplVentanaJugarNormal.add(JugarNormalPuntajeTexto);
		jplVentanaJugarNormal.add(JugarNormallblTitulo);
		jplVentanaJugarNormal.add(JugarNormallblBorde2);
		jplVentanaJugarNormal.add(JugarNormallblBorde);
		jplVentanaJugarNormal.add(JugarNormallblEstadisticas);
		jplVentanaJugarNormal.add(JugarNormallblFondo1);
		//------------------------------------------------------------------------------------------
		//Se ubican las cartas en el JPanel
		JugarNormallblCarta1.setBounds(150,150,85,132);
		JugarNormallblCarta2.setBounds(250,150,85,132);
		JugarNormallblCarta3.setBounds(350,150,85,132);
		JugarNormallblCarta4.setBounds(450,150,85,132);
		JugarNormallblCarta5.setBounds(550,150,85,132);
		JugarNormallblCarta6.setBounds(650,150,85,132);
		JugarNormallblCarta7.setBounds(750,150,85,132);
		JugarNormallblCarta8.setBounds(150,300,85,132);
		JugarNormallblCarta9.setBounds(250,300,85,132);
		JugarNormallblCarta10.setBounds(350,300,85,132);
		JugarNormallblCarta11.setBounds(450,300,85,132);
		JugarNormallblCarta12.setBounds(550,300,85,132);
		JugarNormallblCarta13.setBounds(650,300,85,132);
		JugarNormallblCarta14.setBounds(750,300,85,132);
		//------------------------------------------------------------------------------------------
		//Se ubican y redimensionan las variables tipo objeto
		JugarNormalPuntos.setBounds(700,450,530,145);
		JugarNormalIntentos.setBounds(725,515,530,145);
		JugarNormalbtndeNuevo.setBounds(60,480,285,63);
		JugarNormalbtnAtras.setBounds(60,560,285,63);
		JugarNormallblTitulo.setBounds(100,20,500,96);
		JugarNormallblBorde2.setBounds(410,480,14,145);
		JugarNormallblBorde.setBounds(60,30,14,75);
		JugarNormalPuntajeTexto.setBounds(325,450,530,145);
		JugarNormalIntentosTexto.setBounds(335,515,530,145);
		JugarNormallblEstadisticas.setBounds(410,480,530,145);
		JugarNormallblFondo1.setBounds(0,0,1000,675);
		//------------------------------------------------------------------------------------------
		//Programación de los JButtons del JPanel
		JugarNormalbtndeNuevo.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			//Reinicia los valores del modo de juego
    			InicializarArreglosNormal(); //Se voltean las cartas a su forma oculta
    			IntentosNormal = 8;
    			PuntajeNormal = 0;
    			ClicksConteoNormal = 0;
    			NormalEntrada1 = 0;
    			NormalEntrada2 = 0;
    			JugarNormalPuntos.setText("0");
    			JugarNormalIntentos.setText("8");			
    		}		
    	});
		//Programación del JButton "JugarNormalbtnAtras"
		JugarNormalbtnAtras.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(PuntajeNormal < 70) //Condicionar para validar el botón de regresar
				{
					confirmNormal = JOptionPane.showConfirmDialog(null,
					"¿Estás seguro de volver al menú de juego?, perderás tu progreso en esta partida");
					if(confirmNormal == JOptionPane.OK_OPTION)
					{
						InicializarArreglosNormal(); //Se voltean las cartas a su forma oculta
						puntosHechosNormal -= PuntajeNormal;
						intentosPerdidosNormal -= intentosRestaNormal;
						parejasFormadasNormal -= parejasRestaNormal;
						partidasJugadas--;
    					IntentosNormal = 8;
    					PuntajeNormal = 0;
    					intentosRestaNormal = 0;
    					parejasRestaNormal = 0;
    					ClicksConteoNormal = 0;
    					NormalEntrada1 = 0;
    					NormalEntrada2 = 0;
    					JugarNormalPuntos.setText("0");
    					JugarNormalIntentos.setText("8");
    					jplVentanaJugarNormal.setVisible(false); //Hace invisible el JPanel del modo de juego
    					jplVentanaJugar1.setVisible(true); //Hace visible el JPanel del menú de dificultad de juego
					}
				}
			}
		});
	}
	//---------------------------------------------------------------------------------------------------------------------------------
	//Métodos de la modalidad de juego "Dificil"
	JLabel ArreglodeImagenesDificil[] = new JLabel[18]; //Se crea el nuevo arreglo con imagenes
	int ArregloNumeroImagenesDificil[] = new int[18]; //Arreglo de enteros
	int ArregloRepeticionesDificil[] = new int[9]; //Arreglo que controla las repeticiones
	int ArregloControlPrejasDificil[] = new int[18]; //Arreglo que controla las parejas
	int ArregloControlClicksDificil[] = new int[18]; //Controla los eventos producidos cada vez que se da click en una imagen
	int PuntajeDificil = 0; //Variable que controla los puntos
	int IntentosDificil = 9; //Variable que controla los intentos
	int ClicksConteoDificil = 0; //Variable que maneja los clicks
	int DificilEntrada1 = 0,DificilEntrada2 = 0;
	
	private void InicializarArreglosDificil() //Método que inicializa los arreglos Faciles
	{
		//Personalización de JLabels
		JugarDificilPuntos.setFont(Letra1);
		JugarDificilIntentos.setFont(Letra1);
		JugarDificilPuntos.setForeground(Color.white);
		JugarDificilIntentos.setForeground(Color.white);
		JugarDificilPuntos.setText(""+PuntajeDificil);
		JugarDificilIntentos.setText(""+IntentosDificil);
		
		InicilizarArregloImagenesDificil();
		//Se inicializan o llenan de ceros del arreglos utilizados
		LlenarArregloDificil(ArregloNumeroImagenesDificil);
		LlenarArregloDificil(ArregloRepeticionesDificil); //Areglo que controla que no tenga más de 1 par de la misma imagen
		LlenarArregloDificil(ArregloControlPrejasDificil);
		LlenarArregloDificil(ArregloControlClicksDificil);
		
		int PosicionImagenDificil;
		Random AleatorioDificil = new Random(); //Crea una variable para generar pares de numeros random
		for (int i = 0; i < ArregloNumeroImagenesDificil.length; i++) //Ciclo que recorre el arreglo
		{
			PosicionImagenDificil = AleatorioDificil.nextInt(9); //Genera 9 números aleatorios
			if(ArregloRepeticionesDificil[PosicionImagenDificil] < 2) //Condicional para que se formen parejas de números aleatorios
			{
				ArregloNumeroImagenesDificil[i] = PosicionImagenDificil; //Guarda el numero generado aleatoriamente en el arreglo
				ArregloRepeticionesDificil[PosicionImagenDificil]++;	
			}
			else //Condicional por si no se generaron parejas de números aleatorios
			{
				i--; //Se devuelve en 1 la posición de la matriz
			}
		}
	}
	
	private void LlenarArregloDificil(int[] Arreglo) //Método que inicializa el arreglo y lo llena con ceros
	{
		for (int i = 0; i < Arreglo.length; i++) //Ciclo que recorre el arreglo
			Arreglo[i] = 0; //Se llenan con "0" cada posición del arreglo
	}
	
	private void InicilizarArregloImagenesDificil() //Método que inicializa los arreglos de imagenes No.1
	{
		//A cada parte de el arreglo se le asigna una imagen o carta
		ArreglodeImagenesDificil[0] = JugarDificillblCarta1;
		ArreglodeImagenesDificil[1] = JugarDificillblCarta2;
		ArreglodeImagenesDificil[2] = JugarDificillblCarta3;
		ArreglodeImagenesDificil[3] = JugarDificillblCarta4;
		ArreglodeImagenesDificil[4] = JugarDificillblCarta5;
		ArreglodeImagenesDificil[5] = JugarDificillblCarta6;
		ArreglodeImagenesDificil[6] = JugarDificillblCarta7;
		ArreglodeImagenesDificil[7] = JugarDificillblCarta8;
		ArreglodeImagenesDificil[8] = JugarDificillblCarta9;
		ArreglodeImagenesDificil[9] = JugarDificillblCarta10;
		ArreglodeImagenesDificil[10] = JugarDificillblCarta11;
		ArreglodeImagenesDificil[11] = JugarDificillblCarta12;
		ArreglodeImagenesDificil[12] = JugarDificillblCarta13;
		ArreglodeImagenesDificil[13] = JugarDificillblCarta14;
		ArreglodeImagenesDificil[14] = JugarDificillblCarta15;
		ArreglodeImagenesDificil[15] = JugarDificillblCarta16;
		ArreglodeImagenesDificil[16] = JugarDificillblCarta17;
		ArreglodeImagenesDificil[17] = JugarDificillblCarta18;
		//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesDificil.length; i++) //Ciclo que recorre el arreglo
		{
			//Oculta las imagenes de cada carta, superponiendo a todas otra imagen
			ArreglodeImagenesDificil[i].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png"))); 
			ArreglodeImagenesDificil[i].addMouseListener(this); // El arreglo va a estar a la escucha de lo que haga el mouse
		}
	}
	//Método que valida que se formen las parejas correctas cuando el usuario lo intenta
	private void ValidarParejasDificil(int e1,int e2) 
	{
		//Condicional si los numeros del arreglo de imagenes son los mismos
		if(ArregloNumeroImagenesDificil[e1] == ArregloNumeroImagenesDificil[e2]) 
		{
			PuntajeDificil += 10; //El usuario gana 10 Puntos
			puntosHechosDificil += 10; 
			parejasFormadasDificil++;
			parejasRestaDificil++;
			ArregloControlPrejasDificil[e1] = 1; //Se le asigna 1 a la primera carta seleccionada si formó una pareja
			ArregloControlPrejasDificil[e2] = 1; //Se le asigna 1 a la primera carta seleccionada si formó una pareja
		}
		else
		{
			ArreglodeImagenesDificil[e1].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png")));
			ArreglodeImagenesDificil[e2].setIcon(new ImageIcon(getClass().getResource("Imagenes/Carta.png")));
			ArregloControlClicksDificil[e1] = 0; //Se reinicia la validación de clicks en el 1er JLabel Seleccionado
			ArregloControlClicksDificil[e2] = 0; //Se reinicia la validación de clicks en el 2do JLabel Seleccionado
			ArregloControlPrejasDificil[e1] = 0; //Se reinicia la validación de la 1ra carta seleccionada de la pareja fallida
			ArregloControlPrejasDificil[e2] = 0; //Se reinicia la validación de la 2da carta seleccionada de la pareja fallida
			IntentosDificil--;
			intentosRestaDificil++;
			intentosPerdidosDificil++;
			if(IntentosDificil <= 0) //Si el usuario pierde
			{
				JOptionPane.showMessageDialog(null,"¡Ops! Perdiste :c, Inténtalo de nuevo :)",
				"Perdiste",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/error.png")); //Mensaje de que el usuario perdió
				InicializarArreglosDificil(); //Voltea las cartas a su forma oculta
    			partidasJugadas++;
    			partidasPerdidas++;
    			IntentosDificil = 9;
    			intentosRestaDificil = 0;
    			parejasRestaDificil = 0;
    			PuntajeDificil = 0;
    			ClicksConteoDificil = 0;
    			DificilEntrada1 = 0;
    			DificilEntrada2 = 0;
    			JugarDificilPuntos.setText("0");
    			JugarDificilIntentos.setText("9");
			}
		}
		//Personalización de los JLabels
		JugarDificilPuntos.setFont(Letra1);
		JugarDificilIntentos.setFont(Letra1);
		JugarDificilPuntos.setForeground(Color.white);
		JugarDificilIntentos.setForeground(Color.white);
		JugarDificilPuntos.setText(""+PuntajeDificil);
		JugarDificilIntentos.setText(""+IntentosDificil);
	}
	//Método que verifica si ya se encontró una pareja para deshabilitarla
	private boolean VerificaParejasEncontradasDificil(int i)
	{
		if(ArregloControlPrejasDificil[i] != 1) //Condicional que verifica si se formó una pareja correcta
		{
			return true; //Retorna un "verdadero"
		}
		else //Condicional que verifica si se formó una pareja incorrecta
		{
			return false; //Retorna un "false"
		}
	}
	
	private void ComponentesPanelJugarDificil()
	{
		InicializarArreglosDificil();
		//Definición y construcción de objetos tipo ImageIcon
		ImageIcon JugarDificilFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon JugarDificilEstadisticas = new ImageIcon("Imagenes/ImgEstadisticas.png");
		ImageIcon JugarDificilBorde = new ImageIcon("Imagenes/borde1.png");
		ImageIcon JagarDificilTitulo = new ImageIcon("Imagenes/DificilTitulo.png");
		ImageIcon JugarDificilBotonAtras = new ImageIcon("Imagenes/regresarboton2.png");
		//------------------------------------------------------------------------------------------
		//Definición y construcción de objetos tipo JButton
		JButton JugarDificilbtnAtras = new JButton(JugarDificilBotonAtras);
		//------------------------------------------------------------------------------------------
		//Definición y construcción de objetos tipo JLabel
		JLabel JugarDificillblFondo1 = new JLabel(JugarDificilFondo1);
		JLabel JugarDificilPuntajeTexto = new JLabel(lblPuntajeTexto);
		JLabel JugarDificilIntentosTexto = new JLabel(lblIntentosTexto);
		JLabel JugarDificillblEstadisticas = new JLabel(JugarDificilEstadisticas);
		JLabel JugarDificillblTitulo = new JLabel(JagarDificilTitulo);
		JLabel JugarDificillblBorde = new JLabel(JugarDificilBorde);
		JLabel JugarDificillblBorde2 = new JLabel(JugarDificilBorde);
		//------------------------------------------------------------------------------------------
		//Se agregan las cartas al JPanel
		jplVentanaJugarDificil.add(JugarDificillblCarta1);
		jplVentanaJugarDificil.add(JugarDificillblCarta2);
		jplVentanaJugarDificil.add(JugarDificillblCarta3);
		jplVentanaJugarDificil.add(JugarDificillblCarta4);
		jplVentanaJugarDificil.add(JugarDificillblCarta5);
		jplVentanaJugarDificil.add(JugarDificillblCarta6);
		jplVentanaJugarDificil.add(JugarDificillblCarta7);
		jplVentanaJugarDificil.add(JugarDificillblCarta8);
		jplVentanaJugarDificil.add(JugarDificillblCarta9);
		jplVentanaJugarDificil.add(JugarDificillblCarta10);
		jplVentanaJugarDificil.add(JugarDificillblCarta11);
		jplVentanaJugarDificil.add(JugarDificillblCarta12);
		jplVentanaJugarDificil.add(JugarDificillblCarta13);
		jplVentanaJugarDificil.add(JugarDificillblCarta14);
		jplVentanaJugarDificil.add(JugarDificillblCarta15);
		jplVentanaJugarDificil.add(JugarDificillblCarta16);
		jplVentanaJugarDificil.add(JugarDificillblCarta17);
		jplVentanaJugarDificil.add(JugarDificillblCarta18);
		//------------------------------------------------------------------------------------------
		//Se agregan elementos al JPanel
		jplVentanaJugarDificil.add(JugarDificilbtndeNuevo);
		jplVentanaJugarDificil.add(JugarDificilbtnAtras);
		jplVentanaJugarDificil.add(JugarDificilIntentosTexto);
		jplVentanaJugarDificil.add(JugarDificilPuntos);
		jplVentanaJugarDificil.add(JugarDificilIntentos);
		jplVentanaJugarDificil.add(JugarDificilPuntajeTexto);
		jplVentanaJugarDificil.add(JugarDificillblTitulo);
		jplVentanaJugarDificil.add(JugarDificillblBorde2);
		jplVentanaJugarDificil.add(JugarDificillblBorde);
		jplVentanaJugarDificil.add(JugarDificillblEstadisticas);
		jplVentanaJugarDificil.add(JugarDificillblFondo1);
		//------------------------------------------------------------------------------------------
		//Se ubican las cartas en el JPanel
		JugarDificillblCarta1.setBounds(60,150,85,132);
		JugarDificillblCarta2.setBounds(160,150,85,132);
		JugarDificillblCarta3.setBounds(260,150,85,132);
		JugarDificillblCarta4.setBounds(360,150,85,132);
		JugarDificillblCarta5.setBounds(460,150,85,132);
		JugarDificillblCarta6.setBounds(560,150,85,132);
		JugarDificillblCarta7.setBounds(660,150,85,132);
		JugarDificillblCarta8.setBounds(760,150,85,132);
		JugarDificillblCarta9.setBounds(860,150,85,132);
		JugarDificillblCarta10.setBounds(60,300,85,132);
		JugarDificillblCarta11.setBounds(160,300,85,132);
		JugarDificillblCarta12.setBounds(260,300,85,132);
		JugarDificillblCarta13.setBounds(360,300,85,132);
		JugarDificillblCarta14.setBounds(460,300,85,132);
		JugarDificillblCarta15.setBounds(560,300,85,132);
		JugarDificillblCarta16.setBounds(660,300,85,132);
		JugarDificillblCarta17.setBounds(760,300,85,132);
		JugarDificillblCarta18.setBounds(860,300,85,132);
		//------------------------------------------------------------------------------------------
		//Se ubican y redimensionan las variables tipo objeto
		JugarDificilPuntos.setBounds(700,450,530,145);
		JugarDificilIntentos.setBounds(725,515,530,145);
		JugarDificilbtndeNuevo.setBounds(60,480,285,63);
		JugarDificilbtnAtras.setBounds(60,560,285,63);
		JugarDificillblTitulo.setBounds(100,20,448,96);
		JugarDificillblBorde2.setBounds(410,480,14,145);
		JugarDificillblBorde.setBounds(60,30,14,75);
		JugarDificilPuntajeTexto.setBounds(325,450,530,145);
		JugarDificilIntentosTexto.setBounds(335,515,530,145);
		JugarDificillblEstadisticas.setBounds(410,480,530,145);
		JugarDificillblFondo1.setBounds(0,0,1000,675);
		//------------------------------------------------------------------------------------------
		//Programación de los JButtons del JPanel
		//Programación del JButton "JugarDificilbtndeNuevo"
		JugarDificilbtndeNuevo.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			InicializarArreglosDificil(); //Voltea las cartas a su forma oculta
    			IntentosDificil = 9;
    			PuntajeDificil = 0;
    			ClicksConteoDificil = 0;
    			DificilEntrada1 = 0;
    			DificilEntrada2 = 0;
    			JugarDificilPuntos.setText("0");
    			JugarDificilIntentos.setText("9");
    		}
    	});
		//Programación del JButton "JugarDificilbtnAtras"
		JugarDificilbtnAtras.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(PuntajeNormal < 70) //Condicionar para validar el botón de regresar
				{
					confirmDificil = JOptionPane.showConfirmDialog(null,
					"¿Estás seguro de volver al menú de juego?, perderás tu progreso en esta partida");
					if(confirmDificil == JOptionPane.OK_OPTION)
					{
						//Se reinician valores del modo de juego
						InicializarArreglosDificil(); //Voltea las cartas a su forma oculta
						puntosHechosDificil -= PuntajeDificil;
    					IntentosDificil = 9;
    					intentosPerdidosDificil -= intentosRestaDificil;
    					parejasFormadasDificil -= parejasRestaDificil;
    					intentosRestaDificil = 0;
    					PuntajeDificil = 0;
    					ClicksConteoDificil = 0;
    					DificilEntrada1 = 0;
    					DificilEntrada2 = 0;
    					JugarDificilPuntos.setText("0");
    					JugarDificilIntentos.setText("9");
    					partidasJugadas--;
    					jplVentanaJugarDificil.setVisible(false);
    					jplVentanaJugar1.setVisible(true);
					}	
				}
			}
		});
	}
	//-----------------------------------------------------------------------------------------------------------------------------------
	private void InicioComponentes() //Método que contiene todos los componentes gráficos y JPanels del constructor
	{
		//JPanel Principal
		jplVentanaPrincipal = new JPanel(); 
		jplVentanaPrincipal.setBounds(0,0,1000,675); //Da un tamaño a la ventana
		jplVentanaPrincipal.setLayout(null); //Quita la ubicación automática de los objetos del JPanel
		jplVentanaPrincipal.setVisible(true); //Hace visible el JPanel
		ComponentesPanelPrincipal(); //Invoca al método que contiene las caracteristicas y objetos del JPanel
		//----------------------------------------------------------------------------------------------
		//JPanel de instrucciones
		jplVentanaInstrucciones = new PanelInstrucciones();
		ComponentesPanelInstrucciones(); //Invoca al método que contiene las caracteristicas y objetos del JPanel
		//----------------------------------------------------------------------------------------------
		//JPanel Jugar No.1
		jplVentanaJugar1 = new JPanel();
		jplVentanaJugar1.setBounds(0,0,1000,675); //Da un tamaño a la ventana
		jplVentanaJugar1.setLayout(null); //Quita la ubicación automática de los objetos del JPanel
		jplVentanaJugar1.setVisible(false); //Hace invisible el JPanel
		ComponentesPanelJugar1(); //Invoca al método que contiene las caracteristicas y objetos del JPanel
		//----------------------------------------------------------------------------------------------
		//JPanel Jugar Fácil
		jplVentanaJugarFacil = new JPanel();
		jplVentanaJugarFacil.setBounds(0,0,1000,675); //Da un tamaño a la ventana
		jplVentanaJugarFacil.setLayout(null); //Quita la ubicación automática de los objetos del JPanel
		jplVentanaJugarFacil.setVisible(false); //Hace invisible el JPanel
		ComponentesPanelJugarFacil(); //Invoca al método que contiene las caracteristicas y objetos del JPanel
		//----------------------------------------------------------------------------------------------
		//JPanel Jugar Normal
		jplVentanaJugarNormal = new JPanel();
		jplVentanaJugarNormal.setBounds(0,0,1000,675); //Da un tamaño a la ventana
		jplVentanaJugarNormal.setLayout(null); //Quita la ubicación automática de los objetos del JPanel
		jplVentanaJugarNormal.setVisible(false); //Hace invisible el JPanel
		ComponentesPanelJugarNormal(); //Invoca al método que contiene las caracteristicas y objetos del JPanel
		//----------------------------------------------------------------------------------------------
		//JPanel Jugar Dificil
		jplVentanaJugarDificil = new JPanel();
		jplVentanaJugarDificil.setBounds(0,0,1000,675); //Da un tamaño a la ventana
		jplVentanaJugarDificil.setLayout(null); //Quita la ubicación automática de los objetos del JPanel
		jplVentanaJugarDificil.setVisible(false); //Hace invisible el JPanel
		ComponentesPanelJugarDificil(); //Invoca al método que contiene las caracteristicas y objetos del JPanel
		//----------------------------------------------------------------------------------------------
		//JPanel de estadísticas
		jplVentanaEstadisticas = new JPanel();
		jplVentanaEstadisticas.setBounds(0,0,1000,675); //Da un tamaño a la ventana
		jplVentanaEstadisticas.setLayout(null); //Quita la ubicación automática de los objetos del JPanel
		jplVentanaEstadisticas.setVisible(false); //Hace invisible el JPanel
		//Personalización de letras
		ComponentesPanelEstadisticas();  //Invoca al método que contiene las caracteristicas y objetos del JPanel*/
		//----------------------------------------------------------------------------------------------
		//Se agregan los JPaneles al JFrame
		add(jplVentanaPrincipal);
		add(jplVentanaInstrucciones);
		add(jplVentanaJugar1);
		add(jplVentanaJugarFacil);
		add(jplVentanaJugarNormal);
		add(jplVentanaJugarDificil);
		add(jplVentanaEstadisticas);
	}
	//Método que contiene las características gráficas y objetos del JPanel "jplVentanaPrincipal"
	private void ComponentesPanelPrincipal()
	{
		//Definición y construcción de objetos tipo ImageIcon
		ImageIcon PrincipalFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon PrincipalFondo2 = new ImageIcon("Imagenes/champions2.png");
		ImageIcon PrincipalTitulo1 = new ImageIcon("Imagenes/Titulo.png");
		ImageIcon PrincipalBotonJugar = new ImageIcon("Imagenes/jugarboton.png");
		ImageIcon PrincipalBotonSalir = new ImageIcon("Imagenes/salirboton.png");
		ImageIcon PrincipalBotonInstrucciones = new ImageIcon("Imagenes/instruccionesboton.png");
		//Definición y construcción de objetos tipo JLabel
		JLabel PrincipallblFondo1 = new JLabel(PrincipalFondo1);
		JLabel PrincipallblTitulo1 = new JLabel(PrincipalTitulo1);
		JLabel PrincipallblFondo2 = new JLabel(PrincipalFondo2);
		//Definición y construcción de objetos tipo JButton
		JButton PrincipalbtnJugar = new JButton(PrincipalBotonJugar);
		JButton PrincipalbtnInstrucciones = new JButton(PrincipalBotonInstrucciones);
		JButton PrincipalbtnSalir = new JButton(PrincipalBotonSalir);
		//Se agregan elementos al JPanel
		jplVentanaPrincipal.add(PrincipalbtnInstrucciones);
		jplVentanaPrincipal.add(PrincipalbtnJugar);
		jplVentanaPrincipal.add(PrincipalbtnSalir);
		jplVentanaPrincipal.add(PrincipallblTitulo1);
		jplVentanaPrincipal.add(PrincipallblFondo2);
		jplVentanaPrincipal.add(PrincipallblFondo1);
		//Se ubican y redimensionan las variables tipo objeto
		PrincipalbtnJugar.setBounds(500,300,393,82);
		PrincipallblTitulo1.setBounds(445,25,506,300);
		PrincipalbtnInstrucciones.setBounds(505,275,393,83);
		PrincipalbtnJugar.setBounds(505,375,393,83);
		//PrincipalbtnEstadisticas.setBounds(505,425,393,83);
		PrincipalbtnSalir.setBounds(505,475,393,83);
		PrincipallblFondo2.setBounds(0,0,550,650);
		PrincipallblFondo1.setBounds(0,0,1000,675);
		//Programación de los JButtons del JPanel
		//Programación del JButton "PrincipalbtnInstrucciones"
		PrincipalbtnInstrucciones.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaInstrucciones.setVisible(true);	
				jplVentanaPrincipal.setVisible(false);
			}
		});
		//Programación del JButton "PrincipalbtnJugar"
		PrincipalbtnJugar.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				NombreJugador = JOptionPane.showInputDialog(null,"¿Cúal es su nombre?"); //Lee el nombre del jugador
				if(NombreJugador != null) //Condicional para cuando el usurio digite su nombre
				{
					jplVentanaJugar1.setVisible(true);	
					jplVentanaPrincipal.setVisible(false);	
				}
			}
		});				
		//Programación del JButton "PrincipalbtnSalir"
		PrincipalbtnSalir.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Mata los procesos activos
				dispose(); //Destruye la ventana
			}
		});	
	}
	//Método que contiene las características gráficas y objetos del JPanel "jplVentanaInstrucciones"
	private void ComponentesPanelInstrucciones()
	{	
		ImageIcon InstruccionesBotonAtras = new ImageIcon("Imagenes/regresarboton.png");
		JButton InstruccionesbtnAtras = new JButton(InstruccionesBotonAtras);
		jplVentanaInstrucciones.add(InstruccionesbtnAtras);
		InstruccionesbtnAtras.setBounds(540,535,393,83);
		//Programación de los JButtons del JPanel
		InstruccionesbtnAtras.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaPrincipal.setVisible(true);
				jplVentanaInstrucciones.setVisible(false);
			}
		});
	}
	//Método que contiene las características gráficas y objetos del JPanel "jplVentanaJugar1"
	private void ComponentesPanelJugar1()
	{
		//Definición y construcción de objetos tipo ImageIcon
		ImageIcon JugarFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon JugarBorde1 = new ImageIcon("Imagenes/borde1.png");
		ImageIcon JugarBotonAtras1 = new ImageIcon("Imagenes/regresarboton.png");
		ImageIcon JugarTitulo1 = new ImageIcon("Imagenes/JugarTitulo1.png");
		ImageIcon JugarEstadisticas1 = new ImageIcon("Imagenes/estadisticasboton.png");
		ImageIcon JugarDificultadTexto1 = new ImageIcon("Imagenes/dificultadtexto.png");
		ImageIcon JugarDificultadFacil1 = new ImageIcon("Imagenes/dificultadfacilboton.png");
		ImageIcon JugarDificultadNormal1 = new ImageIcon("Imagenes/dificultadnormalboton.png");
		ImageIcon JugarDificultadDificil1 = new ImageIcon("Imagenes/difultaddificilboton.png");
		ImageIcon JugarDificultadAleatoria1 = new ImageIcon("Imagenes/dificultadaleatoriaboton.png");
		//Definición y construcción de objetos tipo JButton
		JButton JugarbtnFacil1 = new JButton(JugarDificultadFacil1);
		JButton JugarbtnNormal1 = new JButton(JugarDificultadNormal1);
		JButton JugarbtnDificil1 = new JButton(JugarDificultadDificil1);
		JButton JugarbtnAleatoria1 = new JButton(JugarDificultadAleatoria1);
		JButton JugarbtnEstadisticas1 = new JButton(JugarEstadisticas1);
		JButton JugarbtnAtras1 = new JButton(JugarBotonAtras1);
		//Definición y construcción de objetos tipo JLabel
		JLabel JugarlblFondo1 = new JLabel(JugarFondo1);
		JLabel JugarlblBorde1 = new JLabel(JugarBorde1);
		JLabel JugarlblTitulo1 = new JLabel(JugarTitulo1);
		JLabel JugarlblDificultadTexto1 = new JLabel(JugarDificultadTexto1);
		//Se agregan elementos al JPanel
		jplVentanaJugar1.add(JugarbtnFacil1);
		jplVentanaJugar1.add(JugarbtnNormal1);
		jplVentanaJugar1.add(JugarbtnDificil1);
		jplVentanaJugar1.add(JugarbtnAleatoria1);
		jplVentanaJugar1.add(JugarbtnEstadisticas1);
		jplVentanaJugar1.add(JugarbtnAtras1);
		jplVentanaJugar1.add(JugarlblDificultadTexto1);
		jplVentanaJugar1.add(JugarlblTitulo1);
		jplVentanaJugar1.add(JugarlblBorde1);
		jplVentanaJugar1.add(JugarlblFondo1);
		//Se ubican y redimensionan las variables tipo objeto
		JugarbtnFacil1.setBounds(120,250,370,83);
		JugarbtnNormal1.setBounds(500,250,370,83);
		JugarbtnAleatoria1.setBounds(500,350,370,83);
		JugarbtnDificil1.setBounds(120,350,370,83);
		JugarbtnEstadisticas1.setBounds(120,450,370,83);
		JugarbtnAtras1.setBounds(500,450,370,83);
		JugarlblBorde1.setBounds(60,30,14,75);
		JugarlblDificultadTexto1.setBounds(0,150,448,96);
		JugarlblTitulo1.setBounds(100,20,448,96);
		JugarlblFondo1.setBounds(0,0,1000,675);
		//Programación de los JButtons del JPanel
		//Programación del JButton "JugarbtnFacil1"
		JugarbtnFacil1.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaJugar1.setVisible(false);
				jplVentanaJugarFacil.setVisible(true);
				partidasJugadas++;
			}
		});
		//Programación del JButton "JugarbtnNormal1"
		JugarbtnNormal1.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaJugar1.setVisible(false);
				jplVentanaJugarNormal.setVisible(true);
				partidasJugadas++;
			}
		});
		//Programación del JButton "JugarbtnDificil1"
		JugarbtnDificil1.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaJugar1.setVisible(false);
				jplVentanaJugarDificil.setVisible(true);
				partidasJugadas++;
			}
		});
		//Programación del JButton "JugarbtnAleatoria1"
		JugarbtnAleatoria1.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaJugar1.setVisible(false);
				switch(ModoRandom())
				{
					case 0:	jplVentanaJugarFacil.setVisible(true);	 break;
					case 1:	jplVentanaJugarNormal.setVisible(true);	 break;
					case 2:	jplVentanaJugarDificil.setVisible(true); break;
				}
				partidasJugadas++;
			}
		});
		//Programación del JButton "JugarbtnEstadisticas1"
		JugarbtnEstadisticas1.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaJugar1.setVisible(false);
				jplVentanaEstadisticas.setVisible(true);
				InicializacionaValoresEstadisticos();
			}
		});
		//Programación del JButton "JugarbtnAtras1"
		JugarbtnAtras1.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				confirm1 = JOptionPane.showConfirmDialog(null,
				"¿Estás seguro de volver al menú principal?, tus estadísticas se borraran");
				if(confirm1 == JOptionPane.OK_OPTION)
				{
					//Reinicia todos los contadores y acumuladores de estadísticas
					partidasJugadas = 0;
					partidasGanadas = 0;
					partidasPerdidas = 0;
					puntosHechosFacil = 0;
					puntosHechosNormal = 0;
					puntosHechosDificil = 0;
					intentosPerdidosFacil = 0;
					intentosPerdidosNormal = 0;
					intentosPerdidosDificil = 0;
					intentosPerdidos = 0;
					puntosHechos = 0; 
					intentosPerdidos = 0;
					parejasFormadas = 0; 
					parejasFormadasFacil = 0;
					parejasFormadasNormal = 0;
					parejasFormadasDificil = 0;
					parejasRestaFacil = 0;
					parejasRestaNormal = 0;
					parejasRestaDificil = 0;
					jplVentanaJugar1.setVisible(false);
					jplVentanaPrincipal.setVisible(true);	
				}
			}
		});
	}
	
	//Método que contiene los objetos del JPanel "jplVentanaEstadisticas" para el despliegue de estadísticas
	private void InicializacionaValoresEstadisticos()
	{
		puntosHechos = puntosHechosFacil + puntosHechosNormal + puntosHechosDificil;
		intentosPerdidos = intentosPerdidosFacil + intentosPerdidosNormal + intentosPerdidosDificil;
		parejasFormadas = parejasFormadasFacil + parejasFormadasNormal + parejasFormadasDificil;
		//Personalización de JLabels
		EstadisticaslblNombrejugador.setFont(Letra1);
		EstadisticaslblParejasFormadas.setFont(Letra1);
		EstadisticaslblIntentosPerdidos.setFont(Letra1);
		EstadisticaslblPuntosHechos.setFont(Letra1);
		EstadisticaslblPartidasjugadas.setFont(Letra1);
		EstadisticaslblPartidasganadas.setFont(Letra1);
		EstadisticaslblPartidasperdidas.setFont(Letra1);
		EstadisticaslblNombrejugador.setForeground(Color.white);
		EstadisticaslblParejasFormadas.setForeground(Color.white);
		EstadisticaslblIntentosPerdidos.setForeground(Color.white);
		EstadisticaslblPuntosHechos.setForeground(Color.white);
		EstadisticaslblPartidasjugadas.setForeground(Color.white);
		EstadisticaslblPartidasganadas.setForeground(Color.white);
		EstadisticaslblPartidasperdidas.setForeground(Color.white);
		//Asignación de valores a los JLabels
		EstadisticaslblNombrejugador.setText(""+NombreJugador);
		EstadisticaslblParejasFormadas.setText(""+parejasFormadas);
		EstadisticaslblIntentosPerdidos.setText(""+intentosPerdidos);
		EstadisticaslblPuntosHechos.setText(""+puntosHechos);
		EstadisticaslblPartidasjugadas.setText(""+partidasJugadas);
		EstadisticaslblPartidasganadas.setText(""+partidasGanadas);
		EstadisticaslblPartidasperdidas.setText(""+partidasPerdidas);
	}
	//Método que contiene las características gráficas y objetos del JPanel "jplVentanaEstadisticas"
	private void ComponentesPanelEstadisticas()
	{
		InicializacionaValoresEstadisticos();
		ImageIcon EstadisticasFondo1 = new ImageIcon("Imagenes/champions1.jpg");
		ImageIcon EstadisticasPanel = new ImageIcon("Imagenes/panelestadisticas.png");
		ImageIcon EstadisticasBorde = new ImageIcon("Imagenes/borde1.png");
		ImageIcon EstadisticasTitulo = new ImageIcon("Imagenes/EstadisticasTitulo.png");
		ImageIcon EstadisticasBotonAtras = new ImageIcon("Imagenes/regresarboton2.png");
		//Definición y construcción de objetos tipo JButton
		JButton EstadisticasbtnAtras = new JButton(EstadisticasBotonAtras);
		//Definición y construcción de objetos tipo JLabel
		JLabel EstadisticaslblFondo1 = new JLabel(EstadisticasFondo1);
		JLabel EstadisticaslblTitulo = new JLabel(EstadisticasTitulo);
		JLabel EstadisticaslblBorde = new JLabel(EstadisticasBorde);
		JLabel EstadisticaslblPanel = new JLabel(EstadisticasPanel);
		//Se agregan elementos al JPanel
		jplVentanaEstadisticas.add(EstadisticaslblNombrejugador);
		jplVentanaEstadisticas.add(EstadisticaslblPuntosHechos);
		jplVentanaEstadisticas.add(EstadisticaslblIntentosPerdidos);
		jplVentanaEstadisticas.add(EstadisticaslblParejasFormadas);
		jplVentanaEstadisticas.add(EstadisticaslblPartidasjugadas);
		jplVentanaEstadisticas.add(EstadisticaslblPartidasganadas);
		jplVentanaEstadisticas.add(EstadisticaslblPartidasperdidas);
		jplVentanaEstadisticas.add(EstadisticasbtnAtras);
		jplVentanaEstadisticas.add(EstadisticaslblTitulo);
		jplVentanaEstadisticas.add(EstadisticaslblPanel);
		jplVentanaEstadisticas.add(EstadisticaslblBorde);
		jplVentanaEstadisticas.add(EstadisticaslblFondo1);
		//Se ubican y redimensionan las variables tipo objeto
		EstadisticasbtnAtras.setBounds(655,555,285,63);
		EstadisticaslblBorde.setBounds(60,30,14,75);
		EstadisticaslblTitulo.setBounds(40,20,448,96);
		EstadisticaslblNombrejugador.setBounds(540,150,300,50);
		EstadisticaslblPuntosHechos.setBounds(820,245,300,50);
		EstadisticaslblIntentosPerdidos.setBounds(840,353,300,50);
		EstadisticaslblParejasFormadas.setBounds(840,460,300,50);
		EstadisticaslblPartidasjugadas.setBounds(400,245,300,50);
		EstadisticaslblPartidasganadas.setBounds(400,353,300,50);
		EstadisticaslblPartidasperdidas.setBounds(410,460,300,50);
		EstadisticaslblPanel.setBounds(60,140,885,394);
		EstadisticaslblFondo1.setBounds(0,0,1000,675);
		
		EstadisticasbtnAtras.addActionListener(new ActionListener() //Se crea y se agrega el ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				jplVentanaEstadisticas.setVisible(false);
				jplVentanaJugar1.setVisible(true);
			}
		});
	}
	
	//Método perteneciente a “MouseListener” que controla cuando el mouse da un clic sobre algún objeto
	@Override
    public void mouseClicked(MouseEvent e) 
    { 
    	//-------------------------------------------------------------------------------------------------------------------
    	//Modo de Juego Facil
    	//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesFacil.length; i++)
		{
			if(e.getSource() == ArreglodeImagenesFacil[i] && VerificaParejasEncontradasFacil(i))
			{
				ArregloControlClicksFacil[i]++; //Incrementa en la posición seleccionada
				if(ArregloControlClicksFacil[i] < 2) //Valida que solo cuente un clicck por cada JLabel seleccionado
				{
					ClicksConteoFacil++; //Cuenta los clicks del mouse
					ArreglodeImagenesFacil[i].setIcon(new ImageIcon(getClass().
					getResource("Imagenes/"+ArregloNumeroImagenesFacil[i]+".png"))); //Voltea la carta	
					if(ClicksConteoFacil == 1)
					{
						FacilEntrada1 = i; //Se le asigna el valor de esa posición seleccionada en el arreglo
					}
					else
					{
						FacilEntrada2 = i; //Se le asigna el valor de esa posición seleccionada en el arreglo
					}	
				}
			}
		}
		//-------------------------------------------------------------------------------------------------------------------
		//Modo de juego Normal
    	//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesNormal.length; i++)
		{
			if(e.getSource() == ArreglodeImagenesNormal[i] && VerificaParejasEncontradasNormal(i))
			{
				ArregloControlClicksNormal[i]++; //Incrementa en la posición seleccionada
				if(ArregloControlClicksNormal[i] < 2) //Valida que solo cuente un clicck por cada JLabel seleccionado
				{
					ClicksConteoNormal++; //Cuenta los clicks del mouse
					ArreglodeImagenesNormal[i].setIcon(new ImageIcon(getClass().
					getResource("Imagenes/"+ArregloNumeroImagenesNormal[i]+".png"))); //Voltea la carta	
					if(ClicksConteoNormal == 1)
					{
						NormalEntrada1 = i; //Se le asigna el valor de esa posición seleccionada en el arreglo
					}
					else
					{
						NormalEntrada2 = i; //Se le asigna el valor de esa posición seleccionada en el arreglo
					}	
				}
			}
		}
		//-------------------------------------------------------------------------------------------------------------------
		//Modo de juego dificil
    	//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesDificil.length; i++)
		{
			if(e.getSource() == ArreglodeImagenesDificil[i] && VerificaParejasEncontradasDificil(i))
			{
				ArregloControlClicksDificil[i]++; //Incrementa en la posición seleccionada
				if(ArregloControlClicksDificil[i] < 2) //Valida que solo cuente un clicck por cada JLabel seleccionado
				{
					ClicksConteoDificil++; //Cuenta los clicks del mouse
					ArreglodeImagenesDificil[i].setIcon(new ImageIcon(getClass().
					getResource("Imagenes/"+ArregloNumeroImagenesDificil[i]+".png"))); //Voltea la carta	
					if(ClicksConteoDificil == 1)
					{
						DificilEntrada1 = i; //Se le asigna el valor de esa posición seleccionada en el arreglo
					}
					else
					{
						DificilEntrada2 = i; //Se le asigna el valor de esa posición seleccionada en el arreglo
					}	
				}
			}
		}
    }	
    	
   //Procedimiento perteneciente a “MouseListener” que controla cuando el cursor sale de los márgenes de un objeto.
   @Override
    public void mouseExited(MouseEvent e) 
    { 
    	//-------------------------------------------------------------------------------------------------------------------
    	//Modo de juego Facil
    	
    	//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesFacil.length; i++)
		{
			//Condicional si el usuario le dio click a alguna carta y esta no ha sido en parejada en ese momento
			if(e.getSource() == ArreglodeImagenesFacil[i]) 
			{
				if(ClicksConteoFacil == 2) //Condicional si el usurio le dio click a dos cartas
				{
					ValidarParejasFacil(FacilEntrada1,FacilEntrada2); //Método que valida el arreglo
					ClicksConteoFacil = 0; //Se reinicia el conteo de clicks
				}
			}
		}
		if(PuntajeFacil == 50 && IntentosFacil > 0) //Si el usuario gana
		{
			JOptionPane.showMessageDialog(null,"¡"+NombreJugador+" eres un crack "+", pudiste con el nivel fácil!",
			"Ganaste",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/exito.png"));
			InicializarArreglosFacil();
			partidasGanadas++;
    		IntentosFacil = 6;
    		intentosRestaFacil = 0;
    		parejasRestaFacil = 0;
    		PuntajeFacil = 0;
    		ClicksConteoFacil = 0;
    		FacilEntrada1 = 0;
    		FacilEntrada2 = 0;
    		JugarFacilPuntos.setText("0");
    		JugarFacilIntentos.setText("6");
    		jplVentanaJugarFacil.setVisible(false);
    		jplVentanaJugar1.setVisible(true);
		}
		//-------------------------------------------------------------------------------------------------------------------
		//Modo de juego Normal
		
		//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesNormal.length; i++)
		{
			//Condicional si el usuario le dio click a alguna carta y esta no ha sido en parejada en ese momento
			if(e.getSource() == ArreglodeImagenesNormal[i]) 
			{
				if(ClicksConteoNormal == 2) //Condicional si el usurio le dio click a dos cartas
				{
					ValidarParejasNormal(NormalEntrada1,NormalEntrada2); //Método que valida el arreglo
					ClicksConteoNormal = 0; //Se reinicia el conteo de clicks
				}
			}
		}
		if(PuntajeNormal == 70 && IntentosNormal > 0) //Si el usuario gana
		{
			JOptionPane.showMessageDialog(null,"¡Bien hecho "+NombreJugador+", pudiste con el nivel normal!",
			"Ganaste",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/exito.png"));
			InicializarArreglosNormal();
			partidasGanadas++;
    		IntentosNormal = 8;
    		PuntajeNormal = 0;
    		intentosRestaNormal = 0;
    		parejasRestaNormal = 0;
    		ClicksConteoNormal = 0;
    		NormalEntrada1 = 0;
    		NormalEntrada2 = 0;
    		JugarNormalPuntos.setText("0");
    		JugarNormalIntentos.setText("8");
    		jplVentanaJugarNormal.setVisible(false);
    		jplVentanaJugar1.setVisible(true);
		}
		//-------------------------------------------------------------------------------------------------------------------
		//Modo de juego Dificil
		//Ciclo que recorre el arreglo de imagenes
		for (int i = 0; i < ArreglodeImagenesDificil.length; i++)
		{
			//Condicional si el usuario le dio click a alguna carta y esta no ha sido en parejada en ese momento
			if(e.getSource() == ArreglodeImagenesDificil[i]) 
			{
				if(ClicksConteoDificil == 2) //Condicional si el usurio le dio click a dos cartas
				{
					ValidarParejasDificil(DificilEntrada1,DificilEntrada2); //Método que valida el arreglo
					ClicksConteoDificil = 0; //Se reinicia el conteo de clicks
				}
			}
		}
		if(PuntajeDificil == 90 && IntentosDificil > 0) //Si el usurio gana
		{
			JOptionPane.showMessageDialog(null,"¡Wow "+NombreJugador +", legal que sos el mejor GANASTE EL NIVEL MÁS DIFICIL!",
			"Ganaste",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Imagenes/exito.png"));
			InicializarArreglosDificil();
			partidasGanadas++;
    		IntentosDificil = 9;
    		intentosRestaDificil = 0;
    		parejasRestaDificil = 0;
    		PuntajeDificil = 0;
    		ClicksConteoDificil = 0;
    		DificilEntrada1 = 0;
    		DificilEntrada2 = 0;
    		JugarDificilPuntos.setText("0");
    		JugarDificilIntentos.setText("9");
    		jplVentanaJugarDificil.setVisible(false);
    		jplVentanaJugar1.setVisible(true);
		}
    }	
    
    //Propiedades del "MouseListener" no utilizadas pero que tienen que estar presentes dentro del código
    @Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent arg0) { }

	@Override
	public void mouseReleased(MouseEvent arg0) { }
	
    //Método Main
    public static void main(String[] args) 
    {
    	Proyecto1 VentanaPrincipal = new Proyecto1(); //Se crea una instancia de la clase "Proyecto1"
    }
}
