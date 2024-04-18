package com.example.mathmatic;

import java.util.ArrayList;
import java.util.List;

public class DatabaseItems {

    private List<MenuItem> items = new ArrayList<MenuItem>();

    public DatabaseItems(){
        items.add(new MenuItem("sin^2(Θ) + cos^2(Θ) = 1", "Pythagorean Identities"));
        items.add(new MenuItem("1 + tan^2(Θ) = sec^2(Θ)" , "Pythagorean Identities"));
        items.add(new MenuItem("1 + cot2(Θ) = csc2(Θ)" , "Pythagorean Identities"));
        items.add(new MenuItem("csc(Θ) = 1 / sin(Θ)","Reciprocal Identities"));
        items.add(new MenuItem("sec(Θ) = 1 / cos(Θ)", "Reciprocal Identities"));
        items.add(new MenuItem("cot(Θ) = 1 / tan(Θ)", "Reciprocal Identities"));
        items.add(new MenuItem("tan(Θ) = sin(Θ) / cos(Θ)", "Quotient Identities"));
        items.add(new MenuItem("cot(Θ) = cos(Θ) / sin(Θ)", "Quotient Identities"));
        items.add(new MenuItem("sin(π/2 –  Θ) = cos(Θ)", "Co-function Identities"));
        items.add(new MenuItem("cos(π/2 – Θ) = sin(Θ)", "Co-function Identities"));
        items.add(new MenuItem("tan(π/2 – Θ) = cot(Θ)", "Co-function Identities"));
        items.add(new MenuItem("sin(-Θ) = -sin(Θ)", "Even-Odd Identities"));
        items.add(new MenuItem("cos(-Θ) = cos(Θ)", "Even-Odd Identities"));
        items.add(new MenuItem("tan(-Θ) = -tan(Θ)", "Even-Odd Identities"));
        items.add(new MenuItem("sin(A +,- B) = sin(A)cos(B) +,- cos(A)sin(B)", "Sum and Difference Identities"));
        items.add(new MenuItem("cos(A +,- B) = cos(A)Cos(B) +,- sin(A)sin(B)", "Sum and Difference Identities"));
        items.add(new MenuItem("tan(A +,- B) = tan(A) +,- tan(B)  /  1 +,- tan(A)tan(B)", "Sum and Difference Identities"));
        items.add(new MenuItem("sin(2 Θ) = 2sin(Θ)cos(Θ)", "Double Angle Identities"));
        items.add(new MenuItem("cos(2 Θ) = cos^2(Θ) – sin^2(Θ) = 2cos^2(Θ) -1 = 1 – sin^2(Θ)", "Double Angle Identities"));
        items.add(new MenuItem("tan(2 Θ) = 2tan(Θ)  /  1 – tan^2(Θ)", "Double Angle Identities"));
        items.add(new MenuItem("sin(Θ/2) = +,- √(1-cos(Θ) / 2)", "Half Angle Identities"));
        items.add(new MenuItem("cos(Θ/2) = +,- √(1+cos(Θ) / 2)", "Half Angle Identities"));
        items.add(new MenuItem("tan(Θ/2) = sin(Θ) / 1+cos(Θ) = 1-cos(Θ) / sin(Θ)", "Half Angle Identities"));




    }

    public List<MenuItem> getMenuItems(String category){
        List<MenuItem> result = new ArrayList<>();
        for(MenuItem m: items){
            if(m.getCategory().equals(category)){
                result.add(m);
            }
        }
        return result;


    }

    public String[] getCategories(){
        //assume we are reading data from database
        String[] categories = {"Pythagorean Identities", "Reciprocal Identities", "Quotient Identities", "Co-function Identities",
                "Even-Odd Identities", "Sum and Difference Identities", "Double Angle Identities", "Half Angle Identities"};
        return categories;

    }


}