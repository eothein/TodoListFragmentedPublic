package hogent.todolistfragmented;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hogent.todolistfragmented.utils.OnNewItemAddedListener;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class ButtonFragment extends Fragment {


    private OnNewItemAddedListener onNewItemAddedListener;
    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_button, container, false);

        try{
            onNewItemAddedListener = (OnNewItemAddedListener)getActivity();
        }catch(Exception e ){
            e.printStackTrace();
        }

        final Button okButton = (Button)view.findViewById(R.id.okButton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNewItemAddedListener.onNewItemAdded();
            }
        });
        return view;

    }




}
