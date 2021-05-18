public class Romes extends Operations {
    String operand1;
    String operand2;
    int operand1Int;
    int operand2Int;
    int resultInt;
    String sign;
    String resultString;
    final String[] romes = {"I","II","III","IV","V","VI","VII","VIII","IX"};

    public Romes(String operand1,String operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
        operand1Int = convertToInt(operand1);
        operand2Int = convertToInt(operand2);
    }

    private int convertToInt(String romes){
        char[] valueChar = romes.toCharArray();
        int[] valuesInt = new int[valueChar.length];
        for(int i = 0; i< valueChar.length;i++) {
            switch (valueChar[i]) {
                case 'I':
                    valuesInt[i] = 1;
                    break;
                case 'V':
                    valuesInt[i] = 5;
                    break;
                case 'X':
                    valuesInt[i] = 10;
                    break;

                default:
                    System.out.println("Проверьте правильность ввода римских цифр: ");
                    break;
            }
        }
        int result = valuesInt[0];
        for(int i = 0; i < valuesInt.length && valuesInt.length > i+1; i++){
            if(valuesInt[i] >= valuesInt[i+1]){
                result += valuesInt[i+1];
            }
            else if(valuesInt[i] < valuesInt[i+1]){
                result = result +valuesInt[i+1] - 2;
            }
        }
        return result;
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int times = 0;
        String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",
                "XC", "C", "CD", "D", "CM", "M" };
        int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,
                900, 1000 };
        for (int i = ints.length - 1; i >= 0; i--) {
            times = num / ints[i];
            num %= ints[i];
            while (times > 0) {
                sb.append(romans[i]);
                times--;
            }
        }
        return sb.toString();
    }


    public String getRomesOperand1(){
        return operand1;
    }

    public String getRomesOperand2(){
        return operand2;
    }

    public void setRomesOperand1(String operand1){
        this.operand1 = operand1;
    }

    public void setRomesOperand2(String operand2){
        this.operand2 = operand2;
    }

    public int getOperand1Int(){
        return operand1Int;
    }

    public int getOperand2Int(){
        return operand2Int;
    }

    public void setOperand1Int(int operand1Int){
        this.operand1Int = operand1Int;
    }

    public void setOperand2Int(int operand2Int){
        this.operand2Int = operand2Int;
    }



    @Override
    public void plus() {
        resultInt = operand1Int + operand2Int;
        resultString = intToRoman(resultInt);
    }

    @Override
    public void minus() {
        resultInt = operand1Int - operand2Int;
        resultString = intToRoman(resultInt);
    }

    @Override
    public void multiply() {
        resultInt = operand1Int * operand2Int;
        resultString = intToRoman(resultInt);
    }

    @Override
    public void divide() {
        try {
            resultInt = operand1Int / operand2Int;
            resultString = intToRoman(resultInt);
        }catch (ArithmeticException e){
            System.out.println("Вероятно введены и арабские и римские цифры одновременно.");
            return;
        }
    }

    @Override
    public int getResult() {
        return resultInt;
    }

    @Override
    public String getStringResult() {
        return resultString;
    }
}
