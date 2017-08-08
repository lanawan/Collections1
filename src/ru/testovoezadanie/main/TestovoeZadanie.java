package ru.testovoezadanie.main;

import java.util.*;

public class TestovoeZadanie {
    private static final String stroka = "Есть строка состоящая из слов Все слова в ней разделены одним пробелом Нужно преобразовать строку в такую структуру данных которая группирует слова по первой букве в слове " +
            "Затем вывести только группы содержащие более одного элемента Группы должны быть отсортированы в алфавитном порядке по всем буквам в слове " +
            "Слова внутри группы нужно сортировать по убыванию если число символов равное то сортировать в алфавитном порядке ";

    public static void main(String[] args) {
        // Создать пустой массив для сортировки по ключу
        Map<Character, SortedSet<String>> gruppySlov = new TreeMap<>();
        // Разбить строку на массив слов
        String[] slova = stroka.toLowerCase().split(" ");
        // Для каждого слова в массиве
        for (String slovo : slova) {
            // Взять первую букву слова в качестве ключа
            char key = slovo.charAt(0);
            // Создать коллекцию для сортировки значений в ключе пл алфавиту
            SortedSet<String> value = new TreeSet<>();
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
        // Теперь обрабатываем полученный массив по заданным критериям
        Map<Character, List<String>> obrabotannyeGruppySlov = new TreeMap<>();
        for(Map.Entry<Character, SortedSet<String>> e : gruppySlov.entrySet()){
            SortedSet<String> v = e.getValue();
            List<String> gruppa = new ArrayList<>();
            for(String s : v){
                gruppa.add(s);
            }
            // Оставляем если больше одного слова в ключе
            if (gruppa.size()>1){
                // Пишем свой сортировщик по убывающей длинне слов
                Collections.sort(gruppa, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return (o2.length() - o1.length());
                    }
                });
                // И записываем в новый массив результат
                obrabotannyeGruppySlov.put(e.getKey(),gruppa);
            }
        }


        // Демонстрация результата
        for(Map.Entry<Character, List<String>> e : obrabotannyeGruppySlov.entrySet()){
            System.out.println("\n");
            for (String s : e.getValue()){
                System.out.print(s+" ");
            }

        }
    }
}
