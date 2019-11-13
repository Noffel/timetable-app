package com.example.noffel.timetable;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Monday extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{
    Cursor mCursor;
    final int LOADER_CODE = 1;
    View view = null,v;
    ListView list = null;
    String sqlArray[];
    String tSQL[];
    MyAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.monday_layout,container,false);
        list = (ListView) view.findViewById(R.id.list_view);
        registerForContextMenu(list);
        sqlArray = getResources().getStringArray(R.array.TimeSQL);
        getActivity().getSupportLoaderManager().initLoader(LOADER_CODE,null,this);
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                v = view;
                Intent intent = new Intent(MainActivity.getContext(),EditorActivity.class);
                intent.putExtra("subject",((TextView)view.findViewById(R.id.subject)).getText().toString());
                intent.putExtra("room",((TextView)view.findViewById(R.id.room)).getText().toString());
                intent.putExtra("position",position);
                startActivity(intent);
                return true;
            }
        });
        setView(mCursor);
        return view;
    }


    public void setView(Cursor cursor){
        tSQL = MainActivity.getContext().getResources().getStringArray(R.array.TimeSQL);

        if( cursor !=  null  && cursor.moveToFirst() ) {
            adapter  = new MyAdapter(MainActivity.getContext(),cursor,tSQL);
            list.setAdapter(adapter);
        }

    }
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String selectQuery = "SELECT  * FROM " + Contract.Entry.TABLE_NAME + " WHERE "
                + Contract.Entry.COLUMN_DAY + " = " + "\"monday\"";
        Log.e("MONonCreate",""+mCursor);

        Helper helper = (new Helper(MainActivity.getContext()));
        try {
            mCursor = helper.getReadableDatabase().rawQuery(selectQuery, null);
        }catch (SQLiteException e){

        }

                return new CursorLoader(getContext(),Contract.Entry.CONTENT_URI,
                null,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
      //  Toast.makeText(getContext(),"onLoadfinish",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
      //  Toast.makeText(MainActivity.getContext(),"onloaderreset",Toast.LENGTH_SHORT).show();
    }

}
