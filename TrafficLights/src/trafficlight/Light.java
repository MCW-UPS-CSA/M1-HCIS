/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlight;

/**
 *
 * @author mihai-ub
 */
import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JComponent;
import javax.swing.JFrame;
 
 
public class Light
{
     
    private Color LightFillColor;
    private Color LightBorderColor;
     
    private int LightX = 0;
    private int LightY = 0;
    private int LightWidth = 0;
    private int LightHeight = 0;
     
    public boolean fillLight = false;
    private static Light LightArray[]; //Required for drawMultipleLights
     
    Light(){ //Constructor
        LightBorderColor = Color.black;
    }
 
    Light(int LightX, int LightY, int LightWidth, int LightHeight, Color LightBorderColor, JFrame window){ //Constructor
        // X , Y , Width, Height, Border Colour, container
        this.setLightBorderColor(LightBorderColor);
        this.setLightWidth(LightWidth);
        this.setLightHeight(LightHeight);
        this.setLightX(LightX);
        this.setLightY(LightY);
        this.drawLight(window);
    }
     
     
     
    public Color getLightFillColor() {
        return LightFillColor;
    }
    public void setLightFillColor(Color LightFillColor) {
        this.LightFillColor = LightFillColor;
    }
     
    public Color getLightBorderColor() {
        return LightBorderColor;
    }
    public void setLightBorderColor(Color LightBorderColor) {
        this.LightBorderColor = LightBorderColor;
    }
 
    public int getLightX() {
        return LightX;
    }
    public void setLightX(int LightX) {
        this.LightX = LightX;
    }
 
    public int getLightY() {
        return LightY;
    }
    public void setLightY(int LightY) {
        this.LightY = LightY;
    }
 
    public int getLightWidth() {
        return LightWidth;
    }
    public void setLightWidth(int LightWidth) {
        this.LightWidth = LightWidth;
    }
 
     
    public int getLightHeight() {
        return LightHeight;
    }
    public void setLightHeight(int LightHeight) {
        this.LightHeight = LightHeight;
    }
 
 
    public void drawLight(JFrame frame) 
    {
        frame.getContentPane().add(new MyComponent());
    }
 
    public void drawMultipleLights(JFrame frame, Light[] Lights)
    {
        LightArray = Lights;
        frame.getContentPane().add(new MyComponent2());
    }
    private class MyComponent extends JComponent{
        public void paintComponent(Graphics g){
             
            if (fillLight) //Fill first, and then draw outline.
            {
                g.setColor(LightFillColor);
                g.fillOval(getLightX(),getLightY(), getLightHeight(),getLightWidth());
            }
             
            g.setColor(getLightBorderColor());
            g.drawOval(getLightX(),getLightY(), getLightHeight(),getLightWidth());
             
        }
    }
     
    private class MyComponent2 extends JComponent{
        public void paintComponent(Graphics g){
             
            for (int i = 0; i < LightArray.length; i++)
            {
                if (LightArray[i].fillLight) //Fill first, and then draw outline.
                {
                    g.setColor(LightArray[i].LightFillColor);
                    g.fillOval(LightArray[i].getLightX(),LightArray[i].getLightY(), LightArray[i].getLightHeight(),LightArray[i].getLightWidth());
                }
                 
                g.setColor(LightArray[i].getLightBorderColor());
                g.drawOval(LightArray[i].getLightX(),LightArray[i].getLightY(), LightArray[i].getLightHeight(),LightArray[i].getLightWidth());
            }
        }
    }
     
     
 
 
}