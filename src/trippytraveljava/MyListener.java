package trippytraveljava;

import Entities.Excursion;
import Entities.Excursionreservation;

public interface MyListener {
    public void onClickListener(Excursion excursion);
    public void onClickReservationListener(Excursion excursion,Excursionreservation reservation);
}
