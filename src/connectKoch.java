// Cameron Meyer
// Assignment 5 - Exercise 8.2
// CS 4361.001


import java.awt.*;
import java.awt.event.*;

public class connectKoch extends Frame
{
   public static void main(String[] args) {new connectKoch();}

   connectKoch()
   {
      super("Connected Koch. Click the left mouse button to increase the detail level.");
      addWindowListener(new WindowAdapter()
      {
         public void windowClosing(WindowEvent e) {System.exit(0);}
      });
      setSize(600, 500);
      add("Center", new CvKoch());
      setVisible(true);
   }
}

class CvKoch extends Canvas
{
   public float x, y;
   double dir;
   int midX, midY, level = 1;

   int iX(float x) {return Math.round(midX + x);}
   int iY(float y) {return Math.round(midY - y);}

   CvKoch()
   {
      addMouseListener(new MouseAdapter()
      {
         public void mousePressed(MouseEvent evt)
         {
            level++; // Each mouse click increases the level by 1.
            repaint();
         }
      });
   }

   public void paint(Graphics g)
   {
      Dimension d = getSize();
      int maxX = d.width - 1, maxY = d.height - 1, length = 0;
      
      // The size of the shape is dependent on the shorter dimension of the window
      if(maxX >= maxY)
      {
    	  length = 3 * maxY / 4;
      }
      else
      {
    	  length = 3 * maxX / 4;
      }
          
      midX = maxX / 2; midY = maxY / 2;
      x = (float) (-length / 2); // Start point
      y = (float) ((length / 3) * Math.sin(60 * Math.PI / 180)); // Ensure shape is centered vertically in the window
      
      // Draw all 3 segments of the snowflake at the appropriate angles
      dir = 0;
      drawKoch(g, length, level);
      
      dir = 240;
      drawKoch(g, length, level);
      
      dir = 120;
      drawKoch(g, length, level);
   }

   public void drawKoch(Graphics g, double len, int n)
   {
      if (n == 0)
      {
         double dirRad, xInc, yInc;
         dirRad = dir * Math.PI / 180;
         xInc = len * Math.cos(dirRad); // x increment
         yInc = len * Math.sin(dirRad); // y increment
         float x1 = x + (float) xInc, y1 = y + (float) yInc;
         g.drawLine(iX(x), iY(y), iX(x1), iY(y1));
         x = x1;
         y = y1;
      }
      else
      {
         drawKoch(g, len /= 3, --n);
         dir += 60;
         drawKoch(g, len, n);
         dir -= 120;
         drawKoch(g, len, n);
         dir += 60;
         drawKoch(g, len, n);
      }
   }
}