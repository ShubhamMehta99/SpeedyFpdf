/*

Name: Shubham Mehta & Dartanium Mills
Reson: Sunhacks Spring_2018
Time taken: 36 hours
Date: 6 April 2018 - 8 April 2018
Description: This code is for converting the image extentions like jpg and png into pdf.
*/
package SunHacks2018;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import java.awt.Window;
import java.io.*;
import javafx.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.input.*;
import javafx.scene.text.Text;




public class ConvertPDF extends Application{

	public static  String fileDest = "/Users/Shubham/Desktop/converted.pdf";
    public static  String originalImage = "/Users/Shubham/Desktop/";
    //final Text source = new Text(50, 100, "DRAG ME");
     Text target = new Text("DROP HERE");
     Font newFont = new Font("Arial",  24);
     int number = 0;


	public static void main(String[] args) {
		 launch(args);
	}

	protected void createPdf(String dest) throws FileNotFoundException, MalformedURLException, IOException{

		  	PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
	        PageSize pageSize = new PageSize(PageSize.A4);//with I write this it rotate the file=> .rotate();
	        Document doc = new Document(pdfDoc, pageSize);
	        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
	        System.out.print(originalImage);
	        canvas.addImage(ImageDataFactory.create(originalImage), pageSize, false);
	        System.out.print("After canvas thing");
	        doc.close();

    }

	  public void start(Stage primaryStage) {
		  final TextField userTextField = new TextField();
		  StackPane layer1 = new StackPane();
		  layer1.getChildren().addAll(userTextField);
		  Scene  scene1 = new Scene(layer1, 500, 500);
		  Stage window = new Stage();
		  window.setScene(scene1);

		  String home = System.getProperty("user.home");
		  File folderPath = new File(home + File.separator + "Desktop" + File.separator + "ConvertToPDF");
		 // folderPath.mkdir();
	        primaryStage.setTitle("ConvertToPDF!");







	                // Create the VBox

	                VBox root = new VBox();

	                // Add the Pane and The LoggingArea to the VBox

	             //   root.getChildren().addAll(/*pane,*/loggingArea);

	                // Set the Style of the VBox

	                root.setStyle("-fx-padding: 10;" +

	                    "-fx-border-style: solid inside;" +

	                    "-fx-border-width: 2;" +

	                    "-fx-border-insets: 5;" +

	                    "-fx-border-radius: 5;" +

	                    "-fx-border-color: blue;" + "-fx-font-size: 46; "  );






	        target.setOnDragOver(new EventHandler<DragEvent>() {
	            public void handle(DragEvent event) {
	                /* data is dragged over the target */
	                /* accept it only if it is not dragged from the same node
	                 * and if it has a string data */
	                if (event.getGestureSource() != target && event.getDragboard().hasFiles()) {
	                	Dragboard db = event.getDragboard();

	                //	System.out.print("Drag Event: " );
	                    /* allow for both copying and moving, whatever user chooses */
	                    event.acceptTransferModes(TransferMode.COPY);
	                }else {

	                event.consume();
	                }
	            }
	        });


	        target.setOnDragDropped(new EventHandler<DragEvent>() {
	            public void handle(DragEvent event) {
	            /* the drag-and-drop gesture entered the target */
	            /* show to the user that it is an actual gesture target */
	                 if (event.getGestureSource() != target &&
	                         event.getDragboard().hasFiles()) {
	                     System.out.print("Drag Entered");
	                     String filePath = null;
	                     Dragboard db = event.getDragboard();
	                     for (File file:db.getFiles()) {
	                         filePath = file.getAbsolutePath();
	                         System.out.println(filePath);
	                         originalImage = filePath;
	                     }
	                 }

	                 event.consume();
	            }
	        });

	       /* //Text Field
	        userTextField.getText();
	        userTextField.setOnAction( new EventHandler<ActionEvent>() {
	        		public void handle(ActionEvent event) {
	        			System.out.print("TextField");
	        			if(userTextField.getText() != null) {
		            		originalImage += userTextField.getText();
		                System.out.println("Path Saved!");
		                System.out.println(originalImage);
		            	}
		        }
	        });
	        */
	        Text whatever = new Text("        ");
	        //Button
	        Button btn = new Button();

	        btn.setText(" Convert ");

	        btn.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	            	//originalImage = userTextField.getText();
	                File file = new File(fileDest);
	        		//file.getParentFile().mkdirs();
	        		try {
	        	        new ConvertPDF().createPdf(fileDest);//Create PDF
	        	        number ++;
	        	        fileDest = "/Users/Shubham/Desktop/converted"+ number +".pdf";
	        		}catch(FileNotFoundException e){
	        			System.out.print("File Not Found!");
	        		}catch(MalformedURLException e) {
	        			System.out.print("Malformed URL!");
	        		}catch(IOException e){
	        			System.out.print("IO exception");
	        		}
	            	}
	           // System.out.println("ConvertToPDF!");
	        });





	        //StackPane root = new StackPane();
	       // root.getChildren().add(userTextField);
	        root.getChildren().add(target);
	        root.getChildren().add(whatever);
	        root.getChildren().add(btn);


	        primaryStage.setScene(new Scene(root, 300, 250));
	        primaryStage.show();

	    }
}







// sourceFld.setPrefSize(200, 20);

       //  targetFld.setPrefSize(200, 20);



         // Create the Labels

        // Label sourceLbl = new Label("Source Node:");

         //Label targetLbl = new Label("Target Node:");



         // Create the GridPane

         //GridPane pane = new GridPane();

        // pane.setHgap(5);

        // pane.setVgap(20);



         // Add the Labels and Fields to the Pane

        // pane.addRow(0, sourceLbl, sourceFld);

        // pane.addRow(1, targetLbl, targetFld);



         // Add mouse event handlers for the source

      /*   sourceFld.setOnMousePressed(new EventHandler <MouseEvent>()

         {

             public void handle(MouseEvent event)

             {

                 sourceFld.setMouseTransparent(true);

                 System.out.print("Event on Source: mouse pressed");

                 event.setDragDetect(true);

             }

         });
*/


      /*   sourceFld.setOnMouseReleased(new EventHandler <MouseEvent>()

         {

             public void handle(MouseEvent event)

             {

                 sourceFld.setMouseTransparent(false);

                 System.out.print("Event on Source: mouse released");

             }

         });



         sourceFld.setOnMouseDragged(new EventHandler <MouseEvent>()

         {

             public void handle(MouseEvent event)

             {

             	System.out.print("Event on Source: mouse dragged");

                 event.setDragDetect(false);

             }

         });



         sourceFld.setOnDragDetected(new EventHandler <MouseEvent>()

         {

             public void handle(MouseEvent event)

             {

                 sourceFld.startFullDrag();

                 System.out.print("Event on Source: drag detected");

             }

         });

  */

         // Add mouse event handlers for the target
/*
         targetFld.setOnMouseDragEntered(new EventHandler <MouseDragEvent>()

         {

             public void handle(MouseDragEvent event)

             {

             	System.out.print("Event on Target: mouse dragged");

             }

         });



         targetFld.setOnMouseDragOver(new EventHandler <MouseDragEvent>()

         {

             public void handle(MouseDragEvent event)

             {

             	System.out.print("Event on Target: mouse drag over");

             }

         });



         targetFld.setOnMouseDragReleased(new EventHandler <MouseDragEvent>()

         {

             public void handle(MouseDragEvent event)

             {

                 targetFld.setText(sourceFld.getSelectedText());

                 System.out.print("Event on Target: mouse drag released");

             }

         });



         targetFld.setOnMouseDragExited(new EventHandler <MouseDragEvent>()

         {

             public void handle(MouseDragEvent event)

             {

             	System.out.print("Event on Target: mouse drag exited");

             }

         });

  */
