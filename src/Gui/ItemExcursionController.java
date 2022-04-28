package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import trippytraveljava.Main;
import trippytraveljava.MyListener;
import Entities.Excursion;

public class ItemExcursionController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(excursion);
    }

    private Excursion excursion;
    private MyListener myListener;

    public void setData(Excursion excursion, MyListener myListener) {
        this.excursion = excursion;
        this.myListener = myListener;
        nameLabel.setText(excursion.getLibelle());
        priceLable.setText(Main.CURRENCY + excursion.getPrix());
        Image image = new Image(getClass().getResourceAsStream(excursion.getImgSrc()));
        img.setImage(image);
    }
}
