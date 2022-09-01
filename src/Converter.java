public class Converter {
        double stepDistance = 0.75; // Среднее расстояние одного шага
        double caloriesBurn = 50; // Среднее количество сжигаемых калорий за один шаг

        double distance(int numSteps) {
            return (numSteps * stepDistance / 1000);
        }
        double calories(int numSteps){
            return (numSteps * caloriesBurn / 1000);
        }
    }