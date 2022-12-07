public class Main {
    public static void main(String[] args) {
        MyFarmView myfarmView = new MyFarmView();
        MyFarmModel myfarmModel = new MyFarmModel();

        MyFarmController myfarmController = new MyFarmController(myfarmView, myfarmModel);
    }
}
