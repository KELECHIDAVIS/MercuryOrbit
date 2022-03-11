import java.awt.*;

public class Sun {
   static   int sunSize = 60 ;
    static int x =(Main.width/2)-sunSize/2 , y = (Main.height/2)-sunSize/2;


    void draw(Graphics g )
    {
        g.setColor(Color.yellow);

        g.fillOval(x, y, sunSize,sunSize);
    }
}
