package hersh.khan.shaalan.timemanager;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class TodoFragment extends Fragment {

	private ArrayList<String> items;
	private ArrayAdapter<String> itemsAdapter;
	private ListView lvItems;
	View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = inflater.inflate(R.layout.todo_fragment, container, false);
		// ADD HERE
		lvItems = (ListView) view.findViewById(R.id.lvItems);
		items = new ArrayList<String>();

		itemsAdapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, items);
		lvItems.setAdapter(itemsAdapter);
		setupListViewListener();
		
		Button add = (Button) view.findViewById(R.id.btnAddItem);
		
		add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {  //green
                onAddItem(view);
            }
        });

		
		return view;
	}

	// Attaches a long click listener to the listview
	private void setupListViewListener() {
		lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View item,
					int pos, long id) {
				items.remove(pos);
				itemsAdapter.notifyDataSetChanged();

				return true;
			}

		});
	}

	public void onAddItem(View v) {
		EditText etNewItem = (EditText) view.findViewById(R.id.etNewItem);
		String itemText = etNewItem.getText().toString();
		itemsAdapter.add(itemText);
		etNewItem.setText("");

	}

}
