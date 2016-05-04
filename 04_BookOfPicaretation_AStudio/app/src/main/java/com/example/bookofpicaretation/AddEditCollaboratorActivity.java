package com.example.bookofpicaretation;

import com.example.bookofpicaretation.dao.CollaboratorDAO;
import com.example.bookofpicaretation.entity.Collaborator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddEditCollaboratorActivity extends Activity {
	
	EditText nameET, phoneET, emailET;
	TextView titleTV;
	Button addButton;
	CollaboratorDAO cDao;
	long editId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_collaborator);
		
		nameET = (EditText) findViewById(R.id.issueNameEditText);
		phoneET = (EditText) findViewById(R.id.phoneEditText);
		emailET = (EditText) findViewById(R.id.emailEditText);
		titleTV = (TextView) findViewById(R.id.titleTextView);
		addButton = (Button) findViewById(R.id.addButton);
		addButton.setOnClickListener(addButtonClickListener);
		
		cDao = new CollaboratorDAO(this);
		
		editId = getIntent().getLongExtra("editId", 0);
		if(editId != 0) {
			Collaborator c = cDao.getById(editId);
			nameET.setText( c.getName() );
			phoneET.setText( c.getPhone() );
			emailET.setText( c.getEmail() );
			addButton.setText(R.string.lbl_edit);
			titleTV.setText(R.string.lbl_edit_collaborator);
		}
		else {
			addButton.setText(R.string.lbl_add_collaborator);
			titleTV.setText(R.string.lbl_add_collaborator);
		}
	}
	
	private OnClickListener addButtonClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String tName = nameET.getText().toString();
			String tPhone = phoneET.getText().toString();
			String tEmail = emailET.getText().toString();

			Collaborator newCollaborator = new Collaborator();
			newCollaborator.setName(tName);
			newCollaborator.setPhone(tPhone);
			newCollaborator.setEmail(tEmail);
			
			if(editId == 0) {
				cDao.save(newCollaborator);
			}
			else {
				newCollaborator.setId(editId);
				cDao.update(newCollaborator);
			}
			//close current activity and send msg to update
			Intent i = new Intent();
			setResult(RESULT_OK, i);
			AddEditCollaboratorActivity.this.finish();
		}
	};
	
	protected void onDestroy() { 
		super.onDestroy();
		cDao.close();
	}
}
