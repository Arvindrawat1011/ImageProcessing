import java.awt.Graphics;  
 import java.awt.image.BufferedImage;  
 import java.util.ArrayList;  
 import java.util.List;  
 import javax.swing.JFrame;  
 import javax.swing.JPanel;
import javax.swing.JSlider;

import org.opencv.core.Core;  
 import org.opencv.core.Mat;   
 import org.opencv.core.Point;  
 import org.opencv.core.Scalar;  
 import org.opencv.core.Size;  
 import org.opencv.highgui.VideoCapture;  
 import org.opencv.imgproc.Imgproc;  
import org.opencv.core.CvType;  
class Panel extends JPanel{
	 private BufferedImage image; 
	public void setimage(BufferedImage newimage){  
	     image=newimage;  
	     return;  
	   }  
	   public void setimagewithMat(Mat newimage){  
	     image=this.matToBufferedImage(newimage);  
	     return;  
	   }  
	   public BufferedImage matToBufferedImage(Mat matrix) {  
		     int cols = matrix.cols();  
		     int rows = matrix.rows();  
		     int elemSize = (int)matrix.elemSize();  
		     byte[] data = new byte[cols * rows * elemSize];  
		     int type;
			return image;  
	 
		     }  		     
}
public class WebCam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
		     JFrame frame1 = new JFrame("Web Camera1");  
		     frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		     frame1.setSize(650,600);  
		     frame1.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());  
		     Panel panel1 = new Panel(); 
		     frame1.setContentPane(panel1);  
		     frame1.setVisible(true);  
		     //**********************************************
		     JFrame frame2 = new JFrame("Web Camera2");  
		     frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		     frame2.setSize(1250,720);  
		   frame2.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());  
		     Panel panel2 = new Panel();  
		     frame2.setContentPane(panel2);  
		   frame2.setVisible(true); 
		     //********************************************************
		     JFrame frame3 = new JFrame("Web Camera3");  
		     frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		     frame3.setSize(1250,720);  
		     frame3.setBounds(0, 0, frame1.getWidth(), frame1.getHeight());  
		     Panel panel3 = new Panel();  
		     frame3.setContentPane(panel3);  
		  frame3.setVisible(true);  
		     //*********************************************************
		  JFrame frame4 = new JFrame("slider");  
		  JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
		  slider.setMinorTickSpacing(2);  
		  slider.setMajorTickSpacing(10);  
		    
		  slider.setPaintTicks(true);  
		  slider.setPaintLabels(true);  
		    
		  JPanel panel0=new JPanel();  
		  panel0.add(slider);  
		  frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		frame4.add(panel0);  
		  
		  frame3.setVisible(true);
		  
		  //*************************************************************
		      VideoCapture capture =new VideoCapture(0);
		     Mat webcam_image=new Mat(); 
		     Mat hsv_image=new Mat();
		     Mat hsv_image1=new Mat();
		     Mat hsv_image2=new Mat();
		     Mat circles = new Mat();
		     Mat thresholded=new Mat();  
		     Mat thresholded2=new Mat();  
		     Scalar hsv_min = new Scalar(0, 50, 50, 0);  
		     Scalar hsv_max = new Scalar(0,155, 155, 0);  
		     Scalar hsv_min2 = new Scalar(50, 50, 50, 0);  
		     Scalar hsv_max2 = new Scalar(179, 255, 255, 0); 
		     
	     if( capture.isOpened())  
		     {  
		      while( true )  
		      {  
		        capture.read(webcam_image);  
		        if( !webcam_image.empty() )  
		         { //System.out.println("sucess");
		  // Imgproc.cvtColor(webcam_image,hsv_image, Imgproc.COLOR_BGR2GRAY);
		        // Imgproc.cvtColor(webcam_image,hsv_image1, Imgproc.COLOR_BGR2YUV_YV12);
		       //  Imgproc.threshold(webcam_image, hsv_image2, 0,255,Imgproc.THRESH_BINARY + Imgproc.THRESH_BINARY); 
		   Imgproc.cvtColor(webcam_image, hsv_image, Imgproc.COLOR_BGR2GRAY);
		   Imgproc.cvtColor(hsv_image, hsv_image1, Imgproc.COLOR_GRAY2BGR);
	          Core.inRange(hsv_image1, hsv_min, hsv_max, thresholded);           
	          Core.inRange(hsv_image1, hsv_min2, hsv_max2, thresholded2);  
	        Core.bitwise_or(thresholded, thresholded2, thresholded);  
		         
		       
		         panel1.setimagewithMat(thresholded);
		         panel2.setimagewithMat(hsv_image1);
		         panel3.setimagewithMat(webcam_image);
		         frame1.repaint();
		         frame2.repaint();
		         frame3.repaint();
		         }
		      else
	{System.out.print("false");}}}
		     }}
		      


