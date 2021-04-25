import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
//import org.graalvm.compiler.lir.CompositeValue.Component;
import org.w3c.dom.events.MouseEvent;
  
  import javax.swing.ImageIcon;
  
  import java.awt.event.*;
  import java.awt.image.BufferedImage;
  import java.io.File;
  import java.io.IOException;
  import java.util.logging.Level;
  import java.util.logging.Logger;
  import javax.imageio.ImageIO;
  
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import javax.swing.BorderFactory;
  import javax.swing.JButton;
  import javax.swing.JLabel;
  import java.awt.color.*;
  import java.awt.event.MouseListener;
  import javax.swing.JPanel; // Creates panel to draw figures.
import javax.swing.JFrame; // Creates window to place panels.
import javax.swing.JLabel; // Creates mouse-action labels.
import javax.swing.JComponent; // Creates objects of JComponent type.
import javax.swing.BorderFactory; // Adds borders with titles to panels.
import java.awt.BorderLayout; // Sets position of panels in frames.
import java.awt.Color; // Paints panels and figures.
import java.awt.Dimension; // Sets object dimensions.
import java.awt.Font; // Sets properties for fonts.
import java.awt.Graphics; // Creates figures.
import java.awt.event.MouseListener; // Detects mouse actions performed.
//import java.awt.event.MouseEvent; // Indicates which actions to perform.
import java.util.Random; // Generates objects of Random type.
  

final public class Main implements MouseInputListener{
    int money = 1200;
    public static int happiness = 10;
    public static int Pollution = 10;
    public static int mx, my;

    
    public static int counter = 0;
    public static int smallHouse = 0;
    public static int ifRoad = 0;
  
   

    public static int tf = 1;

    JFrame frame;
    DrawPanel drawPanel;
    JButton low;
    JButton lowRes;
    JButton lowComm;

    JButton mid;
    JButton midRes;
    JButton midComm;

    JButton high;
    JButton highRes;
    JButton highComm;

    JButton services;
    JButton cityServices;
    JButton police;
    JButton fire;
    JButton energy;
    JButton windmillButton;
    JButton solarPanelButton;
    JButton nuclearPowerButton;
    JButton factory;
    JButton school;

    JButton close;

    boolean lowBool = false;
    boolean lowPurchaseBool = false;
    boolean midBool = false;
    boolean midPurchaseBool = false;
    boolean highBool = false;
    boolean highPurchaseBool = false;
    boolean servicesBool = false;
    boolean servicesPurchaseBool = false;
    boolean cityServiceBool = false;
    boolean policeBool = false;
    boolean fireBool = false;
    boolean energyBool = false;
    boolean windmill = false;
    boolean solarPanel = false;
    boolean nuclearPower = false;
    boolean factoryBool = false;
    boolean schoolBool = false;
    boolean resBool = false;
    boolean commBool = false;
    boolean landscapeBool = false;
    int count = 0;
    int opacity = 0;
    int infographic = 1;
    float opacityImg = 0.0f;
    
    ArrayList<Integer> xvalues = new ArrayList<Integer>();
    ArrayList<Integer> yvalues = new ArrayList<Integer>();
    ArrayList<Integer> width = new ArrayList<Integer>();
    ArrayList<Integer> height = new ArrayList<Integer>();
    ArrayList<Image> buildingImage = new ArrayList<Image>();
    public static void main(String... args) {
        new Main().go();
    }

    private void go() {
      
        Color lighterBlack = new Color(64, 64, 64);
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(875,800));
        frame.setBackground(Color.GREEN);
        frame.pack();
        drawPanel = new DrawPanel();
        //mouse listener
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
        
        //Adding the buttons for the menu
        lowRes = new JButton("");
        lowRes.setBounds(30,620,100,100);
        lowRes.setBackground(lighterBlack);
        lowRes.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                System.out.println("Low residential purchased");
                lowBool = false;
                lowPurchaseBool = true;
                smallHouse+=1;
                money-=400;
                midBool = false;
                commBool = false;
                resBool = true;
                count = 0;
                tf=0;
                frame.remove(lowRes);
                frame.remove(lowComm);
            } 
        } );
        lowComm = new JButton("");
        lowComm.setBounds(192,620,100,100);
        lowComm.setBackground(lighterBlack);
        lowComm.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                System.out.println("Low commercial purchased");
                lowBool = false;
                lowPurchaseBool = true;
                midBool = false;
                resBool = false;
                commBool = true;
                count = 0;
                tf=0;
                frame.remove(lowRes);
                frame.remove(lowComm);
            } 
        } );
        //Adding the low rise button
        low = new JButton("");
        low.setBounds(82, 720, 45, 45);
        low.setBackground(lighterBlack);
        low.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("Button pressed");
                count++;
                if(count%2 != 0 && money>=400) {
                    opacity = 255;
                    opacityImg = 1.0f;
                    lowBool = true;
                    
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    frame.add(lowRes);
                    frame.add(lowComm);
                    frame.remove(highRes);
                    frame.remove(highComm);
                    frame.remove(midRes);
                    frame.remove(midComm);
                }
                else {
                    opacity = 0;
                    opacityImg = 0.0f;
                   lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    frame.remove(lowRes);
                    frame.remove(lowComm);
                }
            } 
        } );
        frame.add(low);
        //Adding the buttons for the menu
        midRes = new JButton("");
        midRes.setBounds(42,620,100,100);
        midRes.setBackground(lighterBlack);
        midRes.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("Mid residential purchased");
                midBool = false;
                resBool = true;
                commBool = false;
                midPurchaseBool = true;
                count = 0;
                tf = 0;
                frame.remove(midRes);
                frame.remove(midComm);count = 0;
                tf = 0;
                frame.remove(midRes);
                frame.remove(midComm);
            } 
        } );
        midComm = new JButton("");
        midComm.setBounds(197,620,100,100);
        midComm.setBackground(lighterBlack);
        midComm.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("Mid commercial purchased");
                midBool = false;
                commBool = true;
                resBool = false;
                midPurchaseBool = true;
                count = 0;
                tf = 0;
                frame.remove(midRes);
                frame.remove(midComm);count = 0;
                tf = 0;
                frame.remove(midRes);
                frame.remove(midComm);
            } 
        } );
        //Adding the mid rise button
        mid = new JButton("");
        mid.setBounds(192, 720, 45, 45);
        mid.setBackground(lighterBlack);
        mid.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("Button pressed");
                count++;
                if(count%2 != 0) {
                    opacity = 255;
                    opacityImg = 1.0f;
                    lowBool = false;
                    midBool = true;
                    highBool = false;
                    servicesBool = false;
                    frame.add(midRes);
                    frame.add(midComm);
                    frame.remove(highRes);
                    frame.remove(highComm);
                    frame.remove(lowRes);
                    frame.remove(lowComm);
                }
                else {
                    opacity = 0;
                    opacityImg = 0.0f;
                   lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    frame.remove(midRes);
                    frame.remove(midComm);
                }
            } 
        } );
        frame.add(mid);
        //Adding the buttons for the menu
        highRes = new JButton("");
        highRes.setBounds(30, 620, 100, 100);
        highRes.setBackground(lighterBlack);
        highRes.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("High residential purchased");
                highBool = false;
                highPurchaseBool = true;
                resBool = true;
                commBool = false;
                count = 0;
                tf = 0;
                frame.remove(highRes);
                frame.remove(highComm);
            } 
        } );
        highComm = new JButton("");
        highComm.setBounds(182,620,100,100);
        highComm.setBackground(lighterBlack);
        highComm.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                System.out.println("High commercial purchased");
                highBool = false;
                highPurchaseBool = true;
                resBool = false;
                commBool = true;
                count = 0;
                tf = 0;
                frame.remove(highRes);
                frame.remove(highComm);
            } 
        } );
        //Adding button for high rise
        high = new JButton("");
        high.setBounds(302, 720, 45, 45);
        high.setBackground(lighterBlack);
        high.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed");
                count++;
                if(count%2 != 0) {
                    opacity = 255;
                    opacityImg = 1.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = true;
                    servicesBool = false;
                    frame.add(highRes);
                    frame.add(highComm);
                    frame.remove(midRes);
                    frame.remove(midComm);
                    frame.remove(lowRes);
                    frame.remove(lowComm);
                }
                else {
                    opacity = 0;
                    opacityImg = 0.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    frame.remove(highRes);
                    frame.remove(highComm);
                }
            }
        } );
        frame.add(high);
        
        //Adding the buttons for the menu
        cityServices = new JButton("");
        cityServices.setBounds(30, 620, 100, 100);
        cityServices.setBackground(lighterBlack);
        cityServices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed");
                count++;
                if(count%2 != 0) {
                    opacity = 255;
                    opacityImg = 1.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    cityServiceBool = true;
                    frame.remove(highRes);
                    frame.remove(highComm);
                    frame.remove(midRes);
                    frame.remove(midComm);
                    frame.remove(lowRes);
                    frame.remove(lowComm);
                }
                else {
                    opacity = 0;
                    opacityImg = 0.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    cityServiceBool = false;
                    frame.remove(highRes);
                    frame.remove(highComm);
                }
            }
        } );
        
        energy = new JButton("");
        energy.setBounds(182,620,100,100);
        energy.setBackground(lighterBlack);
        energy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed");
                count++;
                if(count%2 != 0) {
                    opacity = 255;
                    opacityImg = 1.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    cityServiceBool = false;
                    energyBool = true;
                    frame.remove(highRes);
                    frame.remove(highComm);
                    frame.remove(midRes);
                    frame.remove(midComm);
                    frame.remove(lowRes);
                    frame.remove(lowComm);
                }
                else {
                    opacity = 0;
                    opacityImg = 0.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    cityServiceBool = false;
                    energyBool = false;
                    frame.remove(highRes);
                    frame.remove(highComm);
                }
            }
        } );
        energy = new JButton("");
        energy.setBackground(lighterBlack);
        //Adding the services button
        services = new JButton("");
        services.setBounds(412, 720, 45, 45);
        services.setBackground(lighterBlack);
        services.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed");
                count++;
                if(count%2 != 0) {
                    opacity = 255;
                    opacityImg = 1.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = true;
                    frame.add(cityServices);
                    frame.add(energy);
                    frame.add(factory);
                    frame.add(school);
                    frame.remove(highRes);
                    frame.remove(highComm);
                    frame.remove(midRes);
                    frame.remove(midComm);
                    frame.remove(lowRes);
                    frame.remove(lowComm);
                }
                else {
                    opacity = 0;
                    opacityImg = 0.0f;
                    lowBool = false;
                    midBool = false;
                    highBool = false;
                    servicesBool = false;
                    frame.remove(highRes);
                    frame.remove(highComm);
                }
            }
        } );

        //Money Meter
        
        frame.add(services);
        
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.add(drawPanel);

        frame.setResizable(false);
        frame.setLocationByPlatform(true);

        frame.setVisible(true);
        moveIt();
    }
    class DrawPanel extends JPanel {
        boolean placed = false;
        int int_random = 100;
        int xChangeConst = 0;
        int yChangeConst = 0;
        int heightConst = 0;
        int widthConst = 0;
        
        boolean infographicDisplay = false;
        
        ImageIcon tempImageIcon = new ImageIcon("highStore.png");
        Image buildingImg = tempImageIcon.getImage();
        public void paint(Graphics g) {
             Graphics2D g2d = (Graphics2D) g;
             
             g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
             float opacityCurrent = opacityImg;
             AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,opacityCurrent);
             AlphaComposite ac2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1);
             super.paintComponent(g);
            
             //font
            

             g.setColor(Color.GREEN);
             g.fillRect(0, 0, 875, 720);
             
             g.setColor(Color.BLACK);
             g.fillRect(0, 720, 875, 80);
             //money
             g.setColor(Color.WHITE);
             g.drawRect(0, 720, 875, 80);
             g.fillRect(720, 725, 120, 30);
             g.setColor(Color.GRAY);
             g.fillRect(730, 730, 100, 20);
             g.setColor(Color.BLACK);
            Font myFont = new Font ("Courier New", 1, 24);
            g.setFont(myFont);
            g.drawString("$" + money, 730, 747);
            repaint();
            Font myoFont = new Font ("Arial", 1, 12);
            g.setFont(myoFont);
            //pollution
            g.setColor(Color.WHITE);
            g.fillRect(580, 725, 120, 30);
            g.setColor(Color.GRAY);
            g.fillRect(590, 730, 100, 20);
            g.setColor(Color.BLACK);
            g.fillRect(Pollution+520, 730, 100, 20);
           
           
           repaint();
          
         
           
            
             
             //Road
             for(int i = 100; i < 870; i+=125) {
                 g.setColor(Color.BLACK);
                 g.fillRect(i, 0, 25, 720);
                 g.setColor(Color.WHITE);
                 g.drawRect(i, 0, 25, 720);
                 g.drawRect(i + 12, 0, 2, 720);
                 if(i < 700) {
                    g.setColor(Color.BLACK);
                    g.fillRect(0, i, 875, 25);
                    g.setColor(Color.WHITE);
                    g.drawRect(0, i, 875, 25);
                    g.fillRect(0, i + 12, 875, 2);
                 }
             }
             g.setColor(Color.BLACK);
             for(int i = 100; i < 870; i+=125) {
                 for(int j = 100; j < 700; j+=125) {
                    g.fillRect(i - 1, j - 1, 27, 27);
                 }
             }
             if(highPurchaseBool) {
                 xChangeConst = 26;
                 yChangeConst = 130;
                 widthConst = 80;
                 heightConst = 160;
                 if(resBool) {
                     System.out.println("Running random generation");
                     Random rand = new Random();
                     int upperbound = 3;
                     int_random = rand.nextInt(upperbound);
                     System.out.println("Generated: " + int_random);
                     ImageIcon icon = new ImageIcon("tower.png");
                     if(int_random == 0) {
                         icon = new ImageIcon("tower.png");
                         System.out.println("Generated small tower");
                     }
                     if(int_random == 1) {
                         icon = new ImageIcon("tall tower.png");
                         System.out.println("Generated tall tower");
                     }
                     if(int_random == 2) {
                         icon = new ImageIcon("high.png");
                         System.out.println("Generated gray tower");
                     }
                     buildingImg = icon.getImage();
                     highPurchaseBool = false;
                 }
                 else if(commBool) {
                     Random rand = new Random();
                     int upperbound = 2;
                     int_random = rand.nextInt(upperbound);
                     ImageIcon icon = new ImageIcon("tower.png");
                     if(int_random == 0) {
                         icon = new ImageIcon("skyscraper.png");
                         xChangeConst = 34;
                         yChangeConst = 180;
                         widthConst = 120;
                         heightConst = 240;
                     }
                     if(int_random == 1) {
                         icon = new ImageIcon("skyscraper2.png");
                         xChangeConst = 52;
                         yChangeConst = 220;
                         widthConst = 160;
                         heightConst = 320;
                     }
                     buildingImg = icon.getImage();
                     highPurchaseBool = false;
                 }
             }
             else if(midPurchaseBool) {
                 xChangeConst = 7;
                 yChangeConst = 32;
                 widthConst = 50;
                 heightConst = 50;
                 if(resBool) {
                     System.out.println("Running random generation");
                     Random rand = new Random();
                     int upperbound = 1;
                     int_random = rand.nextInt(upperbound);
                     System.out.println("Generated: " + int_random);
                     ImageIcon icon = new ImageIcon("tower.png");
                     if(int_random == 0) {
                         icon = new ImageIcon("midapartment.png");
                     }
                     buildingImg = icon.getImage();
                     midPurchaseBool = false;
                 }
                 else if(commBool) {
                     Random rand = new Random();
                     int upperbound = 3;
                     int_random = rand.nextInt(upperbound);
                     ImageIcon icon = new ImageIcon("tower.png");
                     if(int_random == 0) {
                         icon = new ImageIcon("mall.png");
                         widthConst = 100;
                         heightConst = 100;
                     }
                     if(int_random == 1) {
                         icon = new ImageIcon("bigshop.png");
                     }
                     if(int_random == 2) {
                         icon = new ImageIcon("mall5.png");
                         xChangeConst = 16;
                         widthConst = 100;
                         heightConst = 100;
                     }
                     buildingImg = icon.getImage();
                     midPurchaseBool = false;
                 }
             }
             else if(lowPurchaseBool) {
                 xChangeConst = 7;
                 yChangeConst = 32;
                 widthConst = 50;
                 heightConst = 50;
                 if(resBool) {
                     System.out.println("Running random generation");
                     Random rand = new Random();
                     int upperbound = 3;
                     int_random = rand.nextInt(upperbound);
                     System.out.println("Generated: " + int_random);
                     ImageIcon icon = new ImageIcon("tower.png");
                     if(int_random == 0) {
                         icon = new ImageIcon("log cabin.png");
                     }
                     if(int_random == 1) {
                         icon = new ImageIcon("house2.png");
                     }
                     if(int_random == 2) {
                        icon = new ImageIcon("housestronk.png");
                     }
                     buildingImg = icon.getImage();
                     lowPurchaseBool = false;
                 }
                 else if(commBool) {
                     Random rand = new Random();
                     int upperbound = 3;
                     int_random = rand.nextInt(upperbound);
                     ImageIcon icon = new ImageIcon("tower.png");
                     if(int_random == 0) {
                         icon = new ImageIcon("lowshop.png");
                     }
                     if(int_random == 1) {
                         icon = new ImageIcon("shop2.png");
                     }
                     if(int_random == 2) {
                         icon = new ImageIcon("shop69.png");
                     }
                     buildingImg = icon.getImage();
                     lowPurchaseBool = false;
                 }
             }
             if(tf == 0 && !infographicDisplay) {
                 //20, 130
                 g.drawImage(buildingImg, (mx-xChangeConst)-(mx-xChangeConst)%25 - 15, (my-yChangeConst)-(my-yChangeConst)%25, widthConst, heightConst, null);

             }
             else if (tf == 1 && !infographicDisplay) {
                 int_random = 1000;
                 xvalues.add((mx-xChangeConst)-(mx-xChangeConst)%25 - 15/*(int)Math.floor((mx-50)/25)*25*/);
                 yvalues.add((my-yChangeConst)-(my-yChangeConst)%25/*(int)Math.floor((my-50)/25)*25*/);
                 width.add(widthConst);
                 height.add(heightConst);
                 buildingImage.add(buildingImg);
             }
             
             for(int i = 0; i < xvalues.size(); i++) {
                 g.drawImage(buildingImage.get(i), xvalues.get(i), yvalues.get(i), width.get(i), height.get(i), null);
             }
             repaint();
             
             //Ppo-up window
             Color lighterBlack = new Color(64, 64, 64, opacity);
             g.setColor(lighterBlack);
             
             
            
             //Pop-up for low rise buildings
             if(lowBool) {
                
                 g.fillRect(0, 620, 875, 100);
                 //Residential
                 ImageIcon lowRes = new ImageIcon("log cabin.png");
                 Image lowResImage = lowRes.getImage();
                 
                 //Commercial
                 ImageIcon commercial = new ImageIcon("lowshop.png");
                 Image commercialImage = commercial.getImage();
                 
                 //Draw
                 g2d.setComposite(ac);
                 g2d.setColor(Color.WHITE);
                 g2d.drawImage(lowResImage, 50, 620, 80, 80, null);
                 g2d.drawImage(commercialImage, 202, 632, 65, 65, null);
                 g2d.drawString("Low Residential: $500", 30, 700);
                 g2d.drawString("Low Commercial: $750", 172, 700);
                 g2d.setComposite(ac2);

             }
             //Pop-up window for mid rise buildings
             if(midBool) {
                 g.fillRect(0, 620, 875, 100);
                 //Residential
                 ImageIcon res = new ImageIcon("midapartment.png");
                 Image resImage = res.getImage();
                 g2d.setComposite(ac);
                 g2d.drawImage(resImage, 50, 620, 80, 80, null);
                 g2d.setComposite(ac2);
                 //Commercial
                 ImageIcon comm = new ImageIcon("mall.png");
                 Image commImage = comm.getImage();
                 g2d.setComposite(ac);
                 g2d.setColor(Color.WHITE);
                 g2d.drawImage(commImage, 210, 620, 100, 100, null);
                 g2d.setComposite(ac2);
             }
             //Pop-up window for high rise buildings
             if(highBool) {
                 g.fillRect(0, 620, 875, 100);
                 //Residential
                 ImageIcon res = new ImageIcon("tower.png");
                 Image resImage = res.getImage();
                 g2d.setComposite(ac);
                 g2d.drawImage(resImage, 70, 618, 40, 80, null);
                 g2d.setComposite(ac2);
                 //Commercial
                 ImageIcon comm = new ImageIcon("highStore.png");
                 Image commImage = comm.getImage();
                 g2d.setComposite(ac);
                 g2d.setColor(Color.WHITE);
                 g2d.drawImage(commImage, 200, 620, 80, 80, null);
                 g2d.drawString("High Residential: $5000", 30, 710);
                 g2d.drawString("High Commercial: $7500", 172, 710);
                 g2d.setComposite(ac2);
             }
             
             //Pop-up window for services
             if(servicesBool) {
                 g.fillRect(0, 620, 875, 100);
                 //City services
                 ImageIcon cityServices = new ImageIcon("police.png");
                 Image cityServicesImage = cityServices.getImage();
                 if(cityServiceBool) {
                     g.fillRect(0, 620, 875, 100);
                 }
                 //Energy
                 ImageIcon energy = new ImageIcon("power.png");
                 Image energyImage = energy.getImage();
                 if(energyBool) {
                     g.fillRect(0, 620, 875, 100);
                 }
                 //Factory
                 ImageIcon factory = new ImageIcon("factory.png");
                 Image factoryImage = factory.getImage();
                 //School
                 ImageIcon school = new ImageIcon("school.png");
                 Image schoolImage = school.getImage();
                 
                 //Draw
                 g2d.setComposite(ac);
                 g2d.drawImage(cityServicesImage, 50, 620, 80, 80, null);
                 g2d.drawImage(energyImage, 200, 620, 80, 80, null);
                 g2d.drawImage(factoryImage, 350, 620, 80, 80, null);
                 g2d.drawImage(schoolImage, 500, 620, 80, 80, null);
             }
             else if(servicesPurchaseBool) {
                xChangeConst = 7;
                yChangeConst = 32;
                widthConst = 50;
                heightConst = 50;
                if(policeBool) {
                    ImageIcon icon = new ImageIcon("police.png");
                    buildingImg = icon.getImage();
                    servicesPurchaseBool = false;
                }
                else if(fireBool) {
                    ImageIcon icon = new ImageIcon("fire.png");
                    buildingImg = icon.getImage();
                    servicesPurchaseBool = false;
                }
                else if(windmill) {
                    ImageIcon icon = new ImageIcon("Untitled_Artwork.png");
                    buildingImg = icon.getImage();
                    servicesPurchaseBool = false;
                }
                else if(solarPanel) {
                    ImageIcon icon = new ImageIcon("solar pannel.png");
                    buildingImg = icon.getImage();
                    servicesPurchaseBool = false;
                }
                else if(nuclearPower) {
                    ImageIcon icon = new ImageIcon("power.png");
                    buildingImg = icon.getImage();
                    servicesPurchaseBool = false;
                }
                else if(factoryBool) {
                    ImageIcon icon = new ImageIcon("factory.png");
                    buildingImg = icon.getImage();
                    servicesPurchaseBool = false;
                }
                else if(schoolBool) {
                    Random rand = new Random();
                    int upperbound = 2;
                    int_random = rand.nextInt(upperbound);
                    ImageIcon icon = new ImageIcon("factory.png");
                    if(int_random == 0) {
                        icon = new ImageIcon("school.png");
                    }
                    else if(int_random == 1) {
                        icon = new ImageIcon("school2.png");
                    }
                    buildingImg = icon.getImage();
                    servicesPurchaseBool = false;
                }
            }
            if(tf == 0 && !infographicDisplay) {
                //20, 130
                g.drawImage(buildingImg, (mx-xChangeConst)-(mx-xChangeConst)%25 - 15, (my-yChangeConst)-(my-yChangeConst)%25, widthConst, heightConst, null);
            }
            else if (tf == 1 && !infographicDisplay) {
                int_random = 1000;
                xvalues.add((mx-xChangeConst)-(mx-xChangeConst)%25 - 15/*(int)Math.floor((mx-50)/25)*25*/);
                yvalues.add((my-yChangeConst)-(my-yChangeConst)%25/*(int)Math.floor((my-50)/25)*25*/);
                width.add(widthConst);
                height.add(heightConst);
                buildingImage.add(buildingImg);
            }
            
            for(int i = 0; i < xvalues.size(); i++) {
                g.drawImage(buildingImage.get(i), xvalues.get(i), yvalues.get(i), width.get(i), height.get(i), null);
            }
            repaint();
            
            //Ppo-up window
            Color lighterBlack = new Color(64, 64, 64, opacity);
            g.setColor(lighterBlack);
            
            //Pop-up for low rise buildings
            if(lowBool) {
                g.fillRect(0, 620, 875, 100);
                //Residential
                ImageIcon lowRes = new ImageIcon("log cabin.png");
                Image lowResImage = lowRes.getImage();
                
                //Commercial
                ImageIcon commercial = new ImageIcon("lowshop.png");
                Image commercialImage = commercial.getImage();
                
                //Draw
                g2d.setComposite(ac);
                g2d.setColor(Color.WHITE);
                g2d.drawImage(lowResImage, 50, 620, 80, 80, null);
                g2d.drawImage(commercialImage, 202, 632, 65, 65, null);
                g2d.drawString("Low Residential: $500", 30, 700);
                g2d.drawString("Low Commercial: $750", 172, 700);
                g2d.setComposite(ac2);
            }
            //Pop-up window for mid rise buildings
            if(midBool) {
                g.fillRect(0, 620, 875, 100);
                //Residential
                ImageIcon res = new ImageIcon("midapartment.png");
                Image resImage = res.getImage();
                g2d.setComposite(ac);
                g2d.drawImage(resImage, 50, 620, 80, 80, null);
                g2d.setComposite(ac2);
                //Commercial
                ImageIcon comm = new ImageIcon("mall.png");
                Image commImage = comm.getImage();
                g2d.setComposite(ac);
                g2d.setColor(Color.WHITE);
                g2d.drawImage(commImage, 210, 620, 100, 100, null);
                g2d.setComposite(ac2);
            }
            //Pop-up window for high rise buildings
            if(highBool) {
                g.fillRect(0, 620, 875, 100);
                //Residential
                ImageIcon res = new ImageIcon("tower.png");
                Image resImage = res.getImage();
                g2d.setComposite(ac);
                g2d.drawImage(resImage, 70, 618, 40, 80, null);
                g2d.setComposite(ac2);
                //Commercial
                ImageIcon comm = new ImageIcon("highStore.png");
                Image commImage = comm.getImage();
                g2d.setComposite(ac);
                g2d.setColor(Color.WHITE);
                g2d.drawImage(commImage, 200, 620, 80, 80, null);
                g2d.drawString("High Residential: $5000", 30, 710);
                g2d.drawString("High Commercial: $7500", 172, 710);
                g2d.setComposite(ac2);
            }
            
            //Pop-up window for services
            if(servicesBool) {
                g.fillRect(0, 620, 875, 100);
                //City services
                ImageIcon cityServicesIcon = new ImageIcon("police.png");
                Image cityServicesImage = cityServicesIcon.getImage();
                //Energy
                ImageIcon energyIcon = new ImageIcon("power.png");
                Image energyImage = energyIcon.getImage();
                //Factory
                ImageIcon factoryIcon = new ImageIcon("factory.png");
                Image factoryImage = factoryIcon.getImage();
                //School
                ImageIcon schoolIcon = new ImageIcon("school.png");
                Image schoolImage = schoolIcon.getImage();
                
                //Draw
                g2d.setComposite(ac);
                g2d.drawImage(cityServicesImage, 50, 620, 80, 80, null);
                g2d.drawImage(energyImage, 200, 620, 80, 80, null);
                g2d.drawImage(factoryImage, 350, 620, 80, 80, null);
                g2d.drawImage(schoolImage, 500, 620, 80, 80, null);
                g2d.setComposite(ac2);
            }
            if(cityServiceBool) {
                 g.fillRect(0, 620, 875, 100);
                 //Police
                 ImageIcon policeService = new ImageIcon("police.png");
                 Image policeServiceImage = policeService.getImage();
                 //Fire
                 ImageIcon fireService = new ImageIcon("fire.png");
                 Image fireServiceImage = fireService.getImage();
                 //Draw
                 g2d.setComposite(ac);
                 g2d.drawImage(policeServiceImage, 50, 620, 80, 80, null);
                 g2d.drawImage(fireServiceImage, 200, 620, 80, 80, null);
                 g2d.setComposite(ac2);
            }
            if(energyBool) {
                 g.fillRect(0, 620, 875, 100);
                 //Windmill
                 ImageIcon windmillIcon = new ImageIcon("Untitled_Artwork.png");
                 Image windmillImage = windmillIcon.getImage();
                 //Solar panel
                 ImageIcon solarPanelIcon = new ImageIcon("solar pannel.png");
                 Image solarPanelImage = solarPanelIcon.getImage();
                 //Nuclear power
                 ImageIcon nuclearIcon = new ImageIcon("power.png");
                 Image nuclearImage = nuclearIcon.getImage();
                 //Draw
                 g2d.setComposite(ac);
                 g2d.drawImage(windmillImage, 70, 620, 40, 80, null);
                 g2d.drawImage(solarPanelImage, 200, 620, 80, 80, null);
                 g2d.drawImage(nuclearImage, 350, 620, 80, 80, null);
            }
             
             //Pop-up window for landscape
             if(landscapeBool) {
                 g.fillRect(0, 620, 800, 100);
                 //Tree
                 ImageIcon tree = new ImageIcon("tree (1).png");
                 Image treeImage = tree.getImage();
                 g2d.setComposite(ac);
                 g2d.drawImage(treeImage, 50, 620, 80, 80, null);
                 g2d.setComposite(ac2);
             }
             
             //GUI part
             ImageIcon lowIcon = new ImageIcon("log cabin.png");
             Image lowIconImage = lowIcon.getImage();
             
             ImageIcon midIcon = new ImageIcon("midapartment.png");
             Image midIconImage = midIcon.getImage();
             
             ImageIcon highIcon = new ImageIcon("apartment.png");
             Image highIconImage = highIcon.getImage();
             
             ImageIcon servicesIcon = new ImageIcon("power.png");
             Image servicesIconImage = servicesIcon.getImage();
             
             ImageIcon resInfographic = new ImageIcon("residential.png");
             Image resInfoImage = resInfographic.getImage();
             
             g.drawImage(lowIconImage,70,703,70,70,null);
             g.drawImage(midIconImage,180,713,60,60,null);
             g.drawImage(highIconImage,290,713,60,60,null);
             g.drawImage(servicesIconImage,400,713,60,60,null);
             if(infographic == 2 && resBool) {
                 g.drawImage(resInfoImage, 87, 25, 700, 700, null);
                 tf = 0;
                 infographicDisplay = true;
             }
             else if(infographic == 3) {
                 mx = 1000;
                 my = 1000;
                 infographic++;
             }
             else if(infographic == 4) {
                 infographicDisplay = false;
             }
             repaint();

             
        }
    }
    public void mouseMoved(MouseEvent e) {
      
      mx = ((java.awt.Component) e).getX();
      
      my = ((java.awt.Component) e).getY();
    
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        ifRoad=1;
      
      if(tf==0&&ifRoad==1) {
          if(infographic == 1 || infographic == 2) {
              infographic++;
          }
          tf=1;
          //lowBool
          if(smallHouse==1){

            
            System.out.println("release");
           
            

         }
         //highBool
      }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
       
    }
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
      
        
    }
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
    }
    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
       int mxcoord = e.getX();
       int mycoord = e.getY();
        if(tf==0){
            Main.mx = e.getX();
            Main.my = e.getY();
        }
        
                   
    }

    private void moveIt()
    {
        
            /*# You MAY want change or remove the loops below depending on 
             * how your pictures move. If you aren't sure, ask for help!
             */
            while(true){  
                
                
                counter+=10;
            //lowRes
            if(smallHouse>=1){

                if (counter%10==0){
                    money+=(1*smallHouse);
                    System.out.println("yoo");
               
                    }
            }
            
                try
                {
                    Thread.sleep(1000);
                    System.out.println(counter);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                frame.repaint();
            
            
            
            }
          
            
           
            /*# Please DO NOT change the code below! */
            
        }
    }

  
   


  /*
draw(){
int + 1



}





  */
