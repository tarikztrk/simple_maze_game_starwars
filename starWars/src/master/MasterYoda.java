package master;

import javax.swing.*;
import java.awt.*;

public class MasterYoda {
    private Image masterYoda;

    public Image getMasterYoda() {
        return masterYoda;
    }

    public int getKaroX() {
        return KaroX;
    }

    public int getKaroY() {
        return KaroY;
    }

    public void setKaroX(int karoX) {
        KaroX = karoX;
    }

    public void setKaroY(int karoY) {
        KaroY = karoY;
    }

    private int KaroX, KaroY;

    MasterYoda() {
        ImageIcon img = new ImageIcon("masteryoda.png");
        masterYoda = img.getImage();
        KaroX = 6;
        KaroY = 5;

    }

    public void move(int tx, int ty) {
        KaroX += tx;
        KaroY += ty;

    }


}
