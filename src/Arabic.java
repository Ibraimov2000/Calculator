public class Arabic extends Operations {
    int operand1;
    int operand2;
    int result;

    Arabic(int operand1, int operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void plus() {
        this.result = operand1 + operand2;
    }

    @Override
    public void minus() {
        this.result = operand1 - operand2;
    }

    @Override
    public void multiply() {
        this.result = operand1 * operand2;
    }

    @Override
    public void divide() {
        try {
            this.result = operand1 / operand2;
        }catch (ArithmeticException e){
            System.out.println("Нельзя делить на ноль!");
            return;
        }
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getStringResult() {
        return "" + result;
    }
}
