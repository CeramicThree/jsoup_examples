package examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GoogleCovid {
    public static void infoParse(){
        StringBuilder covidInfo = new StringBuilder();
        try {
            Document document = Jsoup.connect("https://news.google.com/covid19/map?hl=ru&gl=RU&ceid=RU%3Aru&mid=%2Fm%2F06bnz").get();
            Elements elements = document.select("div.UvMayb");
            covidInfo.append(elements.text());
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] covidArray = covidInfo.toString().split(" ");
        System.out.println("Россия: \nЗаражений всего: " + covidArray[0] + " " + covidArray[1] +
                "\nВыздоровело: " + covidArray[2] + " " + covidArray[3] +
                "\nУмерло: " + covidArray[4] + " " + covidArray[5]);
    }

    public static void main(String[] args){
        GoogleCovid.infoParse();
    }
}
