import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.text.StringEscapeUtils;


import java.nio.charset.StandardCharsets;


public class TextSummarizer {

    public static void main(String[] args) throws UnirestException {


        SummerizerRequest("https://en.wikipedia.org/wiki/Mozart", 10);


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

    public static void SummerizerRequest(String url, int numberOfsentences) throws UnirestException {

        String post_body = ("url=" + url.replace(":", "%3A").replace("/", "%2F") + "&sentnum=" + numberOfsentences);

//          TODO: UTF ENCODINGS

//                .replace("Ä", "%C3%84")
//                .replace("Ö", "%C3%96")
//                .replace("Ü", "%C3%9C")
//                .replace("ß", "%C3%9F")
//                .replace("ä", "%C3%A4")
//                .replace("ö", "%C3%B6")
//                .replace("ü", "%C3%BC");
//                .replace("Ü", "&Uuml")
//                .replace("Ä", "&Auml")
//                .replace("Ö", "&Ouml")
//                .replace("ü", "&uuml")
//                .replace("ä", "&auml")
//                .replace("ö", "&ouml")
//                .replace("ß", "&szlig");
//                .replace("Ä", "&#196")
//                .replace("Ö", "&#214")
//                .replace("Ü", "&#220")
//                .replace("ß", "&#223")
//                .replace("ä", "&#228")
//                .replace("ö", "&#246")
//                .replace("ü", "&#252")
//                .replace("\\u00e4", "ä")
//                .replace("\\u00c4", "Ä")
//                .replace("\\u00d6", "Ö")
//                .replace("\\u00f6", "ö")
//                .replace("\\u00dc", "Ü")
//                .replace("\\n", "")
//                .replace("\\u00fc", "ü")
//                .replace("\\u00df", "ß")
//                .replace("\\u201e", "„")
//                .replace("\\u201c", "\"")
//                .replace("\\u00e9", "e")

        HttpResponse<String> response = Unirest.post("https://textanalysis-text-summarization.p.rapidapi.com/text-summarizer-url")
                .header("content-type", "application/x-www-form-urlencoded")
                .header("x-rapidapi-key", "250f71bf98mshd779c3b5224257ep193414jsn39f10e42adb3")
                .header("x-rapidapi-host", "textanalysis-text-summarization.p.rapidapi.com")
                .body(post_body)
                .asString();

        String response_utf8 = new String(response.getBody().getBytes(StandardCharsets.UTF_8));
        String clean_response = StringEscapeUtils.unescapeJava(response_utf8);

        System.out.print(clean_response);

    }


}
