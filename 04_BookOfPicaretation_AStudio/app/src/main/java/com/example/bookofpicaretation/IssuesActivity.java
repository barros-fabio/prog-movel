package com.example.bookofpicaretation;

import java.util.List;

import com.example.bookofpicaretation.dao.CollaboratorDAO;
import com.example.bookofpicaretation.dao.IssueDAO;
import com.example.bookofpicaretation.entity.Collaborator;
import com.example.bookofpicaretation.entity.Issue;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class IssuesActivity extends ActionBarActivity {
	long collaboratorId;
	TextView infoTV, summaryTV;
	ListView issuesListView;
	Button backButton, addIssueButton, showClosedButton;
	CollaboratorDAO cDao;
	IssueDAO issueDao;
	Collaborator collaborator;
	List<Issue> issues;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_issues);
		
		infoTV = (TextView) findViewById(R.id.infoTextView);
		summaryTV = (TextView) findViewById(R.id.summaryTextView);
		issuesListView = (ListView) findViewById(R.id.issuesListView);
		
		addIssueButton = (Button) findViewById(R.id.addIssueButton);
		addIssueButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				openIssueAdd();
			}
		});
		showClosedButton = (Button) findViewById(R.id.showClosedButton);
		backButton = (Button) findViewById(R.id.backButton);
		backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				back();
			}
		});
		
		collaboratorId = getIntent().getLongExtra("collaboratorId", 0);
		
		cDao = new CollaboratorDAO(this);
		issueDao = new IssueDAO(this);
		
		collaborator = cDao.getById(collaboratorId);
		setTitle(collaborator.getName());
		infoTV.setText(collaborator.getPhone() + " -- " + collaborator.getEmail());	
		
		updateUI();
	}

	public void updateUI() {
		issues = issueDao.getBy(collaborator);
		
		summaryTV.setText( issueDao.calculateSummary(issues) );
		ArrayAdapter<Issue> issueAdapter = new ArrayAdapter<Issue>(this, android.R.layout.simple_list_item_1, issues);
		issuesListView.setAdapter(issueAdapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.issues, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch(id) {
			case R.id.backItem:
				back();
				return true;
			case R.id.addItem:
				openIssueAdd();
				return true;
			case R.id.showClosedItem:
				return true;
				
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void back() {
		this.finish();
	}
	
	public void openIssueAdd() {
		Intent i = new Intent(this, AddEditIssueActivity.class);
		i.putExtra("collaborator", collaborator);
		startActivityForResult(i, 29);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		cDao.close();
		issueDao.close();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent i) {
		if(requestCode == 29 && resultCode == RESULT_OK) {
			updateUI();
		}
	}
}
