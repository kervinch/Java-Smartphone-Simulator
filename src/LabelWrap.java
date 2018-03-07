import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class LabelWrap {

    public static JPanel createPanel() {
        JLabel label = new JLabel();
        label.setText("<html>"
            + "<h3>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</h3>"
            + "<p>Duis a tincidunt urna. Phasellus tristique interdum mauris, "
            + "ut vestibulum purus suscipit eget. Aenean massa elit, accumsan "
            + "non faucibus vel, dictum placerat urna. In bibendum est sagittis "
            + "urna iaculis quis sagittis velit commodo. Cum sociis natoque "
            + "penatibus et magnis dis parturient montes, nascetur ridiculus "
            + "mus. Nam quis lacus mauris. Phasellus sem libero, convallis "
            + "mattis sagittis vel, auctor eget ipsum. Vivamus molestie semper "
            + "adipiscing. In ac neque quis elit suscipit pharetra. Nulla at "
            + "orci a tortor consequat consequat vitae sit amet elit. Praesent "
            + "commodo lacus a magna mattis vehicula. Curabitur a hendrerit "
            + "risus. Aliquam accumsan lorem quis orci lobortis malesuada.</p>"
            + "<p>Proin quis viverra ligula. Donec pulvinar, dui id facilisis "
            + "vulputate, purus justo laoreet augue, a feugiat sapien dolor ut "
            + "nisi. Sed semper augue ac felis ultrices a rutrum dui suscipit. "
            + "Praesent et mauris non tellus gravida mollis. In hac habitasse "
            + "platea dictumst. Vestibulum ante ipsum primis in faucibus orci "
            + "luctus et ultrices posuere cubilia Curae; Vestibulum mattis, "
            + "tortor sed scelerisque laoreet, tellus neque consectetur lacus, "
            + "eget ultrices arcu mi sit amet arcu. Nam gravida, nulla interdum "
            + "interdum gravida, elit velit malesuada arcu, nec aliquam lectus "
            + "velit ut turpis. Praesent pretium magna in nibh hendrerit et "
            + "elementum tellus viverra. Praesent eu ante diam. Proin risus "
            + "eros, dapibus at eleifend sit amet, blandit eget purus. "
            + "Pellentesque eu mollis orci. Sed venenatis diam a nisl tempor "
            + "congue.</p>"
            + "</html>");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.setPreferredSize(new Dimension(640, 480));
        return panel;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() { 
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(createPanel());
                frame.pack();
                frame.setVisible(true);
            }

        });
    }

}