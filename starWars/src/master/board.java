package master;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class board extends JPanel implements ActionListener {
    boolean darth1, darth2, darth3, darth4, darth5, ky1, ky2, ky3, ky4, ky5, stp1, stp2, stp3, stp4, stp5, mYoda, luke;

    private Stormtrooper s1;
    private Stormtrooper s2;
    private Stormtrooper s3;
    private Stormtrooper s4;
    private Stormtrooper s5;
    private DarthVader d1;
    private DarthVader d3;
    private DarthVader d4;
    private DarthVader d2;
    private DarthVader d5;
    private KyloRen kyloRen1, kyloRen2, kyloRen3, kyloRen4, kyloRen5;
    int a;
    private Timer timer;
    private harita h;
    private Karakter k;
    private MasterYoda masterYoda;
    ArrayList<Vertex> path;
    ArrayList<Vertex> path2;
    ArrayList<Vertex> path3;
    ArrayList<Vertex> path4;
    ArrayList<Vertex> path5;
    ArrayList<Vertex> path6;
    ArrayList<Vertex> path7;
    ArrayList<Vertex> path8;
    ArrayList<Vertex> path9;
    ArrayList<Vertex> path10;
    ArrayList<Vertex> path11;
    ArrayList<Vertex> path12;
    ArrayList<Vertex> path13;
    ArrayList<Vertex> path14;
    ArrayList<Vertex> path15;
    int saglıkBar, yarımSaglik,lukeSaglikBar;



    private boolean win = false;
    private String mesaj = "";
    private Font font = new Font("a", Font.BOLD, 48);
    File file, file2;
    FileReader fr, fr2;
    BufferedReader read, read2;
    Graph g, g2;
    enKisaYol e, e2;
    Vertex[] vertexss, vertexss2;
    Image doluCan;
    Image yarımCan;
    Image bosCan;


    public board() throws IOException {

        ImageIcon img = new ImageIcon("fullheart.png");
        doluCan = img.getImage();
        ImageIcon img2 = new ImageIcon("halfhearth.png");
        yarımCan = img2.getImage();
        img = new ImageIcon("heart.png");
        bosCan = img.getImage();
        h = new harita();
        k = new Karakter();
        masterYoda = new MasterYoda();
        addKeyListener(new Al());
        setFocusable(true);
        timer = new Timer(25, this);
        timer.start();
        file = new File("graf.txt");
        fr = new FileReader(file);
        read = new BufferedReader(fr);
        String s, str2;
        g = new Graph();
        g2 = new Graph();
        vertexss = new Vertex[156];
        vertexss2 = new Vertex[156];
        for (int i = 0; i < 156; i++) {
            String a = Integer.toString(i);
            vertexss[i] = g.addVertex(a);
        }
        for (int i = 0; i < 156; i++) {
            String a = Integer.toString(i);
            vertexss2[i] = g2.addVertex(a);
        }
        int[] dizi = new int[3];
        while ((s = read.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(s, ",");

            while (st.hasMoreTokens()) {


                for (int i = 0; i < 3; i++) {
                    String a = st.nextToken();

                    dizi[i] = Integer.parseInt(a);

                }

                g.addEdge(vertexss[dizi[0]], vertexss[dizi[1]], dizi[2]);
                e = new enKisaYol(g);


            }

        }
        file2 = new File("darthgraf.txt");
        fr2 = new FileReader(file2);
        read2 = new BufferedReader(fr2);
        while ((str2 = read2.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(str2, ",");

            while (st.hasMoreTokens()) {


                for (int i = 0; i < 3; i++) {
                    String a = st.nextToken();

                    dizi[i] = Integer.parseInt(a);

                }

                g2.addEdge(vertexss2[dizi[0]], vertexss2[dizi[1]], dizi[2]);
                e2 = new enKisaYol(g2);


            }

        }


        for (int i = 0; i < h.getKotuKarakter().size(); i++) {

            if (h.getKotuKarakter().get(i).toString().equals("Stormtrooper") && h.getGirisKapisi().get(i).toString().equals("A")) {
                s1 = new Stormtrooper(0, 5);
                stp1 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("Stormtrooper") && h.getGirisKapisi().get(i).toString().equals("B")) {
                s2 = new Stormtrooper(4, 0);
                stp2 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("Stormtrooper") && h.getGirisKapisi().get(i).toString().equals("C")) {
                s3 = new Stormtrooper(12, 0);
                stp3 = true;
            }
            if (h.getKotuKarakter().get(i).toString().equals("Stormtrooper") && h.getGirisKapisi().get(i).toString().equals("D")) {
                s4 = new Stormtrooper(13, 5);
                stp4 = true;
            }
            if (h.getKotuKarakter().get(i).toString().equals("Stormtrooper") && h.getGirisKapisi().get(i).toString().equals("E")) {
                s5 = new Stormtrooper(4, 10);
                stp5 = true;
            }
            if (h.getKotuKarakter().get(i).toString().equals("DarthVader") && h.getGirisKapisi().get(i).toString().equals("A")) {
                d1 = new DarthVader(0, 5);
                darth1 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("DarthVader") && h.getGirisKapisi().get(i).toString().equals("B")) {
                d2 = new DarthVader(4, 0);
                darth2 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("DarthVader") && h.getGirisKapisi().get(i).toString().equals("C")) {
                d3 = new DarthVader(12, 0);
                darth3 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("DarthVader") && h.getGirisKapisi().get(i).toString().equals("D")) {
                d4 = new DarthVader(13, 5);
                darth4 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("DarthVader") && h.getGirisKapisi().get(i).toString().equals("E")) {
                d5 = new DarthVader(4, 10);
                darth5 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("KyloRen") && h.getGirisKapisi().get(i).toString().equals("A")) {
                kyloRen1 = new KyloRen(0, 5);
                ky1 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("KyloRen") && h.getGirisKapisi().get(i).toString().equals("B")) {
                kyloRen2 = new KyloRen(4, 0);
                ky2 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("KyloRen") && h.getGirisKapisi().get(i).toString().equals("C")) {
                kyloRen3 = new KyloRen(12, 0);
                ky3 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("KyloRen") && h.getGirisKapisi().get(i).toString().equals("D")) {
                kyloRen4 = new KyloRen(13, 5);
                ky4 = true;

            }
            if (h.getKotuKarakter().get(i).toString().equals("KyloRen") && h.getGirisKapisi().get(i).toString().equals("E")) {
                kyloRen5 = new KyloRen(4, 10);
                ky5 = true;

            }
        }
    }

    int lukeSayac = 0;
    int lukeKontrol = 0;
    int yodaSayac = 0;
    int yodaKontrol = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if ((h.getMap(k.getKaroX(), k.getKaroY()).equals("l"))) {
            mesaj = "Kazandınız.";
            win = true;
        }
        if (luke) {
            if (stp1) {
                if (k.getKaroX() == s1.getX() && k.getKaroY() == s1.getY()) {
                    lukeSayac++;
                    sifirla();
                    s1.setX(0);
                    s1.setY(5);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (stp2) {
                if (k.getKaroX() == s2.getX() && k.getKaroY() == s2.getY()) {
                    lukeSayac++;
                    sifirla();
                    s2.setX(4);
                    s2.setY(0);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (stp3) {
                if (k.getKaroX() == s3.getX() && k.getKaroY() == s3.getY()) {
                    lukeSayac++;
                    sifirla();
                    s3.setX(12);
                    s3.setY(0);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (stp4) {
                if (k.getKaroX() == s4.getX() && k.getKaroY() == s4.getY()) {
                    lukeSayac++;
                    sifirla();
                    s4.setX(13);
                    s4.setY(5);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (stp5) {
                if (k.getKaroX() == s5.getX() && k.getKaroY() == s5.getY()) {
                    lukeSayac++;
                    sifirla();
                    s5.setX(4);
                    s5.setY(10);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }

            if (ky1) {
                if (k.getKaroX() == kyloRen1.getX() && k.getKaroY() == kyloRen1.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen1.setX(0);
                    kyloRen1.setY(5);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (ky2) {
                if (k.getKaroX() == kyloRen2.getX() && k.getKaroY() == kyloRen2.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen2.setX(4);
                    kyloRen2.setY(0);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (ky3) {
                if (k.getKaroX() == kyloRen3.getX() && k.getKaroY() == kyloRen3.getY()) {
                    lukeSayac++;
                    sifirla();
                    sifirla();
                    kyloRen3.setX(12);
                    kyloRen3.setY(0);
                    k.setKaroX(6);
                    k.setKaroY(5);

                    System.out.println(lukeSayac);
                }

            }
            if (ky4) {
                if (k.getKaroX() == kyloRen4.getX() && k.getKaroY() == kyloRen4.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen4.setX(13);
                    kyloRen4.setY(5);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (ky5) {
                if (k.getKaroX() == kyloRen5.getX() && k.getKaroY() == kyloRen5.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen5.setX(4);
                    kyloRen5.setY(10);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }

            if (darth1) {
                if (k.getKaroX() == d1.getX() && k.getKaroY() == d1.getY()) {
                    lukeSayac++;
                    sifirla();
                    d1.setX(0);
                    d1.setY(5);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth2) {
                if (k.getKaroX() == d2.getX() && k.getKaroY() == d2.getY()) {
                    lukeSayac++;
                    sifirla();
                    d2.setX(4);
                    d2.setY(0);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth3) {
                if (k.getKaroX() == d3.getX() && k.getKaroY() == d3.getY()) {
                    lukeSayac++;
                    sifirla();
                    d3.setX(12);
                    d3.setY(0);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth4) {
                if (k.getKaroX() == d4.getX() && k.getKaroY() == d4.getY()) {
                    lukeSayac++;
                    sifirla();
                    d4.setX(13);
                    d4.setY(5);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth5) {
                if (k.getKaroX() == d5.getX() && k.getKaroY() == d5.getY()) {
                    lukeSayac++;
                    sifirla();
                    d5.setX(4);
                    d5.setY(10);
                    k.setKaroX(6);
                    k.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }

        }
        if (mYoda) {
            if ((h.getMap(masterYoda.getKaroX(), masterYoda.getKaroY()).equals("l"))) {
                mesaj = "Kazandınız.";
                win = true;
            }
            if (stp1) {
                if (masterYoda.getKaroX() == s1.getX() && masterYoda.getKaroY() == s1.getY()) {
                    lukeSayac++;
                    sifirla();
                    s1.setX(0);
                    s1.setY(5);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (stp2) {
                if (masterYoda.getKaroX() == s2.getX() && masterYoda.getKaroY() == s2.getY()) {
                    lukeSayac++;
                    sifirla();
                    s2.setX(4);
                    s2.setY(0);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (stp3) {
                if (masterYoda.getKaroX() == s3.getX() && masterYoda.getKaroY() == s3.getY()) {
                    lukeSayac++;
                    sifirla();
                    s3.setX(12);
                    s3.setY(0);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (stp4) {
                if (masterYoda.getKaroX() == s4.getX() && masterYoda.getKaroY() == s4.getY()) {
                    lukeSayac++;
                    sifirla();
                    s4.setX(13);
                    s4.setY(5);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (stp5) {
                if (masterYoda.getKaroX() == s5.getX() && masterYoda.getKaroY() == s5.getY()) {
                    lukeSayac++;
                    sifirla();
                    s5.setX(4);
                    s5.setY(10);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }

            if (ky1) {
                if (masterYoda.getKaroX() == kyloRen1.getX() && masterYoda.getKaroY() == kyloRen1.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen1.setX(0);
                    kyloRen1.setY(5);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (ky2) {
                if (masterYoda.getKaroX() == kyloRen2.getX() && masterYoda.getKaroY() == kyloRen2.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen2.setX(4);
                    kyloRen2.setY(0);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }
            }

            if (ky3) {
                if (masterYoda.getKaroX() == kyloRen3.getX() && masterYoda.getKaroY() == kyloRen3.getY()) {
                    lukeSayac++;
                    sifirla();
                    sifirla();
                    kyloRen3.setX(12);
                    kyloRen3.setY(0);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);

                    System.out.println(lukeSayac);
                }

            }
            if (ky4) {
                if (masterYoda.getKaroX() == kyloRen4.getX() && masterYoda.getKaroY() == kyloRen4.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen4.setX(13);
                    kyloRen4.setY(5);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (ky5) {
                if (masterYoda.getKaroX() == kyloRen5.getX() && masterYoda.getKaroY() == kyloRen5.getY()) {
                    lukeSayac++;
                    sifirla();
                    kyloRen5.setX(4);
                    kyloRen5.setY(10);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }

            if (darth1) {
                if (masterYoda.getKaroX() == d1.getX() && masterYoda.getKaroY() == d1.getY()) {
                    lukeSayac++;
                    sifirla();
                    d1.setX(0);
                    d1.setY(5);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth2) {
                if (masterYoda.getKaroX() == d2.getX() && masterYoda.getKaroY() == d2.getY()) {
                    lukeSayac++;
                    sifirla();
                    d2.setX(4);
                    d2.setY(0);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth3) {
                if (masterYoda.getKaroX() == d3.getX() && masterYoda.getKaroY() == d3.getY()) {
                    lukeSayac++;
                    sifirla();
                    d3.setX(12);
                    d3.setY(0);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth4) {
                if (masterYoda.getKaroX() == d4.getX() && masterYoda.getKaroY() == d4.getY()) {
                    lukeSayac++;
                    sifirla();
                    d4.setX(13);
                    d4.setY(5);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }
            if (darth5) {
                if (masterYoda.getKaroX() == d5.getX() && masterYoda.getKaroY() == d5.getY()) {
                    lukeSayac++;
                    sifirla();
                    d5.setX(4);
                    d5.setY(10);
                    masterYoda.setKaroX(6);
                    masterYoda.setKaroY(5);
                    System.out.println(lukeSayac);
                }

            }

        }


        if (lukeKontrol == 0) {
            lukeSaglikBar = 3;
        }
        if (lukeKontrol == 1) {
            lukeSaglikBar = 2;
        }
        if (lukeKontrol == 2) {
            lukeSaglikBar = 1;

        }
        if (lukeKontrol == 3) {
            lukeSaglikBar = 0;
            mesaj = "oyun bitti";
            win = true;
        }
        if (yodaKontrol == 0) {
            saglıkBar = 3;
            yarımSaglik = 0;
        }
        if (yodaKontrol == 1) {
            saglıkBar = 2;
            yarımSaglik = 1;
        }
        if (yodaKontrol == 2) {
            saglıkBar = 2;
            yarımSaglik = 0;
        }
        if (yodaKontrol == 3) {
            saglıkBar = 1;
            yarımSaglik = 1;
        }
        if (yodaKontrol == 4) {
            saglıkBar = 1;
            yarımSaglik = 0;
        }
        if (yodaKontrol == 5) {
            saglıkBar = 0;
            yarımSaglik = 1;
        }
        if (yodaKontrol == 6) {
            mesaj = "oyun bitti";
            win = true;
        }


        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        if (!win) {
            for (int y = 0; y < 11; y++) {
                for (int x = 0; x < 14; x++) {
                    if (h.getMap(x, y).equals("1"))
                        g.drawImage(h.getYol(), x * 32, y * 32, null);
                    if (h.getMap(x, y).equals("0"))
                        g.drawImage(h.getDuvar(), x * 32, y * 32, null);
                    if (h.getMap(x, y).equals("l"))
                        g.drawImage(h.getBitis(), x * 32, y * 32, null);
                    if (!luke && !mYoda) {
                        g.drawImage(k.getOyuncu(), 16 * 32, 6 * 32, null);
                        g.drawImage(masterYoda.getMasterYoda(), 16 * 32, 8 * 32, null);
                    }

                }
            }
            if (luke) {
                System.out.println(lukeSaglikBar);
                for (int i = 0; i < lukeSaglikBar; i++) {
                    g.drawImage(doluCan, (15 + i) * 32, 0, null);
                    a = (14 * k.getKaroY()) + k.getKaroX() + 1;
                }

            }
            if (mYoda) {
                for (int i = 0; i < saglıkBar; i++) {
                    g.drawImage(doluCan, (15 + i) * 32, 0, null);

                    a = (14 * masterYoda.getKaroY()) + masterYoda.getKaroX() + 1;
                }
                for (int i = 0; i < yarımSaglik; i++) {
                    g.drawImage(yarımCan, (15 + saglıkBar) * 32, 0 * 32, null);
//                            a = (14 * masterYoda.getKaroY()) + masterYoda.getKaroX() + 1;
                }
                System.out.println(saglıkBar);
            }


            if (stp1) {
                int a1 = (14 * s1.getY()) + s1.getX() + 1;
                path = e.shortestPath(vertexss[a1], vertexss[a]);

                for (int i = 0; i < path.size() - 1; i++) {
                    int x = (Integer.parseInt(path.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path.get(i).getName()) / 14;
                    g.setColor(Color.red);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        lukeKontrol++;
                        sifirla();
                        s1.setX(0);
                        s1.setY(5);
                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        yodaKontrol++;
//                        s1.setX(0);
//                        s1.setY(5);
                        sifirla();
                        yodaSayac = 0;

                    }
                    g.drawImage(s1.getStormTropper(), s1.getX() * 32, s1.getY() * 32, null);
                }


            }
            if (stp2) {
                int a2 = (14 * s2.getY()) + s2.getX() + 1;
                path2 = e.shortestPath(vertexss[a2], vertexss[a]);
                for (int i = 0; i < path2.size(); i++) {
                    int x = (Integer.parseInt(path2.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path2.get(i).getName()) / 14;
                    g.setColor(Color.green);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {

                        lukeKontrol++;
                        sifirla();

                        s2.setX(4);
                        s2.setY(0);

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {

                        yodaKontrol++;

                        sifirla();
                        s2.setX(4);
                        s2.setY(0);

                        yodaSayac = 0;

                    }
                    g.drawImage(s2.getStormTropper(), s2.getX() * 32, s2.getY() * 32, null);
                }
            }
            if (stp3) {
                int a2 = (14 * s3.getY()) + s3.getX() + 1;
                path3 = e.shortestPath(vertexss[a2], vertexss[a]);
                for (int i = 0; i < path3.size() - 1; i++) {
                    int x = (Integer.parseInt(path3.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path3.get(i).getName()) / 14;
                    g.setColor(Color.blue);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {

                        s3.setX(12);
                        s3.setY(0);
                        sifirla();
                        lukeKontrol++;
                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        s3.setX(12);
                        s3.setY(0);
                        sifirla();
                        yodaKontrol++;
                        yodaSayac = 0;

                    }

                    g.drawImage(s3.getStormTropper(), s3.getX() * 32, s3.getY() * 32, null);
                }
            }
            if (stp4) {
                int a2 = (14 * s4.getY()) + s4.getX() + 1;
                path4 = e.shortestPath(vertexss[a2], vertexss[a]);
                for (int i = 0; i < path4.size(); i++) {
                    int x = (Integer.parseInt(path4.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path4.get(i).getName()) / 14;
                    g.setColor(Color.pink);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        s4.setX(13);
                        s4.setY(5);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        s4.setX(13);
                        s4.setY(5);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(s4.getStormTropper(), s4.getX() * 32, s4.getY() * 32, null);
                }
            }
            if (stp5) {
                int a2 = (14 * s5.getY()) + s5.getX() + 1;
                path5 = e.shortestPath(vertexss[a2], vertexss[a]);
                for (int i = 0; i < path5.size(); i++) {
                    int x = (Integer.parseInt(path5.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path5.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        s5.setX(4);
                        s5.setY(10);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }

                    if (yodaSayac == 1) {
                        s5.setX(4);
                        s5.setY(10);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(s5.getStormTropper(), s5.getX() * 32, s5.getY() * 32, null);
                }
            }
            if (ky1) {
                int a2 = (14 * kyloRen1.getY()) + kyloRen1.getX() + 1;
                path6 = e.shortestPath(vertexss[a2], vertexss[a]);
                for (int i = 0; i < path6.size(); i++) {
                    int x = (Integer.parseInt(path6.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path6.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        kyloRen1.setX(0);
                        kyloRen1.setY(5);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }

                    if (yodaSayac == 1) {
                        kyloRen1.setX(0);
                        kyloRen1.setY(5);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(kyloRen1.getKyloren(), kyloRen1.getX() * 32, kyloRen1.getY() * 32, null);
                }
            }
            if (ky2) {
                int a2 = (14 * kyloRen2.getY()) + kyloRen2.getX() + 1;
                path7 = e.shortestPath(vertexss[a2], vertexss[a]);

                for (int i = 0; i < path7.size(); i++) {
                    int x = (Integer.parseInt(path7.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path7.get(i).getName()) / 14;
                    System.out.println(path7.get(i).getName());
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        kyloRen2.setX(4);
                        kyloRen2.setY(0);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        kyloRen2.setX(4);
                        kyloRen2.setY(0);
                        sifirla();

                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(kyloRen2.getKyloren(), kyloRen2.getX() * 32, kyloRen2.getY() * 32, null);
                }
            }
            if (ky3) {
                int a2 = (14 * kyloRen3.getY()) + kyloRen3.getX() + 1;
                path8 = e.shortestPath(vertexss[a2], vertexss[a]);

                for (int i = 0; i < path8.size(); i++) {
                    int x = (Integer.parseInt(path8.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path8.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        kyloRen3.setX(12);
                        kyloRen3.setY(0);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        kyloRen3.setX(12);
                        kyloRen3.setY(0);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(kyloRen3.getKyloren(), kyloRen3.getX() * 32, kyloRen3.getY() * 32, null);
                }


            }
            if (ky4) {
                int a2 = (14 * kyloRen4.getY()) + kyloRen4.getX() + 1;
                path9 = e.shortestPath(vertexss[a2], vertexss[a]);
                for (int i = 0; i < path9.size(); i++) {
                    int x = (Integer.parseInt(path9.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path9.get(i).getName()) / 14;
                    g.setColor(Color.pink);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        kyloRen4.setX(13);
                        kyloRen4.setY(5);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    } if (yodaSayac == 1) {
                        kyloRen4.setX(13);
                        kyloRen4.setY(5);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(kyloRen4.getKyloren(), kyloRen4.getX() * 32, kyloRen4.getY() * 32, null);
                }
            }
            if (ky5) {
                int a2 = (14 * kyloRen5.getY()) + kyloRen5.getX() + 1;
                path10 = e.shortestPath(vertexss[a2], vertexss[a]);
                for (int i = 0; i < path10.size(); i++) {
                    int x = (Integer.parseInt(path10.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path10.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        kyloRen5.setX(4);
                        kyloRen5.setY(10);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        kyloRen5.setX(4);
                        kyloRen5.setY(10);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(kyloRen5.getKyloren(), kyloRen5.getX() * 32, kyloRen5.getY() * 32, null);
                }

            }
            if (darth1) {
                int a2 = (14 * d1.getY()) + d1.getX() + 1;
                path11 = e2.shortestPath(vertexss2[a2], vertexss2[a]);
                for (int i = 0; i < path11.size(); i++) {
                    int x = (Integer.parseInt(path11.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path11.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        d1.setX(0);
                        d1.setY(5);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        d1.setX(0);
                        d1.setY(5);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(d1.getDarthvader(), d1.getX() * 32, d1.getY() * 32, null);
                }

            }
            if (darth2) {
                int a2 = (14 * d2.getY()) + d2.getX() + 1;
                path12 = e2.shortestPath(vertexss2[a2], vertexss2[a]);
                for (int i = 0; i < path12.size(); i++) {
                    int x = (Integer.parseInt(path12.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path12.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        lukeKontrol++;

                        d2.setX(4);
                        d2.setY(0);
                        sifirla();

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        yodaKontrol++;

                        d2.setX(4);
                        d2.setY(0);
                        sifirla();

                        yodaSayac = 0;

                    }
                    g.drawImage(d2.getDarthvader(), d2.getX() * 32, d2.getY() * 32, null);
                }

            }
            if (darth3) {
                int a2 = (14 * d3.getY()) + d3.getX() + 1;
                path13 = e2.shortestPath(vertexss2[a2], vertexss2[a]);
                for (int i = 0; i < path13.size(); i++) {
                    int x = (Integer.parseInt(path13.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path13.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        d3.setX(12);
                        d3.setY(0);

                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        d3.setX(12);
                        d3.setY(0);

                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(d3.getDarthvader(), d3.getX() * 32, d3.getY() * 32, null);
                }

            }
            if (darth4) {
                int a2 = (14 * d4.getY()) + d4.getX() + 1;
                path14 = e2.shortestPath(vertexss2[a2], vertexss2[a]);
                for (int i = 0; i < path14.size(); i++) {
                    int x = (Integer.parseInt(path14.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path14.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        d4.setX(13);
                        d4.setY(5);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        d4.setX(13);
                        d4.setY(5);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(d4.getDarthvader(), d4.getX() * 32, d4.getY() * 32, null);
                }

            }
            if (darth5) {
                int a2 = (14 * d5.getY()) + d5.getX() + 1;
                path15 = e2.shortestPath(vertexss2[a2], vertexss2[a]);
                for (int i = 0; i < path15.size(); i++) {
                    int x = (Integer.parseInt(path15.get(i).getName()) % 14) - 1;
                    int y = Integer.parseInt(path15.get(i).getName()) / 14;
                    g.setColor(Color.yellow);
                    g.fillRect(x * 32, y * 32, 32, 32);
                    if (lukeSayac == 1) {
                        d5.setX(4);
                        d5.setY(10);
                        sifirla();
                        lukeKontrol++;

                        lukeSayac = 0;

                    }
                    if (yodaSayac == 1) {
                        d5.setX(4);
                        d5.setY(10);
                        sifirla();
                        yodaKontrol++;

                        yodaSayac = 0;

                    }
                    g.drawImage(d5.getDarthvader(), d5.getX() * 32, d5.getY() * 32, null);
                }

            }

            if (luke) {
                g.drawImage(k.getOyuncu(), k.getKaroX() * 32, k.getKaroY() * 32, null);
                System.out.println(lukeKontrol);
            }
            if (mYoda) {
                g.drawImage(masterYoda.getMasterYoda(), masterYoda.getKaroX() * 32, masterYoda.getKaroY() * 32, null);
                System.out.println(yodaKontrol);

            }


        }
        if (win) {
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(mesaj, 150, 300);

        }


    }

    public int takip = 1;

    public void sifirla() {
        if (stp1) {
            s1.setX(0);
            s1.setY(5);
        }

        if (stp2) {
            s2.setX(4);
            s2.setY(0);
        }

        if (stp3) {
            if (k.getKaroX() == s3.getX() && k.getKaroY() == s3.getY()) {
                s3.setX(12);
                s3.setY(0);
            }

        }
        if (stp4) {
            s4.setX(13);
            s4.setY(5);

        }
        if (stp5) {
            s5.setX(4);
            s5.setY(10);

        }

        if (ky1) {
            kyloRen1.setX(0);
            kyloRen1.setY(5);
        }

        if (ky2) {
            kyloRen2.setX(4);
            kyloRen2.setY(0);
        }

        if (ky3) {
            kyloRen3.setX(12);
            kyloRen3.setY(0);

        }
        if (ky4) {
            kyloRen4.setX(13);
            kyloRen4.setY(5);

        }
        if (ky5) {
            kyloRen5.setX(4);
            kyloRen5.setY(10);

        }

        if (darth1) {
            d1.setX(0);
            d1.setY(5);

        }
        if (darth2) {
            d2.setX(4);
            d2.setY(0);

        }
        if (darth3) {
            d3.setX(12);
            d3.setY(0);

        }
        if (darth4) {
            d4.setX(13);
            d4.setY(5);

        }
        if (darth5) {
            d5.setX(4);
            d5.setY(10);

        }
    }

    public class Al extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            if (keycode == KeyEvent.VK_W) {
                if ((!h.getMap(k.getKaroX(), k.getKaroY() - 1).equals("0")) && luke) {
                    k.move(0, -1);

                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }
                    }
                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }

                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }

                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;
                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;

                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            ++lukeSayac;

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }
                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }
                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }
                if ((!h.getMap(masterYoda.getKaroX(), masterYoda.getKaroY() - 1).equals("0")) && mYoda) {
                    masterYoda.move(0, -1);
                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;
                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }
                    }
                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }
                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }
                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;
                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;

                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }

                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }
                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }


            }

            if (keycode == KeyEvent.VK_S) {
                if ((!h.getMap(k.getKaroX(), k.getKaroY() + 1).equals("0")) && luke) {
                    k.move(0, 1);
                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {

                            lukeSayac++;
                            sifirla();
                            lukeSayac = 0;
                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }


                    }
                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }

                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }

                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;

                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {

                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;
                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();
                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();
                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }

                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }

                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }
                if ((!h.getMap(masterYoda.getKaroX(), masterYoda.getKaroY() + 1).equals("0")) && mYoda) {
                    masterYoda.move(0, 1);
                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }
                    }
                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }
                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }
                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;
                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;

                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }

                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }
                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }
            }

            if (keycode == KeyEvent.VK_A) {
                if ((!h.getMap(k.getKaroX() - 1, k.getKaroY()).equals("0")) && luke) {
                    k.move(-1, 0);
                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }


                    }
                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }

                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }

                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;

                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {

                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;
                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();
                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }
                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }
                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }
                if ((!h.getMap(masterYoda.getKaroX() - 1, masterYoda.getKaroY()).equals("0")) && mYoda) {
                    masterYoda.move(-1, 0);
                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;
                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }
                    }
                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }
                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }
                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;
                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;

                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }

                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }
                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }

            }

            if (keycode == KeyEvent.VK_D) {
                if ((!h.getMap(k.getKaroX() + 1, k.getKaroY()).equals("0")) && luke) {
                    k.move(1, 0);
                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }


                    }

                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }

                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }

                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;

                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {

                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;
                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();
                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();
                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();
                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }
                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }

                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (k.getKaroX() == x && k.getKaroY() == y || (k.getKaroX() == x2 && k.getKaroY() == y2) || (k.getKaroX() == x3 && k.getKaroY() == y3)) {
                            lukeSayac++;
                            sifirla();

                            k.setKaroX(6);
                            k.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }
                if ((!h.getMap(masterYoda.getKaroX() + 1, masterYoda.getKaroY()).equals("0")) && mYoda) {
                    masterYoda.move(1, 0);
                    int x;
                    int y;
                    if (stp1) {
                        takip = 1;
                        x = (Integer.parseInt(path.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s1.setX(x);
                            s1.setY(y);
                        }
                    }
                    if (stp2) {
                        takip = 1;
                        x = (Integer.parseInt(path2.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path2.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path2.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path2.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path2.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path2.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;
                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s2.setX(x);
                            s2.setY(y);
                        }
                    }
                    if (stp3) {
                        takip = 1;
                        x = (Integer.parseInt(path3.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path3.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path3.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path3.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path3.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path3.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s3.setX(x);
                            s3.setY(y);
                        }
                    }
                    if (stp4) {
                        takip = 1;
                        x = (Integer.parseInt(path4.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path4.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path4.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path4.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path4.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path4.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;


                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);

                        } else {
                            s4.setX(x);
                            s4.setY(y);
                        }
                    }
                    if (stp5) {
                        takip = 1;
                        x = (Integer.parseInt(path5.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path5.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path5.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path5.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path5.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path5.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            s5.setX(x);
                            s5.setY(y);
                        }

                    }
                    if (ky1) {
                        takip = 2;
                        x = (Integer.parseInt(path6.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path6.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path6.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path6.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path6.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path6.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen1.setX(x);
                            kyloRen1.setY(y);
                        }

                    }
                    if (ky2) {
                        takip = 2;
                        x = (Integer.parseInt(path7.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path7.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path7.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path7.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path7.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path7.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen2.setX(x);
                            kyloRen2.setY(y);
                        }

                    }
                    if (ky3) {
                        takip = 2;

                        x = (Integer.parseInt(path8.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path8.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path8.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path8.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path8.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path8.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen3.setX(x);
                            kyloRen3.setY(y);
                        }

                    }
                    if (ky4) {
                        takip = 2;
                        x = (Integer.parseInt(path9.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path9.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path9.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path9.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path9.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path9.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen4.setX(x);
                            kyloRen4.setY(y);
                        }

                    }
                    if (ky5) {
                        takip = 2;
                        x = (Integer.parseInt(path10.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path10.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path10.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path10.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path10.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path10.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            kyloRen5.setX(x);
                            kyloRen5.setY(y);
                        }

                    }

                    if (darth1) {
                        takip = 1;
                        x = (Integer.parseInt(path11.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path11.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path11.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path11.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path11.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path11.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d1.setX(x);
                            d1.setY(y);
                        }

                    }
                    if (darth2) {
                        takip = 1;
                        x = (Integer.parseInt(path12.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path12.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path12.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path12.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path12.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path12.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d2.setX(x);
                            d2.setY(y);
                        }


                    }
                    if (darth3) {
                        takip = 1;
                        x = (Integer.parseInt(path13.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path13.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path13.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path13.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path13.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path13.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d3.setX(x);
                            d3.setY(y);
                        }


                    }
                    if (darth4) {
                        takip = 1;
                        x = (Integer.parseInt(path14.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path14.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path14.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path14.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path14.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path14.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d4.setX(x);
                            d4.setY(y);
                        }


                    }
                    if (darth5) {
                        takip = 1;
                        x = (Integer.parseInt(path15.get(takip).getName()) % 14) - 1;
                        y = Integer.parseInt(path15.get(takip).getName()) / 14;
                        int x3 = (Integer.parseInt(path15.get(0).getName()) % 14) - 1;
                        int y3 = Integer.parseInt(path15.get(0).getName()) / 14;
                        int x2 = (Integer.parseInt(path15.get(1).getName()) % 14) - 1;
                        int y2 = Integer.parseInt(path15.get(1).getName()) / 14;
                        if (masterYoda.getKaroX() == x && masterYoda.getKaroY() == y || (masterYoda.getKaroX() == x2 && masterYoda.getKaroY() == y2) || (masterYoda.getKaroX() == x3 && masterYoda.getKaroY() == y3)) {
                            yodaSayac++;

                            masterYoda.setKaroX(6);
                            masterYoda.setKaroY(5);
                            System.out.println(lukeSayac);
                        } else {
                            d5.setX(x);
                            d5.setY(y);
                        }


                    }
                }

            }

            if (keycode == KeyEvent.VK_L) {
                luke = true;
                mYoda = false;
            }

            if (keycode == KeyEvent.VK_M) {
                luke = false;
                mYoda = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }
    }
}
