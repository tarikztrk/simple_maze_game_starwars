package master;

import javax.swing.*;
import java.awt.*;

public class KyloRen {
    private Image kyloren;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    private int x;

    public Image getKyloren() {
        return kyloren;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y;
    KyloRen(int i,int j){
        ImageIcon img=new ImageIcon("kyloren.png");
        kyloren=img.getImage();
        x=i;
        y=j;

    }
}
