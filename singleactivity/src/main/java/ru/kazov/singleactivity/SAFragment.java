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

import android.view.animation.Animation;
import androidx.annotation.AnimRes;
import androidx.fragment.app.Fragment;

public class SAFragment extends Fragment {
    public static boolean sDisableFragmentAnimations = false;
    protected SingleActivity activity;

    public SAFragment(){
        activity = (SingleActivity) getActivity();
    }

    /**
     * Add fragment to stack with specific <code>fragment</code> and default animation
     *
     * @param fragment A fragment to be pushed onto the stack.
     */
    public void addFragment(Fragment fragment) {
        ((SingleActivity) requireActivity()).addFragment(fragment, "", R.anim.slide_enter_from_right, R.anim.slide_exit_to_left, R.anim.slide_enter_from_left, R.anim.slide_exit_to_right);
    }

    /**
     * Add fragment to stack with specific <code>fragment</code> and <code>title</code> and default animation
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param title A title that shows at AppBar.
     */
    public void addFragment(Fragment fragment, String title) {
        ((SingleActivity) requireActivity()).addFragment(fragment, title, R.anim.slide_enter_from_right, R.anim.slide_exit_to_left, R.anim.slide_enter_from_left, R.anim.slide_exit_to_right);
    }

    /**
     * Add fragment to stack with specific <code>fragment</code> and custom animation
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. The <code>popEnter</code>
     * and <code>popExit</code> animations will be played for enter/exit
     * operations specifically when popping the back stack.
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param enter An animation or animator resource ID used for the enter animation on the
     *              view of the fragment being added or attached.
     * @param exit An animation or animator resource ID used for the exit animation on the
     *             view of the fragment being removed or detached.
     * @param popEnter An animation or animator resource ID used for the enter animation on the
     *                 view of the fragment being readded or reattached.
     * @param popExit An animation or animator resource ID used for the enter animation on the
     *                view of the fragment being removed or detached.
     */
    public void addFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        ((SingleActivity) requireActivity()).addFragment(fragment, "", enter, exit, popEnter, popExit);
    }

    /**
     * Add fragment to stack with specific <code>fragment</code> and <code>title</code> and custom animation
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. The <code>popEnter</code>
     * and <code>popExit</code> animations will be played for enter/exit
     * operations specifically when popping the back stack.
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param title A title that shows at AppBar.
     *
     * @param enter An animation or animator resource ID used for the enter animation on the
     *              view of the fragment being added or attached.
     * @param exit An animation or animator resource ID used for the exit animation on the
     *             view of the fragment being removed or detached.
     * @param popEnter An animation or animator resource ID used for the enter animation on the
     *                 view of the fragment being readded or reattached.
     * @param popExit An animation or animator resource ID used for the enter animation on the
     *                view of the fragment being removed or detached.
     */
    public void addFragment(Fragment fragment, String title, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        ((SingleActivity) requireActivity()).addFragment(fragment, title, enter, exit, popEnter, popExit);
    }

    /**
     * Add fragment to stack with specific <code>fragment</code> and <code>title</code> without animation
     *
     * @param fragment A fragment to be pushed onto the stack.
     */
    public void addFragmentNoAnimation(Fragment fragment) {
        ((SingleActivity) requireActivity()).addFragmentNoAnimation(fragment, "");
    }

    /**
     * Add fragment to stack with specific <code>fragment</code> and <code>title</code> without animation
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param title A title that shows at AppBar.
     */
    public void addFragmentNoAnimation(Fragment fragment, String title) {
        ((SingleActivity) requireActivity()).addFragmentNoAnimation(fragment, title);
    }

    /**
     * Empty stack and add fragment to stack with specific <code>fragment</code> and default animation
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. The <code>popEnter</code>
     * and <code>popExit</code> animations will be played for enter/exit
     * operations specifically when popping the back stack.
     *
     * @param fragment A fragment to be pushed onto the stack.
     */
    public void replaceFragment(Fragment fragment) {
        ((SingleActivity) requireActivity()).replaceFragment(fragment, "", R.anim.slide_enter_from_right, R.anim.slide_exit_to_left, R.anim.slide_enter_from_left, R.anim.slide_exit_to_right);
    }

    /**
     * Empty stack and add fragment to stack with specific <code>fragment</code> and <code>title</code> and default animation
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. The <code>popEnter</code>
     * and <code>popExit</code> animations will be played for enter/exit
     * operations specifically when popping the back stack.
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param title A title that shows at AppBar.
     */
    public void replaceFragment(Fragment fragment, String title) {
        ((SingleActivity) requireActivity()).replaceFragment(fragment, title, R.anim.slide_enter_from_right, R.anim.slide_exit_to_left, R.anim.slide_enter_from_left, R.anim.slide_exit_to_right);
    }

    /**
     * Empty stack and add fragment to stack with specific <code>fragment</code> and custom animation
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. The <code>popEnter</code>
     * and <code>popExit</code> animations will be played for enter/exit
     * operations specifically when popping the back stack.
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param enter An animation or animator resource ID used for the enter animation on the
     *              view of the fragment being added or attached.
     * @param exit An animation or animator resource ID used for the exit animation on the
     *             view of the fragment being removed or detached.
     * @param popEnter An animation or animator resource ID used for the enter animation on the
     *                 view of the fragment being readded or reattached.
     * @param popExit An animation or animator resource ID used for the enter animation on the
     *                view of the fragment being removed or detached.
     */
    public void replaceFragment(Fragment fragment, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        ((SingleActivity) requireActivity()).replaceFragment(fragment, "", enter, exit, popEnter, popExit);
    }

    /**
     * Empty stack and add fragment to stack with specific <code>fragment</code> and <code>title</code> and custom animation
     * Set specific animation resources to run for the fragments that are
     * entering and exiting in this transaction. The <code>popEnter</code>
     * and <code>popExit</code> animations will be played for enter/exit
     * operations specifically when popping the back stack.
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param title A title that shows at AppBar.
     *
     * @param enter An animation or animator resource ID used for the enter animation on the
     *              view of the fragment being added or attached.
     * @param exit An animation or animator resource ID used for the exit animation on the
     *             view of the fragment being removed or detached.
     * @param popEnter An animation or animator resource ID used for the enter animation on the
     *                 view of the fragment being readded or reattached.
     * @param popExit An animation or animator resource ID used for the enter animation on the
     *                view of the fragment being removed or detached.
     */
    public void replaceFragment(Fragment fragment, String title, @AnimRes int enter, @AnimRes int exit, @AnimRes int popEnter, @AnimRes int popExit) {
        ((SingleActivity) requireActivity()).replaceFragment(fragment, title, enter, exit, popEnter, popExit);
    }

    /**
     * Empty stack and add fragment to stack with specific <code>fragment</code> without animation
     *
     * @param fragment A fragment to be pushed onto the stack.
     */
    public void replaceFragmentNoAnimation(Fragment fragment) {
        ((SingleActivity) requireActivity()).replaceFragmentNoAnimation(fragment, "");
    }

    /**
     * Empty stack and add fragment to stack with specific <code>fragment</code> and <code>title</code> without animation
     *
     * @param fragment A fragment to be pushed onto the stack.
     *
     * @param title A title that shows at AppBar.
     */
    public void replaceFragmentNoAnimation(Fragment fragment, String title) {
        ((SingleActivity) requireActivity()).replaceFragmentNoAnimation(fragment, title);
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (SAFragment.sDisableFragmentAnimations) {
            Animation a = new Animation() {};
            a.setDuration(0);
            return a;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }
}
