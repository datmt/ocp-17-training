package com.datmt.ocp17.building_blocks;

public class TextBlock {

    public static void main(String[] args) {

        //1. Example
        String textBlock = """
                This is a text block
                """;
        System.out.println(textBlock);

        //2. Essential & Incidental white space
        String textBlock2 = """
                     This is a text block
                         this is essential white space
                     """;
        System.out.println(textBlock2);

        String textBlock3 = """
              This is a text block
                  this is essential white space
              """;

        System.out.println(textBlock3.equals(textBlock2));

        //3. Skip new line
        String textBlock4 = """
              This is a text block \
                   this will not be printed on a new line
              """;

        System.out.println(textBlock4);

        //4. Escape characters
        String textBlock5 = """
              This is a text block 5: \
                   this "will not" be \"printed\" on a new line \
                   this is a new line \n \
                   this is a tab \t
              """;

        System.out.println(textBlock5);

        //5. New line at the end results in 2 new lines
        String textBlock6 = """
              This is text block 6:
              First line \n
                   Second line
                   Last line
              """;

        System.out.println(textBlock6);

        //6. Invalid text block
        // String textBlock7 = """ """; // this will not compile

        String textBlock7 = """
                Single line block \s""";
        System.out.println("Textblock7: " + textBlock7 + "*");
        System.out.println(textBlock7.length() + "-" + textBlock7.trim().length());
    }
}
