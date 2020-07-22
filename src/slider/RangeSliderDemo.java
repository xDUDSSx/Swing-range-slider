package slider;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;

/**
 * Demo application panel to display a range slider.
 */
public class RangeSliderDemo extends JPanel {
    private final RangeSlider rangeSlider = new RangeSlider(0, 100);
    private final RangeSlider rangeSlider2 = new RangeSlider(0, 10);
    
    private final JLabel titleLable = new JLabel("Swing-range-slider demo");
    private final JPanel panel = new JPanel();
    private final JSeparator separator = new JSeparator();
    
    private final JLabel verticalSliderValue1 = new JLabel("");
    private final JLabel verticalSliderValue2 = new JLabel("");
    private final JLabel horizontalSliderValue1 = new JLabel("");
    private final JLabel horizontalSliderValue2 = new JLabel("");

    public RangeSliderDemo() {    
        rangeSlider.setOrientation(JSlider.HORIZONTAL);
        
        rangeSlider.setMinimum(0);
        rangeSlider.setMaximum(100);
        
        rangeSlider.setPaintTicks(true);
        rangeSlider.setPaintLabels(true);
        rangeSlider.setSnapToTicks(false);
        rangeSlider.setMajorTickSpacing(10);
        rangeSlider.setMinorTickSpacing(2);
        
        rangeSlider2.setOrientation(JSlider.VERTICAL);
        
        rangeSlider2.setPaintTicks(false);
        rangeSlider2.setPaintLabels(true);
        rangeSlider2.setSnapToTicks(false);
        rangeSlider2.setMajorTickSpacing(2);
        rangeSlider2.setMinorTickSpacing(1);
        
        // Add listeners to update display.
        rangeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                RangeSlider slider = (RangeSlider) e.getSource();
                horizontalSliderValue1.setText("Horizontal slider low: " + String.valueOf(slider.getValue()));
                horizontalSliderValue2.setText("Horizontal slider high: " + String.valueOf(slider.getUpperValue()));
            }
        });
        
        rangeSlider2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                RangeSlider slider = (RangeSlider) e.getSource();
                verticalSliderValue1.setText("Vertical slider low: " + String.valueOf(slider.getValue()));
                verticalSliderValue2.setText("Vertical slider high: " + String.valueOf(slider.getUpperValue()));
            }
        });
        
        setLayout(new MigLayout("", "[]20px[grow]", "[][grow]"));
        
        add(panel, "cell 1 0,grow");
        panel.setLayout(new MigLayout("", "[grow]", "[][][][]20px[][]"));
        panel.add(titleLable, "cell 0 0");    
        panel.add(separator, "cell 0 1,growx");       
        panel.add(verticalSliderValue1, "cell 0 2");     
        panel.add(verticalSliderValue2, "cell 0 3");        
        panel.add(horizontalSliderValue1, "cell 0 4");      
        panel.add(horizontalSliderValue2, "cell 0 5");
        
        add(rangeSlider2, "cell 0 0 1 2,grow");
        add(rangeSlider, "cell 1 1,growx,aligny bottom");
    }
    
    public void display() {
        // Initialize values.
        rangeSlider.setValue(20);
        rangeSlider.setUpperValue(100);
        
        rangeSlider2.setValue(2);
        rangeSlider2.setUpperValue(7);
        
        // Create window frame.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setTitle("Range Slider Demo");
        
        // Set window content and validate.
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.pack();
        
        // Set window location and display.
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * Main application method.
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RangeSliderDemo().display();
            }
        });
    }
}
