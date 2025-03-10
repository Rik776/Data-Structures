using System;

namespace carWash
{
     public class App
    {
        static void Main(string[] args)
        {
            CarWash carWash = new CarWash();
             carWash.addCar(new Car ("btl-54g", "Ricardo Forero Ortiz") );
             carWash.addCar(new Car ("btl-54", "Ricardo Forero Silva") );
             carWash.addCar(new Car ("btl-5g", "Benito ") );
            Console.WriteLine(carWash.verifyCar().DriverName);
            Console.WriteLine(carWash.washCar().DriverName);
            Console.WriteLine(carWash.washCar().DriverName);
            Console.WriteLine(carWash.washCar().DriverName);


        }
    }
}