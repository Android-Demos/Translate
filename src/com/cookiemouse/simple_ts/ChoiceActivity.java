package com.cookiemouse.simple_ts;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ChoiceActivity extends Activity {

	private String languagereturn = "default", languageText = "default";
	private List<Language> languageList = new ArrayList<Language>();
	
	private String contryText[] = {"自动识别", "中文", "英语", "日语", "泰语", "俄语", "葡萄牙语", "德语", "韩语", "西班牙语", "法语", "阿拉拍语", "意大利语", "荷兰语", "希腊语"};
	private String contry[] = {"auto", "zh", "en", "jp", "th", "ru", "pt", "de", "kor", "spa", "fra", "ara", "it", "nl", "el"};
	//																1		2		3		4		5		6			7		8			9		10	 	11	12	13	14
	//韩国，西班牙，法国，阿拉拍，意大利，荷兰，西腊 没有语音
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		
		Intent intent = getIntent();
		languagereturn = intent.getStringExtra("LANGUAGE");
		languageText = intent.getStringExtra("LANGUAGE_TEXT");
		
		initLanguage();
		LanguageAdapter adapter = new LanguageAdapter(ChoiceActivity.this
				, R.layout.language_item, languageList);
		ListView listView = (ListView)findViewById(R.id.from_list);
		listView.setAdapter(adapter);
		
		//设置Item监听事件
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
//				Language language = languageList.get(position);
//				languagereturn = language.getName();
				languagereturn = contry[position];
				languageText = contryText[position];
				
				//调用返回函数，并关闭当前Activity
				activityfinish();
			}
		});
	}
	
	@Override
	public void onBackPressed() {
		activityfinish();
	}

	private void activityfinish()
	{
		Intent intent = new Intent();
		intent.putExtra("LANGUAGE", languagereturn);
		intent.putExtra("LANGUAGE_TEXT", languageText);
		this.setResult(0, intent);
		this.finish();
	}
	
	private void initLanguage()
	{
		//自动识别
		Language auto = new Language(R.drawable.ic_launcher, "自动识别");
		languageList.add(auto);

		//中文
		Language china = new Language(R.drawable.china, "中文");
		languageList.add(china);

		//英文
		Language english = new Language(R.drawable.en, "英文");
		languageList.add(english);

		//日语
		Language japen = new Language(R.drawable.japen, "日语");
		languageList.add(japen);

		//泰语
		Language tailand = new Language(R.drawable.tailand, "泰语");
		languageList.add(tailand);

		//俄语
		Language russia = new Language(R.drawable.russia, "俄语");
		languageList.add(russia);

		//葡萄牙语
		Language pt = new Language(R.drawable.portugal, "葡萄牙语");
		languageList.add(pt);

		//德语
		Language de = new Language(R.drawable.de, "德语");
		languageList.add(de);

		//韩语
		Language kro = new Language(R.drawable.kor, "韩语(无语音)");
		languageList.add(kro);
		//西班牙语
		Language sp = new Language(R.drawable.span, "西班牙语(无语音)");
		languageList.add(sp);
		//法语
		Language fra = new Language(R.drawable.franch, "法语(无语音)");
		languageList.add(fra);
		//阿拉拍语
		Language ara = new Language(R.drawable.alabo, "阿拉拍语(无语音)");
		languageList.add(ara);
		//意大利语
		Language it = new Language(R.drawable.itali, "意大利语(无语音)");
		languageList.add(it);
		//荷兰语
		Language nl = new Language(R.drawable.holland, "荷兰语(无语音)");
		languageList.add(nl);

		//希腊语
		Language el = new Language(R.drawable.greece, "希腊语(无语音)");
		languageList.add(el);
	}
}
