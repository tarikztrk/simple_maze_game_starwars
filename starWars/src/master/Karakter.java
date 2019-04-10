package master;

import javax.swing.*;
import java.awt.*;

public class Karakter {
    private String Ad;
    private  String tur;

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

    private int KaroX;
    private int KaroY;

    public Image getOyuncu() {
        return oyuncu;
    }

    private Image oyuncu;






    public Karakter() {
        ImageIcon img=new ImageIcon("luke.png");
        oyuncu=img.getImage();

        KaroX=6;
        KaroY=5;
    }

    public void move(int tx,int ty){
        KaroX=KaroX+tx;
        KaroY=KaroY+ty;

    }


}
