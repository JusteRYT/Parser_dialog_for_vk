package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("MyDialog.txt", "UTF-8");
        File folder = new File("C:/Users/juste/PycharmProjects/pythonProject1/bot/vk/bot_corpus/messages/");
        File[] listOffiles = folder.listFiles();
        for (File file1 : listOffiles) {
            if (file1.isDirectory()) {
                File folder1 = new File(String.format("C:/Users/juste/PycharmProjects/pythonProject1/bot/vk/bot_corpus/messages/%s", file1.getName()));
                File[] listOfFiles1 = folder1.listFiles();
                for (File file2 : listOfFiles1) {
                    if (file2.isFile()) {
                        for (int i = 0; i < listOfFiles1.length; i++) {
                            File html1 = new File(folder1 + "\\" + file2.getName());
                            Document document1 = Jsoup.parse(html1);
                            Elements list = document1.getElementsByClass("item");
                            try {
                                for (Element elements : list) {
                                    String elementstext = elements.getElementsByClass("item").get(i).
                                            getElementsByClass("item__main").get(0).getElementsByClass("message")
                                            .get(0).getElementsByTag("div").get(2)
                                            .getElementsByTag("div").get(0).text();
                                    if (elementstext.equals("Запись на стене")) {

                                    } else if (elementstext.startsWith("Файл")) {

                                    } else if (elementstext.startsWith("Фотография")) {

                                    } else if (elementstext.contains("прикреплённых сообщения")) {

                                    } else {
                                        System.out.println(elementstext);
                                        writer.println("- " + elementstext + "\n");
                                    }
                                }
                            }catch (IndexOutOfBoundsException e){
                                System.out.println("Закончил");
                            }
                        }
                    }
                }
            }
        } writer.close();
    }
}