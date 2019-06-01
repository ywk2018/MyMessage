package com.example.mymessage;

/**
 * class description:
 * author ywk
 * since 2019-06-01
 */
public class Msg {
    static final int MsgReceiver = 1;
    static final int Msgsend = 0;

    private String content;

    private int type;

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

}