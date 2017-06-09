/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hills.cipher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author willi
 */
public class HillsCipher extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        CipherPane root = new CipherPane();
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Hill's Cipher Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("HillsCipher.png"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
