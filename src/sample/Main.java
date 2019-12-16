package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox(10);
        root.setPadding(new Insets(25));
        root.setAlignment(Pos.CENTER);

        TextField textField1 = new TextField("Je suis le premier");
        TextField textField2 = new TextField("Je suis le deuxième");

        //textField1.textProperty().bindBidirectional(textField2.textProperty());
        Bindings.bindBidirectional(textField1.textProperty(), textField2.textProperty());

        //Create a layout and add button to it
        Button dislikeButton = new Button("Bien le bonjour");

        //Create an event on the button
        dislikeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Yes i am Happy");
            }
        });

        //Or with a  lambda expression
        dislikeButton.setOnAction(e -> System.out.println("Je suis la amène toi"));

        //I can create a text node
        Text text = new Text();
        text.setText("Je suis le nouveau texte");

        root.getChildren().addAll(textField1, textField2, dislikeButton);

        //create a scene
        Scene scene = new Scene(root, 400, 400);

        //Prepare the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Starting");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
