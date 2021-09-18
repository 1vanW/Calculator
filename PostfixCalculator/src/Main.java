import java.util.Scanner;
import java.util.Stack;
// суть работы проста пишем числа а потом пишем оператор который мы к ним применяем что то типо 5 2 + (ответ будет 7)
public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //Записываем с консоли строку
        String str = in.nextLine();
        // Разбиваем строку на массив строк по делителю " " т.е по пробелу
        String [] strings = str.split(" ");
        // Создаем стопку со значением Double
        Stack<Double> stack = new Stack<Double>();

    //создаем цикл который пройдет по всей стопке будет проверять массив строк strings и уже точно переобразовать в Double
        for (int i = 0; i< strings.length; i++) {
            //проверяет может ли он спарсить строку если да то парсит
            if (isNumber(strings[i])) {
                stack.push(Double.parseDouble(strings[i]));
            } else {
                // создаем переменые в которые помешаем первый элемент стопки а затем удаляем его оттуда
                double tmp1 = stack.pop();
                double tmp2 = stack.pop();
                switch (strings[i]){
                    case "+":
                        stack.push(tmp1 + tmp2);
                        break;
                    case "-":
                        stack.push(tmp2 - tmp1);
                        break;
                    case "*":
                        stack.push(tmp1*tmp2);
                        break;
                    case "/":
                        stack.push(tmp2/tmp1);
                        break;
                }
            }
        }

        // проверяем пустая очередь или нет
        if (!stack.empty()){
            System.out.println(stack.pop());

        }
        else{
            System.out.println("Стэк пуст");
        }
    }


// метод который возвращает истину или ложь если сможет преобразовать строку в Double тип
    private static boolean isNumber(String str){
        try {
            Double.parseDouble(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
