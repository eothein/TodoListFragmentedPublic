package hogent.todolistfragmented;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;

import hogent.todolistfragmented.utils.OnNewItemAddedListener;
import hogent.todolistfragmented.utils.ToDoItem;
import hogent.todolistfragmented.utils.ToDoItemAdapter;

public class ToDoList extends Activity implements OnNewItemAddedListener {


    private ToDoItemAdapter aa;
    private ArrayList<ToDoItem> todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list_fragment);

        FragmentManager fm = getFragmentManager();
        ItemFragment toDoListFragment = (ItemFragment)fm.findFragmentById(R.id.ToDoListFragment);

        todoItems= new ArrayList<ToDoItem>();
        aa=new ToDoItemAdapter(this,R.layout.todolist_item,todoItems);

        toDoListFragment.setListAdapter(aa);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNewItemAdded() {
        final EditText editText = (EditText)this.findViewById(R.id.myEditText);
        String newItem = (String)editText.getText().toString();
        editText.setText("");
        ToDoItem newTodoItem = new ToDoItem(newItem);
        todoItems.add(newTodoItem);
        aa.notifyDataSetChanged();
    }

    public void onCancel(){
        final EditText editText = (EditText)this.findViewById(R.id.myEditText);
        editText.setText("");
    }
}

