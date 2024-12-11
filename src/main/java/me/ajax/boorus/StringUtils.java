package me.ajax.boorus;

class StringUtils {

    static String removeTrailingQuotes(final String input) {
        String output = input;

        if (output.startsWith("\""))
            output = output.substring(1);

        if (output.endsWith("\""))
            if (output.length() == 1)
                output = "";
            else
                output = output.substring(0, output.length() - 1);


        return output;
    }

}
