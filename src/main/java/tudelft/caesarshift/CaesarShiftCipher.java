package tudelft.caesarshift;

class CaesarShiftCipher {
    private static final String INVALID_INPUT_MESSAGE = "invalid";

    String cipher(String message, int shift){
        StringBuilder sb = new StringBuilder();
        char currentChar;
        int length = message.length();

        shift = shift % 26;

        for (int i = 0; i < length; i++){
            currentChar = message.charAt(i);

            if (currentChar > 'z' || currentChar < 'a') {
                if (currentChar == ' ') {
                    sb.append(currentChar);
                    continue;
                }

                return INVALID_INPUT_MESSAGE;
            } else if ((char) (currentChar + shift) > 'z') {
                currentChar = (char) (currentChar - 26);
            } else if ((char) (currentChar + shift) < 'a'){
                currentChar = (char) (currentChar + 26);
            }

            sb.append((char) (currentChar + shift));
        }

        return sb.toString();
    }
}
