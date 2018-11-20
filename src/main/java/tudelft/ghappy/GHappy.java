package tudelft.ghappy;

class GHappy {
    private static final String INVALID_INPUT_MESSAGE = "String does not contain 'g'";

    boolean isEveryGHappy(String str) {
        if (str == null || !str.contains("g")) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                if (i > 0 && str.charAt(i-1) == 'g') { continue; }
                if (i+1 < str.length() && str.charAt(i+1) == 'g') { continue; }

                return false;
            }
        }

        return true;
    }
}
