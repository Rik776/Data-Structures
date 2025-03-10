using System;
namespace carWash
{
   public class CarWash
   {
    private Queue<Car> cars;
    public CarWash(){   
        cars = new Queue<Car>();

    }
    public void addCar(Car car) 
    {
        cars.Add(car);
    }
    public Car washCar()
    {
        return cars.pullValue();
    }
    public Car verifyCar(){
        return cars.GetValue();
    }
   
   }
}