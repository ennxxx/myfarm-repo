import model.CropModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreController {
    private StoreFrame storeFrame;
    private MainFrame mainFrame;
    private CropModel cropModel;

    public StoreController(StoreFrame storeFrame, MainFrame mainFrame, CropModel cropModel) {
        this.mainFrame = mainFrame;
        this.storeFrame = storeFrame;
        this.cropModel = cropModel;

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

        CropModel cropModel = new CropModel(seedName);

        return "<html><left>" +
                "<p><b>Name: </b>" + cropModel.getName() + "</p>" +
                "<p><b>Type: </b>" + cropModel.getType() + "</p>" +
                "<p><b>Cost: </b>" + cropModel.getCost() + "</p>" +
                "</left></html>";
    }
}
