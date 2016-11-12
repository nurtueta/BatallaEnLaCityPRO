package Grafica;
import java.applet.Applet;
import java.applet.AudioClip;

/**
 * @Author Ryan Castillo - Edited for adaptation by Guillermo Vazquez
 * 
 */
//-------------------------------------------------------------------
//
//@Ryan Castillo
//  Sorry for the lack of comments, ran into some time constraints.
//
//-------------------------------------------------------------------
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import java.util.Random;

public class main extends Frame
{

  CvStory canvas;
  private	AudioClip clip;
  private	boolean termino =false;

  public static void main (String[] args) throws IOException
  {

    main Pic = new main ("archivo/IntroStory.txt");

      //try
      //{ Thread.sleep(500);}
      //catch (InterruptedException e){}
    
    Pic.show();
    Pic.movePic ();
    Pic.disable();
    Pic.setVisible(false);
    Inicio juego = new Inicio();
    juego.setVisible();
  }

  public main(String s) throws IOException
  {
    super ("StarWasIntro");


    java.net.URL url = main.class.getResource("/archivo/Star_Wars_Music_Theme.wav");
    clip = Applet.newAudioClip(url);
    clip.play();
    
    addWindowListener (new WindowAdapter ()
       {public void windowClosing (WindowEvent e){System.exit(0);}});
    //this.setExtendedState(MAXIMIZED_BOTH);
    setSize (800, 600);
    canvas = new CvStory("archivo/IntroStory.txt");
    setBounds(100, 100, 900, 630);
    canvas = new CvStory(s);
    
    add (canvas);
  }

  public void movePic ()
  {
    //for (int a = 0; a < 3600; a++)
    while (!termino)
    {

      try
      { Thread.sleep(10);}
      catch (InterruptedException e){}

      canvas.repaint();
      
      canvas.addMouseListener(new MouseAdapter() {
  		@Override
  		public void mouseClicked(MouseEvent e) {
  			termino=true;
  			
  		}
  	});
      
      
    }
    clip.stop();
    
  }

}

class CvStory extends Canvas
{
  private String [] storyTxt;
  private double [][] pixels, pixels3D, beforeRotate;
  private int [][] stars;
  private int storySize, maxX, maxY;
  private int numPixels = 0;
  private boolean readData = false;
  Random generator = new Random ();
  
  CvStory (String s) throws IOException
  {
	
	ReadFile f = new ReadFile (s);

    storyTxt = f.getStory ();
    storySize = f.getSize ();

    pixels = new double [30000][3];
    beforeRotate = new double [30000][3];
    pixels3D = new double [30000][3];

    stars = new int [80][4];
    
    for (int a = 0; a < stars.length; a++)
    {
     stars[a][2] = (Math.abs (generator.nextInt ()) % 3) + 1;
     stars[a][3] = stars[a][2];
     
     stars[a][0] = (Math.abs (generator.nextInt ()) % 799) + 10;
     stars[a][1] = (Math.abs (generator.nextInt ()) % 599) + 10;          
}
    
    BufferedImage bufferImg = new BufferedImage (650, 900,
                                                 Image.SCALE_DEFAULT);
    Graphics gBuffer = bufferImg.getGraphics ();

    Font g = new Font ("Arial", Font.PLAIN, 20);
    gBuffer.setFont(g);

    for (int i = 0; i < storySize; i++)
      gBuffer.drawString (storyTxt [i], 10, i * 20 + 30);

    for (int i = 0; i < 650 - 1; i++)
      for (int j = 0; j < 900 - 1; j++)
        if (bufferImg.getRGB (i, j) == -1)
          {
          pixels[numPixels][0] = 0;
          pixels[numPixels][1] = i - 135;
          pixels[numPixels][2] = j + 410;      //value determines start

          numPixels = numPixels + 1;
          
          //System.out.println(numPixels);
          }

  }

  public void paint (Graphics g)
  {
    Dimension d = getSize();

    maxX = d.width - 1; 
    maxY = d.height - 1;  

    double t = 0.0, Eye = 635.0;
    
    int originX = (int) ((int)maxX / 2.5),
        originY = maxY/2 ;
        
    BufferedImage bufferImg = new BufferedImage (getWidth(), getHeight(),
                                                 Image.SCALE_DEFAULT);
    Graphics gBuffer = bufferImg.getGraphics ();
    
    for (int a = 0; a < stars.length; a++)
    {
     gBuffer.setColor(Color.lightGray);
     gBuffer.fillOval (stars[a][0]-1, stars[a][1]-1, stars[a][2]+ 2, stars[a][3]+ 2);
     
     gBuffer.setColor(Color.white);
     
        gBuffer.fillOval (stars[a][0], stars[a][1], stars[a][2], stars[a][3]);
    }

    rotateY(-59);
    
    gBuffer.setColor(Color.yellow);

    for (int i = 0; i < numPixels; i++)
      for (int j = 0; j < 3; j++)
      {

        if (j == 0)
          t = 1.0 / (1.0 - (pixels[i][j] / Eye));
        else
          pixels3D[i][j - 1] = t * pixels[i][j];
      }

    for (int i = 0; i < numPixels; i++)
    {
  gBuffer.drawLine ((int) Math.round(originX + pixels3D[i][0]),
                        (int) Math.round(pixels3D[i][1])+ 1,
                        (int) Math.round(originX + pixels3D[i][0]),
                        (int) Math.round(pixels3D[i][1])- 1);
      gBuffer.drawLine ((int) Math.round(originX + pixels3D[i][0])+ 1,
                        (int) Math.round(pixels3D[i][1])+ 1,
                        (int) Math.round(originX + pixels3D[i][0])+ 1,
                        (int) Math.round(pixels3D[i][1])- 1);
      gBuffer.drawLine ((int) Math.round(originX + pixels3D[i][0])- 1,
                        (int) Math.round(pixels3D[i][1])+ 1,
                        (int) Math.round(originX + pixels3D[i][0])- 1,
                        (int) Math.round(pixels3D[i][1])- 1);
    }

      try
      { Thread.sleep(10);}
      catch (InterruptedException e){}

    g.drawImage (bufferImg, 0, 0, this);
    rotateY(59);
    transPic (0, 0, -0.1);

  }

  public void rotateY (double ry)
  {
    double radAngle = (ry * Math.PI) / 180,
    newX = 0,
newY = 0,
newZ = 0;

for (int i = 0; i < numPixels; i++)
  {
  newX = (pixels[i][0] * Math.cos (radAngle)) +
(pixels[i][2] * (- Math.sin (radAngle)));
  newY = pixels[i][1];
  newZ = (pixels[i][0] * Math.sin (radAngle)) +
(pixels[i][2] * Math.cos (radAngle));

  pixels[i][0] = newX;
  pixels[i][1] = newY;
  pixels[i][2] = newZ;
  }

}

public void transPic (double sx, double sy, double sz)
{

for (int i = 0; i < numPixels; i++)
{
pixels[i][0] = pixels[i][0] + 0;
   pixels[i][1] = pixels[i][1] + sy;
   pixels[i][2] = pixels[i][2] + sz;
}

}//end of transPic


   public void update (Graphics g)
   {
     paint(g);
   }
}

//-------------------------------------------------------------------
//
//  Class for reading text files.
//
//-------------------------------------------------------------------

class ReadFile
{

  private BufferedReader inFile;
  private StringTokenizer tokenizer;
  private String line;
  private int numLine = 0;
  private String story [] = new String [40];

  ReadFile (String file) throws IOException
  {

    inFile = new BufferedReader (new FileReader (file));

    //***************************************************************

    //---------------------------------------------------------------
    //
    //  Code for reading the text file into the array.
    //
    //---------------------------------------------------------------

      line = inFile.readLine();

      while (line != null)
        {

        story [numLine] = line;
        ++numLine;
        line = inFile.readLine();
        }

     inFile.close();
  }//end of ReadFile Constructor

  public int getSize ()
  {
    return numLine;

  }

  public String [] getStory ()
  {
    return story;
  }
}