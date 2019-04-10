package master;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class harita {
    String line;
    String[] harita = new String[11];
    String oku;
private   ArrayList KotuKarakter = new ArrayList();

    public ArrayList getKotuKarakter() {
        return KotuKarakter;
    }

    public ArrayList getGirisKapisi() {
        return GirisKapisi;
    }

    private ArrayList GirisKapisi = new ArrayList();
    File file1;
    FileReader fileReader;
    BufferedReader br;
    private Image duvar;
    private Image yol;


    public Graph getG() {
        return g;
    }

    private Graph g;

    public Image getBitis() {
        return bitis;
    }

    private Image bitis;



    public Image getDuvar() {
        return duvar;
    }


    public Image getYol() {
        return yol;
    }





    public String getMap(int x,int y){
        String index=harita[y].substring(x,x+1);
        return index;
    }

    public harita() throws IOException {

        ImageIcon img=new ImageIcon("brick.png");
        duvar=img.getImage();
        img=new ImageIcon("rectangle.png");
        yol=img.getImage();
        img=new ImageIcon("cup.png");
        bitis=img.getImage();


        dosyaAc();
        dosyaOku();
        dosyaKapat();
    }

    public void dosyaAc() {
        try {
            file1 = new File("harita.txt");
            fileReader = new FileReader(file1);
            br = new BufferedReader(fileReader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dosyaOku() throws IOException {
        int x = 0;

        while ((oku = br.readLine()) != null) {

            if (oku.startsWith("K")) {
                KotuKarakter.add(oku.substring(9, oku.indexOf(",")));
                GirisKapisi.add(oku.charAt(oku.length() - 1));
            } else {

                line = oku.replace(" ", "");
                harita[x++] = line;

            }
        }
    }
    public void dosyaKapat() throws IOException {
        br.close();

    }
}
