import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// Autor: Benjamin Decker
// Datum: 4.2.2021
// ----------------------------------------------------------------Das Hier ist unwichtig (fürs erste); Wichtig wird es erst ab Zeile 70-------------------
public class SquarerV2 extends JFrame {
  // Anfang Attribute
  private JNumberField jNumberField1 = new JNumberField();
  private JNumberField jNumberField2 = new JNumberField();
  private JButton jButton1 = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JComboBox jComboBox1 = new JComboBox();
    private DefaultComboBoxModel jComboBox1Model = new DefaultComboBoxModel();
  // Ende Attribute
  
  public SquarerV2(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 110;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jNumberField1.setBounds(8, 8, 73, 25);                                 
    jNumberField1.setText("");
    jNumberField1.setToolTipText("Zahl");
    cp.add(jNumberField1);
    
    jNumberField2.setBounds(88, 8, 73, 25);
    jNumberField2.setText("");                                              //-----------------Zeile 70!! Nicht hier!-----------------
    jNumberField2.setToolTipText("Maximum");
    cp.add(jNumberField2);
    
    jButton1.setBounds(8, 40, 153, 25);
    jButton1.setText("L   O   S");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    
    jLabel1.setBounds(168, 40, 107, 25);
    jLabel1.setText("text");
    cp.add(jLabel1);
    
    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(168, 8, 105, 25);
    jComboBox1.addItem("Maximum");
    jComboBox1.addItem("Quersumme");
    cp.add(jComboBox1);
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public SquarerV2
  // --------------------------------------------------------------- Ab Hier beginnt das Interessante -----------------------------------------------
  // Meine Variablen
  double max, input, sum;
  // Anfang Methoden
  
  public static void main(String[] args) {
    new SquarerV2("SquarerV2");    //Erstelle Das Fenster
  } // end of main
  
  public void jButton1_ActionPerformed(ActionEvent evt) {     //Dies Hier führt der Knopf aus
    input = Integer.parseInt(jNumberField1.getText()); //Hohle den Wert aus der ersten Textbox
    max = Integer.parseInt(jNumberField2.getText());   //Hohle den Wert aus der zweiten Textbox
    if (jComboBox1.getSelectedItem() == "Maximum") {  //Was ist in dem DropDown Menu gewählt?
      Max();      //Führe Zeilen 88-94 aus
    } else {
      Quer();     //Führe Zeilen 96-103 aus
    } // end of if-else
  } // end of jButton1_ActionPerformed         //Ende des Knopfes
  
  public void Max() {
    while (input < max) { 
      input = input*2;
      System.out.println("Max "+input); //Wert wird als Test (und zur kontrolle) ausgegeben und ist nur im Java Editor einzusehen
    } // end of while
    jLabel1.setText(input+"");   //Zeige den wert im Programm an
  } //Ende von Max
  
  public void Quer() {
    while (sum < max) { 
      sum=sum+input;
      input=input*2;
      System.out.println("Quer "+input+" "+sum);   //Wert wird als Test (und zur kontrolle) ausgegeben und ist nur im Java Editor einzusehen
    } // end of while
    jLabel1.setText(sum+"");   //Zeige den wert im Programm an
  } //Ende von Quer
  
  // Ende Methoden
} // end of class SquarerV2
