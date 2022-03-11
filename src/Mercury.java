import java.awt.*;
import java.util.ArrayList;

public class Mercury {
    ArrayList<Info> data = new ArrayList<>();
    int x ,  y, size=10;

    Mercury ()
    {
        // add all the data
    }
    Mercury(int x , int y)
    {
        this.x = x ;
        this.y = y;
    }


    void update()
    {
        //determine what piece of data they want to look at
        // also have a button thats shows all of the at the same time
    }

    void draw(Graphics g )
    {
        g.setColor(new Color(152,100,38));
        g.fillOval(x,y,size,size);
    }

}
