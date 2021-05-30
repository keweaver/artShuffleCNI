
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

/**
 * Program for Cognitive Neuroimaging Lab at Montclair State University
 *
 * Displays a target slide for five seconds, a randomly selected artwork for five seconds, and then a blank buffer
 * slide for five seconds while the participant measures their appreciation of a piece.
 *
 * @author kaylaweaver
 */
public class frameArt {
    static GraphicsConfiguration gc;
    public static void main (String args[]){

        /*
        Array containing all abstract art files
         */

        String[] art = new String[]{
                //"/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Wadsworth-_The_Open_Window.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Soutine-_Landscapeat_Ceret_copy_50.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Popova- Space force construction (5).jpeg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Nicholson-_Feb_29.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Poliakoff- Composition.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Motherwell- Mallarme's Swan.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Motherwell- Chi Ama, Crede.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Mondrian- Oval Composition.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Louis- Number 99.png",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Kupka- Fugue a duex couleurs.png",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Klee- Side Panels for Anatomy of Aphrodite.jpeg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Klee- Orenda Ajada.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Kandinsky- Reciprocal Agreement, 1942.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Kandinsky- Cossacks, 1910.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Kandinsky- Black Lines, 1913.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Kandinsky - Improvisation 19, 1910.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Hodgkin- Dinner in Palazzo Albrizzi .jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Frankenthaler- After 'Mountains And the Sea' 1956-1959.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Frances- Sin Titulo, 1967.png",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Frances- Sin Titulo, 1955.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Fautruer- Tete D'Otage No.jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Delaunay- Windows Open Simultaneously (First Part, Third Motif).jpg",
                "/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/Artworks/Abstract Art/Bella- The Car Has Passed.jpg",
        };

        /*
        Set up of JFrame display
         */
        System.out.println("new trial");
        Artwork artWrks = new Artwork(art);
        JFrame frame = new JFrame(gc);
        //TimeUnit time = TimeUnit.SECONDS;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        //Scanner key = new Scanner(System.in);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        //frame.setSize(height, width);
        frame.setLocationRelativeTo(null);
        ImageIcon target = new ImageIcon(new ImageIcon("/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/sizedTarget.png").getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
        ImageIcon blank = new ImageIcon(new ImageIcon("/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/white.jpg").getImage().getScaledInstance(JFrame.MAXIMIZED_VERT, JFrame.MAXIMIZED_HORIZ, java.awt.Image.SCALE_SMOOTH));
        frame.add(new JLabel(blank));

        /*
         Trial:
         Set target, wait five seconds
         Show random artwork and print to terminal for storage. Wait five seconds.
         Show blank buffer slide. Wait five seconds.

         Repeat ten times (number of rounds of artwork)
         */

        for(int i = 0;i<5;i++){
            //show target
            frame.setContentPane(new JLabel(target));
            frame.setVisible(true);
            //wait for 5 seconds
            try {
                Thread.sleep(5000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            //show random art
            String randArt = artWrks.getArt();
            frame.setContentPane(new JLabel(new ImageIcon(randArt)));
            System.out.println(randArt);
            frame.setVisible(true);
            //press key to white slide

            try {
                Thread.sleep(5000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            frame.setContentPane(new JLabel(blank));
            frame.setVisible(true);
            try {
                Thread.sleep(5000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
        frame.setContentPane(new JLabel(new ImageIcon("/Users/kaylaweaver/Desktop/KEENAN LAB STUDIES/Abs+Rep Art Study Materials/done.jpg")));
        frame.setVisible(true);
        System.out.println("end of trial");
    }
}
