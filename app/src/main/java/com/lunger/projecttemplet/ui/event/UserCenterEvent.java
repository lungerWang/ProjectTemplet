package com.lunger.projecttemplet.ui.event;

/**
 *  Created by Lunger on 2017/6/14.
 */
public class UserCenterEvent extends BaseEvent {

    public static final int LOG_IN = 1; //用户登录
    public static final int LOG_OUT = 2; //用户登出

    public static UserCenterEvent getInstance(int id){
        UserCenterEvent event = new UserCenterEvent();
        event.setEventId(id);
        return event;
    }

}
