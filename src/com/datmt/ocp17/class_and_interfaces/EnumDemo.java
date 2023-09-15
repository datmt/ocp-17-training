package com.datmt.ocp17.class_and_interfaces;

public class EnumDemo {

    interface Time {
        void time();
    }

    enum DAYS implements Time{
        TODAY(0) {
            @Override
            void printInfo() {

            }
        },
        TOMORROW(1) {
            @Override
            void printInfo() {

            }
        },
        YESTERDAY(-1) {
            @Override
            void printInfo() {

            }
        };

        private final int relativeDay;

        DAYS(int relativeDay) {
            this.relativeDay = relativeDay;
        }

        public int getRelativeDay() {
            return relativeDay;
        }
        public void time() {
            System.out.println("Time is 12:00 AM");
        }

        abstract void printInfo();
    }

    public static void main(String[] args) {

        //print the relative day for each enum value
        for (DAYS day : DAYS.values()) {
            System.out.println(day + " is " + day.getRelativeDay() + " day");
        }
    }
}
