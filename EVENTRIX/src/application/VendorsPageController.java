package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VendorsPageController implements Initializable {
	FileChooser fileChooser=new FileChooser();
	
	//for Vendors Items
	@FXML
	AnchorPane vendorItem;
	
	 
	
	//for Vendors Page 
		private int a1=0,a2=1,a3=2;//rows
		private int grid=0;
		private int c=0;
		@FXML
		Line vendorLine;
		@FXML
		ScrollPane myItemScrollPane;
		@FXML
		AnchorPane addItemAnchorPane;
		@FXML
		GridPane myItemsGridPane;
		@FXML
		TextField productName;
		@FXML
		TextField productId;
		@FXML
		TextField productPrice;
		@FXML
		ImageView sampleProductImage;
		
		public void addColumn() {
			RowConstraints row1 = new RowConstraints();
			ColumnConstraints col1 = new ColumnConstraints();
			col1.setMinWidth(310);
			col1.setPrefWidth(310);
			col1.setMaxWidth(310);
			myItemsGridPane.getColumnConstraints().add(col1);
		}
		public void addRow() {
			RowConstraints row1 = new RowConstraints();
			row1.setMinHeight(180);
			row1.setPrefHeight(180);
			row1.setMaxHeight(180);
			myItemsGridPane.getRowConstraints().add(row1);
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			fileChooser.setInitialDirectory(new File("C:\\Users\\User\\Downloads"));
		
			/*ColumnConstraints col1 = new ColumnConstraints();
			col1.setMinWidth(310);
			col1.setPrefWidth(310);
			col1.setMaxWidth(310);
			ColumnConstraints col2 = new ColumnConstraints();
			col1.setMinWidth(310);
			col1.setPrefWidth(310);
			col1.setMaxWidth(310);
			ColumnConstraints col3 = new ColumnConstraints();
			col1.setMinWidth(310);
			col1.setPrefWidth(310);
			col1.setMaxWidth(310);
			RowConstraints row1 = new RowConstraints();
			row1.setMinHeight(180);
			row1.setPrefHeight(180);
			row1.setMaxHeight(180);
			myItemsGridPane.getColumnConstraints().addAll(col1,col2,col3);
			myItemsGridPane.getRowConstraints().add(row1);
			*/
			addColumn();
			addColumn();
			addColumn();
			addRow();
			myItemsGridPane.setHgap(10);
			myItemsGridPane.setVgap(10);
		}
		
	
	
	
	
	//Vendors Page start
		public void myItems() {
			gotoItems();
		}
		public void orders() {
			gotoorders();
		}
		public void profits() {
			gotoprofits();
		}
		
		public void gotoItems() {
			TranslateTransition translate=new TranslateTransition();
			translate.setNode(vendorLine);
			translate.setDuration(Duration.millis(300));
			translate.setToX(0);
			translate.play();
		}
		public void gotoorders() {
			TranslateTransition translate=new TranslateTransition();
			translate.setNode(vendorLine);
			translate.setDuration(Duration.millis(300));
			translate.setToX(120);
			translate.play();
		}
		public void gotoprofits() {
			TranslateTransition translate=new TranslateTransition();
			translate.setNode(vendorLine);
			translate.setDuration(Duration.millis(300));
			translate.setToX(240);
			translate.play();
		}
		public void addItemFunc() {
			if(c%2==0) {
			//myItemScrollPane.setVisible(false);
			myItemsGridPane.setVisible(false);
			addItemAnchorPane.setVisible(true);
			}
			else {
				if(grid==3) {
					grid=0;
					a1+=1;
					a2+=3;
					a3+=3;
				}
				ImageView temp=new ImageView(sampleProductImage.getImage());
				temp.setFitWidth(300);
				temp.setFitHeight(210); 
				
				myItemsGridPane.add(vendorItem,0,0);
				
				
				/*myItemsGridPane.add(temp,grid,a1);
				Label pName=new Label(productName.getText());
				Label pPrice=new Label(productPrice.getText()+" Tk");
				myItemsGridPane.add(pName,grid,a2);
				myItemsGridPane.add(pPrice,grid,a3);
				sampleProductImage.setImage(new Image(getClass().getResourceAsStream("example.png")));
				*/
				grid++;
				
				addItemAnchorPane.setVisible(false);
				myItemsGridPane.setVisible(true);
				//myItemScrollPane.setVisible(true);
				
			}
			c++;
		}
		public void importImage() {
			fileChooser.setTitle("Select Product Image");
			File file=fileChooser.showOpenDialog(new Stage());
			sampleProductImage.setImage(new Image(file.toURI().toString()));
			/*Image image = new Image(file.toURI().toString());
			System.out.println(file.toURI().toString());
			sampleProductImage.setImage(image);
			 */
		}
		
}
