/**
 *@author Jason Boyer
 *Date  :  12/1/15
 *Assignment: Homework 4
 *Program Function: To create a program to visually display colors. The system has 3 sliders that modify the RGB values. The color is 
 *displayed in a circle mid screen. There are also three color bars that visually display the amount of red, green, and blue in the
 *color. The color values are able to be displayed in decimal, binary, hex, and octal formats.
 */


import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;


public class ColorFactory
{

    public static void main(String[] args) throws URISyntaxException
    {
        SwingUtilities.invokeLater(new Runnable()    
        {   
            public void run()
            {
                JFrame colorFrame = new JFrame();
        
                colorFrame.setTitle("ColorFactory. Make your "
                        + "colors here");
                colorFrame.setSize(700, 600);
                colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                colorFrame.setLocationRelativeTo(null);
                colorFrame.setLayout(new BorderLayout());
                
                
                JLabel banner = new JLabel("Color Factory") 
                {
                    public Font getFont() 
                    {
                        return new Font("Garamond",Font.PLAIN,70);
                    }
                };
                colorFrame.add(banner,BorderLayout.NORTH);
                
                banner.setHorizontalAlignment(JLabel.CENTER);
                banner.setVerticalAlignment(JLabel.TOP);
                banner.setBorder(
                        BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), 
                        BorderFactory.createLoweredBevelBorder()));
        
                MyCanvas circleColor = new MyCanvas();
                JPanel SliderPanel = new JPanel();
                SliderPanel.setLayout(new GridLayout(5,1));
                JPanel redPanel = new JPanel();
                JPanel greenPanel = new JPanel();
                JPanel bluePanel = new JPanel();
                JPanel radioPanel = new JPanel();
        
                JRadioButton decimalButton = new JRadioButton("Dec");
                JRadioButton binaryButton = new JRadioButton("Bin");
                JRadioButton octalButton = new JRadioButton("Oct");
                JRadioButton hexButton = new JRadioButton("Hex");
                
                ButtonGroup numberFormat = new ButtonGroup();
                numberFormat.add(decimalButton);
                numberFormat.add(binaryButton);
                numberFormat.add(octalButton);
                numberFormat.add(hexButton);
                
                
                radioPanel.add(decimalButton);
                radioPanel.add(binaryButton);
                radioPanel.add(octalButton);
                radioPanel.add(hexButton);
                
                decimalButton.setSelected(true);
                ActionListener radioListener=new ActionListener() 
                {
        
                    @Override
                    public void actionPerformed(ActionEvent arg0)
                    {
                        if(arg0.getSource().equals(decimalButton))
                        {
                            circleColor.setType("decimal");
                        }else if(arg0.getSource().equals(octalButton))
                        {
                            circleColor.setType("octal");
                        }else if(arg0.getSource().equals(hexButton))
                        {
                            circleColor.setType("hex");
                        }else if(arg0.getSource().equals(binaryButton))
                        {
                            circleColor.setType("binary");
                        }
                    }
                    
                };
                
                decimalButton.addActionListener(radioListener);
                octalButton.addActionListener(radioListener);
                hexButton.addActionListener(radioListener);
                binaryButton.addActionListener(radioListener);
                
                decimalButton.setToolTipText("<html><h1>Decimal"
                        + "</h1><p>This button changes the output"
                        + " to decimal format</p>");
                octalButton.setToolTipText("<html><h1>Octal</h1>"
                        + "<p>This button changes the output to "
                        + "octal format</p>");
                hexButton.setToolTipText("<html><h1>Hex</h1>"
                        + "<p>This button changes the output to "
                        + "hex format</p>");
                binaryButton.setToolTipText("<html><h1>Binary</h1>"
                        + "<p>This button changes the output to"
                        + " binary format</p>");
                
                JSlider redSlider = new JSlider(0,255,0);
                redSlider.setMajorTickSpacing(51);
                redSlider.setPaintTicks(true);
                redSlider.setToolTipText("<html><h1>Red Slider</h1>"
                        + "<p>This slider adds <font color=#FF0000>"
                        + "<b>red</b></font> to the color wheel.</p>");
                JLabel redLabel = new JLabel("Red");
                
                redLabel.setSize(50, 50);
                
                JSlider blueSlider = new JSlider(0,255,0);
                blueSlider.setMajorTickSpacing(51);
                blueSlider.setPaintTicks(true);
                blueSlider.setToolTipText("<html><h1>Blue Slider"
                        + "</h1><p>This slider adds "
                        + "<font color=#0000FF><b>blue</b></font>"
                        + " to the color wheel.</p>");  
                
                JLabel blueLabel = new JLabel("Blue");
                blueLabel.setSize(50,50);
                
                JSlider greenSlider = new JSlider(0,255,0);
                greenSlider.setMajorTickSpacing(51);
                greenSlider.setPaintTicks(true);
                greenSlider.setToolTipText("<html><h1>Green Slider"
                        + "</h1><p>This slider adds "
                        + "<font color=#00FF00>"
                        + "<b>green</b></font> to the color wheel."
                        + "</p>");
                JLabel greenLabel = new JLabel("Green");
                greenLabel.setSize(50,50);
        
        
                redSlider.addChangeListener(new ChangeListener() 
                {
        
                    @Override
                    public void stateChanged(ChangeEvent arg0)
                    {
                        circleColor.setRed(redSlider.getValue());
                        
        
                    }
                    
                });
                
                blueSlider.addChangeListener(new ChangeListener() 
                {
        
                    @Override
                    public void stateChanged(ChangeEvent arg0)
                    {
                        circleColor.setBlue(blueSlider.getValue());
                        
        
                    }
                    
                });
                
                greenSlider.addChangeListener(new ChangeListener() 
                {
        
                    @Override
                    public void stateChanged(ChangeEvent arg0)
                    {
                        circleColor.setGreen(greenSlider.getValue());
              
        
                    }
                    
                });
                
        
                redPanel.add(redLabel);
                redPanel.add(redSlider);
                greenPanel.add(greenLabel);
                greenPanel.add(greenSlider);
                bluePanel.add(blueLabel);
                bluePanel.add(blueSlider);
                
                SliderPanel.add(new JPanel());
                SliderPanel.add(redPanel);
                SliderPanel.add(greenPanel);
                SliderPanel.add(bluePanel);
                SliderPanel.add(radioPanel);

                colorFrame.add(circleColor,BorderLayout.CENTER);

                colorFrame.add(SliderPanel, BorderLayout.EAST);
                colorFrame.setVisible(true);
            }
        });
    }
    
 
}


