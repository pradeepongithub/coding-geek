public class BitwiseOperator {

    public static void main(String[] args) {
        System.out.println("Bitwise OR --> " + bitwiseOr(12));
        System.out.println("Bitwise And --> " + bitwiseAnd(12));
        System.out.println("Bitwise XOR --> " + bitwiseXor(12));
        System.out.println("Bitwise Left Shift --> " + bitwiseLeftShift(12));
        System.out.println("Bitwise Right Shift --> " + bitwiseRightShift(12));
        System.out.println("Bitwise Unsigned Right Shift --> " + bitwiseUnsignedRightShift(12));
    }

    private static int bitwiseUnsignedRightShift(int i) {
        return i>>>1;
    }

    private static int bitwiseRightShift(int i) {
        return i>>1;
    }

    private static int bitwiseLeftShift(int i) {
        return i<<1;
    }

    public static int bitwiseOr(int number){
        return number | 1;
    }

    public static int bitwiseAnd(int number){
        return number & 1;
    }

    public static int bitwiseXor(int number){
        return number ^ 1;
    }
}