package xg.productmanagement;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity {
	private Button btnOpenApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setipViews();
	}

	private void setipViews() {
		btnOpenApp = (Button) findViewById(R.id.app_open_app);
		
		
		btnOpenApp.setOnClickListener(clicker);
	}

	private OnClickListener clicker = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.app_open_app:
				break;
			case R.id.wap_open_app:
				break;
			case R.id.msg_open_app:
				break;
			case R.id.weibsite_filter:
				break;

			}

		}
	};

}
