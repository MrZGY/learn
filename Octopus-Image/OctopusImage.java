import java.awt.*;
import java.io.*;
import javax.swing.*;


public class OctopusImage{
    public static void main(String[] args){
        EventQueue.invokeLater(() ->{
            var frame = new OctopusImageFrame();
            frame.setTitle("Octopus Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class OctopusImageFrame extends JFrame{
    private static final int DEFAULT_WIDTH=300;
    private static final int DEFAULT_HEIGHT=400;
    
    public OctopusImageFrame(){
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        var label =new JLabel();
        add (label);
        
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        
        var menuBar =new JMenuBar();
        setJMenuBar(menuBar);
        
        var menu= new JMenu("Flie");
        menuBar.add(menu);

        var openItem =new JMenuItem("open");
        menu.add(openItem);
        openItem.addActionListener(event ->{
            int result =chooser.showOpenDialog(null);
            
            if(result==JFileChooser.APPROVE_OPTION){
                String name =chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
            }
        });
        
        var exitItem=new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}

