package com.sobot.sdk.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.lidroid.xutils.util.LogUtils;
import com.sobot.chat.activity.SobotLoadingActivity;
import com.sobot.chat.model.Information;

public class DemoActivity extends Activity {

	private EditText sysNum, uid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
		LogUtils.allowI = true;
		sysNum = (EditText) findViewById(R.id.sysNumET);
		uid = (EditText) findViewById(R.id.userIDET);

		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(DemoActivity.this,
						SobotLoadingActivity.class);

				Information info = new Information();
				info.setAppKey(sysNum.getText().toString());/* 必填 */
				LogUtils.i(sysNum.getText().toString());
				/*
				 * info.setColor("") 设置气泡主题颜色，默认颜色为 #09aeb0
				 * 修改气泡的颜色，可以替换资源文件，资源文件在drawable-xhdpi文件夹下，
				 * 机器人信息的背景图片为chatfrom_bg_normal.9.png 我的信息的背景图片有以下两张
				 * chatto_bg_normal.9.png/chatto1_bg_normal.9.png
				 */
				info.setColor("");/* 选填 */
				/* info.setUid("") 设置用户唯一标识， */
				info.setUid(uid.getText().toString());
				info.setNickName("");/* 用户昵称，选填 */
				info.setPhone("");/* 用户电话，选填 */
				info.setEmail("");/* 用户邮箱，选填 */
				Bundle bundle = new Bundle();
				bundle.putSerializable("info", info);
				intent.putExtra("bundle", bundle);
				startActivity(intent);
			}
		});
	}
}