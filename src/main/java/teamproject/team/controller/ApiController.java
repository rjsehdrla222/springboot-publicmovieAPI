package teamproject.team.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ApiController {

    public String getData(int version) {

        Map<String, Object> result = new HashMap<String, Object>();
        String jsonInString = "";

        try {
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

            RestTemplate restTemplate = new RestTemplate(factory);
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);

            Calendar c1 = new GregorianCalendar();
            Calendar c2 = new GregorianCalendar();
            c1.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
            c2.add(Calendar.DATE, -7);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 날짜 포맷
            String yesterday = sdf.format(c1.getTime());
            String lastWeek = sdf.format(c2.getTime());
            String url;
            UriComponents uri;
            if (version == 1) {
                url = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
                uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "key=a3e11df8975ca7dd6dc1361d2448c0c1&targetDt=" + yesterday).build();
            } else {
                url = "https://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json";
                uri = UriComponentsBuilder.fromHttpUrl(url + "?" + "key=a3e11df8975ca7dd6dc1361d2448c0c1&targetDt=" + lastWeek + "&weekGb=0").build();
            }
            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result.put("statusCode", resultMap.getStatusCodeValue());
            result.put("header", resultMap.getHeaders());
            result.put("body", resultMap.getBody());

            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultMap.getBody());
        } catch (HttpClientErrorException |
                HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            System.out.println("dfdfdf");
            System.out.println(e.toString());
        } catch (
                Exception e) {
            result.put("statusCode", "999");
            result.put("body", "except 오류");
            System.out.println(e.toString());
        }

        return jsonInString;
    }

    public String getDramaData() {
        Map<String, Object> result = new HashMap<String, Object>();
        String jsonInString = "";

        try {
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

            RestTemplate restTemplate = new RestTemplate(factory);
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(headers);

            String url;
            UriComponents uri;
            url = "https://api.themoviedb.org/3/discover/tv?api_key=4eddcf1fdf02f99add655b69c4a5e2e0&with_networks=213";
            uri = UriComponentsBuilder.fromHttpUrl(url).build();
            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class);
            result.put("statusCode", resultMap.getStatusCodeValue());
            result.put("header", resultMap.getHeaders());
            result.put("body", resultMap.getBody());

            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(resultMap.getBody());
        } catch (HttpClientErrorException |
                HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            System.out.println("dfdfdf");
            System.out.println(e.toString());
        } catch (
                Exception e) {
            result.put("statusCode", "999");
            result.put("body", "except 오류");
            System.out.println(e.toString());
        }

        return jsonInString;
    }

}