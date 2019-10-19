package hokien07.developer.clock.presenters;


import java.util.Random;

public class ClockPresenter implements ClockInterface.Presenter{


    ClockInterface.View clockView;

    public ClockPresenter(ClockInterface.View clockView) {
        this.clockView = clockView;
    }

    @Override
    public void handlerChangeImage() {

        Random r = new Random();
        int low = 0;
        int high = 6;
        int position = r.nextInt(high-low) + low;
        clockView.onChangeImage(position);

    }
}
