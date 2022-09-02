import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter Con = new Converter();
    int targetValue = 10000;
    // int newTargetValue;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void quantitySteps() {
        System.out.println("Введите номер месяца:");
        System.out.println("1 - Январь");
        System.out.println("2 - Февраль");
        System.out.println("3 - Март");
        System.out.println("4 - Апрель");
        System.out.println("5 - Май");
        System.out.println("6 - Июнь");
        System.out.println("7 - Июль");
        System.out.println("8 - Август");
        System.out.println("9 - Сентябрь");
        System.out.println("10 - Октябрь");
        System.out.println("11 - Ноябрь");
        System.out.println("12 - Декабрь");
        int monthNumber = scanner.nextInt();
        if (monthNumber > 12 || monthNumber < 1) {
            System.out.println("Неверный номер месяца.");
            return;
        }
        System.out.println("Введите номер дня (1-30)");
        int dayNumber = scanner.nextInt();
        if (dayNumber > 30 || dayNumber < 1) {
            System.out.println("Указан неверный день.");
            return;
        }
        System.out.println("Введите количество пройденных шагов:");
        int numSteps = scanner.nextInt();
        if (numSteps < 0) {
            System.out.println("Указано отрицательное значение.");
            return;
        }
        monthToData[monthNumber].inputDayData(dayNumber, numSteps);
        System.out.println("Данные успешно сохранены.");
    }

    void statPrint() {
        System.out.println("Введите номер месяца:");
        System.out.println("1 - Январь");
        System.out.println("2 - Февраль");
        System.out.println("3 - Март");
        System.out.println("4 - Апрель");
        System.out.println("5 - Май");
        System.out.println("6 - Июнь");
        System.out.println("7 - Июль");
        System.out.println("8 - Август");
        System.out.println("9 - Сентябрь");
        System.out.println("10 - Октябрь");
        System.out.println("11 - Ноябрь");
        System.out.println("12 - Декабрь");
        int monthNumber = scanner.nextInt();
        if (monthNumber > 12 || monthNumber <= 1) {
            System.out.println("Неверный номер месяца.");
        }

        printFullStat(monthNumber);
        System.out.println("1. Общее количество шагов за месяц: " + calcSteps(monthNumber));
        System.out.println("2. Максимальное пройденное количество шагов в месяце: " + maxStepsPerDay(monthNumber));
        System.out.println("3. Среднее количество шагов: " + calcSteps(monthNumber) / monthToData[monthNumber].dayData.length);
        System.out.println("4. Пройденная дистанция (в км): " + Con.distance(calcSteps(monthNumber)));
        System.out.println("5. Количество сожжённых килокалорий: " + Con.calories(calcSteps(monthNumber)));
        System.out.println("6. Лучшая серия шагов: " + bestSeries(monthNumber));
    }

    void printFullStat(int monthNumber) {
        for (int j = 0; j < monthToData[monthNumber].dayData.length; j++) {
            System.out.print(j + 1 + " день: " + monthToData[monthNumber].dayData[j] + ", ");
        }
        System.out.println(" ");
    }

    int calcSteps(int monthNumber) {
        int calcSteps = 0;
        for (int j = 0; j < monthToData[monthNumber].dayData.length; j++) {
            calcSteps += monthToData[monthNumber].dayData[j];
        }
        return calcSteps;
    }

    int maxStepsPerDay(int monthNumber) {
        int stepsPerDay = 0;
        for (int j = 0; j < monthToData[monthNumber].dayData.length; j++) {
            if (stepsPerDay < monthToData[monthNumber].dayData[j])
                stepsPerDay = monthToData[monthNumber].dayData[j];
        }
        return stepsPerDay;
    }

    void newTarget() {
        System.out.println("Введите новую цель по количеству шагов:");
        int newTarget = scanner.nextInt();
        if (newTarget > 0) {
            targetValue = newTarget;
            System.out.println("Цель по количеству шагов обнавлена " + targetValue);
        } else if (newTarget < 0) {
            System.out.println("Указано отрицательное значение.");
        }
    }
    int bestSeries(int monthNumber) {
        int series = 0;
        int bestSeries = 0;
        for (int j = 0; j < monthToData[monthNumber].dayData.length; j++) {
            if (monthToData[monthNumber].dayData[j] >= targetValue) {
                series = series + 1;
                if (bestSeries < series) {
                    bestSeries = series; }
            } else {
                series = 0;
            }
        }
        return bestSeries;
    }

    class MonthData {
        int[] dayData; // days
        MonthData() {
            dayData = new int[30]; // days
        }
        void inputDayData(int dayNumber, int numSteps) {
            dayData[dayNumber] = numSteps; // Заполните класс самостоятельно
        }
    }
}