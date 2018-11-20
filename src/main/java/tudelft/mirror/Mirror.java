package tudelft.mirror;

class Mirror {
    private static final String INVALID_INPUT_MESSAGE = "String cannot be null";

    String mirrorEnds(String string) {
        if (string == null) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        String mirror = "";

        int begin = 0;
        int end = string.length() - 1;

        for (; begin < end; begin++, end--) {
            if (string.charAt(begin) == string.charAt(end)) {
                mirror += String.valueOf(string.charAt(end));
            } else {
                break;
            }
        }

        return begin == end && mirror.isEmpty() ? string : mirror;
    }
}
