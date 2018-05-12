package log.bewell.login.domain;


/**
 *5/5/2018
 * @reference  https://www.youtube.com/watch?v=VrUrBNM_RL0&t=
 * @author Azeez Yusuff x14443758
 */

import java.util.ArrayList;
import java.util.List;

public class CurrentState {
    public Boolean isFinished;
    public long startTime;
    public int level;
    public int lastWorkoutWeek;
    public int lastWorkoutDay;
    public long lastWorkoutCompletionTime;
    public int nextWorkoutWeek;
    public int nextWorkoutDay;

    public List<HistoryRecord> historyRecords;

    public CurrentState(){
        historyRecords = new ArrayList<HistoryRecord>();
        isFinished = false;
    }
}
