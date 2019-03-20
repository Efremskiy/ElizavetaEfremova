package homeworks.hw9;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import homeworks.hw9.entities.Options;
import homeworks.hw9.entities.SpellerAnswer;
import homeworks.hw9.entities.SpellerConstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;

public class SpellerCheckTextsApi {

    private HashMap<String, List<String>> params = new HashMap<>();

    public static class ApiBuilder {
        SpellerCheckTextsApi spellerApi;
        private ApiBuilder(SpellerCheckTextsApi spellerApi) {
            this.spellerApi = spellerApi;
        }

        public ApiBuilder setText(List<String> text) {
            spellerApi.params.put(SpellerConstants.TEXT.getText(), text);
            return this;
        }

        public ApiBuilder setOptions(Options... options) {
            spellerApi.params.put(SpellerConstants.OPTIONS.getText(), new ArrayList<>(Arrays
                    .asList(String.valueOf(Options.sumOptions(options)))));
            return this;
        }

        public ApiBuilder setLang(String lang) {
            spellerApi.params.put(SpellerConstants.LANG.getText(), new ArrayList<>(Arrays
                    .asList(lang)));
            return this;
        }

        public Response callApi() {
            return RestAssured
                    .with()
                    .queryParams(spellerApi.params)
                    .log().all()
                    .get(SpellerConstants.SPELLER_API_URL.getText()).prettyPeek();
        }
    }

    public static ApiBuilder with() {
        return new ApiBuilder(new SpellerCheckTextsApi());
    }

    public static List<SpellerAnswer> getSpellerAnswers(Response response){
        List<List<SpellerAnswer>> listOfLists =  new Gson().fromJson(response.asString().trim(),
                new TypeToken<List<List<SpellerAnswer>>>() {}.getType());
        List<SpellerAnswer> result = new ArrayList<>();
        listOfLists.forEach(result::addAll);
        return result;
    }

    public static ResponseSpecification successResponse(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectHeader("Connection", "keep-alive")
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration(){
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .setRelaxedHTTPSValidation()
                .addHeader("custom header2", "header2.value")
                .addQueryParam("requestID", new Random().nextLong())
                .setBaseUri(SpellerConstants.SPELLER_API_URL.getText())
                .build();
    }
}
