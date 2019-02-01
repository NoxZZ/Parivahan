package com.example.gautamnair.myapplication;

import android.net.Uri;

public class QuestionLibrary {

    private String LQuestions[]={
            "1. Near a pedestrian crossing, when the pedestrians are waiting to cross the road, you should",
            "2. You are approaching a narrow bridge, another vehicle is about to enter the bridge from opposite side you should",
            "3. On a road designated as one way",
            "4. When a vehicle is involved in an accident causing injury to any person",
            "5. You can overtake a vehicle in front",
            "6. When a vehicle approaches an unguarded railway level crossing, before crossing it, the driver shall",
            "7. How can you distinguish a transport vehicle",
            "8. Validity of learners licence",
            "9. In a road without footpath, the pedestrians",
            "10. Free passage should be given to the following types of vehicles",
            "11. The following sign represents..",
            "12. The following sign represents..",
            "13. The following sign represents..",
            "14. The following sign represents..",
            "15. The sign represents "
    };


    private String Lchoices[][]={
            {"Sound horn and proceed","Slow down, sound horn and pass","Stop the vehicle and wait till the pedestrians cross the road and then proceed"},
            {"Increase the speed and try to cross the bridge as fast as possible","Put on the head light and pass the bridge","Wait till the other vehicle crosses the bridge and then proceed"},
            {"Through the right side of that vehicle","Through the left side","Through the left side, if the road is wide"},
            {"Take the vehicle to the nearest police station and report the accident","Stop the vehicle and report to the police station","Take all reasonable steps to secure medical attention to the injured and report to the nearestpolice\n" +
                    "station within 24 hours"},
            {"Through the right side of that vehicle","Through the left side","Through the left side, if the road is wide"},
            {"Stop the vehicle on the left side of the road, get down from the vehicle, go to the railway track,and\n" +
                    "ensure that no train or trolley is coming from either side","Sound horn and cross the track as fast as possible","Wait till the train passes"},
            {"By looking at the tyre size.","By colour of the vehicle.","By looking at the number plate of the vehicle."},
            {"Till the driving licence is obtained","6 months","30 days"},
            {"Should walk on the left side of the road","Should walk on the right side of the road","May walk on either side of the road"},
            {"Police vehicles","Ambulance and fire service vehicles","Express, Super Express buses"},
            {"Keep left","There is no road to the left","Compulsory turn left"},
            {"Right turn prohibited","Sharp curve to the right","U-turn prohibited"},
            {"Pedestrian crossing","Pedestrians may enter","Pedestrians prohibited"},
            {"Horn prohibited","Compulsory sound horn","May sound horn"},
            {"Trucks Prohibited","Bus Prohibited","Heavy vehicles Prohibited"}
    };
    private String Lanswers[]= {
            "Stop the vehicle and wait till the pedestrians cross the road and then proceed",
            "Wait till the other vehicle crosses the bridge and then proceed",
            "Through the right side of that vehicle",
            "Take all reasonable steps to secure medical attention to the injured and report to the nearestpolice\n" +
                    "station within 24 hours",
            "Through the right side of that vehicle",
            "Stop the vehicle on the left side of the road, get down from the vehicle, go to the railway track,and\n" +
                    "ensure that no train or trolley is coming from either side",
            "By looking at the number plate of the vehicle.",
            "6 months",
            "Should walk on the right side of the road",
            "Ambulance and fire service vehicles",
            "Compulsory turn left",
            "U-turn prohibited",
            "Pedestrian crossing",
            "Horn prohibited",
            "Trucks Prohibited"
    };

    private  int Limages[]=
    {
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.leftturn,
            R.drawable.uturn,
            R.drawable.pedestrian_crossing,
            R.drawable.horn,
            R.drawable.truck_prohibited
    };

    public String getquestion(int option)
    {
        String question = LQuestions[option];
        return question;
    }

    public int getImage(int option){
        int Imagech=Limages[option];
        return Imagech;
    }
    public String getChoice1(int option)
    {
        String choice1 = Lchoices[option][0];
        return choice1;
    }

    public String getChoice2(int option)
    {
        String choice2 = Lchoices[option][1];
        return choice2;
    }

    public String getChoice3(int option)
    {
        String choice3 = Lchoices[option][2];
        return choice3;
    }

    public String getCorrectAnswer(int option) {
        String answer = Lanswers[option];
        return answer;
    }

    public int getlength()
    {
        return LQuestions.length;
    }
}
