/*
 * T-Plan Robot Enterprise, automated testing tool.
 * Copyright (C) 2009-2013 T-Plan Limited (http://www.t-plan.com),
 * Cloisters House, 8 Battersea Park Road, London, SW8 4BG, United Kingdom.
 * All rights reserved.
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Simple test application used for demonstration of T-Plan Robot Enterprise 
 * integration with Continuous Integration (Jenkins).
 */
public class DemoApp extends JFrame implements Runnable, ActionListener {

    public DemoApp() {
        super("Test Application");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        JPanel content = new JPanel(new BorderLayout());
        setContentPane(content);
        
        // Create the message
        String text = "Hello!\nThis is a test application for demonstration\n"
                + "of T-Plan Robot integration with Jenkins.";
        JTextArea area = new JTextArea(text);
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        area.setEditable(false);
        area.setOpaque(false);
        content.add(area, BorderLayout.CENTER);
        
        // Create the Close button
        JButton btn = new JButton("Close");
        btn.addActionListener(this);
        ImageIcon icon = new ImageIcon(getClass().getResource("exit16.png"));
        btn.setIcon(icon);
        JPanel pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlSouth.add(btn);
        content.add(pnlSouth, BorderLayout.SOUTH);
        
        // Pack the window and center it on the screen
        pack();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void run() {
        setVisible(true);
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        System.exit(0);
    }
    
    /**
     * Application entry point.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DemoApp app = new DemoApp();
        SwingUtilities.invokeLater(app);        
    }
}
