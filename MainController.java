import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;

        mainView.setSleepBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == mainView.getSleepBtn()) {
                    mainView.getMainFrame().dispose();
                    RestView restView = new RestView();
                }
            }
        });
    }
}


