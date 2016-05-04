package com.example.bookofpicaretation;

import java.util.List;

import com.example.bookofpicaretation.dao.CollaboratorDAO;
import com.example.bookofpicaretation.entity.Collaborator;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemLongClickListener;

public class MainActivity extends ActionBarActivity {
	
	ListView collaboratorsLV;
	List<Collaborator> collaboratorsList;
	ArrayAdapter<Collaborator> collaboratorAdapter;
	CollaboratorDAO cDao;
	int currentPosition;
	private ActionMode currentActionMode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		cDao = new CollaboratorDAO(this);
		
		collaboratorsLV = (ListView) findViewById(R.id.collaboratorsListView);
		collaboratorsLV.setOnItemLongClickListener(onItemLongClickListener);
		collaboratorsLV.setOnItemClickListener(onItemClickListener);
		fillListViewWithCollaborators();
		
	}

	private OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if(currentActionMode != null) {
				currentActionMode.finish();
				currentActionMode = null;
			}
			Intent i = new Intent(MainActivity.this, IssuesActivity.class);
			i.putExtra("collaboratorId", collaboratorsList.get(position).getId());
			startActivityForResult(i, 21);
		}
	};
	
	private OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,int position, long id) {
			if (currentActionMode != null)
				return false;

			currentPosition = position;	//armazena o item atualmente selecionado
			currentActionMode = startActionMode(modeCallBack);
			view.setSelected(true);
			return false;
		}
		
	};
	
	private ActionMode.Callback modeCallBack = new ActionMode.Callback() {
		
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			mode.setTitle("Actions");
			mode.getMenuInflater().inflate(R.menu.collaborator_context_menu, menu);
			return true;
		}
		
		// chamado quando o usuario seleciona um item do contextual menu
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			switch(item.getItemId()) {
			case R.id.editItem:
				//start in edit mode
				Intent i = new Intent(MainActivity.this, AddEditCollaboratorActivity.class);
				i.putExtra("editId", collaboratorsList.get(currentPosition).getId() );
				startActivityForResult(i, 22);
				mode.finish();	//encerra o action mode
				return true;
				
			case R.id.deleteItem:
				cDao.delete( collaboratorsList.get(currentPosition) );
				fillListViewWithCollaborators();
				mode.finish();	//encerra o action mode
				return true;
			}	
			return false;
		}

		//chamado to vez que o action mode eh apresentado
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false;
		}

		//chamado quando o usuario sai do action mode
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			currentActionMode = null; //limpa o current mode atual
		}
	};	
	
	private void fillListViewWithCollaborators() {
		collaboratorsList = cDao.getAll();
		
		collaboratorAdapter = new ArrayAdapter<Collaborator>(MainActivity.this, android.R.layout.simple_list_item_1, collaboratorsList);
		collaboratorsLV.setAdapter(collaboratorAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch(id) {
			case(R.id.newCollaboratorItem):
				Intent i = new Intent(this, AddEditCollaboratorActivity.class);
				startActivityForResult(i, 22);				
				return true;
			case(R.id.viewGroupsItem):
				return true;
			case(R.id.exitItem):
				MainActivity.this.finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == 22 && resultCode == RESULT_OK) {
			//update view 
			//retrieve all collaborators and update list view
			fillListViewWithCollaborators();
		}
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		cDao.close();
	}
}
