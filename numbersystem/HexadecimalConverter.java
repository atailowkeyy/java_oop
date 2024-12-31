package hus.oop.numbersystem;

import java.math.BigInteger;

public class HexadecimalConverter extends AbstractNumberConverter {
    public HexadecimalConverter(MyNumber originalNumber) {
        /* TODO */
        super(originalNumber);
    }

    /*
     * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
     * sang số được biểu diễn trong hệ cơ số 16.
     * @param decimal
     * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
     *
     * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
     * không sử dụng thư viện chuyển đổi số có sẵn của Java.
     */
    @Override
    public String decimalTo(String decimal) {
        /* TODO */
        BigInteger number = new BigInteger(decimal);
        BigInteger sixteen = BigInteger.valueOf(16);
        StringBuilder result = new StringBuilder();
        while(number.compareTo(BigInteger.ZERO) > 0){
            BigInteger temp = number.mod(sixteen);
            int val = temp.intValue();
            char hex;
            if(val <= 9){
                hex = (char) ((char)val + '0');
            }else{
                hex = (char) ((char)val + 'A' - 10);
            }
            result.insert(0, hex);
            number = number.divide(sixteen);
        }
        return result.toString();
    }

    /*
     * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
     * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal 
     * số được chuyển đổi theo định dạng a1a2...an(16).
     */
    @Override
    public void update() {
        /* TODO */
        convert();
        display();
    }

    /*
     * Hiển thị số ra terminal theo định dạng a1a2...an(16).
     */
    @Override
    public void display() {
        /* TODO */
        System.out.println(convertedNumber + "(16)");
    }
}
