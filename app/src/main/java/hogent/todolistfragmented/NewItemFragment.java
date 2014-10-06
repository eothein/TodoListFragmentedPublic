package hogent.todolistfragmented;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import hogent.todolistfragmented.utils.OnNewItemAddedListener;


public class NewItemFragment extends Fragment {


    private OnNewItemAddedListener onNewItemAddedListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_item_fragment,container,false);

        //Hier komt de code om te luisteren naar de EditText
        final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);
        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    if((i == KeyEvent.KEYCODE_DPAD_CENTER) || (i == KeyEvent.KEYCODE_ENTER)){
                        onNewItemAddedListener.onNewItemAdded();
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            onNewItemAddedListener = (OnNewItemAddedListener)activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnNewItemAddedListener");
        }
    }


}
