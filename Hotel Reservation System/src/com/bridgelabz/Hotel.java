package com.bridgelabz;

public class Hotel {
    private String hotelName;
    private int weekdaysRateForRegularCustomer;
    private int weekendsRateForRegularCustomer;

    public Hotel(String hotelName, int weekdaysRateForRegularCustomer, int weekendsRateForRegularCustomer) {
        this.hotelName = hotelName;
        this.weekdaysRateForRegularCustomer = weekdaysRateForRegularCustomer;
        this.weekendsRateForRegularCustomer = weekendsRateForRegularCustomer;
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
                ", weekdaysRateForRegularCustomer=" + weekdaysRateForRegularCustomer +"$"+
                ", weekendsRateForRegularCustomer=" + weekendsRateForRegularCustomer +"$"+
                '}';
    }
}
