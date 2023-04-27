import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str1 = "Сервісний центр\n" +
                "У ремонтних роботах, спеціалізуємося на:\n" +
                "- ремонт/налаштування персональних комп'ютерів\n" +
                "- ремонт/налаштування ноутбуків\n" +
                "- ремонт/налаштування планшетів\n" +
                "- ремонт/налаштування телевізорів\n" +
                "- ремонт/налаштування ігрових приставок (playstation, xbox)\n" +
                "- ремонт моніторів\n" +
                "Контактні телефони сервісного відділу:\n" +
                "(+380)50-333-33-33\n" +
                "(+380)97-444-55-66\n" +
                "(+380)98-777-88-99\n" +
                "Інтернет магазин комп'ютерної техніки\n";
        String str2 = "Я хочу    бути     програмістом";
        String str3 = "<div>\n" +
                "<p>Символи круглих дужок <code>'('</code> та <code>')'</code>. <br />Ці символи\n" +
                "дозволяють отримати з рядка додаткову інформацію.\n" +
                "<br/>Зазвичай, якщо парсер регулярних виразів шукає в тексті інформацію\n" +
                "за заданим виразом і знаходить її - він просто повертає\n" +
                "знайдений рядок.</p>\n" +
                "<p align=\"right\">А ось тут <a href=\"google.com\">посилання</a>, щоб життя медом не здавалося.</p>\n" +
                "</div>";

        String pattern1 = "\\(\\+380\\)\\d{2}-\\d{3}-\\d{2}-\\d{2}";
        String pattern2 = "\\s+";
        String pattern3 = "(<.*?>)";

        Pattern pattern = Pattern.compile(pattern1);
        Matcher matcher = pattern.matcher(str1);

        System.out.println("1. Пошук телефонних номерів");
        System.out.println("\nТекст:");
        System.out.println(str1);

        System.out.println("Результати роботи:");

        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            System.out.println("Знайдено номер телефону: " + str1.substring(start,end) + " з "+ start + " по " + (end-1) + " позицію");
        }

        pattern = Pattern.compile(pattern2);
        matcher = pattern.matcher(str2);

        System.out.println("\n\n2. Видалення зайвих пробілів");
        System.out.println("\nТекст:");
        System.out.println(str2);
        System.out.println("\nРезультати роботи:");
        System.out.print(matcher.replaceAll(" "));

        pattern = Pattern.compile(pattern3);
        matcher = pattern.matcher(str3);

        System.out.println("\n\n\n3. Видалення html тегів");
        System.out.println("\nТекст:");
        System.out.println(str3);
        System.out.println("\nРезультати роботи:");
        System.out.println(matcher.replaceAll(""));
    }
}