package com.lunger.projecttemplet.ui.event;

/**
 * Created by Lunger on 2017/06/14.
 * EventBus event基类
 */

public class BaseEvent {
    private int eventId;
    private Object data;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
