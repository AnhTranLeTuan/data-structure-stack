public class SolveProblemsWithStack {

    public static String reverseString(String string){
        if (string == null)
            throw new IllegalArgumentException();

        int stringLength = string.length();
        Stack<Character> charCollection = new Stack<Character>(stringLength);
        for (int i = 0; i < stringLength; i++)
            charCollection.push(string.charAt(i));

        char[] charArray = new char[stringLength];

        for (int i = 0; i < stringLength; i++)
            charArray[i] = charCollection.pop();

        return String.valueOf(charArray);
    }

    public static String checkBalancedExpressions(String balancedString){
        char[] balancedCharArray = balancedString.toCharArray();
        Stack<Character> leftBrackets = new Stack<>();

        for (int i = 0; i < balancedCharArray.length; i++){
            if (isLeftBrackets(balancedCharArray[i]))
                leftBrackets.push(balancedCharArray[i]);

            if (isRightBrackets(balancedCharArray[i])) {
                if (!compareLeftAndRightBrackets(balancedCharArray[i], leftBrackets))
                    return "The " + "\'" + balancedCharArray[i] + "\' " +
                            "bracket doesn't match with its corresponding left bracket.";
            }
        }

        if (!leftBrackets.isEmpty())
            return "There are not enough corresponding right brackets.";

        return "The expression is balanced.";
    }

    private static boolean isLeftBrackets(char character){
        return character == '(' || character == '[' || character == '{' || character == '<';
    }

    private static boolean isRightBrackets(char character){
        return character == ')' || character == ']' || character == '}' || character == '>';
    }

    private static boolean compareLeftAndRightBrackets(char character, Stack<Character> leftBrackets){
        if (character == ')') {
            if (leftBrackets.pop() == '(')
                return true;
        } else if (character == ']'){
            if (leftBrackets.pop() == '[')
                return true;
        } else if (character == '}'){
            if (leftBrackets.pop() == '{')
                return true;
        } else if (character == '>'){
            if (leftBrackets.pop() == '<')
                return true;
        }

        return false;
    }

}
