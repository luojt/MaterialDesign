package com.yechaoa.materialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class ToolbarActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(view);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        //mToolbar.inflateMenu(R.menu.menu_toolbar);
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher_round);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //引入toolbar上的menu
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //toolbar上menu的事件处理
            case android.R.id.home:
                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_more1:
                Toast.makeText(this, "menu_more1", Toast.LENGTH_SHORT).show();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(this, "menu_more2", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }

}
