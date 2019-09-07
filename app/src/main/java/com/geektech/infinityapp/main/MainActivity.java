package com.geektech.infinityapp.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.geektech.infinityapp.R;
import com.geektech.infinityapp.data.BoredApiClient;
import com.geektech.infinityapp.data.IBoredApiClient;
import com.geektech.infinityapp.model.BoredAction;
import com.geektech.infinityapp.model.EActionType;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @OnClick(R.id.next)
    void onClick(View view){
        refreshAction();
    }
    @BindView(R.id.tv_task) TextView task;
    @BindView(R.id.tv_category) TextView category;
    @BindView(R.id.tv_price) TextView price;
    @BindView(R.id.tv_participants) ImageView participants;
    @BindView(R.id.tv_accessibility) ProgressBar accessibility;
    @BindView(R.id.loading_progress) ProgressBar loadingProgressBar;
    @BindView(R.id.nice_spinner) NiceSpinner niceSpinner;

    List<EActionType> type = Arrays.asList(EActionType.values());

    public static void start(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



        refreshAction();
        niceSpinner.attachDataSource(type);
    }

    private void hideViews(){
        task.setVisibility(View.INVISIBLE);
        category.setVisibility(View.INVISIBLE);
        price.setVisibility(View.INVISIBLE);
        accessibility.setVisibility(View.INVISIBLE);
        participants.setVisibility(View.INVISIBLE);
        loadingProgressBar.setVisibility(View.VISIBLE);
    }

    private void showViews(){
        task.setVisibility(View.VISIBLE);
        category.setVisibility(View.VISIBLE);
        price.setVisibility(View.VISIBLE);
        accessibility.setVisibility(View.VISIBLE);
        participants.setVisibility(View.VISIBLE);
        loadingProgressBar.setVisibility(View.INVISIBLE);
    }

    private void refreshAction(){
        hideViews();
        new BoredApiClient().getBoredAction(new IBoredApiClient.BoredActionCallBack() {
            @Override
            public void onSuccess(BoredAction action) {
                task.setText(action.getActivity());
                category.setText(action.getType().toString());
                price.setText(action.getPrice().toString());
                //accessibility.setText(action.getAccessibility().toString());
                //participants.setText(action.getParticipants().toString());
                showViews();
            }

            @Override
            public void onFailure(Exception e) {
                Log.e("-------------", "Failure " + e.getMessage());
            }
        });
    }
}
