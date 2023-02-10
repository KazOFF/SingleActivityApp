
# Single Activity App

This is a small lib, that helps you to use single activity with fragment manager.

# Features:

* Single activity
* Custom animations
* Can clear fragment stack

# Methods

```
 public void addFragment(Fragment fragment) - Add fragment with default animation
 public void addFragment(Fragment fragment, String title) - Add fragment with title in AppBar and default animation
 public void addFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) - Add fragment with custom animation
 public void addFragment(Fragment fragment, String title, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) - Add fragment with title and custom animation
 
 public void addFragmentNoAnimation(Fragment fragment) - Add fragment without animation
 public void addFragmentNoAnimation(Fragment fragment, String title) - Add fragment with title and without animation
 
 public void replaceFragment(Fragment fragment) - Clear stack and add fragment with default animation
 public void replaceFragment(Fragment fragment, String title) - Clear stack and add fragment with title and default animation
 public void replaceFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) - Clear stack and add fragment with custom animation
 public void replaceFragment(Fragment fragment, String title, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) - Clear stack and add fragment with title and custom animation
 
 public void replaceFragmentNoAnimation(Fragment fragment) - Clear stack and add fragment without animation
 public void replaceFragmentNoAnimation(Fragment fragment, String title) - Clear stack and add fragment with title and without animation
```


# Usage

1. Create layout activity_main.xml with container 

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:background="?attr/colorPrimary"
        android:minHeight="?attr/actionBarSize"
        android:theme="?attr/actionBarTheme"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <FrameLayout
        android:id="@+id/container"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/toolbar"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

2. Extend MainActivity with SingleActivity class. Set fragments container. Add first fragment to stack.

```java
public class MainActivity extends SingleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        setContainer(R.id.container);
        addFragmentNoAnimation(new MainFragment(), "");
    }
}
```

3. Extend fragments with SAFragment class.

```java
public class MainFragment extends SAFragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }
}
```

For more information run example app


## License

Copyright 2018 Roman Kazov\
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.