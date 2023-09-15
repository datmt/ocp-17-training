package com.datmt.ocp17.loop_branch;

import java.util.List;

public class FlowControl {

}

class IfStatementDemo {
    enum DAYS {
        MONDAY,
        TUESDAY
    }

    public static void main(String[] args) {
        int dayOfWeek = 3;
        //char, byte, short, int Character, Byte, Short, Integer, String, Enum
        DAYS dayOfWeekEnum = DAYS.MONDAY;
        var String = switch (dayOfWeekEnum) {
            case MONDAY -> "Monday";
            case TUESDAY -> {
                System.out.println("It's Thursday");
                yield "Thursday";
            }
        };

    }
}

















