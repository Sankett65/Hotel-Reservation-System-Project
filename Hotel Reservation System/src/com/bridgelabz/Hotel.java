package com.bridgelabz;

import java.util.List;

public class Hotel {
    private String hotelName;
    private int rateForRegularCustomer;


    public Hotel(String hotelName, int rateForRegularCustomer) {
        this.hotelName = hotelName;
        this.rateForRegularCustomer = rateForRegularCustomer;

    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdaysRateForRegularCustomer() {
        return rateForRegularCustomer;
    }

    public void setWeekdaysRateForRegularCustomer(int weekdaysRateForRegularCustomer) {
        this.rateForRegularCustomer = weekdaysRateForRegularCustomer;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", RateForRegularCustomer=" + rateForRegularCustomer + "$" +

                '}';
    }


    public int rateOfHotel(List<String> list) {
        HotelReservation hotelReservation = new HotelReservation();
        int sum =0;
        for (String s : list) {
            if (s == null)
                return 0;

            if (s.equals("MONDAY") || s.equals("TUESDAY") || s.equals("WEDNESDAY") || s.equals("THURSDAY") || s.equals("FRIDAY")) {
                sum = sum + this.rateForRegularCustomer;

            }
        }
        return sum;

    }

}
