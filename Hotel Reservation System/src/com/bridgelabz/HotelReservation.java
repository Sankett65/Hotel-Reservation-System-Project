package com.bridgelabz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;


public class HotelReservation {

    List<Hotel> hotelList = new ArrayList<>();

    public void addHotel(Hotel hotel){
        hotelList.add(hotel);
    }

    public List<String> toGetDay() {
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
        System.out.println("\nFinding the best Hotel from "+Startdate1+" to "+Enddate1+" :- ");
        List<String> list= new ArrayList<>();

        int a = Startdate1.compareTo(Enddate1);

    try {
        if (a>0){
            throw new DateCannotBeZero("Ending Date should be greater than Starting Date");
        }else {
               long numOfDaysBetween = ChronoUnit.DAYS.between(Startdate1, Enddate1);
               numOfDaysBetween = numOfDaysBetween + 1;
               for (int i = 0; i < numOfDaysBetween; i++) {
                   list.add(String.valueOf(Startdate1.plusDays(i).getDayOfWeek()));

               }
           }
        return list;
    }catch (Exception e){
        System.out.println(e);
    }
    return list;
    }


    public void minimumRates(int i,List<String> list){
        int sum1=0;
        int sum2=0;
        int sum3=0;
        for (Hotel hotel : hotelList) {
            switch (hotel.getHotelName()) {
                case "Lakewood" -> sum1 = hotel.rateOfHotel(i,list);
                case "Bridgewood" -> sum2 = hotel.rateOfHotel(i,list);
                case "Ridgewood" -> sum3 = hotel.rateOfHotel(i,list);
            }
        }
        Random random = new Random();
        int check = random.nextInt(0,3);
        if (check==0){
            System.out.println("\nHotel Lakewood is not Available for this Dates");
            if (sum2<sum3){
                System.out.println("This Rate is for Hotel BridgeWood is the ");
                System.out.println( "Rates :- "+sum2+"$");
            }else {
                System.out.println("This Rate is for Hotel RidgeWood");
                System.out.println("Rates :- "+sum3+"$");
            }
        }else if (check==1){
            System.out.println("\nHotel BridgeWood is not Available for this Dates");
            if (sum1<sum3){
                System.out.println("This Rate is for Hotel Lakewood");
                System.out.println("Rates :- "+sum1+"$");
            }else {
                System.out.println("This Rate is for Hotel RidgeWood");
                System.out.println("Rates :- "+sum3+"$");
            }
        }else {
            System.out.println("\nHotel RidgeWood is not Available for this Dates");
            if (sum1<sum2){
                System.out.println("This Rate is for Hotel Lakewood");
                System.out.println("Rates :- "+sum1+"$");
            }else {
                System.out.println("This Rate is for Hotel BridgeWood");
                System.out.println("Rates :- "+sum2+"$");
            }
        }
    }

    public void cheapestAndBestRated(){
        System.out.println("\nCheapest Rated Hotel :- ");
        double rating = Integer.MAX_VALUE;
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelRate() < rating) {
                rating = hotel.getHotelRate();
            }
        }
        double finalRating = rating;
        hotelList.stream().filter(m -> m.getHotelRate()== finalRating).forEach(System.out::println);
    }


    public void bestRated(){
        System.out.println("\nBest Rated Hotel :- ");
        double rating = Integer.MIN_VALUE;
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelRate() > rating) {
                rating = hotel.getHotelRate();
            }
        }
        double finalRating = rating;
        hotelList.stream().filter(m -> m.getHotelRate()== finalRating).forEach(System.out::println);
    }

    public void cheapestRateUsingJavaSream(int option,List<String> list){
        List<Hotel> cheapest=hotelList.stream()
                .sorted((hotel1,hotel2) ->{
                    int sum1 = hotel1.rateOfHotel(option,list);
                    int sum2 = hotel2.rateOfHotel(option,list);
                    return Integer.compare(sum1,sum2);
                }).toList();
        System.out.println("Hotel Name is :- "+cheapest.get(0).getHotelName());
        System.out.println("Hotel Rating is :- "+cheapest.get(0).getHotelRate());
        int finalRate= cheapest.get(0).rateOfHotel(option,list);
        System.out.println("Cheapest Rent is :- "+finalRate);
    }



    public void printHotelList(){
        for (Hotel h : hotelList){
            System.out.println(h);
        }
    }

    public static void main(String[] args)  {
        System.out.println("Welcome to Hotel Reservation Program");

        HotelReservation hotelReservation = new HotelReservation();

        Hotel hotel1= new Hotel("Lakewood",3,110,90,80,80);
        Hotel hotel2= new Hotel("Bridgewood",4,160,150,110,50);
        Hotel hotel3= new Hotel("Ridgewood",5,220,150,100,40);

        //   Adding the Hotels to Hotel Reservation Class
        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);

        System.out.println("List of Hotel Available");
        hotelReservation.printHotelList();

     //  Checking Whether the Customer is Regular or Rewarded
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                \nEnter 1 if you are a Regular Customer
                Enter 2 if you are a Reward Customer""");

        System.out.print("Enter your Option :- ");
        int option = sc.nextInt();


      //  hotelReservation.minimumRates(option,hotelReservation.toGetDay());

        hotelReservation.cheapestRateUsingJavaSream(option,hotelReservation.toGetDay());



    }
}








