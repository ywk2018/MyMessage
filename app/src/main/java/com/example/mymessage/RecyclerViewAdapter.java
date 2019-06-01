package com.example.mymessage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * class description:
 * author ywk
 * since 2019-06-01
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Msg> mMsgArrayList;
    public RecyclerViewAdapter(ArrayList<Msg> msgList) {
        mMsgArrayList = msgList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        Msg msg = mMsgArrayList.get(i);
        if(msg.getType() == msg.MsgReceiver){
            viewHolder.mLinearLayoutLeft.setVisibility(View.VISIBLE);
            viewHolder.mLinearLayoutRight.setVisibility(View.GONE);
            viewHolder.Msgleft.setText(msg.getContent());
        }else if(msg.getType() == msg.Msgsend){
            viewHolder.mLinearLayoutLeft.setVisibility(View.GONE);
            viewHolder.mLinearLayoutRight.setVisibility(View.VISIBLE);
            viewHolder.MsgRight.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgArrayList.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout mLinearLayoutLeft;
        LinearLayout mLinearLayoutRight;
        TextView Msgleft;
        TextView MsgRight;

        public ViewHolder(View view) {
            super(view);
            mLinearLayoutLeft = (LinearLayout) view.findViewById(R.id.msg_left);
            mLinearLayoutRight = (LinearLayout) view.findViewById(R.id.msg_right);
            Msgleft = (TextView) view.findViewById(R.id.tv_left_msg);
            MsgRight = (TextView) view.findViewById(R.id.tv_right_msg);
        }
    }
}