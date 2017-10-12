package ru.testovoezadanie.main;

import java.util.*;

public class TestovoeZadanie {
    private static final String stroka = "Есть строка состоящая из слов Все слова в ней разделены одним пробелом Нужно преобразовать строку в такую структуру данных которая группирует слова по первой букве в слове " +
            "Затем вывести только группы содержащие более одного элемента Группы должны быть отсортированы в алфавитном порядке по всем буквам в слове " +
            "Слова внутри группы нужно сортировать по убыванию если число символов равное то сортировать в алфавитном порядке ";

    public static void main(String[] args) {
        // Создать пустой массив для сортировки по ключу
        Map<Character, Set<String>> gruppySlov = new TreeMap<>();
        // Разбить строку на массив слов
        String[] slova = stroka.toLowerCase().split(" ");
        // Для каждого слова в массиве
        for (String slovo : slova) {
            // Взять первую букву слова в качестве ключа
            char key = slovo.charAt(0);
            // Создать коллекцию для сортировки значений в ключе пл алфавиту
            Comparator<String> sravnitel = (o1,o2) -> o2.length() - o1.length();
            Set<String> value = new TreeSet<String>(sravnitel);
            // Если в массив мы уже записали этот ключ ранее
            if(gruppySlov.containsKey(key)){
                // То извлекаем значение этого ключа
                value = gruppySlov.get(key);
            }
            // И записываем в коллекцию любо новое значение либо добавляем к уже существующему в этом ключе массива
            value.add(slovo);
            // Обновляем ключ массива со значением
            gruppySlov.put(key, value);
        }
        // Демонстрация результата
        System.out.println(gruppySlov.toString());
    }
}
