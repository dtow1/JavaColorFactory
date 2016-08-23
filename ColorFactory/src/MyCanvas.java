/**
 *@author Jason Boyer
 *Date  :  12/1/15
 *Assignment: Homework 4
 *Program Function: To create a program to visually display colors. The system has 3 sliders that modify the RGB values. The color is 
 *displayed in a circle mid screen. There are also three color bars that visually display the amount of red, green, and blue in the
 *color. The color values are able to be displayed in decimal, binary, hex, and octal formats.
 */

import java.awt.*;


public class MyCanvas extends Canvas
{
    private int red,green,blue,width,height,x,y;
    private String redString, greenString, blueString;
    private boolean drawCircle, drawRedBar, drawGreenBar,
    drawBlueBar,drawAllString;
    
    private enum NumberType
    {
        Decimal, Octal, Binary, Hex;
    }
    
    private NumberType currentType;
  
    public MyCanvas()
    {
        x=240;
        y=125;
        width= 175;
        height= 175;
        drawCircle=true;drawRedBar=true; drawGreenBar=true;
        drawBlueBar=true;
        redString = Integer.toString(red);
        blueString = Integer.toString(blue);
        greenString = Integer.toString(green);
        currentType = NumberType.Decimal;        
    }
    

    public void paint(Graphics g) 
    {
        super.paint(g);
        update(g);       
    }
    
    @Override
    public void update(Graphics g) 
    {        
        if(drawCircle) 
        {
            g.setColor(new Color(red,green,blue));
            g.fillOval(x, y, width, height);
            drawCircle=false;
        }
        if(drawRedBar) 
        {
            g.clearRect(20,45,60,320);
            g.setColor(new Color(255,0,0));
            g.fillRect(20, 300-red, 60, red);
            g.setColor(Color.BLACK);
            g.drawLine(20, 300, 80, 300);
            g.drawString(redString, 20, 315);
            drawRedBar=false;
        }
        if(drawGreenBar)
        {
            g.clearRect(90,45,60,300);
            g.setColor(new Color(0,255,0));
            g.fillRect(90, 300-green, 60, green);
            g.setColor(Color.BLACK);
            g.drawLine(90, 300, 150, 300);
            g.drawString(greenString, 90, 315);
            drawGreenBar=false;
        }
        if(drawBlueBar)
        {
            g.clearRect(160, 45, 60, 300);
            g.setColor(new Color(0,0,255));
            g.fillRect(160, 300-blue, 60, blue);
            g.setColor(Color.BLACK);
            g.drawLine(160, 300, 220, 300);
            g.drawString(blueString, 160, 315);
            drawBlueBar=false;
        }
        if(drawAllString) 
        {
            g.clearRect(20, 305, 205, 10);
            g.setColor(Color.BLACK);
            g.drawLine(20, 300, 80, 300);
            g.drawString(redString, 20, 315);
            g.drawLine(90, 300, 150, 300);
            g.drawString(greenString, 90, 315);
            g.drawLine(160, 300, 220, 300);
            g.drawString(blueString, 160, 315);
            drawAllString=false;
        }
    }
    
    public void setType(String type) 
    {
        String tempType = type.toLowerCase();
        switch(tempType) 
        {
            case "decimal": currentType=NumberType.Decimal;
                            redString = Integer.toString(red);
                            greenString = Integer.toString(green);
                            blueString = Integer.toString(blue);
                            break;
            case "octal":   currentType=NumberType.Octal;
                            redString = Integer.toOctalString(red);
                            greenString = Integer.toOctalString(green);
                            blueString = Integer.toOctalString(blue);
                            break;
            case "hex":     currentType=NumberType.Hex;
                            redString = Integer.toHexString(red);
                            greenString = Integer.toHexString(green);
                            blueString = Integer.toHexString(blue);
                            break;
            case "binary":  currentType=NumberType.Binary;
                            redString = Integer.toBinaryString(red);
                            greenString = Integer.toBinaryString(green);
                            blueString = Integer.toBinaryString(blue);
                            break;
            default:        currentType=NumberType.Decimal;
                            redString = Integer.toString(red);
                            greenString = Integer.toString(green);
                            blueString = Integer.toString(blue);
                            break;
        }
        drawAllString=true;
        repaint();
    }
    
    public void setColor(int red, int green, int blue) 
    {
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }
    
    public void setRed(int red) 
    {
        this.red=red;
        setType(currentType.name());
        drawCircle=true;
        drawRedBar=true;
    }
    
    public void setGreen(int green) 
    {
        this.green=green;
        setType(currentType.name());
        drawCircle=true;
        drawGreenBar=true;
    }
    
    public void setBlue(int blue) 
    {
        this.blue=blue;
        setType(currentType.name());
        drawCircle=true;
        drawBlueBar=true;
    }
    
    public int getRed() 
    {
        return red;
    }
    
    public int getBlue() 
    {
        return blue;
    }
    
    public int getGreen() 
    {
        return green;
    }
    
}
