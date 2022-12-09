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
}
