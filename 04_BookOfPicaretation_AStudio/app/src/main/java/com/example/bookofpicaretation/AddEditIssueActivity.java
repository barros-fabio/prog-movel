package com.example.bookofpicaretation;

import com.example.bookofpicaretation.dao.IssueDAO;
import com.example.bookofpicaretation.entity.Collaborator;
import com.example.bookofpicaretation.entity.Issue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class AddEditIssueActivity extends Activity {
	TextView nameTV;
	EditText issueNameET, issueDescET, issueValueET;
	RadioButton noMoneyRadio, topayRadio, toreceiveRadio;
	Button addButton;
	Collaborator collaborator;
	IssueDAO issueDao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_edit_issue);
		
		collaborator = (Collaborator) getIntent().getSerializableExtra("collaborator");
		nameTV = (TextView) findViewById(R.id.collaboratorNameTextView);
		nameTV.setText(collaborator.getName());
		
		issueNameET = (EditText) findViewById(R.id.issueNameEditText);
		issueDescET = (EditText) findViewById(R.id.issueDescEditText);
		issueValueET = (EditText) findViewById(R.id.issueValueEditText);
		noMoneyRadio = (RadioButton) findViewById(R.id.noMoneyRadio);
		topayRadio = (RadioButton) findViewById(R.id.toPayRadio);
		toreceiveRadio = (RadioButton) findViewById(R.id.toReceiveRadio);
		
		addButton = (Button) findViewById(R.id.issueSaveButton);
		addButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				saveIssue();
			}
		});
		
		issueDao = new IssueDAO(this);
	}
	
	private void saveIssue() {
		String tName = issueNameET.getText().toString();
		String tDesc = issueDescET.getText().toString();
		String tValue = issueValueET.getText().toString();
		double value = 0;
		if(! tValue.equals("")) {
			value = Double.valueOf(tValue);
		}
		long tType = 0;
		if(topayRadio.isChecked())
			tType = 1;
		if(toreceiveRadio.isChecked())
			tType = 2;
		
		Issue issue = new Issue();
		issue.setName(tName);
		issue.setDescription(tDesc);
		issue.setValue(value);
		issue.setClosed(false);
		issue.setType(tType);
		issue.setCollaborator(collaborator);
		
		issueDao.save(issue);
		setResult(RESULT_OK);
		this.finish();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		issueDao.close();
	}	
}
