package controller;

import model.Farmer;
import model.crops.Crop;
import view.FeedbackView;
import view.StoreView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is a class to initialize actions done in the store.
 */
public class StoreController {
    private StoreView storeView;
    private Crop[] cropLibrary;
    private Crop activeCrop;
    private Farmer farmer;
    private FarmerController farmerController;

    public StoreController(StoreView storeFrame, FarmerController farmerController, FeedbackView feedbackView) {
        this.storeView = storeFrame;
        this.farmerController = farmerController;
        this.farmer = farmerController.getFarmer();

        CropFactory factory = new CropFactory();

        this.cropLibrary = factory.getCropLibrary();
        this.storeView.setCoinsLbl(farmer.getObjectCoins());

        /**
         * Closes the store and takes note of the seed bought.
         */
        this.storeView.setReturnBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == storeFrame.getReturnBtn()) {
                    storeFrame.getStoreView().setVisible(false);
                    if (farmer.getInventory() != null) {
                        feedbackView.updateFeedback("You're holding a: " + farmer.getInventory().getName());
                    }
                }
            }
        });

        // Sets information of turnips on feedback, and makes it the active crop.
        this.storeView.setTurBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Turnip"));
                activeCrop = factory.create("Turnip");
            }
        });

        // Sets information of carrots on feedback, and makes it the active crop.
        this.storeView.setCarBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Carrot"));
                activeCrop = factory.create("Carrot");
            }
        });

        // Sets information of potatoes on feedback, and makes it the active crop.
        this.storeView.setPotBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                storeFrame.setFeedbackLblText(setInformation("Potato"));

                activeCrop = factory.create("Potato");

            }
        });

        // Sets information of roses on feedback, and makes it the active crop.
        this.storeView.setRosBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Rose"));
                activeCrop = factory.create("Rose");
            }
        });

        // Sets information of tulips on feedback, and makes it the active crop.
        this.storeView.setTulBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Tulips"));

                activeCrop = factory.create("Tulips");
            }
        });

        // Sets information of sunflowers on feedback, and makes it the active crop.
        this.storeView.setSunBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Sunflower"));
                activeCrop = factory.create("Sunflower");
            }
        });

        // Sets information of mangoes on feedback, and makes it the active crop.
        this.storeView.setManBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Mango"));
            }
        });

        // Sets information of apples on feedback, and makes it the active crop.
        this.storeView.setAppBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Apple"));
            }
        });

        // Buys a seed after clicking buy button.
        this.storeView.setBuyBtnListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                buySeed();
            }
        });
    }

    /**
     * Buys a seed from the seed store.
     */
    public void buySeed(){

        if (activeCrop == null){
            storeView.setFeedbackLblText(
                    "<html><center>" + "No crop was selected!" + "</center></html>"
            );
            return;
        }

        // Get the price of the activeCrop
        double price = activeCrop.getCost();
        price -= farmer.getRank().getSeedDiscount();

        farmer.setObjectCoins(
                farmer.getObjectCoins() - price
        );

        farmer.setInventory(activeCrop);

        storeView.setFeedbackLblText(
                "<html><center>" + "Successfully purchased!" + "</center></html>"
        );

        storeView.setCoinsLbl(
                farmer.getObjectCoins()
        );

        farmerController.updateFarmerView();
    }

    /**
     * Sets the information of a crop.
     *
     * @param seedName name of crop
     * @return information about the selected crop
     */
    public String setInformation(String seedName) {

        CropFactory cropFactory = new CropFactory();

        return "<html><left>" +
                "<p><b>Name: </b>" + cropFactory.create(seedName).getName() + "</p>" +
                "<p><b>Type: </b>" + cropFactory.create(seedName).getType() + "</p>" +
                "<p><b>Cost: </b>" + cropFactory.create(seedName).getCost() + "</p>" +
                "</left></html>";
    }

    /**
     * Looks for base price of a crop.
     *
     * @return cheapest price
     */
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
