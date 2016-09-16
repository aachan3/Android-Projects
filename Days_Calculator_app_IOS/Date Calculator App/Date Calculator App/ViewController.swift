//
//  ViewController.swift
//  Date Calculator App
//
//  Created by Aravind Achanta on 4/29/16.
//  Copyright © 2016 iosclass. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var StartMonth: UITextField!
    @IBOutlet weak var StartDay: UITextField!
    @IBOutlet weak var StartYear: UITextField!
    @IBOutlet weak var EndMonth: UITextField!
    @IBOutlet weak var EndDay: UITextField!
    @IBOutlet weak var EndYear: UITextField!
    @IBOutlet weak var Output: UILabel!
    @IBOutlet weak var ErrorLabel: UILabel!
    @IBAction func OnClick(sender: AnyObject) {
        
        var StartyearInteger=0;
        var num1=" ";
        var num2=" ";
        var num3=" ";
        var num4=" ";
        var num5=" ";
        var num6=" ";
        var EndyearInteger=0;
        
        var StartmonthInteger=0;
        var EndmonthInteger=0;
        var StartdateInteger=0;
        var EnddateInteger=0;
        Output.text=String(0);

        
         num1 =  StartYear.text!;
         num2 = StartMonth.text!;
         num3 = StartDay.text!;
         num4 = EndYear.text!;
         num5 = EndMonth.text!;
         num6 = EndDay.text!;
        
        var yearInteger:Int? = Int(num1);
        var smInteger:Int? = Int(num2);
        var seInteger:Int? = Int(num3);
        var eyInteger:Int? = Int(num4);
        var emInteger:Int? = Int(num5);
        var edInteger:Int? = Int(num6);
        
        if yearInteger==nil||smInteger==nil||seInteger==nil||eyInteger==nil||emInteger==nil||edInteger==nil
        {
            let alert = UIAlertView()
            
            alert.title="Invalid!!"
            
            alert.message = "Enter a numeric value"
            alert.addButtonWithTitle("OK");
            alert.show()
            
            return
        }
        
        //if textfield is empty
        
        if(StartYear.text!.isEmpty)
        {
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = "Fields cannot be empty"
            alert.addButtonWithTitle("OK");
            alert.show()
            return
            
        }

        
        StartyearInteger = Int(StartYear.text!)!;
        
        //if textfield is empty

        
        if(EndYear.text!.isEmpty)
        {
            
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = "Fields cannot be empty"
            alert.addButtonWithTitle("OK");
            alert.show()

            return
            
        }

        EndyearInteger = Int(EndYear.text!)!;
        
        //if textfield is empty

        if(StartMonth.text!.isEmpty)
        {
            
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = "Fields cannot be empty"
            alert.addButtonWithTitle("OK");
            alert.show()
            return
            
        }
        

        StartmonthInteger=Int(StartMonth.text!)!;
        
        
        //if textfield is empty

        if(EndMonth.text!.isEmpty)
        {
            
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = "Fields cannot be empty"
            alert.addButtonWithTitle("OK");
            alert.show()
            return
            
        }

        EndmonthInteger = Int(EndMonth.text!)!;
        
        //if textfield is empty

        if(StartDay.text!.isEmpty)
        {
            
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = "Fields cannot be empty"
            alert.addButtonWithTitle("OK");
            alert.show()

            return
            
        }

        StartdateInteger = Int(StartDay.text!)!;
        
        //if textfield is empty

        if(EndDay.text!.isEmpty)
        {
            
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = "Fields cannot be empty"
            alert.addButtonWithTitle("OK");
            alert.show()
            return
            
        }

        EnddateInteger = Int(EndDay.text!)!;
        
        
        
        
        // validating
        
        
        
        let greg =  Gregorian();
        
        if !greg.isStartEndValid(StartyearInteger, startmonth: StartmonthInteger, startday: StartdateInteger, endyear: EndyearInteger, endmonth: EndmonthInteger, endday: EnddateInteger)
        {
            
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = "Start Date can't be in future to end date"
            alert.addButtonWithTitle("OK");
            alert.show()
            return
        }
        
        // checking if the dates are valid
        
        var out = greg.areValidDates(StartyearInteger, month: StartmonthInteger, day: StartdateInteger)
        if out.containsString("Failed")
        {
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message = out + " in Start Date"
            alert.addButtonWithTitle("OK");
            alert.show()
            return

        }
        // checking if the dates are valid

        out = greg.areValidDates(EndyearInteger, month: EndmonthInteger, day: EnddateInteger)
        if out.containsString("Failed")
        {
            let alert = UIAlertView()
            alert.title="Invalid Input!!"
            
            alert.message =  out + " in End Date"
            alert.addButtonWithTitle("OK");
            alert.show()

            return
        }
        //start year
        
        var days1 = greg.numberofDays(StartyearInteger, month: StartmonthInteger, Day: StartdateInteger)
        
        //end year
        var days2 = greg.numberofDays(EndyearInteger, month: EndmonthInteger, Day: EnddateInteger)
        
        //answer
        var answer = days2 - days1
        
        Output.text = String(answer)
        

        
        
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}



class Gregorian{
    //function to find the number of days from year 500 -> start and end dates
    func numberofDays( year : Int, month: Int, Day:Int)->Int
    {
        
        var days=0;
        var temporaryyear=500;
        while temporaryyear < year
        {
            if isLeap(temporaryyear)
            {
                days = days + 366;
            }
                
            else
            {
                
                days = days + 365
            }
            
            temporaryyear++
            
        }
        
        var list = 1;
        
        while list<month
        {
            if(list == 1)||(list==3)||(list==5)||(list==7)||(list==8)||(list == 01)||(list==03)||(list==05)||(list==07)||(list==08)||(list==10)||(list==12)
            {
                days = days + 31;
            }
            if (list==4)||(list==6)||(list==9)||(list==04)||(list==06)||(list==09)||(list==11)
            {
                
                days = days + 30;
            }
            
            if list==2
            {
                if isLeap(year)
                {
                    days = days + 29
                }
                else
                {
                    days = days + 28
                }
            }
            
            list++
            
        }
        
        days = days + Day
        
        return days;
    }
    //validating if all the start end dates are in bounadry

    func areValidDates(year:Int, month:Int, day:Int)->String
    {
        
        
        if(month == 1)||(month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12)
        {
            if(day > 31 || day < 1)
            {
                return "Validation Failed...Enter day between 1 to 31"
            }
        }
        if (month==4)||(month==6)||(month==9)||(month==11)
        {
            if(day > 30 || day < 1)
            {
                return "Validation Failed...Enter day between 1 to 30"
            }
        }
        
        if month==2
        {
            if isLeap(year)
            {
                if(day > 29 || day < 1)
                {
                    return "Validation Failed...Enter day between 1 to 29"
                }
            }
            else
            {
                if(day > 28 || day < 1)
                {
                    return "Validation Failed...Enter day between 1 to 28"
                }
            }
        }
        
        if(month>12 || month < 1 || year < 0 )
        {
            return "Validation Failed....Enter a valid Date"
        }
        
        return "Validation is Successfull!!!"
    }
    
    //validating if all the start,end months and years are set accordingly
    func isStartEndValid(startyear:Int, startmonth:Int, startday:Int, endyear:Int, endmonth:Int, endday:Int)->Bool
    {
        
        if startyear > endyear
        {
            return false
        }
        
        if startyear == endyear
        {
            if startmonth > endmonth
            {
                return false
            }
            
            if startmonth == endmonth && startday > endday
            {
                return false
            }
            
        }
        
        return true;
        
    }


    //function to find if year is a leap year
    func isLeap(yearInteger:Int)->Bool
    {
        if yearInteger % 400 == 0
        {
            return true
        }
        
        if yearInteger % 100 == 0
        {
            return false
        }
        
        return yearInteger%4 == 0
        
        
    }
    
    
    
}



