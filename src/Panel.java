import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Panel extends GamePanel{
    Sun sun = new Sun();
    boolean all = false;
    ArrayList<Mercury> planets = new ArrayList<>();

    Info info = new Info();
    boolean drawOrbit = false;
    String text = "";
    int index =0;
    Panel()
    {
        //init info
        initInfo();
        //showOrbit(0);
        this.setBackground(Color.black);
        this.start();
    }

    void initInfo()
    {
        File data = new File("./src/MercuryData");

        try
        {
            Scanner scan = new Scanner(data);
            int it =1 ;
            while(scan.hasNext()&&it<139)
            {
             if(it <47)//DATES
                 info.dates.add(scan.nextLine());
             else if(it<93)
                 info.lengths.add(Double.valueOf(scan.nextLine()));
             else
                 info.angles.add(Integer.valueOf(scan.nextLine()));
             it++;
            }

            System.out.println(info.angles.get(0));
        }catch(Exception e )
        {
            e.printStackTrace();
        }

    }
    @Override
    public void update() {

    }

    @Override
    public void paint(Graphics g) {
        /*super.paintComponents(g);*/

        super.paintComponent(g);
        //g.clearRect(0,0,600,600);
        sun.draw(g);
        System.out.println(info.dates.size());

        for(Mercury planet: planets)
        {
            planet.draw(g);
        }

        Graphics2D g1 = (Graphics2D) g;

        g1.drawString(text, 250,20);
        // draw ellipse
        if(drawOrbit)
            drawEllipse(g1);




    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    void showOrbit(int it) // show one
    {
        Mercury singlePlanet = new Mercury();
        planets.clear();
        double length = 500*info.lengths.get(it);
        double angle = info.angles.get(it);
        singlePlanet.x= (int) (sun.x+(length*Math.cos(Math.toRadians(-angle))));
        singlePlanet.y = (int) (sun.y+(length*Math.sin(Math.toRadians(-angle))));
        singlePlanet.x-=singlePlanet.size/2;
        singlePlanet.y-=singlePlanet.size/2;
        text  = info.dates.get(it)+" | "+info.lengths.get(it)+" | "+info.angles.get(it);
        planets.add(singlePlanet);


    }
    void drawEllipse(Graphics2D g )
    {
        int[] x = new int[46];
        int[] y= new int[46];
        for(int i = 0 ; i<x.length; i++)
        {
            double length = 500*info.lengths.get(i);
            double angle = info.angles.get(i);
            x[i] = (int) (sun.x+(length*Math.cos(Math.toRadians(-angle))));
            y[i] =(int) (sun.y+(length*Math.sin(Math.toRadians(-angle))));

        }
        g.setColor(new Color(255,255,255,40));
        g.drawPolygon(x,y,46);
    }


    /*void showOrbit() // this is to show all of them
    {
        planets.clear();
        if() // meaning first time ; then create all the planets
        {
            for(int i = 0 ; i<info.dates.size(); i++)
            {
                planets.add
            }
        }
        all = true;
    }*/


    @Override
    public void keyPressed(KeyEvent e) {
        // press space shows all

        // press right and left goes backward and forwards through the orbit

        switch (e.getKeyCode())
        {
            case KeyEvent.VK_RIGHT:

                all = false;
                if(index>0)
                    index--;
                else
                    index = info.dates.size()-1;
                showOrbit(index);
                break;

            case KeyEvent.VK_LEFT:
                all = false;
                if(index<info.dates.size()-1)
                    index++;
                else
                    index = 0;
                showOrbit(index);
                break;
            case KeyEvent.VK_SPACE:
                drawOrbit =!drawOrbit;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
