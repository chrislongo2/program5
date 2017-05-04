/*
 *  Chris Longo
    5/3/2017
    Program 5 - Square Cyclops
    creating a gamecharacter
 */
package csc220.program5.longocj2020;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 *
 * @author longocj2020
 */
public class SquareCyclops extends csc220.program5.GameCharacter {
    
private boolean isHappy;
    private Color hatColor;
    private int horizontalStepSize;	// how far to move
    private int windowWidth;
    Random rand = new Random();
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor1 = new Color(r, g, b);
    Color randomColor2 = new Color(g, b, r);
    
    
    public SquareCyclops(int x, int y, int radius, int moveInterval) {
        super(x, y, radius,radius, 1000, new csc220.program5.longocj2020.List<>());
        
        
        
        animationPath.add(new Point(x, y));
        animationPath.add(new Point(x + 100, y));
        animationPath.add(new Point(x, y + 100));
        animationPath.add(new Point(x + 100, y + 100));
       // animationPath.add(new Point(x+300 , y+50 )); 
        isHappy = true;
        hatColor = randomColor1;
     } // constructor

    public void draw(Graphics g) {
        // Draw the SquareHead's face.
        int over = getOver();
        int down = getDown();
        int width = getWidth();
        
        
        
          // Draw the RoundHead's hat.
        g.setColor(hatColor);
        g.fillOval(over+width/4,down-width/4, width/2,width/2);
        g.fillRect(over, down, width, width/10);
        //g.fillRect(over+width/4, down-width/3, width/2, width/3);
        
        
        g.setColor(randomColor2);
        g.fillRect(over, down, width, width);
        
        
      g.setColor(hatColor);
        g.fillRect(over, down, width, width/10);
        

        // Put a black outline around face.
        g.setColor(Color.black);
        g.drawRect(over, down, width, width);

        

        // Draw the RoundHead's facial features in black, based on mood.
        g.setColor(Color.black);

        if (isHappy)  {
            g.fillOval(over+2*width/5, down+3*width/10, width/5, width/5);
           // g.fillOval(over+3*width/5, down+3*width/10, width/5, width/5);
            g.drawArc(over+3*width/10, down+width/2, 2*width/5, 3*width/10, 190, 160);
        } else {
            // sad
            g.fillRect(over+2*width/5, down+3*width/10, width/5, width/10);
            //g.fillRect(over+3*width/5, down+3*width/10, width/5, width/10);
            g.drawArc(over+3*width/10, down+7*width/10, 2*width/5, 3*width/10, 10, 160);
        }
    } // drawMe

     
    public void changeMood() {
        isHappy = !isHappy;
    } // changeMood

  

    

    
} 
