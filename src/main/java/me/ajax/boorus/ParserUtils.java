package me.ajax.boorus;

class ParserUtils {

    static Boolean parseBooleanNullable(final String s) {
        if (s == null || s.equals("null"))
            return null;

        return Boolean.parseBoolean(s);
    }

    static Integer parseIntNullable(final String s) {
        if (s == null || s.equals("null"))
            return null;

        return Integer.parseInt(s);
    }

    static Long parseLongNullable(final String s) {
        if (s == null || s.equals("null"))
            return null;

        return Long.parseLong(s);
    }

}
