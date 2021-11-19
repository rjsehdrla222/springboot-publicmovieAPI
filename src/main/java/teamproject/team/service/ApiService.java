package teamproject.team.service;

import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import teamproject.team.controller.ApiController;
import teamproject.team.domain.Board;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
@AllArgsConstructor
public class ApiService {

    private final BoardService boardService;
    private final ApiController apiController;

    static int i = 1;
    static int a, b;

    public void test() {
        Calendar c2 = new GregorianCalendar();
        c2.add(Calendar.DATE, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("D");
        String today = sdf.format(c2.getTime());
        int t = Integer.parseInt(today);
        a = t;
        if (i == 1) {
            i = 0;
            b = t;
            try {
                boardService.boardDelete();
                boardService.boardDelete2();
                boardService.boardDelete3();
                String jsonString1 = apiController.getData(1);
                String jsonString2 = apiController.getData(2);
                String jsonString3 = apiController.getDramaData();

                String[] jsonString = {jsonString1, jsonString2, jsonString3};
                JSONParser parser = new JSONParser();
                JSONArray jsonArray;
                for (int ia = 0; ia < 3; ia++) {
                    Object obj = parser.parse(jsonString[ia]);
                    JSONObject jsonObject = (JSONObject) obj;
                    if (ia < 2) {
                        JSONObject jsonObject1 = (JSONObject) jsonObject.get("boxOfficeResult");

                        if (ia == 0) {
                            jsonArray = (JSONArray) jsonObject1.get("dailyBoxOfficeList");
                        } else {
                            jsonArray = (JSONArray) jsonObject1.get("weeklyBoxOfficeList");
                        }

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject object = (JSONObject) jsonArray.get(i);
                            String title = (String) object.get("movieNm");
                            if (title.contains(":")) {
                                title = title.replace(":", "：");
                            }
                            int ranks = Integer.parseInt((String) object.get("rank"));
                            String attendance = (String) object.get("audiAcc");
                            String openDt = (String) object.get("openDt");

                            int x = i + 1;
                            long ai = Long.valueOf(x);
                            if (ia == 0) {
                                insertData(ai, title, ranks, attendance, openDt);
                            } else {
                                insertData2(ai, title, ranks, attendance, openDt);
                            }
                        }
                    } else {
                        jsonArray = (JSONArray) jsonObject.get("results");

                        for (int i = 0; i < jsonArray.size(); i++) {
                            JSONObject object = (JSONObject) jsonArray.get(i);
                            String title = (String) object.get("original_name");
                            if (title.contains(":")) {
                                title = title.replace(":", "：");
                            }
                            int ranks = ((Long) object.get("vote_count")).intValue();
                            int x = i + 1;
                            long ai = Long.valueOf(x);
                            insertData3(ai, title, ranks);
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (a != b) {
            b = t;
            i = 1;
        }
    }

    public void insertData(long id, String title, int ranks, String attendance, String openDt) {
        Board board = new Board();
        board.setId(id);
        board.setRanks(ranks);
        board.setTitle(title);
        board.setAttendance(attendance);
        board.setUpload_day(openDt);
        boardService.boardInsert(board);
        boardService.totalInsert(board);
    }

    public void insertData2(long id, String title, int ranks, String attendance, String openDt) {
        Board board = new Board();
        board.setId(id);
        board.setRanks(ranks);
        board.setTitle(title);
        board.setAttendance(attendance);
        board.setUpload_day(openDt);
        boardService.totalInsert(board);
        boardService.boardInsert2(board);
    }

    public void insertData3(long id, String title, int ranks) {
        Board board = new Board();
        board.setId(id);
        board.setRanks(ranks);
        board.setTitle(title);
        boardService.totalInsert(board);
        boardService.boardInsert3(board);
    }
}
