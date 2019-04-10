package master;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Stormtrooper extends Karakter{
    private harita h1=new harita();

    public Image getStormTropper() {
        return stormTropper;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y;

    private Image stormTropper;
    public Stormtrooper(int i,int j) throws IOException {
       ImageIcon img=new ImageIcon("Stormtrooper.png");
        stormTropper=img.getImage();
        x=i;
        y=j;

    }
}
