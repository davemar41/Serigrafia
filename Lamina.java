import java.awt.Container;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.w3c.dom.ls.LSOutput;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lamina extends JPanel {
    private JLabel cliente;
    private JTextField cliente2;
    private JLabel tipodeproducto;
    private JTextField referencias2;
    private JLabel cantidad;
    private JTextField cantidad2;
    private JPanel mipanel1;
    private JPanel mipanel2;
    private JPanel mipanel3;
    private JPanel misubpanel1;
    private JPanel misubpanel2;
    private JPanel misubpanel3;
    private JPanel misubpanel4;
    private JPanel misubpanel5;
    private JPanel misubpanel6;
    private JPanel misubpanel7;
    private JLabel resultado;
    private JTextField resultado2;
    private JRadioButton opcion1;
    private JRadioButton opcion2;
    private JRadioButton opcion3;
    private JRadioButton opcion4;
    private JRadioButton opcion5;
    private JRadioButton opcion6;
    private JRadioButton opcion7;
    private JComboBox posiciones;
    private ButtonGroup migrupo;
    private JComboBox otrocombo;
    private JTextArea presentacion;
    private JLabel logo;
    private JButton presentar;
    private JButton reset;
    private JButton guardar;
    private int kantidad;
    private Double prezio;
    private Double prezioposicion;
    private Double preziocolor;
    private Double rresult;
    private Double rresult2;
    private int contador=0;
    private String texto;
    private FileWriter archivo;
    private Image imagen;
    private URL fondo;
    private String nada="0";
    private String nadatex="";
    private Color colorpanel1 = new Color(235, 251, 244);
    private JCheckBox micheck1;
    private JCheckBox micheck2;
    JTextField textopecho;
    JTextField textoespalda;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        File mimagen=new File("D:/descargas/putologo2.png");
        try {
            imagen=ImageIO.read(mimagen);
        } catch (IOException e) {
            System.out.println("imagen no encrontrada");
        }
        g.drawImage(imagen,5,400,null);
        setOpaque(false);
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return  texto ;

    }

    public int getKantidad() {
        return kantidad;
    }

    public void setKantidad(int kantidad) {
        this.kantidad = kantidad;
    }

    public Double getPrezio() {
        return prezio;
    }

    public void setPrezio(Double prezio) {
        this.prezio = prezio;
    }

    public Double getRresult() {
        return rresult;
    }

    public void setRresult(Double rresult) {
        this.rresult = rresult;
    }

    public Double getRresult2() {
        return rresult2;
    }

    public void setRresult2(Double rresult2) {
        this.rresult2 = rresult2;
    }

    public Lamina() {
        setLayout(new BorderLayout());
        mipanel1 = new JPanel(new GridLayout(2, 7));
        mipanel2 = new JPanel(new BorderLayout());
        mipanel3 = new JPanel(new BorderLayout());
        misubpanel1 = new JPanel();
        misubpanel2 = new JPanel();
        misubpanel3 = new JPanel();
        misubpanel4 = new JPanel();
        misubpanel5 = new JPanel(new GridLayout(1,2));
        misubpanel6 = new JPanel();
        EventoRadio mievento=new EventoRadio();
        cliente = new JLabel("            cliente");
        cliente2 = new JTextField(20);
        cantidad = new JLabel("           cantidad");
        cantidad2 = new JTextField(10);
        tipodeproducto = new JLabel("            producto");
        referencias2 = new JTextField(20);

        mipanel1.add(cliente);
        mipanel1.add(cliente2);
        mipanel1.add(cantidad);
        mipanel1.add(cantidad2);
        mipanel1.add(tipodeproducto);
        mipanel1.add(referencias2);
        add(mipanel1, BorderLayout.NORTH);
        mipanel1.setBackground(colorpanel1);
        //panel2 botones norte combos y resultado
        migrupo = new ButtonGroup();
        opcion1 = new JRadioButton("categoria1", false);
        opcion2 = new JRadioButton("categoria2", false);
        opcion3 = new JRadioButton("categoria3", false);
        opcion4 = new JRadioButton("categoria4", false);
        opcion5 = new JRadioButton("categoria5", false);
        opcion6 = new JRadioButton("categoria6", false);
        opcion7 = new JRadioButton("moleskines",false);
        logo=new JLabel(new ImageIcon("D/descargas/putologo2.png"));
        //logo.setIcon(new ImageIcon("D/descargas/putologo2.png"));
        migrupo.add(opcion1);
        migrupo.add(opcion2);
        migrupo.add(opcion3);
        migrupo.add(opcion4);
        migrupo.add(opcion5);
        migrupo.add(opcion6);
        migrupo.add(opcion7);
        mipanel1.add(logo,BorderLayout.NORTH);
        mipanel1.add(opcion1, BorderLayout.NORTH);
        mipanel1.add(opcion2, BorderLayout.NORTH);
        mipanel1.add(opcion3, BorderLayout.NORTH);
        mipanel1.add(opcion4, BorderLayout.NORTH);
        mipanel1.add(opcion5, BorderLayout.NORTH);
        mipanel1.add(opcion6, BorderLayout.NORTH);
        mipanel1.add(opcion7, BorderLayout.NORTH);
        add(mipanel2, BorderLayout.CENTER);
        opcion1.addActionListener(mievento);
        opcion2.addActionListener(mievento);
        opcion3.addActionListener(mievento);
        opcion4.addActionListener(mievento);
        opcion5.addActionListener(mievento);
        opcion6.addActionListener(mievento);
        opcion7.addActionListener(mievento);
        mipanel2.setBackground(colorpanel1);
        //COMBOS
        Eventoposiciones eventoposicion=new Eventoposiciones();
        posiciones = new JComboBox();
        posiciones.addItem("una pantalla");
        posiciones.addItem("dos pantallas");
        posiciones.addItem("tres pantallas");
        posiciones.addItem("cuatro pantallas");
        posiciones.addItem("cinco pantallas");
        posiciones.addItem("seis pantallas");
        posiciones.addItem("siete pantallas");
        posiciones.addItem("ocho pantallas");

        misubpanel1.add(posiciones);
        misubpanel1.setBackground(colorpanel1);
        mipanel2.add(misubpanel1, BorderLayout.WEST);
        mipanel2.setBackground(colorpanel1);
        //add(mipanel3, BorderLayout.SOUTH);
        posiciones.addActionListener(eventoposicion);
        Eventocolores eventocolor=new Eventocolores();
        otrocombo = new JComboBox();
        otrocombo.addItem("un color");
        otrocombo.addItem("dos colores");
        otrocombo.addItem("tres colores");
        otrocombo.addItem("cuatro colores");
        otrocombo.addItem("cinco colores");
        otrocombo.addItem("seis colores");
        otrocombo.addItem("siete colores");
        otrocombo.addItem("ocho colores");
        otrocombo.addActionListener(eventocolor);
        misubpanel2.add(otrocombo);
        misubpanel2.setBackground(colorpanel1);
        mipanel2.add(misubpanel2, BorderLayout.EAST);
        mipanel2.add(misubpanel3, BorderLayout.NORTH);
        resultado = new JLabel("resultado");
        resultado2 = new JTextField(20);
        misubpanel3.add(resultado);
        misubpanel3.add(resultado2);
        misubpanel3.setBackground(colorpanel1);

        //TEXTAREA Y DOS BOTONES
        Eventoguardar eventoguardo=new Eventoguardar();
        yoimprimo eventoimpresora=new yoimprimo();
        Present yopresento=new Present();
        presentar = new JButton("presentar");
        reset = new JButton("reset");
        guardar=new JButton("guardar");
        presentacion = new JTextArea(18, 35);
        presentacion.setLineWrap(true);
        presentacion.setEditable(true);


        Eventoreset eventreset=new Eventoreset();
        misubpanel4.add(presentacion);
        mipanel2.add(misubpanel4, BorderLayout.CENTER);
        misubpanel5=new JPanel();
        misubpanel6=new JPanel(new GridLayout(2,2));
        misubpanel5.add(presentar);
        misubpanel5.add(guardar);
        misubpanel5.add(reset);
        add(mipanel3, BorderLayout.SOUTH);
        misubpanel5.add(presentar);
        //misubpanel6.add(imprimir);
        mipanel3.add(misubpanel5,BorderLayout.SOUTH);
        mipanel3.add(misubpanel6,BorderLayout.NORTH);
        presentar.addActionListener(yopresento);
        //imprimir.addActionListener(eventoimpresora);
        reset.addActionListener(eventreset);
        guardar.addActionListener(eventoguardo);
        posiciones.setEnabled(false);
        //checkbox
        Checkmybox mieventocheck=new Checkmybox();
        textopecho=new JTextField(10);
        textoespalda=new JTextField(10);
        textopecho.setEnabled(false);
        textoespalda.setEnabled(false);
        micheck1=new JCheckBox(" pecho",false);
        micheck2=new JCheckBox("espalda",false);
        misubpanel6.add(micheck1);
        misubpanel6.add(textopecho);
        misubpanel6.add(micheck2);
        misubpanel6.add(textoespalda);
        micheck1.addActionListener(mieventocheck);
        micheck2.addActionListener(mieventocheck);

    }
    class EventoRadio implements ActionListener {
        //precios opcion1
        Double precio = 22.0;
        Double prezio;
        Double precio2 = 28.0;
        Double preciounitario = 0.06;
        Double preciounitario2 = 0.05;
        Double preciounitario3 = 0.04;
        Double preciounitario4 = 0.035;
        //precios opcion2
        Double precio3 = 24.0;
        Double preciounitdos = 0.10;
        Double preciounitdos2 =0.09;
        Double preciounitdos3 = 0.08;
        Double preciounitdos4 = 0.07;
        Double preciounitdos5=0.06;
        //precios opcion3
        Double precio4=25.0;
        Double preciounittres = 0.24;
        Double preciounittres2 =0.22;
        Double preciounittres3 = 0.20;
        Double preciounittres4 = 0.18;
        Double preciounittres5=0.16;
        //OPCION 4
        Double precio5=30.0;
        Double preciounitcuatro=0.28;
        Double preciounitcuatro2=0.27;
        Double preciounitcuatro3=0.26;
        Double preciounitcuatro4=0.25;
        Double preciounitcuatro5=0.24;
        //OPCION5
        Double precio6=24.0;
        Double preciounitcinco=0.22;
        Double preciounitcinco2=0.21;
        Double preciounitcinco3=0.18;
        Double preciounitcinco4=0.17;
        Double preciounitcinco5=0.12;
        //OPCION6
        Double precio7=25.0;
        Double preciounitseis=0.24;
        Double preciounitseis2=0.22;
        Double preciounitseis3=0.20;
        Double preciounitseis4=0.18;
        Double preciounitseis5=0.16;
        //opcion 7
        Double precio8=25.0;
        Double preciounitocho=0.18;
        Double preciounitocho2=0.18;
        Double preciounitocho3=0.16;
        Double preciounitocho4=0.14;
        Double preciounitocho5=0.12;
        Double preciounitocho6=0.10;
        @Override
        public void actionPerformed(ActionEvent e) {
            String micantidad = String.valueOf(cantidad2.getText());

            if (e.getSource() == opcion1) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);

                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.PINK);
                    CalculoRadio3(kantidad, precio, precio2, preciounitario, preciounitario2, preciounitario3,
                            preciounitario4, precio3, preciounitdos, preciounitdos2, preciounitdos3, preciounitdos4
                            , preciounitdos5, precio4, preciounittres, preciounittres2, preciounittres3, preciounittres4,
                            preciounittres5);

                }
            }
            if (e.getSource() == opcion2) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);
                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.ORANGE);
                    CalculoRadio3(kantidad, precio, precio2, preciounitario, preciounitario2, preciounitario3,
                            preciounitario4, precio3, preciounitdos, preciounitdos2, preciounitdos3, preciounitdos4
                            , preciounitdos5, precio4, preciounittres, preciounittres2, preciounittres3, preciounittres4,
                            preciounittres5);

                }

            }
            if (e.getSource() == opcion3) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);
                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.green);
                    CalculoRadio3(kantidad, precio, precio2, preciounitario, preciounitario2, preciounitario3,
                            preciounitario4, precio3, preciounitdos, preciounitdos2, preciounitdos3, preciounitdos4
                            , preciounitdos5, precio4, preciounittres, preciounittres2, preciounittres3, preciounittres4,
                            preciounittres5);

                }
            }
            if (e.getSource() == opcion4) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);
                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.red);
                    CalculoRadio4(kantidad, precio5, preciounitcuatro, preciounitcuatro2, preciounitcuatro3,
                            preciounitcuatro4, preciounitcuatro5, precio6, preciounitcinco, preciounitcinco2,
                            preciounitcinco3, preciounitcinco4, preciounitcinco5, precio7, preciounitseis,
                            preciounitseis2, preciounitseis3, preciounitseis4, preciounitseis5, precio8,
                            preciounitocho, preciounitocho3, preciounitocho4, preciounitocho5, preciounitocho6);

                }
            }
            if (e.getSource() == opcion5) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);
                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.black);
                    CalculoRadio4(kantidad, precio5, preciounitcuatro, preciounitcuatro2, preciounitcuatro3,
                            preciounitcuatro4, preciounitcuatro5, precio6, preciounitcinco, preciounitcinco2,
                            preciounitcinco3, preciounitcinco4, preciounitcinco5, precio7, preciounitseis,
                            preciounitseis2, preciounitseis3, preciounitseis4, preciounitseis5, precio8,
                            preciounitocho, preciounitocho3, preciounitocho4, preciounitocho5, preciounitocho6);

                }
            }
            if (e.getSource() == opcion6) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);
                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.BLUE);
                    CalculoRadio4(kantidad, precio5, preciounitcuatro, preciounitcuatro2, preciounitcuatro3,
                            preciounitcuatro4, preciounitcuatro5, precio6, preciounitcinco, preciounitcinco2,
                            preciounitcinco3, preciounitcinco4, preciounitcinco5, precio7, preciounitseis,
                            preciounitseis2, preciounitseis3, preciounitseis4, preciounitseis5, precio8,
                            preciounitocho, preciounitocho3, preciounitocho4, preciounitocho5, preciounitocho6);

                }
            }
            if (e.getSource() == opcion6) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);
                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.BLUE);
                    CalculoRadio4(kantidad, precio5, preciounitcuatro, preciounitcuatro2, preciounitcuatro3,
                            preciounitcuatro4, preciounitcuatro5, precio6, preciounitcinco, preciounitcinco2,
                            preciounitcinco3, preciounitcinco4, preciounitcinco5, precio7, preciounitseis,
                            preciounitseis2, preciounitseis3, preciounitseis4, preciounitseis5, precio8,
                            preciounitocho, preciounitocho3, preciounitocho4, preciounitocho5, preciounitocho6);

                }
            }
            if (e.getSource() == opcion7) {
                if (micantidad.isEmpty()) {
                    resultado2.setText(nada);
                } else {
                    kantidad = Integer.parseInt(micantidad);
                    mipanel1.setBackground(Color.GRAY);
                    CalculoRadio4(kantidad, precio5, preciounitcuatro, preciounitcuatro2, preciounitcuatro3,
                            preciounitcuatro4, preciounitcuatro5, precio6, preciounitcinco, preciounitcinco2,
                            preciounitcinco3, preciounitcinco4, preciounitcinco5, precio7, preciounitseis,
                            preciounitseis2, preciounitseis3, preciounitseis4, preciounitseis5, precio8,
                            preciounitocho, preciounitocho3, preciounitocho4, preciounitocho5, preciounitocho6);


                }
            }

    }public Double CalculoRadio3(int kantidad,Double precio,Double precio2
            ,Double preciounitario,Double preciounitario2,Double preciounitario3, Double preciounitario4,
                                 Double precio3,Double preciounitdos,Double preciounitdos2,Double preciounitdos3,
                                 Double preciounitdos4,Double preciounitdos5,Double precio4,
                                 Double preciounittres,
                                 Double preciounittres2,Double preciounittres3,Double preciounittres4,
                                 Double preciounittres5){
        if( opcion1.isSelected()){
            if(kantidad<=200){
                prezio=precio;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            }else if(kantidad<500){
                prezio=precio2;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            }else if(kantidad<1000){
                prezio=preciounitario*kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            }else if(kantidad<3000){
                prezio=preciounitario2*kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            }else if (kantidad<5000){
                prezio=preciounitario3*kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            }else if(kantidad>=5000){
                prezio=preciounitario4*kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);

            }

        }if( opcion2.isSelected()) {
            if (kantidad <= 200) {
                prezio = precio3;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 500) {
                prezio = preciounitdos*kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 1000) {
                prezio = preciounitdos2 * kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 3000) {
                prezio = preciounitdos3 * kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 5000) {
                prezio = preciounitdos4 * kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad >= 3001) {
                prezio = preciounitdos5 * kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);

            }
        }if( opcion3.isSelected()) {
            if (kantidad <= 100) {
                prezio = precio4;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 300) {
                prezio = preciounittres*kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 500) {
                prezio = preciounittres2* kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 1000) {
                prezio = preciounittres3 * kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad < 3000) {
                prezio = preciounittres4* kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);
            } else if (kantidad >= 3001) {
                prezio = preciounittres5 * kantidad;
                resultado2.setText(String.valueOf(prezio));
                setPrezio(prezio);

            }
        }
        return prezio;
    }public Double CalculoRadio4(int kantidad, Double precio5,Double preciounitcuatro,Double preciounitcuatro2,
                                 Double preciounitcuatro3,Double preciounitcuatro4,Double preciounitcuatro5,
                                 Double precio6, Double preciounitcinco, Double preciounitcinco2,
                                 Double preciounitcinco3, Double preciounitcinco4, Double preciounitcinco5,
                                 Double precio7,Double preciounitseis,Double preciounitseis2,Double preciounitseis3,
                                 Double preciounitseis4,Double preciounitseis5,Double precio8,Double preciounitocho,
                                 Double preciounitocho3,Double preciounitocho4,Double preciounitocho5,
                                 Double preciounitocho6) {
            if (opcion4.isSelected()) {
                if (kantidad <= 100) {
                    prezio = precio5;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 300) {
                    prezio = preciounitcuatro * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 500) {
                    prezio = preciounitcuatro2 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 1000) {
                    prezio = preciounitcuatro3 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 3000) {
                    prezio = preciounitcuatro4 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad >= 3001) {
                    prezio = preciounitcuatro5 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);

                }
            }
            if (opcion5.isSelected()) {
                if (kantidad <= 100) {
                    prezio = precio6;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 300) {
                    prezio = preciounitcinco * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 500) {
                    prezio = preciounitcinco2 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 1000) {
                    prezio = preciounitcinco3 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 5000) {
                    prezio = preciounitcinco4 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad >= 5001) {
                    prezio = preciounitcinco5 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);

                }
            }
            if (opcion6.isSelected()) {
                if (kantidad <= 100) {
                    prezio = precio7;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 300) {
                    prezio = preciounitseis * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 500) {
                    prezio = preciounitseis2 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 1000) {
                    prezio = preciounitseis3 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 5000) {
                    prezio = preciounitseis4 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad >= 5001) {
                    prezio = preciounitseis5 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);

                }

            }if (opcion7.isSelected()) {
                if (kantidad <= 100) {
                    prezio = precio8;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                    System.out.println(prezio);
                } else if (kantidad < 300) {
                    prezio = preciounitocho * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 500) {
                    prezio = preciounitocho3 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 1000) {
                    prezio = preciounitocho4 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad < 5000) {
                    prezio = preciounitocho5 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);
                } else if (kantidad >= 5001) {
                    prezio = preciounitocho6 * kantidad;
                    resultado2.setText(String.valueOf(prezio));
                    setPrezio(prezio);

                }
            }

            return prezio;
        }
    }class Eventoposiciones implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            prezio = getPrezio();



            Calculoposicion(rresult, prezio);


        }

    }

    public Double Calculoposicion(Double rresult, Double prezio) {
        if(opcion1.isSelected()||opcion2.isSelected()){
            prezioposicion=22.0;


        }if(opcion3.isSelected()||opcion4.isSelected()||opcion5.isSelected()||opcion6.isSelected()||opcion7.isSelected())
            prezioposicion=25.00;
        if (posiciones.getSelectedItem() == "una pantalla") {

            rresult=rresult2+prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);



        } else if (posiciones.getSelectedItem() == "dos pantallas") {
            prezioposicion=prezioposicion*2;
            rresult = rresult2 +prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);

        } else if (posiciones.getSelectedItem() == "tres pantallas") {
            prezioposicion=prezioposicion*3;
            rresult= rresult2 +prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);
        } else if (posiciones.getSelectedItem() == "cuatro pantallas") {
            prezioposicion=prezioposicion*4;
            rresult = rresult2 +prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);
        }else if (posiciones.getSelectedItem() == "cinco pantallas") {
            prezioposicion = prezioposicion * 5;
            rresult = rresult2 + prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);
        }else if (posiciones.getSelectedItem() == "seis pantallas") {
            prezioposicion = prezioposicion * 6;
            rresult = rresult2 + prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);
        }else if (posiciones.getSelectedItem() == "siete pantallas") {
            prezioposicion = prezioposicion * 7;
            rresult = rresult2 + prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);
        }   else if (posiciones.getSelectedItem() == "ocho pantallas") {
            prezioposicion = prezioposicion * 8;
            rresult = rresult2 + prezioposicion;
            resultado2.setText(String.valueOf(rresult));
            setRresult(rresult);
        }
        return rresult;
    }class Eventocolores implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            rresult=getRresult();
            prezio=getPrezio();
            CalculoColores(rresult,prezio);



        }
    }public Double CalculoColores(Double rresult,Double prezio) {
        if (otrocombo.getSelectedItem() == "un color") {
            rresult2 = prezio * 1;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        } else if (otrocombo.getSelectedItem() == "dos colores") {
            rresult2 = prezio * 2;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        } else if (otrocombo.getSelectedItem() == "tres colores") {
            rresult2 = prezio * 3;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        } else if (otrocombo.getSelectedItem() == "cuatro colores") {
            rresult2 = prezio * 4;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        } else if (otrocombo.getSelectedItem() == "cinco colores") {
            rresult2 = prezio * 5;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        }else if (otrocombo.getSelectedItem() == "seis colores") {
            rresult2 = prezio * 6;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        }else if (otrocombo.getSelectedItem() == "siete colores") {
            rresult2 = prezio * 7;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        }else if (otrocombo.getSelectedItem() == "ocho colores") {
            rresult2 = prezio * 8;
            resultado2.setText(String.valueOf(rresult2));
            posiciones.setEnabled(true);
            setRresult2(rresult2);
        }
            return rresult2;

    }public class Present implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            contador=contador+1;
            presentacion.setText("JS SERRIGRAFÍA     CIF  presupuesto numero "  + contador +"\n"+
                    " Realizado para la empresa :" +cliente2.getText()+
                    "                                                        "+"\n"+
                    "                                                        "+"\r"+
                    "                                                                      "+"\r"+
                    "CANTIDAD                         "+cantidad2.getText() +"\n"+
                    "                                                        "+"\n"+
                    "PRODUCTO                     "+referencias2.getText()+  "\n"+
                    "                                                         "+"\n"+
                    "PANTALLAS                   "+posiciones.getSelectedItem()+"\n"+
                    "PECHO                           "+micheck1.isSelected()+"\n"+
                    textopecho.getText()+"\n"+
                    "ESPALDA                         "+micheck2.isSelected()+"\n"+
                    textoespalda.getText()+"\n"+
                    "                                                         "+"\n"+
                    "COLORES                       "+otrocombo.getSelectedItem()+"\n"+
                    "                                                         "+"\n"+
                    "PRECIO TOTAL               "+resultado2.getText()+"\n"+
                    "SIN IVA                                           "+"\n"+
                    "                                                         ");

            texto=String.valueOf(presentacion.getText());

            setTexto(texto);

        }

    }class yoimprimo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {


            String imprimo = String.valueOf(presentacion.getText().replaceAll("\n","\r\n"));
            impresora imp=new impresora();


            imp.imprimir(imprimo);
            System.out.println(getTexto());




        }


    }class impresora{
        Font fuente=new Font("DIALOG",Font.PLAIN,13);
        PrintJob pj;
        Graphics pagina;
        impresora() {
            pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "scat", null);
        }public void imprimir(String imprimer) {
            pagina=pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.BLACK);
            pagina.drawString(imprimer,10,10);
            pagina.dispose();
            pj.end();
        }
    }





    class Eventoguardar extends Component implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Date objdate=new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String texto2=presentacion.getText();
                    String texto3=presentacion.getText();
            try {
                FileOutputStream mipdf=new FileOutputStream("C:\\presupuestos\\presupuesto"+cliente2.getText()
                        +referencias2.getText()+".pdf");
                Document doc=new Document();
                PdfWriter.getInstance(doc,mipdf);
                doc.open();
                doc.add(new Paragraph(texto3));
                doc.close();
            } catch (FileNotFoundException | DocumentException ex) {
                ex.printStackTrace();
            }


        }
    }class Eventoreset implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            cantidad2.setText(nada);

            cliente2.setText(nadatex);
            referencias2.setText(nadatex);
            presentacion.setText(nadatex);
            otrocombo.setSelectedItem("un color");
            posiciones.setEnabled(false);
            resultado2.setText(nada);
            migrupo.clearSelection();
            mipanel1.setBackground(colorpanel1);
            micheck1.setSelected(false);
            micheck2.setSelected(false);
            textopecho.setText(nadatex);
            textoespalda.setText(nadatex);
            textopecho.setEnabled(false);
            textoespalda.setEnabled(false);

        }
    }class Checkmybox implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(micheck1.isSelected()){
                textopecho.setEnabled(true);
            }
            if(micheck2.isSelected()){
                textoespalda.setEnabled(true);
            }
        }
    }
}
