package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class HotelReservation {

    List<Hotel> hotelList = new ArrayList<>();

    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }



    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation hotelReservation = new HotelReservation();

        Hotel hotel1= new Hotel("Lakewood",110,90);
        Hotel hotel2= new Hotel("Bridgewood",160,60);
        Hotel hotel3= new Hotel("Ridgewood",220,150);

        //   Adding the Hotels to Hotel Resetration Class
        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);

        System.out.println("List of Hotel Avaliable");
        for (Hotel h : hotelReservation.hotelList){
            System.out.println(h);
        }
    }
}
