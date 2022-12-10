import model.CropModel;
import model.Farmer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreController {
    private StoreFrame storeFrame;
    private Farmer farmer;

    //TODO: integrate farmer into the store
    public StoreController(StoreFrame storeFrame, Farmer farmer) {
        this.storeFrame = storeFrame;
        this.farmer = farmer;

        this.storeFrame.setReturnBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == storeFrame.getReturnBtn()) {
                    storeFrame.getStoreFrame().setVisible(false);
                }
            }
        });

        this.storeFrame.setTurBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Turnip"));
            }
        });

        this.storeFrame.setCarBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Carrot"));
            }
        });

        this.storeFrame.setPotBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Potato"));
            }
        });

        this.storeFrame.setRosBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Rose"));
            }
        });

        this.storeFrame.setTulBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Tulips"));
            }
        });

        this.storeFrame.setSunBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                storeFrame.setFeedbackLblText(setInformation("Sunflower"));
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
}
