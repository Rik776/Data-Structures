using System;
namespace carWash
{
    public class Car
    {
        public string CarPlate{get; set;}
        public string DriverName{get; set;}

        public Car(string carPlate, string driverName){
            CarPlate = carPlate;
            DriverName = driverName;
        }
        
    }
}