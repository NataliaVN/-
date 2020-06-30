import javax.swing.*;
import java.awt.*;
import sweeper.Box;

public class JavaSweeper extends JFrame {
    private final int IMAGE_SIZE = 50;
    private final int COLS = 15;
    private final int ROWS = 1;

    private JPanel panel;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper() {
        initPanel();
        initFrame();

    }

    private void initPanel() {
        panel = new JPanel()
                // Метод для рисования сразу после создания панели
        {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                for (Box box: Box.values())
                g.drawImage(getImage(box.name().toLowerCase()), box.ordinal() * IMAGE_SIZE, 0, this);



            }
        };
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper by Natali");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("res/img/" + name+ ".png");
        return icon.getImage();
    }

}
