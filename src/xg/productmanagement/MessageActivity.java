package xg.productmanagement;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.EditText;

public class MessageActivity extends Activity {
	private final static String TAG = "test";
	private EditText textMessage;
	private BroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_message);

		setupViews();
	}

	private void setupViews() {
		textMessage = (EditText) findViewById(R.id.text_verifier);

		receiver = new SMSBroadcastReceiver();
		IntentFilter filter = new IntentFilter();
		filter.setPriority(2147483647); // 权限设到最高
		filter.addAction("android.provider.Telephony.SMS_RECEIVED");// 短信的action
		registerReceiver(receiver, filter);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (null != receiver) {
			unregisterReceiver(receiver);
		}
	}

	public class SMSBroadcastReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Object[] pdus = (Object[]) intent.getExtras().get("pdus");
			for (Object pdu : pdus) {
				byte[] data = (byte[]) pdu;
				SmsMessage message = SmsMessage.createFromPdu(data);
				String sender = message.getOriginatingAddress();
				String content = message.getMessageBody();
				Log.i(TAG, "onReceive(), sender = " + sender + " : content = "
						+ content);
				if (null != content && content.contains("盈盈理财验证码为")) {
					String regNum = content.substring(content.indexOf("：") + 1,
							content.indexOf("（"));
					Log.i(TAG,
							"regNum = " + regNum + "; index = "
									+ content.indexOf("：") + 1);
					textMessage.requestFocus();
					textMessage.setText(regNum);
					textMessage.setSelection(textMessage.getText().length());
				}
			}
		}
	}

}
