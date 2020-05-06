package examples;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;

public class YandexWeather {
    public static String todayWeather(){
        String Weather = "";
        try {
            Document document = Jsoup.connect("https://yandex.ru").get();
            Elements element = document.select("#div.weather__temp");
            Weather = element.text();
        }catch (IOException e){
            e.printStackTrace();
        }
        return Weather;
    }

    public static void main(String[] args) {
        System.out.println("Сейчас температура на улице " + YandexWeather.todayWeather() + "градусов.");
    }
}
