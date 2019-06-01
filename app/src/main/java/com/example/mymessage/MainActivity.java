package com.example.mymessage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private Button mBtnSend;
    private ArrayList<Msg> mMsgArrayList = new ArrayList<>();
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();
        mRecyclerView = findViewById(R.id.recycler_view);
        mEditText = findViewById(R.id.edit_message);
        mBtnSend = findViewById(R.id.btn_send);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerViewAdapter = new RecyclerViewAdapter( mMsgArrayList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mEditText.getText().toString();
                if(!TextUtils.isEmpty(content)){
                    Msg msg = new Msg(content ,0);
                    mMsgArrayList.add(msg);
                    mRecyclerViewAdapter.notifyItemInserted(mMsgArrayList.size() - 1);
                    mRecyclerView.scrollToPosition(mMsgArrayList.size() - 1);
                    mEditText.setText("");
                }
            }
        });
    }

    private void initMsgs() {
        for (int i = 0; i < 4; i++) {
            Msg msg = new Msg("你好吗",1);
            mMsgArrayList.add(msg);
            Msg ask = new Msg("我还行",0);
            mMsgArrayList.add(ask);
            Msg question = new Msg("你快乐吗",1);
            mMsgArrayList.add(question);
        }
    }
}
