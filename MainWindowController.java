package com.example.demo1;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    MazeDisplayer mazeDisplayer;

    int[][] mazeData = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
    };


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {mazeDisplayer.setMazeData(mazeData);

        mazeDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e)->mazeDisplayer.requestFocus());

        mazeDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                int r = mazeDisplayer.getcRow();
                int c = mazeDisplayer.getcCol();

                if(event.getCode() == KeyCode.UP) {
                    mazeDisplayer.setCharacterPosition(r-1, c);
                }
                if(event.getCode() == KeyCode.DOWN) {
                    mazeDisplayer.setCharacterPosition(r+1, c);
                }
                if(event.getCode() == KeyCode.RIGHT) {
                    mazeDisplayer.setCharacterPosition(r, c+1);
                }
                if(event.getCode() == KeyCode.LEFT) {
                    mazeDisplayer.setCharacterPosition(r, c-1);
                }
            }
        });
    }

    public void start() {
        System.out.println("start");
    }

    public void openFile() {
        FileChooser fc = new FileChooser();
        fc.setTitle("open maze file");
        fc.setInitialDirectory(new File("./resources"));
        File chosen = fc.showOpenDialog(null);
        if(chosen!=null) {
            System.out.println(chosen.getName());
        }
    }

}