import javax.swing.*;
import java.awt.*;

public class Frame01
{
    public static void main(String[] args){
        SwingUtilities.invokeLater (new Runnable ()
        {
            public void run ()
            {
                JFrame frame = new JFrame("panel demo");
                frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

                JPanel panel = new JPanel();
                Container c = frame.getContentPane();
                panel.setSize(100,100);
                panel.setLayout(new GridLayout(1000,1));
                for(int i = 0; i<1000;i++)
                panel.add(new JLabel("JLabel "+i));

                JScrollPane jsp = new JScrollPane(panel);
                c.add(jsp);
                frame.setSize(100,100);
                frame.setVisible(true);
            }
        });
    }
}