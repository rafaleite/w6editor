//package br.com.w6.w6Editor.ui;
//
//import java.awt.BorderLayout;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.SwingUtilities;
//import javax.swing.UIManager;
//
//import br.com.w6.w6Editor.server.WebSocketServer;
//import br.com.w6.w6Editor.suport.Constants;
//
// 
//public class UIMain extends JPanel implements ActionListener {
//    private JLabel mImage;
//    private byte[] mData;
//    private WebSocketServer mWebSocketServer;
// 
//    public UIMain() {
//        super(new BorderLayout());
//        
//        // image panel
//		JPanel imageViewer = new JPanel();
//		mImage = new JLabel();
//		mImage.setSize(480, 640);
//		imageViewer.add(mImage);
//		add(imageViewer, BorderLayout.CENTER);
//		
////		try {        	
////        	BufferedImage bi = ImageIO.read(new File(Constants.PATH_ICON));
////    		ByteArrayOutputStream out = new ByteArrayOutputStream();
////    		ImageIO.write(bi, "png", out);
////    		mData = out.toByteArray();
////    		out.close();
////        } catch (IOException exception) {
////        	exception.printStackTrace();
////        }
////        
////        mImage.setIcon(new ImageIcon(mData));
//		
//		
//		// WebSocketServer
//		mWebSocketServer = new WebSocketServer();
//		mWebSocketServer.start();
//    }
//
//	public void actionPerformed(ActionEvent e) {
//
//    }
// 
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//        JFrame frame = new JFrame("W6Scanner");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Add content to the window.
//        frame.add(new UIMain());
//       
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//        frame.setResizable(false);
//        frame.setSize(205, 230);
//        
//        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
//        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
//        int frameWidth = frame.getWidth();
//        int frameHeight = frame.getHeight();
//        frame.setLocation((int)(width - frameWidth) / 2, (int)(height - frameHeight) / 2);
//    }
// 
//    public static void main(String[] args) {
//
//        SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//                UIManager.put("swing.boldMetal", Boolean.FALSE); 
//                createAndShowGUI();
//            }
//        });
//    }
//}
//
