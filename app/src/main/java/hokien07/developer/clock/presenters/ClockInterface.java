package hokien07.developer.clock.presenters;

public interface ClockInterface {
    interface View {
        void onChangeImage(int position);
    }

    interface Presenter {
        void handlerChangeImage();
    }
}
