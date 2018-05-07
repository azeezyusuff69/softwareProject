package log.bewell.login;

import android.app.Activity;
import android.os.Bundle;

import log.bewell.login.adapter.ProgressAdapter;
import log.bewell.login.domain.CurrentState;
import log.bewell.login.domain.TrainingHelper;

import se.emilsjolander.stickylistheaders.ExpandableStickyListHeadersListView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;


public class ProgressActivity extends Activity {

    ExpandableStickyListHeadersListView workoutList;

    StickyListHeadersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        workoutList = (ExpandableStickyListHeadersListView )findViewById(R.id.workouts_list);

        CurrentState currentState = TrainingHelper.getCurrentState(this);

        adapter = new ProgressAdapter(this, currentState.historyRecords);
        workoutList.setAdapter(adapter);

    }
}
