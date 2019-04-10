package master;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        new Main();



        }






    public Main() throws IOException {
        JFrame f = new JFrame();
        f.setTitle("STAR WARS");
        f.add(new board());
        f.setSize(600, 450);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
