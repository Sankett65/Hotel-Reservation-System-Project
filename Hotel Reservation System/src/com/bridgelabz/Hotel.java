package com.bridgelabz;

import java.util.List;

public class Hotel {
    private String hotelName;
    private int weekdaysRateForRegularCustomer;
    private int weekendsRateForRegularCustomer;

    public Hotel(String hotelName, int weekdaysRateForRegularCustomer, int weekendsRateForRegularCustomer) {
        this.hotelName = hotelName;
        this.weekdaysRateForRegularCustomer = weekdaysRateForRegularCustomer;
        this.weekendsRateForRegularCustomer = weekendsRateForRegularCustomer;
    }

    public Hotel() {

    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdaysRateForRegularCustomer() {
        return weekdaysRateForRegularCustomer;
    }

    public void setWeekdaysRateForRegularCustomer(int weekdaysRateForRegularCustomer) {
        this.weekdaysRateForRegularCustomer = weekdaysRateForRegularCustomer;
    }

    public int getWeekendsRateForRegularCustomer() {
        return weekendsRateForRegularCustomer;
    }

    public void setWeekendsRateForRegularCustomer(int weekendsRateForRegularCustomer) {
        this.weekendsRateForRegularCustomer = weekendsRateForRegularCustomer;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", weekdaysRateForRegularCustomer=" + weekdaysRateForRegularCustomer + "$" +
                ", weekendsRateForRegularCustomer=" + weekendsRateForRegularCustomer + "$" +
                '}';
    }


    public int rateOfHotel(List<String> list) {
        HotelReservation hotelReservation = new HotelReservation();

        int sum =0;
        for (int j = 0; j < list.size(); j++) {
            String s = list.get(j);
            if (s == null)
                return 0;

            if (s.equals("MONDAY") || s.equals("TUESDAY") || s.equals("WEDNESDAY") || s.equals("THURSDAY") || s.equals("FRIDAY")) {
                sum = sum + this.weekdaysRateForRegularCustomer;

            } else {
                sum = sum + this.weekendsRateForRegularCustomer;

            }
        }
        return sum;

    }

}
