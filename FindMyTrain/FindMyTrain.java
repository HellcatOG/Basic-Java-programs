package FindMyTrain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMyTrain {
    public static void main(String[] args) {
        TrainSystem system = new TrainSystem();

        Station station1 = new Station("1111", "AGRA");
        Station station2 = new Station("2222", "DELHI");


        Train train1 = new Train("333","INDIGO","FAST");
        Train train2 = new Train("333","INDIA","PASS");

        Platform p1 = new Platform(1);
        Platform p2 = new Platform(2);

        p1.setTrain(train1);
        p2.setTrain(train2);

        List<Platform> platformList = new ArrayList<>();
        platformList.add(p1);
        platformList.add(p2);


        station1.setPlatformList(platformList);

        Schedule s1 = new Schedule(train1,station1, "(9AM", "9:05", p1);
        Schedule s2 = new Schedule(train1,station1, "(10AM", "10:05", p1);

        system.addStation(station1);
        system.addStation(station2);
        system.addTrain(train1);
        system.addTrain(train2);
        system.addSchedule(s1);
        system.addSchedule(s2);

        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER SOURCE: ");
        String source = sc.nextLine();
        System.out.println("Enter the Desc: ");
        String des = sc.nextLine();
        List<Schedule> myTrains = system.findMyTrain(source, des);
        System.out.println("Your Trains btwn "+source+ "and " + des);
        Schedule schedule= myTrains.get(0);
        Train train = schedule.getTrain();
        System.out.println(train);
    }
}
