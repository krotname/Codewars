package kyu4;

public class TimeFormatter {
    // 4 https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java
    /*Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.

The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.

It is much easier to understand with an example:

TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
For the purpose of this Kata, a year is 365 days and a day is 24 hours.

Note that spaces are important.

Detailed rules
The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.

The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.

A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.

Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.

A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.

A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.*/
    private static int currentSeconds;
    private static int currentMinutes;
    private static int currentHours;
    private static int currentDays;
    private static int currentYears;
    private static int currentCount;

    public static void main(String[] args) {
        System.out.println(formatDuration(0));
        System.out.println(formatDuration(1));
        System.out.println(formatDuration(44));
        System.out.println(formatDuration(60));
        System.out.println(formatDuration(3200));
        System.out.println(formatDuration(1201));
        System.out.println(formatDuration(12001));
        System.out.println(formatDuration(31596000));
        System.out.println(formatDuration(1596000));
        System.out.println(formatDuration(132030240));
        System.out.println(formatDuration(132030240));
    }

    public static String formatDuration(int seconds) {
        if (seconds <= 0) return "now";
        calculate(seconds);
        return format().trim();
    }

    private static void calculate(int secondsTime) {
        currentSeconds = 0;
        currentMinutes = 0;
        currentHours = 0;
        currentDays = 0;
        currentYears = 0;
        currentCount = 0;

        if (secondsTime > 31536000) {
            currentYears = secondsTime / 31536000; // 60*60*24*365=31536000
            secondsTime = secondsTime % 86400;
        }
        if (secondsTime < 31536000 && secondsTime >= 86400) {
            currentDays = secondsTime / 86400; // 60*60*24=86400
            secondsTime = secondsTime % 86400;
        }
        if (secondsTime < 86400 && secondsTime >= 3600) {
            currentHours = secondsTime / 3600; // 60*60=3600
            secondsTime = secondsTime % 3600;
        }
        if (secondsTime < 3600 && secondsTime >= 60) {
            currentMinutes = secondsTime / 60;
            secondsTime = secondsTime % 60;
        }
        if (secondsTime < 60 && secondsTime > 0) {
            currentSeconds = secondsTime;
        }
        if (currentYears != 0) currentCount++;
        if (currentDays != 0) currentCount++;
        if (currentHours != 0) currentCount++;
        if (currentMinutes != 0) currentCount++;
        if (currentSeconds != 0) currentCount++;
    }

    private static String format() {
        String result = "";
        if (currentYears != 0) {
            result = addYears(result);
        }
        if (currentDays != 0) {
            result = addDays(result);
        }
        if (currentHours != 0) {
            result = addHours(result);
        }
        if (currentMinutes != 0) {
            result = addMinutes(result);
        }
        if (currentSeconds != 0) {
            result = addSeconds(result);
        }
        return result;
    }


    private static String addSeconds(String stringTime) {
        if (currentSeconds == 1) {
            stringTime = stringTime + currentSeconds + " second";
        } else {
            stringTime = stringTime + currentSeconds + " seconds";
        }
        return stringTime;
    }

    private static String addMinutes(String stringTime) {
        if (currentMinutes == 1) {
            stringTime = stringTime + currentMinutes + " minute";
        } else {
            stringTime = stringTime + currentMinutes + " minutes";
        }
        stringTime = addSeparator(stringTime);
        return stringTime;
    }

    private static String addHours(String stringTime) {
        if (currentHours == 1) {
            stringTime = stringTime + currentHours + " hour";
        } else {
            stringTime = stringTime + currentHours + " hours";
        }
        stringTime = addSeparator(stringTime);
        return stringTime;
    }

    private static String addDays(String stringTime) {
        if (currentDays == 1) {
            stringTime = stringTime + currentDays + " day";
        } else {
            stringTime = stringTime + currentDays + " days";
        }
        stringTime = addSeparator(stringTime);
        return stringTime;
    }

    private static String addYears(String stringTime) {
        if (currentYears == 1) {
            stringTime = stringTime + currentYears + " year";
        } else {
            stringTime = stringTime + currentYears + " years";
        }
        stringTime = addSeparator(stringTime);
        return stringTime;
    }

    private static String addSeparator(String stringTime) {
        currentCount--;
        if (currentCount > 1) {
            stringTime = stringTime + ", ";
        } else if (currentCount == 1) {
            stringTime = stringTime + " and ";
        }
        return stringTime;
    }

}
