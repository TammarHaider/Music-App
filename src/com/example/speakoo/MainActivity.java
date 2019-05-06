package com.example.speakoo;

import java.util.ArrayList;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView txvResult;
	TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t=(TextView)findViewById(R.id.textView1);
		txvResult = (TextView)findViewById(R.id.txvResult);
	}
 
	public void getSpeechInput(View view)
	{
		Intent intent  = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.CHINESE);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.GERMAN);
		if(intent.resolveActivity(getPackageManager())!=null)
		{
			startActivityForResult(intent, 10);
		}
		else
		{
			Toast.makeText(getApplicationContext(), "Your Device Dont Dupport Speech  Input", Toast.LENGTH_SHORT).show();
		}
		
	}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	switch(requestCode)
	{
	case 10:
		if(requestCode == RESULT_OK && data!=null){
		ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			txvResult.setText(result.get(0));
		}
		break;
	}
}
}

