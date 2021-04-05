import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Arrays;


public class TextSummerizer {

    public static void main(String[] args) throws UnirestException, ParseException, org.json.simple.parser.ParseException, UnsupportedEncodingException {

        String urlORtext = "https://de.wikipedia.org/wiki/Meditation";
        int numberOfSentences = 5;

        SummerizerRequest("https://de.wikipedia.org/wiki/Stefan_Kaminsky_(Bankmanager)", 10);


//        HttpResponse<String> response = Unirest.post("https://textanalysis-text-summarization.p.rapidapi.com/text-summarizer-url")
//                .header("content-type", "application/x-www-form-urlencoded")
//                .header("x-rapidapi-key", "250f71bf98mshd779c3b5224257ep193414jsn39f10e42adb3")
//                .header("x-rapidapi-host", "textanalysis-text-summarization.p.rapidapi.com")
//                .body("url=http%3A%2F%2Fen.wikipedia.org%2Fwiki%2FMeditation&sentnum=5") //sentnum = how many sentences
//                .asString();
//
//        String string = new String(response.getBody().getBytes("ISO-8859-1"));
//
//        System.out.print(string);

    }

    public static void SummerizerRequest(String url, int numberOfsentences) throws UnirestException, UnsupportedEncodingException {

        String post_body = new String("url=" + url.replace(":", "%3A").replace("/","%2F") + "&sentnum=" + numberOfsentences);

        HttpResponse<String> response = Unirest.post("https://textanalysis-text-summarization.p.rapidapi.com/text-summarizer-url")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("x-rapidapi-key", "250f71bf98mshd779c3b5224257ep193414jsn39f10e42adb3")
                .header("x-rapidapi-host", "textanalysis-text-summarization.p.rapidapi.com")
                .body(post_body) //sentnum = how many sentences
                .asString();

        String string = new String(response.getBody().getBytes("UTF-8"));

        System.out.print(string);

    }


}
