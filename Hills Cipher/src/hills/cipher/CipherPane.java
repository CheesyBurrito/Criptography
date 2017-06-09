/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hills.cipher;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


/**
 *
 * @author willi
 */
public class CipherPane extends Pane{
    
    int[][] cipherMatrix = new int[3][3];
    
    private String cipherString = "";
    private String plainString = "";
    
    private Button cipherButton;
    private Button decipherButton;
    
    
    private TextField[][] textFieldArray = new TextField[3][3];
    private TextField plainTextField;
    private TextField cipherTextField;
    private TextField matrixIndication;
    
    
    public CipherPane(){
        super();
        setupCipherPane();
    }
    
    private void setupCipherPane(){
        setupButtons();
        setupTextField();
    }
    
    private void setupButtons(){
        cipherButton = new Button ("Cipher Text");
        
        
        decipherButton = new Button ("Decipher Text");
        
        
        
        this.getChildren().add(cipherButton);
        this.getChildren().add(decipherButton);
        
        cipherButton.setPrefSize(100, 50);
        decipherButton.setPrefSize(100, 50);
        
        decipherButton.setTranslateX(425);
        decipherButton.setTranslateY(400);
        cipherButton.setTranslateX(275);
        cipherButton.setTranslateY(400);
        
        buttonSetOnActionLogic();
    }
    
    private void buttonSetOnActionLogic(){
        cipherButton.setOnMouseClicked(e ->{
           obtainCipherMatrixFromTextFieldArray();
           plainString = plainTextField.getText();
           cipherString = CipherLogic.cipherText(cipherMatrix, plainString);
           cipherTextField.setText(cipherString);
        });
        
        decipherButton.setOnMouseClicked(e ->{
           obtainCipherMatrixFromTextFieldArray();
           cipherString = cipherTextField.getText();
           plainString = CipherLogic.cipherText(cipherMatrix, cipherString);
           plainTextField.setText(plainString);
        });
    }
    
    private void setupTextField(){
        plainTextField = new TextField();
        cipherTextField = new TextField();
        matrixIndication = new TextField();
        
        plainTextField.setTranslateX(300);
        plainTextField.setTranslateY(150);
        
        cipherTextField.setTranslateX(300);
        cipherTextField.setTranslateY(250);
        
        matrixIndication.setTranslateX(500);
        matrixIndication.setTranslateY(100);
        matrixIndication.setPrefWidth(200);
        matrixIndication.setStyle("-fx-background-color: #00ff00");
        
        plainTextField.setPromptText("Enter plain text here");
        
        cipherTextField.setPromptText("Enter cipher text here");
        
        matrixIndication.setText("Enter the de/cipher matrix here");
        matrixIndication.setEditable(false);
        
        
        for(int i = 0; i < textFieldArray.length; i++){
            for(int k = 0; k < textFieldArray[i].length; k++){
                textFieldArray[i][k] = new TextField();
                textFieldArray[i][k].setTranslateX((i * 75  + 500));
                textFieldArray[i][k].setTranslateY((k * 50) + 150);
                textFieldArray[i][k].setPrefSize(50, 25);
                this.getChildren().add(textFieldArray[i][k]);
            }
        }
        
        this.getChildren().add(matrixIndication);
        this.getChildren().add(plainTextField);
        this.getChildren().add(cipherTextField);
    }
    
    private void obtainCipherMatrixFromTextFieldArray(){
        for(int i = 0; i < textFieldArray.length; i++){
            for(int k = 0; k < textFieldArray[i].length; k++){
                cipherMatrix[i][k] = Integer.parseInt(textFieldArray[k][i].getText());
            }
        }
    }
}
