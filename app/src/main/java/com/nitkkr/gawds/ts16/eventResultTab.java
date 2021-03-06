package com.nitkkr.gawds.ts16;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class eventResultTab extends Fragment
{
	eventData data;
	View view;

	public void setUpFragment(eventData event)
	{
		data=event;
		if(data==null)
			data=new eventData();
		eventUpdated();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		view= inflater.inflate(R.layout.fragment_event_result_tab, container, false);
		eventUpdated();
		return view;
	}

	public void eventUpdated()
	{
		if(view== null)
			return;

		if(!data.isResultDeclared())
		{
			(view.findViewById(R.id.NoResult)).setVisibility(View.VISIBLE);
		}
		else
		{
			view.findViewById(R.id.NoResult).setVisibility(View.INVISIBLE);

			((TextView)view.findViewById(R.id.resultView)).setText(Html.fromHtml(data.Result));

			Typeface font = Typeface.createFromAsset(getContext().getAssets(),
					"fonts/Font2.ttf");
				(( TextView)view.findViewById(R.id.resultView)).setTypeface(font);
		}
	}
}