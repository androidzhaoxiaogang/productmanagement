package xg.productmanagement;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button btnAppOpenApp;
	private Button btnMsgOpenApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setipViews();
	}

	private void setipViews() {
		btnAppOpenApp = (Button) findViewById(R.id.app_open_app);
		btnMsgOpenApp = (Button) findViewById(R.id.msg_open_app);
		
		
		btnAppOpenApp.setOnClickListener(clicker);
		btnMsgOpenApp.setOnClickListener(clicker);
	}

	private OnClickListener clicker = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.app_open_app:
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("YYLC:init")));
				break;
			case R.id.wap_open_app:
				break;
			case R.id.msg_open_app:
				startActivity(new Intent(MainActivity.this, MessageActivity.class));
				break;
			case R.id.weibsite_filter:
				break;

			}

		}
	};

}
