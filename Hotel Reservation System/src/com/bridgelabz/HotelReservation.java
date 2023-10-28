package com.bridgelabz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservation {

    List<Hotel> hotelList = new ArrayList<>();

    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public List<String> toGetDay(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter the Starting Date in YYYY-MM-DD");
        System.out.print("Enter the Year:- ");
        int year=sc.nextInt();
        System.out.print("Enter the Month:- ");
        int month=sc.nextInt();
        System.out.print("Enter the Day:- ");
        int day=sc.nextInt();

        System.out.println("\nEnter the Ending Date YYYY-MM-DD");
        System.out.print("Enter the Year:- ");
        int year1=sc.nextInt();
        System.out.print("Enter the Month:- ");
        int month1=sc.nextInt();
        System.out.print("Enter the Day:- ");
        int day1=sc.nextInt();

        LocalDate Startdate1=LocalDate.of(year,month,day);
        LocalDate Enddate1=LocalDate.of(year1,month1,day1);

        long numOfDaysBetween = ChronoUnit.DAYS.between (Startdate1, Enddate1)+1;
        List<String> list= new ArrayList<>();
        for (int i =0;i<numOfDaysBetween;i++){
            list.add(String.valueOf(Startdate1.plusDays(i).getDayOfWeek()));

        }

        return list;
    }


    public void minimumRates(List<String> list){
        int sum1=0;
        int sum2=0;
        int sum3=0;
        for (Hotel hotel : hotelList) {
            switch (hotel.getHotelName()) {
                case "Lakewood" -> sum1 = hotel.rateOfHotel(list);
                case "Bridgewood" -> sum2 = hotel.rateOfHotel(list);
                case "Ridgewood" -> sum3 = hotel.rateOfHotel(list);
            }
        }

        if (sum1<sum2 && sum1<sum3){
            System.out.println("\nThis Rate is for Hotel Lakewood");
            System.out.println("Minimum Rates :- "+sum1+"$");
        }else  if (sum2<sum1 && sum2<sum3){
            System.out.println("\nThis Rate is for Hotel Bridgewood");
            System.out.println("Minimum Rates :- "+sum2+"$");
        }else {
            System.out.println("\nThis Rate is for Hotel Ridgewood");
            System.out.println("Minimum Rates :- "+sum3+"$");
        }
    }

    public void printHotelList(){
        for (Hotel h : hotelList){
            System.out.println(h);
        }
    }



    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation hotelReservation = new HotelReservation();

        Hotel hotel1= new Hotel("Lakewood",110,90);
        Hotel hotel2= new Hotel("Bridgewood",160,150);
        Hotel hotel3= new Hotel("Ridgewood",220,150);

        //   Adding the Hotels to Hotel Reservation Class
        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);

        System.out.println("List of Hotel Available");
        hotelReservation.printHotelList();

        System.out.println();
        hotelReservation.minimumRates(hotelReservation.toGetDay());
    }
}
