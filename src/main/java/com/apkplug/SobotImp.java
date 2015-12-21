package com.apkplug;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.apkplug.component.sobotsdk.Sobot;
import com.sobot.chat.activity.SobotLoadingActivity;
import com.sobot.chat.model.Information;

public class SobotImp extends Sobot {
    
    private Context mContext=null;

    public SobotImp(Context context) {
        mContext=context;
    }


    @Override
    public int versionInPlug() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public void start() {
        Intent intent = new Intent(mContext,
                SobotLoadingActivity.class);
        Information info = new Information();
        info.setAppKey("d20640c734f0457ab5de1de9f519caf8");/* 必填 */
        info.setColor("");/* 选填 */
				/* info.setUid("") 设置用户唯一标识， */
        info.setUid("test");
        info.setNickName("");/* 用户昵称，选填 */
        info.setPhone("");/* 用户电话，选填 */
        info.setEmail("");/* 用户邮箱，选填 */
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", info);
        intent.putExtra("bundle", bundle);
        mContext.startActivity(intent);

    }
}