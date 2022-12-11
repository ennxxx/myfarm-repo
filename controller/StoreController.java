package controller;

import model.CropModel;
import model.Farmer;
import model.crops.Crop;
import model.tiles.Tile;
import view.FeedbackView;
import view.StoreFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreController {
    private StoreFrame storeFrame;

    private Crop[] cropLibrary;

    private Crop activeCrop;
    private Farmer farmer;
    private FarmerController farmerController;

    //TODO: integrate farmer into the store
    public StoreController(StoreFrame storeFrame, FarmerController farmerController, FeedbackView feedbackView) {
        this.storeFrame = storeFrame;
        this.farmerController = farmerController;
        this.farmer = farmerController.getFarmer();

        CropFactory factory = new CropFactory();

        this.cropLibrary = factory.getCropLibrary();

        this.storeFrame.setCoinsLbl(farmer.getObjectCoins());

        this.storeFrame.setReturnBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == storeFrame.getReturnBtn()) {
                    storeFrame.getStoreFrame().setVisible(false);
                    if(farmer.getInventory() != null) {
                        feedbackView.updateFeedback("You're holding a: " + farmer.getInventory().getName());
                    }
                }
            }
        });

        this.storeFrame.setTurBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Turnip"));
                activeCrop = factory.create("Turnip");
            }
        });

        this.storeFrame.setCarBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Carrot"));
                activeCrop = factory.create("Carrot");
            }
        });

        this.storeFrame.setPotBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                storeFrame.setFeedbackLblText(setInformation("Potato"));

                activeCrop = factory.create("Potato");

            }
        });

        this.storeFrame.setRosBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Rose"));
                activeCrop = factory.create("Rose");
            }
        });

        this.storeFrame.setTulBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Tulips"));

                activeCrop = factory.create("Tulips");
            }
        });

        this.storeFrame.setSunBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Sunflower"));
                activeCrop = factory.create("Sunflower");
            }
        });

        this.storeFrame.setManBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Mango"));
            }
        });

        this.storeFrame.setAppBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Apple"));
            }
        });

        this.storeFrame.setBuyBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                buySeed();
            }
        });
    }

    public void buySeed(){

        if(activeCrop == null){

            storeFrame.setFeedbackLblText(
                    "No crop selected!"
            );
            return;
        }
        // get the price of the activeCrop
        double price = activeCrop.getCost();
        price -= farmer.getRank().getSeedDiscount();

        farmer.setObjectCoins(
                farmer.getObjectCoins() - price
        );

        farmer.setInventory(activeCrop);

        storeFrame.setFeedbackLblText(
                "Purchased!"
        );

        storeFrame.setCoinsLbl(
                farmer.getObjectCoins()
        );

        farmerController.updateFarmerView();
    }

    public String setInformation(String seedName) {
        // TODO: add crop initialization here

        CropModel cropModel = new CropModel(seedName);

        return "<html><left>" +
                "<p><b>Name: </b>" + cropModel.getName() + "</p>" +
                "<p><b>Type: </b>" + cropModel.getType() + "</p>" +
                "<p><b>Cost: </b>" + cropModel.getCost() + "</p>" +
                "</left></html>";
    }

    public double getCheapestPrice() {

        double cheapestPrice = cropLibrary[0].getCost();

        for (Crop crop : cropLibrary) {
            if (crop.getCost() < cheapestPrice) {
                cheapestPrice = crop.getCost();
            }
        }

        return cheapestPrice;
    }
}
