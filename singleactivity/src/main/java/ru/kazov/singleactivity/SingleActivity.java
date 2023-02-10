/*
 * Designed and developed by 2017 Roman Kazov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.kazov.singleactivity;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.AnimRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayDeque;

public class SingleActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private int container = 0;
    protected FragmentManager fragmentManager;
    private ArrayDeque<String> titles = null;
    protected int getContainer() {
        return container;
    }
    protected void setContainer(int container) {
        this.container = container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titles = new ArrayDeque<>();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.addOnBackStackChangedListener(this);
    }

    public void addFragment(Fragment fragment, String title, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        titles.push(title);

        fragmentManager.beginTransaction()
                .setCustomAnimations(enter, exit, popEnter, popExit)
                .replace(container, fragment)
                .addToBackStack(null)
                .commit();

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(titles.peek());
    }

    public void addFragmentNoAnimation(Fragment fragment, String title) {
        titles.push(title);

        fragmentManager.beginTransaction()
                .replace(container, fragment)
                .addToBackStack(null)
                .commit();

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(titles.peek());
    }

    public void replaceFragment(Fragment fragment, String title, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        titles.clear();
        titles.push(title);

        clearFragments();
        fragmentManager.beginTransaction()
                .setCustomAnimations(enter,exit,popEnter,popExit)
                .replace(container, fragment)
                .addToBackStack(null)
                .commit();

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(titles.peek());
    }

    public void replaceFragmentNoAnimation(Fragment fragment, String title) {
        titles.clear();
        titles.push(title);

        clearFragments();
        fragmentManager.beginTransaction()
                .replace(container, fragment)
                .addToBackStack(null)
                .commit();

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(titles.peek());
    }

    private void clearFragments() {
        SAFragment.sDisableFragmentAnimations = true;
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        SAFragment.sDisableFragmentAnimations = false;
    }

    private void getBack() {
        titles.pop();

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(titles.peek());

        fragmentManager.popBackStack();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getBack();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            getBack();
        } else
            this.finish();
    }

    @Override
    public void onBackStackChanged() {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            if (getSupportActionBar() != null)
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }
}
