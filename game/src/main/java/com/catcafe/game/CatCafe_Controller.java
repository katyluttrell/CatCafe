package com.catcafe.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CatCafe_Controller {
    double x,y;

    @FXML
    private Button close_button;
    @FXML //close window with custom button
    protected void handleCloseAction(ActionEvent event){
        System.out.println("Closing window");
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button window_button;
    //this one will be disabled for now, we'll see if I can resize -- Gaby

    @FXML
    private Button min_button;
    @FXML //minimize window with custom button
    protected void handleMinAction(ActionEvent event){
        System.out.println("Minimizing window");
        Stage stage = (Stage) min_button.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private Pane top_pane;
    @FXML //drag window with custom bar
    protected void handleClickAction(MouseEvent event){
        Stage stage = (Stage) top_pane.getScene().getWindow();
        x = event.getSceneX();
        y = event.getSceneY();
    }
    @FXML
    protected void handleDragAction(MouseEvent event){
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX()-x);
        stage.setY(event.getScreenY()-y);
    }

    @FXML
    private Button QuitButton;
    @FXML //close window with Quit Button
    protected void handleQuitAction(ActionEvent event){
        System.out.println("Closing window");
        Stage stage = (Stage) QuitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button PlayButton;
    @FXML //move on to the gameplay view
    protected void handlePlayAction(ActionEvent event) throws IOException {
        System.out.println("Moving on to gameplay");
        Parent gameplay_parent = FXMLLoader.load(getClass().getResource("gameplay-view.fxml"));
        Scene gameplay_scene = new Scene(gameplay_parent);
        Stage stage = (Stage) PlayButton.getScene().getWindow();
        stage.setScene(gameplay_scene);
        stage.show();
        //start game logic
        DemoLevel test = new DemoLevel();
        test.go();
    }
}