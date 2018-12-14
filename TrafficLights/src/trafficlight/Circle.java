package trafficlight;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
 
 
public class Circle extends JFrame
{ 
    private Color CircleFillColor;
    private Color CircleBorderColor;
     
    private int CircleX = 0;
    private int CircleY = 0;
    private int CircleWidth = 0;
    private int CircleHeight = 0;
     
    public boolean fillCircle = false;
 
    Circle(){ //Constructor
        CircleBorderColor = Color.black;
    }
 
    Circle(int CircleX, int CircleY, int CircleWidth, int CircleHeight, Color CircleBorderColor){//, JFrame window //Constructor
        // X , Y , Width, Height, Border Colour, container
        this.setCircleBorderColor(CircleBorderColor);
        this.setCircleWidth(CircleWidth);
        this.setCircleHeight(CircleHeight);
        this.setCircleX(CircleX);
        this.setCircleY(CircleY);
        this.drawCircle();
    }
     
    public Color getCircleFillColor() {
        return CircleFillColor;
    }
    public void setCircleFillColor(Color CircleFillColor) {
        this.CircleFillColor = CircleFillColor;
    }
     
    public Color getCircleBorderColor() {
        return CircleBorderColor;
    }
    public void setCircleBorderColor(Color CircleBorderColor) {
        this.CircleBorderColor = CircleBorderColor;
    }
 
    public int getCircleX() {
        return CircleX;
    }
    public void setCircleX(int CircleX) {
        this.CircleX = CircleX;
    }
 
    public int getCircleY() {
        return CircleY;
    }
    public void setCircleY(int CircleY) {
        this.CircleY = CircleY;
    }
 
    public int getCircleWidth() {
        return CircleWidth;
    }
    public void setCircleWidth(int CircleWidth) {
        this.CircleWidth = CircleWidth;
    }     
    public int getCircleHeight() {
        return CircleHeight;
    }
    public void setCircleHeight(int CircleHeight) {
        this.CircleHeight = CircleHeight;
    }
    public void drawCircle() { //JFrame frame
        super.getContentPane().add(new MyComponent());
    } 
    @Override
    public void paint(Graphics g){
        
        if (fillCircle){ //Fill first, and then draw outline.
            g.setColor(CircleFillColor);
            g.fillOval(getCircleX(),getCircleY(), getCircleHeight(),getCircleWidth());
        }
        g.setColor(getCircleBorderColor());
        g.drawOval(getCircleX(),getCircleY(), getCircleHeight(),getCircleWidth());
    }
    private class MyComponent extends JComponent{
        @Override
        public void paintComponents(Graphics g){
            if (fillCircle) //Fill first, and then draw outline.
            {
                g.setColor(CircleFillColor);
                g.fillOval(getCircleX(),getCircleY(), getCircleHeight(),getCircleWidth());
            }
            g.setColor(getCircleBorderColor());
            g.drawOval(getCircleX(),getCircleY(), getCircleHeight(),getCircleWidth());
        }
        
    }
 
 
}