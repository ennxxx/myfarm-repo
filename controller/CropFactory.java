package controller;

import model.crops.*;

public class CropFactory implements AbstractFactory<Crop, String> {

    public Crop create (String flag) {
        // TODO: implement
        return switch (flag.toLowerCase()) {
            case "turnip" -> new Turnip();
            case "carrot" -> new Carrot();
            case "potato" -> new Potato();
            case "rose" -> new Rose();
            case "tulips" -> new Tulips();
            case "sunflower" -> new Sunflower();
            case "mango" -> new Mango();
            case "apple" -> new Apple();
            default -> null;
        };

    }

    public Crop[] getCropLibrary() {

        Crop[] cropLibrary = new Crop[8];
        cropLibrary[0] = new Turnip();
        cropLibrary[1] = new Carrot();
        cropLibrary[2] = new Potato();
        cropLibrary[3] = new Rose();
        cropLibrary[4] = new Tulips();
        cropLibrary[5] = new Sunflower();
        cropLibrary[6] = new Mango();
        cropLibrary[7] = new Apple();
        return cropLibrary;
    }
}
